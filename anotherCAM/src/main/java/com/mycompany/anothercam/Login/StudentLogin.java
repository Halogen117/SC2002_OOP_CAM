/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.Login;

import com.mycompany.anothercam.User;
import com.mycompany.anothercam.StudentList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentLogin implements Login{
    private Authenticate auth = new Authenticate();
    public boolean runLogin(String fileLocation, Scanner scanObj){
        if(!this.auth.return_authenticate(StudentList.studList, scanObj)){
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
