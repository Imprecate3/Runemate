package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.WaitUntilNoLongerGrabbing;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsGrabbingWire extends BranchTask {

    @Override
    public boolean validate() {
        return Players.getLocal().getAnimationId() != -1;
    }

    @Override
    public TreeTask failureTask() {
        return new CanGrabWire();
    }

    @Override
    public TreeTask successTask() {
        return new WaitUntilNoLongerGrabbing();
    }
}