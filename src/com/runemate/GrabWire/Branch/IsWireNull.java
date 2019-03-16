package com.runemate.GrabWire.Branch;

import com.runemate.GrabWire.Leaf.GrabWire;
import com.runemate.GrabWire.Leaf.WaitForWire;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsWireNull extends BranchTask {

    @Override
    public boolean validate() {
        GameObject wire = GameObjects.newQuery().names("Wire").results().first();
        getLogger().info("Checking if wire is null");
        if(wire != null) {
            if (wire.getId() == 22731) {
                return wire == null;
            } else {
                return false;
            }
        }
        else{
            getLogger().info("Wire was null upon attempt to create wire object");
            return true;
        }
    }

    @Override
    public TreeTask failureTask() {
        return new GrabWire();
    }

    @Override
    public TreeTask successTask() {
        return new WaitForWire();
    }
}