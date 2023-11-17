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
import java.util.Scanner;

public class Authenticate {
    private User userCookie;
    /**
    * Returns the boolean status whether the authentication of a user has been achieved.
    * @return true if the user is authenticated.
    *         Returns false if not authenticated,
    */
    public boolean return_authenticate(ArrayList<User> user_list, Scanner scanObj){
        //Scanner scanObj = new Scanner(System.in);
        System.out.println("What is your Username?");
        System.out.print("Enter your choice: ");
        String username = scanObj.next();
        System.out.println("What is your Password?");
        System.out.print("Enter your choice: ");
        String password = scanObj.next();
        for(User user : user_list){
            if((user.getUserID()).equals(username)){
                if((user.getPassword()).equals(password)){
                    this.userCookie = user; 
                    return true;
                }
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
