public class WarGameGroup02 {

    public static void main(String[] args) {
        // Create three players with their names and IDs
        Player p1 = new Player("John", 123);
        Player p2 = new Player("Ella", 234);
        Player p3 = new Player("ABC", 245);

        // Create a new WarGame instance with the three players
        WarGame warGame = new WarGame(p1, p2,p3);

        // Deal cards to the players
        warGame.dealCards();
        
        // Start the game
        warGame.playGame();
    }
    
}
