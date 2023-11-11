/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam;

/**
 *
 * @author Halogen
 */
public class Student extends User{
    private boolean campCommittee = false;
    private String campCommitteeName = null;
    private int points = 0;
    
    public Student(String userId, String email,String facultyInfo){
        super(userId, email, facultyInfo);
    }
    
    public boolean getCampCommittee(){
        return this.campCommittee;
    }

    public String getCampCommitteeName(){
        return this.campCommitteeName;
    }
    public int getPoints(){
        return this.points;
    }
    
    public void setCampCommittee(boolean campCommittee){
        this.campCommittee = campCommittee;
    }

    public void setCampCommitteeName(String campCommitteeName){
        this.campCommitteeName = campCommitteeName;
    }
    
    public void setPoints(int points){
        this.points = points;
    } 
    
    
    
    
}
