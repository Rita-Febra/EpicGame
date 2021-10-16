package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.Locale;

public class Field {
    private static final Picture FIELD = new Picture(10,10,"Pics/Background.jpeg");
    private static final Picture GAME_OVER_SCREEN = new Picture(10,10,"Pics/GameOver.png");
    private static final Picture TAZ_WINS = new Picture(550,420,"Pics/TazWins.png");
    private static final Picture COYOTE_WINS = new Picture(550,270,"Pics/CoyoteWins.png");
    private static final Picture TAZ_LOSES = new Picture(220,350,"Pics/TazLoses.png");
    private static final Picture COYOTE_LOSES = new Picture(120,250,"Pics/CoyoteLoses.png");
    private static final Picture TAZ_TIE = new Picture(200,380,"Pics/TazTie.png");
    private static final Picture COYOTE_TIE = new Picture(820,160,"Pics/CoyoteTie.png");

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

    public static void playerTwoVictory() {
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

    public static void tie() {
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

    public static void drawText(String text, int col, int row,int growCol,int growRow,Color color){
        Text shadow = new Text(col+3,row+2,text.toUpperCase(Locale.ROOT));
        Text  stringText = new Text(col,row,text.toUpperCase(Locale.ROOT));
        shadow.setColor(Color.BLACK);
        stringText.setColor(color);
        shadow.grow(growCol,growRow);
        stringText.grow(growCol,growRow);
        shadow.draw();
        stringText.draw();
    }
}