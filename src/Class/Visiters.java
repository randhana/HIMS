
package Class;


public class Visiters {
   private String Name;
   private String Id;
   private String PhoneNo;
   private String Date;
   private String InTime;
   private String OutTime;
   private String Note;
   private String Purpose;

    public Visiters(String Name, String Id, String PhoneNo,String Date, String InTime, String OutTime, String Note, String Purpose) {
        this.Name = Name;
        this.Id = Id;
        this.PhoneNo = PhoneNo;
        this.Date =Date;
        this.InTime = InTime;
        this.OutTime = OutTime;
        this.Note = Note;
        this.Purpose = Purpose;
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
    public String getDate(){
        return Date;
    }
    public void setDate(String Date){
        this.Date = Date;
    
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
    public String getPurpose(){
        return Purpose;
    }
    public void setPurpose(String Purpose){
         this.Purpose = Purpose;
    }
    public void setNote(String Note) {
        this.Note = Note;
    }

}