/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem.file_data;

/**
 *
 * @author User
 */
public class FileData {
    
    private String Id;
    private String name;
    private String hireDate;
    private String departement;

    public FileData(String Id, String Name, String hireDate, String departement) {
        this.Id = Id;
        this.name = Name;
        this.hireDate = hireDate;
        this.departement = departement;
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

    public void setName(String Name) {
        this.name = Name;
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

    @Override
    public String toString() {
        return name + " hireDate " + hireDate + " Departement " + departement + " ID " + Id; //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
    
    
    
    
    
    
}
