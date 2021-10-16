package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.loopeytunes.EpicGame.Factorys.FoodFactory;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Character;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.FoodType;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Game implements KeyboardHandler {
    private static final int MAXDELAY = 2000;
    private static final int MINDELAY = 1000;
    private static final int FOOD_TOTAL = 10;
    private final Field field;
    private static Food foodItem = new Food(0, "Pics/Transparent.png", FoodType.GOOD);
    private Character player1;
    private Character player2;
    private Text scorePlayer1;
    private Text scorePlayer1Shadow;
    private Text scorePlayer2;
    private Text scorePlayer2Shadow;
    private static boolean gameOn = false;

    public Game(Field field) {
        this.field = field;
    }


    public void start() throws InterruptedException {
        playersCreation();
        while (!gameOn) {
            Thread.sleep(MINDELAY);
        }
        field.hideRules();
        this.field.hideStart();
        startEngine();

    }

    public void startEngine() throws InterruptedException {
        commandsOn();
        scoreAppear();

        for (int i = 0; i < FOOD_TOTAL; i++) {
            playersAppearance();
            scoreUpdate();

            Thread.sleep((int) (Math.random() * (MAXDELAY - MINDELAY) + MINDELAY));
            foodItem = FoodFactory.makeFood();
            Thread.sleep(MAXDELAY / 2);

            foodItem.getPicture().delete();

        }
        gameOn = false;
        gameOver();
    }

    public void playersCreation() {
        player1 = new Character();
        player2 = new Character();
    }

    public void playersAppearance() {
        player1.changePic(230, 350, "Pics/Taz2.png");
        player2.changePic(870, 350, "Pics/coyote2.png");
    }

    public void commandsOn() {
        Keyboard kbPlayer1 = new Keyboard(player1);
        KeyboardEvent aPressed = new KeyboardEvent();
        KeyboardEvent aDpressed = new KeyboardEvent();
        setCommands(aPressed, KeyboardEvent.KEY_A, KeyboardEventType.KEY_PRESSED);
        setCommands(aDpressed, KeyboardEvent.KEY_A, KeyboardEventType.KEY_RELEASED);

        Keyboard kbPlayer2 = new Keyboard(player2);
        KeyboardEvent kPressed = new KeyboardEvent();
        KeyboardEvent kDpressed = new KeyboardEvent();
        setCommands(kPressed, KeyboardEvent.KEY_K, KeyboardEventType.KEY_PRESSED);
        setCommands(kDpressed, KeyboardEvent.KEY_K, KeyboardEventType.KEY_RELEASED);

        kbPlayer1.addEventListener(aPressed);
        kbPlayer1.addEventListener(aDpressed);
        kbPlayer2.addEventListener(kPressed);
        kbPlayer2.addEventListener(kDpressed);

    }

    public void setCommands(KeyboardEvent keyboardEventName, int keyboardEvent, KeyboardEventType keyboardEventType) {
        keyboardEventName.setKey(keyboardEvent);
        keyboardEventName.setKeyboardEventType(keyboardEventType);

    }

    public void scoreAppear() {
        scorePlayer1Shadow = new Text(93, 51, "Score: " + player1.getScore());
        scorePlayer1 = new Text(90, 50, "Score: " + player1.getScore());
        scorePlayer2Shadow = new Text(1153, 51, "Score: " + player2.getScore());
        scorePlayer2 = new Text(1150, 50, "Score: " + player2.getScore());

        field.drawText(scorePlayer1, scorePlayer1Shadow, 40, 15, Color.YELLOW);
        field.drawText(scorePlayer2, scorePlayer2Shadow, 40, 15, Color.YELLOW);

    }

    public void scoreUpdate() {
        scorePlayer1.setText("Score: " + player1.getScore());
        scorePlayer1Shadow.setText("Score: " + player1.getScore());
        scorePlayer2.setText("Score: " + player2.getScore());
        scorePlayer2Shadow.setText("Score: " + player2.getScore());
    }

    private void gameOver() {
        if (player1.getScore() > player2.getScore()) {
            System.out.println("Player 1 wins");
            field.playerOneVictory();
            return;
        }

        if (player1.getScore() == player2.getScore()) {
            System.out.println("It's a tie");
            field.tie();
            return;
        }

        System.out.println("Player 2 wins");
        field.playerTwoVictory();
    }


    public static Food getFoodItem() {
        return foodItem;
    }

    public void gameOn() {
        gameOn = true;
    }

    public static boolean isGameOn() {
        return gameOn;
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

}
