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
public class DoctorClass extends PersonClass {

    /**
     * an integer rating that is used to signify the doctors ability/performance
     */
    protected int rating;

    /**
     * feedback given to the doctor by a patient or administrator
     */
    protected String feedback;

    /**
     *takes in a set of parameters and uses them to create a doctor object
     * @param username    
     * @param password
     * @param name
     * @param rating
     * @param feedback
     */
    public DoctorClass(String username, String password, String name, int rating, String feedback)
{
  
   
this.username = username;
this.password = password;
this.name = name;
this.feedback = feedback;
this.rating = rating;
}


    /**
     *
     * @return    getter for the doctors rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * setter for the doctors rating
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *    getter for the doctors feedback
     * @return
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     * setter for the doctors feedback
     * @param feedback
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


}
