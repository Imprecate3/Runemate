package com.runemate.WireCollector.Branch;

import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.IsInventoryFull
//import path.to.your.FoodInInventory

/**
 * NOTES:
 * Checks if the players health is over 5
 */
public class HealthOver5 extends BranchTask {

    private IsInventoryFull isinventoryfull = new IsInventoryFull();
    private FoodInInventory foodininventory = new FoodInInventory();

    @Override
    public boolean validate() {
        if(Health.getCurrent() > 5){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return foodininventory;
    }

    @Override
    public TreeTask successTask() {
        return isinventoryfull;
    }
}
