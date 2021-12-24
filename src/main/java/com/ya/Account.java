package com.ya;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

         return name.length() >= 3 && name.length() <= 19 &&
                 name.length() - name.replace(" ", "").length() <= 1 &&
                 !name.replace(" ", "").equals(name) &&
                 name.equals(name.trim());
    }
}
