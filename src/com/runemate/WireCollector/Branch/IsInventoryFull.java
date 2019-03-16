package com.runemate.WireCollector.Branch;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.CHANGETOINBANKAREA
//import path.to.your.InWireArea

/**
 * NOTES:
 * Checks if the players inventory is full
 */
public class IsInventoryFull extends BranchTask {

    private CHANGETOINBANKAREA changetoinbankarea = new CHANGETOINBANKAREA();
    private InWireArea inwirearea = new InWireArea();

    @Override
    public boolean validate() {
        if(Inventory.isFull()){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return inwirearea;
    }

    @Override
    public TreeTask successTask() {
        return changetoinbankarea;
    }
}
