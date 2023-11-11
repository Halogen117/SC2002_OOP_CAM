/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam;

/**
 *
 * @author Halogen
 */
public abstract class User {
    private String userID;
    private String password = "password";
    private String email;
    private String facultyInfo;
    
    public User(String userID, String email, String facultyInfo){
        this.userID = userID;
        this.email = email;
        this.facultyInfo = facultyInfo;
    }

    public String getEmail(){
        return this.email;
    }

    public String getFacultyInfo(){
        return this.facultyInfo;
    }

    public String getPassword(){
        return this.password;
    }
    public String getUserID(){
        return this.userID;
    }

    
    public void setEmail(String email){
        this.email = email;
    }

    public void setFacultyInfo(String facultyInfo){
        this.facultyInfo = facultyInfo;
    }

    public void setPassword(String password){
        this.password = password;
    }
    
    public void setUserID(String userID){
        this.userID = userID;
    }
}
