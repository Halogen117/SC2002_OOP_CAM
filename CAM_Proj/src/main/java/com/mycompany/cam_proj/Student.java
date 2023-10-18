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
    private boolean campCommittee = false;
    private int points = 0;
    
    public Student(String userId, String email,String facultyInfo){
        super(userId, email, facultyInfo);
    }
    
    public boolean get_campCommittee(){
        return this.campCommittee;
    }
    
    public int get_points(){
        return this.points;
    }
    
    public void set_campCommittee(boolean campCommittee){
        this.campCommittee = campCommittee;
    }
    
    public void set_points(int points){
        this.points = points;
    } 
    
    
    
    
}
