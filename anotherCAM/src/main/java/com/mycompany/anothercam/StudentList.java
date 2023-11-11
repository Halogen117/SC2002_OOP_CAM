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

    public ArrayList<User> getStudentList(){
        return this.studList;
    }
    
    public void setStudentList(ArrayList<User> studList){
        this.studList = studList;
    }
    
    public void addStudentToList(User stud){
        studList.add(stud);
    }
    
    public static boolean checkStudentInList(String userID){
        for(int i=0; i< studList.size(); i++){
            if(studList.get(i).getUserID().equals(userID)){
                return true;
            }
        }
        return false;
    }
    
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
