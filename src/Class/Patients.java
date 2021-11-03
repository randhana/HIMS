/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author KODITHUWAKKU
 */
public class Patients {
      private  String username;
      private  String name;
      private  String gender;
      private  String phoneno;
      private  String id;

      private  String dob;
      private  String address;
      private  String status;
      private  String bloodgroup;
      private  String allergies;

    public Patients(String username, String name, String gender, String phoneno, String id, String dob, String address, String status, String bloodgroup, String allergies) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.phoneno = phoneno;
        this.id =id;
        this.dob = dob;
        this.address = address;
        this.status = status;
        this.bloodgroup = bloodgroup;
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        
        //return "Patent{" + "username=" + username + ", name=" + name + ", gender=" + gender + ", phoneno=" + phoneno + ", dob=" + dob + ", address=" + address + ", status=" + status + ", bloodgroup=" + bloodgroup + ", allergies=" + allergies + '}';
        return username + "," +name + "," + gender + "," + phoneno + "," + dob + "," + address + "," +status + "," + bloodgroup + "," + allergies ;
    }

    public String getPatientUserName() {
        return username;
    }

    public String getPatientName() {
        
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
    
    public String getBloodgroup() {
        return bloodgroup;
    }
    
    public String getAllergies() {
        return allergies;
    }
    
    
    
    
      
}
