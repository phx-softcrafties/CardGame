/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgame;

import cardgame.strategy.CardValuationStrategy;
import java.util.Collection;

/**
 *
 * @author glassfish
 */
public class CardValuationStrategyStub implements CardValuationStrategy {

    public Card evaluate(Collection<Card> hand) {
        return new Card(3);
    }

}
