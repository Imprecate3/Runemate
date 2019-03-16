package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.ClimbUpWireAreaStairs;
import com.runemate.WireCollectorImproved.Leaf.Terminate;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class AreWireAreaUpStairsNull extends BranchTask {

    @Override
    public boolean validate() {
        GameObject wireAreaUpStairs = GameObjects.newQuery().names("Stairs").on(Places.WireUpStairs).results().first();
        if(wireAreaUpStairs == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return new ClimbUpWireAreaStairs();
    }

    @Override
    public TreeTask successTask() {
        return new Terminate();
    }
}