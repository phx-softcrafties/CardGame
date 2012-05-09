/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cardgame;

/**
 *
 * @author glassfish
 */
public class Card {
    public Integer value;

    public Card(Integer value) {
        this.value = value;
    }
    
    @Override
    public String toString(){
        return value.toString();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof Card) ? this.value == ((Card)other).value : false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.value != null ? this.value.hashCode() : 0);
        return hash;
    }
}
