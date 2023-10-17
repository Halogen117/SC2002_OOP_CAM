/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;

/**
 *
 * @author Halogen
 */
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class CampApp {
    private ArrayList<Camp> camp_array;
    private Scanner scan_obj = new Scanner(System.in);
    private User cookie;
    public CampApp(ArrayList<Camp> camp_array, User cookie){
        this.camp_array = camp_array;
        this.cookie = cookie;
        System.out.println("Welcome to the camp subsection");
        System.out.println("1. Create Camp");
        System.out.println("2. Modify Camp");
        System.out.println("3. Remove Camp");
        System.out.println("4. Exit Camp Interface");
        int choose_camp = scan_obj.nextInt();
        boolean loop_camp = true;
        while(loop_camp){
            switch(choose_camp){
                case 1:
                    create_camp();
                    break;
                case 2:
                    modify_camp();
                    break;
                case 3:
                    remove_camp();
                    break;
                case 4:
                    loop_camp = false;
                    break;
            }
        }
    }
    
    public boolean create_camp(){
        if(cookie instanceof Staff){
            System.out.println("Creating camp!");
            // Check how many camps already inside
            System.out.println("What is the camp name? ");
            String camp_name = scan_obj.next();
            System.out.println("Date of Camp Initalization");
            LocalDateTime date = generate_date();
            System.out.println("Closing registration of Camp Initalization");
            LocalDateTime registration_closing_date = generate_date();
            System.out.println("Where is the camp located? ");
            String location = scan_obj.next();
            System.out.println("How many students are to participate in the camp? ");
            int total_slot = scan_obj.nextInt();
            System.out.println("How many camp committee members are participating in the camp? ");
            int camp_committee_slots = scan_obj.nextInt();
            System.out.println("Please type the description of the camp ");
            String description = scan_obj.next();
            String staff_in_charge = cookie.get_userID();
            Camp new_camp = new Camp(camp_name, date, registration_closing_date, location, total_slot, camp_committee_slots, description, staff_in_charge);
            this.camp_array.add(new_camp);
            return true;
        }else{
            System.out.println("As a student you are not allowed to create a camp!");
            return false;
        }
    }
    
    public LocalDateTime generate_date(){
        System.out.println("What is the Year?: ");
        int year = scan_obj.nextInt();
        System.out.println("What is the Month?: ");
        int month = scan_obj.nextInt();
        System.out.println("What is the Day?: ");
        int day = scan_obj.nextInt();
        System.out.println("What is the Hour?: ");
        int hour = scan_obj.nextInt();
        System.out.println("What is the Minutes?: ");
        int minutes = scan_obj.nextInt();
        String date_formation = Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day)+" "+Integer.toString(hour)+":"+Integer.toString(minutes)+"";
        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-mm-yy HH:mm");
        return LocalDateTime.parse(date_formation, formatter);
    }
    public boolean modify_camp(){
        // Modify Existing Camp
        return true;
    }
    
    public boolean remove_camp(){
        return true;
    }
    
    public boolean exit_camp(){
        return true;
    }
    
    public boolean signup_camp(){
        return true;
    }
    
}
