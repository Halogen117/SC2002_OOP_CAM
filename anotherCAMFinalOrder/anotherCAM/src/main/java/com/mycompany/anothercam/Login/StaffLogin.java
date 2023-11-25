package com.mycompany.anothercam.Login;

import com.mycompany.anothercam.User;
import com.mycompany.anothercam.StaffList;
import java.util.Scanner;

/**
Represents the StaffLogin Object and the following assistance methods.
A StaffLogin can be called only once.
The method is used to login for a staff user.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-1
*/
public class StaffLogin implements Login{
    private Authenticate auth = new Authenticate();
    
    /**
     * This will run the Login Application to verify the staff Object.
     * @param fileLocation Location of the staffList to authenticate the staff.
     * @param scanObj Scanner Object used to pass inputs into.
     * @return boolean to see if the login was successful. True for success. False for unsuccessful.
     */
    public boolean runLogin(String fileLocation, Scanner scanObj){
        if(!auth.return_authenticate(StaffList.staffList, scanObj)){
            System.out.println("Unverified Staff! Try logging in again!");
            return false;
        }
        return true;
    }
    
    /**
    * Gets the Staff cookie of the Student Object.
    * @return Staff Object denoted as cookie.
    */
    public User getUserCookie(){
        return this.auth.getUserCookie();
    }
    
    /**
    * Logs the Staff Object out when called.
    * @return true to signify that the staff has successfully logged out.
    */
    public boolean staffLogOut(){
        this.auth.clearUserCookie();
        return true;
    }
    
}
