import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 2 - Another Console Program      *
 *                                                                  *
 *                                                                  *
 *  Class Name:  MileRedemptionApp                                  *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program drives the program.              *
 *                                                                  *
 ********************************************************************/

public class MileRedemptionApp
{
  public static void main(String[] args)
  {
    String fileName;
    Scanner keyScan = new Scanner(System.in);
    MileRedeemer service = new MileRedeemer();
    
    System.out.print("Please enter the name of your file: ");
    fileName = keyScan.nextLine();
    
    try
    {
    Scanner fileScan = new Scanner(new File(fileName)); 
    service.readDestinationInfo(fileScan); 
    }
    catch(FileNotFoundException e)
    {
      
    }
    
    System.out.println("----------------------------------------------------------------");
    System.out.println("WELCOME TO THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("----------------------------------------------------------------");
    System.out.println("\nList of destination cities your client can travel to:\n");
    String[] cityNames = service.getDestinationNames();
    for(int i = 0; i < cityNames.length; i++)
    {
     System.out.println(cityNames[i]); 
    }
    System.out.println("\n----------------------------------------------------------------\n");
    
    int frequentFlyerMiles, monthOfDeparture;
    boolean endFlag = false; 
    String endString;
    do
    {
     System.out.print("\nPlease enter your client's accumulated Frequent Flyer Miles: ");
     frequentFlyerMiles = keyScan.nextInt();
     System.out.print("\nPlease enter your client's month of departure (1-12): ");
     monthOfDeparture = keyScan.nextInt();
    
     String[] visitNames = service.redeemCustomerMiles(frequentFlyerMiles, monthOfDeparture);
     if(visitNames[0] == null)
       System.out.println("\n*** Your client has not accumulated enough Frequent Flyer Miles ***");
     else
     {
      System.out.println("\nYour client's Frequent Flyer Miles can be used to redeem the following tickets:");
      
      for(int j = 0; j < visitNames.length; j++)
      {
       if(visitNames[j] != null)
         System.out.println(visitNames[j]); 
      }
     }
     System.out.println("\nYour client's remaining Frequent Flyer Miles: " + service.getLeftoverMiles());
     
     System.out.print("\nDo you want to continue (y/n)? ");
     keyScan.nextLine();
     endString = keyScan.nextLine();
     switch(endString)
     {
      case "n":
      case "N":
      case "No":
      case "no":
        endFlag = true;
        break;
      case "y":
      case "Y":
      case "Yes":
      case "yes":
        break;
      default: 
        System.out.println("Invalid answer");
        break;
      }
    }
    while(endFlag == false);
    System.out.println("-------------------------------------------------------------------------");
    System.out.println("THANK YOU FOR USING THE JAVA AIRLINES FREQUENT FLYER MILES REDEMPTION APP");
    System.out.println("-------------------------------------------------------------------------");
    keyScan.close();
  }
}