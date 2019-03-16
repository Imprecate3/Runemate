package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.ViewportPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkNextToMachine extends LeafTask {

    @Override
    public void execute() {
        BresenhamPath bPath = BresenhamPath.buildTo(Places.nextToMachine);
        Path toMachine = ViewportPath.convert(bPath);
        if(toMachine != null){
            toMachine.step();
            Execution.delayUntil(()-> !Players.getLocal().isMoving());
        }
        else{
            getLogger().info("Unable to build path in WalkNextToMachine");
        }
    }

}