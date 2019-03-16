package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ClimbDownMainAreaStairs extends LeafTask {

    @Override
    public void execute() {
        GameObject MainAreaDownStairs = GameObjects.newQuery().names("Stairs").on(Places.mainDownStairs).results().first();

        if(MainAreaDownStairs != null){
            if(MainAreaDownStairs.isVisible()){
                if(MainAreaDownStairs.interact("Climb-down")){
                    Execution.delay(1000);
                }
                else{
                    getLogger().info("Unable to climb-up stairs in ClimbDownMainAreaStairs");
                }
            }
            else{
                Camera.turnTo(MainAreaDownStairs);
            }
        }
        else{
            getLogger().info("Unable to find MainAreaUpStairs in ClimbDownMainAreaStairs");
        }
    }

}