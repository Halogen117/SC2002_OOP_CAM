/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;
import java.time.LocalDateTime;
import java.util.ArrayList;
/**
 *
 * @author Halogen
 */
public class Camp {
    private String campName;
    private LocalDateTime date;
    private LocalDateTime regClosingDate;
    private String location;
    private int totalSlot;
    private int campCommitteeSlots;
    private String description;
    private String staffInCharge;
    private boolean visiblility;
    private ArrayList<Student> studentList = new ArrayList();
    private DateFormatter dateForm = new DateFormatter();
    public Camp(String camp_name, LocalDateTime date,LocalDateTime reg_closing_date, String location, int total_slot, int camp_committee_slots, String description, String staff_in_charge, boolean visiblility){
        this.campName = campName;
        this.date = date;
        this.regClosingDate = reg_closing_date;
        this.location = location;
        this.totalSlot =total_slot;
        this.campCommitteeSlots = camp_committee_slots;
        this.description = description;
        this.staffInCharge = staff_in_charge;
        this.visiblility = visiblility;
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

    public String getDescription(){
        return this.description;
    }

    public String getStaffInCharge(){
        return this.staffInCharge;
    }

    public ArrayList<Student> getStudentList(){
        return this.studentList;
    }
    
    public boolean getVisiblility(){
        return this.visiblility;
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

    public void setCampCommitteeSlots(int campCommitteeSlots){
        this.campCommitteeSlots = campCommitteeSlots;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setStaffInCharge(String staffInCharge){
        this.staffInCharge = staffInCharge;
    }
    
    public void setVisiblility(boolean visiblility){
        this.visiblility = visiblility;
    }
}
