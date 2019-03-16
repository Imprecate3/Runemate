package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.WalkToMainAreaStairs;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsPlayerNearMainAreaUpStairs extends BranchTask {

    @Override
    public boolean validate() {
        return Distance.between(Places.nearMainAreaUpStairs, Players.getLocal()) < 4;
    }

    @Override
    public TreeTask failureTask() {
        return new WalkToMainAreaStairs();
    }

    @Override
    public TreeTask successTask() {
        return new AreWireAreaDownStairsNull();
    }
}