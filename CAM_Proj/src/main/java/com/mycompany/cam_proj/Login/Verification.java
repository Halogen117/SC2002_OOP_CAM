/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.Login;
import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.Camp.visibilityStatus;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.ArrayList;


/**
 *
 * @author Halogen
 */
// To verify all inputs when accessed to be boolean to return true for correct input and false for incorrect input
public class Verification {
    private int loopTolerance = 5;
    private int loopLooper;
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");

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
        return true;
    }
    
    private boolean verifyNumber(int number){
        // Edit to verify this shit
        try{
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public String verifyCampName(String campName, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            while(true){
                System.out.println(questionAsked);
                try{
                    scanObj.nextLine();
                    campName = scanObj.nextLine();
                    if(verifyString(campName) == true){
                        return campName;
                    }else{
                        System.out.println("Invalid Input! Please retype!");
                        this.loopLooper += 1;
                        break;
                    }
                }catch(Exception e){
                    scanObj.nextLine();
                    System.out.println("Invalid String Input! Please Try Again!");
                    System.out.println("");
                    this.loopLooper += 1;
                    break;
                }
            }
        }
        this.loopLooper = 0;
        return null;
    }
    
    
    public int[] verifyDate(Scanner scanObj){
        int[] timeArray = new int[5];
        while(this.loopTolerance != this.loopLooper){
            while(true){
                System.out.println("What is the Year? ");
                int year = -1;
                try{
                    scanObj.reset();
                    year = scanObj.nextInt();
                    if(!verifyNumber(year)){
                        System.out.println("Year value is invalid! Please retype.");
                        break;
                    }
                    timeArray[0] = year;
                    System.out.println("What is the Month? (1 for January - 12 for December)");
                    int month = scanObj.nextInt();
                    if(!verifyNumber(month) || (1 > month || month  >13)){
                        System.out.println("Month value is invalid! Please retype.");
                        this.loopLooper += 1;
                        break;
                    }
                    timeArray[1] = month;

                    System.out.println("What is the Day? (1-31) ");
                    int day = scanObj.nextInt();
                    if(!verifyNumber(day) || (1 > day || day > 32)){
                        System.out.println("Day value is invalid! Please retype.");
                        this.loopLooper += 1;
                        break;
                    }
                    timeArray[2] = day;

                    System.out.println("What is the Hour? (1-12)");
                    int hour = scanObj.nextInt();
                    if(!verifyNumber(hour) || (0 > hour || hour  > 13)){
                        System.out.println("Hour value is invalid! Please retype.");
                        this.loopLooper += 1;
                        break;
                    }
                    timeArray[3] = hour;

                    System.out.println("What is the Minutes? (0-59)");
                    int minutes = scanObj.nextInt();
                    if(!verifyNumber(minutes) || (-1 > hour || hour > 60)){
                        System.out.println("Minute value is invalid! Please retype.");
                        this.loopLooper += 1;
                        break;
                    }
                    timeArray[4] = minutes;
                
                    LocalDateTime parse_date  =LocalDateTime.of(timeArray[0], timeArray[1], timeArray[2], timeArray[3], timeArray[4]);
                    return timeArray;
                }catch(java.time.DateTimeException de){
                    System.out.println("Invalid Date!");
                    this.loopLooper += 1;
                    break;
                    
                }catch(Exception e){
                    System.out.println("Invalid Integer Input! Please Try Again!");
                    System.out.println("");
                    this.loopLooper += 1;
                    scanObj.next();
                    break;
                }
                
            }
        }
        this.loopLooper = 0;
        return null;
    }
    
    public boolean verifyRegistrationClosingDate(){
        return true;
    }
    
    public String verifyCampLocation(String location, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            while(true){
                try{
                    scanObj.nextLine();
                    location = scanObj.nextLine();
                        if(verifyString(location) == true){
                            return location;
                        }else{
                            this.loopLooper += 1;
                            break;
                        }
                }catch(Exception e){
                    
                    System.out.println("Invalid String Input! Please Try Again!");
                    System.out.println("");
                    this.loopLooper += 1;
                    break;
                }
            }
        }
        this.loopLooper = 0;
        return null;
        
    }
    
    public int verifyTotalStudents(int totalStudent, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            try{
                totalStudent = scanObj.nextInt();
                if(verifyNumber(totalStudent) == true){
                    return totalStudent;
                }else{
                    this.loopLooper += 1;
                }
            }catch(Exception e){
                scanObj.next();
                System.out.println("Invalid Integer Input! Please Try Again!");
                System.out.println("");
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        return -1;
    }
    
    public int verifyCampCommittee(int inputCampCom, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            try{
                inputCampCom = scanObj.nextInt();
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
            }catch(Exception e){
                scanObj.next();
                System.out.println("Invalid Integer Input! Please Try Again!");
                System.out.println("");
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        return -1;
    }
    public String verifyDescription(String description, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            while(true){
                System.out.println(questionAsked);
                try{
                    scanObj.nextLine();
                    description = scanObj.nextLine();
                    if(verifyString(description) == true){
                        return description;
                    }else{
                        this.loopLooper += 1;
                    }
                    }catch(Exception e){
                        scanObj.next();
                        System.out.println("Invalid String Input! Please Try Again!");
                        System.out.println("");
                        this.loopLooper += 1;
                }
            }
        }
        this.loopLooper = 0;
        return null;
    }    

    
    public visibilityStatus verifyToggleVisiblity(int togVisible, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            try{
                togVisible = scanObj.nextInt();
                if(togVisible == 3){
                    System.out.println("Setting visibility to be viewed for all students!");
                    return visibilityStatus.ENTIRESCHOOL;
                }else if(togVisible == 2){
                    System.out.println("Setting visibility to be viewed only to students in staff-in-charge faculty!");
                    return visibilityStatus.FACULTY;
                }else if(togVisible == 1){
                    System.out.println("Setting visibility to be viewed only to no one!!");
                    return visibilityStatus.NOVISIBILE;
                }else{
                    this.loopLooper += 1;
                }
            }catch(Exception e){
                scanObj.next();
                System.out.println("Invalid Integer Input! Please Try Again!");
                System.out.println("");
                this.loopLooper += 1;
            }
        }
        this.loopLooper = 0;
        System.out.println("Unknown Input!. Setting visibility to be viewed only to staff!");
        return visibilityStatus.NOVISIBILE;
    }    
}
