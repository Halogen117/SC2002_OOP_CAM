/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;

/**
 *
 * @author Halogen
 */
public class Student extends User{
    protected boolean campCommittee = false;
    protected int points = 0;
    
    public Student(String userId, String email,String facultyInfo){
        super(userId, email, facultyInfo);
    }
    
    
    
    
}
