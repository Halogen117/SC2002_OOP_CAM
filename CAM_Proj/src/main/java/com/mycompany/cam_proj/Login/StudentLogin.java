/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.Login;

import com.mycompany.cam_proj.User;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public class StudentLogin implements Login{
    private Authenticate auth = new Authenticate();
    public boolean runLogin(String fileLocation, ArrayList<User> studentList){
        if(!this.auth.return_authenticate(studentList)){
            System.out.println("Unverified Student! Try logging in again!");
            return false;
        }
        return true;
    }
    public User getUserCookie(){
        return this.auth.getUserCookie();
    }
    
    public boolean studentLogOut(){
        this.auth.clearUserCookie();
        return true;
    }
    
    // Set user Cookie?
}
