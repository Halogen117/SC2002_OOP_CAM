
package com.mycompany.anothercam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import com.mycompany.anothercam.Login.Verification;

/**
 *
 * @author Halogen
 */
public class DateFormatter {
    //private Scanner scan_obj = new Scanner(System.in).useDelimiter("\n");
    private static final String date_pattern = "dd-MM-yyyy-HHmm";
    private static final DateTimeFormatter date_formatter= DateTimeFormatter.ofPattern(date_pattern);
    private Verification veriClass = new Verification();

    public LocalDateTime generate_date(Scanner scanObj){
        int timeArray[] = this.veriClass.verifyDate(scanObj);
        if(timeArray == null){
            return null;
        }
        LocalDateTime parse_date  =LocalDateTime.of(timeArray[0], timeArray[1], timeArray[2], timeArray[3], timeArray[4]);
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
    
    public int compareDateAndTime(LocalDateTime dateLeft, LocalDateTime dateRight){
    // Initalize both dates
    
    // Check if the date is earlier
    // 0 is earlier
    // 1 is later
    // 2 is equal
    if(dateLeft.compareTo(dateRight)>0){
        System.out.println("Date left is earlier");
        return 0;
    }else if(dateLeft.compareTo(dateRight)<0){
        System.out.println("Date left is later");
        return 1;
    }else{
        System.out.println("Same date!");
        return 2;
    }
    }
    
    public boolean clashDates(LocalDateTime dateLeft, LocalDateTime dateRight){
        if(compareDateAndTime(dateLeft, dateRight) == 2){
            return true;
        }else{
            return false;
        }
    }
}
