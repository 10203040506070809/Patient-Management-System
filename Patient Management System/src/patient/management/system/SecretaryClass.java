/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient.management.system;

/**
 *This is inherited from the person class and has no extra functionality to it. 
 * @author jflet
 */
public class SecretaryClass extends PersonClass {

    /**
     *These are inherited from the person class and follow the same functionality;
     * @param username - The secretaries username.
     * @param password - The secretaries password.
     * @param name - The secretaries name.
     */
    public SecretaryClass(String username, String password, String name)
{
    //calls super class 
    
this.username = username;
this.password = password;
this.name = name;
}
}
