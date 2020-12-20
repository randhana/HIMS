
package hospital.opd.java;

import static hospital.opd.java.PatientDashboard.jLabel13;
import static hospital.opd.java.PatientDashboard.jLabel14;
import static hospital.opd.java.PatientDashboard.jLabel15;
import static hospital.opd.java.PatientDashboard.jLabel16;
import static hospital.opd.java.PatientDashboard.jLabel17;
import static hospital.opd.java.PatientDashboard.jLabel18;
import static hospital.opd.java.PatientDashboard.jLabel19;
import static hospital.opd.java.PatientDashboard.jLabel20;
import static hospital.opd.java.Patients.jComboBox1;
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
                 
                  
                    
                    
                    status = true;
                    
                    if (usertype == "Admin" && status==true){
                        Dashboard objDashboard = new Dashboard();
                        Hidelogin();
                        objDashboard.setVisible(true);
                       }
                    
                     if (usertype == "Receptionist"&& status==true){
                        Dashboard objDashboard = new Dashboard();
                        Hidelogin();
                        objDashboard.setVisible(true);
                       }
                     
                     if (usertype == "Medical Officer"&& status==true){
                        //-------------
                        Hidelogin();
                        //objDashboard.setVisible(true);
                       }
                    if (usertype == "Patient"&& status==true){
                        
                        String[] Patientsblock;
                        String ptr;
                        PatientDashboard objDashboard = new PatientDashboard();
                        
                        
                        
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
       setVisible(false);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(200, 223, 251));

        jPanel2.setBackground(new java.awt.Color(73, 147, 185));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hospital OPD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(117, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(144, 195, 245));

        jLabel1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(38, 38, 48));
        jLabel1.setText("Password");

        jLabel3.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(38, 38, 48));
        jLabel3.setText("Username");

        jComboBox1.setBackground(new java.awt.Color(144, 195, 245));
        jComboBox1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(38, 38, 48));
        jComboBox1.setMaximumRowCount(4);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Receptionist", "Patient", "Medical Officer", "Admin" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jComboBox1.setFocusable(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(194, 220, 233));
        jButton1.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(38, 38, 48));
        jButton1.setText("Exit");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(194, 220, 233));
        jButton2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(38, 38, 48));
        jButton2.setText("Login");
        jButton2.setBorder(null);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField2.setBackground(new java.awt.Color(187, 205, 247));
        jTextField2.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 14)); // NOI18N
        jTextField2.setBorder(null);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jPasswordField1.setBackground(new java.awt.Color(187, 205, 247));
        jPasswordField1.setBorder(null);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //userlogin();
        
        try {
            filereader();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //Exit button
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
