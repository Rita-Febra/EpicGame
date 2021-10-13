package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

public class Food extends GameObjects {
    private FoodType type;
    private boolean eaten;

    public Food(FoodType type, int score) {
        super(score);
        eaten =false;
        this.type = type;
        System.out.println("my type is " + type);
    }

    public void getsEaten() {
        this.eaten = true;
    }
    public boolean wasEaten(){
        return eaten;
    }
}
