package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.WaitForStun;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsPlayerStunned extends BranchTask {

    @Override
    public boolean validate() {
        return Players.getLocal().getSpotAnimationIds().size() != 0;
    }

    @Override
    public TreeTask failureTask() {
        return new IsGrabbingWire();
    }

    @Override
    public TreeTask successTask() {
        return new WaitForStun();
    }
}
