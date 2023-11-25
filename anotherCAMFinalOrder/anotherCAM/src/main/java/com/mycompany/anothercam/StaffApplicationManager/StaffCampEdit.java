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
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.implementActions.Edit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
//import com.mycompany.anothercam.implementActions.Edit;
//implements Edit
public class StaffCampEdit implements Edit {
    private ArrayList<Integer> countKeep = new ArrayList<Integer>();
    private DateFormatter dateFormat = new DateFormatter();
    private LocalDateTime today = this.dateFormat.convertStringToDatetime(this.dateFormat.convertDatetimeToString(LocalDateTime.now()));

    /**
     * Runs the Staff Edit Application.
     *
     * @param campArray the CampArray which the new camp object is stored.
     * @param cookie    the User Object (A Staff) which the requested user creates the Camp
     * @param scanObj   takes in the scanner Object for automated testing.
     * @return the boolean value whether the edit of camp object was successful.
     */
    @Override
    public boolean runEdit(ArrayList<Camp> campArray, User cookie, Scanner scanObj) {
        Verification veri = new Verification();
        // Modify Existing Camp
        // Show options to change
        ArrayList<Integer> arryList = new ArrayList<Integer>();

        for (int j = 0; j < campArray.size(); j++) {
            if (campArray.get(j).getStaffInCharge().equals(cookie.getUserID())) {
                arryList.add(j);
            }
        }
        if (arryList.isEmpty()) {
            System.out.println("No camps exist at the moment!");
            return true;
        } else {
            System.out.println("These are the camps that exist!");
            System.out.println("Which camp do you want to modify?");
            for (int i = 1; i < arryList.size() + 1; i++) {
                System.out.println(arryList.size() + ". " + campArray.get(arryList.get(arryList.size() - 1)).getCampName());
            }
            System.out.println("0. Exit Edit Camp Main Menu");
            int decision = veri.verifyScannerNumber(scanObj);
            if (decision == 0) {
                System.out.println("Exiting Edit Camp Main Menu");
                return false;
            } else if (decision > arryList.size()) {
                System.out.println("This camp does not exist!");
            } else if ((0 < decision) && (decision <= arryList.size() + 1)) {
                System.out.println("Modifying Camp " + campArray.get(arryList.get(decision - 1)).getCampName());
                System.out.println("0. Exit Camp Modifier");
                System.out.println("1. Camp Name");
                System.out.println("2. Camp Date");
                System.out.println("3. Registration Closing Date");
                System.out.println("4. Camp Location");
                System.out.println("5. Camp Total Slots");
                System.out.println("6. Edit Visibility Modifier");
                System.out.println("7. Camp Committee Total Slots");
                System.out.println("8. Description");
                System.out.println("Select which element you want to modify!");
                int choice_modi = veri.verifyScannerNumber(scanObj);
                switch (choice_modi) {
                    case 1:
                        String newCampName = null;
                        newCampName = veri.verifyCampName(newCampName, "Insert the new Camp Name", scanObj);
                        if (newCampName == null) {
                            System.out.println("The Camp Name was not updated successfully!");
                            return false;
                        }
                        campArray.get(arryList.get(decision - 1)).setCampName(newCampName);
                        System.out.println("The new camp name is " + campArray.get(arryList.get(decision - 1)).getCampName());
                        break;
                    case 2:
                        System.out.println("Insert the new Camp Date");
                        LocalDateTime date = this.dateFormat.generateDate(scanObj);
                        if (this.dateFormat.compareDateAndTime(date, this.today) == 1) {
                            System.out.println("The date of the camp cannot be earlier than the predefined timing of today!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        campArray.get(arryList.get(decision - 1)).setDate(date);
                        System.out.println("The new camp date is " + campArray.get(arryList.get(decision - 1)).getDateString());
                        break;
                    case 3:
                        System.out.println("Insert the new Closing registration of Camp");
                        LocalDateTime reg_closing_date = this.dateFormat.generateDate(scanObj);
                        if (this.dateFormat.compareDateAndTime(campArray.get(arryList.get(decision - 1)).getDate(), reg_closing_date) == 1) {
                            System.out.println("The date of the camp cannot be later than the registration closing date!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        campArray.get(arryList.get(decision - 1)).setRegClosingDate(reg_closing_date);
                        System.out.println("The new camp date is " + campArray.get(arryList.get(decision - 1)).getRegClosingDateString());
                        break;
                    case 4:
                        String location = null;
                        location = veri.verifyCampLocation(location, "Insert the new Camp Location", scanObj);
                        if (location == null) {
                            System.out.println("The Camp location was not updated successfully!");
                            return false;
                        }

                        campArray.get(arryList.get(decision - 1)).setLocation(location);
                        System.out.println("The new camp location is " + campArray.get(arryList.get(decision - 1)).getLocation());
                        break;
                    case 5:
                        if (!campArray.get(arryList.get(decision - 1)).getCampStudentList().isEmpty() || !campArray.get(arryList.get(decision - 1)).getCampCommitteeList().isEmpty()) {
                            System.out.println("Unable to change Camp Total Slots due to students inside the camp!");
                            return false;
                        }
                        int totalSlot = -1;
                        int campCommitteeSlotVeri = campArray.get(arryList.get(decision - 1)).getCampCommitteeSlots();
                        totalSlot = veri.verifyTotalStudents(totalSlot, campCommitteeSlotVeri, "Insert the new camp total slots", scanObj);
                        if (totalSlot == -1) {
                            System.out.println("The Camp Total Slot number was not updated successfully!");
                            return false;
                        }
                        campArray.get(arryList.get(decision - 1)).setTotalSlot(totalSlot);
                        System.out.println("The new total slot number is " + campArray.get(arryList.get(decision - 1)).getTotalSlot());
                        break;
                    /*
                    case 6:
                        System.out.println("Insert the new camp committee member");
                        
                        int toal_camp_com = this.scanObj.nextInt();
                        if(toal_camp_com >10 || toal_camp_com <0 ){
                            System.out.println("The camp committee slots must be in between 0 to 10!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        
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
                    */
                    case 6:
                        if (!campArray.get(arryList.get(decision - 1)).getCampStudentList().isEmpty() || !campArray.get(arryList.get(decision - 1)).getCampCommitteeList().isEmpty()) {
                            System.out.println("Unable to change visibility modifier due to students inside the camp!");
                            return false;
                        }
                        System.out.println("Enter the number for the new visibility Modification!");
                        System.out.println("Enter 1 to change visibility to be viewed by staff only!");
                        System.out.println("Enter 2 to change visibility to be viewed by staff and students in the faculty!");
                        System.out.println("Enter 3 to change visibility to be viewed by everyone in NTU!");
                        int chooseModif = veri.verifyScannerNumber(scanObj);
                        switch (chooseModif) {
                            case 1:
                                System.out.println("The Camp's Visibiliy has been changed to be visible only to Staff");
                                campArray.get(arryList.get(decision - 1)).setVisiblility(Camp.visibilityStatus.NOVISIBILE);

                                break;
                            case 2:
                                System.out.println("The Camp's Visibiliy has been changed to be seen in Faculty only!");
                                campArray.get(arryList.get(decision - 1)).setVisiblility(Camp.visibilityStatus.FACULTY);
                                break;
                            case 3:
                                System.out.println("The Camp's Visibiliy has been changed to be seen by the entire School");
                                campArray.get(arryList.get(decision - 1)).setVisiblility(Camp.visibilityStatus.ENTIRESCHOOL);
                                break;
                            case 0, -1:
                                System.out.println("No visiblity changed!");
                                break;
                            default:
                                System.out.println("Invalid Input!");
                                return false;
                        }
                        break;
                    case 7:
                        if (!campArray.get(arryList.get(decision - 1)).getCampStudentList().isEmpty() || !campArray.get(arryList.get(decision - 1)).getCampCommitteeList().isEmpty()) {
                            System.out.println("Unable to change Camp Committee Total Slots due to students inside the camp!");
                            return false;
                        }
                        int campCommitteeSlots = -1;
                        campCommitteeSlots = veri.verifyCampCommittee(campCommitteeSlots, "Insert the new Camp Committee Total Slot Number!", scanObj);
                        if (campCommitteeSlots == -1) {
                            System.out.println("The Camp Committee was not updated successfully!");
                            return false;
                        }
                        campArray.get(arryList.get(decision - 1)).setCampCommitteeSlots(campCommitteeSlots);

                        System.out.println("The new Camp Committee Slot number is " + campArray.get(arryList.get(decision - 1)).getCampCommitteeSlots());
                        break;
                    case 8:
                        String descp = null;
                        descp = veri.verifyDescription(descp, "Insert the new Description", scanObj);
                        if (descp == null) {
                            System.out.println("The Camp Description was not update successfully!");
                            return false;
                        }
                        campArray.get(arryList.get(decision - 1)).setDescription(descp);
                        System.out.println("The new description is " + campArray.get(arryList.get(decision - 1)).getDescription());
                        break;
                    // Need to retrieve the xlsx file
                    default:
                        System.out.println("Invalid Input! Please try again");
                        break;
                }
                System.out.println("Camp modification was successful!");
                return true;
            } else {
                System.out.println("Deletion was not successful!");
                return false;
            }
        }
        return true;
    }
}