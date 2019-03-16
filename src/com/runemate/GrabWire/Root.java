package com.runemate.GrabWire;

import com.runemate.GrabWire.Branch.IsHealthOverFive;
import com.runemate.GrabWire.Leaf.PauseBot;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class Root extends BranchTask {

    @Override
    public boolean validate() {
        getLogger().info("Checking if inventory is full");
        return Inventory.isFull();
    }

    @Override
    public TreeTask failureTask() {
        return new IsHealthOverFive();
    }

    @Override
    public TreeTask successTask() {
        return new PauseBot();
    }
}