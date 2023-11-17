/**
Represents the Staff Object and the following mutator methods.
A staff can create multiple camps.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-28
*/
package com.mycompany.anothercam;

import java.util.ArrayList;
import com.mycompany.anothercam.StaffList;


public class Staff extends User{
    /**
    * The Staff Constructor.
    * The User interface is extended to this class.
    * @param userID The unique userID of the Staff.
    * @param email The email of the Staff.
    * @param facultyInfo The faculty of the Staff is in.
    */
    public Staff(String userID, String userName,String email, String facultyInfo){
        super(userID, userName, email, facultyInfo);
    }
    
}
