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
public class PersonClass {
    
    protected String username;
    protected String password;
    protected String name;
    
    public PersonClass(String username, String password, String name){
    this.username = username;
    this.password = password;
    this.name = name;
    }
}
