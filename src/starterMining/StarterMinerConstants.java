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

	public StarterMinerConstants(ClientContext ctx) {
		super(ctx);
	}
}
