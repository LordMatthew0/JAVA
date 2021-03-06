/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 2 - Another Console Program      *
 *                                                                  *
 *                                                                  *
 *  Class Name:  Destination                                        *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A console program that declares                    *
 *               the destination class.                             *
 *                                                                  *
 ********************************************************************/

public class Destination
{
  private String cityName;
  private int normalMiles;
  private int frequentFlyerMiles;
  private int upgradeMiles;
  private int startMonth;
  private int endMonth;

 public Destination(String cityName, int normalMiles, int frequentFlyerMiles, int upgradeMiles, int startMonth, int endMonth)
 {
   this.cityName = cityName;
   this.normalMiles = normalMiles;
   this.frequentFlyerMiles = frequentFlyerMiles;
   this.upgradeMiles = upgradeMiles;
   this.startMonth = startMonth;
   this.endMonth = endMonth;
 }
 
 public Destination()
 {
   this.cityName = " ";
   this.normalMiles = 1;
   this.frequentFlyerMiles = 1;
   this.upgradeMiles = 1;
   this.startMonth = 1;
   this.endMonth = 1;
 }
 
 public String getCityName()
 {
  return cityName; 
 }
 
 public int getNormalMiles()
 {
  return normalMiles; 
 }
 
 public int getFrequentFlyerMiles()
 {
  return frequentFlyerMiles; 
 }
 
 public int getUpgradeMiles()
 {
  return upgradeMiles; 
 }
 
 public int getStartMonth()
 {
  return startMonth; 
 }
 
 public int getEndMonth()
 {
  return endMonth; 
 }
 
 public void setCityName(String cityName)
 {
  this.cityName = cityName; 
 }
 
 public void setNormalMiles(int normalMiles)
 {
  this.normalMiles = normalMiles;
 }
 
 public void setFrequentFlyerMiles(int frequentFlyerMiles)
 {
  this.frequentFlyerMiles = frequentFlyerMiles;
 }
 
 public void setUpgradeMiles(int upgradeMiles)
 {
  this.upgradeMiles = upgradeMiles;
 }
 
 public void setStartMonth(int startMonth)
 {
  this.startMonth = startMonth; 
 }
 
 public void setEndMonth(int endMonth)
 {
  this.endMonth = endMonth; 
 }
 
}