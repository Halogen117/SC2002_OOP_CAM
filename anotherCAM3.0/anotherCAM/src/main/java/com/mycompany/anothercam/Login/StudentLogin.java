/**
Represents the StudentLogin Object and the following assistance methods.
A StudentLogin can be called only once.
The method is used to login for a student user.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-11-1
*/
package com.mycompany.anothercam.Login;
import com.mycompany.anothercam.User;
import com.mycompany.anothercam.StudentList;
import java.util.Scanner;

public class StudentLogin implements Login{
    private Authenticate auth = new Authenticate();
    
    /**
    * Runs the login procedure of for the Student User
    * @param fileLocation takes in the file location where the student csv file is stored for the login procedure.
    * @param scanObj takes in the scanner Object for automated testing.
    * @return True if the the authentication is successful.
    * Returns False if the authentication is unsuccessful.
    */
    public boolean runLogin(String fileLocation, Scanner scanObj){
        if(!this.auth.return_authenticate(StudentList.studList, scanObj)){
            System.out.println("Unverified Student! Try logging in again!");
            return false;
        }
        return true;
    }
    
    /**
    * Gets the User cookie of the Student Object.
    * @return Student Object denoted as cookie.
    */
    public User getUserCookie(){
        return this.auth.getUserCookie();
    }
    
    /**
    * Logs the Student Object out when called.
    * @return true to signify that the student has successfully logged out.
    */
    public boolean studentLogOut(){
        this.auth.clearUserCookie();
        return true;
    }
    
    // Set user Cookie?
}
