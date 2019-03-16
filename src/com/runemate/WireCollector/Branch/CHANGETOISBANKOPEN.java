package com.runemate.WireCollector.Branch;

import com.runemate.WireCollector.Leaf.OpenBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.CHANGETOISFOODINBANK
//import path.to.your.CHANGETOOPENBANK

/**
 * NOTES:
 * IsBankOpen
 */
public class CHANGETOISBANKOPEN extends BranchTask {

    private CHANGETOISFOODINBANK changetoisfoodinbank = new CHANGETOISFOODINBANK();
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
        return changetoisfoodinbank;
    }
}
