package dataStructures;

import javax.swing.*;
import java.awt.*;

public abstract class User {
    protected String username;
    protected String password;
    protected String CNP;
    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }

    public void setCNP(String CNP) {
        if(!isNumeric(CNP)){
            Component frame = null;
            JOptionPane.showMessageDialog(frame,
                    "CNP-ul este invalid",
                    "eroare la conectare",
                    JOptionPane.ERROR_MESSAGE);
        }
        else
            this.CNP = CNP;
    }

    public String getCNP() {
        return CNP;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", CNP='" + CNP + '\'' +
                '}';
    }
}