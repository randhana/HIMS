
package hospital.opd.java;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;


public class Patients extends javax.swing.JFrame {
 
    
    public Patients() {
        try {
            this.File = new FileWriter("db\\patients.txt",true);
        } catch (IOException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
    }
  FileWriter File;
 private static Scanner x;     
public String tempvalue;
public String Utype;
public String Uname;
public int Plines;
public int PatientDataRow;
public class patients extends Patients{

        String username;
        String name;
        String gender;
        String phoneno;
        String id;
        String dob;
        String address;
        String status;
        String bloodgroup;
        String allergies;
        
        
  }
public void SavePatientData(){
            patients objPatientrow = new patients();
            
            
        objPatientrow.username = this.jTextField2.getText();
        objPatientrow.name     = jTextField4.getText();
        objPatientrow.gender   = this.jComboBox1.getSelectedItem().toString();
        objPatientrow.phoneno  =jTextField1.getText();
        objPatientrow.id  =jTextField5.getText();
        objPatientrow.dob  =jTextField6.getText();
        objPatientrow.address  =jTextArea1.getText();
        objPatientrow.status  =jComboBox2.getSelectedItem().toString();
        objPatientrow.bloodgroup = jComboBox4.getSelectedItem().toString();
        objPatientrow.allergies =  jTextField3.getText();
        System.out.println("save btn objname="+objPatientrow.username);
        System.out.println("SAVE Method");
          
        String CheckValue = getEditValue(Uname);
         if (CheckValue != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\patients.txt";
        
        System.out.println("Update Button Clicked");
        System.out.println("VheckValue"+CheckValue);
         
        String tempFile = "db\\temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String username; String name; String gender; String phono; String id;
        String dob; String address; String status; String bloodgroup; String allergies;
        
        FileWriter fw;
        try {
            fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
        
         x =new Scanner(new File(filepath));
         x.useDelimiter("[,\n]");
         
         while(x.hasNext()){
             username = x.next();
             name = x.next();
             gender = x.next();
             phono = x.next();
             id = x.next();
             dob = x.next();
             address = x.next();
             status = x.next();
             bloodgroup = x.next();
             allergies = x.next();
             
             if (username.equals(CheckValue)){
                 System.out.println("Found equal"+"nextline= "+username+" objcombo val="+jComboBox1.getSelectedItem().toString()+"objUsername= "+objPatientrow.username);
                    pw.println(objPatientrow.username+ ","+ objPatientrow.name+","+
                            objPatientrow.gender+","+objPatientrow.phoneno+","+objPatientrow.id+","+
                            objPatientrow.dob+","+objPatientrow.address+","+
                            objPatientrow.status+","+objPatientrow.bloodgroup+","+
                            objPatientrow.allergies);
                   }
             else
             {
                 pw.println(username+","+ name+","+ gender+","+ phono+","+ id+","+ dob+","+ address+","+ status+","+
                         bloodgroup+","+ allergies);
             }
             
         
         
         }
         x.close();
         pw.flush();
         pw.close();
         oldFile.delete();
         File dump = new File(filepath);
         newFile.renameTo(dump);
         
         
        } catch (IOException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
         
         
         
         
         
         
         
         }   
            
            
        
          
                try (BufferedWriter FilePatients = new BufferedWriter(File)) {
                    FilePatients.write(objPatientrow.username);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.name);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.gender);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.phoneno);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.id);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.dob);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.address);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.status);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.bloodgroup);
                    FilePatients.write(",");
                    FilePatients.write(objPatientrow.allergies);
                    FilePatients.write("\n");
                    //for save  patients details
                } catch (IOException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }

        
            
       
            
       
        
        
        //create object for save patients data
        
   }

 public void HideSaveButton(){
   jButton2.setVisible(false);
       
   }  
 
 public String getEditValue(String value){
      initComponents();
        Uname = value;
      System.out.println("Return Value"+Uname);
  return Uname;
  }
  public void getValues(){
      patients objPatientrow = new patients();  //create a object
           
    
        objPatientrow.username = jTextField2.getText();
        objPatientrow.name     = jTextField4.getText();
        objPatientrow.gender   = Patients.jComboBox1.getSelectedItem().toString();
        objPatientrow.phoneno  =jTextField1.getText();
        objPatientrow.id  =jTextField5.getText();
        objPatientrow.dob  =jTextField6.getText();
        objPatientrow.address  =jTextArea1.getText();
        objPatientrow.status  =jComboBox2.getSelectedItem().toString();
        objPatientrow.bloodgroup = jComboBox4.getSelectedItem().toString();
        objPatientrow.allergies =  jTextField3.getText();
  System.out.println("user ="+objPatientrow.username);
  System.out.println("dob ="+objPatientrow.dob);
  System.out.println("id ="+objPatientrow.id);
  System.out.println("ADD ="+objPatientrow.address);
  System.out.println("Name" +objPatientrow.name);
  System.out.println("Gender ="+objPatientrow.gender);
  //this.jTextField2.setText("asSas");
  }


public void UpdateButton(){
    
     patients objPatientrow = new patients();  //create a object
           
        String filepath ="db\\patients.txt";
       String CheckValue = getEditValue(Uname);
        System.out.println("Update Button Clicked");
        System.out.println("VheckValue"+CheckValue);
        
       
       
        objPatientrow.username = jTextField3.getText();
        objPatientrow.name     = jTextField4.getText();
        objPatientrow.gender   = Patients.jComboBox1.getSelectedItem().toString();
        objPatientrow.phoneno  =jTextField1.getText();
        objPatientrow.id  =jTextField5.getText();
        objPatientrow.dob  =jTextField6.getText();
        objPatientrow.address  =jTextArea1.getText();
        objPatientrow.status  =jComboBox2.getSelectedItem().toString();
        objPatientrow.bloodgroup = jComboBox4.getSelectedItem().toString();
        objPatientrow.allergies =  jTextField3.getText();
  
        String tempFile = "db\\temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);
        String username; String name; String gender; String phono; String id;
        String dob; String address; String status; String bloodgroup; String allergies;
        
        FileWriter fw;
        try {
            fw = new FileWriter(tempFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
           PrintWriter pw = new PrintWriter(bw);
        
         x =new Scanner(new File(filepath));
         x.useDelimiter("[,\n]");
         
         while(x.hasNext()){
             username = x.next();
             name = x.next();
             gender = x.next();
             phono = x.next();
             id = x.next();
             dob = x.next();
             address = x.next();
             status = x.next();
             bloodgroup = x.next();
             allergies = x.next();
             
             if (username.equals(CheckValue)){
                 System.out.println("Found equal"+"nextline= "+username+" objcombo val="+jComboBox1.getSelectedItem().toString()+"objUsername= "+objPatientrow.username);
                    pw.println(objPatientrow.username+ ","+ objPatientrow.name+","+
                            objPatientrow.gender+","+objPatientrow.phoneno+","+objPatientrow.id+","+
                            objPatientrow.dob+","+objPatientrow.address+","+
                            objPatientrow.status+","+objPatientrow.bloodgroup+","+
                            objPatientrow.allergies);
                   }
             else
             {
                 pw.println(username+","+ name+","+ gender+","+ phono+","+ id+","+ dob+","+ address+","+ status+","+
                         bloodgroup+","+ allergies);
             }
             
         
         
         }
         x.close();
         pw.flush();
         pw.close();
         oldFile.delete();
         File dump = new File(filepath);
         newFile.renameTo(dump);
         
         
        } catch (IOException ex) {
            Logger.getLogger(Patients.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
 
      
      
      
     }




    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Gender:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/resources/mainbanneredit.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(200, 223, 251));

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel2.setText("Patients Registration");

        jLabel3.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel3.setText("Phone Number:");

        jLabel4.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel4.setText("Username:");

        jLabel5.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel5.setText("Name:");

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setMaximumRowCount(2);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel6.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel6.setText("ID Number:");

        jLabel7.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel7.setText("Address:");

        jLabel8.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel8.setText("Gender:");

        jLabel10.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel10.setText("Status:");

        jLabel11.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel11.setText("Date of Birth:");

        jTextField1.setBackground(new java.awt.Color(215, 227, 242));

        jTextField2.setBackground(new java.awt.Color(215, 227, 242));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jComboBox2.setBackground(new java.awt.Color(215, 227, 242));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setMaximumRowCount(4);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Separated", "Divorced" }));

        jTextField3.setBackground(new java.awt.Color(215, 227, 242));

        jTextField4.setBackground(new java.awt.Color(215, 227, 242));
        jTextField4.setToolTipText("");

        jTextField5.setBackground(new java.awt.Color(215, 227, 242));

        jTextField6.setBackground(new java.awt.Color(215, 227, 242));

        jTextArea1.setBackground(new java.awt.Color(215, 227, 242));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel13.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel13.setText(" Allergies: ");

        jLabel14.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel14.setText("Blood Group:");

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-", "" }));

        jLabel19.setBackground(new java.awt.Color(153, 153, 153));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/resources/profile pic.jpg"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(215, 227, 242));
        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel20.setText("Profile Picture");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setText("Cancel");

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setText("Update");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(324, 324, 324)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SavePatientData();
        
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       //UpdatePatientsDetails();
      // print();
     // Patients objPat = new Patients();
      //objPat.
     // jTextField2.setText("gttyhdchch");
    // getValues();
        //System.out.println("LABLE="+labal);
      //UpdateButton();
     // SavePatientData();
      this.setVisible(false);
      //SavePatientData();
    //  UserTypeName obj = new UserTypeName();
       // obj.checkWhichUser();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField2ActionPerformed

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
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Patients().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
