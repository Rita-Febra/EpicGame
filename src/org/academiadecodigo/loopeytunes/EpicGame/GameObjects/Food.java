package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

public class Food extends GameObjects {
    private FoodType type;

    public Food(FoodType type, int score) {
        super(score);
        this.type = type;
        System.out.println("my type is " + type);
    }
}
