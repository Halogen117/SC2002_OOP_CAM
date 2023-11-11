/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam;

import com.mycompany.anothercam.User;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public class StaffList {
    public static ArrayList<User> staffList = new ArrayList<User>();

    public ArrayList<User> getStaffList(){
        return this.staffList;
    }
    
    public void setStaffList(ArrayList<User> staffList){
        this.staffList = staffList;
    }
    
    public void addStaffToList(User staffie){
        this.staffList.add(staffie);
    }
}
