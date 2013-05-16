package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.*;

import java.util.*;

public class GameInitialization {

    private static int NUMBER_OF_PLAYERS = 2;

    public static void initialize(Game game) {

        List<Player> players = createPlayers(getNumberOfPlayers());
        game.setPlayers(players);

        game.setDeck(createDeck());

        List<Round> rounds = null;
        // initializeRounds(rounds); ??
        game.setRounds(rounds);

        game.setFinished(false);
        game.setState(GameState.NEW);

    }




    private static int getNumberOfPlayers() {
        return NUMBER_OF_PLAYERS;
    }


    private static List<Player> createPlayers(int numberOfPlayers) {
        List<Player> players = new ArrayList<Player>();
        for (int i = 0; i < numberOfPlayers; i++ ) {
            Player player = new Player();
            player.setName(getPlayerName(i));
            players.add(player);
        }
        return players;
    }


    private static String getPlayerName(int i) {
        //getPlayerName() if False ->
        return "Player " + i;
    }

    private static List<Card> createDeck() {
        List<Card> deck = new ArrayList<Card>();

        for (Card c : Card.values()) {
            System.out.println(c);
            deck.add(c);
        }

        Collections.shuffle(deck);
        System.out.println("Shuffled deck=" + deck);
        return deck;
    }

}
