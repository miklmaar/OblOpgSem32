package com.example.demo.util;

import com.example.demo.model.Game;
import com.example.demo.model.Player;
import com.example.demo.model.Review;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.ReviewRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class DummyData {
    GameRepository gameRepository;
    PlayerRepository playerRepository;
    ReviewRepository reviewRepository;

    public DummyData(GameRepository gameRepository, PlayerRepository playerRepository, ReviewRepository reviewRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
        this.reviewRepository = reviewRepository;
    }

    public void createDD(){
        Player player0 = createPlayer("Jeremiah von Bullfrog");
        Player player1 = createPlayer("Ignatas Konovalovas");
        Player player2 = createPlayer("Chela Chela");

        Game game0 = createGame("Dark Souls", player0, player1, player2);
        Game game1 = createGame("Tomb Raider", player1);
        Game game2 = createGame("Ratchet & Clank", player2);
        Game game3 = createGame("Grand Theft Auto", player2, player0);
        Game game4 = createGame("Resident Evil", player2, player1, player0);

        createReview(game0, player1, 100, "Best");
        createReview(game0, player2, 100,"Okay");
        createReview(game1, player1, 88, "A");
        createReview(game2, player2, 94, "B");
        createReview(game3, player0, 10, "C");
        createReview(game4, player0, 2, "D");
        createReview(game0, player0, 99, "E");
        createReview(game1, player0, 35, "F");
        createReview(game2, player0, 59, "DDK");
    }


    public Player createPlayer(String name){

        Player player = new Player();
        player.setName(name);

        playerRepository.save(player);

        return player;
    }

    public Game createGame(String title, Player... players){
        Set<Player> playersHasPlayed = new HashSet<>();

        for(int i=0; i<players.length; i++){
            playersHasPlayed.add(players[i]);
        }

        Game game = new Game();
        game.setTitle(title);
        game.setPlayers(playersHasPlayed);

        gameRepository.save(game);

        return game;
    }

    public Review createReview(Game game, Player player, int score, String reviewText){
        Review review = new Review();
        review.setGame(game);
        review.setPlayer(player);
        review.setScore(score);
        review.setReviewText(reviewText);

        reviewRepository.save(review);

        return review;
    }

}
