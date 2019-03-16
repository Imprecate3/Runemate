package com.runemate.WireCollector.Branch;

import com.runemate.WireCollector.Leaf.DepositAndEnd;
import com.runemate.WireCollector.Leaf.ExchangeWithBank;
import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.CHANGETOEXCHANGEWITHBANK
//import path.to.your.CHANGETODEPOSITANDEND

/**
 * NOTES:
 * Checks to see if food is in the bank
 */
public class CHANGETOISFOODINBANK extends BranchTask {

    private ExchangeWithBank exchangewithbank = new ExchangeWithBank();
    private DepositAndEnd depositandend = new DepositAndEnd();

    private String[] food = {"Lobster"};

    @Override
    public boolean validate() {
        if(Bank.isOpen()){
            if(Bank.containsAnyOf(food)) {
                return true;
            }
            else{
                return false;
            }
        }
        else{
            Environment.getBot().getLogger().info("Bank not open when looked for in CHANGETOISFOODINBANK");
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return depositandend;
    }

    @Override
    public TreeTask successTask() {
        return exchangewithbank;
    }
}
