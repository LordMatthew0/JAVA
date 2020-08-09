import java.util.Scanner;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 3 - Classes, Objects, and Methods*
 *                                                                  *
 *                                                                  *
 *  Class Name:  USMoneyDemo                                        *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program that tests the USMoney class.    *
 *                                                                  *
 ********************************************************************/


public class USMoneyDemo
{
 public static void main(String[] args)
 {
   int dollar, cent; // for storing the input 
   Scanner sc = new Scanner(System.in);
   
   System.out.print("Enter dollar amount: ");
   dollar = sc.nextInt();
   System.out.print("\nEnter cent amount: ");
   cent = sc.nextInt();
   USMoney x = new USMoney(dollar, cent);
   sc.nextLine();
   
   
   System.out.print("\nEnter dollar amount: ");
   dollar = sc.nextInt();
   System.out.print("\nEnter cent amount: ");
   cent = sc.nextInt();
   USMoney y = new USMoney(dollar, cent);
   
   //print out the values
   System.out.println("x dollars: " + x.getDollars());
   System.out.println("x cents: " + x.getCents());
   System.out.println("y dollars: " + y.getDollars());
   System.out.println("y cents: " + y.getCents());
   
   
   
   // used for testing USMoney plus() 
   USMoney xPlusY = x.plus(y);
   System.out.print("X plus Y is  $" + xPlusY.getDollars() + "." + xPlusY.getCents()); 
 }
}