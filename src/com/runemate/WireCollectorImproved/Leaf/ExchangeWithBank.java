package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Variables;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ExchangeWithBank extends LeafTask {

    @Override
    public void execute() {
        Bank.depositInventory();
        Bank.withdraw("Lobster", 3);
        Bank.close();
        Variables.forceToBank = false;
    }

}