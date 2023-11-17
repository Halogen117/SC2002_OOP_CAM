/**
Represents the User Object and the following mutator methods.
A user would be associated to the Student and Staff class.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-23
*/
package com.mycompany.anothercam;

public abstract class User {
    private String userID;
    private String userName;
    private String password = "password";
    private String email;
    private String facultyInfo;
    
    /**
    * The User Constructor.
    * @param userID The unique userID generated
    * @param userName The username of the user is generated
    * @param email The email which the user is associated to.
    * @param facultyInfo The faculty which the user is associated to.
    */
    
    public User(String userID, String userName ,String email, String facultyInfo){
        this.userID = userID;
        this.userName = userName;
        this.email = email;
        this.facultyInfo = facultyInfo;
    }

    /**
    * Gets the email of the User Object.
    * @return the email of the User Object.
    */
    public String getEmail(){
        return this.email;
    }

    /**
    * Gets the faculty information of the User Object.
    * @return the faculty information of the User Object.
    */
    public String getFacultyInfo(){
        return this.facultyInfo;
    }

    /**
    * Gets the password of the User Object.
    * @return the password of the User Object.
    */
    public String getPassword(){
        return this.password;
    }
    
    /**
    * Gets the userID of the User Object.
    * @return the userID of the User Object.
    */
    public String getUserID(){
        return this.userID;
    }
    
    /**
    * Gets the username of the User Object.
    * @return the userName of the User Object.
    */
    public String getUserName(){
        return this.userName;
    }

    /**
    * Changes the email of the User Object
    * @param email This user new email should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setEmail(String email){
        this.email = email;
    }

    /**
    * Changes the faculty information of the User Object
    * @param facultyInfo This user new faculty information should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setFacultyInfo(String facultyInfo){
        this.facultyInfo = facultyInfo;
    }

    /**
    * Changes the password of the User Object
    * @param password This user new password should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
    * Changes the userID of the User Object
    * @param userID This user new userID should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setUserID(String userID){
        this.userID = userID;
    }
    
    /**
    * Changes the userName of the User Object
    * @param userName This user new userName should just be a regular string in general.
    *                The validation is already done before the method is called.
    */
    public void setUserName(String userName){
        this.userName = userName;
    }
    
}
