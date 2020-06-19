package dataStructures;

import Exceptions.CNPException;

public abstract class User {
    protected String username;
    protected String password;
    protected String CNP;
    private boolean flag;
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

    public void setCNP(String CNP) throws CNPException {
        if(!isNumeric(CNP)) {
            flag = true;
            throw new CNPException();
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
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public boolean isFlag() {
        return flag;
    }
}