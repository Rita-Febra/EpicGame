package org.academiadecodigo.loopeytunes.EpicGame.Factorys;

import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.FoodType;


public class FoodFactory {


    public static Food makeFood() {
        return (FoodType.chooseType() == FoodType.GOOD)
                ? new Food(20, "Pics/Avocado.png")
                : new Food(-10, "Pics/poop.png");

    }
}
