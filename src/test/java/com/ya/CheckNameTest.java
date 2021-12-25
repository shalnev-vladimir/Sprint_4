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
                {" Александр Овечкин ", false},   // пробел в начале и конце строки
                {"Александр  Овечкин", false},    // 2 пробела между именем и фамилией
                {"АлександрОвечкин", false},      // нет пробела
                {"", false},                      // пустая строка
                {"   ", false},                   // строка из пробелов
                {"А О", true},                    // 3 символа с пробелом посередине
                {"Ал", false},                    // 2 символа
                {"А Ов", true},                   // 4 символа с пробелом посередине
                {"Снорри Бьярнарсонар", true},    // 19 символов с пробелом посередине
                {"Халлдор Бьярнарсонар", false},  // 20 символов с пробелом посередине
                {"Дагур Бьярнарсонар", true},     // 18 символов с пробелом посередине
                {"оо рр тт", false},              // 2 пробела посередине
                {null, false},
                {" блаблабла", false},            // пробел в начале
                {"блаблабла ", false}             // пробел в конце
        };
    }

    @Test
    public void ifNameMeetsRequirementsTest() {

        Account account = new Account(fullName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}

