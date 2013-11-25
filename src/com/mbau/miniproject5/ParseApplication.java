package com.mbau.miniproject5;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
import com.parse.ParseObject;
import com.parse.ParseAnalytics;
import android.app.Application;
 
public class ParseApplication extends Application {
 
    @Override
    public void onCreate() {
        super.onCreate();
        
        ParseObject.registerSubclass(Image.class);
 
        // Add your initialization code here
        Parse.initialize(this, "xYMRyzzSxE6Jtgbe49xy4kf5LcsHjY7EDCusH7tH", "L1f7oiKS20lzQlPYcY2ZzGbbz7xCQYmO66qHrJp4");
 
        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
 
        // If you would like all objects to be private by default, remove this
        // line.
        defaultACL.setPublicReadAccess(true);
 
        ParseACL.setDefaultACL(defaultACL, true);
    }
 
}