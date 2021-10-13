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
    private static final int FOOD_TOTAL = 20;
    public static Food foodItem;
    private Character player1;
    private Character player2;
    private Field field;
    private Keyboard kbPlayer1;
    private Keyboard kbPlayer2;
    private KeyboardEvent aPressed;
    private KeyboardEvent kPressed;


    public Game() {
    }

    public void init() {
        // field.generateField();
        player1 = new Character(CharactersType.TAZ);
        player2 = new Character(CharactersType.PORKY);


    }

    public void start() throws InterruptedException {
        startEngine();
    }

    public void startEngine() throws InterruptedException {
        chekPressed();
        for (int i = 0; i < FOOD_TOTAL; i++) {

            System.out.println(2);
            foodItem = FoodFactory.makeFood();


            Thread.sleep(DELAY);


        }


    }


    public void chekPressed() {
        kbPlayer1 = new Keyboard(player1);
        kbPlayer2 = new Keyboard(player2);

        aPressed = new KeyboardEvent();
        kPressed = new KeyboardEvent();

        aPressed.setKey(KeyboardEvent.KEY_A);
        aPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kPressed.setKey(KeyboardEvent.KEY_K);
        kPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kbPlayer1.addEventListener(aPressed);
        kbPlayer2.addEventListener(kPressed);


    }

}
