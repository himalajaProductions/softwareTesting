/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.discgolfapp.Main;
import static com.mycompany.discgolfapp.Main.players;
import com.mycompany.discgolfapp.Player;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import org.junit.Test;
import static org.junit.Assert.*;

public class JUnitTest {

    @Test
    public void PrintPlayerTest() {
        Player player = new Player("Jukka");
        player.AddScore(5);
        String correctPrint = "Jukka: 5";
        assertEquals(correctPrint, player.PrintScore());
    }
    
    @Test
    public void AddScoreTest() {
        Player player = new Player("Jukka");
        int score1 = 6;
        int score2 = 4;
        int score3 = 2;
        player.AddScore(score1);
        player.AddScore(score2);
        player.AddScore(score3);
        assertEquals(score1 + score2 + score3, player.Score());
    }
    
    @Test
    public void SortPlayersTest() {
        Player player1 = new Player("Jukka");
        Player player2 = new Player("Teppo");
        Player player3 = new Player("Martti");
        Main.players.add(player1);
        Main.players.add(player2);
        Main.players.add(player3);
        
        player1.AddScore(7);
        player2.AddScore(10);
        player3.AddScore(5);
        
        Collections.sort(players, new Main.SortPlayers());
        
        assertEquals(player3, Main.players.get(0));
        assertEquals(player1, Main.players.get(1));
        assertEquals(player2, Main.players.get(2));
    }
}
