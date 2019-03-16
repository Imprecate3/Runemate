package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.WalkNextToMachine;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsPlayerNextToMachine extends BranchTask {

    @Override
    public boolean validate() {
        if (Players.getLocal().getPosition() == Places.nextToMachine) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return new WalkNextToMachine();
    }

    @Override
    public TreeTask successTask() {
        return new IsHealthOverFive();
    }
}
