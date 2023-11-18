/**
Represents the Camp Object and the following mutator methods.
A camp can be registered by multiple students.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Camp {
    /**
    * The public Enumeration of the visibility status of the camp.
    * NOVISIBLE: Not Visible to everyone in the school except staff.
    * FACULTY: Visible to only Staff and Student within that faculty.
    * ENTIRESCHOOL: Visible to the entire database of students and staff    
    */
    public enum visibilityStatus{
        NOVISIBILE, FACULTY, ENTIRESCHOOL
    }
    private int campID;
    private String campName;
    private LocalDateTime date;
    private LocalDateTime regClosingDate;
    private String location;
    private int totalSlot;
    private int campCommitteeSlots;
    private ArrayList<Student> campCommitteeList  = new ArrayList<Student>();
    private String description;
    private String staffInCharge;
    private visibilityStatus visiblility;
    private ArrayList<Student> studentList = new ArrayList<Student>();
    private String faculty;
    private DateFormatter dateForm = new DateFormatter();
    
    /**
    * The Camp Constructor.
    * @param campID The unique campID generated
    * @param campName The unique Camp Name generated by user input
    * @param date The date which the camp will commence as the date which the camp will commence as generated by user input
    * @param regClosingDate The date which the camp will close its registration closing date generated by user input
    * @param location The location of the camp
    * @param totalSlot The initalized number of attendees that can be added in the camp. The minimum is 0. The max is as many students.
    * @param campCommitteeList The initalized arraylist of Students that constitute the Camp Committee.
    * @param campCommitteeSlots The initalized number of camp committee members that can be added in the camp. The minimum is 0. The max is 10
    * @param description The description of the camp, that is the camp details and what not.
    * @param staffInCharge The staff that is in charge of the camp in its totality.
    * @param visiblility The enum variable to set.
    * @param faculty The faculty which the staff in charge is in.
    */
    public Camp(int campID, String campName, LocalDateTime date,LocalDateTime regClosingDate, String location, int totalSlot, int campCommitteeSlots,ArrayList<Student> campCommitteeList, String description, String staffInCharge, visibilityStatus visiblility, String faculty){
        this.campID = campID;
        this.campName = campName;
        this.date = date;
        this.regClosingDate = regClosingDate;
        this.location = location;
        this.totalSlot =totalSlot;
        this.campCommitteeList = campCommitteeList;
        this.campCommitteeSlots = campCommitteeSlots;
        this.description = description;
        this.staffInCharge = staffInCharge;
        this.visiblility = visiblility;
        this.faculty = faculty;
    }
    
    /**
    * Gets the campID of the Camp Object.
    * @return the campID of the camp.
    */
    public int getCampID(){
        return this.campID;
    }

    /**
    * Gets the camp name of the Camp Object.
    * @return the name of the camp.
    */
    public String getCampName(){
        return this.campName;
    }

    /**
    * Gets the camp date LocalDateTime Object of the Camp Object.
    * @return the date LocalDateTime Object of the camp.
    */
    public LocalDateTime getDate(){
        return this.date;
    }
    
    /**
    * Gets the camp date String of the Camp Object.
    * @return the date String of the camp.
    */
    public String getDateString(){
        return dateForm.convertDatetimeToString(this.date);
    }

    /**
    * Gets the faculty of the Camp Object.
    * @return the faculty the camp is under.
    */
    public String getFaculty(){
        return this.faculty;
    }

    /**
    * Gets the camp registration closing date LocalDateTime Object of the Camp Object.
    * @return the registration closing date LocalDateTime Object of the camp.
    */
    public LocalDateTime getRegClosingDate(){
        return this.regClosingDate;
    }
    
    /**
    * Gets the camp registration closing date String of the Camp Object.
    * @return the registration closing date String of the camp.
    */
    public String getRegClosingDateString(){
        return dateForm.convertDatetimeToString(this.regClosingDate);
    }
    
    /**
    * Gets the location of the Camp Object.
    * @return the location of the camp.
    */
    public String getLocation(){
        return this.location;
    }
    
    /**
    * Gets the number of initalized total attendee slots of the Camp Object.
    * @return the number of initalized total attendee slots of the camp.
    */
    public int getTotalSlot(){
        return this.totalSlot;
    }
    
    /**
    * Gets the number of initalized total camp committee slots of the Camp Object.
    * @return the number of initalized total camp committee slots of the camp.
    */
    public int getCampCommitteeSlots(){
        return this.campCommitteeSlots;
    }
    
    /**
    * Gets the Student ArrayList object of camp committee members in the camp.
    * @return the Student ArrayList object of camp committee member in the camp.
    */
    public ArrayList<Student> getCampCommitteeList(){
        return this.campCommitteeList;
    }

    /**
    * Gets the description of the Camp Object.
    * @return the description of the camp.
    */
    public String getDescription(){
        return this.description;
    }

    /**
    * Gets the staff in charge of the Camp Object.
    * @return the staff in charge of the camp.
    */
    public String getStaffInCharge(){
        return this.staffInCharge;
    }

    /**
    * Gets the Student ArrayList object of attendees in the camp.
    * @return the Student ArrayList object of attendees in the camp.
    */
    public ArrayList<Student> getCampStudentList(){
        return this.studentList;
    }
    
    /**
    * Gets the visibility enumeration of the Camp Object.
    * @return the visibility status of the camp.
    */
    public visibilityStatus getVisiblility(){
        return this.visiblility;
    }
    
    /**
    * Changes the campID of the Camp Object
    * @param campID This campID 
    */
    /*
    Can't reset the campID cause that is unique
    Though OOP?
    public void setCampID(int campID){
        this.campID = campID;
    }
    */
    
    /**
    * Changes the camp name of the Camp Object
    * @param campName This camp's new name should just be a regular string in general.
    *               The validation is already done before the method is called.
    */
    public void setCampName(String campName){
        this.campName = campName;
    }

    /**
    * Changes the date of the Camp Object
    * @param date This camp's new date must be a LocalDateTime object.
    *               The validation for the pattern is done in this set method.
    */
    public void setDate(LocalDateTime date){
        if(dateForm.checkDatetimeFormat(dateForm.convertDatetimeToString(date))){
            this.date = date;
        }else{
            System.out.println("The format is incorrect! Please retry inputing the date again!");
        }
        
    }
    
    // Do we need a date string to set? Or just set LocalDateTime can le
    /*
    public void set_date_string(){
        date_form.convert_datetime_to_string(this.date);
    }
    */
    
    /**
    * Changes the faculty of the Camp Object
    * @param faculty This camp's new faculty must be a LocalDateTime object.
    *                The validation is already done before the method is called.
    */
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
    
    /**
    * Changes the registration closing date of the Camp Object
    * @param regClosingDate This camp's new registration closing date should just be a regular string in general.
    *                       The validation for the pattern is done in this set method.
    */
    public void setRegClosingDate(LocalDateTime regClosingDate){
        if(dateForm.checkDatetimeFormat(dateForm.convertDatetimeToString(regClosingDate))){
            this.regClosingDate = regClosingDate;
        }else{
            System.out.println("The format is incorrect! Please retry inputing the registration closing date again!");
        }
    }
    
    // Do we need a date string to set? Or just set LocalDateTime can le
    /*
    public void set_reg_closing_date_string(){
        date_form.convert_datetime_to_string(this.reg_closing_date);
    }
    */
    
    
    /**
    * Changes the location of the Camp Object
    * @param location This camp's new location should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setLocation(String location){
        this.location = location;
    }
    
    /**
    * Changes the total attendee number of the Camp Object
    * @param totalSlot This camp's new total number of attendees should just be an integer in general.
    *                The validation is already done before the method is called.
    */
    public void setTotalSlot(int totalSlot){
        this.totalSlot = totalSlot;
    }
    
    /**
    * Changes the ArrayList of Students in the Camp Committee of the Camp Object
    * @param campCommitteeList This camp's new Student ArrayList of camp Committee Members should be passed as such.
    *                The validation is already done before the method is called.
    */
    public void setCampCommitteeList(ArrayList<Student> campCommitteeList){
        this.campCommitteeList = campCommitteeList;
    }
    
    /**
    * Changes the total camp committee number of the Camp Object
    * @param campCommitteeSlots This camp's new total number of camp committee members should just be an integer in general.
    *                           The validation is already done before the method is called.
    */
    public void setCampCommitteeSlots(int campCommitteeSlots){
        this.campCommitteeSlots = campCommitteeSlots;
    }

    /**
    * Changes the description of the Camp Object
    * @param description This camp's new description should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setDescription(String description){
        this.description = description;
    }

    /**
    * Changes the staff in charge of the Camp Object
    * @param staffInCharge This camp's new staff in charge should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setStaffInCharge(String staffInCharge){
        this.staffInCharge = staffInCharge;
    }
    
    /**
    * Changes the visibility enumeration of the Camp Object
    * @param visiblility This camp's new visibility should just be the visibility enumeration objects.
    *                The validation is already done before the method is called.
    */
    public void setVisiblility(visibilityStatus visiblility){
        this.visiblility = visiblility;
    }
    
    /**
    * Adds a Student Object to the ArrayList of Students into the attendee of the Camp Object
    * @param stud This student object passed should be a Student object.
    *             The validation is already done before the method is called.
    */
    public void addStudentToList(Student stud){
        this.studentList.add(stud);
    }
    
    /**
    * Removes a Student Object to the ArrayList of Students from the attendee of the Camp Object
    * @param stud This student object passed should be a Student object.
    *             The validation is already done before the method is called.
    */
    public void removeStudentToList(Student stud){
        this.studentList.remove(stud);
    }
    
    /**
    * Adds a Student Object to the ArrayList of Students into the camp committee of the Camp Object
    * @param stud This student object passed should be a Student object.
    *             The validation is already done before the method is called.
    */
    public void addCampCommitteeMemberToList(Student stud){
        this.campCommitteeList.add(stud);
    }

    /**
    * Removes a Student Object to the ArrayList of Students from the camp committee of the Camp Object
    * @param stud This student object passed should be a Student object.
    *             The validation is already done before the method is called.
    */
    public void removeCampCommitteeMemberToList(Student stud){
        this.campCommitteeList.remove(stud);
    }
}
