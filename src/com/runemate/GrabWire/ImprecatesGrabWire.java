package com.runemate.GrabWire;

import com.runemate.game.api.script.framework.tree.TreeBot;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class ImprecatesGrabWire extends TreeBot {

    @Override
    public TreeTask createRootTask() {return new Root();}
}
