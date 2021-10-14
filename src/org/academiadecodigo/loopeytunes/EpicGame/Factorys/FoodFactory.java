package org.academiadecodigo.loopeytunes.EpicGame.Factorys;

import org.academiadecodigo.loopeytunes.EpicGame.Field;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.FoodType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class FoodFactory {



    public static Food makeFood(){
        return (FoodType.chooseType() == FoodType.GOOD)
                ? new Food(FoodType.GOOD, 20, "/Users/codecadet/Desktop/EpicGame/epicgame/Pics/Avocado.png")
                : new Food(FoodType.BAD, -10,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/poop.png");

    }
}
