import javax.swing.*; //imports libraries we need
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

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

//Creating a public glass TicTacEvent that implements ItemListener, Action Listener, and Runnable
public class TicTacEvent implements ItemListener, ActionListener, Runnable { 
    //Referencing TicTacToeApplication as gui
    TicTacToeApplication gui;
    //Adding a variable to images x, o and carback
    ImageIcon a = new ImageIcon("X.jpg"); 
    ImageIcon b = new ImageIcon("O.jpg"); 
    ImageIcon back = new ImageIcon("cardback.jpg");
    
    //Declaring different variables that will be used later in the code
    Date date = new Date();
    int clicks = 0;  
    int win = 0;   
    int[][] check = new int[4][4];  
    int xHasWon = 0;
    int oHasWon = 0;
    int ties = 0;
    String contents = "";
    
    //associates the two files to be used together.
    public TicTacEvent (TicTacToeApplication in){    
        gui = in;
        //initiates the winner check array.
        for (int row=0; row<=3; row++){
            for (int col=0; col<=3; col++){
                check[row][col]=0;
            }
        }
    }
    //When game history is clicked the following occurs
    public void saveSubMenuActionPerformed(java.awt.event.ActionEvent evt) {                                       
        //Opens TicTacToeGame.txt
        try {
            Desktop.getDesktop().open(new java.io.File("TicTacToeGame.txt"));
        } catch (IOException ex) {
            
        }
    }
    //When clear score is clicked the following occurs
    public void clearSubMenuActionPerformed(java.awt.event.ActionEvent evt) {                                       
        //Set all variables that show the score to 0
        xHasWon = 0;
        oHasWon = 0;
        ties = 0;
        
        //Reset text to refresh the correct score
        gui.oWins.setText("O has won: " + oHasWon);
        gui.xWins.setText("   X has won: " + xHasWon);
        gui.tie.setText("   Ties: " + ties);
    }
    //When reset is clicked the following occurs  
    public void resetActionPerformed(java.awt.event.ActionEvent evt) {                                       
        //Calls the reset function made later in the code
        reset();
    }
    
    //Tells the program what to do when a button is clicked.
    public void actionPerformed (ActionEvent event) {  
        //Setting a string to the button input from the button that is clicked
        String command = event.getActionCommand();  
        //If a button is clicked 1-16 they each have there own function that is shown later in the code
        //If command is 1 call b1 function
        if (command.equals("1")) {  
            b1();                    
        }
        //If command is 2 call b2 function
        if (command.equals("2")) {
            b2();
        }
        //If command is 3 call b3 function
        if (command.equals("3")) {
            b3();
        }
        //If command is 4 call b4 function
        if (command.equals("4")) {
            b4();
        }
        //If command is 5 call b5 function
        if (command.equals("5")) {
            b5();
        }
        //If command is 6 call b6 function
        if (command.equals("6")) {
            b6();
        }
        //If command is 7 call b7 function
        if (command.equals("7")) {
            b7();
        }
        //If command is 8 call b8 function
        if (command.equals("8")) {
            b8();
        }
        //If command is 9 call b9 function
        if (command.equals("9")) {
            b9();
        }
        //If command is 10 call b10 function
        if (command.equals("10")) {
            b10();
        }
        //If command is 11 call b11 function
        if (command.equals("11")) {
            b11();
        }
        //If command is 12 call b12 function
        if (command.equals("12")) {
            b12();
        }
        //If command is 13 call b13 function
        if (command.equals("13")) {
            b13();
        }
        //If command is 14 call b14 function
        if (command.equals("14")) {
            b14();
        }
        //If command is 15 call b15 function
        if (command.equals("15")) {
            b15();
        }
        //If command is 16 call b16 function
        if (command.equals("16")) {
            b16();
        }
        
    }

    //Creating a function reset   
    void reset() {
        //Setting variable clicks to 0
        clicks = 0;
        //Setting variable win to 0
        win = 0;
        //Using two for loops for the 2d array to get every posible combination
        for (int x = 0; x <= 3; x++) {
            for (int y = 0; y <= 3; y++) {
                //Setting the gui boxes to enabled, the image to back.jpg, and check all combos to 0.
                gui.boxes[x][y].setEnabled(true);
                gui.boxes[x][y].setDisabledIcon(back);
                check[x][y] = 0;
            }
        }
       
    }
    //Creating 16 functions that determine what happens when each button is clicked
        void b1() {
        //adds 1 to clicks to record amount of clicks
        clicks = clicks + 1;
        //If clicks is odd then jump into if statement
        if ((clicks % 2) == 1) {
            //Sets the check[0][0] box to 1 also known as x
            check[0][0] = 1;
            //Lets the user know the box is clicked and can no longer be click again
            gui.boxes[0][0].setEnabled(false);
            //Set the icon to the x image to show user x player clicked this box
            gui.boxes[0][0].setDisabledIcon(a);
        //If the clicks is anything else, meaning it is even which indicates o jump into if statement
        } else {
            //Sets the check[0][0] box to 2 also known as o
            check[0][0] = 2;
            //Lets the user know the box is clicked and can no longer be click again
            gui.boxes[0][0].setEnabled(false);
            //Set the icon to the o image to show user o player clicked this box
            gui.boxes[0][0].setDisabledIcon(b);
        }
        //After each button is clicked call the winner function to determine if a winner is selected
        winner();

    }

    void b2() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[0][1] = 1;
            gui.boxes[0][1].setEnabled(false);
            gui.boxes[0][1].setDisabledIcon(a);
        } else {
            check[0][1] = 2;
            gui.boxes[0][1].setEnabled(false);
            gui.boxes[0][1].setDisabledIcon(b);
        }
        winner();
    }

    void b3() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[0][2] = 1;
            gui.boxes[0][2].setEnabled(false);
            gui.boxes[0][2].setDisabledIcon(a);
        } else {
            check[0][2] = 2;
            gui.boxes[0][2].setEnabled(false);
            gui.boxes[0][2].setDisabledIcon(b);
        }
        winner();
    }

    void b4() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[0][3] = 1;
            gui.boxes[0][3].setEnabled(false);
            gui.boxes[0][3].setDisabledIcon(a);
        } else {
            check[0][03] = 2;
            gui.boxes[0][3].setEnabled(false);
            gui.boxes[0][3].setDisabledIcon(b);
        }
        winner();
    }

    void b5() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[1][0] = 1;
            gui.boxes[1][0].setEnabled(false);
            gui.boxes[1][0].setDisabledIcon(a);
        } else {
            check[1][0] = 2;
            gui.boxes[1][0].setEnabled(false);
            gui.boxes[1][0].setDisabledIcon(b);
        }
        winner();
    }

    void b6() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[1][1] = 1;
            gui.boxes[1][1].setEnabled(false);
            gui.boxes[1][1].setDisabledIcon(a);
        } else {
            check[1][1] = 2;
            gui.boxes[1][1].setEnabled(false);
            gui.boxes[1][1].setDisabledIcon(b);
        }
        winner();
    }

    void b7() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[1][2] = 1;
            gui.boxes[1][2].setEnabled(false);
            gui.boxes[1][2].setDisabledIcon(a);
        } else {
            check[1][2] = 2;
            gui.boxes[1][2].setEnabled(false);
            gui.boxes[1][2].setDisabledIcon(b);
        }
        winner();
    }

    void b8() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[1][3] = 1;
            gui.boxes[1][3].setEnabled(false);
            gui.boxes[1][3].setDisabledIcon(a);
        } else {
            check[1][3] = 2;
            gui.boxes[1][3].setEnabled(false);
            gui.boxes[1][3].setDisabledIcon(b);
        }
        winner();
    }

    void b9() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[2][0] = 1;
            gui.boxes[2][0].setEnabled(false);
            gui.boxes[2][0].setDisabledIcon(a);
        } else {
            check[2][0] = 2;
            gui.boxes[2][0].setEnabled(false);
            gui.boxes[2][0].setDisabledIcon(b);
        }
        winner();
    }

    void b10() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[2][1] = 1;
            gui.boxes[2][1].setEnabled(false);
            gui.boxes[2][1].setDisabledIcon(a);
        } else {
            check[2][1] = 2;
            gui.boxes[2][1].setEnabled(false);
            gui.boxes[2][1].setDisabledIcon(b);
        }
        winner();
    }

    void b11() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[2][2] = 1;
            gui.boxes[2][2].setEnabled(false);
            gui.boxes[2][2].setDisabledIcon(a);
        } else {
            check[2][2] = 2;
            gui.boxes[2][2].setEnabled(false);
            gui.boxes[2][2].setDisabledIcon(b);
        }
        winner();
    }

    void b12() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[2][3] = 1;
            gui.boxes[2][3].setEnabled(false);
            gui.boxes[2][3].setDisabledIcon(a);
        } else {
            check[2][3] = 2;
            gui.boxes[2][3].setEnabled(false);
            gui.boxes[2][3].setDisabledIcon(b);
        }
        winner();
    }

    void b13() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[3][0] = 1;
            gui.boxes[3][0].setEnabled(false);
            gui.boxes[3][0].setDisabledIcon(a);
        } else {
            check[3][0] = 2;
            gui.boxes[3][0].setEnabled(false);
            gui.boxes[3][0].setDisabledIcon(b);
        }
        winner();
    }

    void b14() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[3][1] = 1;
            gui.boxes[3][1].setEnabled(false);
            gui.boxes[3][1].setDisabledIcon(a);
        } else {
            check[3][1] = 2;
            gui.boxes[3][1].setEnabled(false);
            gui.boxes[3][1].setDisabledIcon(b);
        }
        winner();
    }

    void b15() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[3][2] = 1;
            gui.boxes[3][2].setEnabled(false);
            gui.boxes[3][2].setDisabledIcon(a);
        } else {
            check[3][2] = 2;
            gui.boxes[3][2].setEnabled(false);
            gui.boxes[3][2].setDisabledIcon(b);
        }
        winner();
    }

    void b16() {
        clicks = clicks + 1;
        if ((clicks % 2) == 1) {
            check[3][3] = 1;
            gui.boxes[3][3].setEnabled(false);
            gui.boxes[3][3].setDisabledIcon(a);
        } else {
            check[3][3] = 2;
            gui.boxes[3][3].setEnabled(false);
            gui.boxes[3][3].setDisabledIcon(b);
        }
        winner();
    }

    //Creating the winner variable
    void winner() {
        //Checks each row for a horizontal win
        for (int x = 0; x <= 3; x++) {
            //Checks to see if all entries are X, or all entries are O.
            if ((check[x][0] == check[x][1]) && (check[x][0] == check[x][2]) && (check[x][0] == check[x][3])) {
                // if all X jump into if statement
                if (check[x][0] == 1) {
                    //Pops up a MessageDialog telling the user that x won
                    JOptionPane.showMessageDialog(null, "X is the winner.");
                    //adds 1 to our variable xHasWon
                    xHasWon++;
                    //Adds text to a string giving the exact date time, who won, how many clicks it took, and the type of win
                    contents = "[" + date.toString() + "]\nX won in " + clicks + " clicks\nWin Type: Horizontal\n\n";
                    //Find file TicTacToeGame.txt
                    try (FileWriter writer = new FileWriter("TicTacToeGame.txt", true)) {
                        //Write to TicTacToeGame.txt our string contents
                        writer.write(contents);
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    //References xWins from gui and sets the text to the updated xHasWon int variable
                    gui.xWins.setText("   X has won: " + xHasWon);
                    //Sets win to 1
                    win = 1;
                // if all O jump into if statement
                } else if (check[x][0] == 2) {
                    //Pops up a MessageDialog telling the user that o won
                    JOptionPane.showMessageDialog(null, "O is the winner.");
                    //adds 1 to our variable oHasWon
                    oHasWon++;
                    //Adds text to a string giving the exact date time, who won, how many clicks it took, and the type of win
                    contents = "[" + date.toString() + "]\nO won in " + clicks + " clicks\nWin Type: Horizontal\n\n";
                    //Find file TicTacToeGame.txt
                    try (FileWriter writer = new FileWriter("TicTacToeGame.txt", true)) {
                        //Write to TicTacToeGame.txt our string contents
                        writer.write(contents);
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    //References oWins from gui and sets the text to the updated oHasWon int variable
                    gui.oWins.setText("O has won: " + oHasWon);
                    //Sets win to 1
                    win = 1;

                }
            }
        }
        /** Check columns for winner */
        for (int x = 0; x <= 3; x++) {
            //checks to see if all entries are X, or all entries are O.
            if ((check[0][x] == check[1][x]) && (check[0][x] == check[2][x]) && (check[0][x] == check[3][x])) {
                // if all X jump into if statement
                if (check[0][x] == 1) {
                    //Pops up a MessageDialog telling the user that x won
                    JOptionPane.showMessageDialog(null, "X is the winner.");
                    //adds 1 to our variable xHasWon
                    xHasWon++;
                    //Adds text to a string giving the exact date time, who won, how many clicks it took, and the type of win
                    contents = "[" + date.toString() + "]\nX won in " + clicks + " clicks\nWin Type: Vertical\n\n";
                    //Find file TicTacToeGame.txt
                    try (FileWriter writer = new FileWriter("TicTacToeGame.txt", true)) {
                        //Write to TicTacToeGame.txt our string contents
                        writer.write(contents);
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    //References xWins from gui and sets the text to the updated xHasWon int variable
                    gui.xWins.setText("   X has won: " + xHasWon);
                    //Sets win to 1
                    win = 1;
                // if all O jump into if statement
                } else if (check[0][x] == 2) {
                    //Pops up a MessageDialog telling the user that o won
                    JOptionPane.showMessageDialog(null, "O is the winner.");
                    //adds 1 to our variable oHasWon
                    oHasWon++;
                    //Adds text to a string giving the exact date time, who won, how many clicks it took, and the type of win
                    contents = "[" + date.toString() + "]\nO won in " + clicks + " clicks\nWin Type: Vertical\n\n";
                    //Find file TicTacToeGame.txt
                    try (FileWriter writer = new FileWriter("TicTacToeGame.txt", true)) {
                        //Write to TicTacToeGame.txt our string contents
                        writer.write(contents);
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                    //References oWins from gui and sets the text to the updated oHasWon int variable
                    gui.oWins.setText("O has won: " + oHasWon);
                    //Sets win to 1
                    win = 1;

                }
            }
        }
        /** Check diagonals for winner */
        //If x matches diagonal jump into the if statement
        if ((check[0][0] == 1) && (check[1][1] == 1) && (check[2][2] == 1) && (check[3][3] == 1) || (check[3][0] == 1) && (check[2][1] == 1) && (check[1][2] == 1) && (check[0][3] == 1)) {
            //Pops up a MessageDialog telling the user that x won
            JOptionPane.showMessageDialog(null, "X is the winner.");
            //adds 1 to our variable xHasWon
            xHasWon++;
            //Adds text to a string giving the exact date time, who won, how many clicks it took, and the type of win
            contents = "[" + date.toString() + "]\nX won in " + clicks + " clicks\nWin Type: Diagonal\n\n";
            //Find file TicTacToeGame.txt
            try (FileWriter writer = new FileWriter("TicTacToeGame.txt", true)) {
                //Write to TicTacToeGame.txt our string contents
                writer.write(contents);
            } catch (IOException i) {
                i.printStackTrace();
            }
            //References xWins from gui and sets the text to the updated xHasWon int variable
            gui.xWins.setText("   X has won: " + xHasWon);
            //Sets win to 1
            win = 1;
        } else if ((check[0][0] == 2) && (check[1][1] == 2) && (check[2][2] == 2) && (check[3][3] == 2) || (check[3][0] == 2) && (check[2][1] == 2) && (check[1][2] == 2) && (check[0][3] == 2)) {
            //Pops up a MessageDialog telling the user that o won
            JOptionPane.showMessageDialog(null, "O is the winner.");
            //adds 1 to our variable oHasWon
            oHasWon++;
            //Adds text to a string giving the exact date time, who won, how many clicks it took, and the type of win
            contents = "[" + date.toString() + "]\nO won in " + clicks + " clicks\nWin Type: Diagonal\n\n";
            //Find file TicTacToeGame.txt
            try (FileWriter writer = new FileWriter("TicTacToeGame.txt", true)) {
                //Write to TicTacToeGame.txt our string contents
                writer.write(contents);
            } catch (IOException i) {
                i.printStackTrace();
            }
            //References oWins from gui and sets the text to the updated oHasWon int variable
            gui.oWins.setText("O has won: " + oHasWon);
            //Sets win to 1
            win = 1;

        }
        
        //If 16 clicks has occurs and win is sitll 0 then jump into the if statement
        if ((clicks == 16) && (win == 0)) {
            //Pops up a MessageDialog telling the users there is a tie
            JOptionPane.showMessageDialog(null, "Tie");
            //Adds 1 to variable tie
            ties++;
            //Adds text to a string giving the exact date time, tie, how many clicks it took.
            contents = "[" + date.toString() + "]\nTie Game (" + clicks + " Clicks)\n\n";
            //Find file TicTacToeGame.txt
            try (FileWriter writer = new FileWriter("TicTacToeGame.txt", true)) {
                //Write to TicTacToeGame.txt our string contents
                writer.write(contents);
            } catch (IOException i) {
                i.printStackTrace();
            }
            //References tie from gui and sets the text to the updated ties int variable
            gui.tie.setText("   Ties: " + ties);

        }
    }

    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
