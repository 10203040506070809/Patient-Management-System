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
    
    List<PatientClass> patients = new ArrayList<PatientClass>();
    List<PatientClass> newPatients = new ArrayList<PatientClass>();
    List<DoctorClass> doctors = new ArrayList<DoctorClass>();
    List<AdminClass> admins = new ArrayList<AdminClass>();
    List<SecretaryClass> secretarys = new ArrayList<SecretaryClass>();
    DefaultListModel model = new DefaultListModel();
    DefaultListModel ratingList = new DefaultListModel();
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
logOffButtonOnClick();



         patients.add(new PatientClass("P1", "the north", "Jon Snow", 18, "Male", "Suffers with Belly ache", "Belly ache", "Paracetemol, 24mg 2x a day"));
         patients.add(new PatientClass("P2", "betrayal", "Robb Stark", 23, "Male", "Suffers with migraines", "Migraines", "Ibruprofen, 24mg 2x a day"));
         patients.add(new PatientClass("P3", "joffrey", "Sansa Stark", 15, "Female", "Suffers with Bipolar Disorder", "Bipolar", "Xanax, 24mg 1x a day"));
        doctors.add(new DoctorClass("D1", "the watch" ,"Aemon Targaryen", 5, "Caring and thorough."));
        doctors.add(new DoctorClass("D2", "boar" ,"Robert Baratheon", 2, "Callous."));
        doctors.add(new DoctorClass("D3", "ironprice" ,"Theon Greyjoy", 1, "A little rough, missed my diagnosis three times."));
        admins.add(new AdminClass("A1", "king", "Arys Oakheart"));
        secretarys.add(new SecretaryClass("S1", "needle", "Arya Stark"));
    }
    
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
             
               secretaryUserNameBox.setText(usernameText.getText());  
             secretaryNameBox.setText(nameText.getText());
                             mainPanel.addTab("Secretary", SecretaryPanel);
                             mainPanel.remove(LoginPanel);}}
             break;
             
         case "Administrator":
             //check if admin exists in system
                  for (int i = 0; i < admins.size(); i++) {
            //check list for patient
            //check if patient exists, then check for password
            //password stored in plaintext, HASH PLS
            if (admins.get(i).getUsername().equals(userEntry) & admins.get(i).getPassword().equals(passEntry)){
                  System.out.println(("Login Successful."));
             
                            mainPanel.addTab("Admin", AdministrationPanel);
                                         adminUserNameBox.setText(usernameText.getText());  
             adminNameBox.setText(nameText.getText());
             mainPanel.remove(LoginPanel);}
            
                  }
             break;
         
     }}    
     
     catch(Exception e){
             feedbackLabel.setText("An error has occured: Make sure you have selected everything., otherwise contact an administrator.");
             }
     
     
    }
             

    }
    public void registerOnClick(){
if (registerName.getText() != null && registerGenderList.getSelectedValue() != null && registerDobText.getText() != null){
    //make sure no premade patients have the same ID
            
            String username = "A" + counter;
    newPatients.add(new PatientClass(username, registerPassword.getText(), registerName.getText(), Integer.parseInt(registerDobText.getText()), registerGenderList.getSelectedValue(), "", "", ""));
   counter++;
   System.out.println(counter);
   //get the most recent addition (The user that was just created) and add it to the secretary model view

  //System.out.println("Your name is:" + name);
  
        
   model.addElement(newPatients.get(newPatients.size() - 1));
      
 
                 registerFeedbackLabel.setText("Your username is: " + username + " Please wait to be approved by a secretary.");
}  
    
}
     
    
        
    
    public void logOffButtonOnClick(){
                mainPanel.remove(DoctorPanel);
        mainPanel.remove(PatientPanel);
        mainPanel.remove(SecretaryPanel);
        mainPanel.remove(AdministrationPanel);
        mainPanel.add("Login", LoginPanel);
    }
public void approvePatient(){
    //approve all patients currently waiting
    for (int i = 0; i < newPatients.size(); i++) {
        patients.add(newPatients.get(i));
        
    }
    newPatients.clear();
    model.clear();
}
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
public void confirmFeedback(){
    String drName = patientDoctorRatingList.getSelectedValue();
    if (patientFeedback.getText() != null && patientDoctorRatingSpinner.getValue() != null)
    for (int i = 0; i < doctors.size(); i++) {
        
    
    if (doctors.get(i).getName().equals(drName)){
    doctors.get(i).setFeedback(doctors.get(i).getFeedback() + "\n" + patientFeedback.getText());
    doctors.get(i).setRating((int) patientDoctorRatingSpinner.getValue());
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
        jTextField1 = new javax.swing.JTextField();
        AdministrationPanel = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        DoctorText = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        DoctorText1 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        SecretaryLabel = new javax.swing.JLabel();
        DoctorLabel = new javax.swing.JLabel();
        adminUserNameBox = new javax.swing.JTextField();
        usernameLabel3 = new javax.swing.JLabel();
        nameLabel3 = new javax.swing.JLabel();
        adminNameBox = new javax.swing.JTextField();
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
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(feedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registerButton)
                    .addComponent(loginUserLabel)
                    .addGroup(LoginPanelLayout.createSequentialGroup()
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(passwordText, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(loginPassLabel)
                            .addComponent(loginButton)
                            .addComponent(jLabel2)
                            .addComponent(nameText))
                        .addGap(55, 55, 55)
                        .addGroup(LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(352, Short.MAX_VALUE))
        );
        LoginPanelLayout.setVerticalGroup(
            LoginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(passwordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(feedbackLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(registerButton)
                .addContainerGap(164, Short.MAX_VALUE))
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
                .addGap(25, 25, 25)
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
                                    .addComponent(registerName, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                                    .addGroup(RegisterPanelLayout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel9)
                                    .addGroup(RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(registerDobText, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(registerButton1, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(jLabel8)
                                    .addComponent(registerPassword))))))
                .addContainerGap(457, Short.MAX_VALUE))
        );
        RegisterPanelLayout.setVerticalGroup(
            RegisterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RegisterPanelLayout.createSequentialGroup()
                .addGap(69, 69, 69)
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
                .addContainerGap(144, Short.MAX_VALUE))
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

        javax.swing.GroupLayout DoctorPanelLayout = new javax.swing.GroupLayout(DoctorPanel);
        DoctorPanel.setLayout(DoctorPanelLayout);
        DoctorPanelLayout.setHorizontalGroup(
            DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usernameLabel1)
                    .addComponent(doctorUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel1)
                    .addComponent(doctorNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 666, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        DoctorPanelLayout.setVerticalGroup(
            DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DoctorPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DoctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DoctorPanelLayout.createSequentialGroup()
                        .addComponent(usernameLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doctorUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nameLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(doctorNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(448, Short.MAX_VALUE))
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

        jScrollPane5.setViewportView(scriptList);

        patientApprovalList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        patientApprovalList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        patientApprovalList.setMaximumSize(new java.awt.Dimension(200, 200));
        patientApprovalList.setMinimumSize(new java.awt.Dimension(200, 200));
        jScrollPane6.setViewportView(patientApprovalList);

        jLabel5.setText("Appointment Requests");

        javax.swing.GroupLayout SecretaryPanelLayout = new javax.swing.GroupLayout(SecretaryPanel);
        SecretaryPanel.setLayout(SecretaryPanelLayout);
        SecretaryPanelLayout.setHorizontalGroup(
            SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecretaryPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SecretaryPanelLayout.createSequentialGroup()
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(secretaryNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(secretaryUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(usernameLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(SecretaryPanelLayout.createSequentialGroup()
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel2)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SecretaryPanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(66, 66, 66)
                                .addComponent(approvalButton))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        SecretaryPanelLayout.setVerticalGroup(
            SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SecretaryPanelLayout.createSequentialGroup()
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SecretaryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SecretaryPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(usernameLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(secretaryUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(nameLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(secretaryNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(SecretaryPanelLayout.createSequentialGroup()
                            .addGap(67, 67, 67)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jScrollPane5))
                        .addGroup(SecretaryPanelLayout.createSequentialGroup()
                            .addGap(68, 68, 68)
                            .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel5)
                                .addGroup(SecretaryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(approvalButton)
                                    .addComponent(jLabel4)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(113, Short.MAX_VALUE))
        );

        mainPanel.addTab("Secretary", SecretaryPanel);

        jButton12.setText("Log Off");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        DoctorText.setViewportView(jTextArea2);

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        DoctorText1.setViewportView(jTextArea3);

        SecretaryLabel.setText("Secretarys");

        DoctorLabel.setText("Doctors");

        adminUserNameBox.setEditable(false);

        usernameLabel3.setText("Username");

        nameLabel3.setText("Name");

        adminNameBox.setEditable(false);

        javax.swing.GroupLayout AdministrationPanelLayout = new javax.swing.GroupLayout(AdministrationPanel);
        AdministrationPanel.setLayout(AdministrationPanelLayout);
        AdministrationPanelLayout.setHorizontalGroup(
            AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministrationPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DoctorText, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoctorLabel))
                        .addGap(172, 172, 172)
                        .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SecretaryLabel)
                            .addComponent(DoctorText1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(295, Short.MAX_VALUE))
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel3)
                            .addComponent(usernameLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );
        AdministrationPanelLayout.setVerticalGroup(
            AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AdministrationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AdministrationPanelLayout.createSequentialGroup()
                        .addComponent(usernameLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(nameLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(adminNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DoctorLabel)
                    .addComponent(SecretaryLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(AdministrationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DoctorText, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DoctorText1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1037, 1037, 1037))
        );

        mainPanel.addTab("Administration", AdministrationPanel);

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

        patientUserNameBox.setEditable(false);

        nameLabel.setText("Name");

        usernameLabel.setText("Username");

        jButton1.setText("Request Account Termination");

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

        javax.swing.GroupLayout PatientPanelLayout = new javax.swing.GroupLayout(PatientPanel);
        PatientPanel.setLayout(PatientPanelLayout);
        PatientPanelLayout.setHorizontalGroup(
            PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(patientUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameLabel)
                    .addComponent(usernameLabel)
                    .addComponent(jButton1))
                .addGap(36, 36, 36)
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addComponent(patientHistoryLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel13)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(patientDoctorRatingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7)
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(doctorSelect))
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(doctorRatingLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addComponent(patientFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2)))
                                .addGap(0, 102, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        PatientPanelLayout.setVerticalGroup(
            PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(patientNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(jButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(doctorSelect)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(doctorRatingLabel)
                                .addGap(77, 77, 77))))
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientPanelLayout.createSequentialGroup()
                                .addComponent(usernameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(patientUserNameBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)
                                .addComponent(nameLabel))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PatientPanelLayout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addComponent(patientHistoryLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PatientPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, Short.MAX_VALUE)))
                .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PatientPanelLayout.createSequentialGroup()
                        .addGroup(PatientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(patientDoctorRatingSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(patientFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        mainPanel.addTab("Patient", PatientPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 952, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
                logOffButtonOnClick();

    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
                logOffButtonOnClick();

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
                logOffButtonOnClick();

    }//GEN-LAST:event_jButton6ActionPerformed

    private void approvalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvalButtonActionPerformed
        // TODO add your handling code here:
        approvePatient();
    }//GEN-LAST:event_approvalButtonActionPerformed

    private void secretaryUserNameBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_secretaryUserNameBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_secretaryUserNameBoxActionPerformed

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
    private javax.swing.JScrollPane DoctorText;
    private javax.swing.JScrollPane DoctorText1;
    private javax.swing.JPanel LoginPanel;
    private javax.swing.JPanel PatientPanel;
    private javax.swing.JPanel RegisterPanel;
    private javax.swing.JLabel SecretaryLabel;
    private javax.swing.JPanel SecretaryPanel;
    private javax.swing.JTextField adminNameBox;
    private javax.swing.JTextField adminUserNameBox;
    private javax.swing.JButton approvalButton;
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
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginPassLabel;
    private javax.swing.JLabel loginUserLabel;
    private javax.swing.JTabbedPane mainPanel;
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
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JLabel usernameLabel1;
    private javax.swing.JLabel usernameLabel2;
    private javax.swing.JLabel usernameLabel3;
    private javax.swing.JTextField usernameText;
    // End of variables declaration//GEN-END:variables
}
