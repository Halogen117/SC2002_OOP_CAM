/**
Represents the StaffList Object and the following mutator methods.
A staffList has multiple staff members in it.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam;
import java.util.ArrayList;

public class StaffList {
    public static ArrayList<User> staffList = new ArrayList<User>();

    /**
    * Gets the Staff ArrayList object retrieved from the excel sheets in the camp.
    * @return the Staff ArrayList object from the excel sheets.
    */
    public ArrayList<User> getStaffList(){
        return this.staffList;
    }
    
    /**
    * Changes the ArrayList of Staff retrieved from the excel sheets.
    * @param staffList This camp's new Staff ArrayList of camp Committee Members should be passed as such.
    *                  The validation is already done before the method is called.
    */
    public void setStaffList(ArrayList<User> staffList){
        this.staffList = staffList;
    }
    
    /**
    * Adds a Staff Object to the ArrayList of Staff from the excel sheets.
    * @param staffie This new staff object passed should be a Staff object.
    *                The validation is already done before the method is called.
    */
    public void addStaffToList(User staffie){
        this.staffList.add(staffie);
    }
    
    /**
    * Removes a Staff Object to the ArrayList of Staff from the excel sheets.
    * @param staffie This new staff object passed should be a Staff object.
    *                The validation is already done before the method is called.
    */
    public void removeStaffToList(User staffie){
        this.staffList.remove(staffie);
    }
}
