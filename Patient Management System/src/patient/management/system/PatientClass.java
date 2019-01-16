/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient.management.system;

/**
 *
 * @author jflet
 */    
public class PatientClass extends PersonClass {
    
    /**
     * variable to store the patients age, taken at creation
     */
    protected int age;

    /**
     * variable to store the patients gender, taken at creation
     */
    protected String gender;

    /**
     * variable to store the patients notes, to be edited by a doctor during an appointment
     */
    protected String notes;

    /**
     * variable to store the patients history, to be viewable by both the patient and their doctor
     */
    protected String history;

    /**
     * a string to contain the current medications the patient is in possession of
     */
    protected String medicines;

    /**
     * a string to contain the appointments the patient has 
     */
    protected String appointment;

    
    /**
     * a string to contain the prescription the doctor has given them, to be shown to a secretary and be given medicines in return
     */
    
    protected String prescription;
     /* 
    parameters to be used in creation of a patient object
     *
     * @param username
     * @param password
     * @param name
     * @param age
     * @param gender
     * @param notes
     * @param history
     * @param medicines
     * @param appointment
     */

    /**
     *
     * @param username
     * @param password
     * @param name
     * @param age
     * @param gender
     * @param notes
     * @param history
     * @param medicines
     * @param appointment
     * @param prescription
     */

    public PatientClass(String username, String password, String name, int age, String gender, String notes, String history, String medicines, String appointment , String prescription)
{
    //calls super class 
  
this.username = username;
this.password = password;
this.age = age;
this.name = name;
this.gender = gender;
this.notes = notes;
this.history = history;
this.medicines = medicines;
this.appointment = appointment;
this.prescription = prescription;
}

    /**
     * getter for patient age
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     * setter for patient age
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * getter for patient gender
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     * setter for patient gender
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *getter for patient notes
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     * setter for patient notes
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     * getter for patient history
     * @return
     */
    public String getHistory() {
        return history;
    }

    /**
     * setter for patient history
     * @param history
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     * getter for patient medicines
     * @return
     */
    public String getMedicines() {
        return medicines;
    }

    /**
     * setter for patient medicines
     * @param medicines
     */
    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    /**
     * getter for patient appointments
     * @return
     */
    public String getAppointment() {
        return appointment;
    }

    /**
     * setter for patient appointments
     * @param appointment
     */
    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    /**
     *  getter for patient script
     * @return 
     */
    
    public String getPrescription() {
        return prescription;
    }
/**
 *  setter for patient script
 * @param prescription 
 */
    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }




}
