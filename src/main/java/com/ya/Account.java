package com.ya;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name == null) {
            return false;
        }

         return name.length() >= 3 && name.length() <= 19 &&
                 name.length() - name.replace(" ", "").length() == 1 &&
                 !name.replace(" ", "").equals(name);
    }
}
