/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp.CampCreate;
import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.Camp.visibilityStatus;
import com.mycompany.cam_proj.DateFormatter;
import com.mycompany.cam_proj.Staff;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Login.Verification;
import com.mycompany.cam_proj.Student;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
public class StaffCampCreate implements CreateCamp{
    private DateFormatter dateFormat = new DateFormatter();
    private Verification verify = new Verification();
    private LocalDateTime today = this.dateFormat.convert_string_to_datetime(this.dateFormat.convert_datetime_to_string(LocalDateTime.now()));
    public boolean runCreateCamp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
    String question_to_ask = null;
    String campName = null;
    LocalDateTime date = null;
    LocalDateTime reg_closing_date = null;
    String location = null;
    int total_slot = -1;
    int camp_committee_slots = -1;
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
            
            System.out.println("Date of Camp Initalization");
            date = this.dateFormat.generate_date(scanObj);
            if(date == null){
                System.out.println("Date of Camp Time Inputs were invalid!");
                return false;
            }else if(this.dateFormat.compareDateAndTime(date, this.today)== 1){
                System.out.println("The date of the camp cannot be earlier than the predefined timing of today!");
                return false;
            }
            System.out.println("Closing registration of Camp Initalization");
            reg_closing_date = this.dateFormat.generate_date(scanObj);
            
            if(reg_closing_date == null){
                System.out.println("Date of Camp Time Inputs were invalid!");
                return false;
            }else if(this.dateFormat.compareDateAndTime(date, reg_closing_date) == 1){
                System.out.println("The date of the camp cannot be later than the registration closing date!");
                return false;
            }
            question_to_ask = "Where is the camp located? ";
            location = this.verify.verifyCampLocation(location, question_to_ask, scanObj);
            if(location == null){
                location = "NO LOCATION SPECIFIED";
            }
            
            question_to_ask = "How many students are to participate in the camp? ";
            total_slot = this.verify.verifyTotalStudents(total_slot, question_to_ask, scanObj);
            if(total_slot == -1){
                return false;
            }
            
            question_to_ask = "How many camp committee members are participating in the camp? ";
            camp_committee_slots = this.verify.verifyCampCommittee(camp_committee_slots, question_to_ask, scanObj);
            if(camp_committee_slots==-1){
                return false;
            }else{
                campCommitteeList = new ArrayList<Student>(camp_committee_slots);
            }
            
            question_to_ask = "Please type the description of the camp ";
            description = this.verify.verifyDescription(description, question_to_ask, scanObj);
            if(description==null){
                description = "NO DESCRIPTION FILLED";
            }
            
            String staff_in_charge = cookie.getUserID();
            question_to_ask = "Do you want this camp to be visible to students?\n"
                    + "1. Visibile to no one \n"
                    + "2. Visible only to the staff-in-charge faculty \n"
                    + "3. Visible to the entire school.";
            visibility = this.verify.verifyToggleVisiblity(true_false, question_to_ask, scanObj);

            String faculty = cookie.getFacultyInfo();
            Camp new_camp = new Camp(campName, date, reg_closing_date, location, total_slot, campCommitteeList, description, staff_in_charge, visibility, faculty);
            campArray.add(new_camp);
            return true;
        }else{
            System.out.println("As a student you are not allowed to create a camp!");
            return false;
        }
    }
    
    public boolean checkDuplicateCamp(ArrayList<Camp> campArray, String campName){
        
        for(int i=0; i<campArray.size(); i++){
            if(campArray.get(i).getCampName().equals(campName)){
                return true;
            }
        
        }
        return false;
    }
}
