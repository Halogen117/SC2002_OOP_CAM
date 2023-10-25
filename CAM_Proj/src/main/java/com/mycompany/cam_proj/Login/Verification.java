/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.Login;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
// To verify all inputs when accessed to be boolean to return true for correct input and false for incorrect input
public class Verification {
    private int loopTolerance = 5;
    private int loopLooper;
    private Scanner scan_obj = new Scanner(System.in);

    //private date_formatter date_format = new date_formatter();
    //private final LocalDateTime today  = date_format.convert_string_to_datetime(date_format.convert_datetime_to_string(LocalDateTime.now()));
    
    
    public void setLoopTolerance(int loopTolerance){
        this.loopTolerance = loopTolerance;
    }
    
    public int getLoopTolerance(){
        return this.loopTolerance;
    }
    private boolean verifyString(String stringer){
        if(stringer.isEmpty()){
            return false;
        }
        if(!Character.isJavaIdentifierPart(stringer.charAt(0))){
            return false;
        }
        for(int i=1; i<stringer.length(); i++){
            if(!Character.isJavaIdentifierPart(stringer.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    private boolean verifyNumber(int number){
        // Edit to verify this shit
        return true;
    }
    public String verifyCampName(String campName, String questionAsked){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            campName = this.scan_obj.next();
            if(verifyString(campName) == true){
                return campName;
            }else{
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        return null;
    }
    
    /*
    public boolean verifyDate(LocalDateTime date_left, LocalDateTime date_right){

    }
    
    public boolean verifyRegistrationClosingDate(){
        return true;
    }
    */
    
    public String verifyCampLocation(String location, String questionAsked){
        while(this.loopTolerance != this.loopLooper){
        System.out.println(questionAsked);
            if(verifyString(location) == true){
                return location;
            }else{
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        return null;
        
    }
    
    public int verifyTotalStudents(int totalStudent, String questionAsked){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            totalStudent = this.scan_obj.nextInt();
            if(verifyNumber(totalStudent) == true){
                return totalStudent;
            }else{
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        return -1;
    }
    
    public int verifyCampCommittee(int inputCampCom, String questionAsked){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            inputCampCom = this.scan_obj.nextInt();
            if(verifyNumber(inputCampCom) == true){
                if(0< inputCampCom && inputCampCom <= 10){
                    return inputCampCom;
                }else{
                    System.out.println("The camp committee slots must be in between 0 to 10!");
                    this.loopLooper += 1;
                }
            }else{
                this.loopLooper += 1;
            }
            System.out.println(this.loopLooper);
        }
        this.loopLooper = 0;
        return -1;
    }
    public String verifyDescription(String description, String questionAsked){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            description = this.scan_obj.next();
            if(verifyString(description) == true){
                return description;
            }else{
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        return null;
    }    

    
    public boolean verifyToggleVisiblity(String togVisible, String questionAsked){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            togVisible = this.scan_obj.next();
            if(togVisible.equals("Y") || togVisible.equals("YES")){
                System.out.println("Setting visibility to be viewed for all students!");
                return true;
            }else if(togVisible.equals("N") || togVisible.equals("NO")){
                System.out.println("Setting visibility to be viewed only to staff!");
                return false;
            }else{
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        System.out.println("Unknown Input!. Setting visibility to be viewed only to staff!");
        return false;
    }    
}
