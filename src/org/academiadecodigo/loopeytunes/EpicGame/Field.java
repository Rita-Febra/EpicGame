package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private static final int MIN_X = 0;
    private static final int MAX_X = 0;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 0;
    private static final Picture FIELD = new Picture(10,10,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/Background.jpeg");
    private static Picture playerOne = new Picture();
    private static Picture playerTwo = new Picture();
    private static Picture FOOD = new Picture();

    public static void generateField() {

        FIELD.draw();
    }

    //nos argumentos do grow ajustamos as dimensões das imagens
    public static void generatePlayers() {
        //playerOne.grow();
        playerOne.draw();

        //playerTwo.grow(0,0);
        playerTwo.draw();
    }

    public static void generateFood() {
        //FOOD.grow();
        FOOD.draw();
    }

}