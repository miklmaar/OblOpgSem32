package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "player")
    public Set<Review> reviews;

    @ManyToMany(mappedBy = "players")
    public Set<Game> gamesPlayed;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Game> getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(Set<Game> gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

}
