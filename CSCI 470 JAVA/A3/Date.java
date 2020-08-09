/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 3 - Classes, Objects, and Methods*
 *                                                                  *
 *                                                                  *
 *  Class Name:  Date                                               *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program that sets up the Date class.     *
 *                                                                  *
 ********************************************************************/


public class Date
{
  //create instince variables
 private int day, month, year;
 
 //constructor
 Date(int day, int month, int year) 
 {
  this.day = day;
  this.month = month;
  this.year = year;
 }
 
 //returns the days since jan 1st
 public int daysSinceJan1() 
 {
   //temp var to add to 
  int daysSoFar = 0;
  
  //go through the months and add how many days are in that month
  switch(month) 
  {
    case 1:
      daysSoFar = day;
      break;
    case 2:
      daysSoFar = day + 31;
      break;
    case 3:
      daysSoFar = day + 59;
      break;
    case 4:
      daysSoFar = day + 90;
      break;
    case 5:
      daysSoFar = day + 120;
      break;
    case 6:
      daysSoFar = day + 151;
      break; 
    case 7:
      daysSoFar = day + 181;
      break;
    case 8:
      daysSoFar = day + 212;
      break;
    case 9:
      daysSoFar = day + 243;
      break;
    case 10:
      daysSoFar = day + 273;
      break;
    case 11:
      daysSoFar = day + 304;
      break;
    case 12:
      daysSoFar = day + 334;
      break;
   }
    
  //for calculating leap years
  if ((year % 4) == 0 && ((year % 100) == (year % 400)))
    daysSoFar++;
    
  return daysSoFar;
 }
}