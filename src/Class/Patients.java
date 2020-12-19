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
      private  int phoneno;

      private  int dob;
      private  String address;
      private  String status;
      private  String bloodgroup;
      private  String allergies;

    public Patients(String username, String name, String gender, int phoneno, int dob, String address, String status, String bloodgroup, String allergies) {
        this.username = username;
        this.name = name;
        this.gender = gender;
        this.phoneno = phoneno;

        this.dob = dob;
        this.address = address;
        this.status = status;
        this.bloodgroup = bloodgroup;
        this.allergies = allergies;
    }

    @Override
    public String toString() {
        return "Patent{" + "username=" + username + ", name=" + name + ", gender=" + gender + ", phoneno=" + phoneno + ", dob=" + dob + ", address=" + address + ", status=" + status + ", bloodgroup=" + bloodgroup + ", allergies=" + allergies + '}';
    }

    
    
    
    
      
}
