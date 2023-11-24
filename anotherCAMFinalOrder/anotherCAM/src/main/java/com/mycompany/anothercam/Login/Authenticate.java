/**
Represents the Authentication Object and the following mutator methods.
An Authentication method can be called once.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-31
*/
package com.mycompany.anothercam.Login;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Authenticate {
    private User userCookie;
    /**
    * Returns the boolean status whether the authentication of a user has been achieved.
    * @param userList User array list which contains the user objects
    * @param scanObj the scanner object used to take in inputs
    * @return true if the user is authenticated.
    *         Returns false if not authenticated,
    */
    public boolean return_authenticate(ArrayList<User> userList, Scanner scanObj){
        //Scanner scanObj = new Scanner(System.in);
        System.out.println("What is your Username?");
        System.out.print("Enter your choice: ");
        String username = scanObj.next();
        System.out.println("What is your Password?");
        System.out.print("Enter your choice: ");
        String password = scanObj.next();
        for(User user : userList){
            if(user.getUserID().equals(username) && user.getPassword().equals(password)){
                if(user.getFirstLogin() == false){
                    System.out.println("Do you want to change password? (Y/N)");
                    String newChoose = scanObj.next();
                    if(newChoose.equals("YES") || newChoose.equals("Y")){
                        System.out.println("Please type in your new password!");
                        String change_password = scanObj.next();
                        user.setPassword(change_password);
                        System.out.println("Password has been changed!");
                        System.out.println("Logging out due to password change!");
                        user.setFirstLogin(true);
                        return true;
                    }else if(newChoose.equals("NO") || newChoose.equals("N")){
                        System.out.println("Explicit Not changing password!");
                        user.setFirstLogin(true);
                    }else{
                        System.out.println("Not changing password!");
                        user.setFirstLogin(true);
                    } 
                }
                this.userCookie = user; 
                return true;
            }
        }
        
        
    return false;
    }

    /**
    * Gets the User object which is denoted as a cookie.
    * @return the User Object of the authentication class.
    */
    public User getUserCookie(){
        return this.userCookie;
    }
    
    /**
    * Clears the User Object from the authentication class.
    *  The validation is already done before the method is called.
    */
    public void clearUserCookie(){
        this.userCookie = null;
    }
}
