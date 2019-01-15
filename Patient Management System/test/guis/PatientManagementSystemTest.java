/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import patient.management.system.AdminClass;
import patient.management.system.DoctorClass;
import patient.management.system.PatientClass;
import patient.management.system.SecretaryClass;

/**
 *
 * @author jflet
 */
public class PatientManagementSystemTest {
                List<PatientClass> testpatients = new ArrayList<PatientClass>();
    List<DoctorClass> testdoctors = new ArrayList<DoctorClass>();
    List<AdminClass> testadmins = new ArrayList<AdminClass>();
    List<SecretaryClass> testsecretarys = new ArrayList<SecretaryClass>();
    public PatientManagementSystemTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() {

        
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testLoginButtonOnClick() {
        testdoctors.add(new DoctorClass("D2", "password", "name", 5, "feedback"));
assertEquals(testdoctors.get(0).getUsername(), ("D2"));
    }

    @Test
    public void testRegisterOnClick() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testLogOffButtonOnClick() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testApprovePatient() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testDoctorFeedbackSelect() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testConfirmFeedback() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testRequestAppointmentBtn() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testRequestAccountTermination() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testTerminateAccounts() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testRemoveDoctor() {
                testdoctors.add(new DoctorClass("D2", "password", "name", 5, "feedback"));
                System.out.println("new Doctor added" + testdoctors.get(0).getUsername());
                testdoctors.remove(0);
assertTrue("testdoctors should be empty.", testdoctors.isEmpty());

    }

    @Test
    public void testCreateAdmin() {
        
       testadmins.add(new AdminClass("A1", "password", "username"));
       testdoctors.add(new DoctorClass("D1", "password", "name", 5, "feedback"));
        for (int i = 0; i < testadmins.size(); i++) {
            
        //check that admin is created
       assertEquals("testadmins.get(i) should equal A1", testadmins.get(i).getUsername(), ("A1"));                            
            }
        for (int j = 0; j < testadmins.size(); j++) {
                assertEquals("testdoctors.get(j) should equal D1", testdoctors.get(j).getUsername(), ("D1"));
    }}

    @Test
    public void testCheckDoctorRating() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testSecretaryRemovalBtn() {
         fail("Test not yet implemented"); 

    }

    @Test
    public void testMain() {
         fail("Test not yet implemented"); 

    }
    
}
