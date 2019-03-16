package com.runemate.GrabWire.Leaf;

import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class GrabWire extends LeafTask {

    @Override
    public void execute() {
        GameObject wire = GameObjects.newQuery().names("Wire").results().first();
        if(wire != null){
            if(wire.getVisibility() > 90) {
                wire.hover();
                wire.interact("Grab");
                Execution.delay(750);
                Execution.delayUntil(() -> Players.getLocal().getAnimationId() == -1);
            }
            else{
                Camera.turnTo(wire);
            }
        }
        else{
            getLogger().info("Unable to grab wire in GrabWire");
        }

    }

}