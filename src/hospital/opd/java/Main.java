
package hospital.opd.java;

import static hospital.opd.java.PatientDashboard.jLabel13;
import static hospital.opd.java.PatientDashboard.jLabel14;
import static hospital.opd.java.PatientDashboard.jLabel15;
import static hospital.opd.java.PatientDashboard.jLabel16;
import static hospital.opd.java.PatientDashboard.jLabel17;
import static hospital.opd.java.PatientDashboard.jLabel18;
import static hospital.opd.java.PatientDashboard.jLabel19;
import static hospital.opd.java.PatientDashboard.jLabel20;
import static hospital.opd.java.PatientDashboard.jPanel3;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main extends javax.swing.JFrame {
    private List<String> list;
    private static Scanner x; 
      String username;
      String password;
      public String usertype;
      public String PatientName;
      public  String Pusername;
    


   
  
   public void filereader() throws IOException{ 
        String[] tokens;
        String str;
        
        
        boolean status =false;
        JFrame f;  
        
        
        
        // check if File exists or not 
         
        BufferedReader log;
        log = new BufferedReader(new FileReader("db\\login.txt"));
        username = getUserName();
        password =getPassword();
        usertype = getusertype();
            
        
            
        //System.out.println(log.readLine());
        //System.out.println(log.readLine());
        while ((str = log.readLine()) != null) {
            
            
         
        //System.out.println(user+password);
  // read from FileReader till the end of file 
        tokens = str.split(",");
        //System.out.println(user +" "+ password+"||"+ tokens[0] +" "+ tokens[1] );
        
        
        
            try {
                if ((username.equals(tokens[0])) && (password.equals(tokens[1])) &&(usertype.equals(tokens[2]))){
                 
                    System.out.println("Valid user");
                    System.out.println("user -"+username);
                    System.out.println("password -"+password);
                    System.out.println("usertype -"+usertype);
                    
                    
                    status = true;
                    
                    if (usertype == "Admin" && status==true){
                        System.out.println("Admin Logged");
                        Dashboard obj = new Dashboard();
                        this.setVisible(false);
                        obj.setVisible(true);
                        
                        obj.jLabel105.setText("Admin Panel");
                        
                       }
                    
                     if (usertype == "Receptionist"&& status==true){
                        Dashboard objDashboard = new Dashboard();
                        Hidelogin();
                        objDashboard.setVisible(true);
                        objDashboard.jLabel105.setText("Receptionist");
                       }
                     
                     if (usertype == "Medical Officer"&& status==true){
                        //-------------
                        Hidelogin();
                        //objDashboard.setVisible(true);
                       }
                    if (usertype == "Patient"&& status==true){
                        
                        String[] Patientsblock;
                        String ptr;
                        
                        
                        
                        
                        BufferedReader reader;
                        reader = new BufferedReader(new FileReader("db\\patients.txt"));
                        
                        while ((ptr = reader.readLine()) != null) {
                            Patientsblock = ptr.split(",");
                            if (username.equals(Patientsblock[0])){
                                System.out.println("Found patients record");
                               
                                
                                PatientDashboard obj = new PatientDashboard();
                                obj.putTextNow(jLabel14,Patientsblock[0]);
                                obj.putTextNow(jLabel15,Patientsblock[1]);
                                obj.putTextNow(jLabel16,Patientsblock[2]);
                                obj.putTextNow(jLabel18,Patientsblock[5]);
                                obj.putTextNow(jLabel17,Patientsblock[6]);
                                obj.putTextNow(jLabel19,Patientsblock[7]);
                                obj.putTextNow(jLabel20,Patientsblock[4]);
                                obj.putTextNow(jLabel13,Patientsblock[3]);
                                
                                obj.jPanel3.setVisible(false);
                                obj.jPanel4.setVisible(false);
                                obj.jPanel6.setVisible(false);
                                obj.jPanel5.setVisible(true);
        
                                obj.setVisible(true);
                                
                                
                                
                            
                            }
                        
                        }
                        
                        
                        
                        
                        
                        
                        
                        Hidelogin();
                        //objDashboard.setVisible(true);
                        getPatientUname(tokens[0].toString());
                        System.out.println("Patient login");
                        
                       }
                    
                    //for hide current login window and move to main dashboard
                    Hidelogin();
                    //Showdashboard();
                    
                    //log.close();
                    break;  //To stop the loop 
                
          
        }
                
            } catch (Exception e) {
                
            }
        
        
        }
        
       
        if (!status){ 
         f=new JFrame(); 
         JOptionPane.showMessageDialog(f,"Incorrect Username and Password.","Try Again",JOptionPane.WARNING_MESSAGE);   
         System.out.println("Not Logged!");
         
       
         //Reset the input boxes
         jTextField2.setText("");
         jPasswordField1.setText("");
         
         
         log.close();
        }  
   
         
   
        
        
// close the file 
          
       }
   public List<String> getList() {
      return list;  
   }
   
   
   
   public String OpenPatientdashboard() throws FileNotFoundException
   {
       initComponents();
   
   String CheckValue = PatientName;
       System.out.println("open Fun ="+PatientName);
   
   //String filepath ="db\\patients.txt";
        String[] tokens;
        String str;
        
        System.out.println("CheckValue"+ CheckValue);
         
        
        //File oldFile = new File(filepath);
        
        String name; String gender; String phono; String id;
        String dob; String address; String status; String bloodgroup; String allergies;
        
        BufferedReader reader;
        
        
            reader = new BufferedReader(new FileReader("db\\patients.txt"));
            
            
        try {
            while ((str = reader.readLine()) != null) {
                tokens = str.split(",");
                if (tokens[0].equals(CheckValue)){
                    System.out.println("Found Uname");
                    Pusername = tokens[0];
                    name = tokens[0];
                    gender = tokens[0];
                    phono = tokens[0];
                    id = tokens[0];
                    dob = tokens[0];
                    address = tokens[0];
                    status = tokens[0];
                    
                    
                    
                    
                
                }
                
                
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
        
  return Pusername; 
}      
         
         
   
   
   
   
   
    public String getPatientUname(String value){
       
       PatientName = value;
       System.out.println("Return Value in fun"+PatientName);
    return PatientName;
    
    
    }
   
   public void encryption(){
        //login password encrypt and decryptgit status
 
 }     
  
   
   public void Showdashboard(){
        Dashboard d = new Dashboard();
        d.setVisible(true);
   }
   public void Hidelogin(){
       this.setVisible(false);
   }

    
    public String getUserName(){
       username = jTextField2.getText();
       return username;
       
   }
   public String getPassword(){
       password = jPasswordField1.getText();
       return password;
   }
   public String getusertype(){
   usertype = jComboBox1.getSelectedItem().toString();
   return usertype;
   }
   
   
   
    public Main() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(33, 152, 207));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Suwin Hospital");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("X");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Garamond", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(38, 38, 48));
        jLabel1.setText("Password");

        jLabel3.setFont(new java.awt.Font("Garamond", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(38, 38, 48));
        jLabel3.setText("Username");

        jComboBox1.setFont(new java.awt.Font("Garamond", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(38, 38, 48));
        jComboBox1.setMaximumRowCount(4);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Receptionist", "Patient", "Medical Officer", "Admin" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.setFocusable(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTextField2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jPasswordField1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/login button pre.png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel5MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/login.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel4)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jLabel5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseEntered
        // Login
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/login button past.png")));
    }//GEN-LAST:event_jLabel5MouseEntered

    private void jLabel5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseExited
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/login button pre.png")));
    }//GEN-LAST:event_jLabel5MouseExited

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        //userlogin();
        
        try {
            filereader();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
       
        setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
