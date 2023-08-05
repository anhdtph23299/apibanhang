package com.example.asm.security;

import jakarta.servlet.http.HttpServletRequest;

public class UserRequestContextHolder {
    private static HttpServletRequest userRequestContextHolder ;

    public static void setRequest(HttpServletRequest request) {
        System.out.println(request);
        userRequestContextHolder = request;
    }

    public static HttpServletRequest getRequest() {
        return userRequestContextHolder;
    }

    public static void clear() {
    }
}


