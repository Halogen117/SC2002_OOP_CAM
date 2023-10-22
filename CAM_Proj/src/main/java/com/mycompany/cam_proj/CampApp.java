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
import java.util.Scanner;
public class CampApp {
    private ArrayList<Camp> camp_array;
    private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");;
    private User cookie;
    private date_formatter date_format = new date_formatter();
    private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    public CampApp(ArrayList<Camp> camp_array, User cookie){
        this.camp_array = camp_array;
        this.cookie = cookie;
        boolean loop_camp = true;
        while(loop_camp){
            System.out.println("Welcome to the camp subsection");
            
                System.out.println("0. Exit Camp Interface");
                System.out.println("1. Modify Camp");
                System.out.println("2. View Camps");
            if(cookie instanceof Staff){
                System.out.println("3. Remove Camp");
                System.out.println("4. Create Camp");
            }

            int choose_camp = scan_obj.nextInt();
            switch(choose_camp){
                case 0:
                    
                    loop_camp = false;
                    break;

                case 1:
                    modify_camp();
                    break;

                case 2:

                    view_camp();
                    break;

                case 3:
                    remove_camp();
                    break;

                case 4:
                    create_camp();
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
            LocalDateTime date = this.date_format.generate_date();
            if(this.date_format.compare_dates(date, this.today)== 1){
                System.out.println("The date of the camp cannot be earlier than the predefined timing of today!");
                System.out.println("Camp was not successfully created!");
                return false;
            }
            System.out.println("Closing registration of Camp Initalization");
            LocalDateTime reg_closing_date = this.date_format.generate_date();
            if(this.date_format.compare_dates(date, reg_closing_date) == 1){
                System.out.println("The date of the camp cannot be later than the registration closing date!");
                System.out.println("Camp was not successfully created!");
                return false;
            }
            System.out.println("Where is the camp located? ");
            String location = scan_obj.next();
            
            System.out.println("How many students are to participate in the camp? ");
            int total_slot = scan_obj.nextInt();
            
            System.out.println("How many camp committee members are participating in the camp? ");
            int camp_committee_slots = scan_obj.nextInt();
            if(camp_committee_slots >10 || camp_committee_slots <0 ){
                System.out.println("The camp committee slots must be in between 0 to 10!");
                System.out.println("Camp was not successfully modified!");
                return false;
            }
            
            System.out.println("Please type the description of the camp ");
            String description = scan_obj.next();
            
            String staff_in_charge = cookie.get_userID();
            System.out.println("Do you want this camp to be visible to students Y/N");
            String true_false = scan_obj.next();
            boolean visibility;
            if(true_false.equals("Y") || true_false.equals("YES")){
                System.out.println("Setting visibility to be viewed for all students!");
                visibility = true;
            }else if(true_false.equals("N") || true_false.equals("NO")){
                System.out.println("Setting visibility to be viewed only to staff!");
                visibility = false;
            }else{
                System.out.println("Unknown Input!. Setting visibility to be viewed only to staff!");
                visibility = false;
            }
            Camp new_camp = new Camp(camp_name, date, reg_closing_date, location, total_slot, camp_committee_slots, description, staff_in_charge, visibility);
            this.camp_array.add(new_camp);
            return true;
        }else{
            System.out.println("As a student you are not allowed to create a camp!");
            return false;
        }
    }

    
    public boolean modify_camp(){
        // Modify Existing Camp
        // Show options to change
        if(this.camp_array.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            System.out.println("These are the camps that exist!");
        for(int i=1; i< this.camp_array.size()+1; i++){
                System.out.println(i+". "+this.camp_array.get(i-1).get_camp_name());
            }
            System.out.println("Which camp do you want to modify?");
            int decision = this.scan_obj.nextInt();
            if(decision == 0){
                return false;
            }else if(decision > this.camp_array.size()+1){
                System.out.println("This camp does not exist!");
            }else if((0 < decision)&&(decision <= this.camp_array.size()+1)){
                System.out.println("Modifying Camp "+ this.camp_array.get(decision-1).get_camp_name());
                System.out.println("1. Camp Name");
                System.out.println("2. Camp Date");
                System.out.println("3. Registration Closing Date");
                System.out.println("4. Camp Location");
                System.out.println("5. Camp Total Slots");
                System.out.println("6. Camp Committee Slots");
                System.out.println("7. Camp in charge");
                System.out.println("0. Exit Camp Modifier");
                System.out.println("Select which element you want to modify!");
                int choice_modi = this.scan_obj.nextInt();
                switch(choice_modi){
                    case 1:
                        System.out.println("Insert the new Camp Name");
                        String new_camp_name = this.scan_obj.next();
                        this.camp_array.get(decision-1).set_camp_name(new_camp_name);
                        System.out.println("The new camp name is "+this.camp_array.get(decision-1).get_camp_name());
                        break;
                    case 2:
                        System.out.println("Insert the new Camp Date");
                        LocalDateTime date = this.date_format.generate_date();
                        if(this.date_format.compare_dates(date, this.today)== 1){
                            System.out.println("The date of the camp cannot be earlier than the predefined timing of today!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        this.camp_array.get(decision-1).set_date(date);
                        System.out.println("The new camp date is "+this.camp_array.get(decision-1).get_date_string());
                        break;
                    case 3:
                        System.out.println("Insert the new Closing registration of Camp");
                        LocalDateTime reg_closing_date = this.date_format.generate_date();
                        if(this.date_format.compare_dates(this.camp_array.get(decision-1).get_date(), reg_closing_date) == 1){
                            System.out.println("The date of the camp cannot be later than the registration closing date!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        this.camp_array.get(decision-1).set_reg_closing_date(reg_closing_date);
                        System.out.println("The new camp date is "+this.camp_array.get(decision-1).get_reg_closing_date_string());
                        break;
                    case 4:
                        System.out.println("Insert the new Camp Location");
                        String location = this.scan_obj.next();
                        this.camp_array.get(decision-1).set_location(location);
                        System.out.println("The new camp location is "+this.camp_array.get(decision-1).get_location());
                        break;
                    case 5:
                        System.out.println("Insert the new camp total slots");
                        int toal_slots = this.scan_obj.nextInt();
                        this.camp_array.get(decision-1).set_total_slot(toal_slots);
                        System.out.println("The new total slot number is "+this.camp_array.get(decision-1).get_total_slot());
                        break;
                    case 6:
                        System.out.println("Insert the new camp committee slots");
                        int toal_camp_com = this.scan_obj.nextInt();
                        if(toal_camp_com >10 || toal_camp_com <0 ){
                            System.out.println("The camp committee slots must be in between 0 to 10!");
                            System.out.println("Camp was not successfully modified!");
                            return false;
                        }
                        this.camp_array.get(decision-1).set_camp_committee_slots(toal_camp_com);
                        System.out.println("The new camp committee slots is "+this.camp_array.get(decision-1).get_camp_committee_slots());
                        // Don't forget to check if 10 or less
                        break;
                    case 7: 
                        System.out.println("Insert the new camp in charge!");
                        
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
    
    public boolean remove_camp(){
        // Print all camps
        if(this.camp_array.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            System.out.println("These are the camps that exist!");
            for(int i=1; i< this.camp_array.size()+1; i++){
                System.out.println(i+". "+this.camp_array.get(i-1).get_camp_name());
            }
            System.out.println("0. Exit decision to remove camp!");
            System.out.println("Which camp do you want to remove? ");
            int decision = scan_obj.nextInt();
            if(decision == 0){
                return false;
            }else if(decision > this.camp_array.size()+1){
                System.out.println("This camp does not exist!");
            }else if((0 < decision)&&(decision <= this.camp_array.size()+1)){
                System.out.println("Deleting Camp "+ this.camp_array.get(decision-1).get_camp_name());
                this.camp_array.remove(this.camp_array.get(decision-1));
                System.out.println("Deletion was successful!");
                return true;
            }else{
                System.out.println("Deletion was not successful!");
                return false;
            }
        }
        System.out.println("Deletion was not successful!");
        return false;
    }
    
    public void view_camp(){
        if(this.camp_array.isEmpty()){
            System.out.println("No camps exist at the moment!");
        }else{
            for(int i=1; i< this.camp_array.size()+1; i++){
                if((this.camp_array.get(i-1).get_visiblility() == true && this.cookie instanceof Student) || this.cookie instanceof Staff){
                    System.out.println("Camp Number "+i+" on display!");
                    // Check what is the role of the user!
                    System.out.println("The camp name is "+this.camp_array.get(i-1).get_camp_name());
                    System.out.println("The date the camp starts is on "+this.camp_array.get(i-1).get_date_string());
                    System.out.println("The registration date the camp ends is on "+this.camp_array.get(i-1).get_reg_closing_date_string());
                    System.out.println("The location of the camp is "+this.camp_array.get(i-1).get_location());
                    System.out.println("The total slots available in the camp are "+this.camp_array.get(i-1).get_total_slot());
                    System.out.println("The total camp committee slots available in the camp are "+this.camp_array.get(i-1).get_camp_committee_slots());
                    System.out.println("The staff in charge of the camp is "+this.camp_array.get(i-1).get_staff_in_charge());
                    // Find a way to check if student_list is empty
                    if(this.camp_array.get(i-1).get_student_list().isEmpty()){
                        System.out.println("There are no students who signed up for the camp at the moment!");
                    }else{
                        System.out.println("The students in the camp so far are ");
                        for(Student stud: this.camp_array.get(i-1).get_student_list()){
                            System.out.println(stud.get_userID());
                        }
                    }
                }
            }
        }
    }
    
    public boolean exit_camp(){
        return true;
    }
    
    public boolean signup_camp(){
        return true;
    }
    
}
