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
    
    protected int age;
    protected String gender;
    protected String notes;
    protected String history;
    protected String medicines;
    
public PatientClass(String username, String password, String name, int age, String gender, String notes, String history, String medicines)
{
    //calls super class 
  
this.username = username;
this.password = password;
this.name = name;
this.gender = gender;
this.notes = notes;
this.history = history;
this.medicines = medicines;
}

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }




}
