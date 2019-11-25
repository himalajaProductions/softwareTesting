package com.mycompany.discgolfapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<Player> players = new ArrayList<>();
    public static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);  // Create a Scanner object
        
        System.out.println("DISC GOLF SCORE COUNTER\n");
        System.out.println("Add players:\n");
        AddPlayers();
        System.out.println("\nGame:\n");
        Game();
        System.out.println("\nResults:\n");
        Results();
    }
    
    public static void AddPlayers() {
        int playerCounter = 1;
        while(true) {
            System.out.print("Enter player " + playerCounter + ". name: ");
            String name = scanner.nextLine();  // Read user input
            if(name.isEmpty()) {
                break;   // If empty input, stop adding players
            }
            Player player = new Player(name);
            players.add(player);
            playerCounter++;
        }        
    }
    
    public static void Game() {
        System.out.print("Number of tracks: ");
        String numberOfTracksString = scanner.nextLine();
        int numberOfTracks = Integer.parseInt(numberOfTracksString);
        for(int i = 0; i < numberOfTracks; i++) {
            System.out.println("\nTrack " + (i + 1) + ":");
            for(Player player : players) {
                System.out.print(player.Name() + " score: ");
                String scoreString = scanner.nextLine();
                int score = Integer.parseInt(scoreString);
                player.AddScore(score);
            }
        }
        
    }
    
    public static void Results() {
        Collections.sort(players, new SortPlayers());
        for(Player player : players) {
            System.out.println(player.PrintScore());
        }
    }
    
    public static class SortPlayers implements Comparator<Player> 
    { 
        // Used for sorting in ascending order of 
        // roll number 
        public int compare(Player a, Player b) 
        { 
            return a.Score() - b.Score();
        } 
    } 
}
