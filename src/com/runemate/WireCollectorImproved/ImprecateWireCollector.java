package com.runemate.WireCollectorImproved;

import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class ImprecateWireCollector extends TreeBot {

    @Override
    public TreeTask createRootTask() {
        return new Root();
    }
}
