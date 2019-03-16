package com.runemate.WireCollector;

import com.runemate.WireCollector.Branch.HealthOver5;
import com.runemate.WireCollector.Leaf.StopBot;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.HealthOver5
//import path.to.your.StopBot

/**
 * NOTES:
 * Checks to see if in Dorgesh-Kaan
 */
public class InDorg extends BranchTask {

    private HealthOver5 healthover5 = new HealthOver5();
    private StopBot stopbot = new StopBot();

    private Coordinate dorg = new Coordinate(2712, 5332,0);
    private Player player;

    @Override
    public boolean validate() {
        if((player = Players.getLocal()) != null && Distance.between(dorg, player) < 50){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return stopbot;
    }

    @Override
    public TreeTask successTask() {
        return healthover5;
    }
}
