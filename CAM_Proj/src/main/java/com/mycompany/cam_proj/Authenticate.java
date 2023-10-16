/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
public class Authenticate {
    public boolean return_authenticate(User[] user_list){
        Scanner scan_obj = new Scanner(System.in);
        System.out.println("What is your Username?: ");
        String username = scan_obj.next();
        System.out.println("What is your Password?: ");
        String password = scan_obj.next();
        for(User user : user_list){
            if(user.userID == username){
                if(user.password == password){
                    return true;
                }
            }
        }
        return false;
    }
}
