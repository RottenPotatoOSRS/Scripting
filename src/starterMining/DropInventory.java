package starterMining;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.*;
import tutorialIsland.TutorialComponents;

import static starterMining.HelperMethods.*;
import static starterMining.StarterMinerConstants.*;

public class DropInventory extends Task {

	StarterMinerConditions starterMinerConditions = new StarterMinerConditions(ctx);
	StarterMinerComponents starterMinerComponents = new StarterMinerComponents(ctx);

	public DropInventory(ClientContext ctx) { super(ctx); }

	@Override
	public boolean activate() {
		return playerInArea(LUMBRIDGE_AREA, ctx) &&
				!(ctx.equipment.itemAt(Equipment.Slot.MAIN_HAND).id() == bronzePickaxeId);
	}

	@Override
	public void execute() {
		System.out.println("Starting Starter Miner!");

		System.out.println("Enabling shift click drop!");
		turnOnShiftDrop(ctx);
		System.out.println("Shift click drop enabled!");

		starterMinerComponents.inventoryTab.click();

		// Drop everything besides bronze pickaxe
		Item[] inventoryItems = ctx.inventory.items();
		System.out.println("Checking inventory items");

		for (int i = 0; i < inventoryItems.length; i++) {
			if (inventoryItems[i].id() != bronzePickaxeId) {
				ctx.inventory.drop(inventoryItems[i], true);
			}
		}

		System.out.println("Equipping bronze pickaxe!");
		try {
			Item pickaxe = getItemFromInventory(bronzePickaxeId, ctx);
			pickaxe.interact("Wield");
			System.out.println("Equipped bronze pickaxe!!");
		}
		catch (NullPointerException e) {
			System.out.println("Can't find pickaxe!");
		}

	}

}
