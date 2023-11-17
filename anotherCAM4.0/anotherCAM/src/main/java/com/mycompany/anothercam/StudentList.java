/**
Represents the StudentList Object and the following mutator methods.
A studentList has multiple staff members in it.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam;
import java.util.ArrayList;


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
    
    /**
    * Returns faculty which the students are in as a String ArrayList. 
    * @return the String ArrayList of the faculties the students are in.
    */
    public ArrayList<String> getFacultyStudentList(){
        ArrayList<String> facultyList = new ArrayList<String>();
        for(int i=0; i< studList.size(); i++){
            if(!facultyList.contains(StudentList.studList.get(i).getFacultyInfo())){
                facultyList.add(StudentList.studList.get(i).getFacultyInfo());
            } 
        }
        return facultyList;
    }
}
