package com.runemate.WireCollector.Branch;

import com.runemate.WireCollector.Leaf.WalkToBank;
import com.runemate.game.api.hybrid.entities.Player;
import com.runemate.game.api.hybrid.location.Coordinate;
import com.runemate.game.api.hybrid.region.Players;
import com.runemate.game.api.hybrid.util.calculations.Distance;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

//import path.to.your.IsBankOpen
//import path.to.your.WalkToBank

/**
 * NOTES:
 * Checks if player is in the bank
 */
public class InBankArea extends BranchTask {

    private IsBankOpen isbankopen = new IsBankOpen();
    private WalkToBank walktobank = new WalkToBank();

    private Coordinate BankArea = new Coordinate(2703, 5349, 0);
    private Player player;

    @Override
    public boolean validate() {
        if((player = Players.getLocal()) != null && Distance.between(BankArea, player) < 5){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public TreeTask failureTask() {
        return walktobank;
    }

    @Override
    public TreeTask successTask() {
        return isbankopen;
    }
}
