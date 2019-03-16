package com.runemate.WireCollector.Leaf;

import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Deposits items and withdraws food
 */
public class ExchangeWithBank extends LeafTask {

    private String food = "Lobster";
    @Override
    public void execute() {
        Bank.depositInventory();
        Bank.withdraw(food, 3);
        Bank.close();
    }
}
