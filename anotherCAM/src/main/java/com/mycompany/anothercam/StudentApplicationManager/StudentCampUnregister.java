/**
Represents the StudentCampUnregister Object and the following assistance methods.
A StudentCampUnregister is ran dependent on how many users are going to unregister for the camp.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-5
*/
package com.mycompany.anothercam.StudentApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;



public class StudentCampUnregister {
    //private Scanner scanObj = new Scanner(System.in);
    
    /**
    * Runs the Student Unregister Application.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Student) which the requested user to unregisters the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runUnregister(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        if(checkCommitteeMember((Student) cookie)){
            System.out.println("As you are a Committee Member, you cannot quit the camp!");
            return false;
        }
        if(campArray.isEmpty()){
            System.out.println("No camps to register for!");
            return false;
        }else{
            System.out.println("We are sorry to see you go :( .");
            System.out.println("Unregister as a");
            System.out.println("0. Exit Unregister Main Menu");
            System.out.println("1. Camp Attendee");
            int choiceUnAttend = scanObj.nextInt();
            if(choiceUnAttend == 0){
                return false;
            }
            System.out.println("Which camp would you like to unregister?");
            StudentCampView studView = new StudentCampView();
            
            ArrayList<Integer> choice = studView.runViewCampListOut(campArray, cookie);
            int chooseChoice = scanObj.nextInt();
            if(choice == null){
                System.out.print("No Camps exist at the moment!");
                return true;
            }else if(!choice.contains(chooseChoice)){
                System.out.println("Choice outside of input! Exiting Unregister Main Menu!");
                return false;
            }
            System.out.println("Are you sure you want to register for Camp "+campArray.get(chooseChoice-1).getCampName()+"? (Y/N)");
            String yes_no = scanObj.next();
            
            if(yes_no.equals("Y") || yes_no.equals("YES")){
                // Check if student registered for other camps
                // Check if camp is full
                if(checkCampEmpty(campArray, chooseChoice)){
                    System.out.println("Camp is already empty!");
                    return false;
                }else if(checkAttendeeList(campArray, (Student) cookie) && choiceUnAttend == 1){
                    System.out.println("You are not an attendee in the camp!");
                    return false;
                }
                // This should be repurposed to remove the student if the request is successful
                if(choiceUnAttend == 1){
                    campArray.get(chooseChoice-1).removeStudentToList((Student) cookie);
                }
                /*
                else if(choiceUnAttend == 2){
                    // Check if camp Committee
                    if(!checkCampCommitteeRemove((Student) cookie, campArray, chooseChoice)){
                        System.out.println("You are not a camp committee member in this camp!");
                        return false;
                    }else{
                        if(!checkAttendeeList(campArray, (Student) cookie)){
                            campArray.get(chooseChoice-1).removeStudentToList((Student) cookie);
                        }
                            removeCampCommittee((Student) cookie);
                            campArray.get(chooseChoice-1).removeCampCommitteeMemberToList((Student) cookie); 
                    }
                }
                */
            }else if(yes_no.equals("N") || yes_no.equals("NO")){
                System.out.println("Exiting Register option!");
                return false;
            }
            return true;
        }
    }
    
    /**
    * Returns if the Student object is a camp committee member.
    * @param Stud takes in the Student Object to check if they are camp committee member
    * @return boolean value if student is part of camp committee or not.
    */
    public boolean checkCommitteeMember(Student Stud){
        return Stud.getCampCommittee();
    }
    

    public boolean checkCampEmpty(ArrayList<Camp> campArray, int chooseChoice){
        // Check if the camp is full
        if(campArray.get(chooseChoice-1).getCampStudentList().size() == 0 && campArray.get(chooseChoice-1).getCampCommitteeList().size() == 0){
            return true;
        }
        return false;

    }

    /**
    * Checks if the student is in the camp
    * @param Stud takes in the student object to be checked if they are an attendee.
    * @param campArray the CampArray which the new camp object is stored.
    * @return boolean value once the application has completed running. True if student not in. False if student in.
    */
    public boolean checkAttendeeList(ArrayList<Camp> campArray, Student Stud){
        for(int i=1; i<campArray.size(); i++){
            if(campArray.get(i-1).getCampStudentList().contains(Stud)){
                return false;
            }
        }
        return true;
    }
    
    /**
    * Applies the student for removes the student from the new camp committee member of the camp.
    * @param Stud takes in the student object to be applied to removed from new camp committee member.
    */
    public void removeCampCommittee(Student Stud){
        Stud.setCampCommittee(false);
        System.out.println("Successfully removed as Camp Committee Member!");
    }
    
    
    /**
    * Checks if the student is in the camp
    * @param choice takes in the arraylist of integer choices to be used to check attendee list.
    * @param Stud takes in the student object to be checked if they are an attendee.
    * @param campArray the CampArray which the new camp object is stored.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    * @param chooseChoice takes in the choice of camp to be check for the student.
    */
    /*
    public boolean checkCampCommitteeRemove(Student Stud, ArrayList<Camp> campArray, int chooseChoice){
        // If camp Committee matches name of 
        if(Stud.getCampCommitteeName().equals(campArray.get(chooseChoice-1).getCampName())){
            return true;
        }
        return false;
        
    }
    */
}

