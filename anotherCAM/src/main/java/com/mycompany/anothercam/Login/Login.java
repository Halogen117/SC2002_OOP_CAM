/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.anothercam.Login;

import com.mycompany.anothercam.User;
import java.util.Scanner;
/**
 *
 * @author Halogen
 */
interface Login {
    User getUserCookie();
    boolean runLogin(String fileLocation, Scanner scanObj);
    
}
