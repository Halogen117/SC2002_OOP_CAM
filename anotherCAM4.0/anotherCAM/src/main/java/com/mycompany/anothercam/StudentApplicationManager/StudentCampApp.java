/**
Represents the StudentCampApp Object and the following assistance methods.
A StudentCampApp is only run once.
@author Russel Tan Jun Hong
@version 1.0
@since 2023-10-27
*/
package com.mycompany.anothercam.StudentApplicationManager;
import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.Login.Verification;
import com.mycompany.anothercam.User;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Halogen
 */
public class StudentCampApp{
    /**
    * Runs the Student Camp Application to access main menu subsections for the different camp functions.
    * @param campArray the CampArray which the new camp object is stored.
    * @param cookie the User Object (A Staff) which the requested user creates the Camp
    * @param scanObj takes in the scanner Object for automated testing.
    * @return boolean value once the application has completed running. True for successful run. False for unknown exit.
    */
    public boolean runStudentCampApp(ArrayList<Camp> campArray, User cookie, Scanner scanObj){
        Verification verifier = new Verification();
        boolean loopCamp = true;
        while(loopCamp){
            if(cookie == null){
                loopCamp = false;
                break;
            }
            System.out.println("Welcome to the camp subsection");
            System.out.println("0. Exit Camp Interface");
            System.out.println("1. View Camps");
            System.out.println("2. Register Camp");
            System.out.println("3. Unregister Camp");

            int chooseCamp = verifier.verifyScannerNumber(scanObj);
            switch(chooseCamp){
                case 0:
                    loopCamp = false;
                    break;

                case 1:
                    StudentCampView studView = new StudentCampView();
                    studView.runStudentViewCamp(campArray, cookie, scanObj);
                    break;
                
                case 2:
                    StudentCampRegister studReg = new StudentCampRegister();
                    studReg.runStudentRegister(campArray, cookie, scanObj);
                    break;

                case 3:
                    StudentCampUnregister studUnReg = new StudentCampUnregister();
                    studUnReg.runUnregister(campArray, cookie, scanObj);
                    break;
            }
        }
        return true;
    }
}
