package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsPlayerInBankArea extends BranchTask {

    @Override
    public boolean validate() {
        return Places.bankArea.contains(Players.getLocal());
    }

    @Override
    public TreeTask failureTask() {
        return new InWireArea();
    }

    @Override
    public TreeTask successTask() {
        return new IsBankOpen();
    }
}
