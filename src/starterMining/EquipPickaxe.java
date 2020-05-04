package starterMining;

import org.powerbot.script.rt4.*;
import osrs.Task;

import static starterMining.MiningConstants.*;

public class EquipPickaxe extends Task {

	public EquipPickaxe(ClientContext ctx) { super(ctx); }

	@Override
	public boolean activate() {
		return !(ctx.equipment.itemAt(Equipment.Slot.MAIN_HAND).id() == BRONZE_PICKAXE_ID);
	}

	@Override
	public void execute() {
		ctx.game.tab(Game.Tab.INVENTORY);

		System.out.println("Equipping bronze pickaxe!");
		Item bronzePickaxe = ctx.inventory.select().id(BRONZE_PICKAXE_ID).poll();
		bronzePickaxe.interact("Wield");
	}

}
