package com.mycompany.anothercam.StudentApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.StudentCommitteeApplicationManager.StudentCommitteeApp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
Represents the StudentCampApp Object and the following assistance methods.
A StudentCampApp is only run once.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-1
*/
public class StudentApp{
    private DateFormatter date_format = new DateFormatter();
    private final LocalDateTime today  = date_format.convertStringToDatetime(date_format.convertDatetimeToString(LocalDateTime.now()));
    
    /**
    * Runs the Student Application to access main menu subsections.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStudentApp(ArrayList<Camp> campArray, Student cookie, Scanner scanObj){
        Verification verifier = new Verification();
        boolean loopCont = true;
        while(loopCont){
            if(cookie == null){
                loopCont = false;
                break;
            }
            System.out.println("WELCOME STUDENT "+cookie.getUserName()+":");
            System.out.println("0. Log out!");
            System.out.println("1. Camp Subsection");
            // Enquiry
            System.out.println("2. Enquiry Subsection");
            System.out.println("3. Access Status Subsection");
            System.out.println("4. Access Student Committee Menu Subsection");
            System.out.println("5. Change Password");
            int what_to_do = verifier.verifyScannerNumber(scanObj);
            switch(what_to_do){
                case 1:
                    StudentCampApp studentCamper = new StudentCampApp();
                    studentCamper.runStudentCampApp(campArray, cookie, scanObj);
                    break;
                case 2:
                    EnquiryStudentApp studentEnquiry = new EnquiryStudentApp();
                    studentEnquiry.runEnquiryStudentApp(campArray, cookie, scanObj);
                    break;
                case 3:
                    System.out.println("Accessing Student Status Subsection!");
                    StudentStatusApp statStud = new StudentStatusApp();
                    statStud.runStudentStatusApp(campArray, cookie,scanObj);
                    break;
                    
                case 4:
                    try{
                        System.out.println("Attempting to access Student Committee Main Menu");
                        if(checkCommitteeMember((Student) cookie)){
                            StudentCommitteeApp commiApp = new StudentCommitteeApp();
                            commiApp.runStudentCommitteeApp(campArray, cookie, scanObj);
                        }else{
                            System.out.println("You are not a Student Committee Member!");
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                    break;

                case 5:
                    System.out.println("Please type in your new password!");
                    String change_password = scanObj.next();
                    cookie.setPassword(change_password);
                    System.out.println("Password has been changed!");
                    System.out.println("Logging out due to password change!");
                    loopCont = false;
                    break;
                case 0, -1:
                    loopCont = false;
                    break;
                default:
                    System.out.println("Invalid Input! Please Try again!");
                    break;
                }
        }
        return true;
    }
    
    /**
     * Checks if the Student is a camp Committee
     * @param stud User object passed into the variable.
     * @return boolean value if the student is a camp committee member.
     */
    public boolean checkCommitteeMember(Student stud){
        return stud.getCampCommittee();
    }
}
