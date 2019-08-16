package io.pivotal.support.rogueinstances.objects;

public class BackingApp {

    private static String appGUID;
    private static String appName;
    //private static String


    public BackingApp(String appName){
        this.appName = appName;
        this.appGUID = appName.split("-", 2)[1];
    }

    public static String getAppName() {
        return appName;
    }

    public static String getAppGUID() {
        return appGUID;
    }
}

