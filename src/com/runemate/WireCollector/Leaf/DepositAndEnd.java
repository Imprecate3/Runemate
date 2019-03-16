package com.runemate.WireCollector.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Deposits items and ends bot
 */
public class DepositAndEnd extends LeafTask {

    @Override
    public void execute() {
        Bank.depositInventory();
        Bank.close();
        Environment.getBot().stop();
    }
}
