package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.WalkToWireStairs;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class NearWireAreaStairs extends BranchTask {

    @Override
    public boolean validate() {
        return Places.wireStairs.contains(Players.getLocal());
    }

    @Override
    public TreeTask failureTask() {
        return new WalkToWireStairs();
    }

    @Override
    public TreeTask successTask() {
        return new AreWireAreaUpStairsNull();
    }
}