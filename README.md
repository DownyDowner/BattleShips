# Battleship Console Game

This project is a classic Battleship game played in the console. Players take turns placing their ships on a grid, then try to guess the locations of each other’s ships. The first player to sink all of the opponent's ships wins!
Game Rules
    
Setup: Each player places 5 ships of varying sizes on a 10x10 grid. Ships cannot overlap or extend beyond the grid's boundaries.
Gameplay: Players alternate turns to "attack" coordinates on the opponent's grid, trying to locate and sink all the opponent's ships.
Winning: The game ends when a player has sunk all of the opponent's ships.

## How to Play

Run the game in a Java-compatible console.
Each player will be prompted to enter their name and place their ships on the grid.
During each turn, the player will be asked to input coordinates for their attack.
The game will display the results of each attack and notify players when a ship is hit or sunk.

## Project Structure

- Main.java: Handles user input and coordinates game flow.
- Game.java: Manages the game state, player turns, and win conditions.
- Player.java: Stores player data, including their name and personal grid.
- Ocean.java: Represents the player's grid where ships are placed and attacks are tracked.
- Boat.java: Represents a single ship with a name, size, and "health" (number of hits it can take).
- Cell.java: Represents individual cells in the Ocean grid, tracking occupancy and hit status.
- State Pattern: Implements different phases of the game (start, place ships, attack, and finish) to structure the game flow.
