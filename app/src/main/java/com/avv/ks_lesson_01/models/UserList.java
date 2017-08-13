package com.avv.ks_lesson_01.models;

import android.content.Intent;

/**
 * Created by user on 13.08.2017.
 */

public class UserList  {

    private String userName;
    private Integer userID;
    private  boolean isOnline;
    private String userEmail;
    private UserCategory userCategory;

    public String getUserName() {
        return userName;
    }

    public enum UserCategory{
        FRIENDS,
        FAMILY,
        WORK,
        OTHER;

        @Override
        public String toString() {
            //return super.toString();
            switch (this){
                case FRIENDS: return "Friends";
                case FAMILY: return "Family";
                case WORK: return "Work";
                case OTHER: return "Other";
            }
            return "unknown";
        }
    }

    public UserList(String userName, Integer userID, boolean isOnline, String userEmail, UserCategory userCategory) {
        this.userName = userName;
        this.userID = userID;
        this.isOnline = isOnline;
        this.userEmail = userEmail;
        this.userCategory = userCategory;
    }

    public Integer getUserID() {
        return userID;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public UserCategory getUserCategory() {
        return userCategory;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserCategory(UserCategory userCategory) {
        this.userCategory = userCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserList userList = (UserList) o;

        if (!getUserName().equals(userList.getUserName())) return false;
        return getUserID().equals(userList.getUserID());

    }

    @Override
    public int hashCode() {
        int result = getUserName().hashCode();
        result = 31 * result + getUserID().hashCode();
        return result;
    }



}
