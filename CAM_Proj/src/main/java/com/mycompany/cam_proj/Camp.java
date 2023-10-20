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
    private String camp_name;
    private LocalDateTime date;
    private LocalDateTime reg_closing_date;
    private String location;
    private int total_slot;
    private int camp_committee_slots;
    private String description;
    private String staff_in_charge;
    private boolean visiblility;
    private ArrayList<Student> student_list = new ArrayList();
    private date_formatter date_form = new date_formatter();
    public Camp(String camp_name, LocalDateTime date,LocalDateTime reg_closing_date, String location, int total_slot, int camp_committee_slots, String description, String staff_in_charge, boolean visiblility){
        this.camp_name = camp_name;
        this.date = date;
        this.reg_closing_date = reg_closing_date;
        this.location = location;
        this.total_slot =total_slot;
        this.camp_committee_slots = camp_committee_slots;
        this.description = description;
        this.staff_in_charge = staff_in_charge;
        this.visiblility = visiblility;
    }
    
    
    public String get_camp_name(){
        return this.camp_name;
    }

    public LocalDateTime get_date(){
        return this.date;
    }
    public String get_date_string(){
        return date_form.convert_datetime_to_string(this.date);
    }
    
    public LocalDateTime get_reg_closing_date(){
        return this.reg_closing_date;
    }
    public String get_reg_closing_date_string(){
        return date_form.convert_datetime_to_string(this.reg_closing_date);
    }
    
    public String get_location(){
        return this.location;
    }
    
    public int get_total_slot(){
        return this.total_slot;
    }

    public int get_camp_committee_slots(){
        return this.camp_committee_slots;
    }

    public String get_description(){
        return this.description;
    }

    public String get_staff_in_charge(){
        return this.staff_in_charge;
    }

    public ArrayList<Student> get_student_list(){
        return this.student_list;
    }
    
    public boolean get_visiblility(){
        return this.visiblility;
    }
    public void set_camp_name(String camp_name){
        this.camp_name = camp_name;
    }

    public void set_date(LocalDateTime date){
        if(date_form.check_datetime_format(date_form.convert_datetime_to_string(date))){
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
    
    public void set_reg_closing_date(LocalDateTime reg_closing_date){
        if(date_form.check_datetime_format(date_form.convert_datetime_to_string(reg_closing_date))){
            this.reg_closing_date = reg_closing_date;
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
    
    public void set_location(String location){
        this.location = location;
    }
    
    public void set_total_slot(int total_slot){
        this.total_slot = total_slot;
    }

    public void set_camp_committee_slots(int camp_committee_slots){
        this.camp_committee_slots = camp_committee_slots;
    }

    public void set_description(String description){
        this.description = description;
    }

    public void set_staff_in_charge(String staff_in_charge){
        this.staff_in_charge = staff_in_charge;
    }
    
    public void set_visiblility(boolean visiblility){
        this.visiblility = visiblility;
    }
}
