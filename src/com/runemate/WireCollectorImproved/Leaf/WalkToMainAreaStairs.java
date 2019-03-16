package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkToMainAreaStairs extends LeafTask {

    @Override
    public void execute() {
        Path toMainStairs = BresenhamPath.buildTo(Places.MainAreaUpStairs);
        if(toMainStairs != null){
            toMainStairs.step();
            Execution.delayUntil(()-> !Players.getLocal().isMoving());
        }
        else{
            getLogger().info("Unable to build path in WalkToMainAreaStairs");
        }
    }

}