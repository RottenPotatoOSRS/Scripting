package starterMining;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.ClientAccessor;

import static starterMining.HelperMethods.createTilesFromCorners;
import static starterMining.HelperMethods.generateRandomTile;

public class MiningConstants {

	// Item IDs
	public static final int BRONZE_PICKAXE_ID = 1265;

	// Object IDs
	public static final int[] COPPER_ROCK = {10943, 11161};
	public static final int[] TIN_ROCK = {11360, 11361};
	public static final int[] IRON_ROCK = {11364, 11365};

	// Tiles
	public static final Tile VARROCK_IRON_TILE = new Tile(3286, 3368, 0);
	public static final Tile[] VARROCK_IRON_ROCK_TILES = {new Tile(3285, 3368, 0), new Tile(3286, 3369, 0)};

	/*
	public static final Tile[] LUMBRIDGE_AREA = createTilesFromCorners(
			new Tile(3231, 3215),
			new Tile(3236, 3221)
	);
	 */

	// Paths
	public static final Tile[] LUMBY_TO_VARROCK_MINE = {new Tile(3237, 3226, 0), new Tile(3241, 3226, 0), new Tile(3245, 3226, 0), new Tile(3249, 3226, 0), new Tile(3253, 3226, 0), new Tile(3257, 3227, 0), new Tile(3259, 3231, 0), new Tile(3259, 3235, 0), new Tile(3259, 3239, 0), new Tile(3259, 3243, 0), new Tile(3259, 3247, 0), new Tile(3256, 3250, 0), new Tile(3253, 3253, 0), new Tile(3252, 3257, 0), new Tile(3252, 3261, 0), new Tile(3251, 3265, 0), new Tile(3248, 3268, 0), new Tile(3247, 3272, 0), new Tile(3243, 3274, 0), new Tile(3241, 3278, 0), new Tile(3241, 3282, 0), new Tile(3239, 3286, 0), new Tile(3239, 3290, 0), new Tile(3239, 3294, 0), new Tile(3239, 3298, 0), new Tile(3239, 3302, 0), new Tile(3240, 3306, 0), new Tile(3243, 3309, 0), new Tile(3246, 3313, 0), new Tile(3249, 3317, 0), new Tile(3252, 3321, 0), new Tile(3256, 3322, 0), new Tile(3260, 3322, 0), new Tile(3264, 3325, 0), new Tile(3267, 3328, 0), new Tile(3267, 3332, 0), new Tile(3271, 3335, 0), new Tile(3274, 3339, 0), new Tile(3277, 3343, 0), new Tile(3280, 3347, 0), new Tile(3281, 3351, 0), new Tile(3281, 3355, 0), new Tile(3277, 3358, 0), new Tile(3277, 3362, 0), new Tile(3277, 3366, 0), new Tile(3278, 3370, 0), new Tile(3282, 3371, 0), new Tile(3283, 3367, 0), new Tile(3285, 3363, 0), new Tile(3289, 3362, 0)};
	public static final Tile[] VARROCK_MINE_TO_BANK = {new Tile(3286, 3368, 0), new Tile(3287, 3372, 0), new Tile(3289, 3376, 0), new Tile(3290, 3380, 0), new Tile(3290, 3384, 0), new Tile(3290, 3388, 0), new Tile(3290, 3392, 0), new Tile(3290, 3396, 0), new Tile(3290, 3400, 0), new Tile(3290, 3404, 0), new Tile(3289, 3408, 0), new Tile(3288, 3412, 0), new Tile(3288, 3416, 0), new Tile(3286, 3420, 0), new Tile(3282, 3422, 0), new Tile(3278, 3423, 0), new Tile(3275, 3426, 0), new Tile(3271, 3426, 0), new Tile(3267, 3426, 0), new Tile(3263, 3426, 0), new Tile(3259, 3428, 0), new Tile(3255, 3427, 0), new Tile(3254, 3423, 0)};
	public static final Tile[] BANK_TO_VARROCK_MINE = {new Tile(3253, 3421, 0), new Tile(3253, 3425, 0), new Tile(3257, 3428, 0), new Tile(3261, 3428, 0), new Tile(3265, 3428, 0), new Tile(3269, 3428, 0), new Tile(3273, 3428, 0), new Tile(3277, 3426, 0), new Tile(3279, 3422, 0), new Tile(3280, 3418, 0), new Tile(3283, 3414, 0), new Tile(3286, 3411, 0), new Tile(3288, 3407, 0), new Tile(3290, 3403, 0), new Tile(3290, 3399, 0), new Tile(3290, 3395, 0), new Tile(3290, 3391, 0), new Tile(3290, 3387, 0), new Tile(3290, 3383, 0), new Tile(3290, 3379, 0), new Tile(3290, 3375, 0), new Tile(3287, 3371, 0), new Tile(3286, 3367, 0)};

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
}
