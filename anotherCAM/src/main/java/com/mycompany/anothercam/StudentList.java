/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam;

import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.User;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
public class StudentList {
    public static ArrayList<User> studList = new ArrayList<User>();

    /**
    * Gets the Student ArrayList object retrieved from the excel sheets in the camp.
    * @return the Student ArrayList object from the excel sheets.
    */
    public ArrayList<User> getStudentList(){
        return this.studList;
    }
    
    /**
    * Changes the ArrayList of Student retrieved from the excel sheets.
    * @param studList This camp's new Student ArrayList of camp Committee Members should be passed as such.
    *                  The validation is already done before the method is called.
    */
    public void setStudentList(ArrayList<User> studList){
        this.studList = studList;
    }
    
    /**
    * Adds a Student Object to the ArrayList of Student from the excel sheets.
    * @param stud This new student object passed should be a Staff object.
    *                The validation is already done before the method is called.
    */
    public void addStudentToList(User stud){
        studList.add(stud);
    }
    
    /**
    * Checks if a Student if it is in the ArrayLists. 
    * @param userID This value passed is the unique studentID.
    *               If inside, return true.
    *               Or else return false instead.  
    */
    public static boolean checkStudentInList(String userID){
        for(int i=0; i< studList.size(); i++){
            if(studList.get(i).getUserID().equals(userID)){
                return true;
            }
        }
        return false;
    }
    
    /**
    * Returns a Student object if student is found.
    * @param userID This value passed is the unique studentID.
    *               If inside, return a student object.
    *               Or else return null.  
    */
    public static User returnStudentCookie(String userID){
        if(checkStudentInList(userID)){
            for(int i=0; i< studList.size(); i++){
                if(studList.get(i).getUserID().equals(userID)){
                    return studList.get(i);
                }
            }
        }
        return null;
    }
}
