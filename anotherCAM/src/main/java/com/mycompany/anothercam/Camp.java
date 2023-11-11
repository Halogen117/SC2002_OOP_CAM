/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author Halogen
 */


public class Camp {
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
    public Camp(int campID, String campName, LocalDateTime date,LocalDateTime reg_closing_date, String location, int total_slot, int campCommitteeSlots,ArrayList<Student> campCommitteeList, String description, String staff_in_charge, visibilityStatus visiblility, String faculty){
        this.campID = campID;
        this.campName = campName;
        this.date = date;
        this.regClosingDate = reg_closing_date;
        this.location = location;
        this.totalSlot =total_slot;
        this.campCommitteeList = campCommitteeList;
        this.campCommitteeSlots = campCommitteeSlots;
        this.description = description;
        this.staffInCharge = staff_in_charge;
        this.visiblility = visiblility;
        this.faculty = faculty;
    }
    
    public int getCampID(){
        return this.campID;
    }
    
    public String getCampName(){
        return this.campName;
    }

    public LocalDateTime getDate(){
        return this.date;
    }
    public String getDateString(){
        return dateForm.convert_datetime_to_string(this.date);
    }
    
    public String getFaculty(){
        return this.faculty;
    }
    
    public LocalDateTime getRegClosingDate(){
        return this.regClosingDate;
    }
    public String getRegClosingDateString(){
        return dateForm.convert_datetime_to_string(this.regClosingDate);
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public int getTotalSlot(){
        return this.totalSlot;
    }
    public int getCampCommitteeSlots(){
        return this.campCommitteeSlots;
    }
    public ArrayList<Student> getCampCommitteeList(){
        return this.campCommitteeList;
    }

    public String getDescription(){
        return this.description;
    }

    public String getStaffInCharge(){
        return this.staffInCharge;
    }

    public ArrayList<Student> getCampStudentList(){
        return this.studentList;
    }
    
    public visibilityStatus getVisiblility(){
        return this.visiblility;
    }
    
    public void setCampID(int campID){
        this.campID = campID;
    }
    public void setCampName(String campName){
        this.campName = campName;
    }

    public void setDate(LocalDateTime date){
        if(dateForm.check_datetime_format(dateForm.convert_datetime_to_string(date))){
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
    
    public void setFaculty(String faculty){
        this.faculty = faculty;
    }
    
    public void setRegClosingDate(LocalDateTime regClosingDate){
        if(dateForm.check_datetime_format(dateForm.convert_datetime_to_string(regClosingDate))){
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
    
    public void setLocation(String location){
        this.location = location;
    }
    
    public void setTotalSlot(int totalSlot){
        this.totalSlot = totalSlot;
    }
    
    public void setCampCommitteeList(ArrayList<Student> campCommitteeList){
        this.campCommitteeList = campCommitteeList;
    }
    public void setCampCommitteeSlots(int campCommitteeSlots){
        this.campCommitteeSlots = campCommitteeSlots;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStaffInCharge(String staffInCharge){
        this.staffInCharge = staffInCharge;
    }
    
    public void setVisiblility(visibilityStatus visiblility){
        this.visiblility = visiblility;
    }
    
    public void addStudentToList(Student stud){
        this.studentList.add(stud);
    }

    public void removeStudentToList(Student stud){
        this.studentList.remove(stud);
    }
    
    public void addCampCommitteeMemberToList(Student stud){
        this.campCommitteeList.add(stud);
    }

    public void removeCampCommitteeMemberToList(Student stud){
        this.campCommitteeList.remove(stud);
    }
}
