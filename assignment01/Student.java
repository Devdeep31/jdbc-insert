package assignment01;
import java.util.*;
import java.sql.*;

public class Student {
// table info
    //private int StdId;
    private int Roll_no;
    private String Name;
    private String Subject;
    private int Marks;

//Getters & Setters
    public void setRollno(int Roll_no){
        this.Roll_no = Roll_no;
    }

    public void setName(String Name){
        this.Name = Name;
    }

    public void setSubject(String Subject){
        this.Subject = Subject;
    }

    public void setMarks(int Marks){
        this.Marks = Marks;
    }

    //Getter
    public int getRollno(){
        return Roll_no;
    }

    public String getName(){
        return Name;
    }

    public String getSubject(){
        return Subject;
    }

    public int getMarks(){
        return Marks;
    }

    public void getInput(){
        Scanner scchar = new Scanner(System.in); //for String val
        Scanner scint = new Scanner(System.in); //for Int val


        System.out.println("Enter Student Roll no. : ");
        int rollnm = scint.nextInt();
        this.setRollno(rollnm);

        System.out.println("Enter Student Name : ");
        String name = scchar.nextLine();
        setName(name); 

        System.out.println("Enter Student Subject : ");
        String sub = scchar.nextLine();
        setSubject(sub); 

        System.out.println("Enter Student Marks : ");
        int marks = scint.nextInt();
        setMarks(marks);

    }

}


