/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.opd.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import static java.nio.file.Files.lines;
import static java.nio.file.Files.lines;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ruser
 */
public class AddAppointment extends javax.swing.JFrame {

    
    public AddAppointment() {
        initComponents();
    }
public boolean requird = false;

    
    
    public class Appointments extends AddAppointment{
    
        String AppointmetDate;
        String AppointmentTime;
        String Symptoms;
        String PatientName;
        String MedicalOfficerName;
        
        
 
    }
  private Appointments SaveAppointmentData() {
        
        Appointments objAppoint  = new Appointments();  //Create object assign user inputs
        
        objAppoint.PatientName        = PatientName();
        objAppoint.MedicalOfficerName = MedOfficerName();
        objAppoint.AppointmetDate     = getDate();
        objAppoint.AppointmentTime    = getTime();
        objAppoint.Symptoms           = Symptoms();
        
       if(objAppoint.AppointmetDate != null && objAppoint.AppointmetDate.trim().isEmpty() || objAppoint.Symptoms != null 
               && objAppoint.Symptoms.trim().isEmpty() || objAppoint.AppointmentTime != null && objAppoint.AppointmentTime.trim().isEmpty()) {  
            
            requird= false;
            
        } else {
            requird = true;
            
        }
        return objAppoint; 
        
    }
    
public String getDate(){   //for getdate 

    String outputDate = jTextField1.getText();
    
        
 return outputDate;
}

public String getTime(){   //for getTime
    
    String outputTime = jTextField2.getText();
    
return outputTime;
}
public String Symptoms(){
    
    String Symptoms = jTextArea1.getText();
    
    
    return Symptoms;
}
public String PatientName(){
    
    String PatientName = jComboBox1.getSelectedItem().toString();
    
    return PatientName;
}
    
public String MedOfficerName(){
    
    String MedOfficerName = jComboBox2.getSelectedItem().toString();
    
    return MedOfficerName;
}
public int getAppointmentfilecount() throws FileNotFoundException, IOException{
    
    int Alines = 0;
    BufferedReader Countreader ;
    
    Countreader = new BufferedReader(new FileReader("db\\Appointments.txt"));
    
        while (Countreader.readLine() != null) {
                
              Alines++;
              
            }
     return Alines;
     
    }

public void SaveAppointments(){
   Appointments obj = new Appointments();
   
   
       
        try {    
            FileWriter fw=new FileWriter("db\\Appointments.txt",true);
           // BufferedWriter FileAppointments = new BufferedWriter(fw);
            
            fw.write(SaveAppointmentData().PatientName);
            fw.write(",");
            fw.write(SaveAppointmentData().MedicalOfficerName);
            fw.write(",");
            fw.write(SaveAppointmentData().AppointmetDate);
            fw.write(",");
            fw.write(SaveAppointmentData().AppointmentTime);
            fw.write(",");
            fw.write(SaveAppointmentData().Symptoms);
            fw.write("\n");
            
            
            fw.close();
        }
      
        catch (IOException ex) {
            Logger.getLogger(AddAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        
   

}




    //To get number of  lines on patients.txt
    public int getPatientsfilecount() throws IOException{
        
        
        int Plines;
        try (BufferedReader Countreader = new BufferedReader(new FileReader("db\\patients.txt"))) {
            Plines = 0;
            while (Countreader.readLine() != null) {
                
                Plines++;
            }
        }
      return Plines;
    }
    
    //To get number of  lines on MedicalOfficers.txt
    public int getMediofficersfilecount() throws IOException{
        
        
        int Mlines;
        try (BufferedReader Countreader = new BufferedReader(new FileReader("db\\MedicalOfficers.txt"))) {
            Mlines = 0;
            while (Countreader.readLine() != null) {
                
                Mlines++;
            }
        }
      return Mlines;
    }
    
    
  public void ShowMassageDialogBox(){
        JFrame f;
        f=new JFrame(); 

        JOptionPane.showMessageDialog(f,"Appointment has been successfully added.","Massage Box",JOptionPane.WARNING_MESSAGE);
   }                                                             
   public void ShowNoinputDialogBox(){
        JFrame f;
        f=new JFrame(); 

        JOptionPane.showMessageDialog(f,"You must fill in all of the fields.","Alert",JOptionPane.WARNING_MESSAGE);
   }
  
  public void setToEmpty(){
      jComboBox1.setSelectedIndex(0);
      jComboBox2.setSelectedIndex(0);
      jTextField1.setText("");
      jTextField2.setText("");
      jTextArea1.setText("");
      
  
  }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<String> getPatientsList() throws IOException{
         int Plines;
         String thisline = null;
         String[] temp;
         
        
         
         List<String> PatientsNamesList = new ArrayList<String>();
         
         try {
            BufferedReader reader= new BufferedReader(new FileReader("db\\patients.txt"));
            Plines = getPatientsfilecount();
            //System.out.println(lines);
            String[] temp2 = new String[Plines];
         for (int i=0; i<(8); i++){
             thisline = reader.readLine();
             temp = thisline.split(",");  
             //PatientsNamesList = thisline.split(",");
             PatientsNamesList.add(i, temp[1]);
             temp2[i] = PatientsNamesList.get(i);
             
             
             
             System.out.println(PatientsNamesList);   
             //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>();  
            DefaultComboBoxModel Patient = new DefaultComboBoxModel(temp2);
             jComboBox1.setModel(Patient);
             
            
            }
            
          
            reader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PatientsNamesList;     //Patient's names array
    
    
    }
    
    public List<String> getMedicalOffList() throws IOException{
         int Mlines;
         String thisline = null;
         String[] temp;
         
        
         
         List<String> MedicalOfficersNamesList = new ArrayList<String>();
         
         try {
            BufferedReader reader= new BufferedReader(new FileReader("db\\MedicalOfficers.txt"));
            Mlines = getMediofficersfilecount();
           System.out.println("Medicaloff lines"+Mlines);
            String[] temp2 = new String[Mlines];
         for (int i=0; i<(Mlines); i++){
             thisline = reader.readLine();
             temp = thisline.split(",");  
             //MedicalOfficersNamesList = thisline.split(",");
             MedicalOfficersNamesList.add(i, temp[1]);
             temp2[i] = MedicalOfficersNamesList.get(i);
             
             
             
             System.out.println(MedicalOfficersNamesList);   
             //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>();  
            DefaultComboBoxModel MediOfficer = new DefaultComboBoxModel(temp2);
             jComboBox2.setModel(MediOfficer);
             
            
            }
            
          
            reader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddAppointment.class.getName()).log(Level.SEVERE, null, ex);
        }
        return MedicalOfficersNamesList;     //Patient's names array
    
    
    }
    
    
   public void ResetFields(){
   
       jComboBox1.setSelectedIndex(0);
       jComboBox2.setSelectedIndex(0);
       jTextField1.setText(" ");
       jTextField2.setText(" ");
       jTextArea1.setText(" ");
   
   
   } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1232, 820));
        getContentPane().setLayout(null);

        jPanel5.setBackground(new java.awt.Color(0, 153, 204,80));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setForeground(new java.awt.Color(51, 110, 123));

        jButton1.setBackground(new java.awt.Color(0, 153, 204,50));
        jButton1.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 153, 204,50));
        jButton2.setFont(new java.awt.Font("Trebuchet MS", 1, 20)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Poor Richard", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(243, 249, 249));
        jLabel10.setText("Suwin Hospital");

        jLabel8.setFont(new java.awt.Font("Rage Italic", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(236, 230, 230));
        jLabel8.setText("We care always");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(195, 195, 195)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(191, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel5);
        jPanel5.setBounds(30, 120, 219, 619);

        jPanel4.setBackground(new java.awt.Color(0, 153, 204,80));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204,80));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setText("Appointment Date:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Patient:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setText("Appointment Time:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Medical Officer:");

        jComboBox1.setBackground(new java.awt.Color(0, 153, 204,50));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Patient" }));
        jComboBox1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), null, null));

        jTextField1.setBackground(new java.awt.Color(0, 153, 204,50));
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), null, null));

        jTextField2.setBackground(new java.awt.Color(0, 153, 204,50));
        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), null, null));

        jComboBox2.setBackground(new java.awt.Color(0, 153, 204,50));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Officer" }));
        jComboBox2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), null, null));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel7.setText("Symptoms:");

        jTextArea1.setBackground(new java.awt.Color(0, 153, 204,50));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 102), null, null));
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(201, 201, 201)))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(260, 120, 930, 620);

        jLabel2.setBackground(new java.awt.Color(0, 153, 204,80));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel2.setText("Add Appointments");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 40, 410, 52);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/wallpaper-login.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1220, 770);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

  

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
           SaveAppointmentData();
        if (requird==true){
            SaveAppointments();
            System.out.println("true vale "+requird);
            ShowMassageDialogBox();
            this.setVisible(false);
            
        } else {
            System.out.println("false vale "+requird);
            ShowNoinputDialogBox();
            setToEmpty();
            
        }
            
            //
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       ResetFields();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private volatile javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
