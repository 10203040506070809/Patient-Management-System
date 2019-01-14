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




}
