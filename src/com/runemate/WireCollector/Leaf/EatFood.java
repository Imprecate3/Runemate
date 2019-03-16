package com.runemate.WireCollector.Leaf;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Eat food
 */
public class EatFood extends LeafTask {

    private String[] food = {"Lobster"};

    @Override
    public void execute() {
        SpriteItem lob = Inventory.newQuery().names(food).results().first();
        if(lob != null){
            lob.click();
        }
    }
}
