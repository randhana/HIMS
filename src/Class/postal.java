/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Class;


public class postal {
    String ReferensesNumber;
    String FromAddress;

    public String getReferensesNumber() {
        return ReferensesNumber;
    }

    public void setReferensesNumber(String ReferensesNumber) {
        this.ReferensesNumber = ReferensesNumber;
    }

    public String getFromAddress() {
        return FromAddress;
    }

    public void setFromAddress(String FromAddress) {
        this.FromAddress = FromAddress;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String Note) {
        this.Note = Note;
    }

    public String getToName() {
        return ToName;
    }

    public void setToName(String ToName) {
        this.ToName = ToName;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }
    String Note;
    String ToName;
    String Date;

    public postal(String ReferensesNumber, String FromAddress, String Note, String ToName, String Date) {
        this.ReferensesNumber = ReferensesNumber;
        this.FromAddress = FromAddress;
        this.Note = Note;
        this.ToName = ToName;
        this.Date = Date;
    }
    
}
