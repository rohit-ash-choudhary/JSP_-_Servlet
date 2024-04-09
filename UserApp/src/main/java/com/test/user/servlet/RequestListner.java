package com.test.user.servlet;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class RequestListner implements ServletRequestListener {

    public void requestInitialized(ServletRequestEvent sre)  { 
        System.out.println("Request initialized");
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
        System.out.println("Request destroyed");
    }
}
