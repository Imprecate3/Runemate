package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class GrabWire extends LeafTask {

    @Override
    public void execute() {
        GameObject wire = GameObjects.newQuery().names("Wire").on(Places.wire).results().first();
        if(wire != null){
            if(wire.isVisible()) {
                wire.interact("Grab");
                Execution.delayUntil(() -> Players.getLocal().getAnimationId() == -1);
            }
            else{
                Camera.turnTo(wire);
            }
        }
        else{
            getLogger().info("Unable to find wire in ImprecatesGrabWire");
        }
    }

}