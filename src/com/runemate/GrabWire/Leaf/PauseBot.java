package com.runemate.GrabWire.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class PauseBot extends LeafTask {

    @Override
    public void execute() {
        Environment.getBot().pause();
    }

}