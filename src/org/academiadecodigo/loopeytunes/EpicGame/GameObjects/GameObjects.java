package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameObjects {
    protected int score;
    protected Picture body;

    public GameObjects(int score) {
        this.score = score;
    }

    public void changePic(int col,int row,String src) {
        if (body != null) {
            body.delete();
        }

        body = new Picture(col, row, src);
        body.draw();
    }

    public Picture getPicture() {
        return body;
    }

    public int getScore() {
        return score;
    }
}
