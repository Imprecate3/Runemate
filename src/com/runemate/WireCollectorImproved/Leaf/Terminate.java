package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class Terminate extends LeafTask {

    @Override
    public void execute() {
        Environment.getBot().stop("Bot stopped");
        getLogger().info("Stopping bot");
    }

}