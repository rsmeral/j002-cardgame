package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.*;
import java.util.*;
import javax.inject.Singleton;

@Singleton
public class GameInitialization {

    public void initialize(Game game, int numOfPlayers) {
        game.setPlayers(createPlayers(numOfPlayers));
        game.setDeck(createRandomDeck());
        game.setDateStarted(new Date());
    }

    private List<Player> createPlayers(int numberOfPlayers) {
        List<Player> players = new ArrayList<Player>();
        for (int i = 1; i <= numberOfPlayers; i++) {
            Player player = new Player();
            player.setName(defaultName(i));
            players.add(player);
        }
        return players;
    }

    private String defaultName(int i) {
        //getPlayerName() if False ->
        return "Player " + i;
    }

    private List<Card> createRandomDeck() {
        List<Card> deck = new ArrayList<Card>();

        for (Card c : Card.values()) {
            deck.add(c);
        }
        Collections.shuffle(deck);
        return deck;
    }
}
