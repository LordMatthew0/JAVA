import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.util.Comparator; 
/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 2 - Another Console Program      *
 *                                                                  *
 *                                                                  *
 *  Class Name:  MileRedeemer                                       *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program adds a worker class.             *
 *                                                                  *
 ********************************************************************/

public class MileRedeemer
{
  ArrayList<Destination> destList = new ArrayList<Destination>();
  
  private int milesRemaining;
  
  public void readDestinationInfo(Scanner fileScanner)
  {
    int counter = 0;
    String record;
    
    while(fileScanner.hasNext())
    {
      destList.add(counter, new Destination());
      record = fileScanner.nextLine();
      String[] splitData = record.split(";");
      String[] splitDate = splitData[4].split("-");
      
      destList.get(counter).setCityName(splitData[0]);
      destList.get(counter).setNormalMiles(Integer.parseInt(splitData[1]));
      destList.get(counter).setFrequentFlyerMiles(Integer.parseInt(splitData[2]));
      destList.get(counter).setUpgradeMiles(Integer.parseInt(splitData[3]));
      destList.get(counter).setStartMonth(Integer.parseInt(splitDate[0]));
      destList.get(counter).setEndMonth(Integer.parseInt(splitDate[1]));
      
      counter++;
      destList.sort(new MileageComparator());
      //Comparator.compare(destList, new MileageComparator());
      //MileageComparator(destList.get(counter).getNormalMiles());
    }
  }
  
  public String[] getDestinationNames()
  {
    String[] destinationList = new String[destList.size()];
    
    for(int i = 0; i < destList.size(); i++)
    {
      destinationList[i] = destList.get(i).getCityName(); 
    }
    
    Arrays.sort(destinationList);
    
    return destinationList;
  }
  
  public String[] redeemCustomerMiles(int miles, int month)
  {
   // ArrayList<String> output = new ArrayList<String>();
    String[] output = new String[destList.size()];
    ArrayList<Destination> temp = new ArrayList<Destination>();
    
    for(int i = 0; i < destList.size(); i++)
    {
      Destination d = destList.get(i);
      int cost = d.getNormalMiles();
      
      if(month >= d.getStartMonth() && month <= d.getEndMonth())
      {
       cost = d.getFrequentFlyerMiles(); 
      }
      
      if(miles > cost)
      {
       miles -= cost;
       temp.add(d);
      }
    }
    
    for(int i = 0; i < temp.size(); i++)
    {
     if(miles > temp.get(i).getUpgradeMiles()) 
     {
      miles -= temp.get(i).getUpgradeMiles();
      System.out.println(miles);
      output[i] = "* A trip to " + temp.get(i).getCityName() + " in First class";
     }
     else
     {
      output[i] = "* A trip to " + temp.get(i).getCityName() + " in Economy class";
     
     }
    }
    milesRemaining = miles;
    return output;
  }
  
  public int getLeftoverMiles()
  {
   return milesRemaining; 
  }
  
  public class MileageComparator implements Comparator<Destination> 
  {
   public int compare(Destination d1, Destination d2) 
   {
      return (d2.getNormalMiles() - d1.getNormalMiles());
   }
}

}