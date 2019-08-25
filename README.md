# Rock Paper Scissors Lizard Spock + AI

This is an API and application that simulates the game Rock, Paper, Scissors, Lizard, Spock. You can read the rules of the game here: https://the-big-bang-theory.com/rock-paper-scissors-lizard-spock/.

This API allows two players to engage each other in a game of Rock, Paper, Scissors, Lizard, Spock. There are three types of players: 1) human, 2) computer, and 3) AI. The API allows developers to choose two players using any combination of the three types of players. 

The AI uses the recorded game history of the opponent to calculate a bias. If the opposing player is making a move more than 50% of the time, then the AI will choose a move that beats the identified bias. If the opposing player is playing a purely optimal randomized strategy, then the AI will also randomly choose a move.

## Getting Started

1a. Clone a copy of the source folder with eight .java files containing the various classes.
1b. An older version of the game (with and without a GUI) is contained in the src folder. This version can also be cloned and the following steps can be used to execute the game. 
2. Using a command prompt of your choice, navigate to the folder on your computer in which the .java files are containd and   compile the files.
3. Run a simulation of the program by executing java Game (The Game.java file contains a nested "main" class that can be used for adjusting the settings of the game, such as choosing the players and determining the number of games to be played). 

### Prerequisites And Installation

Java SDK:  https://www.oracle.com/technetwork/java/javase/downloads/index.html

## Authors

Caleb Kinmon  
Columbia University, 2020  
Computer Science, Intelligent Systems
