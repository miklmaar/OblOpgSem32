package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.model.Player;
import com.example.demo.model.Review;
import com.example.demo.repository.GameRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.util.DummyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/")
    public String index (Model model){
        getDummyData();

        Iterable<Game> games = gameRepository.findAll();

        for(Game game : games){

        }

        model.addAttribute("games", games);

        return "games";
    }


    //
    //
    //Make dummy data fun
    //
    //
    private void getDummyData(){
        DummyData dd = new DummyData(gameRepository, playerRepository, reviewRepository);
        dd.createDD();

    }


}
