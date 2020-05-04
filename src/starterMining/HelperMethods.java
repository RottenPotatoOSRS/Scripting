package starterMining;

import java.util.Random;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;

public class HelperMethods {

	public static boolean turnOnShiftDrop(ClientContext ctx) {
		if (ctx.inventory.shiftDroppingEnabled()) return true;
		System.out.println("Enabling shift click drop");

		Component controls = ctx.widgets.component(261, 1).component(6);
		Component shiftDrop = ctx.widgets.component(261, 80);
		int textureSelected = 762;

		ctx.game.tab(Game.Tab.OPTIONS);
		Condition.wait(controls::valid, 250, 10);

		if(controls.textureId() != textureSelected) controls.click();
		Condition.wait(shiftDrop::valid, 250, 15);

		return shiftDrop.click();
	}

	public static boolean playerInArea(Tile[] area, ClientContext ctx) {
		Tile playerTile = ctx.players.local().tile();
		for (Tile tile : area)
			if (tile.equals(playerTile)) {
				return true;
			}
		return false;
	}

	public static Tile generateRandomTile(Tile tile) {
		Tile[] tiles = new Tile[3];
		int tileX = tile.x();
		int tileY = tile.y();

		tiles[0] = new Tile(tileX + 1, tileY);
		tiles[1] = new Tile(tileX + 1, tileY + 1);
		tiles[2] = new Tile(tileX, tileY + 1);

		return new Area(tiles).getRandomTile();
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
		ctx.movement.findPath(area.getRandomTile()).traverse();
		randomSleep(400, 800);
		// Did the player stop moving?
		Condition.wait(()-> !ctx.players.local().inMotion(),400, 30);
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
