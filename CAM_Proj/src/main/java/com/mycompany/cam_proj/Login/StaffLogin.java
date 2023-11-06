/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.Login;

import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.compiledLists.StaffList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StaffLogin implements Login{
    private Authenticate auth = new Authenticate();
    public boolean runLogin(String fileLocation, Scanner scanObj){
        if(!auth.return_authenticate(StaffList.staffList, scanObj)){
            System.out.println("Unverified Staff! Try logging in again!");
            return false;
        }
        return true;
    }
    
    public User getUserCookie(){
        return this.auth.getUserCookie();
    }
    
    public boolean staffLogOut(){
        this.auth.clearUserCookie();
        return true;
    }
    
}
