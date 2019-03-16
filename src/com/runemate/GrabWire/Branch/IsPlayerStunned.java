package com.runemate.GrabWire.Branch;

import com.runemate.GrabWire.Leaf.WaitForStun;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsPlayerStunned extends BranchTask {

    @Override
    public boolean validate() {
        getLogger().info("Checking if player is stunned");
        return Players.getLocal().getHitsplats().size() == 1;
    }

    @Override
    public TreeTask failureTask() {
        return new IsWireNull();
    }

    @Override
    public TreeTask successTask() {
        return new WaitForStun();
    }
}