/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;


public class Visiters {
   private String Name;
   private String Id;
   private String PhoneNo;
   private String InTime;
   private String OutTime;
   private String Note;

    public Visiters(String Name, String Id, String PhoneNo, String InTime, String OutTime, String Note) {
        this.Name = Name;
        this.Id = Id;
        this.PhoneNo = PhoneNo;
        this.InTime = InTime;
        this.OutTime = OutTime;
        this.Note = Note;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getInTime() {
        return InTime;
    }

    public void setInTime(String InTime) {
        this.InTime = InTime;
    }

    public String getOutTime() {
        return OutTime;
    }

    public void setOutTime(String OutTime) {
        this.OutTime = OutTime;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

}