package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.DepositAndTerminate;
import com.runemate.WireCollectorImproved.Leaf.ExchangeWithBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class DoesBankContainFood extends BranchTask {

    private String[] food = {"Lobster"};

    @Override
    public boolean validate() {
        return Bank.containsAnyOf(food);
    }

    @Override
    public TreeTask failureTask() {
        return new DepositAndTerminate();
    }

    @Override
    public TreeTask successTask() {
        return new ExchangeWithBank();
    }
}