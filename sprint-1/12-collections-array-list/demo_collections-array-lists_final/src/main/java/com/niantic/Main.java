package com.niantic;

import com.niantic.cardgame.BlackJack;
import com.niantic.cardgame.BlackJackModified;

import java.util.ArrayList;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        BlackJack game = new BlackJack();
        game.play();

        System.out.println();

        String[] names = new String[]{"Wolverine", "Superman", "Captain America", "Black Widow", "Mystique"};
        ArrayList<String> myFavoriteHeroes = new ArrayList<>(Arrays.asList(names));
        BlackJackModified newGame = new BlackJackModified(myFavoriteHeroes);

        newGame.play(5);

        myFavoriteHeroes.add("Thor");
        myFavoriteHeroes.add("Iron Man");
        newGame = new BlackJackModified(myFavoriteHeroes);
        newGame.play(100);
    }
}