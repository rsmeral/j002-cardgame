package cz.muni.fi.j002.cardgamee.gameplay;

import cz.muni.fi.j002.cardgamee.model.Game;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Stateful
@SessionScoped
@Named
public class GameController {
    
    private Game activeGame;
    
    public void newGame() {
        activeGame = new Game();
        
    }
    
    public void saveGame() {
        
    }
    
    public void loadGame(Game game) {
        
    }
}
