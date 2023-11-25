
package com.mycompany.anothercam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;

/**
Represents the DateFormatter Object and the following assistor methods.
A DateFormatter can be called multiple times depending on how many dates need to be formatted.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-16
*/
public class DateFormatter {
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private static final String date_pattern = "dd-MM-yyyy-HHmm";
    private static final DateTimeFormatter date_formatter= DateTimeFormatter.ofPattern(date_pattern);
    private Verification veriClass = new Verification();

    
    /**
    * Generates a LocalDatetime of the DateTime variables sent to the function 
    * @param scanObj the Scanner Object used to take in inputs
    * @return a DateTime of the DateTime Formatted by the String object.
    */ 
    public LocalDateTime generateDate(Scanner scanObj){
        int timeArray[] = this.veriClass.verifyDate(scanObj);
        if(timeArray == null){
            return null;
        }
        LocalDateTime parse_date  =LocalDateTime.of(timeArray[0], timeArray[1], timeArray[2], timeArray[3], timeArray[4]);
        return parse_date;
    }
    
    /**
    * Generates a String of the DateTime variable sent to the function 
    * @param returnTime the CampArray which the new camp object is stored.
    * @return a DateTime of the DateTime Formatted by the String object.
    */    
    public String convertDatetimeToString(LocalDateTime returnTime){
        return date_formatter.format(returnTime);
    }
    
    
    /**
    * Generates a DateTime object of the String variable sent to the function 
    * @param returnTime the String object which is converted to DateTime.
    * @return a String of the DateTime Formatted by the String object.
    */    
    public LocalDateTime convertStringToDatetime(String returnTime){
        return  LocalDateTime.parse(returnTime, date_formatter);
    }
    
    /**
    * Checks if the datetie format of the String variable is valid. 
    * @param inputDate string is where the date is checked on the standerdized format.
    * @return a boolean to check if the format is correct. True for correct. False for incorrect.
    */   
    public boolean checkDatetimeFormat(String inputDate){
        try{
            LocalDateTime parsedDate = LocalDateTime.parse(inputDate, date_formatter);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**
    * Checks if the times between dateLeft and dateRight are either earlier, later or on time
    * @param dateLeft the datetime to minus to the right side
    * @param dateRight the datetime to minus to the left side
    * @return an integer that denotes whether the time is earlier (0), later (1) or the same (2).
    */   
    public int compareDateAndTime(LocalDateTime dateLeft, LocalDateTime dateRight){
    // Initalize both dates
    
    // Check if the date is earlier
    // 0 is earlier
    // 1 is later
    // 2 is equal
    if(dateLeft.compareTo(dateRight)>0){
        //System.out.println("Date left is earlier");
        
        return 0;
    }else if(dateLeft.compareTo(dateRight)<0){
        //System.out.println("Date left is later");
        return 1;
    }else{
        //System.out.println("Same date!");
        return 2;
    }
    }
    
    /**
    * Returns a boolean value to see if the dates between time do clash.
    * @param dateLeft the datetime to minus to the right side
    * @param dateRight the datetime to minus to the left side
    * @return a boolean that denotes whether the time is the same (2), which means a clash has occured. True for clash. False for no clash.
    */   
    public boolean clashDates(LocalDateTime dateLeft, LocalDateTime dateRight){
        if(compareDateAndTime(dateLeft, dateRight) == 2){
            return true;
        }else{
            return false;
        }
    }
}
