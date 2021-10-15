package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;


import org.academiadecodigo.loopeytunes.EpicGame.Game;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Character extends GameObjects implements KeyboardHandler {

    public Character() {
        super(0, 0,0,"Pics/Taz2.png");
    }

    public void eat(int score,int col, int row, String path) {
        changePic(col,row,path);
        this.score += score;
        Game.foodItem.getsEaten();

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            if (!Game.foodItem.wasEaten()) {
                eat(Game.foodItem.score, 230,350 ,"Pics/Taz1.png");
            }
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_K) {
            if (!Game.foodItem.wasEaten()) {
                eat(Game.foodItem.score, 680, 350,"Pics/Coyote1.png");
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
