package com.example.java.Projects.HostelManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Registration_form {
    JFrame frame;
    Registration_form(){
        frame=new JFrame("Register");
        Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sagar\\Desktop\\Logo.png");

        Label l1,l2,l3,l4,l5,l6,l7,l8,l9;

        JTextField t2,t3,t4,t5,t6,t7,t8;
        JPasswordField p;

        JButton register_Btn,login_btn,reset_btn;

        l1=new Label("Warden Registration");
        l1.setBackground(null);
        l2=new Label("ID NO : ");
        l3=new Label("First Name : ");
        l4=new Label("Last Name : ");
        l5=new Label("Address : ");
        l6=new Label("Mobile no : ");
        l7=new Label("Hostel Name : ");
        l8=new Label("Email Address : ");
        l9=new Label("Set Password : ");

        //textfiled
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();
        t6=new JTextField();
        t7=new JTextField();
        t8=new JTextField();

        p=new JPasswordField();

        register_Btn=new JButton("Register");
        register_Btn.setBackground(Color.MAGENTA);
        register_Btn.setForeground(Color.BLACK);
        login_btn=new JButton("Login");
        login_btn.setBackground(Color.MAGENTA);
        login_btn.setForeground(Color.BLACK);
        reset_btn=new JButton("Reset");
        reset_btn.setBackground(Color.MAGENTA);
        reset_btn.setForeground(Color.BLACK);

        //set bounds

        l1.setBounds(680,80,400,40);
        l1.setFont(new Font("Verdana",Font.BOLD,27));

        l2.setBounds(450,150,100,20);
        l2.setFont(new Font("Verdana",Font.BOLD,15));

        l3.setBounds(450,200,100,20);
        l3.setFont(new Font("Verdana",Font.BOLD,15));

        l4.setBounds(450,250,100,20);
        l4.setFont(new Font("Verdana",Font.BOLD,15));

        l5.setBounds(450,300,100,20);
        l5.setFont(new Font("Verdana",Font.BOLD,15));

        l6.setBounds(800,150,100,20);
        l6.setFont(new Font("Verdana",Font.BOLD,15));

        l7.setBounds(800,200,110,20);
        l7.setFont(new Font("Verdana",Font.BOLD,15));

        l8.setBounds(800,250,150,20);
        l8.setFont(new Font("Verdana",Font.BOLD,15));

        l9.setBounds(800,300,150,20);
        l9.setFont(new Font("Verdana",Font.BOLD,15));

        //buttons
        register_Btn.setBounds(620,400,130,35);
        login_btn.setBounds(770,400,130,35);
        reset_btn.setBounds(920,400,130,35);

        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.getContentPane().add(login_btn);
        login_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Login_Form();
            }
        });


        //setting textField
        t2.setBounds(550,150,200,25);
        t2.setFont(new Font("Verdana",Font.BOLD,10));

        t3.setBounds(550,200,200,25);
        t3.setFont(new Font("Verdana",Font.BOLD,10));

        t4.setBounds(550,250,200,25);
        t4.setFont(new Font("Verdana",Font.BOLD,10));

        t5.setBounds(550,300,200,25);
        t5.setFont(new Font("Verdana",Font.BOLD,10));

        t6.setBounds(950,150,200,25);
        t6.setFont(new Font("Verdana",Font.BOLD,10));

        t7.setBounds(950,200,200,25);
        t7.setFont(new Font("Verdana",Font.BOLD,10));

        t8.setBounds(950,250,200,25);
        t8.setFont(new Font("Verdana",Font.BOLD,10));

        p.setBounds(950,300,200,25);


        reset_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                p.setText("");

            }
        });
        //database code
        register_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id_no= t2.getText();
                String first_name=t3.getText();
                String last_name=t4.getText();
                String address=t5.getText();
                String mobile_number=t6.getText();
                int len=mobile_number.length();
                String collage=t7.getText();
                String email_address=t8.getText();
                String password=p.getText();


                    try {
                        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hostel", "root", "Pass@123");
                        Statement statement=connection.createStatement();
                        String Query2="Select * from registration where id_no='"+id_no+"' or mobile_number='"+mobile_number+"' or email_address='"+email_address+"'";
                        ResultSet rs= statement.executeQuery(Query2);
                        if (rs.next()){
                            JOptionPane.showMessageDialog(null,"ID or Mobile number or Email already exist");
                        }else {
                            if (len == 10) {

                                String Query1 = "Insert into registration(id_no,first_name,last_name,address,mobile_number,collage,email_address,password) values(?,?,?,?,?,?,?,?)";
                                PreparedStatement ps = connection.prepareStatement(Query1);
                                ps.setString(1, id_no);
                                ps.setString(2, first_name);
                                ps.setString(3, last_name);
                                ps.setString(4, address);
                                ps.setString(5, mobile_number);
                                ps.setString(6, collage);
                                ps.setString(7, email_address);
                                ps.setString(8, password);
                                ps.executeUpdate();
                                JOptionPane.showMessageDialog(null, "You are register successfully");
                                t2.setText("");
                                t3.setText("");
                                t4.setText("");
                                t5.setText("");
                                t6.setText("");
                                t7.setText("");
                                t8.setText("");
                                p.setText("");
                            }else {
                                JOptionPane.showMessageDialog(null,"Enter valid mobile number");
                            }
                        }

                        connection.close();
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
        });

        frame.setIconImage(icon);
        frame.getContentPane().setBackground(Color.decode("#3366cc"));
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(l4);
        frame.add(l5);
        frame.add(l6);
        frame.add(l7);
        frame.add(l8);
        frame.add(register_Btn);
        frame.add(login_btn);
        frame.add(t2);
        frame.add(t3);
        frame.add(t4);
        frame.add(t5);
        frame.add(t6);
        frame.add(t7);
        frame.add(t8);
        frame.add(p);
        frame.add(l9);
        frame.add(reset_btn);

        frame.setSize(1550,1200);
        frame.setLayout(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Registration_form();
    }
}
