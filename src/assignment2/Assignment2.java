/*
Title: STUDENT INFORMATION
Author: Kane Nikander
Date: 14/09/2016
File name: Assignment1_Q1
Purpose: Continually takes in data of people in relation to a show. It records the peoples age,
gender and whether they are a regular viewer and continues taking in peoples details unit the 
user does not want to enter anymore details. It then prints out a table detailing the statistics
people who are regular viewers.
Assumptions:
1. Users will not be able to edit information they have entered. Once entered that information cannot be changed.
2. Users cannot stop entering information on a person once they have typed their age. They are then expected to enter that person gender and whether they are regular viewers.
 */

package assignment2;

import java.util.Scanner;

public class Assignment2 {

    static Scanner scan = new Scanner(System.in);
    
    public static void main(String[] args) {
        int count = 0;
        String input;
        int max = 0;
        
        studentInfo();

        //gets initial value for student array from user//
        do
        {
            System.out.print("Enter number of student records to create: ");
            input = scan.nextLine();
            System.out.println();
            if (checkDataType(input)) //test if input can be integer
            {
                max = Integer.parseInt(input); //makes nput integer
                if (max < 7)
                    System.out.println("You must have at least seven records.\n");
            }
            else
                System.out.println("You must enter a numeric value.\n");     
        } while (max < 7);
        Student[] student = new Student[max]; //initialise array of student type
        
        //sets initial values for 6 students//
        //-----------------------------------------------------------------//
        Date[] date = new Date[max];
        
        date[0] = new Date(13,1,1993);
        student[0] = new Student("Mr","Kane","Nikander",31566009,date[0],100,75,7,100);
        
        date[1] = new Date(30,11,1993);
        student[1] = new Student("Ms","Hannah","Lotti",31563305,date[1],50,65,5,60);
        
        date[2] = new Date(5,1,1995);
        student[2] = new Student("Mr","Jake","marcus",31428009,date[2],100,100,10,100);
        
        date[3] = new Date(7,6,1961);
        student[3] = new Student("Mrs","Tasma","richards",18935527,date[3],63,56,7,70);
        
        date[4] = new Date(12,7,1881);
        student[4] = new Student("Prof","Albus","Dumbledore",99999999,date[4],100,100,10,100);
        
        date[5] = new Date(1,3,1922);
        student[5] = new Student("Mr","severus","snape",91257813,date[5],100,100,10,80);
        
        count = 6; //sets count to accomodate number of initial students 
        //-----------------------------------------------------------------//
   
        //enters main program//
        do
        {
            outputInstructions();
            System.out.print("Enter one of the above numbers to perform its operation: ");
            input = scan.nextLine();
            System.out.println();
            
            //runs method based on input or returns invalid selection message//
            if (input.equals("2"))
                count = method2(student,count,max);
            else if (input.equals("3"))
                method3(student,count);
            else if (input.equals("4"))
                method4(student,count);
            else if (input.equals("5"))
                method5(student,count);
            else if (input.equals("6"))
                method6(student,count);
            else if (input.equals("7"))
                method7(student,count);
            else if (input.equals("8"))
                method8(student,count);
            else if (input.equals("9"))
                method9(student,count);
            else if (input.equals("10"))
                method10(student,count);
            else if (input.equals("11"))
                method11(student,count);
            else if (input.equals("12"))
                method12(student,count);
            else if(input.equals("1") == false)
                System.out.println("You have not made a valid selection.\n");
        } while (input.equals("1") == false);  
    }
    
    static void studentInfo() {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "Student Information");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.format("%-40s%-20s%n", "    Name:", "Kane Nikander");
        System.out.format("%-40s%-20s%n", "    Student Number:", "31566009");
        System.out.format("%-40s%-20s%n", "    Mode of Enrolment:", "Internal");
        System.out.format("%-40s%-20s%n", "    Tutor Name:", "Mark");
        System.out.format("%-40s%-20s%n", "    Tutorial Attendence Day and Time:", "Wednesday, 10:30am");
        System.out.println("-----------------------------------------------------------------------------------\n");
    }
    
    static void outputInstructions()
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "Menu");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("    1. Quit the program.");
        System.out.println("    2. Add student information.");
        System.out.println("    3. Output all details on all current students.");
        System.out.println("    4. Output average overall mark of all students.");
        System.out.println("    5. Display how many students obtained an overall mark equal to or above the\n       average and below the average.");
        System.out.println("    6. Display the distribution of grades.");
        System.out.println("    7. Search for student details via student number.");
        System.out.println("    8. Search for student details via student's name.");
        System.out.println("    9. Find the students with the highest and second highest overall mark.");
        System.out.println("    10. Sort students into ascending order of student numbers.");
        System.out.println("    11. Sort students into ascending order of students' surnames.");
        System.out.println("    12. Calculate and display the standard deviation of the set of overall marks.");
        System.out.println("-----------------------------------------------------------------------------------\n");
    }
    
    static int method2(Student[] student, int count, int num) //read in student information
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "2. Add student information.");
        System.out.println("-----------------------------------------------------------------------------------\n");
        
        if (count<num) //can be added to until array reaches maximum record (inputted first by user)
        {
            student[count] = new Student();
            student[count].readStudent();    
            System.out.println();
            count++; //updates counter of written student records
        }
        else
            System.out.println("    You have added all " + num + " students.\n");
        return count;
    }
    
    static void method3(Student[] student, int count) //outputs details of all added students
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "3. Output all details on all current students.");
        System.out.println("-----------------------------------------------------------------------------------\n");
        if (count == 0)
            System.out.println("    There are currently no students recorded.\n");
        for (int i = 0; i < count; i++)
            student[i].output(i);
    }
    
    static void method4(Student[] student, int count) //outputs average mark of all students
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "4. Output average overall mark of all students.");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.format("%s%.3f%s%n","    The average overall mark of all students is ",getAverage(student,count),".");
        System.out.println("-----------------------------------------------------------------------------------\n");
    }
    
    static double getStandardDeviation(Student[] student, int count) //calculates standard deviation of all overall marks
    {
        double sum = 0;
        
        for (int i = 0; i < count; i++)
            sum = sum + Math.pow(student[i].getOverallMark() - getAverage(student,count), 2);    

        return (Math.sqrt(sum/(count-1)));
    }
    
    static double getAverage(Student[] student, int count) //calculates average overall mark of all students
    {
        return (getSum(student,count)/count);
    }
    
    static double getSum(Student[] student, int count) //calculates sum of overall marks of all students
    {
        double sum = 0;
        
        for (int i = 0; i < count; i++)
            sum = sum + student[i].getOverallMark();

        return sum;
    }
    
    static void method5(Student[] student, int count) //display numbers students who acheived above and below average mark
    {
        int belowAvg = 0;
        
        //counts number of students below average mark//
        for (int i = 0; i < count; i++)
        {
            if (student[i].getOverallMark() < getAverage(student,count))
                belowAvg++;
        }
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "5. Display how many students obtained an overall mark equal to or above the average\n" + "\033[0;1m" + "   and below the average.");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("    Number of students who achieved equal to or above average: " + (count-belowAvg));
        System.out.println("    Number of students who achieved below average: " + belowAvg);
        System.out.println("-----------------------------------------------------------------------------------\n");
    }
    
    static void method6(Student[] student, int count) //calculate and display the total of students achieving each grade
    {
        int HD = 0;
        int D = 0;
        int C = 0;
        int P = 0;
        int N = 0;
        
        //determine and keep count of grade achived by each student//
        for (int i = 0; i < count; i++)
        {
            switch (student[i].getFinalGrade())
            {
                case "HD":
                    HD++;
                    break;
                case "D":
                    D++;
                    break;
                case "C":
                    C++;
                    break;
                case "P":
                    P++;
                    break;
                case "N":
                    N++;
                    break;        
            }
        }
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "6. Display the distribution of grades.");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.format("%-10s%-3d%n", "    HD:", HD);
        System.out.format("%-10s%-3d%n", "    D:", D);
        System.out.format("%-10s%-3d%n", "    C:", C);
        System.out.format("%-10s%-3d%n", "    P:", P);
        System.out.format("%-10s%-3d%n", "    N:", N);
        System.out.println("-----------------------------------------------------------------------------------\n");
        
    }
    
    static void method7(Student[] student, int count) //search for and output student details with student number
    {
        boolean exists = false;
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "7. Search for student details via student number.");
        System.out.println("-----------------------------------------------------------------------------------\n");
        
        System.out.print("Enter student number: ");
        String input = scan.nextLine();
        System.out.println();
        
        for (int i = 0; i < count; i++)
        {
            if(input.equals(Long.toString(student[i].getStudentID())))
            {
                student[i].output(i); //print out any records of student with matching student number
                exists = true; //mark student as existing in records
            }
        }
        if (exists == false)
            System.out.println("There is no record of a student with this student number.\n");
    }
    
    static void method8(Student[] student, int count) //search for and output student details with students full name
    {
        boolean exists = false;
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "8. Search for student details via student's name.");
        System.out.println("-----------------------------------------------------------------------------------\n");
        
        System.out.print("Enter students first name: ");
        String firstName = scan.nextLine();
        System.out.print("Enter students last name: ");
        String lastName = scan.nextLine();
        System.out.println();
        
        for (int i = 0; i < count; i++)
        {
            if(firstName.equalsIgnoreCase(student[i].getFirstName()) && lastName.equalsIgnoreCase(student[i].getLastName()))
            {
                student[i].output(i); //print out any records of student with matching name
                exists = true; //mark student as existing in records
            }
        }
        if (exists == false)
            System.out.println("There is no record of a student with this name.\n");
    }
    
    static void method9(Student[] student, int count)
    {
        Student tem;
        Student[] temp = new Student[count];
        
        //initialise a copy of student array so changes are not made to original array//
        for(int i = 0; i < count; i++) 
        {
            temp[i] = new Student();
            temp[i] = student[i];
        }
        
        //sorts copy array by ascending order of marks//
        for (int i = 0; i < count; i++)
        {
            for (int j = i+1; j < count; j++)
            {
                if (temp[i].getOverallMark() > temp[j].getOverallMark())
                {
                    tem = temp[i];
                    temp[i] = temp[j];
                    temp[j] = tem;
                }
            }
        }
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "9. Find the students with the highest and second highest overall mark.");
        System.out.println("-----------------------------------------------------------------------------------");
        
        int second = 0; 
        //checks for and prints highest mark//
        for (int i = (count-1); i >= 0; i--)
        {
            if (temp[i].getOverallMark() == temp[count-1].getOverallMark())
            {
                System.out.format("%s%s%s%s%s%.2f%s%n","    ",temp[i].getFirstName()," ",temp[i].getLastName()," got the highest overall mark of ",temp[i].getOverallMark(),".");
                second = i - 1; //indicates where to start searching for second highest mark
            }
        }
        
        //checks for and prints second highest mark//
        for (int i = second; i >= 0; i--)
        {
            if (temp[i].getOverallMark() == temp[second].getOverallMark())
            {
                System.out.format("%s%s%s%s%s%.2f%s%n","    ",temp[i].getFirstName()," ",temp[i].getLastName()," got the second highest overall mark of ",temp[i].getOverallMark(),".");
            }
        }
        System.out.println("-----------------------------------------------------------------------------------\n");
    }
    
    static void method10(Student[] student, int count)
    {
        //sorts student array by student number in ascending order//
        for (int i = 1; i < count; i++)
        {
            Student temp = student[i];
            int j;
            for (j = i - 1; j >= 0 && temp.getStudentID() < student[j].getStudentID(); j--)
                student[j+1] = student[j];
            student[j+1] = temp;
        }
        
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "10. Sort students into ascending order of student numbers.");
        System.out.println("-----------------------------------------------------------------------------------\n");
        for (int i = 0; i < count; i++)
            student[i].output(i); //outputs each instance of newly sorted array
    }
    
    static void method11(Student[] student, int count) //sorts student array by last name (ignoring case) in ascending order
    {
        Student temp;
        
        //sorts student array by last name (ignoring case) in ascending order//
        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count; j++)
            {
                if (student[i].getLastName().compareToIgnoreCase(student[j].getLastName()) > 0)
                {
                    temp = student[i];
                    student[i] = student[j];
                    student[j] = temp;
                }
            }
        }
        
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "11. Sort students into ascending order of students' surnames.");
        System.out.println("-----------------------------------------------------------------------------------\n");
        for (int i = 0; i < count; i++)
            student[i].output(i); //outputs each instance of newly sorted array
    }
    
    static void method12(Student[] student, int count) //outputs the standard deviation
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("\033[0;1m" + "12. Calculate and display the standard deviation of the set of overall marks.");
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.format("%s%.3f%n","    The standard deviation of all the overall marks is ",getStandardDeviation(student,count));
        System.out.println("-----------------------------------------------------------------------------------\n");
    }
    
    public void checkEquals(Student[] student, int num) //TODO: probs delete later
    {
        for (int i = 0; i < num; i++)
        {
            for(int j = (i+1); j < num; j++)
            {
                if (student[i].equals(student[j]))
                System.out.println("Student " + (i+1) + " is the same as " + (j+1) + ".");
            }
        }
    }
    
    static boolean checkDataType(String input) //checks if string can be converted to int
    {
        return (input.matches("[+-]?\\d+(\\.\\d+)?"));
    }
}
