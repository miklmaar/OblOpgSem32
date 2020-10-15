package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Player;
import com.example.demo.model.Review;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;

@Controller
public class GameController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/addGame")
    public String addGame(){
        return "addGame";
    }

    @PostMapping("/saveGame")
    public String saveGame(@RequestParam String title){
        Game game = new Game();

        game.setTitle(title);
        game.setPlayers(new HashSet<Player>());
        game.setReviews(new HashSet<Review>());

        gameRepository.save(game);

        return "redirect:/";
    }
}
