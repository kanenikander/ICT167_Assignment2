/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment2;

import java.util.Scanner;

public class Student {
    
    Scanner scan = new Scanner(System.in);
    
    
    private String title;
    private String firstName;
    private String lastName;
    private long studentID;
    private Date dateOfBirth = new Date();
    private double assignment1;
    private double assignment2;
    private double practicalWork;
    private double exam;
    private double overallMark;
    private String finalGrade;
    
     
    Student ()
    {
        title = "";
        firstName = "";
        lastName = "";
        studentID = 0;
        dateOfBirth = new Date(0,0,0);
        assignment1 = -1;
        assignment2 = -1;
        practicalWork = -1;
        exam = -1;
        overallMark = -1;
        finalGrade = "NA";
    }
    
    Student(String t, String fn, String ln, long id, Date d, double a1, double a2, double pw, double e)
    {
        title = t;
        firstName = fn;
        lastName = ln;
        studentID = id;
        dateOfBirth = d;
        assignment1 = a1;
        assignment2 = a2;
        practicalWork = pw;
        exam = e;
        calcOverallMark();
    }
    
    public void readStudent() //TODO: check all input
    {
        title = readString("Enter title: ");
        firstName = readString("Enter first name: ");
        lastName = readString("Enter last name: ");
        studentID = readStudentID();
        dateOfBirth.readDate();
        assignment1 = readDouble("Enter mark for assignment 1: ","Mark of assignment 1 must be a number from 0 to 100.",0,100);
        assignment2 = readDouble("Enter mark for assignment 2: ","Mark of assignment 2 must be a number from 0 to 100.",0,100);
        practicalWork = readDouble("Enter mark for practical work: ","Mark of practical must be a number from 0 to 10.",0,10);
        exam = readDouble("Enter mark for exam: ","Mark of exam must be a number from 0 to 100.",0,100);
        calcOverallMark();
    }
    
    public String readString(String message)
    {
        System.out.print(message);
        String input = scan.nextLine();
        return input;
    }
    
    public double readDouble(String message, String error, int min, int max) //generic reader for double values
    {
        double input = -1;
        do
        {
            System.out.print(message);
            String test = scan.nextLine();
            if (checkDataType(test))
                input = Double.parseDouble(test);
            if (input < min || input > max)
                System.out.println(error);
        } while (input < min || input > max);
        return input;
    }
    
    public long readStudentID()
    {
        long input = 0;
        do
        {
            System.out.print("Enter student number: ");
            String test = scan.nextLine();
            if (checkDataType(test) && test.length() == 8) //input must be numeric and 8 long
                input = Integer.parseInt(test);
            if (input < 10000000 || input > 99999999)
                System.out.println("Student number must be a number of 8 digits and not begin with zero.");
        } while (input < 10000000 || input > 99999999); //ensures student number cannot begin with 0
        return input;
    }
    
    public boolean checkDataType(String input)
    {
        return (input.matches("[+-]?\\d+(\\.\\d+)?"));
    }
    
    public void calcOverallMark()
    {
        overallMark = (assignment1/5) + (assignment2/5) + practicalWork + (exam/2);
        calcFinalGrade();
    }
    
    public void calcFinalGrade()
    {
        if (getOverallMark() < 50)
            finalGrade = "N";
        else if (getOverallMark() < 60)
            finalGrade = "P";
        else if (getOverallMark() < 70)
            finalGrade = "C";
        else if (getOverallMark() < 80)
            finalGrade = "D";
        else
            finalGrade = "HD";
    }
    
    public void output(int record)
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("    Details of student record: " + (record + 1));
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("    " + title + " " + firstName + " " + lastName);
        System.out.format("%-21s%-7d%n", "    Student number: ", studentID);
        System.out.format("%-21s%-7s%n", "    Date of birth: ", dateOfBirth.stringOutput());
        System.out.format("%-21s%.2f%n", "    Assignment 1: ", assignment1);
        System.out.format("%-21s%.2f%n", "    Assignment 2: ", assignment2);
        System.out.format("%-21s%.2f%n", "    Practical work: ", practicalWork);
        System.out.format("%-21s%.2f%n", "    Exam: ", exam);
        System.out.format("%-21s%.2f%n", "    Overall Mark: ", overallMark);
        System.out.format("%-21s%-7s%n", "    Final grade: ", finalGrade);
        System.out.println("-----------------------------------------------------------------------------------\n");
    }
    
    public boolean equalsStudent(Student s)
    {
        return(this.firstName.equals(s.firstName) && this.lastName.equals(s.lastName) && this.dateOfBirth.equalsDate(s.dateOfBirth) && this.studentID == s.studentID);
    }
    
    public boolean checkAllMarksAdded() //checks that all marks have been added with appropriate values
    {
        return (assignment1 >= 0 && assignment1 <= 100 && assignment2 >= 0 && assignment2 <= 100 && practicalWork >= 0 && practicalWork <= 10 && exam >= 0 && exam <= 100);
    }
    
    public void setTitle(String t)
    {
        title = t;
    }
    
    public void setFirstName(String fn)
    {
        firstName = fn;
    }
    
    public void setLastName(String ln)
    {
        lastName = ln;
    }
    
    public void setStudentID(long id)
    {
        studentID = id;
    }
    
    public void setDate(Date dob)
    {
        dateOfBirth = dob;
    }
    
    public void setAssignment1(double a1)
    {
        assignment1 = a1;
        if (checkAllMarksAdded())
            calcOverallMark();
    }
    
    public void setAssignment2(double a2)
    {
        assignment2 = a2;
        if (checkAllMarksAdded())
            calcOverallMark();
    }
    
    public void setPracticalWork(double pw)
    {
        practicalWork = pw;
        if (checkAllMarksAdded())
            calcOverallMark();
    }
    
    public void setExam(double e)
    {
        exam = e;
        if (checkAllMarksAdded())
            calcOverallMark();
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getFirstName()
    {
        return firstName;
    }
    
    public String getLastName()
    {
        return lastName;
    }

    public long getStudentID()
    {
        return studentID;
    }
    
    public Date getDate()
    {
        return dateOfBirth;
    }
    
    public double getAssignment1()
    {
        return assignment1;
    }
    
    public double getAssignment2()
    {
        return assignment2;
    }
    
    public double getPracticalWork()
    {
        return practicalWork;
    }
    
    public double getExam()
    {
        return exam;
    }
    
    public double getOverallMark()
    {
        return overallMark;
    }
     
    public String getFinalGrade()
    {
        return finalGrade;
    }
    
}
