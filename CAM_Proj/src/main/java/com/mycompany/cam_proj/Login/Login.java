/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cam_proj.Login;

import com.mycompany.cam_proj.User;
import java.util.ArrayList;

/**
 *
 * @author Halogen
 */
interface Login {
    User getUserCookie();
    boolean runLogin(String fileLocation, ArrayList<User> userList);
    
}
