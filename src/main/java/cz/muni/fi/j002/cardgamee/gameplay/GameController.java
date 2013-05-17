package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Game;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
@Named
public class GameController implements Serializable {

    private Game activeGame;

    private int numOfPlayers;

    @Inject
    private GameInitialization gi;

    @Inject
    private GameLogic gl;

    @Inject
    private GameRepository gr;

    @Inject
    private FacesContext facesContext;

    public String newGame() {
        // initialize users
        activeGame = new Game();
        // validate number of players
        if (gl.validatePositiveInput(BigDecimal.valueOf(numOfPlayers))) {
            gi.initialize(activeGame, numOfPlayers);
            gr.create(activeGame);
            return "newgame";
        } else {
            facesContext.addMessage(null, new FacesMessage("Enter at least one player."));
            return "gamelist";
        }
    }

    public String start() {
        // validate positivity of InitialBalance number
        if (gl.validatePositiveInput(activeGame.getInitialBalance())) {
            gl.start(activeGame);
            return "game";
        } else {
            facesContext.addMessage(null, new FacesMessage("You should really start with some money. ;-)"));
            return "newgame";
        }
    }

    public String finish() {
        gl.evaluateGame(activeGame);
        gr.save(activeGame);
        return "finish";
    }

    public String save() {
        gr.save(activeGame);
        return "gamelist";
    }

    public String load(Game game) {
        activeGame = gr.load(game);
        return "game";
    }

    public String replay(Game game) {
        activeGame = gr.load(game);
        activeGame.viewRound(1);
        return "game";
    }

    public void delete(Game game) {
        gr.delete(game);
    }

    public Game getActive() {
        return activeGame;
    }

    public void nextRound() {
        if (gl.validateBets(activeGame.getCurrentRound().getPlayerStates())) {
            gl.nextRound(activeGame);
        } else {
            facesContext.addMessage(null, new FacesMessage("All bets must be positive and less than balance"));
        }
    }

    public void viewNextRound() {
        activeGame.viewRound(activeGame.getCurrentRoundIndex() + 2);
    }

    public void viewPreviousRound() {
        activeGame.viewRound(activeGame.getCurrentRoundIndex());
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }
}
