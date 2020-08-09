/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 4 - Tip Calculator               *
 *                                                                  *
 *                                                                  *
 *  Class Name:  TipCalculator                                      *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A program that sets up the tip calculator class.   *
 *                                                                  *
 ********************************************************************/ 

public class TipCalculator
{
  private double billAmount = 0;
  private int tipPercentage = 20;
  private int partySize = 1;
  
  public TipCalculator()
  {
    billAmount = 0;
    tipPercentage = 20;
    partySize = 1;
  }
  
  public void setBillAmount(double billAmount)
  {
    this.billAmount = billAmount;
  }
  
  public void setTipPercentage(int tipPercentage)
  {
    this.tipPercentage = tipPercentage; 
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