/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import careq.logIn;
import config.session;
import gfx.RoundedPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class profileMenu extends javax.swing.JFrame {

    Color mainColor = new Color(37, 171, 241);
    Color hoverColor = new Color(31, 128, 179);

    Color logoutColor = new Color(100, 188, 234);
    Color hoverlogoutColor = new Color(250, 249, 246);

    public profileMenu() {
        initComponents();
        accountInformation();
        loadOpenSans();
    }

    public void accountInformation() {

        session sess = session.getInstance();

        String fullName = session.getFirstName() + " " + session.getLastName();

        name.setText(fullName);
        

        email.setText(session.getEmail());
        
        
        contact.setText(session.getContact());

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainbg = new javax.swing.JPanel();
        dboard = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dboardBG = new RoundedPanel(15);
        contact = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new RoundedPanel(5);
        doctorPanel = new RoundedPanel(50);
        jLabel9 = new javax.swing.JLabel();
        doctor1 = new javax.swing.JLabel();
        patientPanel = new RoundedPanel(50);
        jLabel15 = new javax.swing.JLabel();
        patient1 = new javax.swing.JLabel();
        dashboardPanel = new RoundedPanel(50);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        logoutPanel = new RoundedPanel(25);
        jLabel6 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        profilePanel = new RoundedPanel(50);
        jLabel16 = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        accMngrPanel = new RoundedPanel(50);
        jLabel17 = new javax.swing.JLabel();
        accM = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainbg.setBackground(new java.awt.Color(245, 245, 245));
        mainbg.setMinimumSize(new java.awt.Dimension(1017, 620));
        mainbg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(250, 249, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("User Profile");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        dboard.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 70));

        dboardBG.setBackground(new java.awt.Color(250, 249, 246));
        dboardBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        contact.setText("contact");
        dboardBG.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 100, 280, 30));

        name.setText("name");
        dboardBG.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, 30));

        email.setText("email");
        dboardBG.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 290, 30));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mark.png.png"))); // NOI18N
        dboardBG.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 270, 220));

        dboard.add(dboardBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 870, 590));

        mainbg.add(dboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 910, 700));

        jPanel1.setBackground(new java.awt.Color(37, 171, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctorPanel.setBackground(new java.awt.Color(37, 171, 241));
        doctorPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doctorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorPanelMouseExited(evt);
            }
        });
        doctorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doctor_white_filled.png"))); // NOI18N
        doctorPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        doctor1.setForeground(new java.awt.Color(250, 249, 246));
        doctor1.setText("Doctors");
        doctorPanel.add(doctor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        jPanel1.add(doctorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 190, 50));

        patientPanel.setBackground(new java.awt.Color(37, 171, 241));
        patientPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        patientPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientPanelMouseExited(evt);
            }
        });
        patientPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/patient_white_filled.png"))); // NOI18N
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        patient1.setForeground(new java.awt.Color(250, 249, 246));
        patient1.setText("Patients");
        patient1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientPanel.add(patient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 110, 50));

        jPanel1.add(patientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 190, 50));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard_filled.png"))); // NOI18N
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

        profilePanel.setBackground(new java.awt.Color(37, 171, 241));
        profilePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profilePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilePanelMouseExited(evt);
            }
        });
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile-white.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
        });
        profilePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        profile.setForeground(new java.awt.Color(250, 249, 246));
        profile.setText("Profile");
        profilePanel.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        jPanel1.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 190, -1));

        accMngrPanel.setBackground(new java.awt.Color(37, 171, 241));
        accMngrPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accMngrPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accMngrPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accMngrPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accMngrPanelMouseExited(evt);
            }
        });
        accMngrPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accounts-white.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
        });
        accMngrPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        accM.setForeground(new java.awt.Color(250, 249, 246));
        accM.setText("Accounts \nManager");
        accM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accMngrPanel.add(accM, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 160, 50));

        jPanel1.add(accMngrPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 190, -1));

        mainbg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 700));

        getContentPane().add(mainbg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 700));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void doctorPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorPanelMouseEntered
        doctorPanel.setBackground(hoverColor);
    }//GEN-LAST:event_doctorPanelMouseEntered

    private void doctorPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorPanelMouseExited
        doctorPanel.setBackground(mainColor);
    }//GEN-LAST:event_doctorPanelMouseExited

    private void patientPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseClicked

                patientMenu pMenu = new patientMenu();
                pMenu.setVisible(true);
                this.dispose();
    }//GEN-LAST:event_patientPanelMouseClicked

    private void patientPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseEntered
        patientPanel.setBackground(hoverColor);
    }//GEN-LAST:event_patientPanelMouseEntered

    private void patientPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseExited
        patientPanel.setBackground(mainColor);
    }//GEN-LAST:event_patientPanelMouseExited

    private void dashboardPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseClicked
        
        adminDashB adb = new adminDashB();
        adb.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_dashboardPanelMouseClicked

    private void dashboardPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseEntered

        dashboardPanel.setBackground(hoverColor);

    }//GEN-LAST:event_dashboardPanelMouseEntered

    private void dashboardPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseExited

        dashboardPanel.setBackground(mainColor);
    }//GEN-LAST:event_dashboardPanelMouseExited

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            session userSession = session.getInstance();

            userSession.setU_id(null);
            userSession.setFirstName(null);
            userSession.setLastName(null);
            userSession.setEmail(null);
            userSession.setUsername(null);
            userSession.setAcc_type(null);
            userSession.setAcc_status(null);

            logIn lg = new logIn();
            lg.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_logoutPanelMouseClicked

    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        logoutPanel.setBackground(hoverlogoutColor);
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        logoutPanel.setBackground(logoutColor);
    }//GEN-LAST:event_logoutPanelMouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void profilePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseEntered

        profilePanel.setBackground(hoverColor);
    }//GEN-LAST:event_profilePanelMouseEntered

    private void profilePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseExited

        profilePanel.setBackground(mainColor);
    }//GEN-LAST:event_profilePanelMouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseEntered

    private void accMngrPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMngrPanelMouseEntered

        accMngrPanel.setBackground(hoverColor);
    }//GEN-LAST:event_accMngrPanelMouseEntered

    private void accMngrPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMngrPanelMouseExited
        accMngrPanel.setBackground(mainColor);
    }//GEN-LAST:event_accMngrPanelMouseExited

    private void accMngrPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMngrPanelMouseClicked
        
        accountsMenu acctM = new accountsMenu();
        
        acctM.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_accMngrPanelMouseClicked

    private void doctorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorPanelMouseClicked
        
        doctorMenu docM = new doctorMenu();
        
        docM.setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_doctorPanelMouseClicked

    private void loadOpenSans() {
        try {
            InputStream fontStream = getClass().getResourceAsStream("/font/OpenSans-VariableFont_wdth,wght.ttf");
            if (fontStream != null) {
                Font openSans = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(openSans);
               
                jLabel5.setFont(openSans.deriveFont(Font.BOLD, 24));
                name.setFont(openSans.deriveFont(Font.BOLD, 18));
                email.setFont(openSans.deriveFont(Font.BOLD, 18));
                contact.setFont(openSans.deriveFont(Font.BOLD, 18));
                jLabel2.setFont(openSans.deriveFont(Font.BOLD, 12));
                patient1.setFont(openSans.deriveFont(Font.BOLD, 12));
                doctor1.setFont(openSans.deriveFont(Font.BOLD, 12));
                accM.setFont(openSans.deriveFont(Font.BOLD, 12));
                profile.setFont(openSans.deriveFont(Font.BOLD, 12));
                logout.setFont(openSans.deriveFont(Font.BOLD, 18));
                

            } else {
                System.err.println("Font file not found!");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

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
            java.util.logging.Logger.getLogger(profileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profileMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profileMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accM;
    private javax.swing.JPanel accMngrPanel;
    private javax.swing.JLabel contact;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel dboard;
    private javax.swing.JPanel dboardBG;
    private javax.swing.JLabel doctor1;
    private javax.swing.JPanel doctorPanel;
    private javax.swing.JLabel email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JPanel mainbg;
    private javax.swing.JLabel name;
    private javax.swing.JLabel patient1;
    private javax.swing.JPanel patientPanel;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel profilePanel;
    // End of variables declaration//GEN-END:variables
}
