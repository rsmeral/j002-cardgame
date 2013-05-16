package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Bet;
import cz.muni.fi.j002.cardgamee.model.BetType;
import cz.muni.fi.j002.cardgamee.model.Card;
import cz.muni.fi.j002.cardgamee.model.Game;
import cz.muni.fi.j002.cardgamee.model.GameState;
import cz.muni.fi.j002.cardgamee.model.Player;
import cz.muni.fi.j002.cardgamee.model.PlayerState;
import cz.muni.fi.j002.cardgamee.model.Round;
import java.math.BigDecimal;
import javax.inject.Singleton;

@Singleton
public class GameLogic {

    private static final BigDecimal BET_WIN_MULTIPLIER = new BigDecimal(1);

    public void start(Game game) {
        Round round = new Round();
        game.addRound(round);

        for (Player p : game.getPlayers()) {
            PlayerState ps = new PlayerState();
            ps.setPlayer(p);
            ps.setBalance(game.getInitialBalance());
            round.add(ps);
        }
        System.out.println("currentRoundIndex=" + game.getCurrentRoundIndex()
                + " roundSize=" + game.getRounds().size()
                + "\nCurrentCard=" + game.getCurrentCard()
                + " nextCard=" + game.getNextCard());

        round.setCard(game.getCurrentCard());
        game.setState(GameState.RUNNING);


        System.out.println("currentRoundIndex=" + game.getCurrentRoundIndex()
                + " roundSize=" + game.getRounds().size()
                + "\nCurrentCard=" + game.getCurrentCard()
                + " nextCard=" + game.getNextCard());
        System.out.println("======");

    }

    public void nextRound(Game game) {
        Card currentCard = game.getCurrentCard();
        Card nextCard = game.getNextCard();

        System.out.println("currentRoundIndex=" + game.getCurrentRoundIndex()
                + " roundSize=" + game.getRounds().size()
                + "\nCurrentCard=" + game.getCurrentCard()
                + " nextCard=" + game.getNextCard());

        // positive = higher, negative = lower, 0 = equal
        int diff = nextCard.getValue() - currentCard.getValue();
        // evaluate bets

        Round newRound = new Round();

        // evalute player states -- bets, balances, ..
        for (PlayerState oldPlayerState : game.getCurrentRound().getPlayerStates()) {
            PlayerState newPlayerState = new PlayerState();
            newPlayerState.setPlayer(oldPlayerState.getPlayer());
            BigDecimal newBalance = oldPlayerState.getBalance();
            if (diff != 0) { // not skipped
                BetType bt = oldPlayerState.getBet().getType();
                boolean correct = ((diff > 0) && bt == BetType.HIGHER) || ((diff < 0) && bt == BetType.LOWER);
                newBalance = getNewBalance(oldPlayerState, correct);
            } else { // skipped
                newPlayerState.setBet(oldPlayerState.getBet());
            }
            newPlayerState.setBalance(newBalance);
            newRound.add(newPlayerState);
        }

        // skip round if cards equal
        if (diff == 0) {
            newRound.setSkipped(true);
        }

        newRound.setCard(nextCard);
        game.addRound(newRound);

    }

    public void evaluateGame(Game game) {
        BigDecimal maxScore = new BigDecimal(0);
        Player winner = null;
        for (PlayerState lastState : game.getCurrentRound().getPlayerStates()) {
            if (lastState.getBalance().compareTo(maxScore) == 1) {
                maxScore = lastState.getBalance();
                winner = lastState.getPlayer();
            }
        }
        game.setScore(maxScore);
        game.setWinner(winner);
        game.setState(GameState.FINISHED);
    }

    private BigDecimal getNewBalance(PlayerState oldPlayerState, boolean correct) {
        if (correct) {
            return oldPlayerState.getBalance().add(oldPlayerState.getBet().getValue().multiply(BET_WIN_MULTIPLIER));
        } else {
            return oldPlayerState.getBalance().subtract(oldPlayerState.getBet().getValue());
        }
    }
}
