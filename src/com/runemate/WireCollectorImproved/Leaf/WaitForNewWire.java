package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

import java.util.Random;

public class WaitForNewWire extends LeafTask {

    @Override
    public void execute() {
        Random rand = new Random();
        int wait = rand.nextInt(8000 - 6000 + 1) + 6000;
        Execution.delay(wait);
    }

}