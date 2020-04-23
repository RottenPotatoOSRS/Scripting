package starterMining;

import java.util.concurrent.Callable;
import java.util.Random;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;
import tutorialIsland.TutorialConditions;

public class HelperMethods {

	public static boolean turnOnShiftDrop(ClientContext ctx) {
		Component optionsTab = ctx.widgets.component(Constants.RESIZABLE_VIEWPORT_BOTTOM_LINE_WIDGET, 40);
		Component controls = ctx.widgets.component(261, 1).component(6);
		Component shiftDrop = ctx.widgets.component(261, 80);
		optionsTab.click();
		Condition.wait(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return controls.valid();
			}
		}, 300, 15);

		controls.click();
		Condition.wait(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return shiftDrop.valid();
			}
		}, 300, 15);

		return shiftDrop.click();
	}

	public static boolean playerInArea(Tile[] area, ClientContext ctx) {
		Tile playerTile = ctx.players.local().tile();
		for (int i = 0; i < area.length; i++) {
			Tile tile = area[i];
			if (tile.equals(playerTile)) {
				return true;
			}
		}
		return false;
	}

	public static Item getItemFromInventory(int id, ClientContext ctx) {
		for(Item item : ctx.inventory.items()) {
			if (item.id() == id) {
				return item;
			}
		}
		return null;
	}

	public static Tile[] createTilesFromCorners(Tile southWest, Tile northEast) {
		int left = southWest.x();
		int right = northEast.x();
		int bottom = southWest.y();
		int top = northEast.y();

		int numTiles = (right - left + 1) * (top - bottom + 1);
		Tile[] tiles = new Tile[numTiles];

		int i = 0;
		for (int x = left; x <= right; x++) {
			for (int y = bottom; y <= top; y++) {
				tiles[i] = new Tile(x, y);
				i++;
			}
		}
		return tiles;
	}

	public static void pathToArea(Area area, ClientContext ctx) {
		StarterMinerConditions starterMinerConditions = new StarterMinerConditions(ctx);
		ctx.movement.findPath(area.getRandomTile()).traverse();
		randomSleep(400, 800);
		// Did the player stop moving?
		Condition.wait(new Callable<Boolean>() {
			@Override
			public Boolean call() throws Exception {
				return !ctx.players.local().inMotion();
			}
		},400, 30);
	}

	/**
	 * Uses the Condition.sleep() method to sleep a random number of seconds
	 *
	 * @param min the shortest possible sleep time
	 * @param max the longest possible sleep time
	 */
	public static void randomSleep(int min, int max) {
		Random rand = new Random();
		int sleepTime = rand.nextInt(min + max) + min;
		Condition.sleep(sleepTime);
	}



}
