package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.WalkToBank;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InStairArea extends BranchTask {

    @Override
    public boolean validate() {
        return Distance.between(Players.getLocal(), Places.mainAreaStairs) < 4;
    }

    @Override
    public TreeTask failureTask() {
        return new WalkToBank();
    }

    @Override
    public TreeTask successTask() {
        return new AreMainAreaDownStairsNull();
    }
}