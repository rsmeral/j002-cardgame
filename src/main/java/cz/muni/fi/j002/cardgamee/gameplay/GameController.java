package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Card;
import cz.muni.fi.j002.cardgamee.model.Game;
import cz.muni.fi.j002.cardgamee.model.GameState;
import cz.muni.fi.j002.cardgamee.model.Player;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateful
@SessionScoped
@Named
public class GameController implements Serializable {

    private Game activeGame;
    
    public void newGame() {
        activeGame = new Game();

        // INITIALIZE PLAYERS, DECK
        if (activeGame.getState() == null || activeGame.getState() == GameState.NEW) {
            GameInitialization.initialize(activeGame);
        }



        
    }



    public void saveGame() {
        
    }
    
    public void loadGame(Game game) {
        
    }


}
