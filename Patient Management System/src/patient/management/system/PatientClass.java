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
     *
     */
    protected int age;

    /**
     *
     */
    protected String gender;

    /**
     *
     */
    protected String notes;

    /**
     *
     */
    protected String history;

    /**
     *
     */
    protected String medicines;

    /**
     *
     */
    protected String appointment;

    protected String prescription;
     /* 
   
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
    public PatientClass(String username, String password, String name, int age, String gender, String notes, String history, String medicines, String appointment , String prescription)
{
    //calls super class 
  
this.username = username;
this.password = password;
this.name = name;
this.gender = gender;
this.notes = notes;
this.history = history;
this.medicines = medicines;
this.appointment = appointment;
this.prescription = prescription;
}

    /**
     *
     * @return
     */
    public int getAge() {
        return age;
    }

    /**
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    public String getGender() {
        return gender;
    }

    /**
     *
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     *
     * @return
     */
    public String getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     */
    public void setNotes(String notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     */
    public String getHistory() {
        return history;
    }

    /**
     *
     * @param history
     */
    public void setHistory(String history) {
        this.history = history;
    }

    /**
     *
     * @return
     */
    public String getMedicines() {
        return medicines;
    }

    /**
     *
     * @param medicines
     */
    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    /**
     *
     * @return
     */
    public String getAppointment() {
        return appointment;
    }

    /**
     *
     * @param appointment
     */
    public void setAppointment(String appointment) {
        this.appointment = appointment;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }




}
