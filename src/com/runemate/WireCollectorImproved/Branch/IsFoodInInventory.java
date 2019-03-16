package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.EatFood;
import com.runemate.WireCollectorImproved.Leaf.ForceToBank;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsFoodInInventory extends BranchTask {

    private String[] food = {"Lobster"};

    @Override
    public boolean validate() {
        return Inventory.containsAnyOf(food);
    }

    @Override
    public TreeTask failureTask() {
        return new ForceToBank();
    }

    @Override
    public TreeTask successTask() {
        return new EatFood();
    }
}