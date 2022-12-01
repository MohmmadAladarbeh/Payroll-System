/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import payrollsystem.file_data.FileData;
import payrollsystem.file_data.StaticItems;

/**
 *
 * @author User
 */
public class DialogFrame extends javax.swing.JDialog {

    private String btnNameFrame = "", idSelected = "", hireDate = "";
   

    /**
     * Creates new form DialogFrame
     */
    public DialogFrame(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        labelIdError.setVisible(false);
        labelPasswordErro.setVisible(false);
 
      
    }
    
    public DialogFrame (java.awt.Frame parent, boolean modal, String btnNameFrame, String idSelected ){
        
        super (parent, modal);
        
        initComponents();
        labelIdError.setVisible(false);
        labelPasswordErro.setVisible(false);
        this.btnNameFrame = btnNameFrame;
        this.idSelected = idSelected;
        this.txtPassword.setVisible(false);
        this.labelPassword.setVisible(false);
        ArrayList <FileData> allDataFileArray = FileData.getArray();
        
        // make tetId just for number inputs
        txtId.setColumns(10);
        ((AbstractDocument)txtId.getDocument()).setDocumentFilter(new DocumentFilter(){
            Pattern regEx = Pattern.compile("\\d*");

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {          
                Matcher matcher = regEx.matcher(text);
                if(!matcher.matches()){
                    return;
                }
                super.replace(fb, offset, length, text, attrs);
            }
        });
        
        // Fill ComboBox 
        
        
        comDep.addItem("Select .......");
        comDep.addItem("Sales");
        comDep.addItem("IT");
        comDep.addItem("Financial");
        
        
        
        
         if (this.btnNameFrame.equals("View")) {
            for (int index = 0; index < allDataFileArray.size(); index++) {
                if (allDataFileArray.get(index).getId().equals(idSelected)) {
                    System.out.println("id Selected" + idSelected);
                    txtId.setEditable(false);
                    txtName.setEditable(false);
                    txtAddress.setEditable(false);
                    
                    btnSave.setVisible(false);
                    txtId.setText(allDataFileArray.get(index).getId());
                    txtName.setText(allDataFileArray.get(index).getName());
                    txtAddress.setText(allDataFileArray.get(index).getAddress());
                    
                    String inputString = allDataFileArray.get(index).getHireDate();
                    
                    String OLD_FORMAT = "dd/MM/yyyy";
                    String oldDateString = inputString;
                    SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
                    Date d = null;
                    try {
                        d = sdf.parse(oldDateString);
                    } catch (ParseException ex) {
//                        Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    spinerHireDate.setValue(d);
                    
                    
                    //  spinerHireDate.setValue(inputDate);
                    comDep.setSelectedItem(allDataFileArray.get(index).getDepartement());
                    comDep.setEditable(false);
                    
                    if (allDataFileArray.get(index).getGender().equals("Female"))
                        radioGroupGender.setSelected(radioBtnFemale.getModel(), true);
                    
                    if (allDataFileArray.get(index).getGender().equals("Mael"))
                        radioGroupGender.setSelected(radioBtnMael.getModel(), true);
                    
                    if (allDataFileArray.get(index).getState().equals("Married"))
                        radioGroupStatus.setSelected(radioBtnMarried.getModel(), true);
                    
                    if (allDataFileArray.get(index).getState().equals("Single"))
                        radioGroupStatus.setSelected(radioBtnSingle.getModel(), true);
                    
                    
                    
                }
            }
        
        }
         
         else if (this.btnNameFrame.equals ("Update")) {
             
             
             for (int index = 0; index < allDataFileArray.size(); index++) {
                if (allDataFileArray.get(index).getId().equals(idSelected)) {
                    
                    txtId.setText(allDataFileArray.get(index).getId());
                    txtId.setEditable(false);
                    txtName.setText(allDataFileArray.get(index).getName());
                    txtAddress.setText(allDataFileArray.get(index).getAddress());

                    String inputString = allDataFileArray.get(index).getHireDate();
                    
                    String OLD_FORMAT = "dd/MM/yyyy";
                    String oldDateString = inputString;
                    SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
                    Date d = null;
                    try {
                        d = sdf.parse(oldDateString);
                    } catch (ParseException ex) {
//                        Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    spinerHireDate.setValue(d);
                    
                    comDep.setSelectedItem(allDataFileArray.get(index).getDepartement());
                    btnSave.setText("Update");
                    
                    if (allDataFileArray.get(index).getGender().equals("Female"))
                        radioGroupGender.setSelected(radioBtnFemale.getModel(), true);
                    
                    if (allDataFileArray.get(index).getGender().equals("Mael"))
                        radioGroupGender.setSelected(radioBtnMael.getModel(), true);
                    
                    if (allDataFileArray.get(index).getState().equals("Married"))
                        radioGroupStatus.setSelected(radioBtnMarried.getModel(), true);
                    
                    if (allDataFileArray.get(index).getState().equals("Single"))
                        radioGroupStatus.setSelected(radioBtnSingle.getModel(), true);
                }
            }
             
             
             
         }
         
         
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioGroupGender = new javax.swing.ButtonGroup();
        radioGroupStatus = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        comDep = new javax.swing.JComboBox<>();
        btnClose = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        radioBtnFemale = new javax.swing.JRadioButton();
        radioBtnSingle = new javax.swing.JRadioButton();
        radioBtnMael = new javax.swing.JRadioButton();
        radioBtnMarried = new javax.swing.JRadioButton();
        labelIdError = new javax.swing.JLabel();
        labelPassword = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        labelPasswordErro = new javax.swing.JLabel();
        spinerHireDate = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/new_1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/user_icon.png"))); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/hierarchy.png"))); // NOI18N
        jLabel3.setText("Departement");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/address.png"))); // NOI18N
        jLabel4.setText("Address");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/id.png"))); // NOI18N
        jLabel5.setText("Id Number");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/gender.png"))); // NOI18N
        jLabel7.setText("Gender");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/date.png"))); // NOI18N
        jLabel8.setText("Hire Date");

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/id.png"))); // NOI18N
        jLabel9.setText("Status");

        txtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        comDep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnClose.setBackground(new java.awt.Color(35, 167, 233));
        btnClose.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClose.setText("CLOSE");
        btnClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCloseMouseClicked(evt);
            }
        });
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(35, 167, 233));
        btnSave.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave.setText("SAVE");
        btnSave.setName("SAVE"); // NOI18N
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        radioGroupGender.add(radioBtnFemale);
        radioBtnFemale.setText("Female");
        radioBtnFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnFemaleActionPerformed(evt);
            }
        });

        radioGroupStatus.add(radioBtnSingle);
        radioBtnSingle.setSelected(true);
        radioBtnSingle.setText("Single");
        radioBtnSingle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnSingleActionPerformed(evt);
            }
        });

        radioGroupGender.add(radioBtnMael);
        radioBtnMael.setSelected(true);
        radioBtnMael.setText("Mael");

        radioGroupStatus.add(radioBtnMarried);
        radioBtnMarried.setText("Married");
        radioBtnMarried.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnMarriedActionPerformed(evt);
            }
        });

        labelIdError.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelIdError.setForeground(new java.awt.Color(255, 0, 0));
        labelIdError.setText("Id must be numbers and more than 4");

        labelPassword.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        labelPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/id.png"))); // NOI18N
        labelPassword.setText("Password");

        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });

        labelPasswordErro.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        labelPasswordErro.setForeground(new java.awt.Color(255, 0, 0));
        labelPasswordErro.setText("Your Password must be greater than 8");

        spinerHireDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.DAY_OF_YEAR));
        spinerHireDate.setEditor(new javax.swing.JSpinner.DateEditor(spinerHireDate, "dd/MM/yyyy"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtId, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(comDep, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioBtnMael)
                                    .addComponent(radioBtnMarried))
                                .addGap(77, 98, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(radioBtnSingle)
                                    .addComponent(radioBtnFemale)))
                            .addComponent(txtAddress, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelPasswordErro, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelIdError, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(spinerHireDate))))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelIdError)
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(comDep, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(spinerHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(radioBtnMael)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(radioBtnMarried)
                            .addComponent(radioBtnSingle)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(radioBtnFemale)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelPasswordErro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClose, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void btnCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCloseMouseClicked
        
        
        
        

    }//GEN-LAST:event_btnCloseMouseClicked

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        this.setVisible(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
      
        
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
          
        if (this.btnNameFrame.equals("Update")){
            updateUser();
            JOptionPane.showMessageDialog(this, "The User Updated Successfully");
            this.setVisible(false);
            
        }else {
            boolean result = addUser();
            if (result)
                JOptionPane.showMessageDialog(this, "Added New User Successfully");
                this.setVisible(false);
                
        }
        
        
        
        
        
    }//GEN-LAST:event_btnSaveActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void radioBtnFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnFemaleActionPerformed

    private void radioBtnSingleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnSingleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnSingleActionPerformed

    private void radioBtnMarriedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnMarriedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioBtnMarriedActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    
    public void updateUser () {
        
//        Date date = txtHireDate.getDate();
        
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String hireDateTxt;
        String password = txtPassword.getText();
        System.out.println("password " + password);
        String department = comDep.getSelectedItem().toString();
        String gender = "", status = "";
        ArrayList <FileData> allDataFileArray = FileData.getArray();
        
        
        
        
        
       
        if(radioBtnMarried.isSelected())
            status = "Married";
        else
            status = "Single";
        
        // assign the gender variable
        if (radioBtnFemale.isSelected())
            gender = "Female";
        else 
            gender = "Mael";
        
        
        
        
        // save the data inside employees file 
        // Clear all data inside ArrayList of FileData
         

        allDataFileArray.clear();
        
        ArrayList<FileData> fileDataArray = new ArrayList<>();
        
       
        
        // read a file 
        File file = new File("employees.txt");
        //Construct the new file that will later be renamed to the original filename.
        File tempFile = new File("employees2.txt");

        int count = 0;
        try {
            FileReader fileReader = new FileReader(file); 
                BufferedReader br = new BufferedReader(fileReader);  
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));  
                
                String currentLine;  

                while((currentLine = br.readLine()) != null) {
                    // trim newline when comparing with lineToRemove  
                    String trimmedLine = currentLine.trim();  
                    String [] array = trimmedLine.split("    ");  
                    if (array[0].equals(id))  
                        continue;  
                    fileDataArray.add(new FileData(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]));     
                    bw.write(currentLine + System.getProperty("line.separator"));  
                }  
                
                fileDataArray.add(new FileData(id, name, password, department, hireDate, address, gender, status));   
                bw.write(String.format("%s    %s    %s    %s    %s    %s    %s    %s",   
                        id, name, password, department, hireDate, address, gender, status) + System.getProperty("line.separator"));  
                bw.close();  
                br.close();  
                //    file.delete();  
                //    tempFile.renameTo(new File("F:\\Java Applications\\PayRollSystem\\employees.txt"));  
            }catch (Exception ex) {
                Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            if (file.exists()) {
                file.delete();
            }
            tempFile.renameTo(new File("employees.txt"));

            FileData.setArray(fileDataArray);
    }
    
    public boolean addUser ( ) {
        
        System.out.println("Date"+ spinerHireDate.getValue());
        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String hireDateTxt;
        hireDateTxt = changeDateFormat("E MMM dd HH:mm:ss z yyyy", "dd/MM/yyyy", spinerHireDate.getValue().toString()).toString();
        String password = txtPassword.getText();
        System.out.println("password " + password);
        String department = comDep.getSelectedItem().toString();
        String gender = "", status = "";
        ArrayList <FileData> allDataFileArray = FileData.getArray();
        
        
        if (id.equals("") || name.equals("") || address.equals("") || hireDateTxt.equals("")){
            JOptionPane.showMessageDialog(this, "You Have To Fill All Blocks  And Data","", 
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        
        // assign the status variable
        if(radioBtnMarried.isSelected())
            status = "Married";
        else
            status = "Single";
        
        // assign the gender variable
        if (radioBtnFemale.isSelected())
            gender = "Female";
        else 
            gender = "Mael";
        
        
        // check the txtId
        if (id.equals("") || id.length() < 5 || !id.matches("[0-9]+")){
            labelIdError.setText("Id must be numbers, more than 4 digite");
            labelIdError.setVisible(true);
                
            return false;
        }
            
        else {
            labelIdError.setVisible(false);
            labelPasswordErro.setVisible(false);
            // check if the id number is uniqe or not 
            for (int index = 0; index < allDataFileArray.size(); index++) {
                if (id.equals(allDataFileArray.get(index).getId())){
                    labelIdError.setText("Your Id must be Uniqe");
                    labelIdError.setVisible(true);
                    return false;
                }
                    
            }
            
            
            
        }
        
        // save the data inside employees file 
        // Clear all data inside ArrayList of FileData
         

        allDataFileArray.clear();
        
        ArrayList<FileData> fileDataArray = new ArrayList<>();
        
       
        
        // read a file 
        File file = new File("employees.txt");
        //Construct the new file that will later be renamed to the original filename.
        File tempFile = new File("employees2.txt");

        int count = 0;
        try {
            FileReader fileReader = new FileReader(file); 
                BufferedReader br = new BufferedReader(fileReader);
                BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));
                
                String currentLine;

                while((currentLine = br.readLine()) != null) {
                    // trim newline when comparing with lineToRemove
                    String trimmedLine = currentLine.trim();
                    String [] array = trimmedLine.split("    ");
                        
                    fileDataArray.add(new FileData(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7]));   
                    bw.write(currentLine + System.getProperty("line.separator"));
                }
                
                fileDataArray.add(new FileData(id, name, password, department, hireDateTxt, address, gender, status));   
                bw.write(String.format("%s    %s    %s    %s    %s    %s    %s    %s", 
                        id, name, password, department, hireDateTxt, address, gender, status) + System.getProperty("line.separator"));
                bw.close();
                br.close();
                //    file.delete();
                //    tempFile.renameTo(new File("F:\\Java Applications\\PayRollSystem\\employees.txt"));
            }catch (Exception ex) {
                Logger.getLogger(EmployeeFrame.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            if (file.exists()) {
                file.delete();
            }
            tempFile.renameTo(new File("employees.txt"));

            FileData.setArray(fileDataArray);
            
            return true;
    }
    
    private String changeDateFormat(String oldFormat, String newFormat, String currentDate){
  
        String newDate = null;
        Date d = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat(oldFormat);
        SimpleDateFormat newDateFormat = new SimpleDateFormat(newFormat);
          try {
              d = dateFormat.parse(currentDate);
//              dateFormat.applyPattern(newFormat);
             
              newDate = newDateFormat.format(d.getTime());
              
              //newDate = dateFormat.format(d);
              return newDate;
          } catch (ParseException ex) {
              Logger.getLogger(DialogFrame.class.getName()).log(Level.SEVERE, null, ex);
          }
          return newDate;
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogFrame dialog = new DialogFrame(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> comDep;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labelIdError;
    private javax.swing.JLabel labelPassword;
    private javax.swing.JLabel labelPasswordErro;
    private javax.swing.JRadioButton radioBtnFemale;
    private javax.swing.JRadioButton radioBtnMael;
    private javax.swing.JRadioButton radioBtnMarried;
    private javax.swing.JRadioButton radioBtnSingle;
    private javax.swing.ButtonGroup radioGroupGender;
    private javax.swing.ButtonGroup radioGroupStatus;
    private javax.swing.JSpinner spinerHireDate;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
