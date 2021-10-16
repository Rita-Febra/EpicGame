package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

public class Food extends GameObjects {
    private boolean eaten;


    public Food(int score, String path) {
        super(score);
        changePic(550,285,path);

        body.grow(-50, -50);
        eaten = false;
    }

    public void getsEaten() {
        this.eaten = true;
        body.delete();
    }
    public boolean wasEaten(){
        return eaten;
    }
}
