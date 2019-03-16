package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.ClimbDownWireAreaStairs;
import com.runemate.WireCollectorImproved.Leaf.Terminate;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class AreWireAreaDownStairsNull extends BranchTask {

    @Override
    public boolean validate() {
        GameObject WireAreaDownStairs = GameObjects.newQuery().names("Stairs").on(Places.WireAreaDownStairs).results().first();
        if(WireAreaDownStairs == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return new ClimbDownWireAreaStairs();
    }

    @Override
    public TreeTask successTask() {
        return new Terminate();
    }
}