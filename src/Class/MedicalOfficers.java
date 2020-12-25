/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

public class MedicalOfficers {
      private  String username;
      private  String name;
      private  String gender;
      private  String phoneno;
      private  String id;

      private  String dob;
      private  String address;
      private  String status;
      private  String staffId;
      private  String staffEmail;
      private  String dateofJoining;
      private  String specialtyArea;
 
      

    public MedicalOfficers(String username, String name, String gender, String phoneno, String id, String dob, String address, String status, String staffId, String staffEmail,String dateofJoining,String specialtyArea ) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.phoneno = phoneno;
        this.id =id;
        this.dob = dob;
        this.address = address;
        this.status = status;
        this.staffId = staffId;
        this.staffEmail = staffEmail;
        this.dateofJoining = dateofJoining;
        this.specialtyArea = specialtyArea;
    }

    
    

    public String getMediUserName() {
        return username;
    }

    public String getMeditName() {
        
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getPhono() {
        
        return phoneno;
    }

    public String getDOB() {
        return dob;
    }
    
    public String getId() {
        return id;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getStaffId() {
        return staffId;
    }
    
    public String getStaffMail() {
        return staffEmail;
    }
    
    public String getDateofjoin() {
        return dateofJoining;
    }
    
    
    public String getSpecialityarea() {
        return specialtyArea;
    }
    
    
       
    
    
    
    
    
    
    
    
    
    
    
    
}
