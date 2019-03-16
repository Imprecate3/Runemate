package com.runemate.WireCollectorImproved.Branch;

import com.runemate.WireCollectorImproved.Leaf.GrabWire;
import com.runemate.WireCollectorImproved.Leaf.WaitForNewWire;
import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class CanGrabWire extends BranchTask {

    @Override
    public boolean validate() {
        GameObject wire = GameObjects.newQuery().names("Wire").on(Places.wire).results().first();
        if(wire != null){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return new WaitForNewWire();
    }

    @Override
    public TreeTask successTask() {
        return new GrabWire();
    }
}