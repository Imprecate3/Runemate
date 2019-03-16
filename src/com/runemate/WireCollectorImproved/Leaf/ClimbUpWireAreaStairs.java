package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ClimbUpWireAreaStairs extends LeafTask {

    @Override
    public void execute() {
        GameObject wireAreaUpStairs = GameObjects.newQuery().names("Stairs").on(Places.WireUpStairs).results().first();

        if(wireAreaUpStairs != null){
            if(wireAreaUpStairs.isVisible()){
                if(wireAreaUpStairs.interact("Climb-up")){
                    Execution.delay(1000);
                }
                else{
                    getLogger().info("Unable to climb-up stairs in ClimbUpWireAreaStairs");
                }
            }
            else{
                Camera.turnTo(wireAreaUpStairs);
            }
        }
        else{
            getLogger().info("Unable to find wireAreaUpStairs in ClimbUpWireAreaStairs");
        }
    }
}
