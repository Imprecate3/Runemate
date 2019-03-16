package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Variables;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class ForceToBank extends LeafTask {

    @Override
    public void execute() {
        Variables.forceToBank = true;
    }

}