package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

import org.academiadecodigo.loopeytunes.EpicGame.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Food extends GameObjects {
    private FoodType type;
    private boolean eaten;


    public Food(FoodType type, int score, String path) {
        super(score, 550,285,path);
        body.grow(-50, -50);
        eaten =false;
        this.type = type;
        System.out.println("my type is " + type);
    }

    public void getsEaten() {
        this.eaten = true;
        body.delete();
    }
    public boolean wasEaten(){
        return eaten;
    }
}
