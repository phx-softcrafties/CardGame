package cardgame;

import cardgame.exceptions.CardNotFoundException;
import cardgame.strategy.CardValuationStrategy;
import cardgame.strategy.DefaultEvaluationStrategy;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Player {
    public String name;
    private BlockingQueue<Card> hand = new LinkedBlockingQueue<Card>();
    private Deck drawDeck;
    private Deck discardDeck;
    private CardValuationStrategy evaluator;

    Player(String name) {
        this.name = name;
        this.evaluator = new DefaultEvaluationStrategy();
    }

    public void setDrawDeck(Deck drawDeck) {
        this.drawDeck = drawDeck;
    }

    public Deck getDrawDeck() {
        return this.drawDeck;
    }

    public void setDiscardDeck(Deck discardDeck){
        this.discardDeck = discardDeck;
    }

    public Deck getDiscardDeck(){
        return this.discardDeck;
    }

    public void setStrategy(CardValuationStrategy strategy){
        this.evaluator = strategy;
    }

    public CardValuationStrategy getStrategy() {
        return this.evaluator;
    }

    @Override
    public String toString() {
        return name;
    }

    void take(Card card) {
        hand.add(card);
    }

    public Boolean hasCard(Card toFind){
        return hand.contains(toFind);
    }

    public Integer howManyCards()
    {
        return hand.size();
    }

    public Boolean hasCards() {
        return !hand.isEmpty();
    }

    public void discardCard() throws InterruptedException, CardNotFoundException {
        Card removed = evaluator.evaluate(hand);
        boolean removedSuccessfully = hand.remove(removed);
        if(!removedSuccessfully){
            String message = String.format("The card %s could not be found", removed.toString());
            throw new CardNotFoundException(message);
        }

        discardDeck.addCard(removed);
    }

    public void draw(){
        Card card = drawDeck.take();
        take(card);
    }
}
