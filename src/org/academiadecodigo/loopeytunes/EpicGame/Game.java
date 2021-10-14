package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.loopeytunes.EpicGame.Factorys.FoodFactory;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Character;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.CharactersType;
import org.academiadecodigo.loopeytunes.EpicGame.GameObjects.Food;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Game {
    private static final int DELAY = 2000;
    private static final int FOOD_TOTAL = 2;
    public static Food foodItem;
    private Character player1;
    private Character player2;
    private Keyboard kbPlayer1;
    private Keyboard kbPlayer2;
    private KeyboardEvent aPressed;
    private KeyboardEvent kPressed;


    public Game() {
    }

    public void init() {
        Field.generateField();

    }

    public void start() throws InterruptedException {
        playerCreat();
        startEngine();
    }

    public void startEngine() throws InterruptedException {
        commandsOn();
        for (int i = 0; i < FOOD_TOTAL; i++) {
            playerAppear();
            Thread.sleep(DELAY / 2);
            foodItem = FoodFactory.makeFood();
            Thread.sleep(DELAY);
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
        player1 = new Character(CharactersType.TAZ);
        player2 = new Character(CharactersType.COYOTE);
    }

    public void playerAppear() {
        player1.changePic(230, 350, "/Users/codecadet/Desktop/EpicGame/epicgame/Pics/Taz2.png");
        player2.changePic(870, 350, "/Users/codecadet/Desktop/EpicGame/epicgame/Pics/coyote2.png");
    }

    public void commandsOn() {
        kbPlayer1 = new Keyboard(player1);
        aPressed = new KeyboardEvent();
        setCommands(aPressed, KeyboardEvent.KEY_A);

        kbPlayer2 = new Keyboard(player2);
        kPressed = new KeyboardEvent();
        setCommands(kPressed, KeyboardEvent.KEY_K);

        kbPlayer1.addEventListener(aPressed);
        kbPlayer2.addEventListener(kPressed);


    }


    public void setCommands(KeyboardEvent keyboardEventName, int keyboardEvent) {
        keyboardEventName.setKey(keyboardEvent);
        keyboardEventName.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


    }


}
