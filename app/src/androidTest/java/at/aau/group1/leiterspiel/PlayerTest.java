package at.aau.group1.leiterspiel;

import org.junit.Test;

import at.aau.group1.leiterspiel.Game.BotPlayer;
import at.aau.group1.leiterspiel.Game.IPlayerObserver;
import at.aau.group1.leiterspiel.Game.LocalPlayer;
import at.aau.group1.leiterspiel.Game.Player;

import static org.junit.Assert.assertTrue;

public class PlayerTest {

    IPlayerObserver observer = new IPlayerObserver() {
        @Override
        public void move(int playerID, int diceRoll) {

        }

        @Override
        public int rollDice(int playerID) {
            return 0;
        }
    };

    @Test
    public void testIDs() {
        Player p0 = new BotPlayer(observer);
        Player p1 = new LocalPlayer(observer);
        assertTrue (p1.getPlayerID() == 1);

        Player.resetIDs();
        p1 = new BotPlayer(observer);
        assertTrue (p1.getPlayerID() == 0);
    }

    @Test
    public void testTypes() {
        Player p0 = new BotPlayer(observer);
        Player p1 = new LocalPlayer(observer);
        assertTrue (!p0.expectsTouchInput());
        assertTrue (p1.expectsTouchInput());
    }

}