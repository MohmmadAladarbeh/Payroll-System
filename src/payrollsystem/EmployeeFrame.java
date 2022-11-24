/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import com.sun.rowset.internal.Row;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import payrollsystem.file_data.FileData;

/**
 *
 * @author User
 */
public class EmployeeFrame extends javax.swing.JFrame {

    
    int idIndex = 0, usernameIndex = 0, deptIndex = 0, hireDateIndex = 0, rowCount = 0;
    DefaultTableModel model;

    ArrayList<FileData> allDataFile = new ArrayList<>();

    /**
     * Creates new form EmployeeFrame
     */
    public EmployeeFrame() {
        
        
 
        initComponents();        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JButton();
        txtEmpId = new javax.swing.JTextField();
        txtEmpName = new javax.swing.JTextField();
        comDep = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        empTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(35, 167, 233));
        jLabel1.setText("Employees");

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/id.png"))); // NOI18N
        jLabel2.setText("Employee ID");

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/hierarchy.png"))); // NOI18N
        jLabel3.setText("Department");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 0, 16)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/user_icon.png"))); // NOI18N
        jLabel4.setText("Employee Name");

        btnSearch.setBackground(new java.awt.Color(35, 167, 233));
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/payrollsystem/image/search.png"))); // NOI18N
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        txtEmpId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpIdActionPerformed(evt);
            }
        });

        txtEmpName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtEmpName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmpNameActionPerformed(evt);
            }
        });

        comDep.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comDep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "IT", "Sales", "Financial" }));

        empTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee Id", "Employee Name", "Hire Date", "Department"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empTable.getTableHeader().setReorderingAllowed(false);
        empTable.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                empTableComponentAdded(evt);
            }
        });
        jScrollPane1.setViewportView(empTable);
        if (empTable.getColumnModel().getColumnCount() > 0) {
            empTable.getColumnModel().getColumn(0).setHeaderValue("Employee Id");
            empTable.getColumnModel().getColumn(1).setHeaderValue("Employee Name");
            empTable.getColumnModel().getColumn(2).setHeaderValue("Hire Date");
            empTable.getColumnModel().getColumn(3).setHeaderValue("Department");
        }

        jMenu1.setText("Main");
        jMenu1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu1MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Logout");
        jMenu2.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                jMenu2MenuSelected(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(157, 157, 157)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comDep, 0, 197, Short.MAX_VALUE))))
                        .addGap(128, 128, 128))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(comDep))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmpName, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu1MenuSelected
        this.setVisible(false);
        MainFrame mainFrame = new MainFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(900, 800);
        mainFrame.setVisible(true);
    }//GEN-LAST:event_jMenu1MenuSelected

    private void jMenu2MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_jMenu2MenuSelected
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        loginFrame.setSize(900, 800);
        this.setVisible(false);
    }//GEN-LAST:event_jMenu2MenuSelected

    private void txtEmpIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpIdActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSearchActionPerformed

    private void txtEmpNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmpNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmpNameActionPerformed

    private void empTableComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_empTableComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_empTableComponentAdded

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        
        
        
        // Fetch the data from users inputs.
        String id = txtEmpId.getText();
        String name = txtEmpName.getText();
        String dept = comDep.getSelectedItem().toString();
        model = (DefaultTableModel) empTable.getModel();
        
        // Clear All data inside the table 
        if (model.getRowCount() > 0) {
            while (model.getRowCount() > 0){
                for (int i = 0; i < model.getRowCount(); ++i){
                    model.removeRow(i);
                }
            }
        }
        
        search(name, id, dept);
       
           
        
        
    }//GEN-LAST:event_btnSearchMouseClicked

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
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmployeeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox<String> comDep;
    private javax.swing.JTable empTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEmpId;
    private javax.swing.JTextField txtEmpName;
    // End of variables declaration//GEN-END:variables
    
    
    
    // Search Method 
    private void search (String username, String id, String departement) {
            
            String[] tabelData = new String[model.getColumnCount()];
            int count = 0;
        
            // Read a file form local machine
            File f = new File("E:\\Java Projects\\PayRollSystem\\employees.txt");
            try{
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);

                
                
                while(br.ready()){

                    // split every line inside a txt file to array accoording to the "    "
                    String [] arrLine = br.readLine().split("    ");
                    
                    if (count == 0)
                    for (int index = 0; index < arrLine.length; index++) {
                        if (arrLine[index].equals("Name"))
                            usernameIndex = index;
                        if (arrLine[index].equals("Id"))
                            idIndex = index;
                        if (arrLine[index].equals("Department"))
                            deptIndex = index;
                        if (arrLine[index].equals ("HireDate"))
                            hireDateIndex = index;
                        if (index == arrLine.length)
                            continue;
                        count++;
                    }
                    else{
                    if (username.equals("") && id.equals("")){
                        if (!departement.equals("All")){
                            
                            if (departement.equals(arrLine[deptIndex])){
                                tabelData[0] = arrLine[idIndex];                    
                                tabelData[1] = arrLine[usernameIndex];
                                tabelData[2] = arrLine[hireDateIndex];
                                tabelData[3] = arrLine[deptIndex];
                                model.addRow(tabelData);

                            }
                               
                        }else {
                            tabelData[0] = arrLine[idIndex];                    
                            tabelData[1] = arrLine[usernameIndex];
                            tabelData[2] = arrLine[hireDateIndex];
                            tabelData[3] = arrLine[deptIndex];
                            model.addRow(tabelData);
                        }
                        
                        }else {
                            if (id.equals("")){
                                if (username.equals(arrLine[usernameIndex]) ){
                                    tabelData[0] = arrLine[idIndex];                    
                                    tabelData[1] = arrLine[usernameIndex];
                                    tabelData[2] = arrLine[hireDateIndex];
                                    tabelData[3] = arrLine[deptIndex];
                                    model.addRow(tabelData);
                                }
                            }
                            if (username.equals("")){
                                if (id.equals(arrLine[idIndex]) ){
                                tabelData[0] = arrLine[idIndex];                    
                                tabelData[1] = arrLine[usernameIndex];
                                tabelData[2] = arrLine[hireDateIndex];
                                tabelData[3] = arrLine[deptIndex];
                                model.addRow(tabelData);
                                }
                            }if (!username.equals("") && !id.equals("")){
                                if (id.equals(arrLine[idIndex]) && username.equals(arrLine[usernameIndex])){
                                    tabelData[0] = arrLine[idIndex];                    
                                    tabelData[1] = arrLine[usernameIndex];
                                    tabelData[2] = arrLine[hireDateIndex];
                                    tabelData[3] = arrLine[deptIndex];
                                    model.addRow(tabelData);
                                }
                            }
                    }
                    allDataFile.add(new FileData(tabelData[0], tabelData[1], tabelData[2],tabelData[3]));

            }
            }
            
            }
            catch(Exception e){
            System.out.println(e);
        }     
            
        
    }


}
