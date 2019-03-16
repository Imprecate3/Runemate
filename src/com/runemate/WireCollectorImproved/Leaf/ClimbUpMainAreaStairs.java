package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ClimbUpMainAreaStairs extends LeafTask {

    @Override
    public void execute() {
        GameObject MainAreaUpStairs = GameObjects.newQuery().ids(22937).results().first();

        if(MainAreaUpStairs != null){
            if(MainAreaUpStairs.isVisible()) {
                MainAreaUpStairs.interact("Climb-up");
                Execution.delay(1000);
            }
            else{
                Camera.turnTo(MainAreaUpStairs);
            }
        }
        else{
            getLogger().info("Unable to find MainAreaUpStairs in ClimbUpMainAreaStairs");
        }
    }

}