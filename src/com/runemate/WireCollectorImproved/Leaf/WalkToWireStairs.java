package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.ViewportPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkToWireStairs extends LeafTask {

    @Override
    public void execute() {
        BresenhamPath bPath = BresenhamPath.buildTo((Places.wireStairs.getRandomCoordinate()));
        Path toWireStairs = ViewportPath.convert(bPath);
        if(toWireStairs != null){
            toWireStairs.step();
            Execution.delayUntil(()-> !Players.getLocal().isMoving(), 1000, 4000);
        }
        else{
            getLogger().info("Unable to build path to Wire Stairs");
        }
    }

}