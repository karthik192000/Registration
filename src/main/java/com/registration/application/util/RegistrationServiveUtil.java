package com.registration.application.util;

public class RegistrationServiveUtil {




    public static String stringToAscii(String str){
        StringBuilder stringBuilder = new StringBuilder();


        char[] charArray = str.toCharArray();

        for(char ch: charArray){
            stringBuilder.append((byte) ch);
        }

        return stringBuilder.toString();
    }
}
