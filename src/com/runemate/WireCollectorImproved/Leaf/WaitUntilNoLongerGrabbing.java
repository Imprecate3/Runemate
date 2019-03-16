package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WaitUntilNoLongerGrabbing extends LeafTask {

    @Override
    public void execute() {
        Execution.delayUntil(()->Players.getLocal().getAnimationId() == -1);
    }

}