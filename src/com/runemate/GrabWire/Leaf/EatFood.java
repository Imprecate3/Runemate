package com.runemate.GrabWire.Leaf;

import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.hybrid.local.hud.interfaces.SpriteItem;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class EatFood extends LeafTask {

    private String[] foods = {"Lobster"};

    @Override
    public void execute() {
        SpriteItem food = Inventory.newQuery().names(foods).results().first();
        if(food != null){
            food.hover();
            food.click();
            Execution.delayUntil(()->!food.isValid());
        }
        else{
            getLogger().info("Unable to find food in EatFood");
        }

    }

}