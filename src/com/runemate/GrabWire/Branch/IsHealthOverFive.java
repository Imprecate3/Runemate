package com.runemate.GrabWire.Branch;

import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsHealthOverFive extends BranchTask {

    @Override
    public boolean validate() {
        getLogger().info("Checking if players health is over 5");
        return Health.getCurrent() > 5;
    }

    @Override
    public TreeTask failureTask() {
        return new DoesPlayerHaveFood();
    }

    @Override
    public TreeTask successTask() {
        return new IsPlayerNextToMachine();
    }
}