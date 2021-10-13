package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

import org.academiadecodigo.loopeytunes.EpicGame.Game;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Food extends GameObjects {
    private FoodType type;
    private boolean eaten;


    public Food(FoodType type, int score,String path) {
        super(score, new Picture(600, 400,path));
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
