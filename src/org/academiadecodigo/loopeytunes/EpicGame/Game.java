package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.loopeytunes.EpicGame.Factorys.FoodFactory;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Character;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Game implements KeyboardHandler {
    private static final int DELAY = 2000;
    private static final int FOOD_TOTAL = 10;
    public static Food foodItem;
    private Character player1;
    private Character player2;
    private Text scorePlayer1;
    private Text scorePlayer2;
    private boolean gameOn = false;

    public void init() {
        Field.generateField();

    }

    public void start() throws InterruptedException {
        playerCreat();
        scoreAppear();
        startEngine();
    }

    public void startEngine() throws InterruptedException {
        commandsOn();
        while (!gameOn) {
            Thread.sleep(DELAY);
        }
        Field.HideStart();
        for (int i = 0; i < FOOD_TOTAL; i++) {
            playerAppear();
            scoreUpdate();


            Thread.sleep(DELAY);
            foodItem = FoodFactory.makeFood();
            Thread.sleep(DELAY / 2);

            foodItem.getPicture().delete();

        }

        if (player1.getScore() > player2.getScore()) {
            System.out.println("Player 1 wins");
            Field.playerOneVictory();
            return;
        }

        if (player1.getScore() == player2.getScore()) {
            System.out.println("It's a tie");
            Field.Draw();
            return;
        }

        System.out.println("Player 2 wins");
        Field.PlayerTwoVictory();

    }

    public void playerCreat() {
        player1 = new Character();
        player2 = new Character();
    }

    public void playerAppear() {
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

    public void scoreAppear() {
        scorePlayer1 = new Text(90, 50, "Score: " + player1.getScore());
        scorePlayer2 = new Text(1150, 50, "Score: " + player2.getScore());
        scorePlayer1.grow(40, 15);
        scorePlayer2.grow(40, 15);
        scorePlayer1.draw();
        scorePlayer2.draw();

    }

    public void scoreUpdate() {
        scorePlayer1.setText("Score: " + player1.getScore());
        scorePlayer2.setText("Score: " + player2.getScore());
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            gameOn();
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public void gameOn() {
        gameOn = true;
    }
}
