package com.dmcs.karol.utils;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppDemoUtils {

    public static boolean checkEmailOrPassword(String pattern, String pStr) {

        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pStr);
        return m.matches();
    }

    /**
     * Generator losowych łańcuchów znaków
     * @return String
     */
    public static String randomStringGenerator() {
        String randomString = "";

        String signs = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        Random rnd = new Random();

        for (int i = 0; i < 32; i++) {
            int liczba = rnd.nextInt(signs.length());
            randomString += signs.substring(liczba, liczba + 1);
        }
        return randomString;
    }

    public static String getLoggedUser(){
        String username = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(!(auth instanceof AnonymousAuthenticationToken))
        {
            username = auth.getName();
        }
        return username;
    }
}