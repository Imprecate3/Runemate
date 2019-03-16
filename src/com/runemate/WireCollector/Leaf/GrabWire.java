package com.runemate.WireCollector.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.Skill;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * 
 */
public class GrabWire extends LeafTask {

    @Override
    public void execute() {
        GameObject wire = GameObjects.newQuery().names("Wire").results().nearest();
        if(wire != null){
            int ThievingXpFirst = Skill.THIEVING.getExperience();
            if(wire.isVisible()){
                if(wire.interact("Grab")) {
                    Execution.delayUntil(() -> !wire.isValid() || Skill.THIEVING.getExperience() > ThievingXpFirst, 4000, 5000);
                }
            }
            else{
                Camera.turnTo(wire);
            }
        }
        else{
            Environment.getBot().getLogger().info("Unable to find wire in ImprecatesGrabWire");
        }
    }
}
