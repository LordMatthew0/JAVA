import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;

/********************************************************************
 *                                                                  *
 *  CSCI 470-2/502-2    Assignment 5 – Concurrency and Animation    *
 *                                                                  *
 *                                                                  *
 *  Class Name:  SortPanel                                          *
 *                                                                  *
 *  Programmer:  Matthew Lord                                       *
 *                                                                  *
 *  Purpose:     A program that sets up the GUI                     *
 *                                                                  *
 ********************************************************************/

public class SortPanel extends JPanel
{
  private final JButton populateButton;
  private final JButton sortButton;
  private final JComboBox selectSort;
  private final JComboBox selectSort2;
  private final JComboBox speedSelect;
  private String[] sortTypes;
  private String[] speeds;
  private SortAnimationPanel sortPanel;
  private SortAnimationPanel sortPanel2;
  private ExecutorService executor;
  
  //constructor
  public SortPanel()
  {
    new FlowLayout(FlowLayout.LEADING, 2, 1);

    
    setPreferredSize(new Dimension(900, 450));
    
    sortPanel = new SortAnimationPanel();
    sortPanel2 = new SortAnimationPanel();
    
    speeds = new String[]{"Slow", "Medium", "Fast"};
    sortTypes = new String[]{"Bubble", "Selection", "Heap"};
    populateButton = new JButton("Populate Array");
    sortButton = new JButton("Sort");
    speedSelect = new JComboBox<String>(speeds);
    selectSort = new JComboBox<String>(sortTypes);
    selectSort2 = new JComboBox<String>(sortTypes);
    
    EventsHandler buttonH = new EventsHandler();
    executor = Executors.newCachedThreadPool();
    
    sortButton.setEnabled(false);
    sortPanel.setPreferredSize(new Dimension(440, 300));
    sortPanel.setBackground(new Color(100, 150, 100));
    
    sortPanel2.setPreferredSize(new Dimension(440, 300));
    sortPanel2.setBackground(new Color(100, 150, 100));
    
    add(sortPanel);
    add(sortPanel2);
    
    selectSort.setPreferredSize(new Dimension(440, 25));
    add(selectSort);
    selectSort2.setPreferredSize(new Dimension(440, 25));
    add(selectSort2);
   
    add(populateButton);
    add(sortButton);
   
    add(speedSelect);
    
    populateButton.addActionListener(buttonH);
    sortButton.addActionListener(buttonH);
  }
  
  /**********************************************************
 *                                                          *
 *  class Name:  SortAnimationPanel                        *
 *                                                          *
 *  Purpose: Contains code for sorting algorithems as well  *
 *           as updating the sort panel                     *
 *                                                          *
 ************************************************************/
 
  
  private class SortAnimationPanel extends JPanel implements Runnable 
  {
    private int[] sortable;
    public int sortNo = 0;
    public int sleepTimeindex = 0;
    public int sleepTimeInt = 0;
    
    
    //constructor
    public SortAnimationPanel()
    {
      new FlowLayout(FlowLayout.LEADING, 2, 1); 
    }
    
    //populates array 
    public void populateArr() {
      sortable = new int[440];
      Random rand = new Random(System.currentTimeMillis());
      for (int i = 0; i < sortable.length; i++)
        sortable[i] = rand.nextInt(300);
    }
    
   
    private void selectionSort() throws InterruptedException {
      
      if(sleepTimeindex == 0)
        sleepTimeInt = 50;
      if(sleepTimeindex == 1)
        sleepTimeInt = 25;
      if(sleepTimeindex == 2)
        sleepTimeInt = 10;
      
      
      int hold, min, n = sortable.length;
      
      for (int i = 0; i < n-1; i++) 
      {
        min = i;
        
        for (int j = i+1; j < n; j++) 
        {
          if (sortable[j] < sortable[min])
            min = j;
        }
        
        if (min != i) 
        {
          hold = sortable[i];
          sortable[i] = sortable[min];
          sortable[min] = hold;
        }
        
        repaint();
        Thread.sleep(sleepTimeInt);
      }
    }
    
    //Bubble Sort
    
    private void bubbleSort() throws InterruptedException 
    {
      
      if(sleepTimeindex == 0)
        sleepTimeInt = 50;
      if(sleepTimeindex == 1)
        sleepTimeInt = 25;
      if(sleepTimeindex == 2)
        sleepTimeInt = 10;
      
      int hold, n = sortable.length;
      boolean swapped;
      
      do 
      {
        
        swapped = false;
        
        for (int i = 1; i <= n-1; i++) 
        {
          
          if (sortable[i-1] > sortable[i]) 
          {
            hold = sortable[i-1];
            sortable[i-1] = sortable[i];
            sortable[i] = hold;
            swapped = true;
          }
          
        }
        
        repaint();
        Thread.sleep(sleepTimeInt);
        
      }while (swapped);
    }
    
    //Heap Sort
    
    private void heapSort() throws InterruptedException 
    {
      //build heap
      for (int root = sortable.length - 1; root > 0; root--)
         heapify(sortable.length-1, root);
      
      //Conduct the sort 
      int i = sortable.length - 1;
      while (i > 0) 
      {
        int hold = sortable[0];
        sortable[0] = sortable[i];
        sortable[i] = hold;
        heapify(--i, 0);
      }
    }
    
    private void heapify(int len, int root) throws InterruptedException 
    {
      
      if(sleepTimeindex == 0)
        sleepTimeInt = 50;
      if(sleepTimeindex == 1)
        sleepTimeInt = 25;
      if(sleepTimeindex == 2)
        sleepTimeInt = 10;
      
      if ((2*root) == len){ 
        
        if (sortable[2*root] > sortable[root]) 
        {
          int hold = sortable[2*root];
          sortable[2*root] = sortable[root];
          sortable[root] = hold;
          heapify(len, 2*root);
        }
        
      }else if ((2*root + 1) < len) 
      {
        
        if (sortable[2*root] > sortable[2*root + 1]) 
        {
          
          if (sortable[2*root] > sortable[root]) 
          { 
            int hold = sortable[2*root];
            sortable[2*root] = sortable[root];
            sortable[root] = hold;
            heapify(len, 2*root);
          }
          
        } else 
        {
          if (sortable[2*root + 1] > sortable[root]) 
          {
            int hold = sortable[2*root + 1];
            sortable[2*root + 1] = sortable[root];
            sortable[root] = hold;
            heapify(len, 2*root+1);
          }
        }
      }
    
    
      repaint();
      Thread.sleep(sleepTimeInt);
    }
    
    @Override
    public void paintComponent(Graphics g) {  
      super.paintComponent(g);
      this.setBackground(Color.WHITE);
      
      g.setColor(Color.BLUE);
      if (sortable != null) {
        for (int i = 0; i < sortable.length; i++)
          g.drawLine(i, (300 - sortable[i]), i, 300);
      }
    }
    
    @Override
    public void run() {
      try {
        switch(sortNo) {
          case 0: bubbleSort();
                  break;
          case 1: selectionSort();
                  break;
          case 2: heapSort();
                  break;
        }
        
        populateButton.setEnabled(true);
      } catch (InterruptedException exception) {
        exception.printStackTrace();
        Thread.currentThread().interrupt();
      }
    }
  }
  
  //Event handler for buttons
  private class EventsHandler implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getActionCommand() == "Populate Array") {
        
        //Initalize array and draw it
        sortPanel.populateArr();
        sortPanel2.populateArr();
        
        sortPanel.repaint();
        sortPanel2.repaint();
        
        //Toggle buttons
        populateButton.setEnabled(false);
        sortButton.setEnabled(true);
      }else
      {
        sortPanel.sortNo = selectSort.getSelectedIndex();
        sortPanel.sleepTimeindex = speedSelect.getSelectedIndex();
        
        sortPanel2.sortNo = selectSort2.getSelectedIndex();
        sortPanel2.sleepTimeindex= speedSelect.getSelectedIndex();
        
        executor.execute(sortPanel);
        executor.execute(sortPanel2);
        
        //Disable Sort button
        sortButton.setEnabled(false);
      }
    }
  }
}