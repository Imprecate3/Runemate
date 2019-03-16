package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class DepositAndTerminate extends LeafTask {

    @Override
    public void execute() {
        Bank.depositInventory();
        Environment.getBot().stop("Ran out of food");
    }

}