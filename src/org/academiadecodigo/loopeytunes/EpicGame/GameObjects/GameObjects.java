package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObjects {
    protected int score;
    protected Picture body;

    public GameObjects(int score, Picture body) {
        this.score = score;
        this.body = body;
        body.draw();
    }

    public Picture getPicture(){
       return body;
    }

    public int getScore() {
        return score;
    }
}
