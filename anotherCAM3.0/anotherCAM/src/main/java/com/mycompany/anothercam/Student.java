/**
Represents the Student Object and the following mutator methods.
A student can register for multiple camps.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam;

import java.util.ArrayList;


public class Student extends User{
    private boolean campCommittee = false;
    private String campCommitteeName = null;
    private int points = 0;
    
    /**
    * The Student Constructor.
    * The User interface is extended to this class.
    * @param userID The unique userID of the Student.
    * @param email The email of the Student.
    * @param facultyInfo The faculty of the Student is in.
    */
    
    public Student(String userID, String email,String facultyInfo){
        super(userID, email, facultyInfo);
    }
    
    /**
    * Gets the boolean value if the Student is a camp committee of the Student Object.
    * @return the boolean value if a student is in a Camp Committee or not of the camp.
    */
    public boolean getCampCommittee(){
        return this.campCommittee;
    }

    /**
    * Gets the value of name of the camp which the student is a camp committee of the Student Object.
    * @return the String value of the name of Camp Committee the student is in.
    */
    public String getCampCommitteeName(){
        return this.campCommitteeName;
    }
    
    /**
    * Gets the point count of the student of the Student Object.
    * @return the integer value of point count of the student.
    */
    public int getPoints(){
        return this.points;
    }
    
    /**
    * Changes the boolean value of the student if they are a camp committee member in the Student Object
    * @param campCommittee This camp's new faculty must be a LocalDateTime object.
    *                The validation is already done before the method is called.
    */
    public void setCampCommittee(boolean campCommittee){
        this.campCommittee = campCommittee;
    }

    /**
    * Changes the camp which the student is in the camp committee of of the Student Object
    * @param campCommitteeName This camp's new faculty must be a LocalDateTime object.
    *                The validation is already done before the method is called.
    */
    public void setCampCommitteeName(String campCommitteeName){
        this.campCommitteeName = campCommitteeName;
    }
    
    /**
    * Changes the integer value of the point count of the Student Object
    * @param points This camp's new points must be an integer.
    *                The validation is already done before the method is called.
    */
    public void setPoints(int points){
        this.points = points;
    } 

    
}
