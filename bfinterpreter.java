    import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class bfinterpreter extends JFrame {
  // Anfang Attribute
  private JTextArea TAeingabe = new JTextArea("");
  private JScrollPane TAeingabeScrollPane = new JScrollPane(TAeingabe);
  private JButton jButton1 = new JButton();
  private JLabel LBLausgabe = new JLabel();
  
  private String eingabe = "";
  private int[] array = new int[100];
  private String ausgabe = "";
  private int arrindex = 0;
  private String teststring = "";
  // Ende Attribute
    
  public bfinterpreter() { 
    // Frame-Initialisierung
    super();
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    int frameWidth = 300; 
    int frameHeight = 360;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("bfinterpreter");
    setResizable(false);
    Container cp = getContentPane();
    cp.setLayout(null);
    // Anfang Komponenten
    
    TAeingabeScrollPane.setBounds(16, 16, 264, 132);
    cp.add(TAeingabeScrollPane);
    jButton1.setBounds(112, 160, 75, 25);
    jButton1.setText("Run");
    jButton1.setMargin(new Insets(2, 2, 2, 2));
    jButton1.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    jButton1_ActionPerformed(evt);
    }
    });
    cp.add(jButton1);
    LBLausgabe.setBounds(24, 208, 254, 20);
    LBLausgabe.setText("");
    cp.add(LBLausgabe);
    // Ende Komponenten
    
    setVisible(true);
  } // end of public bfinterpreter
  
  // Anfang Methoden
    
  public static void main(String[] args) {
    new bfinterpreter();
  } // end of main
    
  public void jButton1_ActionPerformed(ActionEvent evt) {
    LBLausgabe.setText("");
    ausgabe = "";
    for (int i = 0; i<100 ; i++ ) {
      array[i] =0;  
      } // end of for
    
    LBLausgabe.setText("");
    
    String workstr = TAeingabe.getText();
    for (int i = 0; i < workstr.length() ; i++ ) { //takes every individual character and executes action
      //System.out.println("round");   //for debugging
      switch (workstr.charAt(i)) {
        case '>': 
          if (arrindex +1 > 99) {
            arrindex = 0;
          } // end of if
          else
          arrindex++;
          break;
        case '<': 
          if (arrindex - 1 < 0) {
            arrindex = 99;
          } // end of if
          else
          arrindex--;
          
          break;
        case '+':
          if (array[arrindex] +1 > 255) {
            array[arrindex] = 0;
          } // end of if
          else
          array[arrindex]++;
          break;
        case '-':
          if (array[arrindex] -1 < 0) {
            array[arrindex] = 255;
          } // end of if
          else
          array[arrindex]--;
          break;
        case '.':
          ausgabe += (char) array[arrindex];
          LBLausgabe.setText(ausgabe);
          //System.out.println(array[arrindex]); //debugging
          break;
        case ',':
          teststring = JOptionPane.showInputDialog("test");
          while (teststring.length() > 1) { 
            teststring = JOptionPane.showInputDialog("test");
            System.out.println("errrror");
          } // end of while
          if (teststring.isEmpty()) {
            break;
          } // end of if
          array[arrindex] = (int) teststring.charAt(0);
          teststring = "";
          break;
        case '[':
          if (array[arrindex] == 0) {
            while (workstr.charAt(i) != ']') { 
              i++;
            } // end of while
          } // end of if
          break;
        case ']':
          if (array[arrindex] != 0) {
            while (workstr.charAt(i) != '[') { 
              i--;
            } // end of while
          } // end of if
          break;
        default: 
          
      } // end of switch
    } // end of for
    
  } // end of jButton1_ActionPerformed

  // Ende Methoden
} // end of class bfinterpreter