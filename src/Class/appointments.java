/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import hospital.opd.java.AddAppointment;
import hospital.opd.java.Dashboard;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ruser
 */
public class appointments {
    
        String AppointmetDate;
        String AppointmentTime;
        String Symptoms;
        String PatientName;
        String MedicalOfficerName;

    public appointments(String PatientName, String MedicalOfficerName, String AppointmetDate, String AppointmentTime, String Symptoms) {
        this.PatientName = PatientName;
        this.MedicalOfficerName = MedicalOfficerName;
        this.AppointmetDate = AppointmetDate;
        this.AppointmentTime = AppointmentTime;
        this.Symptoms = Symptoms;
       
    }

    
         

    public String getPatientName() {
        return PatientName;
    }

    public String getMedicalOfficerName() {
        this.MedicalOfficerName = MedicalOfficerName;
        return MedicalOfficerName;
    }

    public String getAppointmetDate() {
        return AppointmetDate;
    }

    public String getAppointmentTime() {
        this.AppointmentTime = AppointmentTime;
        return AppointmentTime;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    
    
    
    
}
