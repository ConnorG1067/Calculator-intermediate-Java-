//Moduels
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
    
/**Runs TicTacToe Application
 * 2021-02-24
 * Created by: Connor Gomes
 * ICS4U
 * 
 * Added Features
 * 4x4 board
 * score for x,o and ties
 * clear score for all fields
 * Reset game button
 * Game history txt doc
 * new x, o, and cardback photos
 */

public class TicTacToeApplication extends JFrame {
    //Declaring that TicTacEvent will be used in this call using the variable tictac
    TicTacEvent tictac = new TicTacEvent(this);
    //Configuring GUI Application by declaring different variables associated with Swing features
    JPanel row1 = new JPanel();
    JButton[][] boxes = new JButton[4][4];
    JOptionPane win = new JOptionPane("Winner");
    ImageIcon back = new ImageIcon("cardback.jpg");
    JLabel title = new JLabel("     Tic Tac Toe");  
    JLabel xWins = new JLabel("   X has won: " + tictac.xHasWon);  
    JLabel oWins = new JLabel("O has won: " + tictac.oHasWon);  
    JLabel tie = new JLabel("   Ties: " + tictac.ties);
    JButton reset = new JButton("Reset Game");
    JPanel panel = new JPanel(new BorderLayout());
    JMenu  save =new JMenu("History");   
    JMenu  clear =new JMenu("Clear"); 
    JMenuItem saveSubMenu =new JMenuItem("Game History");  
    JMenuItem clearSubMenu = new JMenuItem("Clear Score");  
    JMenuBar mb =new JMenuBar();  

    
    public TicTacToeApplication() {
        //Name the window Tic Tac Toe
        super("Tic Tac Toe");
        //Set the size of the window to 500x500 pixels
        setSize(500,500);
        //Exit application on close
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Creating a new flow layout variable layout
        FlowLayout layout = new FlowLayout();
        //Setting the layout the layout variable
        setLayout(layout);

        //Setting title font to arial, bold, 24 size
        title.setFont(new Font("Arial", Font.BOLD, 24));
        
        //Adding various components to a panel to format properly
        //Adding the title to the north of the panel
        panel.add(title, BorderLayout.NORTH);
        //Adding the reset button to the south of the panel
        panel.add(reset, BorderLayout.SOUTH);
        //Adding xWins JLabel to the east of the panel
        panel.add(xWins, BorderLayout.EAST);
        //Adding oWins JLabel to the west of the panel
        panel.add(oWins, BorderLayout.WEST);
        //Adding tie JLabel to the center of the panel
        panel.add(tie, BorderLayout.CENTER);
        //Adding panel and all of its components to the frame
        add(panel);
        
        //Adding save and clear which are JMenu's to JMenuBar mb
        mb.add(save);
        mb.add(clear);
        //Adding saveSubMenu to save
        save.add(saveSubMenu);
        //Adding clearSubMenu to clear
        clear.add(clearSubMenu);
        //Adding mb to frame
        add(mb);
        //Setting JMenuBar mb to top of the application
        setJMenuBar(mb);  
        
        //Adding an action listener to saveSubMenu to do a specific task from TicTactEvent
        saveSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Referencing TicTactEvent using tictac to access saveSubMenuActionPerformed
                tictac.saveSubMenuActionPerformed(evt);
            }
        });
        //Adding an action listener to clearSubMenu to do a specific task from TicTactEvent
        clearSubMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //Referencing TicTactEvent using tictac to access clearSubMenuActionPerformed
                tictac.clearSubMenuActionPerformed(evt);
            }
        });
        //Adding an action listener to reset button to do a specific task from TicTactEvent
        reset.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    //Referencing TicTactEvent using tictac to access resetActionPerformed
                    tictac.resetActionPerformed(evt);
                }
            });
       
        
        
        
        //Setting an int variable to 0
        int name = 0;
        //Creating a string newname
        String newname;
        //Adding a grid layout with 4,3,10,10 as the values which is a rectangular grid
        GridLayout layout1 = new GridLayout (4,3,10,10);        
        //Setting row1 to layout1
        row1.setLayout(layout1);        
        //Creates and adds button the grid layout up and down
        for(int x=0; x<=3; x++) {
            //Creates and adds button the grid layout left and right
            for(int y=0; y<=3;y++){
                //adds 1 to the loop
                name = name + 1;
                //names newname from 1-9
                newname = Integer.toString(name);
                //Sets the boxes to show numbers 1-9
                boxes[x][y] = new JButton(newname);
                //Sets the back image to each box
                boxes[x][y].setIcon(back);
                //adds remaining components to grid layout
                row1.add(boxes[x][y]);
                
            }
        }
        //Adds the gridlayout to the flowlayout
        add(row1);
        //Runs a loop to determine button clicked
        for(int x=0; x<=3; x++){
            for(int y=0; y<=3;y++){
                //Listens to buttons clicks
                boxes[x][y].addActionListener(tictac);
            }
        }
        //Shows FlowLayout on the screen
        setVisible(true);
        
        
    }

    
    
    //This is the main method in the program and invokes all the other methods required by your program
    public static void main(String[] args) throws IOException {
        //Runs the screen layout class
        TicTacToeApplication frame = new TicTacToeApplication();
        //Creating a file variable named file with the text of TicTacToeGame.txt
        File file = new File("TicTacToeGame.txt");
        //Creates file on users computer
        file.createNewFile();
        
        
        
    }
}
