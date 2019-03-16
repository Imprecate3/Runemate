package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsPlayerInStairArea extends BranchTask {

    @Override
    public boolean validate() {
        return Places.StairArea.contains(Players.getLocal());
    }

    @Override
    public TreeTask failureTask() {
        return new IsPlayerNearMainAreaUpStairs();
    }

    @Override
    public TreeTask successTask() {
        return new AreWireAreaDownStairsNull();
    }
}