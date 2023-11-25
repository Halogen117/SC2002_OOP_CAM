/**
Represents the Verification Object and the following assistance methods.
A verification object can be called multiple times depending on the use cases
* Overall used in the CreateCamp functions and where scanner object is used
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam.Login;
import com.mycompany.anothercam.Camp.visibilityStatus;
import java.time.LocalDateTime;
import java.util.Scanner;


// To verify all inputs when accessed to be boolean to return true for correct input and false for incorrect input
public class Verification {
    private int loopTolerance = 5;
    private int loopLooper;
    private boolean brokenTolerance = false;
    
    /**
    * Changes the loop tolerance of the Verification Object
    * @param loopTolerance This camp's new location should just be a regular string in general.
    *                      The validation is already done before the method is called.
    *                      This loopTolerance variable is used to loop an error validation until the user gets the values right.
    *                      If the validation exceeds loopTolerance, exit the validation.
    */
    public void setLoopTolerance(int loopTolerance){
        this.loopTolerance = loopTolerance;
    }
    
    /**
    * Gets the loopTolerance count from the Verification Object.
    * @return the loopTolerance count.
    */
    public int getLoopTolerance(){
        return this.loopTolerance;
    }
    
    /**
    * Returns the verification status whether a string is empty or not
    * @param stringer takes in the string variable to verify if empty.
    * @return boolean value of True if the string is successfully verified. False if the string is empty.
    */
    private boolean verifyString(String stringer){
        if(stringer == null){
            return false;
        }
        return true;
    }
    
    /**
    * Returns the verification status whether a integer is validated number or not.
    * @param stringer takes in the integer variable to verify if valid.
    * @return boolean value of True if the Integer is successfully verified. False if the Integer is not valid.
    */
    private boolean verifyNumber(int number){
        // Edit to verify this shit
        try{
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
    /**
    * Returns the verification status whether the Number is valid.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return integer value if the Integer is successfully verified. -1 if the Integer is not valid.
    */
    public int verifyScannerNumber(Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            while(true){
                try{
                    System.out.print("Enter your choice: ");
                    int number = scanObj.nextInt();
                    this.loopLooper = 0;
                    return number;
                }catch(Exception e){
                    scanObj.nextLine();
                    System.out.println("Invalid Integer Input! Please Try Again!");
                    this.loopLooper += 1;
                    break;
                }
            }
        }
        this.loopLooper = 0;
        System.out.println("You exceeded the number of invalid input entries! Exiting to the Main Menu...");
        return -1;
    }
    
    
    /**
    * Returns the verification status whether the Camp Name is valid.
    * @param campName takes in the campName of the camp to be added into the application
    * @param questionAsked takes in the question to be asked when entering the Camp Name.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value of True if the Integer is successfully verified. False if the Integer is not valid.
    */
    public String verifyCampName(String campName, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            while(true){
                
                System.out.println(questionAsked);
                try{
                    System.out.print("Enter your choice: ");
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
        System.out.println("You exceeded the number of invalid input entries! Exiting to the Main Menu...");
        return null;
    }
    
    /**
    * Returns the verification status whether the Camp Date is valid.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return integer array of the date values. Return null if invalid values.
    */
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

                    System.out.println("What is the Hour? (0-23)");
                    int hour = scanObj.nextInt();
                    if(!verifyNumber(hour) || (-1 > hour || hour  > 24)){
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
        System.out.println("You exceeded the number of invalid input entries! Exiting to the Main Menu...");
        return null;
    }
    /*
    public boolean verifyRegistrationClosingDate(){
        //this.d
        return true;
    }
    */
    
    /**
    * Returns the verification status whether the Camp Location is valid.
    * @param location takes in the location of the camp to be added into the application.
    * @param questionAsked takes in the question to be asked when entering the Camp Name.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return string of the location values. Return null if invalid values.
    */
    public String verifyCampLocation(String location, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            while(true){
                try{
                    System.out.print("Enter your choice: ");
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
        System.out.println("You exceeded the number of invalid input entries! Exiting to the Main Menu...");
        return null;
        
    }
    
    /**
    * Returns the verification status whether the student attendee count is valid.
    * @param totalStudent takes in the student attendee count of the camp to be added into the application.
    * @param totalCommittee takes in the camp committee member count
    * @param questionAsked takes in the question to be asked when entering the Camp Name.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return integer of the student attendee count. Return -1 if invalid values.
    */
    public int verifyTotalStudents(int totalStudent, int totalCommittee ,String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            try{
                totalStudent = scanObj.nextInt();
                if(totalCommittee > totalStudent){
                    System.out.println("There cannot be more Camp Committee members than Student Attendees!");
                    this.loopLooper += 1;
                    
                }else if(verifyNumber(totalStudent) == true){
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
        System.out.println("You exceeded the number of invalid input entries! Exiting to the Main Menu...");
        return -1;
    }
    
    /**
    * Returns the verification status whether the camp committee count is valid.
    * @param inputCampCom takes in the camp committee count of the camp to be added into the application.
    * @param questionAsked takes in the question to be asked when entering the Camp Name.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return integer of the camp committee count. Return -1 if invalid values.
    */
    public int verifyCampCommittee(int inputCampCom, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            System.out.println(questionAsked);
            try{
                inputCampCom = scanObj.nextInt();
                if(verifyNumber(inputCampCom) == true){
                    if(-1< inputCampCom && inputCampCom <= 10){
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
        System.out.println("You exceeded the number of invalid input entries! Exiting to the Main Menu...");
        return -1;
    }
    
    /**
    * Returns the verification status whether the camp description is valid.
    * @param description takes in the description of the camp to be added into the application.
    * @param questionAsked takes in the question to be asked when entering the Camp Name.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return string of the description. Return null if invalid values.
    */
    public String verifyDescription(String description, String questionAsked, Scanner scanObj){
        while(this.loopTolerance != this.loopLooper){
            while(true){
                System.out.println(questionAsked);
                try{
                    System.out.print("Enter your choice: ");
                    scanObj.nextLine();
                    description = scanObj.nextLine();
                    if(verifyString(description)){
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
        System.out.println("You exceeded the number of invalid input entries! Exiting to the Main Menu...");
        return null;
    }    

    /**
    * Returns the verification status whether the camp toggle visibility is valid.
    * @param togVisible takes in the visibility status of the camp to be added into the application. The value is either 1,2,3 which corresponds to the visibility enum.
    * @param questionAsked takes in the question to be asked when entering the Camp Name.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return visibility enumeration of the camp. Return No Visible enumeration if invalid values.
    */
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
                    System.out.println("Setting visibility to be viewed by only Staff members.");
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
