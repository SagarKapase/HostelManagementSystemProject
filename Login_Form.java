package com.example.java.Projects.HostelManagementSystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login_Form {
    JFrame frame;
    Login_Form(){
        frame=new JFrame("Login");
        Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sagar\\Desktop\\Logo.png");
        ImageIcon img=new ImageIcon("C:\\Users\\Sagar\\Documents\\login.jpg");
        JLabel l1,l2,l3,background;
        JTextField t2;
        JPasswordField p;
        JButton login_Btn,register_btn;

        l1=new JLabel("Hostel Management System");
        l2=new JLabel("Email : ");
        l3=new JLabel("Password : ");
        background=new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1550,1200);
        login_Btn=new JButton("Login");
        register_btn=new JButton("Register");

        t2=new JTextField();
        p=new JPasswordField();

        l1.setBounds(510,300,450,30);
        l1.setFont(new Font("Verdana",Font.BOLD,27));

        l2.setBounds(550,400,200,20);
        l2.setFont(new Font("Verdana",Font.BOLD,15));

        l3.setBounds(550,450,200,20);
        l3.setFont(new Font("Verdana",Font.BOLD,15));

        t2.setBounds(700,400,180,25);
        t2.setFont(new Font("Verdana",Font.BOLD,10));
        p.setBounds(700,450,180,25);
        p.setFont(new Font("Verdana",Font.BOLD,10));

        register_btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Registration_form();
            }
        });

        login_Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username=t2.getText();
                String password=p.getText();


                try{
                    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                    Statement stmt=connection.createStatement();
                    String query="Select * from registration where email_Address='"+username+"' and password='"+password+"'";
                    ResultSet rs=stmt.executeQuery(query);

                    if (rs.next()){
                       frame.dispose();
                       //+++++++++++++++++++++++++++++ HOMEPAGE STARTS HERE +++++++++++++++++++++++++++++++

                        JFrame uframe;
                        uframe=new JFrame("UserHomePage");
                        Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sagar\\Desktop\\Kali Linux\\logo.png");

                        JLabel background,menu;
                        JPanel panel;
                        ImageIcon imageIcon=new ImageIcon("C:\\Users\\Sagar\\Desktop\\Kali Linux\\image.jpg");
                        JButton logout,profile,new_student,search_student,update_delete,search_rooms,student_fees,fill_student_fees,student_fees_details,new_employee,employee_details,contact,about;

                        background=new JLabel("",imageIcon,JLabel.CENTER);
                        background.setBounds(0,0,1550,1200);


                        menu=new JLabel("Menu");


                        menu.setBounds(80,10,100,40);
                        menu.setFont(new Font("Verdana",Font.PLAIN,27));
                        panel=new JPanel();
                        panel.setBounds(0,50,250,1);
                        panel.setBackground(Color.gray);



                        //all buttons
                        logout=new JButton("LogOut");
                        profile=new JButton("Profile");
                        search_student=new JButton("Search");
                        new_student=new JButton("New Student");
                        update_delete=new JButton("Update & Delete");
                        search_rooms=new JButton("Manage Rooms");
                        student_fees=new JButton("Student Fees");
                        fill_student_fees=new JButton("Update Student Fees");
                        student_fees_details=new JButton("Fees Details");
                        new_employee=new JButton("New Employee");
                        employee_details=new JButton("Employee Details");
                        contact=new JButton("Contact");
                        about=new JButton("About");

                        logout.setBounds(20,70,200,35);
                        logout.setBackground(Color.decode("#668cff"));

                        profile.setBounds(20,125,200,35);
                        profile.setBackground(Color.decode("#668cff"));

                        new_student.setBounds(20,180,200,35);
                        new_student.setBackground(Color.decode("#668cff"));
                        search_student.setBounds(20,235,200,35);
                        search_student.setBackground(Color.decode("#668cff"));
                        update_delete.setBounds(20,290,200,35);
                        update_delete.setBackground(Color.decode("#668cff"));
                        search_rooms.setBounds(20,345,200,35);
                        search_rooms.setBackground(Color.decode("#668cff"));
                        student_fees.setBounds(20,400,200,35);
                        student_fees.setBackground(Color.decode("#668cff"));

                        fill_student_fees.setBounds(20,455,200,35);
                        fill_student_fees.setBackground(Color.decode("#668cff"));

                        student_fees_details.setBounds(20,510,200,35);
                        student_fees_details.setBackground(Color.decode("#668cff"));

                        new_employee.setBounds(20,565,200,35);
                        new_employee.setBackground(Color.decode("#668cff"));

                        employee_details.setBounds(20,620,200,35);
                        employee_details.setBackground(Color.decode("#668cff"));

                        contact.setBounds(20,675,200,35);
                        contact.setBackground(Color.decode("#668cff"));
                        about.setBounds(20,725,200,35);
                        about.setBackground(Color.decode("#668cff"));

                        logout.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int result = JOptionPane.showConfirmDialog(frame,"Sure? You want to exit?", "Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                                if (result==JOptionPane.YES_OPTION){
                                    uframe.dispose();
                                    new Login_Form();
                                }else {
                                    JOptionPane.showMessageDialog(null,"Continue...");
                                }
                            }
                        });


                        //homepage profile button
                        profile.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String profile_username=t2.getText();
                                try {
                                    Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                    Statement statement=connection.createStatement();
                                    String query="Select * from registration where email_address='"+profile_username+"'";
                                    ResultSet rs= statement.executeQuery(query);
                                    if (rs.next()){
                                        JFrame profile_frame;
                                        profile_frame=new JFrame("Profile");
                                        JLabel mainlable,lid,l_firstname,l_lastname,l_address,l_mobile,l_hostel,l_email;


                                        String id=rs.getString("id_no");
                                        String fname=rs.getString("first_name");
                                        String lname=rs.getString("last_name");
                                        String address=rs.getString("address");
                                        String mobile=rs.getString("mobile_number");
                                        String hostel=rs.getString("collage");
                                        String email=rs.getString("email_address");

                                        mainlable=new JLabel("Profile Information");
                                        lid=new JLabel("ID No : "+id);
                                        l_firstname=new JLabel("First Name : "+fname);
                                        l_lastname=new JLabel("Last Name : "+lname);
                                        l_address=new JLabel("Address : "+address);
                                        l_mobile=new JLabel("Mobile : "+mobile);
                                        l_hostel=new JLabel("Hostel : "+hostel);
                                        l_email=new JLabel("Email : "+email);

                                        mainlable.setBounds(470,80,300,35);
                                        lid.setBounds(350,150,300,35);
                                        l_firstname.setBounds(350,200,300,35);
                                        l_lastname.setBounds(350,250,300,35);
                                        l_address.setBounds(350,300,300,35);
                                        l_mobile.setBounds(600,150,300,35);
                                        l_hostel.setBounds(600,200,300,35);
                                        l_email.setBounds(600,250,300,35);

                                        mainlable.setFont(new Font("Verdana",Font.BOLD,20));
                                        lid.setFont(new Font("Verdana",Font.BOLD,15));
                                        l_firstname.setFont(new Font("Verdana",Font.BOLD,15));
                                        l_lastname.setFont(new Font("Verdana",Font.BOLD,15));
                                        l_address.setFont(new Font("Verdana",Font.BOLD,15));
                                        l_mobile.setFont(new Font("Verdana",Font.BOLD,15));
                                        l_hostel.setFont(new Font("Verdana",Font.BOLD,15));
                                        l_email.setFont(new Font("Verdana",Font.BOLD,15));

                                        profile_frame.getContentPane().setBackground(Color.decode("#8a00e6"));
                                        profile_frame.add(mainlable);
                                        profile_frame.add(lid);
                                        profile_frame.add(l_firstname);
                                        profile_frame.add(l_lastname);
                                        profile_frame.add(l_address);
                                        profile_frame.add(l_mobile);
                                        profile_frame.add(l_hostel);
                                        profile_frame.add(l_email);
                                        profile_frame.setLayout(null);
                                        profile_frame.setSize(1000,600);
                                        profile_frame.setVisible(true);

                                    }else {
                                        JOptionPane.showMessageDialog(null,"Your profile not Found");
                                    }
                                }catch (Exception exception){
                                    exception.printStackTrace();
                                }
                            }
                        });


                        //New student registration
                        new_student.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame newstudent_frame;
                                newstudent_frame=new JFrame("New Student Registration");
                                Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sagar\\Desktop\\Logo.png");

                                JLabel id,room_no,name,mobile_number,email_address,collage,header,date,status;
                                JTextField tid,troom,tname,tmobile,temail,tcollage,tdate;
                                String list[]={"Select status","Not Booked","Booked"};
                                JComboBox cb=new JComboBox(list);
                                JButton register;


                                id=new JLabel("ID no :");
                                room_no=new JLabel("Room no :");
                                name=new JLabel("Name :");
                                mobile_number=new JLabel("Mobile :");
                                email_address=new JLabel("Email :");
                                collage=new JLabel("Collage :");
                                date=new JLabel("Joining Date :");
                                header=new JLabel("Student Registration");
                                status=new JLabel("Status :");

                                //textfields
                                tid=new JTextField();
                                troom=new JTextField();
                                tname=new JTextField();
                                tmobile=new JTextField();
                                temail=new JTextField();
                                tcollage=new JTextField();
                                tdate=new JTextField();

                                register=new JButton("Add");
                                register.setFont(new Font("Verdana",Font.BOLD,15));
                                register.setBackground(Color.BLACK);
                                register.setForeground(Color.white);

//setting labels
                                header.setBounds(420,60,500,30);
                                id.setBounds(200,150,100,30);
                                room_no.setBounds(200,200,100,30);
                                name.setBounds(200,250,100,30);
                                mobile_number.setBounds(600,150,100,30);
                                email_address.setBounds(600,200,100,30);
                                collage.setBounds(600,250,100,30);
                                date.setBounds(200,300,150,30);
                                status.setBounds(600,300,100,30);

                                //setting font size
                                id.setFont(new Font("Verdana",Font.BOLD,15));
                                room_no.setFont(new Font("Verdana",Font.BOLD,15));
                                name.setFont(new Font("Verdana",Font.BOLD,15));
                                date.setFont(new Font("Verdana",Font.BOLD,15));

                                mobile_number.setFont(new Font("Verdana",Font.BOLD,15));
                                email_address.setFont(new Font("Verdana",Font.BOLD,15));
                                collage.setFont(new Font("Verdana",Font.BOLD,15));
                                header.setFont(new Font("Verdana",Font.BOLD,25));
                                status.setFont(new Font("Verdana",Font.BOLD,15));



                                //setting up textfields
                                tid.setBounds(320,150,200,25);
                                troom.setBounds(320,200,200,25);
                                tname.setBounds(320,250,200,25);
                                tmobile.setBounds(700,150,200,25);
                                temail.setBounds(700,200,200,25);
                                tcollage.setBounds(700,250,200,25);
                                tdate.setBounds(320,300,200,25);
                                cb.setBounds(700,300,200,25);

                                //button
                                register.setBounds(430,420,200,35);
                                register.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String id=tid.getText();
                                        String room=troom.getText();
                                        String name=tname.getText();
                                        String mobile=tmobile.getText();
                                        int len=mobile.length();
                                        String date=tdate.getText();
                                        String email=temail.getText();
                                        String collage=tcollage.getText();
                                        String status= (String) cb.getItemAt(cb.getSelectedIndex());

                                        String warden_email=t2.getText();

                                        try{
                                            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                            Statement statement=connection.createStatement();
                                            String Query2="Select * from Newstudent_registration where stu_id='"+id+"' or mobile='"+mobile+"' or email='"+email+"'";
                                            ResultSet rs=statement.executeQuery(Query2);
                                            if (rs.next()){
                                                JOptionPane.showMessageDialog(null,"ID or Mobile number or Email already exist");
                                            }else {
                                                if (len == 10) {
                                                    String Query1 = "Insert into Newstudent_registration(warden_email,stu_id,room_no,name,mobile,joined_date,email,collage,status) values(?,?,?,?,?,?,?,?,?)";
                                                    PreparedStatement ps = connection.prepareStatement(Query1);
                                                    ps.setString(1,warden_email);
                                                    ps.setString(2, id);
                                                    ps.setString(3, room);
                                                    ps.setString(4, name);
                                                    ps.setString(5, mobile);
                                                    ps.setString(6, date);
                                                    ps.setString(7, email);
                                                    ps.setString(8, collage);
                                                    ps.setString(9, status);
                                                    ps.executeUpdate();
                                                    JOptionPane.showMessageDialog(null, "Student register successfully.");

                                                    tid.setText("");
                                                    troom.setText("");
                                                    tname.setText("");
                                                    tmobile.setText("");
                                                    tdate.setText("");
                                                    temail.setText("");
                                                    tcollage.setText("");
                                                    cb.setToolTipText("Select status");
                                                }else {
                                                    JOptionPane.showMessageDialog(register,"Enter valid Mobile number");
                                                }
                                            }

                                            connection.close();
                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });

                                newstudent_frame.getContentPane().setBackground(Color.decode("#006699"));
                                newstudent_frame.setIconImage(icon);
                                newstudent_frame.add(header);
                                newstudent_frame.add(id);
                                newstudent_frame.add(room_no);
                                newstudent_frame.add(mobile_number);
                                newstudent_frame.add(name);
                                newstudent_frame.add(collage);
                                newstudent_frame.add(email_address);
                                newstudent_frame.add(date);
                                newstudent_frame.add(tid);
                                newstudent_frame.add(troom);
                                newstudent_frame.add(tmobile);
                                newstudent_frame.add(tname);
                                newstudent_frame.add(temail);
                                newstudent_frame.add(tcollage);
                                newstudent_frame.add(tdate);
                                newstudent_frame.add(register);
                                newstudent_frame.add(status);
                                newstudent_frame.add(cb);
                                newstudent_frame.setSize(1000,600);
                                newstudent_frame.setLayout(null);
                                newstudent_frame.setVisible(true);

                            }
                        });

                        search_student.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame search_frame;
                                search_frame=new JFrame("Search Student");
                                Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sagar\\Desktop\\Logo.png");

                                JTextField tsearh;
                                JButton search;

                                tsearh=new JTextField();
                                search=new JButton("Search");

                                tsearh.setBounds(200,80,300,30);
                                search.setBounds(550,80,100,30);

                                //search button
                                search.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String searching_id=tsearh.getText();
                                        String warden_email_address=t2.getText();

                                        JFrame frame2=new JFrame("Student Details");
                                        frame2.setLayout(new FlowLayout());
                                        frame2.setSize(850,400);

                                        DefaultTableModel defaultTableModel=new DefaultTableModel();
                                        JTable table=new JTable(defaultTableModel);
                                        table.setPreferredScrollableViewportSize(new Dimension(800,300));
                                        table.setFillsViewportHeight(true);
                                        frame2.add(new JScrollPane(table));
                                        defaultTableModel.addColumn("ID No");
                                        defaultTableModel.addColumn("Room No");
                                        defaultTableModel.addColumn("Name");
                                        defaultTableModel.addColumn("Mobile No");
                                        defaultTableModel.addColumn("Joining Date");
                                        defaultTableModel.addColumn("Email");
                                        defaultTableModel.addColumn("Collage");
                                        defaultTableModel.addColumn("Status");


                                        try {
                                                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");

                                                Statement statement=connection.createStatement();
                                                String query = "Select * from Newstudent_registration where stu_id='" + searching_id + "' and warden_email='"+warden_email_address+"'";
                                                ResultSet resultSet = statement.executeQuery(query);


                                                if (resultSet.next()) {
                                                    String id = resultSet.getString("stu_id");
                                                    String room = resultSet.getString("room_no");
                                                    String name = resultSet.getString("name");
                                                    String mobile = resultSet.getString("mobile");
                                                    String date = resultSet.getString("joined_date");
                                                    String email = resultSet.getString("email");
                                                    String collage = resultSet.getString("collage");
                                                    String status = resultSet.getString("status");

                                                    if (searching_id.equalsIgnoreCase(id)) {
                                                        defaultTableModel.addRow(new Object[]{id, room, name, mobile, date, email, collage, status});
                                                        frame2.setVisible(true);
                                                        frame2.validate();
                                                    }

                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Student Not Found");
                                                }
                                                if (tsearh.getText().equals("")) {
                                                    JOptionPane.showMessageDialog(null, "Student Not Found");
                                                }
                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }

                                    }
                                });
                                search_frame.getContentPane().setBackground(Color.decode("#8A2BE2"));
                                search_frame.add(tsearh);
                                search_frame.add(search);
                                search_frame.setIconImage(icon);



                                search_frame.setLayout(null);
                                search_frame.setVisible(true);
                                search_frame.setSize(1000,600);

                            }
                        });

                        //***************************************************************************************************************************
                        // update and delete button on userhompage
                        update_delete.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame update_frame;
                                update_frame=new JFrame("Update and Delete");
                                Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sagar\\Desktop\\Logo.png");  //defining

                                JLabel id,room_no,name,mobile_number,email_address,collage,date,status;
                                JTextField tid,troom,tname,tmobile,temail,tcollage,tdate,tsearh;
                                JButton search;
//setting search position
                                tsearh=new JTextField();
                                search=new JButton("Search");

                                tsearh.setBounds(350,80,300,30);
                                search.setBounds(700,80,100,30);
                                search.setBackground(Color.MAGENTA);

                                String list[]={"Select status","Not Booked","Booked"};
                                JComboBox cb=new JComboBox(list);
                                JButton save,delete;

//defining labels
                                id=new JLabel("ID no :");
                                room_no=new JLabel("Room no :");
                                name=new JLabel("Name :");
                                mobile_number=new JLabel("Mobile :");
                                email_address=new JLabel("Email :");
                                collage=new JLabel("Collage :");
                                date=new JLabel("Joining Date :");
                                status=new JLabel("Status :");

                                //textfields
                                tid=new JTextField();
                                troom=new JTextField();
                                tname=new JTextField();
                                tmobile=new JTextField();
                                temail=new JTextField();
                                tcollage=new JTextField();
                                tdate=new JTextField();

                                save=new JButton("Save");
                                save.setFont(new Font("Verdana",Font.PLAIN,15));

                                delete=new JButton("Delete");
                                delete.setFont(new Font("Verdana",Font.PLAIN,15));

                                save.setBackground(Color.decode("#4d4dff"));
                                delete.setBackground(Color.decode("#4d4dff"));

//setting labels
                                id.setBounds(150,150,100,30);
                                room_no.setBounds(150,200,100,30);
                                name.setBounds(150,250,100,30);
                                mobile_number.setBounds(600,150,100,30);
                                email_address.setBounds(600,200,100,30);
                                collage.setBounds(600,250,100,30);
                                date.setBounds(150,300,150,30);
                                status.setBounds(600,300,100,30);

                                //setting font size
                                id.setFont(new Font("Verdana",Font.BOLD,15));
                                room_no.setFont(new Font("Verdana",Font.BOLD,15));
                                name.setFont(new Font("Verdana",Font.BOLD,15));
                                date.setFont(new Font("Verdana",Font.BOLD,15));

                                mobile_number.setFont(new Font("Verdana",Font.BOLD,15));
                                email_address.setFont(new Font("Verdana",Font.BOLD,15));
                                collage.setFont(new Font("Verdana",Font.BOLD,15));
                                status.setFont(new Font("Verdana",Font.BOLD,15));



                                //setting up textfields
                                tid.setBounds(270,150,200,25);
                                troom.setBounds(270,200,200,25);
                                tname.setBounds(270,250,200,25);
                                tmobile.setBounds(700,150,200,25);
                                temail.setBounds(700,200,200,25);
                                tcollage.setBounds(700,250,200,25);
                                tdate.setBounds(270,300,200,25);
                                cb.setBounds(700,300,200,25);


                                //search button in update frame
                                search.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        String getid=tsearh.getText();
                                        String update_frame_wardenEmail=t2.getText();

                                        try {
                                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "Pass@123");
                                            Statement statement = connection.createStatement();
                                            String query = "Select * from newstudent_registration where stu_id='" + getid + "' and warden_email='"+update_frame_wardenEmail+"'";
                                            ResultSet resultSet = statement.executeQuery(query);

                                            if (resultSet.next()) {
                                                String id = resultSet.getString("stu_id");
                                                String room = resultSet.getString("room_no");
                                                String name = resultSet.getString("name");
                                                String mobile = resultSet.getString("mobile");
                                                String date = resultSet.getString("joined_date");
                                                String email = resultSet.getString("email");
                                                String collage = resultSet.getString("collage");
                                                String status = resultSet.getString("status");
                                                if (getid.equals(id)) {
                                                    tid.setText(id);
                                                    tid.setEditable(false);
                                                    troom.setText(room);
                                                    tname.setText(name);
                                                    tname.setEditable(false);
                                                    tmobile.setText(mobile);
                                                    tdate.setText(date);
                                                    tdate.setEditable(false);
                                                    temail.setText(email);
                                                    temail.setEditable(false);
                                                    tcollage.setText(collage);

                                                }
                                            }else {
                                                JOptionPane.showMessageDialog(null,"Student not found");
                                            }
                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });

                                save.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String status= (String) cb.getItemAt(cb.getSelectedIndex());
                                        String id=tid.getText();
                                        try {
                                            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                            Statement statement= connection.createStatement();
                                            String query="update newstudent_registration set status='"+status+"' where stu_id='"+id+"'";
                                            statement.executeUpdate(query);
                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }

                                        JOptionPane.showMessageDialog(null,"Information saved successfully");
                                        tid.setText("");
                                        troom.setText("");
                                        tname.setText("");
                                        tmobile.setText("");
                                        tdate.setText("");
                                        temail.setText("");
                                        tcollage.setText("");
                                    }
                                });
                                //all updates buttons
                                JButton update_room,update_mobile,update_collage;
                                update_room=new JButton("update");
                                update_room.setBounds(480,200,100,25);
                                update_room.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String room=troom.getText();
                                        String id=tid.getText();
                                        try {
                                            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                            Statement statement=connection.createStatement();
                                            String update_query="update newstudent_registration set room_no='"+room+"' where stu_id='"+id+"'";
                                            statement.executeUpdate(update_query);
                                            JOptionPane.showMessageDialog(null,"Room successfully updated");
                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });

                                update_mobile=new JButton("update");
                                update_mobile.setBounds(910,150,100,25);
                                update_mobile.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String mobile=tmobile.getText();
                                        int len=mobile.length();
                                        String id=tid.getText();

                                        try{
                                            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                            Statement statement= connection.createStatement();
                                            String query="update newstudent_registration set mobile='"+mobile+"'where stu_id='"+id+"'";
                                            if (len != 10){
                                                JOptionPane.showMessageDialog(null,"Enter valid mobile number");
                                                tmobile.setText("");
                                            }else {
                                                statement.executeUpdate(query);
                                                JOptionPane.showMessageDialog(null,"Mobile successfully updated");
                                            }

                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });
                                update_collage=new JButton("update");
                                update_collage.setBounds(910,250,100,25);
                                update_collage.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String collage=tcollage.getText();
                                        String id=tid.getText();

                                        try{
                                            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                            Statement statement= connection.createStatement();
                                            String query="update newstudent_registration set collage='"+collage+"'where stu_id='"+id+"'";
                                            statement.executeUpdate(query);
                                            JOptionPane.showMessageDialog(null,"Mobile successfully updated");

                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });

                                //delete button
                                delete.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String d_id=tsearh.getText();
                                        int flag=1;
                                        try{
                                            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "Pass@123");
                                            Statement statement;
                                            statement=connection.createStatement();
                                            String query="Delete from newstudent_registration where stu_id='"+d_id+"'";
                                            statement.executeUpdate(query);
                                            JOptionPane.showMessageDialog(null,"Data deleted successfully");
                                            tid.setText("");
                                            troom.setText("");
                                            tname.setText("");
                                            tmobile.setText("");
                                            tdate.setText("");
                                            temail.setText("");
                                            tcollage.setText("");

                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });

                                //button
                                save.setBounds(430,400,150,35);
                                delete.setBounds(630,400,150,35);
                                update_frame.getContentPane().setBackground(Color.decode("#99004d"));
                                update_frame.setIconImage(icon);
                                update_frame.add(tsearh);
                                update_frame.add(search);
                                update_frame.add(id);
                                update_frame.add(room_no);
                                update_frame.add(mobile_number);
                                update_frame.add(name);
                                update_frame.add(collage);
                                update_frame.add(email_address);
                                update_frame.add(date);
                                update_frame.add(tid);
                                update_frame.add(troom);
                                update_frame.add(tmobile);
                                update_frame.add(tname);
                                update_frame.add(temail);
                                update_frame.add(tcollage);
                                update_frame.add(tdate);
                                update_frame.add(save);
                                update_frame.add(status);
                                update_frame.add(cb);

                                update_frame.add(delete);
                                update_frame.add(update_room);
                                update_frame.add(update_mobile);
                                update_frame.add(update_collage);
                                update_frame.setSize(1100,600);
                                update_frame.setLayout(null);
                                update_frame.setVisible(true);
                            }
                        });
                        //---------------------------end of update button------------------------------------------
                        //search rooms button on homepage
                        search_rooms.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame searchframe=new JFrame("Manage Rooms");

                                String search_warden_email=t2.getText();

                                DefaultTableModel defaultTableModel=new DefaultTableModel();
                                JTable table=new JTable(defaultTableModel);
                                table.setPreferredScrollableViewportSize(new Dimension(1000,700));
                                defaultTableModel.addColumn("ID");
                                defaultTableModel.addColumn("Room NO");
                                defaultTableModel.addColumn("Status");
                                try {
                                    Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                    Statement statement= connection1.createStatement();
                                    String query="Select stu_id,room_no,status from newstudent_registration where warden_email='"+search_warden_email+"'";
                                    ResultSet rs=statement.executeQuery(query);
                                    while (rs.next()) {
                                        String id = rs.getString("stu_id");
                                        String room = rs.getString("room_no");
                                        String status = rs.getString("status");
                                        defaultTableModel.addRow(new Object[]{id, room, status});
                                    }

                                }catch (Exception exception){
                                    exception.printStackTrace();
                                }

                                searchframe.add(new JScrollPane(table));
                                searchframe.setLayout(new FlowLayout());
                                searchframe.setSize(1100,800);
                                searchframe.setVisible(true);
                            }
                        });
                        //--------------------------end of search rooms button on homepage

                        //student fees button on homepage
                        student_fees.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame student_fees_frame;
                                student_fees_frame=new JFrame("Student Fees");
                                Image icon=Toolkit.getDefaultToolkit().getImage("C:\\Users\\Sagar\\Desktop\\Logo.png");  //defining

                                JLabel id,room_no,name,mobile_number,email_address,collage,date,enter_fee;
                                JTextField tid,troom,tname,tmobile,temail,tcollage,tdate,tsearh,tenter;
                                JButton search;
//setting search position
                                tsearh=new JTextField();
                                search=new JButton("Search");

                                tsearh.setBounds(350,80,300,30);
                                search.setBounds(660,80,100,30);
                                search.setBackground(Color.MAGENTA);

                                String list[]={"Select status","Not Booked","Booked"};
                                JComboBox cb=new JComboBox(list);
                                JButton save;

//defining labels
                                id=new JLabel("ID no :");
                                room_no=new JLabel("Room no :");
                                name=new JLabel("Name :");
                                mobile_number=new JLabel("Mobile :");
                                email_address=new JLabel("Email :");
                                collage=new JLabel("Collage :");
                                date=new JLabel("Joining Date :");
                                enter_fee =new JLabel("Enter Fee :");

                                //textfields
                                tid=new JTextField();
                                troom=new JTextField();
                                tname=new JTextField();
                                tmobile=new JTextField();
                                temail=new JTextField();
                                tcollage=new JTextField();
                                tdate=new JTextField();
                                tenter=new JTextField();

                                save=new JButton("Save");
                                save.setFont(new Font("Verdana",Font.BOLD,15));

//setting labels
                                id.setBounds(250,150,100,30);
                                room_no.setBounds(250,200,100,30);
                                name.setBounds(250,250,100,30);
                                mobile_number.setBounds(600,150,100,30);
                                email_address.setBounds(600,200,100,30);
                                collage.setBounds(600,250,100,30);
                                date.setBounds(250,300,150,30);
                                enter_fee.setBounds(600,300,100,30);

                                //setting font size
                                id.setFont(new Font("Verdana",Font.BOLD,15));
                                room_no.setFont(new Font("Verdana",Font.BOLD,15));
                                name.setFont(new Font("Verdana",Font.BOLD,15));
                                date.setFont(new Font("Verdana",Font.BOLD,15));

                                mobile_number.setFont(new Font("Verdana",Font.BOLD,15));
                                email_address.setFont(new Font("Verdana",Font.BOLD,15));
                                collage.setFont(new Font("Verdana",Font.BOLD,15));
                                enter_fee.setFont(new Font("Verdana",Font.BOLD,15));



                                //setting up textfields
                                tid.setBounds(370,150,200,25);
                                troom.setBounds(370,200,200,25);
                                tname.setBounds(370,250,200,25);
                                tmobile.setBounds(700,150,200,25);
                                temail.setBounds(700,200,200,25);
                                tcollage.setBounds(700,250,200,25);
                                tdate.setBounds(370,300,200,25);
                                tenter.setBounds(700,300,200,25);

                                save.setBounds(450,400,140,35);


                                search.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        String getid=tsearh.getText();
                                        String fees_warden_email=t2.getText();

                                        try {
                                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "Pass@123");
                                            Statement statement = connection.createStatement();
                                            String query = "Select * from newstudent_registration where stu_id='" + getid + "' and warden_email='"+fees_warden_email+"'";
                                            ResultSet resultSet = statement.executeQuery(query);

                                            if (resultSet.next()) {
                                                String id = resultSet.getString("stu_id");
                                                String room = resultSet.getString("room_no");
                                                String name = resultSet.getString("name");
                                                String mobile = resultSet.getString("mobile");
                                                String date = resultSet.getString("joined_date");
                                                String email = resultSet.getString("email");
                                                String collage = resultSet.getString("collage");
                                                String status = resultSet.getString("status");
                                                if (getid.equals(id)) {
                                                    tid.setText(id);
                                                    tid.setEditable(false);

                                                    troom.setText(room);
                                                    troom.setEditable(false);

                                                    tname.setText(name);
                                                    tname.setEditable(false);

                                                    tmobile.setText(mobile);
                                                    tmobile.setEditable(false);

                                                    tdate.setText(date);
                                                    tdate.setEditable(false);

                                                    temail.setText(email);
                                                    temail.setEditable(false);

                                                    tcollage.setText(collage);
                                                    tcollage.setEditable(false);
                                                    cb.addItem(status);
                                                }
                                            }else {
                                                JOptionPane.showMessageDialog(null,"Student not found");
                                            }
                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });

                                save.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String warden_email=t2.getText();
                                        String search=tsearh.getText();
                                        String s_id=tid.getText();
                                        String s_room=troom.getText();
                                        String s_name=tname.getText();
                                        String s_mobile=tmobile.getText();
                                        int len=s_mobile.length();
                                        String s_date=tdate.getText();
                                        String s_email=temail.getText();
                                        String s_collage=tcollage.getText();
                                        String s_fees=tenter.getText();
                                        int fees_len=s_fees.length();

                                        try {
                                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "Pass@123");
                                            if (fees_len > 6){
                                                JOptionPane.showMessageDialog(null,"Enter Fees Below 130000");
                                            }else if (tenter.equals("")){
                                                JOptionPane.showMessageDialog(null,"Enter some fees amount");
                                            }
                                            else {
                                                //simple check query remaining fees in database
                                                Statement statement1 = connection.createStatement();
                                                String simple_check_query = "select * from student_fees where stu_id='" + s_id + "'";
                                                ResultSet rs=statement1.executeQuery(simple_check_query);
                                                if (rs.next()){
                                                    JOptionPane.showMessageDialog(null,"You can only add first Installment here\n" +
                                                            "Visit UPDATE STUDENT FEES");
                                                }else {

                                                    String query1 = "Insert into student_fees(warden_email,stu_id,room_no,name,mobile,joined_date,email,collage,paid_fees)values(?,?,?,?,?,?,?,?,?)";
                                                    PreparedStatement ps = connection.prepareStatement(query1);
                                                    ps.setString(1, warden_email);
                                                    ps.setString(2, s_id);
                                                    ps.setString(3, s_room);
                                                    ps.setString(4, s_name);
                                                    ps.setString(5, s_mobile);
                                                    ps.setString(6, s_date);
                                                    ps.setString(7, s_email);
                                                    ps.setString(8, s_collage);
                                                    ps.setString(9, s_fees);
                                                    ps.executeUpdate();

                                                    Statement statements = connection.createStatement();
                                                    String update_remaining_fees = "Update student_fees set remaining_fees=total_fees -'"+s_fees+"' where stu_id='"+s_id+"'";
                                                    statements.executeUpdate(update_remaining_fees);

                                                    JOptionPane.showMessageDialog(null, "Fees added successfully");
                                                    tid.setText("");
                                                    troom.setText("");
                                                    tname.setText("");
                                                    tmobile.setText("");
                                                    tdate.setText("");
                                                    temail.setText("");
                                                    tcollage.setText("");
                                                    tenter.setText("");
                                                }


                                            }

                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }

                                    }
                                });


                                student_fees_frame.getContentPane().setBackground(Color.decode("#8A2BE2"));
                                student_fees_frame.setIconImage(icon);
                                student_fees_frame.add(tsearh);
                                student_fees_frame.add(search);
                                student_fees_frame.add(id);
                                student_fees_frame.add(room_no);
                                student_fees_frame.add(mobile_number);
                                student_fees_frame.add(name);
                                student_fees_frame.add(collage);
                                student_fees_frame.add(email_address);
                                student_fees_frame.add(date);
                                student_fees_frame.add(tid);
                                student_fees_frame.add(troom);
                                student_fees_frame.add(tmobile);
                                student_fees_frame.add(tname);
                                student_fees_frame.add(temail);
                                student_fees_frame.add(tcollage);
                                student_fees_frame.add(tdate);
                                student_fees_frame.add(enter_fee);
                                student_fees_frame.add(tenter);
                                student_fees_frame.add(save);
                                student_fees_frame.setSize(1000,600);
                                student_fees_frame.setLayout(null);
                                student_fees_frame.setVisible(true);
                            }
                        });
                        //--------------------------end of Student fees button on userhomepage-------------------------

                        //updatae students fees button on hompepagge;
                        fill_student_fees.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame update_stu_fees=new JFrame("Update Fees");
                                JTextField t_id,t_fees;
                                JLabel header,enter_id,enter_fees;
                                JButton add;

                                header=new JLabel("UPDATE STUDENT FEES HERE");
                                enter_id=new JLabel("Enter id :");
                                enter_fees=new JLabel("Enter Amount :");

                                t_id=new JTextField();
                                t_fees=new JTextField();
                                add=new JButton("Add");

                                header.setBounds(450,200,300,30);
                                header.setFont(new Font("Verdana",Font.PLAIN,16));
                                enter_id.setBounds(400,250,100,30);
                                enter_id.setFont(new Font("Verdana",Font.PLAIN,15));
                                enter_fees.setBounds(400,300,130,30);
                                enter_fees.setFont(new Font("Verdana",Font.PLAIN,15));

                                t_id.setBounds(530,250,200,25);
                                t_fees.setBounds(530,300,200,25);

                                add.setBounds(510,380,130,30);
                                add.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String getid=t_id.getText();
                                        String getfees=t_fees.getText();
                                        try {
                                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/hostel", "root", "Pass@123");

                                            Statement statement2= connection.createStatement();
                                            String simple_select_query="Select * from student_fees where stu_id='"+getid+"'";
                                            ResultSet rs=statement2.executeQuery(simple_select_query);
                                            if (rs.next()){
                                                String get_paid_fees=rs.getString("paid_fees"); //getting paid fees from database
                                                String get_total_fees=rs.getString("total_fees"); //getting total fees from database
                                                String get_remaining_fees=rs.getString("remaining_fees");

                                                if (get_paid_fees.equals(get_total_fees)){
                                                    JOptionPane.showMessageDialog(null,"Student paid full fees");
                                                    t_id.setText("");
                                                    t_fees.setText("");
                                                }else if (getfees.equals(get_remaining_fees)){
                                                    Statement statement3 = connection.createStatement();
                                                    String add_fees_query = "Update student_fees set paid_fees=paid_fees+'" + getfees + "' , remaining_fees=remaining_fees - '" + getfees + "' where stu_id='" + getid + "'";
                                                    statement3.executeUpdate(add_fees_query);
                                                    JOptionPane.showMessageDialog(null, "Fees added successfully");
                                                    t_id.setText("");
                                                    t_fees.setText("");
                                                }else {
                                                    JOptionPane.showMessageDialog(null,"Student remaining fees "+get_remaining_fees);
                                                }
                                            }else {
                                                JOptionPane.showMessageDialog(null,"Add first installment via Student Fees section");
                                                t_id.setText("");
                                                t_fees.setText("");
                                            }
                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });

                                update_stu_fees.add(header);
                                update_stu_fees.add(enter_id);
                                update_stu_fees.add(enter_fees);
                                update_stu_fees.add(t_id);
                                update_stu_fees.add(t_fees);
                                update_stu_fees.add(add);
                                update_stu_fees.setLayout(null);
                                update_stu_fees.setSize(1000,600);
                                update_stu_fees.setVisible(true);
                            }
                        });
                        // student fees details button on homepage
                        student_fees_details.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame fees_details_frame=new JFrame("Fees Details");
                                String getlogin_email=t2.getText();

                                DefaultTableModel defaultTableModel=new DefaultTableModel();
                                JTable table=new JTable(defaultTableModel);
                                table.setPreferredScrollableViewportSize(new Dimension(900,500));
                                defaultTableModel.addColumn("Student ID");
                                defaultTableModel.addColumn("Room No");
                                defaultTableModel.addColumn("Name");
                                defaultTableModel.addColumn("Mobile Number");
                                defaultTableModel.addColumn("Total Fees");
                                defaultTableModel.addColumn("Paid Fees");
                                defaultTableModel.addColumn("Remaining Fees");

                                try{
                                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                    Statement smt=conn.createStatement();
                                    String query="Select * from student_fees where warden_email='"+getlogin_email+"'";
                                    ResultSet rs=smt.executeQuery(query);
                                    while (rs.next()){
                                        String id_from_database=rs.getString("stu_id");
                                        String room_from_database=rs.getString("room_no");
                                        String name_from_database=rs.getString("name");
                                        String mobile_from_database=rs.getString("mobile");
                                        String total_fees=rs.getString("total_fees");
                                        String fees_from_database=rs.getString("paid_fees");
                                        String remaining_fees=rs.getString("remaining_fees");

                                        defaultTableModel.addRow(new Object[]{id_from_database,room_from_database,name_from_database,mobile_from_database,total_fees,fees_from_database,remaining_fees});
                                    }
                                }catch (Exception exception){
                                    exception.printStackTrace();
                                }
                                fees_details_frame.add(new JScrollPane(table));
                                fees_details_frame.setLayout(new FlowLayout());
                                fees_details_frame.setSize(1000,600);
                                fees_details_frame.setVisible(true);
                            }
                        });
                        //new employee button on homepage
                        new_employee.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame new_employee_frame;
                                new_employee_frame=new JFrame("New Employee");
                                JLabel header,name,mobile,hostel_name,salary;
                                JTextField t1,tmobiles,t3,t4;
                                JButton save;

                                save=new JButton("Save");

                                t1=new JTextField();
                                tmobiles=new JTextField();
                                t3=new JTextField();
                                t4=new JTextField();

                                header=new JLabel("New Employee");
                                name=new JLabel("Name :");
                                mobile=new JLabel("Mobile :");
                                hostel_name=new JLabel("Hostel :");
                                salary=new JLabel("Salary :");

                                header.setBounds(400,80,200,30);
                                name.setBounds(350,150,100,20);
                                mobile.setBounds(350,200,100,20);
                                hostel_name.setBounds(350,250,100,20);
                                salary.setBounds(350,300,100,20);

                                t1.setBounds(450,150,200,30);
                                tmobiles.setBounds(450,200,200,30);
                                t3.setBounds(450,250,200,30);
                                t4.setBounds(450,300,200,30);

                                save.setBounds(420,370,100,30);

                                header.setFont(new Font("Verdana",Font.BOLD,20));
                                name.setFont(new Font("Verdana",Font.BOLD,15));
                                mobile.setFont(new Font("Verdana",Font.BOLD,15));
                                hostel_name.setFont(new Font("Verdana",Font.BOLD,15));
                                salary.setFont(new Font("Verdana",Font.BOLD,15));
                                save.setFont(new Font("Verdana",Font.BOLD,15));


                                save.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String getlogin_email=t2.getText();

                                        String getname=t1.getText();
                                        String getmobile=tmobiles.getText();
                                        int len=getmobile.length();
                                        String gethostel=t3.getText();
                                        String getsalary=t4.getText();

                                        try {
                                            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                            Statement statement= connection.createStatement();
                                            String query2="select * from new_employee where mobile_no='"+getmobile+"'";
                                            ResultSet rs=statement.executeQuery(query2);
                                            if (rs.next()){
                                                JOptionPane.showMessageDialog(null,"Mobile number already exist");
                                            }else {
                                                if (len != 10) {
                                                    JOptionPane.showMessageDialog(null, "Enter valid Mobile Number");
                                                }else {
                                                    String query1 = "Insert into new_employee(warden_email,name,mobile_no,hostel_name,salary) values(?,?,?,?,?)";
                                                    PreparedStatement ps = connection.prepareStatement(query1);
                                                    ps.setString(1,getlogin_email);
                                                    ps.setString(2, getname);
                                                    ps.setString(3, getmobile);
                                                    ps.setString(4, gethostel);
                                                    ps.setString(5, getsalary);
                                                    ps.executeUpdate();
                                                    JOptionPane.showMessageDialog(null,"Data successfully Added");
                                                    t1.setText("");
                                                    tmobiles.setText("");
                                                    t3.setText("");
                                                    t4.setText("");
                                                    connection.close();
                                                }
                                            }

                                        }catch (Exception exception){
                                            exception.printStackTrace();
                                        }
                                    }
                                });



                                new_employee_frame.getContentPane().setBackground(Color.decode("#6600ff"));
                                new_employee_frame.add(header);
                                new_employee_frame.add(name);
                                new_employee_frame.add(mobile);
                                new_employee_frame.add(hostel_name);
                                new_employee_frame.add(salary);
                                new_employee_frame.add(t1);
                                new_employee_frame.add(tmobiles);
                                new_employee_frame.add(t3);
                                new_employee_frame.add(t4);
                                new_employee_frame.add(save);
                                new_employee_frame.setLayout(null);
                                new_employee_frame.setSize(1000,600);
                                new_employee_frame.setVisible(true);
                            }
                        });

                        employee_details.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame employee_details_frame=new JFrame("Employee Details");

                                String getloginemail=t2.getText();

                                DefaultTableModel defaultTableModel=new DefaultTableModel();
                                JTable table=new JTable(defaultTableModel);
                                table.setPreferredScrollableViewportSize(new Dimension(900,500));
                                defaultTableModel.addColumn("Employee Name");
                                defaultTableModel.addColumn("Mobile No");
                                defaultTableModel.addColumn("Hostel Name");
                                defaultTableModel.addColumn("Salary");

                                try {
                                    Connection connection1=DriverManager.getConnection("jdbc:mysql://localhost/hostel","root","Pass@123");
                                    Statement statement=connection1.createStatement();
                                    String query="Select * from new_employee where warden_email='"+getloginemail+"'";
                                    ResultSet rs= statement.executeQuery(query);
                                    while (rs.next()){
                                        String emp_name=rs.getString("name");
                                        String mobile=rs.getString("mobile_no");
                                        String hostel=rs.getString("hostel_name");
                                        String salary=rs.getString("Salary");

                                        defaultTableModel.addRow(new Object[]{emp_name,mobile,hostel,salary});
                                    }
                                }catch (Exception exception){
                                    exception.printStackTrace();
                                }

                                employee_details_frame.add(new JScrollPane(table));
                                employee_details_frame.setLayout(new FlowLayout());
                                employee_details_frame.setSize(1000,600);
                                employee_details_frame.setVisible(true);
                            }
                        });

                        //about button on userhomepage
                        about.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                new AboutPage();
                            }
                        });

                        //contact button on userhomepage
                        contact.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame contactpage_frame=new JFrame("Contact us");
                            }
                        });


                        uframe.setIconImage(icon);
                        uframe.add(background);
                        uframe.add(menu);
                        uframe.add(panel);
                        uframe.add(logout);
                        uframe.add(profile);
                        uframe.add(new_student);
                        uframe.add(search_student);
                        uframe.add(update_delete);
                        uframe.add(search_rooms);
                        uframe.add(new_employee);
                        uframe.add(student_fees);
                        uframe.add(fill_student_fees);
                        uframe.add(student_fees_details);
                        uframe.add(employee_details);
                        uframe.add(contact);
                        uframe.add(about);
                        uframe.setSize(1550,1200);
                        uframe.setLayout(null);
                        uframe.setVisible(true);

                    }else {
                        JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                    }

                }catch (Exception exception){
                    exception.printStackTrace();
                }
            }
        });


        login_Btn.setBounds(560,520,130,35);
        login_Btn.setBackground(Color.BLACK);
        login_Btn.setForeground(Color.white);

        register_btn.setBounds(740,520,130,35);
        register_btn.setBackground(Color.BLACK);
        register_btn.setForeground(Color.white);

        frame.setIconImage(icon);
        frame.add(l1);
        frame.add(l2);
        frame.add(l3);
        frame.add(t2);
        frame.add(p);
        frame.add(login_Btn);
        frame.add(register_btn);
        frame.add(background);
        frame.setSize(1550,1200);
        frame.setLayout(null);
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        new Login_Form();
    }
}
