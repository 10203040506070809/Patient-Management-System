/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guis;
import java.util.*;
import javax.swing.DefaultListModel;
import patient.management.system.*;
/**
 *
 * @author jflet
 */
public class PatientManagementSystem extends javax.swing.JFrame {
    
    String currentUserName;
    List<PatientClass> patients = new ArrayList<PatientClass>();
    List<PatientClass> newPatients = new ArrayList<PatientClass>();
    List<DoctorClass> doctors = new ArrayList<DoctorClass>();
    List<AdminClass> admins = new ArrayList<AdminClass>();
    List<SecretaryClass> secretarys = new ArrayList<SecretaryClass>();
    List<MedicineClass> stock = new ArrayList<MedicineClass>();
    DefaultListModel model = new DefaultListModel();
    DefaultListModel ratingList = new DefaultListModel();
    DefaultListModel terminationListModel = new DefaultListModel();
    DefaultListModel adminDoctorListModel = new DefaultListModel();
    DefaultListModel adminSecretaryListModel = new DefaultListModel();
    DefaultListModel secretaryPatientListModel = new DefaultListModel();
PatientClass newPatient;
 DoctorClass doctor;
 AdminClass admin;
 SecretaryClass secretary;
 int counter = 100;
 
    /**
     * Creates new form PatientManagementSystem
     */
    public PatientManagementSystem() {
      
        initComponents();
        patientApprovalList.setModel(model);
        patientDoctorRatingList.setModel(ratingList);
        terminationsList.setModel(terminationListModel);
        adminDoctorList.setModel(adminDoctorListModel);
        adminSecretaryList.setModel(adminSecretaryListModel);
        SecretaryPatientList.setModel(secretaryPatientListModel);
logOffButtonOnClick();



         patients.add(new PatientClass("P1", "the north", "Jon Snow", 18, "Male", "Suffers with Belly ache", "Belly ache", "Paracetemol, 24mg 2x a day", ""));
         patients.add(new PatientClass("P2", "betrayal", "Robb Stark", 23, "Male", "Suffers with migraines", "Migraines", "Ibruprofen, 24mg 2x a day", ""));
         patients.add(new PatientClass("P3", "joffrey", "Sansa Stark", 15, "Female", "Suffers with Bipolar Disorder", "Bipolar", "Xanax, 24mg 1x a day",""));
        doctors.add(new DoctorClass("D1", "the watch" ,"Aemon Targaryen", 5, "*Patient Feedback* Caring and thorough."));
        doctors.add(new DoctorClass("D2", "boar" ,"Robert Baratheon", 2, "*Patient Feedback* Callous."));
        doctors.add(new DoctorClass("D3", "ironprice" ,"Theon Greyjoy", 1, "*Patient Feedback* A little rough, missed my diagnosis three times."));
        admins.add(new AdminClass("A1", "king", "Arys Oakheart"));
        secretarys.add(new SecretaryClass("S1", "needle", "Arya Stark"));
        stock.add(new MedicineClass("Paracetemol" ,"2 tablets twice a day", 5));
        stock.add(new MedicineClass("Ibruprofen" ,"2 tablets twice a day", 5));
        stock.add(new MedicineClass("Xanax" ," 0.25mg three times a day", 5));
         stock.add(new MedicineClass("Norco" ,"325mg once a day", 5));
          stock.add(new MedicineClass("Metformin" ,"24mg twice a day", 5));
           stock.add(new MedicineClass("Lisinopril" ,"24mg twice a day", 5));
            stock.add(new MedicineClass("Co-codamol" ,"1-2 tablets a day ", 5));
             stock.add(new MedicineClass("Adderall" ,"30mg twice a day", 5));
              stock.add(new MedicineClass("Ambien" ,"6.25mg once before bed", 5));
               stock.add(new MedicineClass("Naproxen" ,"500mg Extended release once a day", 5));
    }
    
    /**
     *
     */
    public void loginButtonOnClick(){
       
       String userEntry = usernameText.getText(); 
       String passEntry = passwordText.getText();
       String nameEntry = nameText.getText();
       if (userEntry != null && passEntry != null){
           try{
     String selectedRole = roleList.getSelectedValue();
           
           
     switch(selectedRole){
         
         case "Patient":
                  for (int i = 0; i < patients.size(); i++) {
            //check list for patient
            //check if patient exists, then check for password
            //password stored in plaintext, HASH PLS
            if (patients.get(i).getUsername().equals(userEntry) && patients.get(i).getPassword().equals(passEntry)){
                  System.out.println((patients.get(i).getName()));
                               currentUserName = userEntry;
appointmentText.setText(patients.get(i).getAppointment());
prescriptionText.setText(patients.get(i).getMedicines());
                  patientHistoryText.setText(patients.get(i).getHistory());
                                  mainPanel.addTab("Patient", PatientPanel);
                                  for (int j = 0; j < doctors.size(); j++) {
                    
                
                                   ratingList.addElement(doctors.get(j).getName());
                                           }
                                 
                mainPanel.remove(LoginPanel);
               
                  
                  }
            else {
                feedbackLabel.setText("Your username or password is incorrect. Please try again.");}
                
            }
               

    


                 //correct login
                            
                 break;
         case "Doctor":
             
             //check if doctor exists in system
                  for (int i = 0; i < doctors.size(); i++) {
            //check list for patient
            //check if patient exists, then check for password
            //password stored in plaintext, HASH PLS
            if (doctors.get(i).getUsername().equals(userEntry) && doctors.get(i).getPassword().equals(passEntry)){
                  System.out.println(("Login Successful."));
                          currentUserName = userEntry;

                                doctorUserNameBox.setText(usernameText.getText());  
                                doctorNameBox.setText(nameText.getText());
                             mainPanel.addTab("Doctor", DoctorPanel);
                             mainPanel.remove(LoginPanel);}}
             break;
                      
         case "Secretary":
             //check if secretary exists in system
                  for (int i = 0; i < secretarys.size(); i++) {
            //check list for patient
            //check if patient exists, then check for password
            //password stored in plaintext, HASH PLS
            if (secretarys.get(i).getUsername().equals(userEntry) && secretarys.get(i).getPassword().equals(passEntry)){
                  System.out.println(("Login Successful."));
             currentUserName = userEntry;
               secretaryUserNameBox.setText(usernameText.getText());  
             secretaryNameBox.setText(nameText.getText());
                             mainPanel.addTab("Secretary", SecretaryPanel);
                             mainPanel.remove(LoginPanel);}}
                  for (int i = 0; i < patients.size(); i++) {
                      if (!secretaryPatientListModel.contains(patients.get(i).getName())){
                 secretaryPatientListModel.addElement(patients.get(i).getName());}
                         
             }
             break;
             
         case "Administrator":
             //check if admin exists in system
                  for (int i = 0; i < admins.size(); i++) {
            //check list for patient
            //check if patient exists, then check for password
            //password stored in plaintext, HASH PLS
            if (admins.get(i).getUsername().equals(userEntry) & admins.get(i).getPassword().equals(passEntry)){
                  System.out.println(("Login Successful."));
                          currentUserName = userEntry;
                for (int j = 0; j < doctors.size(); j++) {
                                                       adminDoctorListModel.addElement(doctors.get(j).getName());

                }
                for (int j = 0; j < secretarys.size(); j++) {
                    
                    adminSecretaryListModel.addElement(secretarys.get(j).getName());
                }
                            mainPanel.addTab("Admin", AdministrationPanel);
                                         adminUserNameBox.setText(usernameText.getText());  
             adminNameBox.setText(nameText.getText());
             mainPanel.remove(LoginPanel);}
            
                  }
             break;
         
     }}    
     
     catch(Exception e){
             feedbackLabel.setText("An error has occured: Make sure you have selected everything, otherwise contact an administrator.");
             }
     
     
    }
             

    }

    /**
     *
     */
    public void registerOnClick(){
if (registerName.getText() != null && registerGenderList.getSelectedValue() != null && registerDobText.getText() != null){
    //make sure no premade patients have the same ID
            
            String username = "A" + counter;
    newPatients.add(new PatientClass(username, registerPassword.getText(), registerName.getText(), Integer.parseInt(registerDobText.getText()), registerGenderList.getSelectedValue(), "", "", "", ""));
   counter++;
   System.out.println(counter);
   //get the most recent addition (The user that was just created) and add it to the secretary model view

  //System.out.println("Your name is:" + name);
  
        
   model.addElement(newPatients.get(newPatients.size() - 1));
      
 
                 registerFeedbackLabel.setText("Your username is: " + username + " Please wait to be approved by a secretary.");
}  
    
}
     
    /**
     *
     */
    public void logOffButtonOnClick(){
                mainPanel.remove(DoctorPanel);
        mainPanel.remove(PatientPanel);
        mainPanel.remove(SecretaryPanel);
        mainPanel.remove(AdministrationPanel);
        mainPanel.add("Login", LoginPanel);
    }

    /**
     *
     */
    public void approvePatient(){
    //approve all patients currently waiting
    for (int i = 0; i < newPatients.size(); i++) {
        patients.add(newPatients.get(i));
        
    }
    newPatients.clear();
    model.clear();
}

    /**
     *
     */
    public void doctorFeedbackSelect(){
   String drName = patientDoctorRatingList.getSelectedValue();
   System.out.println(drName);
    for (int i = 0; i < doctors.size(); i++) {
        if (doctors.get(i).getName().equals(drName)){
            doctorFeedbackText.setText(doctors.get(i).getFeedback());
            System.out.println(doctors.get(i).getFeedback());
            doctorRatingLabel.setText("Selected Doctors Rating: " + Integer.toString(doctors.get(i).getRating()));
        }
    }
}

    /**
     *
     */
    public void confirmFeedback(){
    String drName = patientDoctorRatingList.getSelectedValue();
    if (patientFeedback.getText() != null && patientDoctorRatingSpinner.getValue() != null){
    for (int i = 0; i < doctors.size(); i++) {
        
    
    if (doctors.get(i).getName().equals(drName)){
    doctors.get(i).setFeedback(doctors.get(i).getFeedback() + "\n" + "*Patient Feedback:* " + patientFeedback.getText());
    doctors.get(i).setRating((int) patientDoctorRatingSpinner.getValue());
    }
    }
}
    
    else
    {
    
    }
        
        }

    /**
     *
     */
    public void requestAppointmentBtn(){
    String chosenDoctor;
    if (daySpinner.getValue() != null && monthSpinner.getValue() != null && yearSpinner.getValue() != null){
        if (patientDoctorRatingList.getSelectedValue() != null){
         chosenDoctor = patientDoctorRatingList.getSelectedValue();
    }
        else {chosenDoctor = "any available doctor";}
        String appointment = daySpinner.getValue() + " . " + monthSpinner.getValue() + " . " + yearSpinner.getValue() + " with " + chosenDoctor;
    String appointmentConcatenated ="\n" + " Requested an appointment for: " + appointment; 
    patientHistoryText.setText(patientHistoryText.getText() + "\n" + appointmentConcatenated);
    System.out.println(currentUserName);
    for (int i = 0; i < patients.size(); i++) {
        if (patients.get(i).getUsername().equals(currentUserName)){
            patients.get(i).setAppointment(appointment);
            patients.get(i).setHistory(patients.get(i).getHistory() + appointmentConcatenated);
            System.out.println(patients.get(i).getHistory());
            appointmentText.setText(patients.get(i).getAppointment());

        }
    }
}
}

    /**
     *
     */
    public void requestAccountTermination(){
terminationListModel.addElement(currentUserName);

    
}

    /**
     *
     */
    public void terminateAccounts(){
    for (int i = 0; i < patients.size(); i++) {
        if(terminationListModel.contains(patients.get(i).getUsername())){
                        System.out.println("Account" + patients.get(i).getUsername() +  "removed.");

            patients.remove(i);  
        terminationListModel.clear();
        }
    }
        
    
}

    /**
     *
     */
    public void removeDoctor(){
        for (int i = 0; i < 10; i++) {
            if (adminDoctorList.getSelectedValue() != null){
            if(doctors.get(i).getName() == adminDoctorList.getSelectedValue()){
                doctors.remove(i);
                adminDoctorListModel.removeElement(adminDoctorList.getSelectedValue());
            }
        }}
}

   public void createAdmin(){
       if (adminNewNameText.getText() != null && adminNewPasswordText.getText() != null &&  adminAccountLister.getSelectedValue() != null){
          
           switch (adminAccountLister.getSelectedValue()){
               
               case "Admin":
               admins.add(new AdminClass("A" + counter, adminNewPasswordText.getText(), adminNewNameText.getText()));
               adminFeedbackLabel.setText("The new admin account's username is A" + counter);
               break;
               
               case "Secretary":
                   secretarys.add(new SecretaryClass("S" + counter, adminNewPasswordText.getText(), adminNewNameText.getText()));
                   adminFeedbackLabel.setText("The new secretary account's username is S" + counter);
                   break;
                   
               case "Doctor":
                   doctors.add(new DoctorClass("D" + counter, adminNewPasswordText.getText(), adminNewNameText.getText(), 0, ""));
                   adminFeedbackLabel.setText("The new doctor account's username is D" + counter);
                   break;
           }

counter++;
       }
   }
   public void checkDoctorRating(){
       if (adminDoctorList.getSelectedValue() != null){
           for (int i = 0; i < doctors.size(); i++) {
               if (doctors.get(i).getName() == adminDoctorList.getSelectedValue()){
               adminDoctorRatingLabel.setText("This doctors rating is: " + Integer.toString(doctors.get(i).getRating()));
               adminDoctorFeedbackBox.setText(doctors.get(i).getFeedback());
               }
           }
       }
   }
   

   public void secretaryRemovalBtn(){
               for (int i = 0; i < 10; i++) {
            if (adminSecretaryList.getSelectedValue() != null){
            if(secretarys.get(i).getName() == adminSecretaryList.getSelectedValue()){
                secretarys.remove(i);
                adminSecretaryListModel.removeElement(adminSecretaryList.getSelectedValue());
            }
        }}
               checkDoctorRating();
   }
   
   public void saveDoctorFeedback(){
       for (int i = 0; i < doctors.size(); i++) {
           if(doctors.get(i).getName() == adminDoctorList.getSelectedValue()){
           doctors.get(i).setFeedback(adminDoctorFeedbackBox.getText());
           }
           }
       
   }
   
   public void confirmApps(){
       
   }
   public void removePatient(){
       if (SecretaryPatientList.getSelectedValue() != null){
           for (int i = 0; i < patients.size(); i++) {
               if (patients.get(i).getName() == SecretaryPatientList.getSelectedValue()){
                   secretaryPatientListModel.removeElement((SecretaryPatientList.getSelectedValue()));
                   patients.remove(i);
               }
           }
       
       }
   }
    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JTabbedPane();
        LoginPanel = new javax.swing.JPanel();
        usernameText = new javax.swing.JTextField();
        passwordText = new javax.swing.JTextField();
        loginUserLabel = new javax.swing.JLabel();
        loginPassLabel = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        roleList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        feedbackLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        RegisterPanel = new javax.swing.JPanel();
        registerButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        registerName = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        registerGenderList = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        registerDobText = new javax.swing.JTextField();
        registerPassword = new javax.swing.JPasswordField();
        registerFeedbackLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        DoctorPanel = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        usernameLabel1 = new javax.swing.JLabel();
        doctorUserNameBox = new javax.swing.JTextField();
        nameLabel1 = new javax.swing.JLabel();
        doctorNameBox = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton5 = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        SecretaryPanel = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        secretaryUserNameBox = new javax.swing.JTextField();
        usernameLabel2 = new javax.swing.JLabel();
        nameLabel2 = new javax.swing.JLabel();
        secretaryNameBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        approvalButton = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        scriptList = new javax.swing.JList<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        patientApprovalList = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        terminationApprovalButton = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        terminationsList = new javax.swing.JList<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        appointmentRequestList = new javax.swing.JList<>();
        jLabel34 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        SecretaryPatientList = new javax.swing.JList<>();
        PatientPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        patientHistoryText = new javax.swing.JTextArea();
        patientHistoryLabel = new javax.swing.JLabel();
        patientNameBox = new javax.swing.JTextField();
        patientUserNameBox = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        patientDoctorRatingList = new javax.swing.JList<>();
        patientDoctorRatingSpinner = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        patientFeedback = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        doctorFeedbackText = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        doctorSelect = new javax.swing.JButton();
        doctorRatingLabel = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        daySpinner = new javax.swing.JSpinner();
        monthSpinner = new javax.swing.JSpinner();
        yearSpinner = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        appointmentRequestButton = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        appointmentText = new javax.swing.JTextField();
        prescriptionText = new javax.swing.JTextField();
        AdministrationPanel = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        SecretaryLabel = new javax.swing.JLabel();
        DoctorLabel = new javax.swing.JLabel();
        adminUserNameBox = new javax.swing.JTextField();
        usernameLabel3 = new javax.swing.JLabel();
        nameLabel3 = new javax.swing.JLabel();
        adminNameBox = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        adminSecretaryList = new javax.swing.JList<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        adminDoctorList = new javax.swing.JList<>();
        adminDoctorsRemovalBtn = new javax.swing.JButton();
        adminSecretaryRemovalBtn = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        adminFeedbackLabel = new javax.swing.JLabel();
        adminNewNameText = new javax.swing.JTextField();
        adminNewPasswordText = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        adminConfirmNewAdmin = new javax.swing.JButton();
        adminDoctorFeedbackButton = new javax.swing.JButton();
        adminDoctorRatingLabel = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        adminAccountLister = new javax.swing.JList<>();
        jLabel33 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        adminDoctorFeedbackBox = new javax.swing.JTextArea();
        jLabel35 = new javax.swing.JLabel();
        adminSaveFeedback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setName("mainPanel"); // NOI18N

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });

        loginUserLabel.setText("Username");

        loginPassLabel.setText("Password");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        registerButton.setText("Register");
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });

        roleList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Patient", "Doctor", "Secretary", "Administrator" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(roleList);

        jLabel1.setText("Role");

        jLabel2.setText("Name");

        javax.swing.GroupLayout LoginPanelLayout = new javax.swing.GroupLayout(LoginPanel);
        LoginPanel.setLayout(LoginPanelLayout);
        LoginPanelLayout.setHorizontalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginPanelLayout.createSequentialGroup()
                .addContainerGap(376, Short.MAX_VALUE)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton)
                    .addComponent(loginUserLabel)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameText)
                            .addComponent(passwordText)
                            .addComponent(loginPassLabel)
                            .addComponent(loginButton)
                            .addComponent(jLabel2)
                            .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(303, 303, 303))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(loginUserLabel)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(17, 17, 17)
                        .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(loginPassLabel))
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(feedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addContainerGap(244, Short.MAX_VALUE))
        );

        mainPanel.addTab("Login", LoginPanel);

        registerButton1.setText("Register");
        registerButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Greetings new patients, please enter your name, gender, age and select a password to register.");

        registerGenderList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Male", "Female" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(registerGenderList);

        jLabel7.setText("Name");

        jLabel8.setText("Gender");

        jLabel9.setText("Age");

        jLabel10.setText("Password");

        javax.swing.GroupLayout RegisterPanelLayout = new javax.swing.GroupLayout(RegisterPanel);
        RegisterPanel.setLayout(RegisterPanelLayout);
        RegisterPanelLayout.setHorizontalGroup(
            RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPanelLayout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addGroup(RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(registerFeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, RegisterPanelLayout.createSequentialGroup()
                            .addGap(134, 134, 134)
                            .addGroup(RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel10)
                                .addGroup(RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel7)
                                    .addComponent(registerName)
                                    .addGroup(RegisterPanelLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addComponent(registerDobText)
                                    .addComponent(registerButton1)
                                    .addComponent(jLabel8)
                                    .addComponent(registerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(432, Short.MAX_VALUE))
        );
        RegisterPanelLayout.setVerticalGroup(
            RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPanelLayout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel10)
                .addGap(3, 3, 3)
                .addComponent(registerPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(13, 13, 13)
                .addComponent(registerDobText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(registerButton1)
                .addGap(18, 18, 18)
                .addComponent(registerFeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        mainPanel.addTab("Register", RegisterPanel);

        jButton6.setText("Log Off");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        usernameLabel1.setText("Username");

        doctorUserNameBox.setEditable(false);

        nameLabel1.setText("Name");

        doctorNameBox.setEditable(false);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane12.setViewportView(jTextArea1);

        jLabel26.setText("My feedback");

        jLabel27.setText("Patient Details");

        jLabel28.setText("Name");

        jLabel29.setText("Notes");

        jLabel30.setText("Age");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane13.setViewportView(jTextArea2);

        jTextField1.setEditable(false);

        jTextField2.setEditable(false);

        jLabel31.setText("Patient Select");

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane14.setViewportView(jList1);

        jButton5.setText("Select");

        jLabel32.setText("Medicines");

        javax.swing.GroupLayout DoctorPanelLayout = new javax.swing.GroupLayout(DoctorPanel);
        DoctorPanel.setLayout(DoctorPanelLayout);
        DoctorPanelLayout.setHorizontalGroup(
            DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorPanelLayout.createSequentialGroup()
                        .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(doctorUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DoctorPanelLayout.createSequentialGroup()
                                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLabel1)
                                    .addComponent(nameLabel1)
                                    .addComponent(doctorNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(257, 257, 257)
                                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel31)
                                    .addComponent(jButton5))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DoctorPanelLayout.createSequentialGroup()
                        .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DoctorPanelLayout.createSequentialGroup()
                                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel29))
                                .addGap(29, 29, 29)
                                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
                            .addComponent(jLabel32)
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 469, Short.MAX_VALUE)
                        .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        DoctorPanelLayout.setVerticalGroup(
            DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorPanelLayout.createSequentialGroup()
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26))
                    .addGroup(DoctorPanelLayout.createSequentialGroup()
                        .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(usernameLabel1)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doctorUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DoctorPanelLayout.createSequentialGroup()
                                .addComponent(nameLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(doctorNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorPanelLayout.createSequentialGroup()
                        .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DoctorPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel30)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(jLabel29))
                            .addComponent(jButton5))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel32))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 77, 77))
        );

        mainPanel.addTab("Doctor", DoctorPanel);

        jButton9.setText("Log Off");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jLabel3.setText("Available Prescriptions");

        secretaryUserNameBox.setEditable(false);
        secretaryUserNameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                secretaryUserNameBoxActionPerformed(evt);
            }
        });

        usernameLabel2.setText("Username");

        nameLabel2.setText("Name");

        secretaryNameBox.setEditable(false);

        jLabel4.setText("Patients Needing Approval");

        approvalButton.setText("Approve");
        approvalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvalButtonActionPerformed(evt);
            }
        });

        scriptList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(scriptList);

        patientApprovalList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        patientApprovalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientApprovalList.setMaximumSize(new java.awt.Dimension(200, 200));
        patientApprovalList.setMinimumSize(new java.awt.Dimension(200, 200));
        jScrollPane6.setViewportView(patientApprovalList);

        jLabel5.setText("Appointment Requests");

        jLabel22.setText("Patient Account Terminations");

        terminationApprovalButton.setText("Approve");
        terminationApprovalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terminationApprovalButtonActionPerformed(evt);
            }
        });

        terminationsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane9.setViewportView(terminationsList);

        appointmentRequestList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane11.setViewportView(appointmentRequestList);

        jLabel34.setText("Patients");

        jButton7.setText("Confirm");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Give Prescription");

        jButton4.setText("Remove");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        SecretaryPatientList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane18.setViewportView(SecretaryPatientList);

        javax.swing.GroupLayout SecretaryPanelLayout = new javax.swing.GroupLayout(SecretaryPanel);
        SecretaryPanel.setLayout(SecretaryPanelLayout);
        SecretaryPanelLayout.setHorizontalGroup(
            SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecretaryPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(secretaryNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(secretaryUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameLabel2)
                    .addComponent(nameLabel2)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jButton8))
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecretaryPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 194, Short.MAX_VALUE)
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7))
                        .addGap(76, 76, 76)
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(approvalButton))
                        .addGap(37, 37, 37))
                    .addGroup(SecretaryPanelLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addGroup(SecretaryPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jButton4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecretaryPanelLayout.createSequentialGroup()
                        .addComponent(terminationApprovalButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SecretaryPanelLayout.createSequentialGroup()
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        SecretaryPanelLayout.setVerticalGroup(
            SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecretaryPanelLayout.createSequentialGroup()
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SecretaryPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(usernameLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(secretaryUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(nameLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(secretaryNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SecretaryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SecretaryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton4)
                                    .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(SecretaryPanelLayout.createSequentialGroup()
                            .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)
                                .addComponent(jLabel22))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SecretaryPanelLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(jScrollPane5))))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(approvalButton)
                        .addComponent(jButton7)
                        .addComponent(jButton8))
                    .addComponent(terminationApprovalButton))
                .addContainerGap(217, Short.MAX_VALUE))
        );

        mainPanel.addTab("Secretary", SecretaryPanel);

        jButton3.setText("Log Off");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        patientHistoryText.setEditable(false);
        patientHistoryText.setColumns(20);
        patientHistoryText.setRows(5);
        jScrollPane1.setViewportView(patientHistoryText);

        patientHistoryLabel.setText("Patient History");

        patientNameBox.setEditable(false);
        patientNameBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientNameBoxActionPerformed(evt);
            }
        });

        patientUserNameBox.setEditable(false);

        nameLabel.setText("Name");

        usernameLabel.setText("Username");

        jButton1.setText("Request Account Termination");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane4.setViewportView(patientDoctorRatingList);

        jLabel11.setText("Doctors");

        jLabel12.setText("Feedback");

        jLabel13.setText("Rating");

        doctorFeedbackText.setColumns(20);
        doctorFeedbackText.setRows(5);
        jScrollPane7.setViewportView(doctorFeedbackText);

        jLabel14.setText("Selected Doctors Feedback");

        doctorSelect.setText("Select");
        doctorSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorSelectActionPerformed(evt);
            }
        });

        doctorRatingLabel.setText("Selected Doctors Rating:");

        jButton2.setText("Confirm Feedback");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel15.setText("Request Appointment - Choose your doctor below.");

        jLabel16.setText("Requested Appointment Dates");

        jLabel17.setText("Day");

        jLabel18.setText("Month");

        jLabel19.setText("Year");

        appointmentRequestButton.setText("Request Appointment");
        appointmentRequestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                appointmentRequestButtonActionPerformed(evt);
            }
        });

        jLabel20.setText("Prescriptions");

        jLabel21.setText("Appointments");

        appointmentText.setEditable(false);

        prescriptionText.setEditable(false);
        prescriptionText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescriptionTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PatientPanelLayout = new javax.swing.GroupLayout(PatientPanel);
        PatientPanel.setLayout(PatientPanelLayout);
        PatientPanelLayout.setHorizontalGroup(
            PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPanelLayout.createSequentialGroup()
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientHistoryLabel)
                            .addComponent(jButton1)
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(usernameLabel)
                                    .addComponent(patientUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nameLabel)
                                    .addComponent(patientNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(70, 70, 70)
                                .addComponent(jLabel21))))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(appointmentText, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(prescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(90, 90, 90)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientDoctorRatingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addComponent(doctorRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(doctorSelect))))))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addComponent(patientFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17))
                                .addGap(18, 18, 18)
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18))
                                .addGap(18, 18, 18)
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(appointmentRequestButton)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PatientPanelLayout.setVerticalGroup(
            PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addComponent(usernameLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(patientUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(appointmentText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(nameLabel)
                                            .addComponent(jLabel20))
                                        .addGap(18, 18, 18)
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(patientNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(prescriptionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel15))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel16)
                                        .addGap(18, 18, 18)
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel19))
                                        .addGap(18, 18, 18)
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(daySpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(monthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(yearSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(42, 42, 42)
                                .addComponent(appointmentRequestButton)))
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(patientHistoryLabel)
                                .addGap(130, 130, 130))
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                                .addGap(79, 79, 79)
                                                .addComponent(doctorSelect)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientPanelLayout.createSequentialGroup()
                                                .addComponent(doctorRatingLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                        .addComponent(jLabel14))
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35)))
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(patientDoctorRatingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(patientFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2)))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        mainPanel.addTab("Patient", PatientPanel);

        jButton12.setText("Log Off");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        SecretaryLabel.setText("Secretarys");

        DoctorLabel.setText("Doctors");

        adminUserNameBox.setEditable(false);

        usernameLabel3.setText("Username");

        nameLabel3.setText("Name");

        adminNameBox.setEditable(false);

        adminSecretaryList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(adminSecretaryList);

        adminDoctorList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane10.setViewportView(adminDoctorList);

        adminDoctorsRemovalBtn.setText("Remove");
        adminDoctorsRemovalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDoctorsRemovalBtnActionPerformed(evt);
            }
        });

        adminSecretaryRemovalBtn.setText("Remove");
        adminSecretaryRemovalBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSecretaryRemovalBtnActionPerformed(evt);
            }
        });

        jLabel23.setText("Create a new account:");

        jLabel24.setText("Name");

        jLabel25.setText("Password");

        adminConfirmNewAdmin.setText("Confirm");
        adminConfirmNewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminConfirmNewAdminActionPerformed(evt);
            }
        });

        adminDoctorFeedbackButton.setText("Check Feedback/Rating");
        adminDoctorFeedbackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminDoctorFeedbackButtonActionPerformed(evt);
            }
        });

        adminAccountLister.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Doctor", "Secretary", "Admin" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        adminAccountLister.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane15.setViewportView(adminAccountLister);

        jLabel33.setText("Type of Account");

        adminDoctorFeedbackBox.setColumns(20);
        adminDoctorFeedbackBox.setRows(5);
        jScrollPane17.setViewportView(adminDoctorFeedbackBox);

        jLabel35.setText("When editing the feedback, please mark your addition as *Admin Feedback* to distinguish from Patient feedback.");

        adminSaveFeedback.setText("Save");
        adminSaveFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminSaveFeedbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AdministrationPanelLayout = new javax.swing.GroupLayout(AdministrationPanel);
        AdministrationPanel.setLayout(AdministrationPanelLayout);
        AdministrationPanelLayout.setHorizontalGroup(
            AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministrationPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addGap(503, 503, 503)
                        .addComponent(jLabel23)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                .addComponent(adminDoctorFeedbackButton)
                                .addGap(44, 44, 44)
                                .addComponent(adminDoctorRatingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(DoctorLabel)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(adminDoctorsRemovalBtn))
                                .addGap(44, 44, 44)
                                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SecretaryLabel)
                                    .addComponent(adminSecretaryRemovalBtn)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(90, 90, 90)
                                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminConfirmNewAdmin)
                                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                        .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24)
                                            .addComponent(adminNewNameText, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25)
                                            .addComponent(adminNewPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(29, 29, 29)
                                        .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel33)
                                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(adminFeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminSaveFeedback)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 673, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 267, Short.MAX_VALUE))
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel3)
                            .addComponent(usernameLabel3)
                            .addComponent(adminNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))))
        );
        AdministrationPanelLayout.setVerticalGroup(
            AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addComponent(SecretaryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(adminSecretaryRemovalBtn))
                    .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(AdministrationPanelLayout.createSequentialGroup()
                            .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                    .addComponent(jLabel23)
                                    .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel24)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(adminNewNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(34, 34, 34)
                                            .addComponent(jLabel25)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(adminNewPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(jLabel33)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(13, 13, 13)
                                    .addComponent(adminConfirmNewAdmin)
                                    .addGap(42, 42, 42)
                                    .addComponent(adminFeedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(AdministrationPanelLayout.createSequentialGroup()
                                    .addGap(44, 44, 44)
                                    .addComponent(DoctorLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(adminDoctorsRemovalBtn))))
                        .addGroup(AdministrationPanelLayout.createSequentialGroup()
                            .addComponent(usernameLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(adminUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addComponent(nameLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(adminNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminDoctorFeedbackButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(adminDoctorRatingLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminSaveFeedback)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        mainPanel.addTab("Administration", AdministrationPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        mainPanel.getAccessibleContext().setAccessibleName("mainPanel");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextActionPerformed

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        loginButtonOnClick();
        
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        logOffButtonOnClick();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
                logOffButtonOnClick();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_registerButtonActionPerformed

    private void registerButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButton1ActionPerformed
        // TODO add your handling code here:
        registerOnClick();
    }//GEN-LAST:event_registerButton1ActionPerformed

    private void doctorSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorSelectActionPerformed
        // TODO add your handling code here:
        doctorFeedbackSelect();
    }//GEN-LAST:event_doctorSelectActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        confirmFeedback();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void appointmentRequestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_appointmentRequestButtonActionPerformed
        // TODO add your handling code here:
        requestAppointmentBtn();
    }//GEN-LAST:event_appointmentRequestButtonActionPerformed

    private void prescriptionTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescriptionTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prescriptionTextActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        requestAccountTermination();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        logOffButtonOnClick();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void terminationApprovalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terminationApprovalButtonActionPerformed
        // TODO add your handling code here:
        terminateAccounts();
    }//GEN-LAST:event_terminationApprovalButtonActionPerformed

    private void approvalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvalButtonActionPerformed
        // TODO add your handling code here:
        approvePatient();
    }//GEN-LAST:event_approvalButtonActionPerformed

    private void secretaryUserNameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secretaryUserNameBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secretaryUserNameBoxActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        logOffButtonOnClick();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void adminSecretaryRemovalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSecretaryRemovalBtnActionPerformed
        // TODO add your handling code here:
        secretaryRemovalBtn();
    }//GEN-LAST:event_adminSecretaryRemovalBtnActionPerformed

    private void adminDoctorsRemovalBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDoctorsRemovalBtnActionPerformed
        // TODO add your handling code here:
        removeDoctor();
    }//GEN-LAST:event_adminDoctorsRemovalBtnActionPerformed

    private void adminConfirmNewAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminConfirmNewAdminActionPerformed
        // TODO add your handling code here:
        createAdmin();
    }//GEN-LAST:event_adminConfirmNewAdminActionPerformed

    private void adminDoctorFeedbackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminDoctorFeedbackButtonActionPerformed
        // TODO add your handling code here:
        checkDoctorRating();
    }//GEN-LAST:event_adminDoctorFeedbackButtonActionPerformed

    private void patientNameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientNameBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientNameBoxActionPerformed

    private void adminSaveFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminSaveFeedbackActionPerformed
        // TODO add your handling code here:
        saveDoctorFeedback();
    }//GEN-LAST:event_adminSaveFeedbackActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        confirmApps();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        removePatient();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PatientManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientManagementSystem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AdministrationPanel;
    private javax.swing.JLabel DoctorLabel;
    private javax.swing.JPanel DoctorPanel;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel PatientPanel;
    private javax.swing.JPanel RegisterPanel;
    private javax.swing.JLabel SecretaryLabel;
    private javax.swing.JPanel SecretaryPanel;
    private javax.swing.JList<String> SecretaryPatientList;
    private javax.swing.JList<String> adminAccountLister;
    private javax.swing.JButton adminConfirmNewAdmin;
    private javax.swing.JTextArea adminDoctorFeedbackBox;
    private javax.swing.JButton adminDoctorFeedbackButton;
    private javax.swing.JList<String> adminDoctorList;
    private javax.swing.JLabel adminDoctorRatingLabel;
    private javax.swing.JButton adminDoctorsRemovalBtn;
    private javax.swing.JLabel adminFeedbackLabel;
    private javax.swing.JTextField adminNameBox;
    private javax.swing.JTextField adminNewNameText;
    private javax.swing.JTextField adminNewPasswordText;
    private javax.swing.JButton adminSaveFeedback;
    private javax.swing.JList<String> adminSecretaryList;
    private javax.swing.JButton adminSecretaryRemovalBtn;
    private javax.swing.JTextField adminUserNameBox;
    private javax.swing.JButton appointmentRequestButton;
    private javax.swing.JList<String> appointmentRequestList;
    private javax.swing.JTextField appointmentText;
    private javax.swing.JButton approvalButton;
    private javax.swing.JSpinner daySpinner;
    private javax.swing.JTextArea doctorFeedbackText;
    private javax.swing.JTextField doctorNameBox;
    private javax.swing.JLabel doctorRatingLabel;
    private javax.swing.JButton doctorSelect;
    private javax.swing.JTextField doctorUserNameBox;
    private javax.swing.JLabel feedbackLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginPassLabel;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JTabbedPane mainPanel;
    private javax.swing.JSpinner monthSpinner;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel nameLabel2;
    private javax.swing.JLabel nameLabel3;
    private javax.swing.JTextField nameText;
    private javax.swing.JTextField passwordText;
    private javax.swing.JList<String> patientApprovalList;
    private javax.swing.JList<String> patientDoctorRatingList;
    private javax.swing.JSpinner patientDoctorRatingSpinner;
    private javax.swing.JTextField patientFeedback;
    private javax.swing.JLabel patientHistoryLabel;
    private javax.swing.JTextArea patientHistoryText;
    private javax.swing.JTextField patientNameBox;
    private javax.swing.JTextField patientUserNameBox;
    private javax.swing.JTextField prescriptionText;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton registerButton1;
    private javax.swing.JTextField registerDobText;
    private javax.swing.JLabel registerFeedbackLabel;
    private javax.swing.JList<String> registerGenderList;
    private javax.swing.JTextField registerName;
    private javax.swing.JPasswordField registerPassword;
    private javax.swing.JList<String> roleList;
    private javax.swing.JList<String> scriptList;
    private javax.swing.JTextField secretaryNameBox;
    private javax.swing.JTextField secretaryUserNameBox;
    private javax.swing.JButton terminationApprovalButton;
    private javax.swing.JList<String> terminationsList;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JLabel usernameLabel2;
    private javax.swing.JLabel usernameLabel3;
    private javax.swing.JTextField usernameText;
    private javax.swing.JSpinner yearSpinner;
    // End of variables declaration//GEN-END:variables
}
