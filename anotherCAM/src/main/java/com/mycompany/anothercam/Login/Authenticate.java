/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.Login;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
public class Authenticate {
    private User userCookie;
    public boolean return_authenticate(ArrayList<User> user_list, Scanner scanObj){
        //Scanner scanObj = new Scanner(System.in);
        System.out.println("What is your Username? ");
        String username = scanObj.next();
        System.out.println("What is your Password? ");
        String password = scanObj.next();
        for(User user : user_list){
            if((user.getUserID()).equals(username)){
                if((user.getPassword()).equals(password)){
                    this.userCookie = user; 
                    return true;
                }
            }
        }
        return false;
    }

    public User getUserCookie(){
        return this.userCookie;
    }
    
    public void clearUserCookie(){
        this.userCookie = null;
    }
}
