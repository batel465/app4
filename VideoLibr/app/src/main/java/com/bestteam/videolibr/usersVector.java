package com.bestteam.videolibr;

import java.util.ArrayList;

/**
 * Created by Arkadi on 30/11/2017.
 */

public class usersVector
{
    private static ArrayList<User> users = new ArrayList<>();
    public static int index = 0;
    public static int CurrentIndx=0;

    public static void AddUser(User user)
    {
        users.add(user);
        index++;
    }

    public static User getUserAt(int index)
    {
        return users.get(index);
    }

    public static boolean isExist(User user)
    {
        for(User u: users)
        {
            if(user.getUserName().equals(u.getUserName()) && user.getPassWord().equals(u.getPassWord()))
            {
                return true;
            }
        }
        return false;
    }

    public static boolean checkAndgetCurrentIndx(User user)
    {
        for(User u: users)
        {
            if(user.getUserName().equals(u.getUserName()) && user.getPassWord().equals(u.getPassWord()))
            {
                CurrentIndx = u.getIndex();
                return true;
            }
        }
        return false;
    }
}
