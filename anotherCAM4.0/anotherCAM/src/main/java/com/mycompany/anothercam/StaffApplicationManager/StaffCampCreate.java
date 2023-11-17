/**
Represents the StaffCampCreate Object and the following assistance methods.
A StaffCampCreate can be called multiple times depending on how many camps to be made
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Camp.visibilityStatus;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.Staff;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.Student;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffCampCreate{
    private DateFormatter dateFormat = new DateFormatter();
    private Verification verify = new Verification();
    private LocalDateTime today = this.dateFormat.convert_string_to_datetime(this.dateFormat.convert_datetime_to_string(LocalDateTime.now()));
    
    /**
    * Gets the camp name of the Camp Object.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return the boolean value whether the creation of camp object was successful.
    */
    public boolean runStaffCreateCamp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        int campID;
        String question_to_ask = null;
        String campName = null;
        LocalDateTime date = null;
        LocalDateTime reg_closing_date = null;
        String location = null;
        int total_slot = -1;
        int CampCommitteeSlots = -1;
        ArrayList<Student> campCommitteeList;
        String description = null;
        // -1 for error. 0 for No visiblity. 1 for visible to fac. 2 for visible to whole school
        int true_false = -1;
        visibilityStatus visibility = visibilityStatus.NOVISIBILE;

        if(cookie instanceof Staff){
            System.out.println("Creating camp!");
            // Check how many camps already inside
            question_to_ask ="What is the camp name? ";
            campName = this.verify.verifyCampName(campName, question_to_ask, scanObj);
            if(campName == null){
                System.out.println("Camp Name cannot be null!");
                return false;

            }else if(checkDuplicateCamp(campArray, campName)){
                System.out.println("Duplicated Camp Name!");
                return false;
            }

            System.out.println("Date of Camp Initialization");
            date = this.dateFormat.generate_date(scanObj);
            if(date == null){
                System.out.println("Date of Camp Time Inputs were invalid!");
                return false;
            }else if(this.dateFormat.compareDateAndTime(date, this.today)== 1){
                System.out.println("The date of the camp cannot be earlier than the predefined timing of today!");
                return false;
            }
            System.out.println("Input Closing Registration Date of Camp");
            reg_closing_date = this.dateFormat.generate_date(scanObj);

            if(reg_closing_date == null){
                System.out.println("Date of Camp Time Inputs were invalid!");
                return false;
            }else if(this.dateFormat.compareDateAndTime(date, reg_closing_date) == 1){
                System.out.println("The date of the camp cannot be earlier than the registration closing date!");
                return false;
            }

            question_to_ask = "Where is the camp located? ";
            location = this.verify.verifyCampLocation(location, question_to_ask, scanObj);
            if(location == null){
                location = "NO LOCATION SPECIFIED";
            }

            
            question_to_ask = "How many camp committee members are participating in the camp? ";
            CampCommitteeSlots = this.verify.verifyCampCommittee(CampCommitteeSlots, question_to_ask, scanObj);
            if(CampCommitteeSlots==-1){
                return false;
            }else{
                campCommitteeList = new ArrayList<Student>();
            }
            
            question_to_ask = "How many students are to participate in the camp? ";
            total_slot = this.verify.verifyTotalStudents(total_slot, CampCommitteeSlots,question_to_ask, scanObj);
            if(total_slot == -1){
                return false;
            }

            question_to_ask = "Please type the description of the camp ";
            description = this.verify.verifyDescription(description, question_to_ask, scanObj);
            if(description==null){
                description = "NO DESCRIPTION FILLED";
            }

            String staff_in_charge = cookie.getUserID();
            question_to_ask = "Do you want this camp to be visible to students?\n"
                    + "1. Visible to no one \n"
                    + "2. Visible only to the staff-in-charge's faculty \n"
                    + "3. Visible to the entire school.";
            visibility = this.verify.verifyToggleVisiblity(true_false, question_to_ask, scanObj);

            String faculty = cookie.getFacultyInfo();

            // get campID
            campID = campArray.size()+1;
            Camp new_camp = new Camp(campID, campName, date, reg_closing_date, location, total_slot, CampCommitteeSlots,campCommitteeList, description, staff_in_charge, visibility, faculty);
            campArray.add(new_camp);
            return true;
        }else{
            System.out.println("As a student you are not allowed to create a camp!");
            return false;
        }
    }
    
    /**
    * Checks if a duplicate camp exists in the Camp Array.
    * @param campArray the CampArray which the new camp object is stored.
    * @param campName String object of the campName to check if it exists in the camp array.
    * @return the boolean value whether the creation of camp object was successful.
    */
    public boolean checkDuplicateCamp(ArrayList<Camp> campArray, String campName){
        for(int i=0; i<campArray.size(); i++){
            if(campArray.get(i).getCampName().equals(campName)){
                return true;
            }
        }
        return false;
    }
}
