/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.xml.parsers.ParserConfigurationException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *
 * @author Roman
 */
public class JavaApplication2 extends Frame implements ActionListener{
    private Label lbName;
    private TextField tfname;
    
    private Label lbCourse;
    private TextField tfCourse;
    private Label lbresult;
    private Label lbresultset;
    
    public JavaApplication2(){
        
        Frame frame = new Frame("AWT add student");
        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        
        frame.setVisible(true);
        frame.setSize(500, 500);
        
        
        lbName = new Label("Enter name:");
        frame.add(lbName);
        
        tfname = new TextField(40);
        add(tfname);
        tfname.addActionListener((ActionListener) this);
        
        lbCourse = new Label("Enter course:");
        add(lbCourse);
        
        tfCourse = new TextField(40);
        add(tfCourse);
        tfCourse.addActionListener((ActionListener) this);
        
        lbresult = new Label("Result");
        add(lbresult);
        
        lbresultset = new Label();
        add(lbresultset);
        
        
        
        
    }
    /**
     * @param args the command line arguments
     */
      @SuppressWarnings("empty-statement")
//    public label();
    public static void main(String[] args) throws ParserConfigurationException, IOException, ClassNotFoundException, SQLException{
//        lbName = new 
        new JavaApplication2();
        String url="jdbc:mysql://localhost:3306/book";
        String user="root";
        String pass="1234";       
        Class.forName("com.mysql.jdbc.Driver");
        try(Connection conn = DriverManager.getConnection(url, user, pass)){
            Statement st = conn.createStatement();
            int i = 0;
            System.out.println("we're connected");
            ResultSet rs = st.executeQuery("select * from student");
            ArrayList<String> al = new ArrayList<String>();
            ArrayList<String> al1 = new ArrayList<String>();
            ArrayList<String> al2 = new ArrayList<String>();
            
            while(rs.next()){
                al.add(rs.getString(3));
                al1.add(rs.getString(2));
                al2.add(rs.getString(1));
            }
            
            String[] names = new String[al.size()];
            String[] courses = new String[al1.size()];
            String[] ids = new String[al2.size()];
            names = al.toArray(names);
            for(String o : names){
                System.out.println(o);
            }
            System.out.println("\n");
            courses = al1.toArray(courses);
            for(String c : courses){
                System.out.println(c);
            }
            System.out.println("\n");
            ids = al2.toArray(ids);
            for(String k : ids){
                System.out.println(k);
            }
            System.out.println(names.length);
            String name = rs.getString(3);
            System.out.println(name);
        }catch(Exception sql){
        }
        // TODO code application logic here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = tfname.getText();
        String course = tfCourse.getText();
        tfname.setText("");
        tfCourse.setText("");
        lbresultset.setText("Name: " + name + ", course: " + course + "!!!");
    }
    
}
