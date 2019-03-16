package com.runemate.WireCollectorImproved;

import com.runemate.WireCollectorImproved.Branch.IsPlayerInBankArea;
import com.runemate.WireCollectorImproved.Branch.IsPlayerInWireArea;
import com.runemate.WireCollectorImproved.Variables.Variables;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;
import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;

public class Root extends BranchTask {

   @Override
   public boolean validate() {
       return Inventory.isFull() || Variables.forceToBank;
   }

   @Override
   public TreeTask failureTask() {
       return new IsPlayerInWireArea();
   }

   @Override
   public TreeTask successTask() {
       return new IsPlayerInBankArea();
   }

}
