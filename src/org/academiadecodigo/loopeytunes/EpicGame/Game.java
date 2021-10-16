package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.loopeytunes.EpicGame.Factorys.FoodFactory;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Character;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {
    private static final int DELAY = 2000;
    private static final int FOOD_TOTAL = 10;
    public static Food foodItem;
    private Character player1;
    private Character player2;
    private Text[] scoreText;
    Text scorePlayer1;
    Text scorePlayer1Shadow;
    Text scorePlayer2;
    Text scorePlayer2Shadow;

    public void init() {
        Field.generateField();

    }

    public void start() throws InterruptedException {
        playersCreation();
        scoreAppearence();
        startEngine();
    }

    public void startEngine() throws InterruptedException {
        commandsOn();

        for (int i = 0; i < FOOD_TOTAL; i++) {
            playersAppearence();
            scoreUpdate();


            Thread.sleep(DELAY);
            foodItem = FoodFactory.makeFood();
            Thread.sleep(DELAY / 2);

            foodItem.getPicture().delete();

        }
        gameOver();
    }

    public void playersCreation() {
        player1 = new Character(0, 230, 350, "Pics/Taz2.png");
        player2 = new Character(0, 870, 350, "Pics/coyote2.png");
    }

    public void playersAppearence() {
        player1.changePic(230, 350, "Pics/Taz2.png");
        player2.changePic(870, 350, "Pics/coyote2.png");
    }

    public void commandsOn() {
        Keyboard kbPlayer1 = new Keyboard(player1);
        KeyboardEvent aPressed = new KeyboardEvent();
        setCommands(aPressed, KeyboardEvent.KEY_A);

        Keyboard kbPlayer2 = new Keyboard(player2);
        KeyboardEvent kPressed = new KeyboardEvent();
        setCommands(kPressed, KeyboardEvent.KEY_K);

        kbPlayer1.addEventListener(aPressed);
        kbPlayer2.addEventListener(kPressed);

    }

    public void setCommands(KeyboardEvent keyboardEventName, int keyboardEvent) {
        keyboardEventName.setKey(keyboardEvent);
        keyboardEventName.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

    }

    public void scoreAppearence() {
        scorePlayer1Shadow = new Text(93, 51, "Score: " + player1.getScore());
        scorePlayer1 = new Text(90, 50, "Score: " + player1.getScore());
        scorePlayer2Shadow = new Text(1153, 51, "Score: " + player2.getScore());
        scorePlayer2 = new Text(1150, 50, "Score: " + player2.getScore());
        scoreText = new Text[]{scorePlayer1Shadow, scorePlayer1, scorePlayer2Shadow, scorePlayer2};

        for (int i = 0; i < 4; i++) {
            Text text = scoreText[i];
            text.grow(40, 15);
            if (i%2!=0){
                text.setColor(Color.YELLOW);
            }
            text.draw();
        }
    }

    public void scoreUpdate() {
        scorePlayer1.setText("Score: " + player1.getScore());
        scorePlayer1Shadow.setText("Score: " + player1.getScore());
        scorePlayer2.setText("Score: " + player2.getScore());
        scorePlayer2Shadow.setText("Score: " + player2.getScore());
    }

    private void gameOver(){
        if (player1.getScore() > player2.getScore()) {
            System.out.println("Player 1 wins");
            Field.playerOneVictory();
            return;
        }

        if (player1.getScore() == player2.getScore()) {
            System.out.println("It's a tie");
            Field.tie();
            return;
        }

        System.out.println("Player 2 wins");
        Field.playerTwoVictory();
    }
}
