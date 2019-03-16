package com.runemate.WireCollector.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.cognizant.RegionPath;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;


/**
 * NOTES:
 * Moves player to bank
 */
public class WalkToBank extends LeafTask {

    private Coordinate bankArea = new Coordinate(2703, 5349, 0);
    private Coordinate stair1 = new Coordinate(2713, 5278, 0);
    private Coordinate stair2 = new Coordinate(2713, 5282, 1);
    private Player player;

    @Override
    public void execute() {
        GameObject stairs1 = GameObjects.newQuery().on(stair1).names("Stairs").results().first();
        if(stairs1.isVisible()){
            if(stairs1.interact("Climb")){
                Execution.delayUntil(()-> (player = Players.getLocal()) != null && player.isMoving(), 100, 2000 );
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
        RegionPath toBankArea = RegionPath.buildTo(bankArea);
        if(toBankArea != null){
            toBankArea.step();
        }
        else{
            Environment.getBot().getLogger().info("Unable to build path to bank in WalkToBank");
        }

    }
}
