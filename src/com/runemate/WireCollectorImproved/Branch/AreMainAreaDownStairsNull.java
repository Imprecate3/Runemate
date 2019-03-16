package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.ClimbDownMainAreaStairs;
import com.runemate.WireCollectorImproved.Leaf.Terminate;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class AreMainAreaDownStairsNull extends BranchTask {

    @Override
    public boolean validate() {
        GameObject MainAreaUpStairs = GameObjects.newQuery().names("Stairs").on(Places.mainDownStairs).results().first();
        if(MainAreaUpStairs == null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return new ClimbDownMainAreaStairs();
    }

    @Override
    public TreeTask successTask() {
        return new Terminate();
    }
}