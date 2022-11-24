/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFrame;

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
        
        
        
    }
    
}
