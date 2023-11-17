package com.mycompany.anothercam.Login;

import com.mycompany.anothercam.User;
import java.util.Scanner;

interface Login {
    User getUserCookie();
    boolean runLogin(String fileLocation, Scanner scanObj);
    
}
