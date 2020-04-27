package starterMining;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.ClientAccessor;

import static starterMining.HelperMethods.createTilesFromCorners;
import static starterMining.HelperMethods.generateRandomTile;

public class StarterMinerConstants extends ClientAccessor {
	// Item ids
	public static final int bronzePickaxeId = 1265;
	public static final Tile[] LUMBRIDGE_AREA = createTilesFromCorners(
			new Tile(3231, 3215),
			new Tile(3236, 3221)
	);


	public static Tile[] pathToMine = new Tile[]{
			generateRandomTile(new Tile(3235, 3223)),
			generateRandomTile(new Tile(3246, 3225)),
			generateRandomTile(new Tile(3256, 3226)),
			generateRandomTile(new Tile(3259, 3237)),
			generateRandomTile(new Tile(3254, 3250)),
			generateRandomTile(new Tile(3249, 3261)),
			generateRandomTile(new Tile(3245, 3271)),
			generateRandomTile(new Tile(3237, 3283)),
			generateRandomTile(new Tile(3238, 3300)),
			generateRandomTile(new Tile(3244, 3310)),
			generateRandomTile(new Tile(3252, 3322)),
			generateRandomTile(new Tile(3266, 3325)),
			generateRandomTile(new Tile(3266, 3325)),
			generateRandomTile(new Tile(3278, 3336)),
			generateRandomTile(new Tile(3277, 3345)),
			generateRandomTile(new Tile(3270, 3354)),
			generateRandomTile(new Tile(3270, 3364)),
			generateRandomTile(new Tile(3277, 3369)),
			generateRandomTile(new Tile(3283, 3336))
	};
	public StarterMinerConstants(ClientContext ctx) {
		super(ctx);
	}
}
