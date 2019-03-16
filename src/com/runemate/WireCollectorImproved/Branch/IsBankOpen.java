package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.OpenBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsBankOpen extends BranchTask {

    @Override
    public boolean validate() {
        return Bank.isOpen();
    }

    @Override
    public TreeTask failureTask() {
        return new OpenBank();
    }

    @Override
    public TreeTask successTask() {
        return new DoesBankContainFood();
    }
}