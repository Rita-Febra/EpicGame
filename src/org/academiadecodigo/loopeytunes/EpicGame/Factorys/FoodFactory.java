package org.academiadecodigo.loopeytunes.EpicGame.Factorys;

import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.FoodType;


public class FoodFactory {

    public static Food makeFood() {
        switch (FoodType.chooseType()) {
            case GOOD:
                return new Food(20, "Pics/Avocado.png", FoodType.GOOD);
            case BAD:
                return new Food(-10, "Pics/poop.png", FoodType.BAD);
            case BOMB:
                return new Food(0, "Pics/bomb.png", FoodType.BOMB);
            default:
                return new Food(60, "Pics/SuperJuice.png", FoodType.SPECIAL);//most multiply to number of clicks
        }


    }
}