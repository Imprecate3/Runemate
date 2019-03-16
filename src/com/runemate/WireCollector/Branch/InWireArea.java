package com.runemate.WireCollector.Branch;

import com.runemate.WireCollector.Leaf.GrabWire;
import com.runemate.WireCollector.Leaf.WalkToWireArea;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.ImprecatesGrabWire
//import path.to.your.WalkToWireArea

/**
 * NOTES:
 * 
 */
public class InWireArea extends BranchTask {

    private GrabWire grabwire = new GrabWire();
    private WalkToWireArea walktowirearea = new WalkToWireArea();

    private Coordinate WireArea = new Coordinate(2715, 5274, 0);
    private Player player;

    @Override
    public boolean validate() {
        if((player = Players.getLocal()) != null && Distance.between(WireArea, player) < 10){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return walktowirearea;
    }

    @Override
    public TreeTask successTask() {
        return grabwire;
    }
}
