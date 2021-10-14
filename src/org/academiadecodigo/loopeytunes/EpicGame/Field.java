package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private static final Picture FIELD = new Picture(10,10,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/Background.jpeg");
    private static final Picture GAME_OVER_SCREEN = new Picture(10,10,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/Background.jpeg");
    private static final Picture TAZ_WINS = new Picture();
    private static final Picture COYOTE_WINS = new Picture();
    private static final Picture TAZ_LOSES = new Picture();
    private static final Picture COYOTE_LOSES = new Picture();
    private static final Picture DRAW = new Picture();

    public static void generateField() {
        FIELD.draw();
    }

    public static void playerOneVictory(){
        GAME_OVER_SCREEN.draw();
        TAZ_WINS.draw();
        COYOTE_LOSES.draw();
        Text winner = new Text(620,250, "TAZ KILLED IT!!");
        winner.setColor(Color.PINK);
        winner.grow(400, 170);
        winner.draw();
    }

    public static void PlayerTwoVictory() {
        GAME_OVER_SCREEN.draw();
        COYOTE_WINS.draw();
        TAZ_LOSES.draw();
        Text winner = new Text(500,250, "COYOTE KILLED IT!!");
        winner.draw();
    }

    public static void Draw() {
        GAME_OVER_SCREEN.draw();
        DRAW.draw();
        Text winner = new Text(500,250, "IT'S A TIE!!");
        winner.draw();
    }
}