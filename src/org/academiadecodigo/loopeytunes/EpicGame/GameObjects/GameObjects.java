package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObjects {
    protected int score;
    private Picture picture;

    //Falta a picture
    public GameObjects(int score) {
        this.score = score;
    }

    public Picture getPicture(){
       return null;
    }

    public int getScore() {
        return score;
    }
}
