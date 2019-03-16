package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ClimbDownWireAreaStairs extends LeafTask {

    @Override
    public void execute() {
        GameObject DownWireAreaStairs = GameObjects.newQuery().names("Stairs").on(Places.WireAreaDownStairs).results().first();

        if(DownWireAreaStairs != null){
            if(DownWireAreaStairs.isVisible()){
                if(DownWireAreaStairs.interact("Climb-down")){
                    Execution.delay(1000);
                }
                else{
                    getLogger().info("Unable to climb-up stairs in ClimbDownWireAreaStairs");
                }
            }
            else{
                Camera.turnTo(DownWireAreaStairs);
            }
        }
        else{
            getLogger().info("Unable to find MainAreaUpStairs in ClimbDownWireAreaStairs");
        }
    }
}
