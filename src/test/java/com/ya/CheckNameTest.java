package com.ya;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckNameTest {

    String fullName;
    boolean expected;

    public CheckNameTest(String fullName, boolean expected) {
        this.fullName = fullName;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getFullNameData() {
        return new Object[][] {
                {"Александр Овечкин", true},
                {"Александр Овечкин ", false},
                {" Александр Овечкин", false},
                {" Александр Овечкин ", false},
                {"Александр  Овечкин", false},
                {"АлександрОвечкин", false},
                {"Александр ОвечкинИБольше19Букв", false},
                {"Ал", false},
                {"ш ш в", false},
        };
    }

    @Test
    public void ifNameMeetsRequirementsTest() {

        Account account = new Account(fullName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}

