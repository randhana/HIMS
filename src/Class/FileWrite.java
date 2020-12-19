/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author Rumesh
 */
public class FileWrite {
    private static final String fileparth1="db\\Visiters.txt";
    private static final String fileparth2="db\\ReceivedMail.txt";
    private static final String fileparth3="db\\dispatchedMail.txt";
     private static final String fileparth4="db\\Complaints.txt";
    FileWriter fr=null;
    BufferedWriter bw=null;
    public Boolean addvisiter(Visiters vr){
        
        PrintWriter pw=null;
        String VisiterData = " ,"+vr.getName()+","+vr.getId()+vr.getPhoneNo()+","+vr.getInTime()+","+vr.getOutTime()+"     /"+vr.getNote();
        try {
            pw=new PrintWriter(new BufferedWriter(new FileWriter(fileparth1,true)));
            pw.println(VisiterData);
            pw.close();
            JOptionPane.showConfirmDialog(null,"details are store");
        } catch (IOException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
        
        
        return true;
        
    }
     public Boolean AddReceivedMail(postal postal){
        
        PrintWriter pw=null;
        String ReceivedMail = " ,"+postal.getReferensesNumber()+","+postal.getFromAddress()+postal.Note+","+postal.ToName+","+postal.getDate();
        try {
            pw=new PrintWriter(new BufferedWriter(new FileWriter(fileparth2,true)));
            pw.println(ReceivedMail);
            pw.close();
            JOptionPane.showConfirmDialog(null,"details are store");
        } catch (IOException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
        
        
        return true;
     }
      public Boolean AddDispatchedMail(postal postal){
        
        PrintWriter pw=null;
        String DispatchedMail = " ,"+postal.getReferensesNumber()+","+postal.getFromAddress()+postal.Note+","+postal.ToName+","+postal.getDate();
        try {
            pw=new PrintWriter(new BufferedWriter(new FileWriter(fileparth3,true)));
            pw.println(DispatchedMail);
            pw.close();
            JOptionPane.showConfirmDialog(null,"details are store");
        } catch (IOException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
        
        
        return true;
     }
    
     public Boolean AddComplaints(complaints complaints){
        
        PrintWriter pw=null;
        String ComplaintsDetails = complaints.getComplaintsType()+","+complaints.getComplaintsBy()+complaints.getPhoneNumber()+","+complaints.getDate()+","+complaints.getActionTaken()+","+complaints.getDiscription();
        try {
            pw=new PrintWriter(new BufferedWriter(new FileWriter(fileparth4,true)));
            pw.println(ComplaintsDetails);
            pw.close();
            JOptionPane.showConfirmDialog(null,"details are store");
        } catch (IOException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
                
        
        
        return true;
     }
    
}
