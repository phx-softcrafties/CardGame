/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgame.strategy;

import cardgame.Card;
import java.util.Collection;

/**
 *
 * @author glassfish
 */
public interface CardValuationStrategy {
    Card evaluate(Collection<Card> hand);
}
