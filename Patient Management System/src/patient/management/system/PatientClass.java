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
public PatientClass(String username, String password, String name)
{
    //calls super class 
    super(username, password, name);
this.username = username;
this.password = password;
this.name = name;
}
}
