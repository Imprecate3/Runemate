package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.ClimbUpMainAreaStairs;
import com.runemate.WireCollectorImproved.Leaf.Terminate;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class AreMainAreaUpStairsNull extends BranchTask {

    @Override
    public boolean validate() {
        GameObject MainAreaUpStairs = GameObjects.newQuery().names("Stairs").results().nearest();
        getLogger().info("Checking if the up stairs are null");
        if(MainAreaUpStairs == null){
            getLogger().info("Main upstairs are null");
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return new ClimbUpMainAreaStairs();
    }

    @Override
    public TreeTask successTask() {
        return new Terminate();
    }
}