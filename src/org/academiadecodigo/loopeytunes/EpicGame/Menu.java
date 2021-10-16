package org.academiadecodigo.loopeytunes.EpicGame;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class Menu {
    private final Field field = new Field();
    private final Game game = new Game(field);


    public Menu(){
        field.generateField();
        field.generateStart();
    }

    public void optionStart() throws InterruptedException {
        Keyboard kbStart = new Keyboard(game);
        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKey(KeyboardEvent.KEY_SPACE);
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        kbStart.addEventListener(spacePress);
        game.start();
    }

}
