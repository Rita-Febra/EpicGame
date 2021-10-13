package org.academiadecodigo.loopeytunes.EpicGame.GameObjects;

public enum FoodType {
    GOOD,
    BAD;

    public static FoodType chooseType() {
        double odd = Math.random();

        return (odd <= 0.75) ? GOOD : BAD;
    }
}
