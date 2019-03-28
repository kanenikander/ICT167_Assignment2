/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package assignment2;

import java.util.Scanner;

public class Date {
    Scanner scan = new Scanner(System.in);
    
    private int day;
    private int month;
    private int year;
    
    public Date()
    {
        day = 0;
        month = 0;
        year = 0;
    }
    
    public Date(int d, int m, int y)
    {
        day = d;
        month = m;
        year = y;
    }
    
    public void readDate()
    {
        String input;

        do 
        {
            System.out.print("Enter date of birth: ");
            input = scan.nextLine();

            if (checkInput(input,1,3) || checkInput(input,1,4) || checkInput(input,2,4) || checkInput(input,2,5)) //if format is valid
            {
                if(checkValidDate(day,month,year) == false) 
                    System.out.println("That date is invalid. Please enter a valid date.");
            }
            else
                System.out.println("Your input is invalid. Please enter date as 'DD/MM/YYYY'.");
        } while (checkValidDate(day,month,year) == false); //continue while date is invalid
    }
    
    public boolean checkInput(String input, int slash1, int slash2)  //checks validity of format based on positions of forward slash
    {
        if (input.length() >= 8)
        {
            if (input.charAt(slash1) == '/' && input.charAt(slash2) == '/' && input.length() == (slash2+5))
            {
                if (checkDataType(input.substring(0,slash1)) && checkDataType(input.substring((slash1+1),slash2)) && checkDataType(input.substring((slash2+1),(slash2+5))))
                {
                    day = Integer.parseInt(input.substring(0,slash1));
                    month = Integer.parseInt(input.substring((slash1+1),slash2));
                    year = Integer.parseInt(input.substring((slash2+1),(slash2+5)));
                    return true;
                }            
            }
        }
        return false;
    }
    
    public boolean checkDataType(String input) //checks if string can be converted to int
    {
        return (input.matches("[+-]?\\d+(\\.\\d+)?"));
    }
    
    public boolean checkValidDate(int d, int m, int y) //ensures inputted values make valid date
    {
        if (y >= 1600 && y < 2017) //student must be born (as of 2016) and not before year 1600
        {
            if (m == 2)
            {
                if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) 
                {
                    if (d > 0 && d <= 29) //allows up to 29th on a leap year (febuary)
                        return true;
                }
                else
                {
                    if (d > 0 && d <= 28) //allows up to 28th on a non-leap year (febuary)
                        return true;
                }
            }
            else if(m == 4 || m == 6 || m == 9 || m == 11) //months allowed up to 30th
            {
                if (d > 0 && d <= 30) 
                    return true;
            }
            else if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) //months allowed up to 31st
            {
                if (d > 0 && d <= 31)
                    return true;
            }
        }
        return false;
    }
    
    public String stringOutput() //to be called for simple output to user
    {
       return(day + "/" + month + "/" + year);
    }
    
    public boolean equalsDate(Date d)
    {
        return (this.day == d.day && this.month == d.month && this.year == d.year);
    }
    
    public void setDay(int d)
    {
        day = d;
    }
    
    public void setMonth(int m)
    {
        month = m;
    }
    
    public void setYear(int y)
    {
        year = y;
    }
       
    public int getDay()
    {
        return day;
    }
    
    public int getMonth()
    {
        return month;
    }
    
    public int getYear()
    {
        return year;
    }
    
}
