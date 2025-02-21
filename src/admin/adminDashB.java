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
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javax.swing.SwingUtilities;
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
            usersTable.setModel(DbUtils.resultSetToTableModel(rs));
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());

        }

    }

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
        penAcc = new javax.swing.JLabel();
        patient = new javax.swing.JLabel();
        doctor = new javax.swing.JLabel();
        actAcc = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        totalAcc = new javax.swing.JLabel();
        accOV = new javax.swing.JLabel();
        TA = new javax.swing.JLabel();
        P = new javax.swing.JLabel();
        D = new javax.swing.JLabel();
        AA = new javax.swing.JLabel();
        PA = new javax.swing.JLabel();

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

        jPanel1.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 170, 70));

        mainbg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 620));

        dboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(250, 249, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Admin Dashboard");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        dboard.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 70));

        dboardBG.setBackground(new java.awt.Color(250, 249, 246));
        dboardBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersTable.getTableHeader().setOpaque(false);
        usersTable.setRowHeight(25);
        usersTable.setRowMargin(0);
        jScrollPane1.setViewportView(usersTable);

        dboardBG.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 750, 260));

        penAcc.setText("Pending Accounts");
        dboardBG.add(penAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, -1, -1));

        patient.setText("Patients");
        patient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dboardBG.add(patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 90, -1));

        doctor.setText("Doctors");
        dboardBG.add(doctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        actAcc.setText("Active Accounts");
        dboardBG.add(actAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/patient.png"))); // NOI18N
        dboardBG.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 40, -1));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pendingUser.png"))); // NOI18N
        dboardBG.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doctor.png"))); // NOI18N
        dboardBG.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, -1, -1));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/activeUser.png"))); // NOI18N
        dboardBG.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, -1, -1));

        totalAcc.setText("Total Accounts");
        dboardBG.add(totalAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, -1, -1));

        accOV.setText("Accounts Overview");
        dboardBG.add(accOV, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));
        dboardBG.add(TA, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, -1));
        dboardBG.add(P, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 30, 20));
        dboardBG.add(D, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 30, 30));
        dboardBG.add(AA, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 40, 40));
        dboardBG.add(PA, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 130, 40, 40));

        dboard.add(dboardBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 790, 530));

        mainbg.add(dboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 830, 620));

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
                usersTable.getTableHeader().setFont(openSans.deriveFont(Font.BOLD, 12));
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
