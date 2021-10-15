package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Field {
    private static final Picture FIELD = new Picture(10,10,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/Background.jpeg");
    private static final Picture GAME_OVER_SCREEN = new Picture(10,10,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/GameOver.png");
    private static final Picture TAZ_WINS = new Picture(550,420,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/TazWins.png");
    private static final Picture COYOTE_WINS = new Picture(550,270,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/CoyoteWins.png");
    private static final Picture TAZ_LOSES = new Picture(220,350,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/TazLoses.png");
    private static final Picture COYOTE_LOSES = new Picture(120,250,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/CoyoteLoses.png");
    private static final Picture TAZ_TIE = new Picture(200,380,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/TazTie.png");
    private static final Picture COYOTE_TIE = new Picture(820,160,"/Users/codecadet/Desktop/EpicGame/epicgame/Pics/CoyoteTie.png");

    public static void generateField() {
        FIELD.draw();
    }

    public static void playerOneVictory(){
        GAME_OVER_SCREEN.draw();
        TAZ_WINS.grow(40,60);
        TAZ_WINS.draw();
        COYOTE_LOSES.grow(-50,-80);
        COYOTE_LOSES.draw();
        Text shadow = new Text(643,292, "TAZ WINS!!");
        shadow.setColor(Color.BLACK);
        Text winner = new Text(640,290, "TAZ WINS!!");
        winner.setColor(Color.YELLOW);
        shadow.grow(280,60);
        winner.grow(280, 60);
        shadow.draw();
        winner.draw();

    }

    public static void PlayerTwoVictory() {
        GAME_OVER_SCREEN.draw();
        COYOTE_WINS.grow(-20,-60);
        COYOTE_WINS.draw();
        TAZ_LOSES.draw();
        Text shadow = new Text(643,292, "COYOTE WINS!!");
        shadow.setColor(Color.BLACK);
        Text winner = new Text(640,290, "COYOTE WINS!!");
        winner.setColor(Color.YELLOW);
        shadow.grow(280,60);
        winner.grow(280, 60);
        shadow.draw();
        winner.draw();
    }

    public static void Draw() {
        GAME_OVER_SCREEN.draw();
        TAZ_TIE.draw();
        COYOTE_TIE.grow(-60,-140);
        COYOTE_TIE.draw();
        Text shadow = new Text(643,292, "IT'S A TIE!!");
        shadow.setColor(Color.BLACK);
        Text winner = new Text(640,290, "IT'S A TIE!!");
        winner.setColor(Color.YELLOW);
        shadow.grow(280,60);
        winner.grow(280, 60);
        shadow.draw();
        winner.draw();
    }
}