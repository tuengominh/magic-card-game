package tech.bts.cardgame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
    }

    public void add (Card card){ deck.add(card); }

    public List<Card> getDeck() {
        return deck;
    }

    public void remove (Card card){
        deck.remove(card);
    }

    // toString

    public Deck generate() {

        for (int magicPoint = 1; magicPoint <= 8; magicPoint++) {

            //nested loop
            for (int strengthPoint = 1; strengthPoint <= (9 - magicPoint); strengthPoint++) {
                int intelligencePoint = 10 - magicPoint - strengthPoint;
                this.add(new Card(magicPoint, strengthPoint, intelligencePoint));
            }
        }
        return this;
    }

    public Deck shuffle() {

        Random random = new Random();

        for (int i = 0; i < this.deck.size() - 1; i++) {

            Card card1 = this.deck.get(i);
            Card card2 = this.deck.get(random.nextInt(deck.size()));

            this.deck.set(i, card1);
            this.deck.set(random.nextInt(deck.size()), card2);
        }

        return this;
    }

    public Card pickCard() {
        return this.deck.remove(deck.size() - 1);
    }

    public Hand deal(int dealSize) {

        Hand cards = new Hand();

        for (int i = 1; i<=dealSize; i++) {
            cards.keep(this.pickCard());
        }

        return cards;
    }

    public int deckSize() {
        return this.deck.size();
    }
}
