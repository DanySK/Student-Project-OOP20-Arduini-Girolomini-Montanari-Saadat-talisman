package talisman.view;

import java.util.List;



public interface OpponentChoiceWindow {

    static void show(final List<Integer> players) {
        new OpponentChoiceWindowImpl(players);
    }
}
