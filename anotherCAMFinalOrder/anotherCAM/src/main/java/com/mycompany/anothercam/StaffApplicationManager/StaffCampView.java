/**
Represents the StaffCampView Object and the following assistor methods.
A StaffCampEdit can be called multiple times depending on how many camps to be viewed.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffCampView{
    /**
    * Runs the Staff View Application..
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @param onlyYourOwn Checks if the staff viewing the camp is viewing for the camps that the user created
    * @return the boolean value whether the viewing of camp object was successful.
    */
    public boolean runStaffViewCamp(ArrayList<Camp> campArray, User cookie, Scanner scanObj, boolean onlyYourOwn){
        if(campArray.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            if(!onlyYourOwn){
                for(int i=1; i< campArray.size()+1; i++){
                    if(campArray.get(i-1).getVisiblility() == Camp.visibilityStatus.NOVISIBILE){
                        System.out.println("Camp Number "+i+" on display! Visible to: Staff Only!");
                    }
                    else if(campArray.get(i-1).getVisiblility() == Camp.visibilityStatus.FACULTY){
                        System.out.println("Camp Number "+i+" on display! Visible to: Staff and students in Staff-In-Charge Faculty!");
                    }else if(campArray.get(i-1).getVisiblility() == Camp.visibilityStatus.ENTIRESCHOOL){
                        System.out.println("Camp Number "+i+" on display! Visible to: Everyone in NTU!");
                    }

                    System.out.println("The camp name is "+campArray.get(i-1).getCampName()+".");
                    System.out.println("The date the camp starts is on "+campArray.get(i-1).getDateString()+".");
                    System.out.println("The registration date the camp ends is on "+campArray.get(i-1).getRegClosingDateString()+".");
                    System.out.println("The location of the camp is "+campArray.get(i-1).getLocation()+".");
                    System.out.println("The total slots available in the camp are "+campArray.get(i-1).getTotalSlot()+".");
                    int remainingSlots = campArray.get(i-1).getTotalSlot()-campArray.get(i-1).getCampStudentList().size();
                    System.out.println("The total remaining slots available in the camp are "+remainingSlots+".");
                    if(campArray.get(i-1).getCampCommitteeList().isEmpty()){
                        System.out.println("There are no camp committee members that exist at the moment.");
                    }else{
                        System.out.println("The camp committee members so far are ");
                        for(Student stud: campArray.get(i-1).getCampCommitteeList()){
                            System.out.println(stud.getUserName());
                        }
                    }
                    System.out.println("The description of the camp is "+campArray.get(i-1).getDescription()+".");
                    System.out.println("The faculty of the camp it is under is "+campArray.get(i-1).getFaculty()+".");
                    System.out.println("The staff in charge of the camp is "+campArray.get(i-1).getStaffInCharge()+".");
                    // Find a way to check if student_list is empty
                    if(campArray.get(i-1).getCampStudentList().isEmpty()){
                        System.out.println("There are no students who signed up for the camp at the moment!");
                    }else{
                        System.out.println("The students in the camp so far are ");
                        for(Student stud: campArray.get(i-1).getCampStudentList()){
                            System.out.println(stud.getUserName());
                        }
                    }
                System.out.println("===========================================");
                }
            }else{
                ArrayList<Integer> arryList = new ArrayList<Integer>();

                for(int j=0; j< campArray.size(); j++){
                    if(campArray.get(j).getStaffInCharge().equals(cookie.getUserID())){
                        arryList.add(j);
                    }
                }
                if(arryList.isEmpty()){
                    System.out.println("No Camps that you created exist!");
                }
                for(int i=1; i< arryList.size()+1; i++){
                    if(campArray.get(arryList.get(i-1)).getVisiblility() == Camp.visibilityStatus.NOVISIBILE){
                        System.out.println("Camp Number "+i+" on display! Visible to: Staff Only!");
                    }
                    else if(campArray.get(arryList.get(i-1)).getVisiblility() == Camp.visibilityStatus.FACULTY){
                        System.out.println("Camp Number "+i+" on display! Visible to: Staff and students in Staff-In-Charge Faculty!");
                    }else if(campArray.get(arryList.get(i-1)).getVisiblility() == Camp.visibilityStatus.ENTIRESCHOOL){
                        System.out.println("Camp Number "+i+" on display! Visible to: Everyone in NTU!");
                    }
                    System.out.println("The camp name is "+campArray.get(arryList.get(i-1)).getCampName()+".");
                    System.out.println("The date the camp starts is on "+campArray.get(arryList.get(i-1)).getDateString()+".");
                    System.out.println("The registration date the camp ends is on "+campArray.get(arryList.get(i-1)).getRegClosingDateString()+".");
                    System.out.println("The location of the camp is "+campArray.get(arryList.get(i-1)).getLocation()+".");
                    System.out.println("The total slots available in the camp are "+campArray.get(arryList.get(i-1)).getTotalSlot()+".");
                    int remainingSlots = campArray.get(arryList.get(i-1)).getTotalSlot()-campArray.get(arryList.get(i-1)).getCampStudentList().size();
                    System.out.println("The total remaining slots available in the camp are "+remainingSlots+".");
                    if(campArray.get(arryList.get(i-1)).getCampCommitteeList().isEmpty()){
                        System.out.println("There are no camp committee members that exist at the moment.");
                    }else{
                        System.out.println("The camp committee members so far are ");
                        for(Student stud: campArray.get(arryList.get(i-1)).getCampCommitteeList()){
                            System.out.println(stud.getUserName());
                        }
                    }
                    System.out.println("The description of the camp is "+campArray.get(arryList.get(i-1)).getDescription()+".");
                    System.out.println("The faculty of the camp it is under is "+campArray.get(arryList.get(i-1)).getFaculty()+".");
                    System.out.println("The staff in charge of the camp is "+campArray.get(arryList.get(i-1)).getStaffInCharge()+".");
                    // Find a way to check if student_list is empty
                    if(campArray.get(arryList.get(i-1)).getCampStudentList().isEmpty()){
                        System.out.println("There are no students who signed up for the camp at the moment!");
                    }else{
                        System.out.println("The students in the camp so far are ");
                        for(Student stud: campArray.get(arryList.get(i-1)).getCampStudentList()){
                            System.out.println(stud.getUserName());
                        }
                    }
                System.out.println("===========================================");
                }
                
            }
        }
        return true;
    }
}
