package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;


import org.academiadecodigo.loopeytunes.EpicGame.Game;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Character extends GameObjects implements KeyboardHandler {
    private CharactersType type;

    public Character(CharactersType type) {
        super(0);
        this.type = type;
    }

    // keyboardSetKey()


    public void eat(int score) {
        System.out.println(type + " " + this.score);
        this.score += score;
        System.out.println(type + " " + this.score);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            eat(Game.foodItem.score);
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_K) {
            eat(Game.foodItem.score);
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
