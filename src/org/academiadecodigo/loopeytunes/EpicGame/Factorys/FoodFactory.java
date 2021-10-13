package org.academiadecodigo.loopeytunes.EpicGame.Factorys;

import org.academiadecodigo.loopeytunes.EpicGame.Field;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.FoodType;

public class FoodFactory {

    public static Food makeFood(){
        return (FoodType.chooseType() == FoodType.GOOD)
                ? new Food(FoodType.GOOD, 20)
                : new Food(FoodType.BAD, -10);
    }
}
