package tech.bts.cardgame;

import tech.bts.cardgame.model.Deck;
import tech.bts.cardgame.service.Game;

public class Example {

    public static void main(String[] args) {

        //1 - create prepareGame function
        Deck d = new Deck();
        d.generate();
        d.shuffle();
        System.out.println(d.deckSize());
        Game g = new Game(d);

        //2 - create pickingCards function
        g.join("John"); //join based on user's input
        g.join("Peter"); //join based on user's input

        g.pickCard("John");
        g.keep("John"); //keep or discard based on user's input

        g.pickCard("Peter");
        g.discard("Peter"); //keep or discard based on user's input

        g.pickCard("John");
        g.keep("John"); //keep or discard based on user's input

        g.pickCard("Peter");
        g.discard("Peter"); //keep or discard based on user's input

        g.pickCard("John");
        g.keep("John"); //keep or discard based on user's input

        //3 - create battle function
        //with a loop to execute nextBattle() & battle() while deck.deckSize() > 10

        int deckSize = d.deckSize();
        System.out.println(deckSize);
        System.out.println(g.getPlayerHand("John").handSize());
        System.out.println(g.getPlayerHand("Peter").handSize());

        g.battle("John", "Peter");
        System.out.println(deckSize);

        while(deckSize > Game.MINIMUM_DECK_SIZE){
            g.nextBattle();
            g.battle("john", "peter");
        }

        System.out.println(deckSize);


    }
}
