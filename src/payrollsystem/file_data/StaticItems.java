/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payrollsystem.file_data;

import java.util.List;


/**
 *
 * @author User
 */
public class StaticItems {
    
    public static List<String>  departmentItem;

    public StaticItems() {
        departmentItem.add("Select ..... ");
        departmentItem.add("IT");
        departmentItem.add("Sales");
        departmentItem.add("Financial");
    }

    public static List<String> getDepartmentItem() {
        return departmentItem;
    }

    public static void setDepartmentItem(List<String> departmentItem) {
        StaticItems.departmentItem = departmentItem;
    }
    
    
    
    
    
}
