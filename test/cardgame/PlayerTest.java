/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgame;

import cardgame.exceptions.CardNotFoundException;
import cardgame.strategy.CardValuationStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author glassfish
 */
public class PlayerTest {

    public Player player;

    public PlayerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
        player = new Player("John");
        Deck drawDeck = new Deck();
        drawDeck.addCard(new Card(3));
        drawDeck.addCard(new Card(2));
        drawDeck.addCard(new Card(1));
        player.setDrawDeck(drawDeck);
        player.setDiscardDeck(new Deck());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testPlayerToString() {
        String expResult = "John";
        String result = player.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testPlayerHasCardGiven() {
        player.take(new Card(1));
        assertTrue(player.hasCard(new Card(1)));
    }

    @Test
    public void testPlayerCanTakeACard() {
        player.take(new Card(1));
        assertTrue(player.hasCards());
    }

    @Test
    public void testPlayerHasEmptyHand() {
        assertFalse(player.hasCards());
    }

    @Test
    public void testPlayerCanDiscardACard() throws InterruptedException, CardNotFoundException {

        player.take(new Card(1));
        player.discardCard();
        assertFalse(player.hasCard(new Card(3)));
    }

    @Test
    public void testPlayerDiscardsProperly() throws InterruptedException, CardNotFoundException {
        player.take(new Card(1));
        player.discardCard();
        int[] result = countsHandDrawDiscard();
        String message = String.format("countsHandDrawDiscard is %d %d %d", result[0], result[1], result[2]);
        assertArrayEquals(message, new int[] {0,3,1}, countsHandDrawDiscard());
    }

    private int[] countsHandDrawDiscard() {
            return new int[] {
                player.howManyCards(),
                player.getDrawDeck().howManyCards(),
                player.getDiscardDeck().howManyCards()
            };
    }

    @Test
    public void testPlayerDraw(){
        player.draw();
        assertArrayEquals(new int[] {1,2,0}, countsHandDrawDiscard());
    }

    @Test
    public void testSetStrategy(){        
        CardValuationStrategy strategy = new CardValuationStrategyStub();
        player.setStrategy(strategy);
        assertNotNull(player.getStrategy());
    }

    @Test
    public void testUseStubStrategy() throws CardNotFoundException{
        CardValuationStrategy strategy = new CardValuationStrategyStub();
        player.setStrategy(strategy);
        player.take(new Card(1));
        player.take(new Card(2));
        player.take(new Card(3));
        player.take(new Card(5));
        try {
            player.discardCard();
        } catch (InterruptedException ex) {
            Logger.getLogger(PlayerTest.class.getName()).log(Level.SEVERE, "Failed while discarding card.", ex);
        }
        Deck discardDeck = player.getDiscardDeck();
        assertEquals(new Card(3), discardDeck.take());
    }
}