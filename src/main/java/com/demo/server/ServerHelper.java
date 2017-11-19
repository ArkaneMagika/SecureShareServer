package com.demo.server;

///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package secureshareserver;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.ServerSocket;
//import java.net.Socket;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.eclipse.jetty.server.Server;
//
///**
// *
// * @author Akane D. Simpson
// */
//public class ServerHelper implements Runnable{
//    @Override
//    public void run(){
//        
//    }
//    
//    public static void connect(){
//        try {
//            connSocket = new ServerSocket(port);
////            connSocket.setSoTimeout(5000);
//            System.out.println("Listening on port " + port + "....");
////            System.out.println("Waiting for client on port " + connSocket.getLocalPort() + "....");
//
//            while (true) {
//                Socket server = connSocket.accept();
//
////                System.out.println("Just connected to " + server.getRemoteSocketAddress());
//                in = new DataInputStream(server.getInputStream());
//
//                System.out.println(in.readUTF());
//                out = new DataOutputStream(server.getOutputStream());
//
//                out.writeUTF("Connection Established with " + server.getLocalSocketAddress());
//                server.setKeepAlive(true);
//
////                Thread thrd = new Thread(new ServerThread(server));
////                threadList.add(thrd);
////                thrd.start();
//                numThreads.incrementAndGet();
//
////                System.out.println("Starting Server Thread");
////                ServerThread StartThread = new ServerThread(server);
////                StartThread.StartStream();
//                server.setKeepAlive(true);
//
//                if (in.readBoolean()
//                        == true) {
//                    try {
//                        //        SMS.SendPassword(pass);
//                        while (true) {
//                            String read = in.readUTF();
////                            MessageService(true, read);
//                        }
//                    } catch (IOException ex) {
//                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//
//                if (in.readInt()
//                        == 1) {
//                    try {
//                        while (true) {
//                            String read1 = in.readUTF();
//                            String read2 = in.readUTF();
//                            String read3 = in.readUTF();
////                            EmailService(read1, read2, read3);
//                        }
//                    } catch (IOException ex) {
//                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
//
//                    }
//                }
//            }
//        } catch (IOException ioe) {
//            ioe.printStackTrace();
////            thrd.stop();
//        }
//    }
//    
//    public static void MessageService(boolean confirmation, String pass) {
//        SMS.SendPassword(pass);
//    }
//
//    public static void EmailService(String to, String from, String file) throws IOException {
//        SendEmailAttachment.ConstructEmail(to, from, file);
//    }
//}
//
