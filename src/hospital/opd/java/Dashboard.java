/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospital.opd.java;

import Class.FileWrite;
import Class.MedicalOfficers;
import Class.appointments;
import Class.Patients;
import Class.Receptionists;
import Class.Visiters;
import Class.complaints;
import Class.postal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class Dashboard extends javax.swing.JFrame {

    private Scanner x;
    
    public List<String> getPatientsList() throws FileNotFoundException, IOException {
         int Plines;
        
         String thisline = null;
         String[] temp;
         
        
         
         List<String> PatientsNamesList = new ArrayList<String>();

	BufferedReader reader= new BufferedReader(new FileReader("db\\patients.txt"));
            Plines = getPatientsfilecount();
            System.out.println("Plines"+Plines);

	String[] temp2 = new String[Plines];
         for (int i=0; i<(Plines-3); i++){
             thisline = reader.readLine();
             temp = thisline.split(",");  
             //PatientsNamesList = thisline.split(",");
             PatientsNamesList.add(i, temp[1]);
             temp2[i] = PatientsNamesList.get(i);
             
             
             
             System.out.println(PatientsNamesList);   
             //jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>();  
            DefaultComboBoxModel Patient = new DefaultComboBoxModel(temp2);
             jComboBox4.setModel(Patient);
             
	
	
	
 }
         reader.close();
         System.out.println("Patients list "+PatientsNamesList);
         return PatientsNamesList;
}   
    
  public List<String> getMedicalOffList() throws FileNotFoundException, IOException {
         int Mlines;
         String thisline = null;
         String[] temp;
         
        
         
         List<String> MedicalOfficersNamesList = new ArrayList<String>();
         
       
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
             jComboBox5.setModel(MediOfficer);
             
            }
            
            
          
            reader.close();
            
         
        return MedicalOfficersNamesList;     //Patient's names array
    
    
    }  
    
    
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
    
    public int getReceptionistfilecount() throws IOException{
        
        
        int Rlines;
        try (BufferedReader RecepCountreader = new BufferedReader(new FileReader("db\\Receptionists.txt"))) {
            Rlines = 0;
            while (RecepCountreader.readLine() != null) {
                
                Rlines++;
            }
        }
        
         
        
        
       return Rlines;
    }
    
    
    
    
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
    
    public void detailsView(String Fileparth){
        
         String fileparth=Fileparth;
         File file;
         file = new File(fileparth);
         try {
            BufferedReader brr=new BufferedReader(new FileReader(file));
            //String firstline=brr.readLine().trim();
           // String []ColumsName=firstline.split(",");
            DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
           // model1.setColumnIdentifiers(ColumsName);
           model1.setRowCount(0);  //For prevent data duplication
           
           
           
            Object [] tableline=brr.lines().toArray();
           
             for (Object tableline1 : tableline) {
                 String line = tableline1.toString().trim();
                 String[] datarow=line.split(",");
                 model1.addRow(datarow);
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        
        
        } 
        
        
    }
    
    public void VisitorsdetailsView(String Fileparth){
        
         String fileparth=Fileparth;
         File file;
         file = new File(fileparth);
         try {
            BufferedReader brr=new BufferedReader(new FileReader(file));
            //String firstline=brr.readLine().trim();
           // String []ColumsName=firstline.split(",");
            DefaultTableModel model1=(DefaultTableModel) jTable6.getModel();
           // model1.setColumnIdentifiers(ColumsName);
           model1.setRowCount(0);  //For prevent data duplication
           
           
           
            Object [] tableline=brr.lines().toArray();
           
             for (Object tableline1 : tableline) {
                 String line = tableline1.toString().trim();
                 String[] datarow=line.split(",");
                 model1.addRow(datarow);
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        
        
        } 
        
        
    }
    
    
    
    
    
    public void ComplaintdetailsView(String Fileparth){
        
         String fileparth=Fileparth;
         File file;
         file = new File(fileparth);
         try {
            BufferedReader brr=new BufferedReader(new FileReader(file));
            //String firstline=brr.readLine().trim();
           // String []ColumsName=firstline.split(",");
            DefaultTableModel model1=(DefaultTableModel) jTable3.getModel();
           // model1.setColumnIdentifiers(ColumsName);
           model1.setRowCount(0);  //For prevent data duplication
           
           
           
            Object [] tableline=brr.lines().toArray();
           
             for (Object tableline1 : tableline) {
                 String line = tableline1.toString().trim();
                 String[] datarow=line.split(",");
                 model1.addRow(datarow);
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        
        
        } 
        
        
    }
    
    
   public void ReceivedMaildetailsView(String Fileparth){
        
         String fileparth=Fileparth;
         File file;
         file = new File(fileparth);
         try {
            BufferedReader brr=new BufferedReader(new FileReader(file));
            //String firstline=brr.readLine().trim();
           // String []ColumsName=firstline.split(",");
            DefaultTableModel model1=(DefaultTableModel) jTable4.getModel();
           // model1.setColumnIdentifiers(ColumsName);
           model1.setRowCount(0);  //For prevent data duplication
           
           
           
            Object [] tableline=brr.lines().toArray();
           
             for (Object tableline1 : tableline) {
                 String line = tableline1.toString().trim();
                 String[] datarow=line.split(",");
                 model1.addRow(datarow);
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        
        
        } 
        
        
    }
    
    
    
    
    
    
    
    
    
      public void UpdateMedicalOfficers() throws FileNotFoundException, IOException{
    
        String username = jTextField1.getText();
        String name     = jTextField2.getText();
        String gender   = jComboBox6.getSelectedItem().toString();
        String phoneno  =jTextField8.getText();
        String id  =jTextField10.getText();
        String dob  =jTextField11.getText();
        String address  =jTextArea2.getText();
        String status  =jComboBox7.getSelectedItem().toString();
        String staffid =jTextField14.getText();
        String staffmail =jTextField15.getText();
        String joindate =jTextField16.getText();
        String SpecialityArea = jComboBox8.getSelectedItem().toString();

        
        String NewRowdata =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+staffid+","+staffmail+","+joindate+","+SpecialityArea;
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = EditUsers();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\MedicalOfficers.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
         while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
   }


        
    
    
    
    
    
    
   public void UpdateReceptionists() throws FileNotFoundException, IOException{
    
        String username = jTextField17.getText();
        String name     = jTextField18.getText();
        String gender   = jComboBox9.getSelectedItem().toString();
        String phoneno  =jTextField19.getText();
        String id  =jTextField20.getText();
        String dob  =jTextField21.getText();
        String address  =jTextArea4.getText();
        String status  =jComboBox10.getSelectedItem().toString();
        String staffid =jTextField24.getText();
        String staffmail =jTextField23.getText();
        String joindate =jTextField22.getText();

        
        String NewRowdata =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+staffid+","+staffmail+","+joindate;
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = EditUsers();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\Receptionists.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
         while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
   }
  
    
    
    
    
    
    
    
    public void UpdatePatients() throws FileNotFoundException, IOException{
    
        String username = jTextField7.getText();
        String name     = jTextField3.getText();
        String gender   = jComboBox1.getSelectedItem().toString();
        String phoneno  =jTextField4.getText();
        String id  =jTextField5.getText();
        String dob  =jTextField6.getText();
        String address  =jTextArea1.getText();
        String status  =jComboBox3.getSelectedItem().toString();
        String bloodgroup = jComboBox2.getSelectedItem().toString();
        String allergies =  jTextField9.getText();
        
        String NewRowdata =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+bloodgroup+","+allergies;
        System.out.println("NewLine="+NewRowdata);
        
        String CheckLine = EditUsers();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\patients.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("OldLine returned"+CheckLine);
         
         while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
   }
    
     public void UpdatePatientsButton2() throws FileNotFoundException, IOException{
    
        String username = jTextField7.getText();
        String name     = jTextField3.getText();
        String gender   = jComboBox1.getSelectedItem().toString();
        String phoneno  =jTextField4.getText();
        String id  =jTextField5.getText();
        String dob  =jTextField6.getText();
        String address  =jTextArea1.getText();
        String status  =jComboBox3.getSelectedItem().toString();
        String bloodgroup = jComboBox2.getSelectedItem().toString();
        String allergies =  jTextField9.getText();
        
        String NewRowdata =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+bloodgroup+","+allergies;
        System.out.println("NewLine="+NewRowdata);
        
        String CheckLine = EditPatients();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\patients.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("OldLine returned"+CheckLine);
         
         while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()).append(System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
   }
    
    
    
    
    
 
    
 public String EditUsers(){
    
       int index = jTable2.getSelectedRow();
       String OldLine = null;
       TableModel model = jTable2.getModel();

        String UserType = String.valueOf(model.getValueAt(index, 0).toString());
        String username = String.valueOf(model.getValueAt(index, 1).toString());
        String name     = String.valueOf(model.getValueAt(index, 2).toString());
        String gender   = String.valueOf(model.getValueAt(index, 3).toString());
        String phoneno  = String.valueOf(model.getValueAt(index, 4).toString());
        String id       = String.valueOf(model.getValueAt(index, 5).toString());
        String dob      = String.valueOf(model.getValueAt(index, 6).toString());
        String address  = String.valueOf(model.getValueAt(index, 7).toString());
        String status   = String.valueOf(model.getValueAt(index, 8).toString());
       
       if ("Patient".equals(UserType)){
            String bloodgroup = String.valueOf(model.getValueAt(index, 9).toString());
            String allergies = String.valueOf(model.getValueAt(index, 10).toString());
           System.out.println("Blood"+bloodgroup);
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddPatients.setVisible(true);
        
           jButton6.setVisible(false);    // Hide Save Button
           jButton19.setVisible(true);    //Unhide Update Button
           jButton37.setVisible(false); //update 2
           
           //set patient's details
           jTextField7.setText(username);
           jTextField3.setText(name);
           jComboBox1.setSelectedItem(gender);
           jTextField4.setText(phoneno);
           jTextField5.setText(id);
           jTextField6.setText(dob);
           jTextArea1.setText(address);
           jComboBox3.setSelectedItem(status);
           jComboBox2.setSelectedItem(bloodgroup);
           jTextField9.setText(allergies);
           
           
           
           
           System.out.println("Patient selected");
           OldLine =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+bloodgroup+","+allergies;
           
       }
       
        if ("Receptionist".equals(UserType)){
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddReceptionists.setVisible(true);
        
           jButton15.setVisible(false);    // Hide Save Button
           jButton14.setVisible(true);    //Unhide Update Button
           String staffid = String.valueOf(model.getValueAt(index, 11).toString());
           String staffmail = String.valueOf(model.getValueAt(index, 12).toString());
           String joindate = String.valueOf(model.getValueAt(index, 13).toString());
            
           jTextField17.setText(username);
           jTextField18.setText(name);
           jComboBox9.setSelectedIndex(0);
           jTextField19.setText(phoneno);
           jTextField20.setText(id);
           jTextField21.setText(dob);
           jTextArea4.setText(address);
           jComboBox10.setSelectedIndex(0);
           jTextField24.setText(staffid);
           jTextField23.setText(staffmail);
           jTextField22.setText(joindate);
           
           System.out.println("Recep selected");
            OldLine =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+staffid+","+staffmail+","+joindate; 
            
           }
        if ("MedicalOfficer".equals(UserType)){
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddMedicalOfficer.setVisible(true);
        
           jButton10.setVisible(false);    // Hide Save Button
           jButton9.setVisible(true);    //Unhide Update Button
           String staffid = String.valueOf(model.getValueAt(index, 11).toString());
           String staffmail = String.valueOf(model.getValueAt(index, 12).toString());
           String joindate = String.valueOf(model.getValueAt(index, 13).toString());
           String speciality = String.valueOf(model.getValueAt(index, 14).toString());
           
           jTextField1.setText(username);
           jTextField2.setText(name);
           jComboBox6.setSelectedIndex(0);
           jTextField8.setText(phoneno);
           jTextField10.setText(id);
           jTextField11.setText(dob);
           jTextArea2.setText(address);
           jComboBox7.setSelectedIndex(0);
           jTextField14.setText(staffid);
           jTextField15.setText(staffmail);
           jTextField16.setText(joindate);
           jComboBox8.setSelectedIndex(0);
           
           
           System.out.println("Medi selected");
           OldLine =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+staffid+","+staffmail+","+joindate+","+speciality;
           
                   
           }
       return OldLine;
       }
 
 public String EditPatients(){
    
     
       int index = jTable5.getSelectedRow();
       String OldLine = null;
       TableModel model = jTable5.getModel();

        
        String username = String.valueOf(model.getValueAt(index, 0).toString());
        String name     = String.valueOf(model.getValueAt(index, 1).toString());
        String gender   = String.valueOf(model.getValueAt(index, 2).toString());
        String phoneno  = String.valueOf(model.getValueAt(index, 3).toString());
        String id       = String.valueOf(model.getValueAt(index, 4).toString());
        String dob      = String.valueOf(model.getValueAt(index, 5).toString());
        String address  = String.valueOf(model.getValueAt(index, 6).toString());
        String status   = String.valueOf(model.getValueAt(index, 7).toString());
        String bloodgroup = String.valueOf(model.getValueAt(index, 8).toString());
        String allergies = String.valueOf(model.getValueAt(index, 9).toString());
       
            
           System.out.println("Blood"+bloodgroup);
           


	   jTextField7.setText(username);
           jTextField3.setText(name);
           jComboBox1.setSelectedItem(gender);
           jTextField4.setText(phoneno);
           jTextField5.setText(id);
           jTextField6.setText(dob);
           jTextArea1.setText(address);
           jComboBox3.setSelectedItem(status);
           jComboBox2.setSelectedItem(bloodgroup);
           jTextField9.setText(allergies);
           
           
           
           
           System.out.println("Patient selected");
           OldLine =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+bloodgroup+","+allergies;

	return OldLine;
       }
 
 
 
 
 
 
 
 
 
 public String DeleteUsers(){
    
       int index = jTable2.getSelectedRow();
       String OldLine = null;
       TableModel model = jTable2.getModel();

       String UserType = String.valueOf(model.getValueAt(index, 0).toString());
        String username = String.valueOf(model.getValueAt(index, 1).toString());
        String name     = String.valueOf(model.getValueAt(index, 2).toString());
        String gender   = String.valueOf(model.getValueAt(index, 3).toString());
        String phoneno  = String.valueOf(model.getValueAt(index, 4).toString());
        String id  = String.valueOf(model.getValueAt(index, 5).toString());
        String dob  = String.valueOf(model.getValueAt(index, 6).toString());
        String address  = String.valueOf(model.getValueAt(index, 7).toString());
        String status = String.valueOf(model.getValueAt(index, 8).toString());
       
       if ("Patient".equals(UserType)){
            String bloodgroup = String.valueOf(model.getValueAt(index, 9).toString());
            String allergies = String.valueOf(model.getValueAt(index, 10).toString());
            OldLine =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+bloodgroup+","+allergies;
           
       }
       
        if ("Receptionist".equals(UserType)){
           
           String staffid = String.valueOf(model.getValueAt(index, 11).toString());
           String staffmail = String.valueOf(model.getValueAt(index, 12).toString());
           String joindate = String.valueOf(model.getValueAt(index, 13).toString());
           
            OldLine =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+staffid+","+staffmail+","+joindate; 
            
           }
        if ("MedicalOfficer".equals(UserType)){
           
           String staffid = String.valueOf(model.getValueAt(index, 11).toString());
           String staffmail = String.valueOf(model.getValueAt(index, 12).toString());
           String joindate = String.valueOf(model.getValueAt(index, 13).toString());
           String speciality = String.valueOf(model.getValueAt(index, 14).toString());
           
           
           OldLine =username+","+name+","+gender+","+phoneno+","+id+","+dob+","+address+","+status+","+staffid+","+staffmail+","+joindate+","+speciality;
           
                   
           }
       return OldLine;
       }
 
     public void PatientsdetailsView(String Fileparth){
        
         String fileparth=Fileparth;
         File file;
         file = new File(fileparth);
         try {
            BufferedReader brr=new BufferedReader(new FileReader(file));
            //String firstline=brr.readLine().trim();
           // String []ColumsName=firstline.split(",");
            DefaultTableModel model1=(DefaultTableModel) jTable5.getModel();
           // model1.setColumnIdentifiers(ColumsName);
           model1.setRowCount(0);  //For prevent data duplication
           
           
           
            Object [] tableline=brr.lines().toArray();
           
             for (Object tableline1 : tableline) {
                 String line = tableline1.toString().trim();
                 String[] datarow=line.split(",");
                 model1.addRow(datarow);
             }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AddVisiters.class.getName()).log(Level.SEVERE, null, ex);
        
        
        } 
        
        
    }
 
 
 
    
    
    
   
    
    
    
    public void UserDetailsView() throws IOException{
        int Plines;
        int Mlines;
        int Rlines;
        String thisline = null;
        String[] temp;
       
        
        
        
        
        
            BufferedReader RecepReader= new BufferedReader(new FileReader("db\\Receptionists.txt"));
            BufferedReader MedReader= new BufferedReader(new FileReader("db\\MedicalOfficers.txt"));
            BufferedReader PatientReader= new BufferedReader(new FileReader("db\\patients.txt"));
            
            DefaultTableModel model = (DefaultTableModel)jTable2.getModel();
            model.setRowCount(0);
            
            //Receptionists details
            Rlines = getReceptionistfilecount(); 
            for (int i=0; i<Rlines; i++){
             thisline = RecepReader.readLine();
             temp = thisline.split(",");
                System.out.println(temp[0]);
            
            model.addRow(new Object[]{ "Receptionist",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],"-","-",temp[8],temp[9],temp[10]});
				
           
            }
           //medical officers details
           Mlines = getMediofficersfilecount();
            for (int j=0; j<Mlines; j++){
             thisline = MedReader.readLine();
             temp = thisline.split(",");
                System.out.println(temp[0]);
            
            model.addRow(new Object[]{ "MedicalOfficer",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],"-","-",temp[8],temp[9],temp[10],temp[11]});
				
            
            }
            
            //Patients details
            Plines = getPatientsfilecount();
            System.out.println("Count" +Plines);
            for (int i=0; i<(Plines-3); i++){
             thisline = PatientReader.readLine();
             temp = thisline.split(",");
                System.out.println(temp[0]);
            
            model.addRow(new Object[]{"Patient", temp[0],temp[1],temp[2],temp[3],temp[4],temp[5],temp[6],temp[7],temp[8],temp[9]});
				
           
            }
            
          
          
        
        
    }
    
    
    
    
    
    
    public void UpdateAppointments() throws IOException{
    
        String patientname = jComboBox4.getSelectedItem().toString();
        String medicalofficername= jComboBox5.getSelectedItem().toString();
        String appodate = jTextField12.getText();
        String appotime = jTextField13.getText();
        String symptoms = jTextArea3.getText();
        
        String NewRowdata =patientname+","+medicalofficername+","+appodate+","+appotime+","+symptoms;
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = SetAppointmentData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\Appointments.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
        
        
       
        
        
        
            
                    while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
                    
               
               
                
        
        
    
    
    
    }
    
    public void UpdateComplaints() throws IOException{
    
        String Actiontaken = jTextField25.getText();
        String Complainttype = jComboBox11.getSelectedItem().toString();
        String Complaintby = jTextField27.getText();
        String Phoneno = jTextField28.getText();
        String Date = jTextField29.getText();
	String Discription = jTextArea5.getText(); 
        
        String NewRowdata =Actiontaken+","+Complainttype+","+Complaintby+","+Phoneno+","+Date+","+Discription;
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = SetComplaintData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\Complaints.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
        
        
       
        
        
        
            
                    while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
                    
               
   }
    
    
  public void UpdateReceivedmailRecords() throws IOException{
    
        String ReNo=jTextField33.getText();
       String FromAddress=jTextField32.getText();
       String Note=jTextField31.getText();
       String ToName=jTextField30.getText();
       String  date  =jTextField26.getText();
       String  doing=jComboBox12.getSelectedItem().toString();
        
        String NewRowdata =ReNo+","+FromAddress+","+Note+","+ToName+","+date+","+doing;
        System.out.println("newline="+NewRowdata);
        
        String CheckLine = SetReceivedmailData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\DispatchedMail.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
        
        
       
        
        
        
            
                    while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
                    
               
   }
    
    
    
 public void UpdateVisitorRecords() throws IOException{
    
       String Name      = this.Name.getText();
       String PhoneNumber= this.PhoneNumber.getText();
       String Id         = this.Id.getText();
       String Date        = this.Date.getText();
       String InTime      = this.InTime.getText();
       String OutTime     = this.OutTime.getText();
       String Note        = this.Note.getText();
       String Purpose     = this.Purpose.getText();
        
        String NewRowdata =Name +","+PhoneNumber+","+Id+","+Date+","+InTime+","+OutTime+","+Note+","+Purpose;
        System.out.println("NewLine="+NewRowdata);
        
        String CheckLine = SetVisitorsData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\Visiters.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
        
        
       
        
        
        
            
                    while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = NewRowdata;
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
                    
               
   }   
    
    
    
    
    
    
    
    
    public void DeletePatients() throws IOException{
    
        String CheckLine = DeleteUsers();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\patients.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
                 while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine;
                        String newLine = "";
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine,newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        System.out.println("old line "+oldLine);
                        System.out.println("newline "+newLine);
                   }
                    
               
               
                
        
        
    
    
    
    }
    
    
  public void DeletePatients2() throws IOException{
    
        String CheckLine = EditPatients();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\patients.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
                 while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine;
                        String newLine = "";
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine,newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        System.out.println("old line "+oldLine);
                        System.out.println("newline "+newLine);
                   }
                    
               
               
                
        
        
    
    
    
    }
    
    
    
    
    
    public void DeleteAppointments() throws IOException{
    
        String patientname = jComboBox4.getSelectedItem().toString();
        String medicalofficername= jComboBox5.getSelectedItem().toString();
        String appodate = jTextField12.getText();
        String appotime = jTextField13.getText();
        String symptoms = jTextArea3.getText();
        
        String NewRowdata =SetAppointmentData();
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = SetAppointmentData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\Appointments.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
                 while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = "";
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
  }
    
    
    public void DeleteComplaints() throws IOException{
    
        
        String NewRowdata =SetComplaintData();
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = SetComplaintData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\Complaints.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
                 while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = "";
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
  }
    
    
  public void DeletePostalRecords() throws IOException{
    
        
        String NewRowdata =SetReceivedmailData();
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = SetReceivedmailData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\DispatchedMail.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
                 while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = "";
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
  }  
    
    
 public void DeleteVisitorsRecords() throws IOException{
    
        
        String NewRowdata =SetVisitorsData();
        System.out.println("oldLine="+NewRowdata);
        
        String CheckLine = SetVisitorsData();
        
        if (CheckLine != null){
             System.out.println("INTHE IF CON");
             
        String filepath ="db\\Visiters.txt";
        Scanner sc = new Scanner(new File(filepath));
        StringBuffer buffer = new StringBuffer();
        
        System.out.println("VcheckValue"+CheckLine);
         
                 while (sc.hasNextLine()) {
                        
                        buffer.append(sc.nextLine()+System.lineSeparator());
                        
                     }
                      String fileContents = buffer.toString();  
                      System.out.println("Contents of the file: "+fileContents);  
                        
                        sc.close();
                        String oldLine =CheckLine ;
                        String newLine = "";
                            //Replacing the old line with new line
                        fileContents = fileContents.replaceAll(oldLine, newLine);
                        //instantiating the FileWriter class
                        FileWriter writer = new FileWriter(filepath);
                        System.out.println("");
                        System.out.println("new data: "+fileContents);
                        writer.append(fileContents);
                        writer.flush();  
                        
                        
                   }
  }
  
  
  
  
  
  
    
    
    
    
    public void updatefilenames(){
       Path source1 = Paths.get("db\\Appointments.txt");
     Path source = Paths.get("db\\tempappo.txt");

  try{

    // rename a file in the same directory
    
    Files.move(source1, source1.resolveSibling("Appointmentssold.txt"));
    Files.move(source, source.resolveSibling("Appointments.txt"));

  } catch (IOException e) {
    e.printStackTrace();
  }
   } 
    
    public String SetAppointmentData(){
    
      // get the selected row
       int index = jTable1.getSelectedRow();

       TableModel model = jTable1.getModel();

      String Patientname = String.valueOf(model.getValueAt(index, 0).toString());
      String MedicalOfficername = String.valueOf(model.getValueAt(index, 1).toString());
      String AppointmentDate = String.valueOf(model.getValueAt(index, 2).toString());
      String AppointmentTime = String.valueOf(model.getValueAt(index, 3).toString());
      String Symptoms = String.valueOf(model.getValueAt(index, 4).toString());
      
      String OldRowData = Patientname+","+MedicalOfficername+","+AppointmentDate+","+AppointmentTime+","+Symptoms;
      
       System.out.println("Row value:"+Patientname);
       
       jComboBox4.setSelectedItem(Patientname);
       jComboBox5.setSelectedItem(MedicalOfficername);
       jTextField12.setText(AppointmentDate);
       jTextField13.setText(AppointmentTime);
       jTextArea3.setText(Symptoms);
       
       
     //  int sum = value1+value2+value3+value4;
       
    
    return OldRowData;
    }
    
    
    
    public String SetReceivedmailData(){
        System.out.println("In function");
      // get the selected row
       int index = jTable4.getSelectedRow();

       TableModel model = jTable4.getModel();

      String ReNo = String.valueOf(model.getValueAt(index, 0).toString());
      String FromAddress = String.valueOf(model.getValueAt(index, 1).toString());
      String Note = String.valueOf(model.getValueAt(index, 2).toString());
      String ToName = String.valueOf(model.getValueAt(index, 3).toString());
      String date = String.valueOf(model.getValueAt(index, 4).toString());
     // String doing = String.valueOf(model.getValueAt(index, 5).toString());
      
      String OldRowData = ReNo+","+FromAddress+","+Note+","+ToName+","+date;
        System.out.println("stdadta="+OldRowData);
       
       jTextField33.setText(ReNo);
       jTextField32.setText(FromAddress);
       jTextField31.setText(Note);
       jTextField30.setText(ToName);
       jTextField26.setText(date);
      // jComboBox12.setSelectedItem(doing);
       
       
       
    
    return OldRowData;
    }
    
   public String SetVisitorsData(){
    
      // get the selected row
       int index = jTable6.getSelectedRow();

       TableModel model = jTable6.getModel();

      String Name = String.valueOf(model.getValueAt(index, 0).toString());
      String Phoneno = String.valueOf(model.getValueAt(index, 1).toString());
      String Id = String.valueOf(model.getValueAt(index, 2).toString());
      String Date = String.valueOf(model.getValueAt(index, 3).toString());
      String Intime = String.valueOf(model.getValueAt(index, 4).toString());
      String Outtime = String.valueOf(model.getValueAt(index, 5).toString());
      String Note = String.valueOf(model.getValueAt(index, 6).toString());
      String Purpose = String.valueOf(model.getValueAt(index, 7).toString());	

      String OldRowData = Name+","+Phoneno+","+Id+","+Date+","+Intime+","+Outtime+","+Note+","+Purpose;
      
       
       this.Name.setText(Name);
       this.PhoneNumber.setText(Phoneno);
       this.Id.setText(Id);
       this.Date.setText(Date);
       this.InTime.setText(Intime);
       this.OutTime.setText(Outtime);
       this.Note.setText(Note);
       this.Purpose.setText(Purpose);
       
       
       
    
    return OldRowData;
    }
    
    
    
    
    
    
    
    public void ClearPostal(){
    
    jTextField33.setText("");
   jTextField32.setText("");
    jTextField31.setText("");
    jTextField30.setText("");
    jTextField26.setText("");
    jComboBox12.setSelectedIndex(1);
    
    
    
    }
    
    
    
    
    public String getDate(){   //for getdate 

 
    LocalDate todaynow = LocalDate.now( ZoneId.of( "America/Montreal" ) ) ;// Create a date ob
    String outputDate = todaynow.toString() ; 
    //System.out.println(outputDate);                           // Display the current date
        
 return outputDate;
}


    
    
    
    public String SetComplaintData(){
    
      // get the selected row
       int index = jTable3.getSelectedRow();

       TableModel model = jTable3.getModel();

      String Actiontaken = String.valueOf(model.getValueAt(index, 0).toString());
      String Complainttype = String.valueOf(model.getValueAt(index, 1).toString());
      String Complaintby = String.valueOf(model.getValueAt(index, 2).toString());
      String Phoneno = String.valueOf(model.getValueAt(index, 3).toString());
      String Date = String.valueOf(model.getValueAt(index, 4).toString());
      String Discription = String.valueOf(model.getValueAt(index, 5).toString());

      String OldRowData = Actiontaken+","+Complainttype+","+Complaintby+","+Phoneno+","+Date+","+Discription;
      
       
       
       jTextField25.setText(Actiontaken);
       jComboBox11.setSelectedItem(Complainttype);
       jTextField27.setText(Complaintby);
       jTextField28.setText(Phoneno);
       jTextField29.setText(getDate());
       jTextArea5.setText(Discription);
       
       
    
       
    
    return OldRowData;
    }
    
    
    
    
    
    
    
    
    
    
    public Dashboard() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        DashboardIcon = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        AddAppointments = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel44 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        AppointmentView = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        AddPatients = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel28 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel34 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jButton37 = new javax.swing.JButton();
        AddMedicalOfficer = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel36 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        AddReceptionists = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jTextField20 = new javax.swing.JTextField();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel57 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jTextField23 = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jButton13 = new javax.swing.JButton();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        UsersView = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        CreateUser = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        AddComplaints = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        jLabel83 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabel86 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jComboBox11 = new javax.swing.JComboBox<>();
        jButton27 = new javax.swing.JButton();
        ComplaintsView = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jButton26 = new javax.swing.JButton();
        Reports = new javax.swing.JPanel();
        ReceivedMailView = new javax.swing.JPanel();
        jLabel90 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jButton28 = new javax.swing.JButton();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        AddPostal = new javax.swing.JPanel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jComboBox12 = new javax.swing.JComboBox();
        jTextField26 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField33 = new javax.swing.JTextField();
        jButton31 = new javax.swing.JButton();
        jButton32 = new javax.swing.JButton();
        jButton33 = new javax.swing.JButton();
        PatientsView = new javax.swing.JPanel();
        jLabel104 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jButton36 = new javax.swing.JButton();
        VisitorView = new javax.swing.JPanel();
        jLabel106 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jButton38 = new javax.swing.JButton();
        jButton39 = new javax.swing.JButton();
        jButton40 = new javax.swing.JButton();
        AddVisitor = new javax.swing.JPanel();
        jLabel107 = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        PhoneNumber = new javax.swing.JTextField();
        Id = new javax.swing.JTextField();
        Date = new javax.swing.JTextField();
        InTime = new javax.swing.JTextField();
        OutTime = new javax.swing.JTextField();
        Note = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        jButton41 = new javax.swing.JButton();
        jButton42 = new javax.swing.JButton();
        jButton43 = new javax.swing.JButton();
        jLabel115 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        Purpose = new javax.swing.JTextArea();
        jButton44 = new javax.swing.JButton();
        jLabel116 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();

        jFormattedTextField1.setText("jFormattedTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1219, 795));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(33, 152, 207));

        jLabel1.setFont(new java.awt.Font("Rage Italic", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("We care always");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(204, 204, 204));
        jLabel10.setFont(new java.awt.Font("Poor Richard", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Suwin Hospital");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_appointments pre.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel11MouseExited(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_postal-records pre.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel12MouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_complaint pre.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel13MouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_reports pre.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_visitors pre.png"))); // NOI18N
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel15))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(29, 29, 29)
                .addComponent(jLabel13)
                .addGap(26, 26, 26)
                .addComponent(jLabel15)
                .addGap(26, 26, 26)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 140, 250, 600);

        jLayeredPane1.setLayout(new java.awt.CardLayout());

        DashboardIcon.setBackground(new java.awt.Color(255, 255, 255));
        DashboardIcon.setLayout(null);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/useer.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        DashboardIcon.add(jLabel3);
        jLabel3.setBounds(60, 331, 200, 200);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/complaint.png"))); // NOI18N
        DashboardIcon.add(jLabel4);
        jLabel4.setBounds(357, 311, 230, 230);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/output-onlinepngtools (2).png"))); // NOI18N
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        DashboardIcon.add(jLabel5);
        jLabel5.setBounds(353, 10, 250, 223);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/appointments.png"))); // NOI18N
        DashboardIcon.add(jLabel6);
        jLabel6.setBounds(45, 11, 259, 230);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/repo edited.png"))); // NOI18N
        DashboardIcon.add(jLabel7);
        jLabel7.setBounds(670, 0, 230, 240);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/exit.png"))); // NOI18N
        DashboardIcon.add(jLabel8);
        jLabel8.setBounds(697, 338, 173, 194);

        jLabel64.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel64.setText("Appointments");
        DashboardIcon.add(jLabel64);
        jLabel64.setBounds(97, 247, 145, 41);

        jLabel65.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel65.setText("Patients");
        DashboardIcon.add(jLabel65);
        jLabel65.setBounds(440, 247, 145, 41);

        jLabel66.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel66.setText("Reports");
        DashboardIcon.add(jLabel66);
        jLabel66.setBounds(760, 250, 110, 41);

        jLabel67.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel67.setText("Users");
        jLabel67.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel67MouseEntered(evt);
            }
        });
        DashboardIcon.add(jLabel67);
        jLabel67.setBounds(121, 547, 145, 41);

        jLabel68.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel68.setText("Complaints");
        DashboardIcon.add(jLabel68);
        jLabel68.setBounds(430, 550, 145, 41);

        jLabel69.setFont(new java.awt.Font("Cambria Math", 1, 18)); // NOI18N
        jLabel69.setText("Exit");
        DashboardIcon.add(jLabel69);
        jLabel69.setBounds(746, 547, 87, 30);

        jLabel98.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel98MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel98MouseExited(evt);
            }
        });
        DashboardIcon.add(jLabel98);
        jLabel98.setBounds(30, 0, 260, 300);

        jLabel99.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel99MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel99MouseExited(evt);
            }
        });
        DashboardIcon.add(jLabel99);
        jLabel99.setBounds(340, 0, 280, 300);

        jLabel100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel100MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel100MouseExited(evt);
            }
        });
        DashboardIcon.add(jLabel100);
        jLabel100.setBounds(640, -10, 280, 310);

        jLabel101.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel101MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel101MouseExited(evt);
            }
        });
        DashboardIcon.add(jLabel101);
        jLabel101.setBounds(30, 320, 250, 270);

        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel102MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel102MouseExited(evt);
            }
        });
        DashboardIcon.add(jLabel102);
        jLabel102.setBounds(330, 300, 280, 290);

        jLabel103.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel103MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel103MouseExited(evt);
            }
        });
        DashboardIcon.add(jLabel103);
        jLabel103.setBounds(670, 300, 240, 280);

        jLayeredPane1.add(DashboardIcon, "card2");

        AddAppointments.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Add Apointment");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Patient:");

        jComboBox4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox4.setMaximumRowCount(10);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jComboBox4.setBorder(null);

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Medical Officer:");

        jComboBox5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox5.setMaximumRowCount(10);
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        jComboBox5.setBorder(null);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Symptoms:");

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Appointment Time:");

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Appointment Date:");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton3.setText("Save");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton11.setText("Clear");

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton5.setText("Update");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddAppointmentsLayout = new javax.swing.GroupLayout(AddAppointments);
        AddAppointments.setLayout(AddAppointmentsLayout);
        AddAppointmentsLayout.setHorizontalGroup(
            AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddAppointmentsLayout.createSequentialGroup()
                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddAppointmentsLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddAppointmentsLayout.createSequentialGroup()
                        .addGap(616, 616, 616)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(76, 76, 76))
            .addGroup(AddAppointmentsLayout.createSequentialGroup()
                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddAppointmentsLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddAppointmentsLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AddAppointmentsLayout.createSequentialGroup()
                                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField13)
                                        .addComponent(jTextField12)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(509, Short.MAX_VALUE))
        );
        AddAppointmentsLayout.setVerticalGroup(
            AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddAppointmentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(AddAppointmentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        jLayeredPane1.add(AddAppointments, "card3");

        AppointmentView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Appointments Records");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Patient", "Medical Officer", "Date", "Time", "Symptoms", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTable1MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(230);
            jTable1.getColumnModel().getColumn(1).setPreferredWidth(190);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(150);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(110);
            jTable1.getColumnModel().getColumn(4).setPreferredWidth(220);
            jTable1.getColumnModel().getColumn(5).setPreferredWidth(140);
        }

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AppointmentViewLayout = new javax.swing.GroupLayout(AppointmentView);
        AppointmentView.setLayout(AppointmentViewLayout);
        AppointmentViewLayout.setHorizontalGroup(
            AppointmentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AppointmentViewLayout.createSequentialGroup()
                .addGroup(AppointmentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
                    .addGroup(AppointmentViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        AppointmentViewLayout.setVerticalGroup(
            AppointmentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AppointmentViewLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(AppointmentViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jLayeredPane1.add(AppointmentView, "card4");

        AddPatients.setBackground(new java.awt.Color(255, 255, 255));

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel35.setText("Patients Details");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Name:");

        jTextField3.setToolTipText("");

        jComboBox1.setBackground(new java.awt.Color(136, 216, 216));
        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox1.setMaximumRowCount(2);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Gender:");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Mobile No:");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("NIC No:");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Date of Birth");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Address:");

        jComboBox2.setBackground(new java.awt.Color(136, 216, 216));
        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" }));

        jComboBox3.setBackground(new java.awt.Color(136, 216, 216));
        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox3.setMaximumRowCount(4);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Separated", "Divorced" }));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Status:");

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Blood Group:");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Allergies:");

        jButton6.setBackground(new java.awt.Color(114, 190, 190));
        jButton6.setText("Save");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(114, 190, 190));
        jButton7.setText("Clear");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("UserName:");

        jTextField7.setToolTipText("");

        jButton19.setBackground(new java.awt.Color(114, 190, 190));
        jButton19.setText("Update");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton37.setText("Update");
        jButton37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton37ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddPatientsLayout = new javax.swing.GroupLayout(AddPatients);
        AddPatients.setLayout(AddPatientsLayout);
        AddPatientsLayout.setHorizontalGroup(
            AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPatientsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddPatientsLayout.createSequentialGroup()
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddPatientsLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddPatientsLayout.createSequentialGroup()
                                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(AddPatientsLayout.createSequentialGroup()
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(AddPatientsLayout.createSequentialGroup()
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextField6))
                                        .addGroup(AddPatientsLayout.createSequentialGroup()
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel33, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AddPatientsLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83)
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(88, 88, 88))
                    .addGroup(AddPatientsLayout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddPatientsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))))
        );
        AddPatientsLayout.setVerticalGroup(
            AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPatientsLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddPatientsLayout.createSequentialGroup()
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddPatientsLayout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddPatientsLayout.createSequentialGroup()
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)))
                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddPatientsLayout.createSequentialGroup()
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AddPatientsLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(276, 276, 276)
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton37, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddPatientsLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AddPatientsLayout.createSequentialGroup()
                                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AddPatientsLayout.createSequentialGroup()
                                .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(123, 123, 123)))
                        .addGap(39, 39, 39)
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(AddPatientsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(59, 59, 59))
        );

        jLayeredPane1.add(AddPatients, "card5");

        AddMedicalOfficer.setBackground(new java.awt.Color(255, 255, 255));

        jLabel18.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel18.setText("Username:");

        jLabel19.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel19.setText("Name:");

        jComboBox6.setMaximumRowCount(2);
        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel20.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel20.setText("Gender:");

        jLabel22.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel22.setText("Phone No:");

        jLabel23.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel23.setText("ID No:");

        jLabel29.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel29.setText("Date of Birth:");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        jLabel36.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel36.setText("Address:");

        jComboBox7.setMaximumRowCount(4);
        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Separated", "Divorced" }));

        jLabel37.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel37.setText("Status:");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/resources/profile pic.jpg"))); // NOI18N

        jLabel39.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel39.setText("Profile Picture");

        jButton8.setText("Upload");

        jLabel40.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel40.setText("Staff ID:");

        jLabel41.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel41.setText("Staff Email:");

        jLabel42.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel42.setText("Date of Joining:");

        jLabel43.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel43.setText("Specialty Area:");

        jComboBox8.setMaximumRowCount(6);
        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allergists/Immunologists", "Anesthesiologists", "Cardiologists", "Colon and Rectal Surgeons", "Critical Care Medicine Specialists", "Family Physicians" }));

        jLabel48.setBackground(new java.awt.Color(255, 255, 255));
        jLabel48.setFont(new java.awt.Font("Sylfaen", 1, 14)); // NOI18N
        jLabel48.setText("Add Medical Officer");

        jButton9.setText("Update");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Save");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setText("Clear");

        javax.swing.GroupLayout AddMedicalOfficerLayout = new javax.swing.GroupLayout(AddMedicalOfficer);
        AddMedicalOfficer.setLayout(AddMedicalOfficerLayout);
        AddMedicalOfficerLayout.setHorizontalGroup(
            AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                        .addComponent(jTextField2))))
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(43, 43, 43)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                    .addComponent(jTextField8)
                                    .addComponent(jTextField10)
                                    .addComponent(jTextField11)))
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton8))
                                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                    .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(78, 78, 78))))
        );
        AddMedicalOfficerLayout.setVerticalGroup(
            AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addGap(86, 86, 86)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel38))
                                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton8))))
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                        .addGap(262, 262, 262)
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddMedicalOfficerLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
                            .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddMedicalOfficerLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddMedicalOfficerLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(AddMedicalOfficerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73))))
        );

        jLayeredPane1.add(AddMedicalOfficer, "card6");

        AddReceptionists.setBackground(new java.awt.Color(255, 255, 255));

        jLabel49.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel49.setText("Username:");

        jLabel50.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel50.setText("Name:");

        jComboBox9.setMaximumRowCount(2);
        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));

        jLabel51.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel51.setText("Gender:");

        jLabel52.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel52.setText("Phone No:");

        jLabel53.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel53.setText("ID No:");

        jLabel54.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel54.setText("Date of Birth:");

        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jScrollPane5.setViewportView(jTextArea4);

        jLabel55.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel55.setText("Address:");

        jLabel56.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel56.setText("Status:");

        jComboBox10.setMaximumRowCount(4);
        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Single", "Married", "Separated", "Divorced" }));

        jLabel57.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel57.setText("Date of Joining:");

        jLabel58.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel58.setText("Staff Mail:");

        jLabel59.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel59.setText("Staff ID:");

        jButton13.setText("Upload");

        jLabel60.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/resources/profile pic.jpg"))); // NOI18N

        jLabel61.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel61.setText("Profile Picture");

        jButton14.setText("Update");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Save");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Cancel");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel62.setText("Add Receptionist");

        javax.swing.GroupLayout AddReceptionistsLayout = new javax.swing.GroupLayout(AddReceptionists);
        AddReceptionists.setLayout(AddReceptionistsLayout);
        AddReceptionistsLayout.setHorizontalGroup(
            AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddReceptionistsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddReceptionistsLayout.createSequentialGroup()
                        .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AddReceptionistsLayout.createSequentialGroup()
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddReceptionistsLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AddReceptionistsLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField21)
                                .addComponent(jTextField20)
                                .addComponent(jTextField19)
                                .addComponent(jTextField18)
                                .addComponent(jTextField17)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddReceptionistsLayout.createSequentialGroup()
                                .addGap(175, 175, 175)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddReceptionistsLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton13)
                                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddReceptionistsLayout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(53, 53, 53))))))
        );
        AddReceptionistsLayout.setVerticalGroup(
            AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddReceptionistsLayout.createSequentialGroup()
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddReceptionistsLayout.createSequentialGroup()
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField20, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel55, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(95, 95, 95))
                    .addGroup(AddReceptionistsLayout.createSequentialGroup()
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(AddReceptionistsLayout.createSequentialGroup()
                                .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jButton13)))
                        .addGap(30, 30, 30)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(AddReceptionistsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
        );

        jLayeredPane1.add(AddReceptionists, "card7");

        UsersView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel63.setText("User Records");

        jTable2.setFont(new java.awt.Font("Microsoft Tai Le", 0, 12)); // NOI18N
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserType", " Username", "Name", "Gender", "Phone Numbe", "ID Card Number", "Date of Birth", "Address", "Marital Status", "Blood Group", "Allergies", "Staff Id", "Staff Mail", "Date of Joining", "Specility Area"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable2);

        jButton17.setText("Add");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("Edit");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton20.setText("Delete");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UsersViewLayout = new javax.swing.GroupLayout(UsersView);
        UsersView.setLayout(UsersViewLayout);
        UsersViewLayout.setHorizontalGroup(
            UsersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsersViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6)
                    .addGroup(UsersViewLayout.createSequentialGroup()
                        .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(687, Short.MAX_VALUE))))
        );
        UsersViewLayout.setVerticalGroup(
            UsersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UsersViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(UsersViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        jLayeredPane1.add(UsersView, "card8");

        CreateUser.setBackground(new java.awt.Color(255, 255, 255));
        CreateUser.setLayout(null);

        jLabel70.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel70.setText("Select UserType:");
        CreateUser.add(jLabel70);
        jLabel70.setBounds(22, 33, 218, 54);

        jLabel71.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/receptionist.jpg"))); // NOI18N
        jLabel71.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel71MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel71MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel71MouseExited(evt);
            }
        });
        CreateUser.add(jLabel71);
        jLabel71.setBounds(350, 150, 260, 256);

        jLabel72.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Patients.png"))); // NOI18N
        jLabel72.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel72MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel72MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel72MouseExited(evt);
            }
        });
        CreateUser.add(jLabel72);
        jLabel72.setBounds(681, 160, 220, 247);

        jLabel73.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/doctor.jpeg"))); // NOI18N
        jLabel73.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel73MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel73MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel73MouseExited(evt);
            }
        });
        CreateUser.add(jLabel73);
        jLabel73.setBounds(20, 140, 260, 267);

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_receptionist pre.png"))); // NOI18N
        jLabel74.setText("Receptionist");
        jLabel74.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel74MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel74MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel74MouseExited(evt);
            }
        });
        CreateUser.add(jLabel74);
        jLabel74.setBounds(380, 410, 210, 51);

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_medical-officer pre.png"))); // NOI18N
        jLabel75.setText("Medical Officer");
        jLabel75.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel75MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel75MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel75MouseExited(evt);
            }
        });
        CreateUser.add(jLabel75);
        jLabel75.setBounds(40, 410, 226, 51);

        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_patient pre.png"))); // NOI18N
        jLabel76.setText("Patient");
        jLabel76.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel76MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel76MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel76MouseExited(evt);
            }
        });
        CreateUser.add(jLabel76);
        jLabel76.setBounds(690, 410, 200, 51);

        jLabel77.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel77MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel77MouseExited(evt);
            }
        });
        CreateUser.add(jLabel77);
        jLabel77.setBounds(10, 123, 280, 350);

        jLabel78.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel78MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel78MouseExited(evt);
            }
        });
        CreateUser.add(jLabel78);
        jLabel78.setBounds(340, 120, 280, 350);

        jLabel79.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel79MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel79MouseExited(evt);
            }
        });
        CreateUser.add(jLabel79);
        jLabel79.setBounds(670, 120, 240, 350);

        jLayeredPane1.add(CreateUser, "card9");

        AddComplaints.setBackground(new java.awt.Color(255, 255, 255));

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setText("Add  Complaint");

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Action Taken");

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Complaints Type");

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setText("Complaints By");

        jTextField28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField28ActionPerformed(evt);
            }
        });

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel84.setText("Phone Number");

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel85.setText("Date");

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane7.setViewportView(jTextArea5);

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel86.setText("Discription");

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel87.setText("Daucument");

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel88.setText("Note");

        jButton21.setBackground(new java.awt.Color(215, 227, 242));
        jButton21.setText("Browse");

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton22.setText("Save");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton23.setText("Close");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jComboBox11.setMaximumRowCount(6);
        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Safety", "Quality", "Institutional issues", "Timing and access", "Communication", "Humaneness/caring", "Patient rights" }));

        jButton27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton27.setText("Update");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddComplaintsLayout = new javax.swing.GroupLayout(AddComplaints);
        AddComplaints.setLayout(AddComplaintsLayout);
        AddComplaintsLayout.setHorizontalGroup(
            AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddComplaintsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(AddComplaintsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddComplaintsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton27)
                        .addGap(18, 18, 18)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddComplaintsLayout.createSequentialGroup()
                                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                                        .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32)
                                        .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(32, 32, 32)
                                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(149, 149, 149)
                                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel88, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                                        .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jButton21))))
                            .addGroup(AddComplaintsLayout.createSequentialGroup()
                                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(164, Short.MAX_VALUE))))
        );
        AddComplaintsLayout.setVerticalGroup(
            AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddComplaintsLayout.createSequentialGroup()
                .addComponent(jLabel80, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel88, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel87, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton21))
                        .addGap(105, 105, 105))
                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                        .addComponent(jLabel81, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel83, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(16, 16, 16)
                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel84, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel85, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel86, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(AddComplaintsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(AddComplaintsLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46))
        );

        jLayeredPane1.add(AddComplaints, "card10");

        ComplaintsView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel89.setText("Complaints");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Action Taken", "Complaint Type", "Complaint By", "Phone No", "Date", "Description"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(jTable3);
        if (jTable3.getColumnModel().getColumnCount() > 0) {
            jTable3.getColumnModel().getColumn(0).setPreferredWidth(80);
            jTable3.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable3.getColumnModel().getColumn(5).setPreferredWidth(250);
        }

        jButton24.setText("Add");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Edit");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        jButton26.setText("Delete");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ComplaintsViewLayout = new javax.swing.GroupLayout(ComplaintsView);
        ComplaintsView.setLayout(ComplaintsViewLayout);
        ComplaintsViewLayout.setHorizontalGroup(
            ComplaintsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComplaintsViewLayout.createSequentialGroup()
                .addGroup(ComplaintsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ComplaintsViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComplaintsViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 930, Short.MAX_VALUE))
                .addContainerGap())
        );
        ComplaintsViewLayout.setVerticalGroup(
            ComplaintsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComplaintsViewLayout.createSequentialGroup()
                .addComponent(jLabel89, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ComplaintsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );

        jLayeredPane1.add(ComplaintsView, "card11");

        Reports.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout ReportsLayout = new javax.swing.GroupLayout(Reports);
        Reports.setLayout(ReportsLayout);
        ReportsLayout.setHorizontalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 940, Short.MAX_VALUE)
        );
        ReportsLayout.setVerticalGroup(
            ReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        jLayeredPane1.add(Reports, "card12");

        ReceivedMailView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel90.setText("Received Mails");

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Reference Number", " From Address", "Note", "To Name,", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(jTable4);

        jButton28.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton28.setText("Add");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jButton29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton29.setText("Edit");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton30.setText("Delete");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ReceivedMailViewLayout = new javax.swing.GroupLayout(ReceivedMailView);
        ReceivedMailView.setLayout(ReceivedMailViewLayout);
        ReceivedMailViewLayout.setHorizontalGroup(
            ReceivedMailViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceivedMailViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ReceivedMailViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ReceivedMailViewLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReceivedMailViewLayout.createSequentialGroup()
                        .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(707, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ReceivedMailViewLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jButton30)
                        .addGap(19, 19, 19))))
        );
        ReceivedMailViewLayout.setVerticalGroup(
            ReceivedMailViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ReceivedMailViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel90, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(251, 251, 251)
                .addGroup(ReceivedMailViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton29, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton30, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLayeredPane1.add(ReceivedMailView, "card13");

        AddPostal.setBackground(new java.awt.Color(255, 255, 255));

        jLabel91.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel91.setText("Postal Details");

        jLabel92.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel92.setText("Referenses Number");

        jLabel93.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel93.setText("From Address");

        jLabel94.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel94.setText("Note");

        jLabel95.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel95.setText("To Name");

        jLabel96.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel96.setText("Date");

        jLabel97.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel97.setText("Mail is");

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Received", "Dispatched" }));

        jTextField26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField26ActionPerformed(evt);
            }
        });

        jButton31.setText("Save");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        jButton32.setText("Update");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });

        jButton33.setText("Clear");

        javax.swing.GroupLayout AddPostalLayout = new javax.swing.GroupLayout(AddPostal);
        AddPostal.setLayout(AddPostalLayout);
        AddPostalLayout.setHorizontalGroup(
            AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPostalLayout.createSequentialGroup()
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddPostalLayout.createSequentialGroup()
                        .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddPostalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddPostalLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextField30, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(jTextField31)
                                .addComponent(jTextField32)
                                .addComponent(jTextField33)
                                .addComponent(jTextField26))
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 572, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddPostalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton32)
                        .addGap(18, 18, 18)
                        .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        AddPostalLayout.setVerticalGroup(
            AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddPostalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel91, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel92, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel93, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel94, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel95, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel96, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel97, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(AddPostalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton31, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton32, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton33, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jLayeredPane1.add(AddPostal, "card14");

        PatientsView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel104.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        jLabel104.setText("Patients Details");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Name", "Gender", "Phone No", "NIC No", "Date of Birth", "Address", "Status", "Blood Group", "Allergies"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane10.setViewportView(jTable5);
        if (jTable5.getColumnModel().getColumnCount() > 0) {
            jTable5.getColumnModel().getColumn(0).setPreferredWidth(60);
            jTable5.getColumnModel().getColumn(1).setPreferredWidth(100);
            jTable5.getColumnModel().getColumn(2).setPreferredWidth(50);
            jTable5.getColumnModel().getColumn(3).setPreferredWidth(60);
            jTable5.getColumnModel().getColumn(4).setPreferredWidth(67);
            jTable5.getColumnModel().getColumn(5).setPreferredWidth(60);
            jTable5.getColumnModel().getColumn(6).setPreferredWidth(100);
            jTable5.getColumnModel().getColumn(7).setPreferredWidth(60);
            jTable5.getColumnModel().getColumn(8).setPreferredWidth(50);
            jTable5.getColumnModel().getColumn(9).setPreferredWidth(120);
        }

        jButton34.setText("Edit");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jButton35.setText("Add");
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });

        jButton36.setText("Delete");
        jButton36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton36ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PatientsViewLayout = new javax.swing.GroupLayout(PatientsView);
        PatientsView.setLayout(PatientsViewLayout);
        PatientsViewLayout.setHorizontalGroup(
            PatientsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientsViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PatientsViewLayout.createSequentialGroup()
                .addGroup(PatientsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PatientsViewLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 909, Short.MAX_VALUE))
                    .addGroup(PatientsViewLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton36)))
                .addContainerGap())
        );
        PatientsViewLayout.setVerticalGroup(
            PatientsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientsViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel104, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(PatientsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton35, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton36, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jLayeredPane1.add(PatientsView, "card15");

        VisitorView.setBackground(new java.awt.Color(255, 255, 255));

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel106.setText("Visitors");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " Name", "NIC No", "Phone No", "Date", "In Time", "Out Time", "Note", "Purpose"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable6);

        jButton38.setText("Add");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });

        jButton39.setText("Edit");
        jButton39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton39ActionPerformed(evt);
            }
        });

        jButton40.setText("Delete");
        jButton40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton40ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VisitorViewLayout = new javax.swing.GroupLayout(VisitorView);
        VisitorView.setLayout(VisitorViewLayout);
        VisitorViewLayout.setHorizontalGroup(
            VisitorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisitorViewLayout.createSequentialGroup()
                .addGroup(VisitorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VisitorViewLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(VisitorViewLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 899, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(VisitorViewLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(jButton40)
                .addGap(7, 7, 7))
        );
        VisitorViewLayout.setVerticalGroup(
            VisitorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VisitorViewLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(VisitorViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton38, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton39, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton40, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(83, 83, 83))
        );

        jLayeredPane1.add(VisitorView, "card16");

        AddVisitor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel107.setText("Visitor Details");

        jLabel108.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel108.setText("Note:");

        jLabel109.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel109.setText("Out Time:");

        jLabel110.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel110.setText("In Time:");

        jLabel111.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel111.setText("ID Number:");

        jLabel112.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel112.setText("Phone Number:");

        jLabel113.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel113.setText("Name:");

        jLabel114.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel114.setText("Daucument:");

        jButton41.setBackground(new java.awt.Color(215, 227, 242));
        jButton41.setText("attach");

        jButton42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton42.setText("Save");
        jButton42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton42ActionPerformed(evt);
            }
        });

        jButton43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton43.setText("Cancel");
        jButton43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton43ActionPerformed(evt);
            }
        });

        jLabel115.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel115.setText("Purpose:");

        Purpose.setColumns(20);
        Purpose.setRows(5);
        jScrollPane12.setViewportView(Purpose);

        jButton44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton44.setText("Update");
        jButton44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton44ActionPerformed(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Microsoft Tai Le", 1, 14)); // NOI18N
        jLabel116.setText("Date:");

        javax.swing.GroupLayout AddVisitorLayout = new javax.swing.GroupLayout(AddVisitor);
        AddVisitor.setLayout(AddVisitorLayout);
        AddVisitorLayout.setHorizontalGroup(
            AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddVisitorLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddVisitorLayout.createSequentialGroup()
                        .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddVisitorLayout.createSequentialGroup()
                        .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddVisitorLayout.createSequentialGroup()
                                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddVisitorLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(AddVisitorLayout.createSequentialGroup()
                                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(AddVisitorLayout.createSequentialGroup()
                                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(OutTime, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(AddVisitorLayout.createSequentialGroup()
                                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(InTime, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(AddVisitorLayout.createSequentialGroup()
                                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(AddVisitorLayout.createSequentialGroup()
                                .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Note, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AddVisitorLayout.createSequentialGroup()
                                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddVisitorLayout.createSequentialGroup()
                                        .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddVisitorLayout.createSequentialGroup()
                                        .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(38, 38, 38)))
                                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton41)
                                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AddVisitorLayout.createSequentialGroup()
                                .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)))
                        .addGap(91, 91, 91))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddVisitorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        AddVisitorLayout.setVerticalGroup(
            AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddVisitorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel107, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel113, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AddVisitorLayout.createSequentialGroup()
                        .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Note, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddVisitorLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(PhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel115, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AddVisitorLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton41))
                .addGap(34, 34, 34)
                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OutTime, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(AddVisitorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton42, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton43, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton44, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jLayeredPane1.add(AddVisitor, "card17");

        getContentPane().add(jLayeredPane1);
        jLayeredPane1.setBounds(270, 140, 940, 600);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/user resized.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(33, 152, 207));

        jLabel9.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 72)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("WELCOME");

        jLabel105.setFont(new java.awt.Font("Segoe UI Black", 1, 24)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("Admin Panel");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel105, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(261, 261, 261))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel105, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 629, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel4);
        jPanel4.setBounds(-100, 20, 1320, 750);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        System.out.println("Hello Welcome!");
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AppointmentView.setVisible(false);
        AddPatients.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddComplaints.setVisible(false);
        AddReceptionists.setVisible(true);
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_appointments past.png")));
    }//GEN-LAST:event_jLabel11MouseEntered

    private void jLabel11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseExited
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_appointments pre.png")));
    }//GEN-LAST:event_jLabel11MouseExited

    private void jLabel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseEntered
       jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_postal-records past.png")));
    }//GEN-LAST:event_jLabel12MouseEntered

    private void jLabel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseExited
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_postal-records pre.png")));
    }//GEN-LAST:event_jLabel12MouseExited

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
       
       jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_complaint past.png")));
    }//GEN-LAST:event_jLabel13MouseEntered

    private void jLabel13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseExited
        
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_complaint pre.png")));
    }//GEN-LAST:event_jLabel13MouseExited

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_reports past.png")));
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_reports pre.png")));
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_visitors past.png")));
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_visitors pre.png")));
    }//GEN-LAST:event_jLabel15MouseExited

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String PatientName = jComboBox4.getSelectedItem().toString();
        String MedicalOfficerName = jComboBox5.getSelectedItem().toString();
        String AppointmetDate = jTextField12.getText();
        String AppointmentTime = jTextField13.getText();
        String Symptoms = jTextArea3.getText();

        appointments appointment=new appointments(PatientName, MedicalOfficerName, AppointmetDate, AppointmentTime, Symptoms);
        FileWrite AppointmentFile=new FileWrite();
        AppointmentFile.AddAppointments(appointment);
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(true);
        jButton5.setVisible(false);

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        
        
           detailsView("db\\Appointments.txt");
        
        
        try {
            
            getPatientsList();
            getMedicalOffList();
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(true);
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        try {
            jButton5.setVisible(false);
            jButton3.setVisible(true);
            getPatientsList();
            getMedicalOffList();
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        DashboardIcon.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddAppointments.setVisible(true);
        jButton5.setVisible(false);
        
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
       
      
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        try {
            
            UpdateAppointments();
            
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(true);
        jButton3.setVisible(true);
        jButton5.setVisible(false);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
      //Complaints
      ComplaintdetailsView("db\\Complaints.txt");
      
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        ComplaintsView.setVisible(true);
        
        
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
       //Hospital Name Back to Home page
       DashboardIcon.setVisible(true);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jTable1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MousePressed
        
    }//GEN-LAST:event_jTable1MousePressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            SetAppointmentData();
            DeleteAppointments();
            
             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

       // get selected row index

       try{
       int SelectedRowIndex = jTable1.getSelectedRow();
       model.removeRow(SelectedRowIndex);
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }
            
            JOptionPane.showConfirmDialog(null,
                "Record Deleted Successfully",
                "Done",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        SetAppointmentData();
       
        DashboardIcon.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddAppointments.setVisible(true);
        
       
       jButton3.setVisible(false);  //save
       jButton5.setVisible(true);    //update
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       
        String username = jTextField7.getText();
        String name     = jTextField3.getText();
        String gender   = jComboBox1.getSelectedItem().toString();
        String phoneno  =jTextField4.getText();
        String id  =jTextField5.getText();
        String dob  =jTextField6.getText();
        String address  =jTextArea1.getText();
        String status  =jComboBox3.getSelectedItem().toString();
        String bloodgroup = jComboBox2.getSelectedItem().toString();
        String allergies =  jTextField9.getText();
        
        Patients patients=new Patients(username, name, gender, phoneno, id,dob,address,status,bloodgroup,allergies);
        FileWrite PatientsFile=new FileWrite();
        PatientsFile.AddPatients(patients);
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        PatientsView.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        //patient on dashboard icon
        PatientsdetailsView("db\\patients.txt");
        
        
       AppointmentView.setVisible(false);
       CreateUser.setVisible(false); 
       AddAppointments.setVisible(false);
       AddReceptionists.setVisible(false);
       AddMedicalOfficer.setVisible(false);
       DashboardIcon.setVisible (false);
       UsersView.setVisible(false);
       ComplaintsView.setVisible(false);
       AddComplaints.setVisible(false);
       AddPatients.setVisible(false);
       AddPostal.setVisible(false);
       PatientsView.setVisible(true);
       
        
        
                
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            // Medical Officer's Update button
            UpdateMedicalOfficers();
            
            
           
            JOptionPane.showConfirmDialog(null,"Do you want to save changes?");
            
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        UsersView.setVisible(true);
        
           
        
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        
        String username = jTextField1.getText();
        String name     = jTextField2.getText();
        String gender   = jComboBox6.getSelectedItem().toString();
        String phoneno  =jTextField8.getText();
        String id  =jTextField10.getText();
        String dob  =jTextField11.getText();
        String address  =jTextArea2.getText();
        String status  =jComboBox7.getSelectedItem().toString();
        String staffid =jTextField14.getText();
        String staffmail = jTextField15.getText();
        String dateofjoin = jTextField16.getText();
        String specialarea = jComboBox8.getSelectedItem().toString();
        
        MedicalOfficers medicalofficer=new MedicalOfficers(username, name, gender, phoneno, id,dob,address,status,staffid,staffmail,dateofjoin,specialarea);
        FileWrite MedicaloffiFile=new FileWrite();
        MedicaloffiFile.AddMediofficers(medicalofficer);
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        UsersView.setVisible(true);
        
        

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        try {
            // Receptionist's upadate button

            UpdateReceptionists();
            
         JOptionPane.showConfirmDialog(null,"Do you want to save changes?");
         
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        UsersView.setVisible(true);
        
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        
        
        
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        //Receptionist's save button
        String username = jTextField17.getText();
        String name     = jTextField18.getText();
        String gender   = jComboBox9.getSelectedItem().toString();
        String phoneno  =jTextField19.getText();
        String id  =jTextField20.getText();
        String dob  =jTextField21.getText();
        String address  =jTextArea4.getText();
        String status  =jComboBox10.getSelectedItem().toString();
        String staffid =jTextField24.getText();
        String staffmail = jTextField23.getText();
        String dateofjoin = jTextField22.getText();
        
        
        Receptionists receptionist=new Receptionists(username, name, gender, phoneno, id,dob,address,status,staffid,staffmail,dateofjoin);
        FileWrite ReceptionistFile=new FileWrite();
        ReceptionistFile.AddReceptionists(receptionist);
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        UsersView.setVisible(true);
        
        
        
        
        
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        try {
            //UserView Table2

            UserDetailsView();
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        //UserdetailsView("db\\Receptionists.txt");
        //UserdetailsView("db\\MedicalOfficers.txt");
      AppointmentView.setVisible(false);
       AddPatients.setVisible(false);
       AddAppointments.setVisible(false);
       AddReceptionists.setVisible(false);
       AddMedicalOfficer.setVisible(false);
       DashboardIcon.setVisible (false);
       AddComplaints.setVisible(false);
       UsersView.setVisible(true);
      
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        //UserDetails Edit button
        EditUsers();
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
       // Update button Patient's
        try {
            
            UpdatePatients();
            
            //JOptionPane.showConfirmDialog(null,"Do you want to save changes?");
            
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        UsersView.setVisible(true);
        
           jButton6.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JOptionPane.showConfirmDialog(null,"Do you want to save changes?");
        
        
           
        
        
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // UserView Add Button
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        CreateUser.setVisible(true);
        
        
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jLabel75MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseEntered
        // Medical off create uset
       jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_medical-officer past.png")));
    }//GEN-LAST:event_jLabel75MouseEntered

    private void jLabel75MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseExited
        // TODO add your handling code here:
        
        jLabel75.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_medical-officer pre.png")));
    }//GEN-LAST:event_jLabel75MouseExited

    private void jLabel77MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseEntered
        // TODO add your handling code here:
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
    }//GEN-LAST:event_jLabel77MouseEntered

    private void jLabel77MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel77MouseExited
        // TODO add your handling code here:
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel77MouseExited

    private void jLabel74MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseEntered
        // TODO add your handling code here:
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_receptionist past.png")));
    }//GEN-LAST:event_jLabel74MouseEntered

    private void jLabel74MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseExited
        // TODO add your handling code here:
        jLabel74.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_receptionist pre.png")));
    }//GEN-LAST:event_jLabel74MouseExited

    private void jLabel71MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseEntered
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
    }//GEN-LAST:event_jLabel71MouseEntered

    private void jLabel78MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseEntered
        // TODO add your handling code here:
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
    }//GEN-LAST:event_jLabel78MouseEntered

    private void jLabel78MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel78MouseExited
        // TODO add your handling code here:
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel78MouseExited

    private void jLabel71MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseExited
        // TODO add your handling code here:
        jLabel78.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel71MouseExited

    private void jLabel76MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseEntered
        // TODO add your handling code here:
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_patient past.png")));
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
    }//GEN-LAST:event_jLabel76MouseEntered

    private void jLabel76MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseExited
        // TODO add your handling code here:
        jLabel76.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/button_patient pre.png")));
    }//GEN-LAST:event_jLabel76MouseExited

    private void jLabel79MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseEntered
        // TODO add your handling code here:
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
    }//GEN-LAST:event_jLabel79MouseEntered

    private void jLabel79MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel79MouseExited
        // TODO add your handling code here:
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel79MouseExited

    private void jLabel72MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseEntered
        // TODO add your handling code here:
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
    }//GEN-LAST:event_jLabel72MouseEntered

    private void jLabel72MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseExited
        // TODO add your handling code here:
        jLabel79.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel72MouseExited

    private void jLabel76MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel76MouseClicked
        // patient's user creation
      DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddPatients.setVisible(true);
        
       jButton19.setVisible(false);
       jButton37.setVisible(false);
       jButton6.setVisible(true);
    }//GEN-LAST:event_jLabel76MouseClicked

    private void jLabel72MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel72MouseClicked
        // Patient's userCreation label
       DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddPatients.setVisible(true);
        
       jButton19.setVisible(false);
       jButton37.setVisible(false);
       jButton6.setVisible(true);
    }//GEN-LAST:event_jLabel72MouseClicked

    private void jLabel74MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel74MouseClicked
        // Receptionist's user Creation
       DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddReceptionists.setVisible(true);
        
       jButton14.setVisible(false);
       jButton15.setVisible(true);
       
    }//GEN-LAST:event_jLabel74MouseClicked

    private void jLabel71MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel71MouseClicked
        // Receptionist's user Creation label
       DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddReceptionists.setVisible(true);
        
       jButton14.setVisible(false);
       jButton15.setVisible(true);
       
        
    }//GEN-LAST:event_jLabel71MouseClicked

    private void jLabel75MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel75MouseClicked
        // Medicalofficer's user Creation
       DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddMedicalOfficer.setVisible(true);
        
       jButton9.setVisible(false);
       jButton10.setVisible(true);
    }//GEN-LAST:event_jLabel75MouseClicked

    private void jLabel73MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseClicked
       // Medicalofficer's user Creation label
       DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddMedicalOfficer.setVisible(true);
        
       jButton9.setVisible(false);
       jButton10.setVisible(true);
    }//GEN-LAST:event_jLabel73MouseClicked

    private void jLabel73MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseEntered
        jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout past.png")));
    }//GEN-LAST:event_jLabel73MouseEntered

    private void jLabel73MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel73MouseExited
       jLabel77.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel73MouseExited

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        try {
            DeletePatients();
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jTextField28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField28ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        String  ActionTaken    =jTextField25.getText();
        String  ComplaintsType =jComboBox11.getSelectedItem().toString();
        String  ComplaintsBy   =jTextField27.getText();
        String  PhoneNumber    =jTextField28.getText();
        String  Date           =jTextField29.getText();
        String  Discription    =jTextArea5.getText();

        complaints complaint=new complaints(ActionTaken, ComplaintsType, ComplaintsBy, PhoneNumber, Date, Discription);
        FileWrite ComplaintFile=new FileWrite();
        ComplaintFile.AddComplaints(complaint);
        
       
        
        
        
       DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        ComplaintsView.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "do you really wanto close this appplication","select",JOptionPane.YES_NO_OPTION);
        if (a==0);
        System.exit(0);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // Complaints Add button
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddComplaints.setVisible(true);
        
        jTextField29.setText(getDate());
        jButton27.setVisible(false);
        jButton22.setVisible(true);
        
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // Complaint Edit button
        SetComplaintData();
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddComplaints.setVisible(true);
        
        jButton22.setVisible(false);
        jButton27.setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        try {
            // Complaints Update Button
            UpdateComplaints();
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        ComplaintsView.setVisible(true);
        
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // Complaints Delete Button
        try {
            SetComplaintData();
            DeleteComplaints();
            
             DefaultTableModel model = (DefaultTableModel) jTable3.getModel();

       // get selected row index

       try{
       int SelectedRowIndex = jTable3.getSelectedRow();
       model.removeRow(SelectedRowIndex);
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }
            
            JOptionPane.showConfirmDialog(null,
                "Record Deleted Successfully",
                "Done",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jTextField26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField26ActionPerformed

    private void jLabel98MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseEntered
        // Dashboard appointment label
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/layout past.png")));
    }//GEN-LAST:event_jLabel98MouseEntered

    private void jLabel98MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel98MouseExited
        // TODO add your handling code here:
        jLabel98.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel98MouseExited

    private void jLabel99MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseEntered
        jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/layout past.png")));
    }//GEN-LAST:event_jLabel99MouseEntered

    private void jLabel99MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel99MouseExited
       jLabel99.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel99MouseExited

    private void jLabel100MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseEntered
         jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/layout past.png")));
    }//GEN-LAST:event_jLabel100MouseEntered

    private void jLabel100MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel100MouseExited
         jLabel100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel100MouseExited

    private void jLabel67MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel67MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel67MouseEntered

    private void jLabel101MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseEntered
        jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/layout past.png")));
    }//GEN-LAST:event_jLabel101MouseEntered

    private void jLabel101MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel101MouseExited
       jLabel101.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel101MouseExited

    private void jLabel102MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseEntered
       jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/layout past.png")));
    }//GEN-LAST:event_jLabel102MouseEntered

    private void jLabel102MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseExited
       jLabel102.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel102MouseExited

    private void jLabel103MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseEntered
        jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/layout past.png")));
    }//GEN-LAST:event_jLabel103MouseEntered

    private void jLabel103MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel103MouseExited
       jLabel103.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hospital/opd/java/photoes/Buutons/medilayout pre.png")));
    }//GEN-LAST:event_jLabel103MouseExited

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        // Postal save button
       String ReNo=jTextField33.getText();
       String FromAddress=jTextField32.getText();
       String Note=jTextField31.getText();
       String ToName=jTextField30.getText();
       String  date  =jTextField26.getText();
       String  doing=jComboBox12.getSelectedItem().toString();
       
       
       postal postal=new postal(ReNo, FromAddress, Note, ToName, date);
       
       FileWrite mail=new FileWrite();
       if (doing=="Dispatched"){
           mail.AddDispatchedMail(postal);
           
       }
       if (doing=="Received"){
           mail.AddReceivedMail(postal);
           
           
    }//GEN-LAST:event_jButton31ActionPerformed
   
       DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        ReceivedMailView.setVisible(true);
        
       
       
       ClearPostal();
    }
    
    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        
        try {
            UpdateReceivedmailRecords();
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        ReceivedMailView.setVisible(true);
        
        ClearPostal();
        
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        //Postal Records
        ReceivedMaildetailsView("db\\DispatchedMail.txt");
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        ReceivedMailView.setVisible(true);
        
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        //Postal Add Button
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddPostal.setVisible(true);
        
        jButton32.setVisible(false);
        jButton31.setVisible(true);
        ClearPostal();
        
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        SetReceivedmailData();
        
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddPostal.setVisible(true);
        
        jButton31.setVisible(false);  //save
        jButton32.setVisible(true);    //update
        
        
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        try {
            SetReceivedmailData();
            DeletePostalRecords();
            
             DefaultTableModel model = (DefaultTableModel) jTable4.getModel();

       // get selected row index

       try{
       int SelectedRowIndex = jTable4.getSelectedRow();
       model.removeRow(SelectedRowIndex);
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }
            
            JOptionPane.showConfirmDialog(null,
                "Record Deleted Successfully",
                "Done",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddPatients.setVisible(true);
        
        jButton6.setVisible(true);
       jButton19.setVisible(false); //update
       jButton37.setVisible(false); //update 2
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        //Patient's view edit button
        EditPatients();
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddPatients.setVisible(true);
        
           jButton6.setVisible(false);    // Hide Save Button
           jButton19.setVisible(false);    //Show Update Button
           jButton37.setVisible(true);      //update2 
        
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton37ActionPerformed
        try {
            UpdatePatientsButton2();
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        PatientsView.setVisible(false);
        
        jButton37.setVisible(false);
        
        jButton19.setVisible(false);
        
    }//GEN-LAST:event_jButton37ActionPerformed

    private void jButton36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton36ActionPerformed
       
        try {
            EditPatients();
            DeletePatients2();
            
            
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         DefaultTableModel model = (DefaultTableModel) jTable5.getModel();

       // get selected row index
       
       try{
       int SelectedRowIndex = jTable5.getSelectedRow();
       model.removeRow(SelectedRowIndex);
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }
            
            JOptionPane.showConfirmDialog(null,
                "Record Deleted Successfully",
                "Done",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_jButton36ActionPerformed

    private void jButton42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton42ActionPerformed
        String name=Name.getText();
        String id=Id.getText();
        String phoneNo=PhoneNumber.getText();
        String date = Date.getText();
        String inTime=InTime.getText();
        String outTime=OutTime.getText();
        String note=Note.getText();
        String purpose =Purpose.getText();
        System.out.println("Name --"+name + id +phoneNo+ date + inTime +outTime+note+purpose);

        Visiters visiter;
        visiter=new Visiters(name, id, phoneNo,date , inTime, outTime, note, purpose);

        FileWrite vi=new FileWrite();
        vi.addvisiter(visiter);
        
        
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        VisitorView.setVisible(true);
        
           
    }//GEN-LAST:event_jButton42ActionPerformed

    private void jButton43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton43ActionPerformed
        int a=JOptionPane.showConfirmDialog(null, "do you really wanto close this appplication","select",JOptionPane.YES_NO_OPTION);
        if (a==0);
        System.exit(0);
    }//GEN-LAST:event_jButton43ActionPerformed

    private void jButton44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton44ActionPerformed
        try {
            //Visitor update button
            UpdateVisitorRecords();
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
      
           UsersView.setVisible(false);
           AddAppointments.setVisible(false);
           AppointmentView.setVisible(false);
           AddPatients.setVisible(false);
           AddReceptionists.setVisible(false);
           AddMedicalOfficer.setVisible(false);
           AddComplaints.setVisible(false);
           AddPatients.setVisible(false);
           DashboardIcon.setVisible(false);
           AddComplaints.setVisible(false);
           CreateUser.setVisible(false);
           AddPostal.setVisible(false);
           ComplaintsView.setVisible(false);
           PatientsView.setVisible(false);
           AddVisitor.setVisible(false);
           VisitorView.setVisible(true);
           
           
      
      
    }//GEN-LAST:event_jButton44ActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        
           DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        Reports.setVisible(false);
        AppointmentView.setVisible(false);
        AddVisitor.setVisible(true);
        
           jButton44.setVisible(false); //update button
           jButton42.setVisible(true);
           
        
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jLabel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseClicked
        // Visitor button
        VisitorsdetailsView("db\\Visiters.txt");
        
           UsersView.setVisible(false);
           AddAppointments.setVisible(false);
           AppointmentView.setVisible(false);
           AddPatients.setVisible(false);
           AddReceptionists.setVisible(false);
           AddMedicalOfficer.setVisible(false);
           AddComplaints.setVisible(false);
           AddPatients.setVisible(false);
           DashboardIcon.setVisible(false);
           AddComplaints.setVisible(false);
           CreateUser.setVisible(false);
           AddPostal.setVisible(false);
           ComplaintsView.setVisible(false);
           PatientsView.setVisible(false);
           AddVisitor.setVisible(false);
           VisitorView.setVisible(true);
           
    }//GEN-LAST:event_jLabel15MouseClicked

    private void jButton39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton39ActionPerformed
        // TODO add your handling code here:
        
        SetVisitorsData();
           UsersView.setVisible(false);
           AddAppointments.setVisible(false);
           AppointmentView.setVisible(false);
           AddPatients.setVisible(false);
           AddReceptionists.setVisible(false);
           AddMedicalOfficer.setVisible(false);
           AddComplaints.setVisible(false);
           AddPatients.setVisible(false);
           DashboardIcon.setVisible(false);
           AddComplaints.setVisible(false);
           CreateUser.setVisible(false);
           AddPostal.setVisible(false);
           ComplaintsView.setVisible(false);
           PatientsView.setVisible(false);
           VisitorView.setVisible(false);
           AddVisitor.setVisible(true);
           jButton42.setVisible(false); //hide the save button
           jButton44.setVisible(true);  // show update button
           
        
    }//GEN-LAST:event_jButton39ActionPerformed

    private void jButton40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton40ActionPerformed
        // Delete button in Visitors
        
        try {
            SetVisitorsData();
            DeleteVisitorsRecords();
            
             DefaultTableModel model = (DefaultTableModel) jTable6.getModel();

       // get selected row index

       try{
       int SelectedRowIndex = jTable6.getSelectedRow();
       model.removeRow(SelectedRowIndex);
       }catch(Exception ex)
       {
           JOptionPane.showMessageDialog(null, ex);
       }
            
            JOptionPane.showConfirmDialog(null,
                "Record Deleted Successfully",
                "Done",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton40ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        DashboardIcon.setVisible(false);
        AddAppointments.setVisible(false);
        AddMedicalOfficer.setVisible(false);
        AddPatients.setVisible(false);
        AddComplaints.setVisible(false);
        AddPostal.setVisible(false);
        AddVisitor.setVisible(false);
        AddReceptionists.setVisible(false);
        PatientsView.setVisible(false);
        UsersView.setVisible(false);
        ComplaintsView.setVisible(false);
        VisitorView.setVisible(false);
        ReceivedMailView.setVisible(false);
        CreateUser.setVisible(false);
        AppointmentView.setVisible(false);
        Reports.setVisible(true);
        
    }//GEN-LAST:event_jLabel14MouseClicked
       
   
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Dashboard().setVisible(true);
            
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AddAppointments;
    public static javax.swing.JPanel AddComplaints;
    public static javax.swing.JPanel AddMedicalOfficer;
    public static javax.swing.JPanel AddPatients;
    public static javax.swing.JPanel AddPostal;
    public static javax.swing.JPanel AddReceptionists;
    public static javax.swing.JPanel AddVisitor;
    private javax.swing.JPanel AppointmentView;
    public static javax.swing.JPanel ComplaintsView;
    public static javax.swing.JPanel CreateUser;
    private javax.swing.JPanel DashboardIcon;
    public static javax.swing.JTextField Date;
    private javax.swing.JTextField Id;
    private javax.swing.JTextField InTime;
    private javax.swing.JTextField Name;
    private javax.swing.JTextField Note;
    private javax.swing.JTextField OutTime;
    public static javax.swing.JPanel PatientsView;
    private javax.swing.JTextField PhoneNumber;
    private javax.swing.JTextArea Purpose;
    public static javax.swing.JPanel ReceivedMailView;
    public static javax.swing.JPanel Reports;
    public static javax.swing.JPanel UsersView;
    public static javax.swing.JPanel VisitorView;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    public static javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton36;
    private javax.swing.JButton jButton37;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton39;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton40;
    private javax.swing.JButton jButton41;
    private javax.swing.JButton jButton42;
    private javax.swing.JButton jButton43;
    private javax.swing.JButton jButton44;
    private javax.swing.JButton jButton5;
    public static javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JFormattedTextField jFormattedTextField1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    public static javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    public static javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
