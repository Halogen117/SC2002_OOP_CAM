/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class date_formatter {
    private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private static final String date_pattern = "dd-mm-yyyy HH:mm";
    private static final DateTimeFormatter date_formatter= DateTimeFormatter.ofPattern(date_pattern);
    public date_formatter(){
        System.out.println("Initalizing date formatter!");
    }
        public LocalDateTime generate_date(){
        System.out.println("What is the Year? ");
        int year = scan_obj.nextInt();
        System.out.println("What is the Month? ");
        int month = scan_obj.nextInt();
        System.out.println("What is the Day? ");
        int day = scan_obj.nextInt();
        System.out.println("What is the Hour? ");
        int hour = scan_obj.nextInt();
        System.out.println("What is the Minutes? ");
        int minutes = scan_obj.nextInt();
        LocalDateTime parse_date  =LocalDateTime.of(year, month, day, hour, minutes);
        return parse_date;
    }
    
    public String convert_datetime_to_string(LocalDateTime return_time){
        return date_formatter.format(return_time);
    }
    
    
    public LocalDateTime convert_string_to_datetime(String return_time){
        return  LocalDateTime.parse(return_time, date_formatter);
    }
    
    public boolean check_datetime_format(String input_date){
        try{
            LocalDateTime parsed_date = LocalDateTime.parse(input_date, date_formatter);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
