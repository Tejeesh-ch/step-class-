package week1.class_problems;

import java.util.Random;
import java.util.Scanner;

/**
 * Problem 1 - Rock-Paper-Scissors Game (Day 1 Live-Coding Session)
 *
 * The College Coding Arcade: several rounds between player and computer,
 * every outcome recorded, then a final scoreboard with wins, losses, draws
 * and the player's win percentage.
 */
public class RockPaperScissors {

    public static final int ROUNDS = 5;
    public static final String[] MOVES = { "Rock", "Paper", "Scissors" };

    /** Suggested signature: String playRound(String playerMove, String computerMove) */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            return "Invalid Move";
        }
        String player = playerMove.trim().toLowerCase();
        String computer = computerMove.trim().toLowerCase();

        if (!player.equals("rock") && !player.equals("paper") && !player.equals("scissors")) {
            return "Invalid Move";
        }
        if (player.equals(computer)) {
            return "Draw";
        }
        boolean playerWins =
                (player.equals("rock") && computer.equals("scissors"))
                        || (player.equals("paper") && computer.equals("rock"))
                        || (player.equals("scissors") && computer.equals("paper"));
        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static String generateComputerMove(Random random) {
        return MOVES[random.nextInt(MOVES.length)];
    }

    public static void main(String[] args) {
        Random random = new Random();
        String[] playerMoves = { "Rock", "Paper", "Scissors", "Rock", "Paper" };

        if (args.length > 0 && args[0].equalsIgnoreCase("interactive")) {
            Scanner scanner = new Scanner(System.in);
            playerMoves = new String[ROUNDS];
            for (int i = 0; i < ROUNDS; i++) {
                System.out.print("Round " + (i + 1) + " - your move (Rock/Paper/Scissors): ");
                playerMoves[i] = scanner.nextLine();
            }
            scanner.close();
        }

        String[] computerMoves = new String[ROUNDS];
        String[] results = new String[ROUNDS];
        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < ROUNDS; i++) {
            computerMoves[i] = generateComputerMove(random);
            results[i] = playRound(playerMoves[i], computerMoves[i]);
            System.out.println("Round " + (i + 1) + " -- Player: " + playerMoves[i]
                    + ", Computer: " + computerMoves[i] + "  ->  " + results[i]);

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else if (results[i].equals("Draw")) {
                draws++;
            }
        }

        System.out.println();
        System.out.println("+-------+--------------+----------------+----------------+");
        System.out.printf("| %-5s | %-12s | %-14s | %-14s |%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("+-------+--------------+----------------+----------------+");
        for (int i = 0; i < ROUNDS; i++) {
            System.out.printf("| %-5d | %-12s | %-14s | %-14s |%n",
                    (i + 1), playerMoves[i], computerMoves[i], results[i]);
        }
        System.out.println("+-------+--------------+----------------+----------------+");

        double winPercentage = (wins * 100.0) / ROUNDS;
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n",
                wins, losses, draws, winPercentage);
    }
}
