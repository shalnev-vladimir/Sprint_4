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
                {"Александр Овечкин", true},      // валидное значение
                {"Александр Овечкин ", false},    // пробел в конце строки
                {" Александр Овечкин", false},    // пробел в начале строки
                {" Александр Овечкин ", false},   // пробел в начале и конце строки
                {"Александр  Овечкин", false},    // 2 пробела между именем и фамилией
                {"АлександрОвечкин", false},      // нет пробела
                {"", false},                      // пустая строка
                {"   ", false},                   // строка из пробелов
                {"А О", true},                    // 3 символа
                {"Ал", false},                    // 2 символа
                {"А Ов", true},                   // 4 символа
                {"Снорри Бьярнарсонар", true},    // 19 символов
                {"Халлдор Бьярнарсонар", false},  // 20 символов
                {"Дагур Бьярнарсонар", true},     // 18 символов
                {"о р т", false},                 // в строке не может быть больше 1 пробела, даже если кол-во букв в строке от 3 до 19
                {null, false}
        };
    }

    @Test
    public void ifNameMeetsRequirementsTest() {

        Account account = new Account(fullName);
        boolean actual = account.checkNameToEmboss();
        assertEquals(expected, actual);
    }
}

