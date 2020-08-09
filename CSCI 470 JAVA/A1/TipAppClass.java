import java.text.DecimalFormat;
import java.util.Scanner;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 1 - console porgram              *
 *                                                                  *
 *                                                                  *
 *  Class Name:  TipAppClass                                        *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program that tests TipCalculator.        *
 *                                                                  *
 ********************************************************************/

public class TipAppClass
{
  public static void main(String[] args)
  {
    calculateTips();
  }
  
  public static void calculateTips()
  {
    Scanner sc = new Scanner(System.in);
    DecimalFormat dollars = new DecimalFormat("$##,###,##0.00");
    TipCalculator bill1 = new TipCalculator();
    boolean flag = false;
    boolean flag2 = false;
    String end = " ";
    do
    {
     do
     {
      flag = false;
      System.out.print("Enter the bill amount: ");
      if(sc.hasNextDouble())
      {
        bill1.setBillAmount(sc.nextDouble());
        if(bill1.getBillAmount() > 0)
          flag = true;
        else
          System.out.println("\nError, please enter a valid bill amount\n");
      }
      else
      {
        System.out.println("\nError, please enter a valid bill amount\n");
        sc.nextLine();
      }
     }
     while(flag == false);
     flag = false;
     do{
       System.out.print("Enter the tip percentage: ");
       if(sc.hasNextInt())
       {
         bill1.setTipPercentage(sc.nextInt());
         if(bill1.getTipPercentage() >= 0)
           flag = true;
         else
           System.out.println("\nError, please enter a valid tip percentage\n");
       }
       else
       {
         System.out.println("\nError, please enter a valid tip percentage\n");
         sc.nextLine();
       }
     }
     while(flag == false);
     flag = false;
     do{
       System.out.print("Enter the party size");
       if(sc.hasNextInt())
       {
         bill1.setPartySize(sc.nextInt());
         if(bill1.getPartySize() > 0)
           flag = true;
         else
           System.out.println("\nError, please enter a valid party size\n");
       }
       else
       {
         System.out.println("\nError, please enter a valid party size\n");
         sc.nextLine();
       }
     }
     while(flag == false);
    
     System.out.println("*** Your Bill ***");
     System.out.print("\nBill Amount: ");
     System.out.printf("%s", dollars.format(bill1.getBillAmount()));
     System.out.print("\nTip Percentage: ");
     System.out.print(bill1.getTipPercentage() + "%");
     System.out.println("\nParty Size: " + bill1.getPartySize());
     System.out.print("\nTotal Bill (with Tip): ");
     System.out.printf("%s", dollars.format(bill1.getTotalBill()));
     System.out.print("\nShare for Each Individual: ");
     System.out.printf("%s", dollars.format(bill1.getIndividualShare()));
     flag = false;
     do
     {
      System.out.println("\nAnother Bill? (y/n): ");
      end = sc.next();
      switch(end)
      {
        case "n":
        case "N":
          flag2 = true;
          flag = true;
          break;
        case "y":
        case "Y":
          flag = true;
          break;
        default: 
          System.out.println("Invalid answer");
          break;
      }
     }
     while(flag = false);
    }
    while(flag2 == false);
    System.out.println("Goodbye!\n");
  }
}