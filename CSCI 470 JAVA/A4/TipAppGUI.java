import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.text.DecimalFormat;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 4 - Tip Calculator               *
 *                                                                  *
 *                                                                  *
 *  Class Name:  TipAppGUI                                          *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A  program that sets up the GUI.                   *
 *                                                                  *
 ********************************************************************/

public class TipAppGUI extends JFrame implements ActionListener, ChangeListener
{
  // All of the objects that were needed for the GUI
  private final JTextField textField;
  private final JSlider slider;
  private final JSpinner spinner;
  private final JButton calculateButton;
  private final JButton clearButton;
  private final JLabel totalBillLabel;
  private final JLabel shareLabel;
  private final JLabel billPromptLabel;
  private final JLabel tipPercentageLabel;
  private final JLabel partySizeLabel;
  private final JLabel totalBillPromptLabel;
  private final JLabel sharePromptLabel;
  private final GridLayout gridLayout;
  
  // Sets up the spinner
  Integer value = new Integer(1);
  Integer min = new Integer(0);
  Integer max = new Integer(50);
  Integer step = new Integer(1);
  SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, step);
  
  TipCalculator bill = new TipCalculator();
  
  DecimalFormat dollars = new DecimalFormat("$##,###,##0.00"); // Used for displaying dollar amounts
  
  public TipAppGUI()
  {
    super("Tip Calculator");
    gridLayout = new GridLayout(6, 2, 5, 5); // Using a 6 by 2 grid layout 
    setLayout(gridLayout);
    
    textField = new JTextField(""); // Sets up a blank text field for the user to input the bill amount
    
    // Sets up the slider with tick marks 
    slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 20);
    slider.setPaintTicks(true);
    slider.setMajorTickSpacing(10);
    slider.setMinorTickSpacing(5);
    slider.setPaintLabels(true);
    
    // Sets up the spinner
    spinner = new JSpinner();
    spinner.setModel(model);
    
    // Sets up the buttons 
    calculateButton = new JButton("Calculate");
    clearButton = new JButton("Clear");
    
    // Sets up the labels 
    totalBillLabel = new JLabel("");
    shareLabel = new JLabel("");
    billPromptLabel = new JLabel("Bill Amount");
    tipPercentageLabel = new JLabel("Tip Percentage");
    partySizeLabel = new JLabel("Party Size");
    totalBillPromptLabel = new JLabel("Total Bill(with Tip)");
    sharePromptLabel = new JLabel("Individual Share");
    
    // Adds the change listener and action listener
    slider.addChangeListener(this);
    spinner.addChangeListener(this);
    calculateButton.addActionListener(this);
    clearButton.addActionListener(this);
    
    // Adds all the objects to the grid 
    add(billPromptLabel);
    add(textField);
    add(tipPercentageLabel);
    add(slider);
    add(partySizeLabel);
    add(spinner);
    add(calculateButton);
    add(clearButton);
    add(totalBillPromptLabel);
    add(totalBillLabel);
    add(sharePromptLabel);
    add(shareLabel);
  }
  
  /**********************************************************
 *                                                          *
 *  Method Name:  actionPerformed                           *
 *                                                          *
 *  Purpose: Checks to see if a action, like a button press *
 *           was performed.                                 *
 *                                                          *
 ************************************************************/
  
  @Override
  public void actionPerformed(ActionEvent e)
  {
    String input = e.getActionCommand();
    double d = 0;
    if(input.equals("Calculate")) // Checks if the calculate button was pressed
    {
      try
      {
         d = Double.parseDouble(textField.getText());   // Tries to convert what ever was in the text field to a double
      }
      catch (NumberFormatException o)
      {
        JOptionPane.showMessageDialog(null, "Bill amount must be numeric.");  // Something in the text field was not a number
      }
      if(d < 0)
        JOptionPane.showMessageDialog(null, "Bill amount must be greater than 0."); // The number in the text field was less then zero
      else
      {
       bill.setBillAmount(d);
       bill.setTipPercentage(slider.getValue());
       bill.setPartySize((Integer) model.getNumber());
       double totalBill = bill.getTotalBill();
       double share = bill.getIndividualShare(); 
       totalBillLabel.setText(dollars.format(totalBill));
       shareLabel.setText(dollars.format(share));
      }
    }
    else if(input.equals("Clear"))
    {
      // Clears all fields to their default state
      textField.setText("");
      slider.setValue(20);
      spinner.setValue(1);
      bill.setBillAmount(0);
      bill.setTipPercentage(20);
      bill.setPartySize(1);
      totalBillLabel.setText("");
      shareLabel.setText("");
    }
  }

/***********************************************************
*                                                          *
*  Method Name:  stateChanged                              *
*                                                          *
*  Purpose: Takes action if the state of the               *
*           slider or spinner has changed.                 *
*                                                          *
************************************************************/
  
  
  @Override
  public void stateChanged(ChangeEvent e)
  {
    bill.setTipPercentage(slider.getValue());
    bill.setPartySize((Integer) model.getValue());
  }
}