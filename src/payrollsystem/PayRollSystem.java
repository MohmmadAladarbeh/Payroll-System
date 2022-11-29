/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import payrollsystem.file_data.FileData;

/**
 *
 * @author User
 */
public class PayRollSystem {

    /**
     */
    
    public static void main(String[] args) {
        
        // LoginFrame Instance 
        LoginFrame mainJFrame = new LoginFrame();
        mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainJFrame.setVisible(true);
        mainJFrame.setSize(900, 800);
        
        ArrayList <FileData> fileDataArray = new ArrayList<> ();

       
        try {
            File file = new File ("employees.txt");
            FileReader fileReader = new FileReader (file);
            BufferedReader br = new BufferedReader(fileReader);
            String currentLine1;
            while((currentLine1 = br.readLine()) != null) {
                // trim newline when comparing with lineToRemove
                String trimmedLine = currentLine1.trim();
                String [] arrLine = trimmedLine.split("    ");
                fileDataArray.add (new FileData(arrLine[0], arrLine[1], arrLine[2], arrLine[3], arrLine[4], arrLine[5], arrLine[6], arrLine[7]));
            }
            fileReader.close();
            br.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PayRollSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PayRollSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // set fileDataArray ArrayList to the FileData class (Model)
        FileData.setArray(fileDataArray);
        
        
        
        
        
    }
    
}
