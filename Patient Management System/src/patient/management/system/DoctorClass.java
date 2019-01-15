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
     *
     */
    protected int rating;

    /**
     *
     */
    protected String feedback;

    /**
     *
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
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     */
    public String getFeedback() {
        return feedback;
    }

    /**
     *
     * @param feedback
     */
    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }


}
