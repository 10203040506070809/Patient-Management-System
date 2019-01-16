/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patient.management.system;
import java.io.*;
/**
 *A base user class that all roles inherit from that contains a username, password and name with their respective setters and getters.
 * @author jflet
 */
public class PersonClass implements Serializable{

    /**
     * the persons username
     * 
     */
    protected String username;

    /**
     * persons password
     */
    protected String password;

    /**
     * persons name
     */
    protected String name;
    
    /**
     * getter for the persons username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username   setter for the persons username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getter for the persons password
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * setter for the persons password
     * @param password   
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * getter for the persons name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name setter for the persons name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
public String toString(){
   
    return name;
}
}
