/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;
import java.time.LocalDateTime;
/**
 *
 * @author Halogen
 */
public class Camp {
    private String camp_name;
    private LocalDateTime date;
    private LocalDateTime registration_closing_date;
    private String location;
    private int total_slot;
    private int camp_committee_slots;
    private String description;
    private String staff_in_charge;
    private Student[] student_List;
    public Camp(String camp_name, LocalDateTime date,LocalDateTime registration_closing_date, String location, int total_slot, int camp_committee_slots, String description, String staff_in_charge){
        this.camp_name = camp_name;
        this.date = date;
        this.registration_closing_date = registration_closing_date;
        this.location = location;
        this.total_slot =total_slot;
        this.camp_committee_slots = camp_committee_slots;
        this.description = description;
        this.staff_in_charge = staff_in_charge;
    }
    
    public boolean create_camp(){
        // Check what is the role of the user!
        return true;
    }

}
