package com.runemate.GrabWire.Leaf;

import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.location.navigation.Path;
import com.runemate.game.api.hybrid.location.navigation.basic.BresenhamPath;
import com.runemate.game.api.hybrid.location.navigation.basic.ViewportPath;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class WalkToMachine extends LeafTask {

    private Coordinate machine = new Coordinate(2715, 5274, 0);

    @Override
    public void execute() {
        BresenhamPath bPath = BresenhamPath.buildTo(machine);
        Path toMachine = ViewportPath.convert(bPath);
        if(toMachine != null){
            toMachine.step();
        }
        else {
            getLogger().info("Unable to build path to machine in WalkToMachine");
        }

    }

}