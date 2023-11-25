package com.mycompany.anothercam.StudentApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
Represents the StudentStatusApp Object and the following assistance methods.
A StudentStatusApp can be run multiple times depending on the number of reports to be made.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-7
*/
public class StudentStatusApp{
    /**
    * Runs the Student Status Application to access main menu subsections.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Student) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStudentStatusApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        Student cookieStud = (Student) cookie;
        System.out.println("Student Status application");
        System.out.println("Student UserID: "+cookieStud.getUserName());
        System.out.println("Student Email: "+cookieStud.getEmail());
        System.out.println("Student Faculty: "+cookieStud.getFacultyInfo());
        if(cookieStud.getCampCommittee()){
            System.out.println("You are a Camp Committee Member of Camp "+cookieStud.getCampCommitteeName());
        }else{
            System.out.println("You are not a Camp Committee Member of any camp!");
        }
        
        System.out.println("Camps registered are: ");
        boolean passed = false;
        ArrayList<Integer> arryList = new ArrayList<Integer>();
        
        for(int i=1; i< campArray.size()+1; i++){
            //if((campArray.get(i-1).getFaculty().equals(cookieStud.getFacultyInfo()))&& campArray.get(i-1).getCampStudentList().get(cookieStud)){
            if(campArray.get(i-1).getCampCommitteeList().contains(cookieStud)){
                arryList.add(i-1);
                System.out.println(arryList.size()+". "+campArray.get(arryList.get(arryList.size()-1)).getCampName()+" (Committee Member)");
                passed = true;
            }else if(campArray.get(i-1).getCampStudentList().contains(cookieStud)){
                arryList.add(i-1);
                System.out.println(arryList.size()+". "+campArray.get(arryList.get(arryList.size()-1)).getCampName()+" (Attendee)");
                passed = true;
            }

        }
        if(passed = false){
            System.out.println("You are neither an attendee or committee member!");
        }
        return true;
    }
}
