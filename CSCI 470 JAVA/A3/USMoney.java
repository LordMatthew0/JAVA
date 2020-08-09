import java.lang.Math;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 3 - Classes, Objects, and Methods*
 *                                                                  *
 *                                                                  *
 *  Class Name:  USMoney                                            *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program that sets up the USMoney class.  *
 *                                                                  *
 ********************************************************************/


public class USMoney
{
 private int dollars;
 private int cents;
 
 //The constructor 
 public USMoney(int dollar, int cent)
 {
  if(cent >= 0 && cent <= 99)
  {
    cents = cent;
    dollars = dollar;
  }
  else
  {
    double temp = Math.floor((double) cent / 100);
    dollars += dollar + temp;
    cents = cent % 100;
  }
 }
 
 //A method for adding 
 public USMoney plus(USMoney e) 
 {
   USMoney pls = new USMoney((dollars + e.getDollars()), (cents + e.getCents()));
   
   return pls;
 }
 
 //returns dollar amount
 public int getDollars() 
 {
  return dollars; 
 }
 
 //returns cent amount
 public int getCents() 
 {
  return cents; 
 }
}