import java.util.Scanner;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 3 - Classes, Objects, and Methods*
 *                                                                  *
 *                                                                  *
 *  Class Name:  DateDemo                                           *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program that tests the Date class.       *
 *                                                                  *
 ********************************************************************/


public class DateDemo
{
 public static void main(String[] args)
 {
  Scanner sc = new Scanner(System.in);
  int day, month, year;
  
  //gets and saves the input for day
  System.out.println("Enter a day: ");
  day = sc.nextInt();
  
  //gets and saves the input for month
  System.out.println("Enter a month: ");
  month = sc.nextInt();
  
  //gets and saves the input for year
  System.out.println("Enter a year: ");
  year = sc.nextInt();
  
  Date test = new Date(day, month, year);
  
  //print the days since jan 1
  System.out.printf("%d days have past since January 1st\n", test.daysSinceJan1());
 }
}