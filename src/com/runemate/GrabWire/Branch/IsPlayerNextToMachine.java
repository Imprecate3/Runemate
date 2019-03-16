package com.runemate.GrabWire.Branch;

import com.runemate.GrabWire.Leaf.WalkToMachine;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsPlayerNextToMachine extends BranchTask {

    private Coordinate machine = new Coordinate(2715, 5274, 0);

    @Override
    public boolean validate() {
        getLogger().info("Checking if player is next to machine");
        return Distance.between(Players.getLocal(), machine) == 0;
    }

    @Override
    public TreeTask failureTask() {
        return new WalkToMachine();
    }

    @Override
    public TreeTask successTask() {
        return new IsPlayerStunned();
    }
}