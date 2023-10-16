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
    public String userID;
    private String password = "password";
    private String email;
    private String facultyInfo;
    
    public User(String userID, String email, String facultyInfo){
        this.userID = userID;
        this.email = email;
        this.facultyInfo = facultyInfo;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
}
