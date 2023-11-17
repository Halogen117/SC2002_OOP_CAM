/**
Represents the StaffCampEdit Object and the following assistor methods.
A StaffCampEdit can be called multiple times depending on how many camps to be edited.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam.StaffApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.DateFormatter;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.Student;
import com.mycompany.anothercam.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffCampEdit{
    private ArrayList<Integer> countKeep = new ArrayList<Integer>();
    private DateFormatter dateFormat = new DateFormatter();
    private LocalDateTime today = this.dateFormat.convert_string_to_datetime(this.dateFormat.convert_datetime_to_string(LocalDateTime.now()));

    /**
    * Runs the Staff Edit Application.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return the boolean value whether the edit of camp object was successful.
    */
    public boolean runStaffEditCamp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        // Modify Existing Camp
        // Show options to change
        if(campArray.isEmpty()){
            System.out.println("No camps exist at the moment!");
            return true;
        }else{
            System.out.println("These are the camps that exist!");
            System.out.println("Which camp do you want to modify?");
        for(int i=1; i< campArray.size()+1; i++){
            if(campArray.get(i-1).getStaffInCharge().equals(cookie.getUserID())){
                countKeep.add(i);
                System.out.println(countKeep.indexOf(i)+1+". "+campArray.get(countKeep.indexOf(i)).getCampName());
            }   
        }
            System.out.println("0. Exit Edit Camp Main Menu");
            int decision = scanObj.nextInt();
            if(decision == 0){
                System.out.println("Exiting Edit Camp Main Menu");
                return false;
            }else if(decision > countKeep.size()+1){
                System.out.println("This camp does not exist!");
            }else if((0 < decision)&&(decision <= countKeep.size()+1)){
                System.out.println("Modifying Camp "+ campArray.get(countKeep.indexOf(decision)).getCampName());
                System.out.println("0. Exit Camp Modifier");
                System.out.println("1. Camp Name");
                System.out.println("2. Camp Date");
                System.out.println("3. Registration Closing Date");
                System.out.println("4. Camp Location");
                System.out.println("5. Camp Total Slots");
                //System.out.println("6. Add Student to Camp");
                //System.out.println("7. Remove Student from Camp");
                System.out.println("6. Camp Committee Slot number");
                System.out.println("7. Add Camp Committee Student");
                System.out.println("8. Remove Camp Committee Student");
                System.out.println("9. Description");
                System.out.println("Select which element you want to modify!");
                int choice_modi = scanObj.nextInt();
                switch(choice_modi){
                    case 1:
                        System.out.println("Insert the new Camp Name");
                        String new_camp_name = scanObj.next();
                        campArray.get(countKeep.indexOf(decision)).setCampName(new_camp_name);
                        System.out.println("The new camp name is "+campArray.get(countKeep.indexOf(decision)).getCampName());
                        break;
                    case 2:
                        System.out.println("Insert the new Camp Date");
                        LocalDateTime date = this.dateFormat.generate_date(scanObj);
                        if(this.dateFormat.compareDateAndTime(date, this.today)== 1){
                            System.out.println("The date of the camp cannot be earlier than the predefined timing of today!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        campArray.get(countKeep.indexOf(decision)).setDate(date);
                        System.out.println("The new camp date is "+campArray.get(countKeep.indexOf(decision)).getDateString());
                        break;
                    case 3:
                        System.out.println("Insert the new Closing registration of Camp");
                        LocalDateTime reg_closing_date = this.dateFormat.generate_date(scanObj);
                        if(this.dateFormat.compareDateAndTime(campArray.get(countKeep.indexOf(decision)).getDate(), reg_closing_date) == 1){
                            System.out.println("The date of the camp cannot be later than the registration closing date!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        campArray.get(countKeep.indexOf(decision)).setRegClosingDate(reg_closing_date);
                        System.out.println("The new camp date is "+campArray.get(countKeep.indexOf(decision)).getRegClosingDateString());
                        break;
                    case 4:
                        System.out.println("Insert the new Camp Location");
                        String location = scanObj.next();
                        campArray.get(countKeep.indexOf(decision)).setLocation(location);
                        System.out.println("The new camp location is "+campArray.get(countKeep.indexOf(decision)).getLocation());
                        break;
                    case 5:
                        System.out.println("Insert the new camp total slots");
                        int toal_slots = scanObj.nextInt();
                        campArray.get(countKeep.indexOf(decision)).setTotalSlot(toal_slots);
                        System.out.println("The new total slot number is "+campArray.get(countKeep.indexOf(decision)).getTotalSlot());
                        break;
                    case 6:
                        System.out.println("Insert the new camp committee member");
                        /*
                        int toal_camp_com = this.scanObj.nextInt();
                        if(toal_camp_com >10 || toal_camp_com <0 ){
                            System.out.println("The camp committee slots must be in between 0 to 10!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        */
                        // Retrieve Student List
                        // And checks inside StudentList
                        System.out.println("Type in the name of the student you want to be a Camp Committee Member for");
                        String studentToName = scanObj.next();
                        // If the student is in th e
                        if(!StudentList.checkStudentInList(studentToName)){
                            System.out.println("Student Not Found!");
                            return true;
                        }
                        
                        campArray.get(countKeep.indexOf(decision)).addCampCommitteeMemberToList((Student) StudentList.returnStudentCookie(studentToName));
                        System.out.println("The new Camp Committee Members in the Camp are:");
                        for(int i=1; i<campArray.size(); i++){
                            System.out.println(i+". "+campArray.get(countKeep.indexOf(decision)).getCampCommitteeList().get(i-1).getUserID());
                        
                        }
                        // Don't forget to check if 10 or less
                        break;
                    case 7:
                        System.out.println("Insert the new Description");
                        String descp = scanObj.next();
                        campArray.get(countKeep.indexOf(decision)).setDescription(descp);
                        System.out.println("The new description is "+campArray.get(countKeep.indexOf(decision)).getDescription());
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
