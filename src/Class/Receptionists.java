
package Class;


public class Receptionists {
    
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
     
 
      

    public Receptionists(String username, String name, String gender, String phoneno, String id, String dob, String address, String status, String staffId, String staffEmail,String dateofJoining ) {
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
        
    }

    
    

    public String getRecepUserName() {
        return username;
    }

    public String getReceptName() {
        
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
    
    
    
    
    
    
    
    
    
}
