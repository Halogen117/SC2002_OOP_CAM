/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;

/**
 *
 * @author Halogen
 */
public class User {
    private String userID;
    private String password = "password";
    private String email;
    private String facultyInfo;
    
    public User(String userID, String email, String facultyInfo){
        this.userID = userID;
        this.email = email;
        this.facultyInfo = facultyInfo;
    }

    

    
    public String get_email(){
        return this.email;
    }

    public String get_facultyInfo(){
        return this.facultyInfo;
    }

    public String get_password(){
        return this.password;
    }
    public String get_userID(){
        return this.userID;
    }

    
    public void set_email(String email){
        this.email = email;
    }

    public void set_facultyInfo(String facultyInfo){
        this.facultyInfo = facultyInfo;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
    public void set_userID(String userID){
        this.userID = userID;
    }
}
