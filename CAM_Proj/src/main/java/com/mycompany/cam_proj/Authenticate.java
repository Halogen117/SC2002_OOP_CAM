/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
public class Authenticate {
    private User user_cookie;
    public boolean return_authenticate(ArrayList<User> user_list){
        Scanner scan_obj = new Scanner(System.in);
        System.out.println("What is your Username? ");
        String username = scan_obj.next();
        System.out.println("What is your Password? ");
        String password = scan_obj.next();
        for(User user : user_list){
            if((user.get_userID()).equals(username)){
                if((user.get_password()).equals(password)){
                    this.user_cookie = user; 
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean log_out(){
        this.user_cookie = null;
        return true;
    }
    public User get_user_cookie(){
        return this.user_cookie;
    }
}
