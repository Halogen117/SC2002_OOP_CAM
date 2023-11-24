package com.mycompany.anothercam.implementActions;

import com.mycompany.anothercam.Camp;
import com.mycompany.anothercam.User;

import java.util.ArrayList;
import java.util.Scanner;

public interface Delete {
    boolean runDelete(ArrayList<Camp> camp_array, User cookie, Scanner scanObj);
}
