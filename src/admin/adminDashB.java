/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import careq.*;
import config.connectDB;
import gfx.RoundedPanel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Administrator
 */
public class adminDashB extends javax.swing.JFrame {

    Color mainColor = new Color(37, 171, 241);
    Color hoverColor = new Color(31, 128, 179);

    Color logoutColor = new Color(100, 188, 234);
    Color hoverlogoutColor = new Color(250, 249, 246);

    public adminDashB() {
        initComponents();
        loadOpenSans();
        loadItim();
        displayData();
//        loadTableData();
        getTotalAcc();
        getPatientCount();
        getDoctorCount();
        getActiveAccCount();
        getPendingAccCount();

    }

    public void displayData() {
        try {
            connectDB con = new connectDB();
            ResultSet rs = con.getData("SELECT u_id, u_fname, u_lname, u_email, u_pnum, type, status FROM user");
            DefaultTableModel model = (DefaultTableModel) (DbUtils.resultSetToTableModel(rs));
            rs.close();

            String[] column = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Account Type", "Account Status"};
            model.setColumnIdentifiers(column);

            usersTable.setModel(model);

            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());

                    label.setFont(new Font("OpenSans", Font.BOLD, 12));
                    label.setPreferredSize(new Dimension(label.getWidth(), 30));
                    label.setOpaque(true);
                    label.setBackground(new Color(250, 249, 246));

                    label.setForeground(Color.BLACK);
                    label.setHorizontalAlignment(SwingConstants.LEFT);

                    return label;
                }
            };

// Apply custom header renderer to all columns
            for (int i = 0; i < usersTable.getColumnModel().getColumnCount(); i++) {
                usersTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }
            
            DefaultTableCellRenderer alternatingRowRenderer = new DefaultTableCellRenderer() {
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        
        // Set alternating row colors
        if (row % 2 == 0) {
            cell.setBackground(new Color(240, 240, 240)); // Light gray for even rows
        } else {
            cell.setBackground(new Color(250, 249, 246)); // White for odd rows
        }
        
        // Highlight selected row
        if (isSelected) {
            cell.setBackground(new Color(37,171,241)); // Light blue selection color
        }

        return cell;
    }
};

// Apply the custom renderer to all columns
for (int i = 0; i < usersTable.getColumnCount(); i++) {
    usersTable.getColumnModel().getColumn(i).setCellRenderer(alternatingRowRenderer);
}

        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());

        }

    }

//    public void loadTableData() {
//    DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
//    model.setRowCount(0); // Clear existing data
//
//    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/careq", "root", "");
//         Statement stmt = conn.createStatement();
//         ResultSet rs = stmt.executeQuery("SELECT u_id, u_fname, u_lname, u_email, u_pnum, type, status FROM user")) {
//
//        ResultSetMetaData metaData = rs.getMetaData();
//        int columnCount = metaData.getColumnCount();
//        
//        String[] columnNames = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Account Type", "Account Status"}; 
//        model.setColumnIdentifiers(columnNames);
//
//        // Add columns dynamically if not set in GUI
//        if (model.getColumnCount() == 0) {
//            for (int i = 1; i <= columnCount; i++) {
//                model.addColumn(metaData.getColumnName(i));
//            }
//        }
//
//        // Populate rows
//        while (rs.next()) {
//            Object[] row = new Object[columnCount];
//            for (int i = 1; i <= columnCount; i++) {
//                row[i - 1] = rs.getObject(i);
//            }
//            model.addRow(row);
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(null, "Database Error: " + e.getMessage());
//    }
//}
    public void getTotalAcc() {

        connectDB con = new connectDB();

        try {

            ResultSet rs = con.getData("SELECT COUNT(*) FROM user");
            if (rs.next()) {
                int count = rs.getInt(1);
                TA.setText(String.valueOf(count));
            }

        } catch (SQLException ex) {
            System.out.println("" + ex);

        }

    }

    public void getPatientCount() {

        connectDB con = new connectDB();

        try {

            ResultSet rs = con.getData("SELECT COUNT(*) FROM user WHERE type = 'Patient'");
            if (rs.next()) {
                int count = rs.getInt(1);

                P.setText(String.valueOf(count));
            }

        } catch (SQLException ex) {
            System.out.println("" + ex);

        }

    }

    public void getDoctorCount() {

        connectDB con = new connectDB();

        try {

            ResultSet rs = con.getData("SELECT COUNT(*) FROM user WHERE type = 'Doctor'");
            if (rs.next()) {
                int count = rs.getInt(1);
                D.setText(String.valueOf(count));
            }

        } catch (SQLException ex) {
            System.out.println("" + ex);

        }

    }

    public void getActiveAccCount() {

        connectDB con = new connectDB();

        try {

            ResultSet rs = con.getData("SELECT COUNT(*) FROM user WHERE status = 'Active'");
            if (rs.next()) {
                int count = rs.getInt(1);
                AA.setText(String.valueOf(count));
            }

        } catch (SQLException ex) {
            System.out.println("" + ex);

        }

    }

    public void getPendingAccCount() {

        connectDB con = new connectDB();

        try {

            ResultSet rs = con.getData("SELECT COUNT(*) FROM user WHERE status = 'Pending'");
            if (rs.next()) {
                int count = rs.getInt(1);
                PA.setText(String.valueOf(count));
            }

        } catch (SQLException ex) {
            System.out.println("" + ex);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainbg = new javax.swing.JPanel();
        jPanel1 = new RoundedPanel(5);
        accountPanel = new RoundedPanel(50);
        jPanel2 = new RoundedPanel(50);
        dashboardPanel = new RoundedPanel(50);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logoutPanel = new RoundedPanel(25);
        jLabel6 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        dboard = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dboardBG = new RoundedPanel(15);
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        accOV = new javax.swing.JLabel();
        jPanel4 = new RoundedPanel(15);
        P = new javax.swing.JLabel();
        patient = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new RoundedPanel(15);
        jLabel13 = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        doctor = new javax.swing.JLabel();
        jPanel6 = new RoundedPanel(15);
        jLabel14 = new javax.swing.JLabel();
        actAcc = new javax.swing.JLabel();
        AA = new javax.swing.JLabel();
        jPanel7 = new RoundedPanel(15);
        PA = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        penAcc = new javax.swing.JLabel();
        jPanel8 = new RoundedPanel(15);
        totalAcc = new javax.swing.JLabel();
        TA = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainbg.setBackground(new java.awt.Color(245, 245, 245));
        mainbg.setMinimumSize(new java.awt.Dimension(1017, 620));
        mainbg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(37, 171, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        accountPanel.setBackground(new java.awt.Color(37, 171, 241));
        accountPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accountPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accountPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accountPanelMouseExited(evt);
            }
        });
        accountPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(accountPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 190, 50));

        jPanel2.setBackground(new java.awt.Color(37, 171, 241));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel2MouseExited(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 190, 50));

        dashboardPanel.setBackground(new java.awt.Color(37, 171, 241));
        dashboardPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseExited(evt);
            }
        });
        dashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard.png"))); // NOI18N
        dashboardPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        jLabel2.setForeground(new java.awt.Color(250, 249, 246));
        jLabel2.setText("Dashboard");
        dashboardPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 30));

        jPanel1.add(dashboardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 190, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-stethoscope-48.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel4.setForeground(new java.awt.Color(250, 249, 246));
        jLabel4.setText("CareQ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 100, 30));

        logoutPanel.setBackground(new java.awt.Color(100, 188, 234));
        logoutPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutPanelMouseExited(evt);
            }
        });
        logoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
        logoutPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 30, 50));

        logout.setBackground(new java.awt.Color(73, 138, 172));
        logout.setForeground(new java.awt.Color(73, 138, 172));
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutPanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jPanel1.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 170, 70));

        mainbg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 700));

        dboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(250, 249, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Admin Dashboard");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        dboard.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 70));

        dboardBG.setBackground(new java.awt.Color(250, 249, 246));
        dboardBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersTable.getTableHeader().setOpaque(false);
        usersTable.setBackground(new java.awt.Color(250, 249, 246));
        usersTable.setOpaque(false);
        usersTable.setRowHeight(25);
        usersTable.setRowMargin(0);
        usersTable.setShowHorizontalLines(false);
        usersTable.setShowVerticalLines(false);
        jScrollPane1.setViewportView(usersTable);

        dboardBG.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 830, 260));

        accOV.setText("Accounts Overview");
        dboardBG.add(accOV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        dboard.add(dboardBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 870, 330));

        jPanel4.setBackground(new java.awt.Color(250, 249, 246));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setLayout(null);
        jPanel4.add(P);
        P.setBounds(20, 50, 30, 40);

        patient.setText("Patients");
        patient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(patient);
        patient.setBounds(10, 20, 90, 14);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/patient.png"))); // NOI18N
        jPanel4.add(jLabel11);
        jLabel11.setBounds(200, 40, 40, 40);

        dboard.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 270, 110));

        jPanel5.setBackground(new java.awt.Color(250, 249, 246));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel5.setLayout(null);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doctor.png"))); // NOI18N
        jPanel5.add(jLabel13);
        jLabel13.setBounds(200, 40, 40, 40);
        jPanel5.add(D);
        D.setBounds(10, 50, 30, 40);

        doctor.setText("Doctors");
        jPanel5.add(doctor);
        doctor.setBounds(10, 20, 80, 14);

        dboard.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 270, 110));

        jPanel6.setBackground(new java.awt.Color(250, 249, 246));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel6.setLayout(null);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/activeUser.png"))); // NOI18N
        jPanel6.add(jLabel14);
        jLabel14.setBounds(200, 40, 40, 40);

        actAcc.setText("Active Accounts");
        jPanel6.add(actAcc);
        actAcc.setBounds(20, 20, 170, 14);
        jPanel6.add(AA);
        AA.setBounds(20, 50, 30, 30);

        dboard.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 270, 110));

        jPanel7.setBackground(new java.awt.Color(250, 249, 246));
        jPanel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel7.setLayout(null);
        jPanel7.add(PA);
        PA.setBounds(20, 50, 30, 30);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pendingUser.png"))); // NOI18N
        jPanel7.add(jLabel12);
        jLabel12.setBounds(200, 40, 40, 50);

        penAcc.setText("Pending Accounts");
        jPanel7.add(penAcc);
        penAcc.setBounds(20, 10, 190, 30);

        dboard.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 270, 110));

        jPanel8.setBackground(new java.awt.Color(250, 249, 246));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalAcc.setText("Total Accounts");
        jPanel8.add(totalAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));
        jPanel8.add(TA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 30, 30));

        dboard.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 270, 110));

        mainbg.add(dboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 910, 700));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainbg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseEntered

        dashboardPanel.setBackground(hoverColor);


    }//GEN-LAST:event_dashboardPanelMouseEntered

    private void dashboardPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseExited

        dashboardPanel.setBackground(mainColor);

    }//GEN-LAST:event_dashboardPanelMouseExited

    private void jPanel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseEntered
        jPanel2.setBackground(hoverColor);
    }//GEN-LAST:event_jPanel2MouseEntered

    private void jPanel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseExited
        jPanel2.setBackground(mainColor);
    }//GEN-LAST:event_jPanel2MouseExited

    private void accountPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountPanelMouseEntered
        accountPanel.setBackground(hoverColor);
    }//GEN-LAST:event_accountPanelMouseEntered

    private void accountPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accountPanelMouseExited
        accountPanel.setBackground(mainColor);
    }//GEN-LAST:event_accountPanelMouseExited

    private void dashboardPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseClicked

        dboard.setVisible(true);

    }//GEN-LAST:event_dashboardPanelMouseClicked

    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        logoutPanel.setBackground(hoverlogoutColor);
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        logoutPanel.setBackground(logoutColor);
    }//GEN-LAST:event_logoutPanelMouseExited

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked

//        try {
//            if (connection != null) {
//                connection.close();
//                
//            }
//            
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }   
        logIn lg = new logIn();
        lg.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_logoutPanelMouseClicked

    private void loadOpenSans() {
        try {
            InputStream fontStream = getClass().getResourceAsStream("/font/OpenSans-VariableFont_wdth,wght.ttf");
            if (fontStream != null) {
                Font openSans = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(openSans);
                // Now you can use the font:
                jLabel2.setFont(openSans.deriveFont(Font.BOLD, 14));
                jLabel5.setFont(openSans.deriveFont(Font.BOLD, 24));
                logout.setFont(openSans.deriveFont(Font.PLAIN, 18));
                patient.setFont(openSans.deriveFont(Font.BOLD, 18));
                doctor.setFont(openSans.deriveFont(Font.BOLD, 18));
                actAcc.setFont(openSans.deriveFont(Font.BOLD, 18));
                penAcc.setFont(openSans.deriveFont(Font.BOLD, 18));
                totalAcc.setFont(openSans.deriveFont(Font.BOLD, 18));
                accOV.setFont(openSans.deriveFont(Font.BOLD, 18));
                TA.setFont(openSans.deriveFont(Font.BOLD, 20));
                dboardBG.setFont(openSans.deriveFont(Font.BOLD, 18));
                D.setFont(openSans.deriveFont(Font.BOLD, 20));
                P.setFont(openSans.deriveFont(Font.BOLD, 20));
                AA.setFont(openSans.deriveFont(Font.BOLD, 20));
                PA.setFont(openSans.deriveFont(Font.BOLD, 20));
                usersTable.getTableHeader().setFont(openSans.deriveFont(Font.BOLD, 15));
                usersTable.getTableHeader().revalidate();
                usersTable.getTableHeader().repaint();
                usersTable.setFont(openSans.deriveFont(Font.PLAIN, 12));

            } else {
                System.err.println("Font file not found!");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    private void loadItim() {
        try {
            InputStream fontStream = getClass().getResourceAsStream("/font/Itim-Regular.ttf");
            if (fontStream != null) {
                Font itim = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(itim);

                jLabel4.setFont(itim.deriveFont(Font.ITALIC, 22));

            } else {
                System.err.println("Font file not found!");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(adminDashB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminDashB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminDashB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminDashB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminDashB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AA;
    private javax.swing.JLabel D;
    private javax.swing.JLabel P;
    private javax.swing.JLabel PA;
    private javax.swing.JLabel TA;
    private javax.swing.JLabel accOV;
    private javax.swing.JPanel accountPanel;
    private javax.swing.JLabel actAcc;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel dboard;
    private javax.swing.JPanel dboardBG;
    private javax.swing.JLabel doctor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JPanel mainbg;
    private javax.swing.JLabel patient;
    private javax.swing.JLabel penAcc;
    private javax.swing.JLabel totalAcc;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
