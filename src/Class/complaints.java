/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;

/**
 *
 * @author Rumesh
 */
public class complaints {
    
   String  ActionTaken;
   String  ComplaintsType;

    public complaints(String ActionTaken, String ComplaintsType, String ComplaintsBy, String PhoneNumber, String Date, String Discription) {
        this.ActionTaken = ActionTaken;
        this.ComplaintsType = ComplaintsType;
        this.ComplaintsBy = ComplaintsBy;
        this.PhoneNumber = PhoneNumber;
        this.Date = Date;
        this.Discription = Discription;
    }
   String  ComplaintsBy;   
   String  PhoneNumber;
   String  Date;
   String  Discription;        

    public String getActionTaken() {
        return ActionTaken;
    }

    public void setActionTaken(String ActionTaken) {
        this.ActionTaken = ActionTaken;
    }

    public String getComplaintsType() {
        return ComplaintsType;
    }

    public void setComplaintsType(String ComplaintsType) {
        this.ComplaintsType = ComplaintsType;
    }

    public String getComplaintsBy() {
        return ComplaintsBy;
    }

    public void setComplaintsBy(String ComplaintsBy) {
        this.ComplaintsBy = ComplaintsBy;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public String getDiscription() {
        return Discription;
    }

    public void setDiscription(String Discription) {
        this.Discription = Discription;
    }
    
}
