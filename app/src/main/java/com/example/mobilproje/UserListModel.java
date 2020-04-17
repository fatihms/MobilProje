package com.example.mobilproje;

public class UserListModel {

    int imageID;
    String userName, password;

    public UserListModel(int p_imageID, String name, String description) {
        this.imageID = p_imageID;
        this.userName = name;
        this.password = description;
    }

    public int getimageID() {
        return imageID;
    }

    public void setimageID(int image_id) {
        this.imageID = image_id;
    }

    public String getuserName() {
        return userName;
    }

    public void setuserName(String name) {
        this.userName = name;
    }

    public String getpassword() {
        return password;
    }

    public void setpassword(String p_password) {
        this.password = p_password;
    }


}
