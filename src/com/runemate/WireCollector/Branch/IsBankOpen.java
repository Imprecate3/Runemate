package com.runemate.WireCollector.Branch;

import com.runemate.WireCollector.Leaf.OpenBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.IsFoodInBank
//import path.to.your.OpenBank

/**
 * NOTES:
 * Checks if the bank is open
 */
public class IsBankOpen extends BranchTask {

    private IsFoodInBank isfoodinbank = new IsFoodInBank();
    private OpenBank openbank = new OpenBank();

    @Override
    public boolean validate() {
        if(Bank.isOpen()){
            return true;
        }
        else{
            return false;
        }

    }

    @Override
    public TreeTask failureTask() {
        return openbank;
    }

    @Override
    public TreeTask successTask() {
        return isfoodinbank;
    }
}
