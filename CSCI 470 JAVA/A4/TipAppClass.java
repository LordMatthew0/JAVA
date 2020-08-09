import javax.swing.JFrame;
import java.awt.EventQueue;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 4 - Tip Calculator               *
 *                                                                  *
 *                                                                  *
 *  Class Name:  TipAppClass                                        *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A program that tests TipCalculator                 *
 *               and tipAppGUI.                                     *
 *                                                                  *
 ********************************************************************/

public class TipAppClass
{ 
  public static void main(String[] args)
  { //runs the GUI on the event queue thread
    EventQueue.invokeLater(() ->
    {
      TipAppGUI frame = new TipAppGUI();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(600,300);
      frame.setVisible(true);
    });
  }
}