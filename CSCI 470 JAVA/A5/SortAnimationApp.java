import javax.swing.JFrame;
import java.awt.FlowLayout;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 5 – Concurrency and Animation    *
 *                                                                  *
 *                                                                  *
 *  Class Name:  SortAnimationApp                                   *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A program that runs the sort panel GUI             *
 *                                                                  *
 ********************************************************************/


public class SortAnimationApp extends JFrame
{
  public SortAnimationApp(String s)
  {
    super(s);
    
    setLayout(new FlowLayout(FlowLayout.LEADING, 2, 2));
    
    setResizable(false);
    
    SortPanel sp = new SortPanel();
    
    add(sp);
  }
  
  public static void main(String[] args) 
  {
    
    //New instance of this class
    SortAnimationApp mainWindow = new SortAnimationApp("Sorting Animation");
    
    
    
    //set attributes
    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainWindow.setSize(900, 450);
    mainWindow.setVisible(true);
  }
  
  
}