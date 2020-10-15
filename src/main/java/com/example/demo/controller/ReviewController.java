package com.example.demo.controller;

import com.example.demo.repository.GameRepository;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewController {
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @PostMapping("/review")
    public String showReview(@RequestParam int gameID,
                             Model model){
        model.addAttribute("game", gameRepository.findById(gameID).get());
        return "review";
    }
}
