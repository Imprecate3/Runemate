package com.runemate.WireCollector.Branch;

import com.runemate.WireCollector.Leaf.EatFood;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.EatFood
//import path.to.your.InBankArea

/**
 * NOTES:
 * Checks if food is in the players inventory
 */
public class FoodInInventory extends BranchTask {

    private EatFood eatfood = new EatFood();
    private InBankArea inbankarea = new InBankArea();

    private String[] food = {"Lobster"};

    @Override
    public boolean validate() {
        if(Inventory.containsAnyOf(food)){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return inbankarea;
    }

    @Override
    public TreeTask successTask() {
        return eatfood;
    }
}
