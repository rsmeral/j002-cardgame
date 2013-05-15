package cz.muni.fi.j002.cardgamee.model;

public enum GameState {
    /**
     * Users are being added
     */
    NEW,
    
    /**
     * Players joined, game is running
     */
    RUNNING,
    
    /**
     * The deck was emptied, winner established, game can't be resumed
     */
    FINISHED
}
