package com.kardusinfo.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private final SharedPreferences.Editor editor;
    private final SharedPreferences sharedPreferences;
    PrefManager(Context context, String prefName) {
        sharedPreferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }
    public void setPrefValue(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public void setSignedStatus(boolean status){
        editor.putBoolean("SIGNEDIN", status).apply();
    }

    public boolean isSignedIn(){
        return sharedPreferences.getBoolean("SIGNEDIN",false);
    }

    public String getPrefValue(String key) {
        return sharedPreferences.getString(key, "Not Found");
    }

    public void removePref(String key) {
        editor.remove(key).apply();
    }
}
