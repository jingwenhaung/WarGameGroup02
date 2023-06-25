import java.util.ArrayList;
import java.util.List;

public class WarGame {
    private List<Player> players;
    private Deck deck;
    private int counter;

    public WarGame(Player... players) {
        this.players = new ArrayList<>();
        for (Player player : players) {
            registerPlayer(player);
        }
        deck = new Deck();
        counter = 0;
    }

    public void registerPlayer(Player player) {
        players.add(player);
    }

    // Deal cards to all the players
    public void dealCards() {
        int numPlayers = players.size();
        int numCards = deck.getSize() / numPlayers;

        for (Player player : players) {
            for (int i = 0; i < numCards; i++) {
                Card card = deck.removeCard();
                player.addCardToHand(card);
            }
        }
    }
    
    public void playGame() {
        // playing for 10 rounds
        while (counter < 10) {
            List<Card> cardsOnTable = new ArrayList<>();
            int maxCardValue = 2;
            Player winner = null;
            boolean isWar = false;
            // Count the round
            counter++;

            // Each player is shows their top card
            for (Player p : players) {
                if (p.hasCards()) {
                    Card card = p.showCard();
                    System.out.println(p.getName() + " " + card);
                    cardsOnTable.add(card);

                    // compare the value of each player's card
                    // Ex: Ace is 14, King is 13, etc.

                    int cardValue = card.getValue().getValue();

                    // Compare each player's card with the default number 2.
                    // If a player's card value is greater than the current maxCardValue,
                    // update the maxCardValue and set the winner to the current player.
                    // If the player's card value is equal to the maxCardValue, it's a war.
                    if (cardValue > maxCardValue) {
                        maxCardValue = cardValue;
                        winner = p;
                        isWar = false;
                    } else if (cardValue == maxCardValue) {
                        isWar = true;
                    }
                }
            }

            if (isWar) {
                System.out.println("War!");

                // Each player place three cards facing down
                for (Player player : players) {
                    if (player.hasCards()) {
                        for (int i = 0; i < 3; i++) {
                            if (player.hasCards()) {
                                Card warCard = player.showCard();
                                cardsOnTable.add(warCard);
                            }
                        }
                    }
                }

                // The winner of the war is determined by checking the fourth card
                playGame();
            } else {
                // Winner collects all the cards on the table
                for (Card card : cardsOnTable) {
                    winner.addCardToHand(card);
                }

                 // Update the scores for the winner and display the message indicating the winner of the round

                winner.setScores(winner.getScores()+1);
                System.out.println(counter + " round: " + winner.getName() + " win.");
                System.out.println("-------------------------------------------");
            }
        }

        Player winner = getWinner();
        
        // Communicate the loss to all players except the winner
        for (Player player : players) {
            if (player.getId() != winner.getId()){
                communicateLoss(player);
            }
        }   
        communicateWin(winner);

        printPlayerStatus();
    }

    // Get the winner of the game based on the player with the most cards
    private Player getWinner() {
        Player winner = players.get(0);
        int maxCards = winner.getHand().size();

        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            int numCards = player.getHand().size();

            if (numCards > maxCards) {
                winner = player;
                maxCards = numCards;
            } else if (numCards == maxCards) {
                winner = null;
            }
        }

        return winner;
    }

    public void communicateWin(Player player) {
        System.out.println("Congratulations, " + player.getName() 
            + "! You won the game!");
    }

    public void communicateLoss(Player player) {
        System.out.println("Sorry, " + player.getName() 
            + ". You lost the game.");
    }

    public void printPlayerStatus() {
        System.out.println("Player Status:");
        for (Player player : players) {
            System.out.println(player.toString());
        }
    }
}

