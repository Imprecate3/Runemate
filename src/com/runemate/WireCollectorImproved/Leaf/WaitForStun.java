package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.util.Random;

public class WaitForStun extends LeafTask {

    @Override
    public void execute() {
        Random rand = new Random();
        int wait = rand.nextInt(6000 - 4000 + 1) + 4000;
        Execution.delay(wait);
    }

}