package com.mycompany.anothercam.StudentApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Login.Verification;
import java.time.LocalDateTime;

/**
Represents the StudentCampRegister Object and the following assistance methods.
A StudentCampRegister is ran dependent on how many users are going to register for the camp.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-27
*/
public class StudentCampRegister {
    /**
    * Runs the Student Register Application.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Student) which the requested user registers the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    
    public boolean runStudentRegister(ArrayList<Camp> campArray, Student cookie, Scanner scanObj){
        Verification verifier = new Verification();
        if(campArray.isEmpty()){
            System.out.println("No camps to register for!");
            return false;
        }else{
            System.out.println("Register as a");
            System.out.println("0. Exit Register Main Menu");
            System.out.println("1. Camp Attendee");
            System.out.println("2. Camp Committee Member");
            int choiceAttend = verifier.verifyScannerNumber(scanObj);
            if(choiceAttend == 0 || choiceAttend > 2){
                return false;
            }
            System.out.println("Which camp would you like to register?");
            StudentCampView studView = new StudentCampView();
            
            ArrayList<Integer> choice = null;
            if(choiceAttend == 1){
                choice = studView.runViewCampListOutAttendee(campArray, cookie);
            }else{
                choice = studView.runViewCampListOutCampCommittee(campArray, cookie);
            }
            int chooseChoice = verifier.verifyScannerNumber(scanObj);
            if(choice == null){
                System.out.print("No Camps exist at the moment!");
                return true;
            }else if(chooseChoice > choice.size()){
                System.out.println("Choice outside of input! Exiting Register Main Menu");
                return false;
            }else if(chooseChoice == 0){
                System.out.println("Exiting Register Main Menu!");
                return true;
            }
            System.out.println("Are you sure you want to register for Camp "+campArray.get(choice.get(chooseChoice-1)).getCampName()+"? (Y/N)");
            String yes_no = scanObj.next();
            
            if(yes_no.equals("Y") || yes_no.equals("YES")){
                // Check if student registered for other camps
                if(checkDateClash(choice, campArray,chooseChoice, cookie)){
                    return false;
                }else if(!checkDatePassed(choice, campArray,chooseChoice, cookie)){
                    return false;
                }else if(!checkRegistrationPass(choice, campArray,chooseChoice, cookie)){
                    return false;
                }
                
                else if(checkBlackList((Student) cookie, choice, campArray , chooseChoice)){
                    System.out.println("As you have already previously quitted this camp, you are not allowed to join it again!");
                    return false;
                }
                // Check if camp is full
                else if(checkCampFull(choice, campArray, chooseChoice)){
                    System.out.println("Camp is already full!");
                    return false;
                }else if(checkAttendeeList(choice, campArray, (Student) cookie, chooseChoice) && choiceAttend == 1){
                    System.out.println("You are already an attendee in the camp!");
                }

                if(choiceAttend == 1){
                    campArray.get(choice.get(chooseChoice-1)).addStudentToList(cookie);
                    System.out.println("Successfully registered for Camp "+campArray.get(choice.get(chooseChoice-1)).getCampName()+" as an attendee!");
                    return true;
                }else if(choiceAttend == 2){
                    // Check if camp Committee
                    if(checkCampCommittee(cookie)){
                        System.out.println("Students are capped at 1 camp committee member at the max!");
                    }else{
                        if(!checkAttendeeList(choice, campArray, (Student) cookie, chooseChoice)){
                            campArray.get(choice.get(chooseChoice-1)).addStudentToList(cookie);
                        }
                            cookie.setCampCommittee(true);
                            cookie.setCampCommitteeName(campArray.get(choice.get(chooseChoice-1)).getCampName());
                            campArray.get(choice.get(chooseChoice-1)).addCampCommitteeMemberToList(cookie); 
                            System.out.println("Successfully registered for Camp "+campArray.get(choice.get(chooseChoice-1)).getCampName()+" as a Camp Committee member!");
                            //for(Student campers : campArray.get(chooseChoice-1).getCampCommitteeList()){
                                //System.out.println(campers.getUserName());
                            //}
                            return true;
                    }
                }

            }else if(yes_no.equals("N") || yes_no.equals("NO")){
                System.out.println("Exiting Register option!");
                return false;
            }else{
                System.out.println("Invalid Input!");
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
    public boolean checkCampCommittee(Student Stud){
        return Stud.getCampCommittee();
    }
    
    /**
    * Returns to check if the camp student attendee is at full capacity.
    * @param choice takes in the arraylist of integer choices to be used to check attendee list.
    * @param campArray the CampArray which the new camp object is stored.
    * @param chooseChoice takes in the choice of camp to be check if it is full.
    * @return boolean value if the camp is filled. True if it is filled. False if it is not filled.
    */
    public boolean checkCampFull(ArrayList<Integer> choice, ArrayList<Camp> campArray, int chooseChoice){
        // Check if the camp is full
        //System.out.println(campArray.get(choice.get(chooseChoice-1)).getTotalSlot());
        //System.out.println("Committee Member");
        //for(Student camping : campArray.get(chooseChoice-1).getCampCommitteeList() ){
            //System.out.println(camping.getUserName());
        //}
        if(campArray.get(choice.get(chooseChoice-1)).getTotalSlot() - campArray.get(choice.get(chooseChoice-1)).getCampStudentList().size() > 0){
            return false;
        }
        return true;
    }

    
    /**
    * Checks if the student is in the camp
    * @param choice takes in the arraylist of integer choices to be used to check attendee list.
    * @param Stud takes in the student object to be checked if they are an attendee.
    * @param campArray the CampArray which the new camp object is stored.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    * @param chooseChoice takes in the choice of camp to be check for the student.
    */
    public boolean checkAttendeeList(ArrayList<Integer> choice, ArrayList<Camp> campArray, Student Stud, int chooseChoice){
            if(campArray.get(choice.get(chooseChoice-1)).getCampStudentList().contains(Stud)){
                return true;  
        }
        return false;
    }
    
    /**
    * Checks if the dates for the student will clash
    * @param choice takes in the arraylist of integer choices to be used to check for clashed dates.
    * @param Stud takes in the student object to be checked for clashed date.
    * @param campArray the CampArray which the new camp object is stored.
    * @param chooseChoice takes in the choice of camp to be check if the date clash.
    * @return returns true if the dates clash. Dates don't clash is false
    */
    public boolean checkDateClash(ArrayList<Integer> choice, ArrayList<Camp> campArray , int chooseChoice, Student Stud){
        // Check for the camps the student is in, if got date clash (Same day)
        DateFormatter formaDat  =new DateFormatter();
        for(int i=0; i< choice.size(); i++){
            if(campArray.get(choice.get(i)).getCampStudentList().contains(Stud)){
                if((formaDat.clashDates(campArray.get(choice.get(i)).getDate(), campArray.get(choice.get(chooseChoice-1)).getDate()))== true){
                    System.out.println("Unable to register yourself into the camp as it clashes with another camp date");
                    return true;
                } 
            }
        }
        return false;

    }
    
    /**
    * Checks if the registration has closed for the date
    * @param choice takes in the arraylist of integer choices to be used to check for clashed dates.
    * @param Stud takes in the student object to be checked for clashed date.
    * @param campArray the CampArray which the new camp object is stored.
    * @param chooseChoice takes in the choice of camp to be check if the date clash.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean checkRegistrationPass(ArrayList<Integer> choice, ArrayList<Camp> campArray , int chooseChoice, Student Stud){
        DateFormatter formaDat  =new DateFormatter();
        // Check Locatimenow
        if(formaDat.compareDateAndTime(campArray.get(choice.get(chooseChoice-1)).getDate() , LocalDateTime.now())==1){
            System.out.println("The camp's deadline has already passed!");
            return false;
        // Check registration date closed 
        }else if(formaDat.compareDateAndTime(LocalDateTime.now(), campArray.get(choice.get(chooseChoice-1)).getRegClosingDate())==0){
            System.out.println("The registration has closed for this camp!");
            return false; 
        }
        return true;
        
    }
    
    /**
    * Checks if the Day of the camp has already passed the current time
    * @param choice takes in the arraylist of integer choices to be used to check for clashed dates.
    * @param Stud takes in the student object to be checked for clashed date.
    * @param campArray the CampArray which the new camp object is stored.
    * @param chooseChoice takes in the choice of camp to be check if the date clash.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean checkDatePassed(ArrayList<Integer> choice, ArrayList<Camp> campArray , int chooseChoice, Student Stud){
        DateFormatter formaDat  =new DateFormatter();
        // Check Locatimenow
        if(formaDat.compareDateAndTime(campArray.get(choice.get(chooseChoice-1)).getDate() , LocalDateTime.now())==1){
            System.out.println("The day of the camp has already been initiated!");
            return false;
        // Check registration date closed 
        }
        return true;
    }
    
    
    /**
    * Checks if the Student is blacklisted from the camp
    * @param choice takes in the arraylist of integer choices to be used to check for clashed dates.
    * @param Stud takes in the student object to be checked for clashed date.
    * @param campArray the CampArray which the new camp object is stored.
    * @param chooseChoice takes in the choice of camp to be check if the date clash.
    * @return boolean value whether the user is indeed blacklisted. True for successful run. False for unknown exit.
    */
    public boolean checkBlackList(Student Stud, ArrayList<Integer> choice, ArrayList<Camp> campArray , int chooseChoice){
        for(int i=0; i< Stud.getBlackList().size(); i++){
            if(campArray.get(choice.get(chooseChoice-1)).getCampID() == Stud.getBlackList().get(i)){
                return true;
                
            }
        }
    return false;
    }
}
