package com.example.java.Projects.HostelManagementSystem;

import javax.swing.*;

public class AboutPage {
    JFrame frame;
    AboutPage(){
        frame=new JFrame("About Project");
        JEditorPane pane=new JEditorPane();
        pane.setContentType("text/html");
        pane.setText("<h1 style=font-size=20px>About us</h1>" +
                "<p style=font-size:15px>Hello My name is Sagar Kapase.I am a Computer Branch Student and I made this project for placement purpose." +
                "This project is useful for to store Hostel Student Data.In this project you can add new student,manage their rooms and see their remaining " +
                "fees also you can add new employee's . In this project not have any contribution this project is made by own. Following is the " +
                "Details about me.</p>" +
                "<p style=font-size:20><h2>-: About Me :-</h2></p>" +
                "<p style=font-size:15>Student Name : Sagar Kapase</p>" +
                "<p style=font-size:15>Collage : Sinhgad Institute of Technology , Lonavala</p>" +
                "<p style=font-size:15>Email : sagarkapase139@gmail.com</p>" +
                "<p style=font-size:15>Project name : Hostel Management System</p>");


        frame.setContentPane(pane);
        frame.setLayout(null);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new AboutPage();
    }
}
