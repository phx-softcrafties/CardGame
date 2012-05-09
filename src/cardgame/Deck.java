/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgame;

import java.util.concurrent.LinkedBlockingDeque;
/**
 *
 * @author glassfish
 */
public class Deck {
    LinkedBlockingDeque<Card> cards = new LinkedBlockingDeque<Card>();


    @Override
    public String toString() {
        String result = "top:[";
        for(Card theCard : cards)
        {
            result += theCard.toString()+", ";
        }
        if(!cards.isEmpty())
        result = result.substring(0, result.length()-2);

        return result+"]:bottom";
    }

    public Integer howManyCards(){
        return cards.size();
    }
    void addCard(Card card) {
        cards.push(card);
    }
    public Card take()    {
        return cards.pop();
    }
}
