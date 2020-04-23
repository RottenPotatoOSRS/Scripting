package starterMining;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.ClientAccessor;

import static starterMining.HelperMethods.createTilesFromCorners;

public class StarterMinerConstants extends ClientAccessor {
	// Item ids
	public static final int bronzePickaxeId = 1265;
	public static final Tile[] LUMBRIDGE_AREA = createTilesFromCorners(
			new Tile(3231, 3215),
			new Tile(3236, 3221)
	);
	public static final Tile[] area1 = starterMining.HelperMethods.createTilesFromCorners(new Tile(3251,3225), new Tile(3258,3229));
	public static final Tile[] area2 = starterMining.HelperMethods.createTilesFromCorners(new Tile(3252,3248), new Tile(3257,3251));
	public static final Tile[] area3 = starterMining.HelperMethods.createTilesFromCorners(new Tile(3239,3274), new Tile(3243,3280));
	public static final Tile[] area4 = starterMining.HelperMethods.createTilesFromCorners(new Tile(3242,3308), new Tile(3247,3311));
	public static final Tile[] area5 = starterMining.HelperMethods.createTilesFromCorners(new Tile(3270,3330), new Tile(3277,3334));
	public static final Tile[] area6 = starterMining.HelperMethods.createTilesFromCorners(new Tile(3303,3348), new Tile(3307,3353));
	public static final Tile[] area7 = starterMining.HelperMethods.createTilesFromCorners(new Tile(3284,3367), new Tile(3290,3370));

	public static final Tile[] MINING_AREA = starterMining.HelperMethods.createTilesFromCorners(new Tile(3280,3361), new Tile(3292,3373));

	public StarterMinerConstants(ClientContext ctx) {
		super(ctx);
	}
}
