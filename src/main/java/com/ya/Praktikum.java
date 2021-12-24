package com.ya;

public class Praktikum {

    public static void main(String[] args) {

        String fullName = "Александр Овечкин";

        Account account = new Account(fullName);
        account.checkNameToEmboss();
    }
}