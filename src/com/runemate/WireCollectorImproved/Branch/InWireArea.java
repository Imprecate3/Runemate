package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class InWireArea extends BranchTask {

    @Override
    public boolean validate() {
        return Places.WireArea.contains(Players.getLocal());
    }

    @Override
    public TreeTask failureTask() {
        return new InStairArea();
    }

    @Override
    public TreeTask successTask() {
        return new NearWireAreaStairs();
    }
}