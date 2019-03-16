package com.runemate.WireCollectorImproved.Branch;

import com.runemate.game.api.hybrid.local.hud.interfaces.Health;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class IsHealthOverFive extends BranchTask {

    @Override
    public boolean validate() {
        return (Health.getCurrent() > 5);
    }

    @Override
    public TreeTask failureTask() {
        return new IsFoodInInventory();
    }

    @Override
    public TreeTask successTask() {
        return new IsPlayerStunned();
    }
}
