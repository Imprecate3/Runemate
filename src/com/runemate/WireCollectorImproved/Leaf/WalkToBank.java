package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkToBank extends LeafTask {

    @Override
    public void execute() {
        Path toBank = BresenhamPath.buildTo(Places.bankArea.getRandomCoordinate());
        if(toBank != null){
            toBank.step();
            Execution.delayUntil(()-> !Players.getLocal().isMoving());
        }

    }

}