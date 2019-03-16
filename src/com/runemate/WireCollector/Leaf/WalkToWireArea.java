package com.runemate.WireCollector.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Traversal;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.ViewportPath;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.location.navigation.web.WebPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Walk to the wire area
 */
public class WalkToWireArea extends LeafTask {

    private Coordinate wireArea = new Coordinate(2715, 5274, 0);
    private Coordinate nearStair = new Coordinate(2712, 5285, 0);
    private Coordinate stair1 = new Coordinate(2713, 5282, 0);
    private Coordinate stair2 = new Coordinate(2713, 5279, 1);
    private Player player;

    @Override
    public void execute() {

        player = Players.getLocal();
        BresenhamPath toWireArea = BresenhamPath.buildTo(nearStair);
        while(Distance.between(nearStair,player) > 3) {
            if (toWireArea != null) {
                getLogger().info("Stepping to path");
                ViewportPath path = ViewportPath.convert(toWireArea);
                if(path != null) {
                    path.step();
                }
            } else {
                Environment.getBot().getLogger().info("Unable to build path to bank in WalkToBank");
            }
            Execution.delay(3000);
        }

        GameObject stairs1 = GameObjects.newQuery().on(stair1).names("Stairs").results().first();
        if(stairs1.isVisible()){
            if(stairs1.interact("Climb")){
                Execution.delayUntil(()-> (player) != null && player.isMoving(), 100, 2000 );
            }
        }
        else{
            Camera.turnTo(stairs1);
        }
        GameObject stairs2 = GameObjects.newQuery().on(stair2).names("Stairs").results().first();
        if(stairs1.isVisible()){
            if(stairs1.interact("Climb")){
                Execution.delay(2000);
            }
        }
        else{
            Camera.turnTo(stairs2);
        }

    }
}
