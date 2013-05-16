package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Game;
import java.io.Serializable;
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

    public String newGame() {
        // initialize users
        activeGame = new Game();
        gi.initialize(activeGame, numOfPlayers);
        gr.create(activeGame);
        return "newgame";
    }

    public String start() {
        gl.start(activeGame);
        return "game";
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
        activeGame = game;
        return "game";
    }

    public void delete(Game game) {
        gr.delete(game);
    }

//    public void replay(Game game) {
//        // TODO
//    }
    public Game getActive() {
        return activeGame;
    }

    public void nextRound() {
        gl.nextRound(activeGame);
    }

    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    public void setNumOfPlayers(int numOfPlayers) {
        this.numOfPlayers = numOfPlayers;
    }
}
