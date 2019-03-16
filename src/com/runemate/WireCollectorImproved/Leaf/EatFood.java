package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class EatFood extends LeafTask {

    private String[] food = {"Lobster"};

    @Override
    public void execute() {
        SpriteItem foodItem = Inventory.newQuery().names(food).results().first();
        if(foodItem != null){
            foodItem.click();
        }
    }

}