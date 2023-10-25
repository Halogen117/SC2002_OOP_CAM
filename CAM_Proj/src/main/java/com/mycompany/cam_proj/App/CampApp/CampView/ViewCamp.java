package com.mycompany.cam_proj.App.CampApp.CampView;

import com.mycompany.cam_proj.Camp;
import com.mycompany.cam_proj.User;
import java.util.ArrayList;

interface ViewCamp{
    boolean runViewCamp(ArrayList<Camp> camp_array, User cookie);
}