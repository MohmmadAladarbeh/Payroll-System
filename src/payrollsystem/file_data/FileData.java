/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem.file_data;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class FileData {
    
    private String Id;
    private String name;
    private String hireDate;
    private String departement;
    private String address;
    private String gender;
    private String state;
    private String passwrod;
    public static ArrayList <FileData> array;

    public FileData() {
    }

    
    
    
    public FileData(String Id, 
            String name, 
            String password, 
            String departement, 
            String hireDate, 
            String address, 
            String gender, 
            String state) {
        this.Id = Id;
        this.name = name;
        this.passwrod = password;
        this.departement = departement;
        this.address = address;
        this.gender = gender;
        this.state = state;
        this.hireDate = hireDate;
    }

    public static ArrayList<FileData> getArray() {
        return array;
    }

    public static void setArray(ArrayList<FileData> array) {
        FileData.array = array;
    }

    

    
    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String Gender) {
        this.gender = Gender;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    

    

    @Override
    public String toString() {
        return "Name " + name + 
                " HireDate " + hireDate + 
                " Address " + address + 
                " Gender " + gender + 
                " State " + state + 
                " Departement " + departement + 
                " ID " + Id; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    
}
