package info.kisai.plusmoins;

import info.kisai.plusmoins.controller.Game;
import info.kisai.plusmoins.factory.impl.GameDefaultFactory;

public class Main {

    public static void main(String... args) {
        Game game = GameDefaultFactory.getInstance().create();
        game.init();
        game.start();
    }
}
