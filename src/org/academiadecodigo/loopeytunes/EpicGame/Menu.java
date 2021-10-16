package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Menu {
    private Game game = new Game();

    public Menu() throws InterruptedException {
        Field.generateField();
        Field.generateStart();
        optionStart();


    }

    public void optionStart() throws InterruptedException {
        game.init();
        Keyboard kbStart = new Keyboard(game);
        KeyboardEvent spacePress = new KeyboardEvent();


        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kbStart.addEventListener(spacePress);
        game.start();
    }

}
