package assignment01;

import assignment01.Student;
import java.sql.*;

public class InsertData  {
    static String Con = "com.mysql.cj.jdbc.Driver";
    static String DB_Url = "jdbc:mysql://localhost:3306/School";
    static String DB_User = "root";
    static String DB_Pass = "root";



    public static void main(String[] args) {

        try{
            Class.forName(Con);
            Connection connection = DriverManager.getConnection(DB_Url, DB_User, DB_Pass);

            String Myquery = //"USE School;\n"
            //"CREATE DATABASE IF NOT EXISTS Students;\n"
            "CREATE TABLE IF NOT EXISTS Students(\n"
            +"id INT AUTO_INCREMENT PRIMARY KEY,\n"
            +"Roll_no int NOT NULL,\n"
            +"Name VARCHAR(50) NOT NULL,\n"
            +"Subject VARCHAR(50) NOT NULL,\n"
            +"Marks INT NOT NULL);";

            Statement stm = connection.createStatement();

            int result = stm.executeUpdate(
                Myquery
            );

    

            Student std = new Student(); 
            InsertData insdata = new InsertData();

            
            
            std.getInput();


            int input_Rollno = std.getRollno();
            String input_Name = std.getName();
            String input_Subject = std.getSubject();
            int input_Marks = std.getMarks();


            String insertQuery = "INSERT INTO Students (Roll_no, Name, Subject, Marks) VALUES (?, ?, ?, ?);";
            PreparedStatement pstmt = connection.prepareStatement(insertQuery);
            pstmt.setInt(1, input_Rollno);
            pstmt.setString(2, input_Name);
            pstmt.setString(3, input_Subject);
            pstmt.setInt(4, input_Marks);
            pstmt.executeUpdate();

            System.out.println("Data inserted successfully!");

            ResultSet rs = stm.executeQuery("select * from students");

                while (rs.next()){ 
                    System.out.println(
                        rs.getString(1)+"  "+ rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getInt(5)
                        );
                }

            stm.close();
            connection.close();

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

