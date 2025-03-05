package com.example.big2.play;

import com.example.big2.card.Card;
import com.example.big2.game.Game;
import com.example.big2.player.Player;

import java.util.List;

public class PlayCardHandler extends PlayHandler {


        public PlayCardHandler(PlayHandler next) {
            super(next);
        }

        @Override
        public void handle(Player player, List<Card> inputCards, Game game) {
            if (inputCards != null && !inputCards.isEmpty()) {
                player.getHandCards().removeAll(inputCards);
                game.setTopPlay(inputCards.get(0));
                game.setLastPlayedPlayer(player);
                game.resetPassCount();
                System.out.printf("Player %s plays %s\n", player.getName(), inputCards);
            } else if (next != null) {
                next.handle(player, inputCards, game);
            }
        }

}
