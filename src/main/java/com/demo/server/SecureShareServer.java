/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
//import java.io.
import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
//import java.util.logging.Level;
//import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.*;
import javax.servlet.ServletException;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.*;

/**
 *
 * @author arkane
 */
public class SecureShareServer extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.getWriter().print("");
    }

    public static void Connect (String[] args) throws InterruptedException, Exception {
        AtomicInteger numThreads = new AtomicInteger(0);
        ArrayList<Thread> threadList = new ArrayList<>();

        Server JettyServer = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        
        context.setContextPath("/");
        JettyServer.setHandler(context);
        context.addServlet(new ServletHolder(new SecureShareServer()),"/*");
        
        JettyServer.start();
        JettyServer.join();   

        
        int port = Integer.parseInt(System.getenv("PORT"));

        ServerSocket connSocket = new ServerSocket(port);
        
        Socket open_Socket = new Socket();
        
        DataInputStream in = new DataInputStream(open_Socket.getInputStream());
        DataOutputStream out= new DataOutputStream(open_Socket.getOutputStream());

                
        while(connSocket.isBound()){
            connSocket.accept();
            out.writeUTF("Connection Established on port: "+connSocket.getLocalPort());
        }

    }

    
}
