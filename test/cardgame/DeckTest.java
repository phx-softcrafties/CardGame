/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgame;

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
public class DeckTest {

    public DeckTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class Deck.
     */
    @Test
    public void testEmptyDeckToString() {
        Deck instance = new Deck();
        String expResult = "top:[]:bottom";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testDeckToString() {
        Deck deck = new Deck();
        deck.addCard(new Card(3));
        String expResult = "top:[3]:bottom";
        String result = deck.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testDeckTwoCards(){
        Deck deck = new Deck();
        deck.addCard(new Card(3));
        deck.addCard(new Card(4));
        String expResult="top:[4, 3]:bottom";
        String result = deck.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testDeckTakeCard(){
        Deck deck = new Deck();
        deck.addCard(new Card(3));
        deck.addCard(new Card(4));

        Card card = deck.take();
        
        assertEquals(card, new Card(4));
    }
}