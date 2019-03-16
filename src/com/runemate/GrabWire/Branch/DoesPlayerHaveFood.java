package com.runemate.GrabWire.Branch;

import com.runemate.GrabWire.Leaf.EatFood;
import com.runemate.GrabWire.Leaf.PauseBot;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class DoesPlayerHaveFood extends BranchTask {

    private String[] food = {"Lobster"};

    @Override
    public boolean validate() {
        getLogger().info("Checking if player has food");
        return Inventory.containsAnyOf(food);
    }

    @Override
    public TreeTask failureTask() {
        return new PauseBot();
    }

    @Override
    public TreeTask successTask() {
        return new EatFood();
    }
}