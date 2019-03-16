package com.runemate.WireCollector.Leaf;

import com.runemate.game.api.hybrid.Environment;
import com.runemate.game.api.hybrid.entities.GameObject;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.local.Camera;
import com.runemate.game.api.hybrid.local.hud.interfaces.Bank;
import com.runemate.game.api.hybrid.region.Banks;
import com.runemate.game.api.hybrid.region.GameObjects;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.script.Execution;
import com.runemate.game.api.script.framework.tree.LeafTask;

/**
 * NOTES:
 * Opens the bank
 */
public class OpenBank extends LeafTask {

    private Player player;

    @Override
    public void execute() {
        GameObject bank = Banks.getLoadedBankBooths().nearest();
        if(bank != null){
            if(bank.isVisible()){
                if(bank.interact("Bank")) {
                    Execution.delayUntil(() -> Bank.isOpen(), () -> (player = Players.getLocal()) != null && player.isMoving(), 100, 1000);
                }
            }
            else{
                Camera.turnTo(bank);
            }
        }
        else{
            Environment.getBot().getLogger().info("Unable to find bank in OpenBank");
        }

    }
}
