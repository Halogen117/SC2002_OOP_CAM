/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.App.CampApp.CampEdit;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.DateFormatter;
import com.mycompany.cam_proj.User;
import com.mycompany.cam_proj.Student;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StaffCampEdit implements EditCamp{
    private Scanner scanObj = new Scanner(System.in);
    private DateFormatter dateFormat = new DateFormatter();
    private LocalDateTime today = this.dateFormat.convert_string_to_datetime(this.dateFormat.convert_datetime_to_string(LocalDateTime.now()));
    
    public boolean runEditCamp(ArrayList<Camp> campArray, User cookie){
// Modify Existing Camp
        // Show options to change
        if(campArray.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            System.out.println("These are the camps that exist!");
        for(int i=1; i< campArray.size()+1; i++){
                System.out.println(i+". "+campArray.get(i-1).getCampName());
            }
            System.out.println("Which camp do you want to modify?");
            int decision = this.scanObj.nextInt();
            if(decision == 0){
                return false;
            }else if(decision > campArray.size()+1){
                System.out.println("This camp does not exist!");
            }else if((0 < decision)&&(decision <= campArray.size()+1)){
                System.out.println("Modifying Camp "+ campArray.get(decision-1).getCampName());
                System.out.println("0. Exit Camp Modifier");
                System.out.println("1. Camp Name");
                System.out.println("2. Camp Date");
                System.out.println("3. Registration Closing Date");
                System.out.println("4. Camp Location");
                System.out.println("5. Camp Total Slots");
                System.out.println("6. Camp Committee Slot number");
                System.out.println("7. Add Camp Committee Student");
                System.out.println("8. Remove Camp Committee Student");
                System.out.println("9. Description");
                System.out.println("10. Camp in charge");
                System.out.println("Select which element you want to modify!");
                int choice_modi = this.scanObj.nextInt();
                switch(choice_modi){
                    case 1:
                        System.out.println("Insert the new Camp Name");
                        String new_camp_name = this.scanObj.next();
                        campArray.get(decision-1).setCampName(new_camp_name);
                        System.out.println("The new camp name is "+campArray.get(decision-1).getCampName());
                        break;
                    case 2:
                        System.out.println("Insert the new Camp Date");
                        LocalDateTime date = this.dateFormat.generate_date();
                        if(this.dateFormat.compareDateAndTime(date, this.today)== 1){
                            System.out.println("The date of the camp cannot be earlier than the predefined timing of today!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        campArray.get(decision-1).setDate(date);
                        System.out.println("The new camp date is "+campArray.get(decision-1).getDateString());
                        break;
                    case 3:
                        System.out.println("Insert the new Closing registration of Camp");
                        LocalDateTime reg_closing_date = this.dateFormat.generate_date();
                        if(this.dateFormat.compareDateAndTime(campArray.get(decision-1).getDate(), reg_closing_date) == 1){
                            System.out.println("The date of the camp cannot be later than the registration closing date!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        campArray.get(decision-1).setRegClosingDate(reg_closing_date);
                        System.out.println("The new camp date is "+campArray.get(decision-1).getRegClosingDateString());
                        break;
                    case 4:
                        System.out.println("Insert the new Camp Location");
                        String location = this.scanObj.next();
                        campArray.get(decision-1).setLocation(location);
                        System.out.println("The new camp location is "+campArray.get(decision-1).getLocation());
                        break;
                    case 5:
                        System.out.println("Insert the new camp total slots");
                        int toal_slots = this.scanObj.nextInt();
                        campArray.get(decision-1).setTotalSlot(toal_slots);
                        System.out.println("The new total slot number is "+campArray.get(decision-1).getTotalSlot());
                        break;
                    case 6:
                        System.out.println("Insert the new camp committee member");
                        int toal_camp_com = this.scanObj.nextInt();
                        if(toal_camp_com >10 || toal_camp_com <0 ){
                            System.out.println("The camp committee slots must be in between 0 to 10!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        campArray.get(decision-1).addCampCommitteeMemberToList((Student) cookie);
                        System.out.println("The new Camp Committee Members in the Camp are:");
                        for(int i=1; i<campArray.size(); i++){
                            System.out.println(i+". "+campArray.get(decision-1).getCampCommitteeSlots().get(i-1).getUserID());
                        
                        }
                        // Don't forget to check if 10 or less
                        break;
                    case 7:
                        System.out.println("Insert the new Description");
                        String descp = this.scanObj.next();
                        campArray.get(decision-1).setDescription(descp);
                        System.out.println("The new description is "+campArray.get(decision-1).getDescription());
                        break;
                        // Need to retrieve the xlsx file
                            }
                System.out.println("Camp modification was successful!");
                return true;
            }else{
                System.out.println("Deletion was not successful!");
                return false;
            }
        }
        return true;
    }
}
