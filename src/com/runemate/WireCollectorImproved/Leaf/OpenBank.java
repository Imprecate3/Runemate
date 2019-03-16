package com.runemate.WireCollectorImproved.Leaf;

import com.runemate.WireCollectorImproved.Variables.Places;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

public class OpenBank extends LeafTask {

    @Override
    public void execute() {
        GameObject bankBooth = GameObjects.newQuery().within(Places.bankBooths).names("Bank booth").results().first();
        if(bankBooth != null){
            if(bankBooth.click()){
                Execution.delayUntil(()-> Bank.isOpen(),2000, 10000);
            }
        }
        else{
            getLogger().info("Unable to find bank booths in OpenBank");
        }
    }

}