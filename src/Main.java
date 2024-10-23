import java.util.Random;
import java.util.Scanner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static JFrame homeScreen = new JFrame("Home");
    static JFrame spScreen = new JFrame("Single Player");
    static JFrame mpScreen = new JFrame("Muliplayer");
    static JPanel panel = new JPanel();
    static JPanel buttonPanelLeft = new JPanel();
    static JPanel buttonPanelRight = new JPanel();

    static JLabel label = new JLabel("");
    static JLabel label2 = new JLabel("");
    static JLabel label3 = new JLabel("");

    static JButton multiplayer = new JButton("Multiplayer");
    static JButton singleplayer = new JButton("Singleplayer");

    static JButton rock1 = new JButton("Rock");
    static JButton rock2 = new JButton("Rock");

    static JButton paper1 = new JButton("Paper");
    static JButton paper2 = new JButton("Paper");

    static JButton scissors1 = new JButton("Scissors");
    static JButton scissors2 = new JButton("Scissors");

    static JButton cont = new JButton("Continue");
    static JButton exit = new JButton("Exit"); //initialize all the jframe elements that will be used

    static int userScore1 = 0, userScore2 = 0, computerScore = 0;
    static String player1; //initializing important variables

    public static void main(String args[]) {
        GUIinit(); //runs GUIinit
    }

    public static void GUIinit() {//creates the homescreen and populates it with the needed buttons
        resetScreen();
        homeScreen.setSize(400, 400);
        homeScreen.setLocationRelativeTo(null);
        homeScreen.setVisible(true); //create window

        singleplayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                singleplayer();
            }
        });
        singleplayer.setVisible(true);
        panel.add(singleplayer);

        multiplayer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                multiplayer();
            }
        });
        multiplayer.setVisible(true);
        panel.add(multiplayer); //add the single player and multiplayer buttons

        homeScreen.getContentPane().add(panel);
        homeScreen.setVisible(true); //update window
    }

    public static void resetScreen() { //completely reset the window
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
    }

    public static void gameOver() { //game ends, resets scores and gives option to continue or restart
        System.out.println("game over");
        userScore1 = 0;
        userScore2 = 0;
        computerScore = 0; //reset the scores

        cont.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GUIinit();
            }
        });
        panel.add(cont);
        cont.setVisible(true);

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                homeScreen.dispose();
            }
        });
        panel.add(exit);	//add continue and exit buttons
    }

    public static void singleplayer() { //initialized singleplayer
        resetScreen();

        label.setText("");
        rock1 = new JButton("Rock");
        paper1 = new JButton("Paper");
        scissors1 = new JButton("Scissors"); //clears window and reset buttons

        rock1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spGame("rock");
            }
        });
        panel.add(rock1);
        rock1.setVisible(true);

        paper1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spGame("paper");
            }
        });
        panel.add(paper1);
        paper1.setVisible(true);

        scissors1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                spGame("scissors");
            }
        });
        panel.add(scissors1);
        scissors1.setVisible(true); //add all the buttons and an onclick that runs the singleplayer version of the game with the respective input

        panel.add(label);
        homeScreen.getContentPane().add(panel);
        homeScreen.setVisible(true); //add label and update window
    }

    public static void spGame(String input) { //actual checks for who wins the round and if the game has been won
        Random rand = new Random();

        String[] computer= {"rock", "paper", "scissors"};
        int randInt = rand.nextInt();

        System.out.print("Make your choice: rock, paper, or scissors: ");

        randInt = rand.nextInt(3);

        if(input.equals(computer[randInt])) {
            System.out.println("You played " + input + " your opponent played " + computer[randInt] + " you have tied.");
            label.setText("<html><body style=\"height: 150px; width: 400px;text-align: center;\"><p>You played " + input + " your opponent played " + computer[randInt] + " you have tied.</p></body></html>");
        } else if((input.equals("rock") && computer[randInt].equals("scissors")) || (input.equals("scissors") && computer[randInt].equals("paper")) || (input.equals("paper") && computer[randInt].equals("rock"))) {
            System.out.println("You played " + input + " your opponent played " + computer[randInt] + " you have won.");
            label.setText("<html><body style=\"height: 150px; width: 400px;text-align: center;\"><p>You played " + input + " your opponent played " + computer[randInt] + " you have won.</p></body></html>");
            ++userScore1;
        } else if((input.equals("rock") && computer[randInt].equals("paper")) || (input.equals("scissors") && computer[randInt].equals("rock")) || (input.equals("paper") && computer[randInt].equals("scissors"))) {
            System.out.println("You played " + input + " your opponent played " + computer[randInt] + " you have lost.");
            label.setText("<html><body style=\"height: 150px; width: 400px;text-align: center;\"><p>You played " + input + " your opponent played " + computer[randInt] + " you have lost.</p></body></html>");
            ++computerScore;
        } else {
            System.out.println("Please enter \"rock\", \"paper\", or \"scissors\"");
        } //compares the random computer value to the chosen user value and determines winner

        if(userScore1 > 2 || computerScore > 2) { //checks if game has ended
            rock1.setVisible(false);
            paper1.setVisible(false);
            scissors1.setVisible(false); //hides buttons
            if(userScore1 == 3) { //checks who won
                System.out.println("You have won " + userScore1 + " to " + computerScore + "!");
                label.setText("<html><body style=\"height: 150px; width: 400px;text-align: center;\"><p>You have won " + userScore1 + " to " + computerScore + "!<br></p>"
                        + "    ⠀					⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⢰⡟⢉⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⣿⡉⢻⡆⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⢸⡆⠀⠁⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠈⠀⢰⡇⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⢿⣄⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⣠⡿⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠻⣦⣄⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⣠⣴⠟⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠙⠻⠶⠄⠙⢿⣿⣿⣿⣿⡿⠋⠠⠶⠟⠋⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠘⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⢠⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣼⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣿⠋⠉⠉⠉⠉⠉⠉⠙⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣿⣄⣀⣀⣀⣀⣀⣀⣠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
                        + "</p</body></html>");
            } else if (computerScore == 3) {
                System.out.println("You have lost " + userScore1 + " to " + computerScore + "!");
                label.setText("<html><body style=\"height: 150px; width: 400px;text-align: center;\"><p>You have lost " + userScore1 + " to " + computerScore + "!</p></body></html>");
            } else {
                System.out.println("Yo some shit went down idfk what happened...");
            } //declares which party has won
            gameOver(); //runs gameOver()
        }
    }

    public static void multiplayer() { //initializes the multiplayer ui
        resetScreen();

        panel.add(label);
        label.setText("<html>player 1<br><br><br>player 2</html>");

        rock1 = new JButton("Rock");
        paper1 = new JButton("Paper");
        scissors1 = new JButton("Scissors");
        rock2 = new JButton("Rock");
        paper2 = new JButton("Paper");
        scissors2 = new JButton("Scissors"); //clear the screen, reinitialize the buttons

        rock1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player1 = "rock";
            }
        });
        panel.add(rock1);
        rock1.setVisible(true);

        paper1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player1 = "paper";
            }
        });
        panel.add(paper1);
        paper1.setVisible(true);

        scissors1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player1 = "scissors";
            }
        });
        panel.add(scissors1);
        scissors1.setVisible(true);

        panel.add(label2);
        label2.setText("<html><body><p><br>&emsp&emsp&emsp</p></body></html>");

        rock2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player1 == null) {
                    label3.setText("<html><body style=\"text-align: center;\">Please have player 1 select their choice first.");
                } else {
                    mpGame(player1, "rock");
                }
            }
        });
        panel.add(rock2);
        rock2.setVisible(true);

        paper2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player1 == null) {
                    label3.setText("<html><body style=\"text-align: center;\">Please have player 1 select their choice first.</body></html>");
                } else {
                    mpGame(player1, "paper");
                }
            }
        });
        panel.add(paper2);
        paper2.setVisible(true);

        scissors2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(player1 == null) {
                    label3.setText("<html><body style=\"text-align: center;\">Please have player 1 select their choice first.");
                } else {
                    mpGame(player1, "scissors");
                }
            }
        });
        panel.add(scissors2);
        scissors2.setVisible(true); //add all the buttons and labels in order and check to make sure player 1 selects a choice first so code doesnt break

        panel.add(label3);

        homeScreen.getContentPane().add(panel);
        homeScreen.setSize(400, 400);
        homeScreen.setVisible(true); //update window
    }

    public static void mpGame(String input1, String input2) { //run the multiplayer version of the game
        System.out.print("Make your choice: rock, paper, or scissors: ");

        if(input1.equals(input2)) {
            System.out.println("You played " + input1 + " your opponent played " + input2 + " you have tied.");
            label3.setText("<html><body style=\"text-align: center;\">Player 1 played " + input1 + ", Player 2 played " + input2 + " you have tied.</body></html>");
        } else if((input1.equals("rock") && input2.equals("scissors")) || (input1.equals("scissors") && input2.equals("paper")) || (input1.equals("paper") && input2.equals("rock"))) {
            System.out.println("You played " + input1 + " your opponent played " + input2 + " you have won.");
            label3.setText("<html><body style=\"text-align: center;\">Player 1 played " + input1 + ", Player 2 played " + input2 + " Player 1 wins.</body></html>");
            ++userScore1;
        } else if((input1.equals("rock") && input2.equals("paper")) || (input1.equals("scissors") && input2.equals("rock")) || (input1.equals("paper") && input2.equals("scissors"))) {
            System.out.println("Player 1 played " + input1 + ", Player 2 played " + input2 + " you have lost.");
            label3.setText("<html><body style=\"text-align: center;\">Player 1 played " + input1 + " player 2 played " + input2 + " Player 2 wins.</body></html>");
            ++userScore2;
        } else {
            System.out.println("Please enter \"rock\", \"paper\", or \"scissors\"");
        } //check the two user inputs to see who won

        if(userScore1 > 2 || userScore2 > 2) { //determine that the game has ended
            label3.setText(null);
            rock1.setVisible(false);
            paper1.setVisible(false);
            scissors1.setVisible(false);
            rock2.setVisible(false);
            paper2.setVisible(false);
            scissors2.setVisible(false); //hide the buttons

            if(userScore1 == 3) { //determine who won
                System.out.println("You have won " + userScore1 + " to " + userScore2 + "!");
                label.setText("<html><body style=\"height: 150px; width: 400px;text-align: center;\"><p>Player 1 has won " + userScore1 + " to " + userScore2 + "!<br></p>"
                        + "    ⠀					⢀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⢰⡟⢉⣿⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⣿⡉⢻⡆⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⢸⡆⠀⠁⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠈⠀⢰⡇⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⢿⣄⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⣠⡿⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠻⣦⣄⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⣠⣴⠟⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠙⠻⠶⠄⠙⢿⣿⣿⣿⣿⡿⠋⠠⠶⠟⠋⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⠘⠛⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⢠⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣼⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⢀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣿⠋⠉⠉⠉⠉⠉⠉⠙⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀ ⠀⠀⣿⣄⣀⣀⣀⣀⣀⣀⣠⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀<br>"
                        + "		           ⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀"
                        + "</p</body></html>");
            } else if (userScore2 == 3) {
                System.out.println("You have lost " + userScore1 + " to " + userScore2 + "!");
                label.setText("<html><body style=\"height: 150px; width: 400px;text-align: center;\"><p>Player 1 has lost " + userScore1 + " to " + userScore2 + "!");
            } else {
                System.out.println("Yo some shit went down idfk what happened...");
            }
            gameOver(); //run gameOver()
        }
        player1 = null; //reset this value so that player1 has to choose before this code gets rerun, avoids player 2 spamming through before player 1 can choose again.
    }
}
