/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 1 - console porgram              *
 *                                                                  *
 *                                                                  *
 *  Class Name:  TipCalculator                                      *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program that sets up the tip calculator. *
 *                                                                  *
 ********************************************************************/ 

public class TipCalculator
{
  private double billAmount = 0;
  private int tipPercentage = 20;
  private int partySize = 1;
  
  public TipCalculator()
  {
   
  }
  
  public double getBillAmount()
  {
    return billAmount; 
  }
  
  public void setBillAmount(double billAmount)
  {
    this.billAmount = billAmount;
  }
  
  public int getTipPercentage()
  {
    return tipPercentage; 
  }
  
  public void setTipPercentage(int tipPercentage)
  {
    this.tipPercentage = tipPercentage; 
  }
  
  public int getPartySize()
  {
    return partySize; 
  }
  
  public void setPartySize(int partySize)
  {
    this.partySize = partySize; 
  }
  
  public double getTotalBill()
  {
    double tip = (billAmount * (tipPercentage / 100.0));
    return  (billAmount + tip);
  }
  
  public double getIndividualShare()
  {
    double tip = (billAmount * (tipPercentage / 100.0));
    double bill = (billAmount + tip);
    return (bill / partySize);
  }
}