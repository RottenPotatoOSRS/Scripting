package tutorial;

import org.powerbot.script.Area;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;

import static tutorialIsland.HelperMethods.createAreaFromCorners;

public final class TutorialConstants extends ClientAccessor {

    // Variables
    public static boolean ratSlain = false;

    // Strings
    public static final String[] chatOptions = { "I am an experienced player.", "Yes.", "No, I'm not planning to do that." };

    // Item IDs
    public static final int netID               = 303;
    public static final int rawShrimpID         = 2514;
    public static final int cookedShrimpID      = 315;
    public static final int burntShrimpID       = 7954;
    public static final int bronzeAxeID         = 1351;
    public static final int logsID              = 2511;
    public static final int tinderboxID         = 590;
    public static final int flourID             = 2516;
    public static final int bucketWaterID       = 1929;
    public static final int doughID             = 2307;
    public static final int breadID             = 2309;
    public static final int bronzePickaxeID     = 1265;
    public static final int hammerID            = 2347;
    public static final int tinOreID            = 438;
    public static final int copperOreID         = 436;
    public static final int bronzeBarID         = 2349;
    public static final int bronzeDaggerID      = 1205;
    public static final int bronzeSwordID       = 1277;
    public static final int woodShieldID        = 1171;
    public static final int bowID               = 841;
    public static final int arrowID             = 882;
    public static final int mindRuneID          = 558;

    // Object IDs
    public static final int[] fishingSpots      = {505,506,507};
    public static final int treeID              = 9730; //1570?
    public static final int fireID              = 26185; //2260?
    public static final int[] ladderIDs         = {9726, 9727};
    public static final int ladderDownID        = 9726; //1203?
    public static final int ladderUpID          = 9727; //1208?
    public static final int rangeID             = 9736; //1219?
    public static final int tinRockID           = 10080; //1390?
    public static final int copperRockID        = 10079; //1390?
    public static final int furnaceID           = 10082; //11546?
    public static final int anvilID             = 2097; //1251?
    public static final int bankBoothID         = 10083; //1270?
    public static final int pollBoothID         = 26801; //28905?

    public static final int bodyRuneID = 559;

    // Doors/gates
    public static final int startingDoorID      = 9398; //9476?
    public static final int questDoorID         = 9716; //9476?
    public static final int cookingDoorInID     = 9709; //9476?
    public static final int cookingDoorOutID    = 9710; //9476?
    public static final int gateID              = 9708; //966?
    public static final int resourceGateID      = 9470; //966?
    public static final int metalGateID         = 9717; //1509?
    public static final int combatGateID        = 9720; //1509?
    public static final int bankDoorInID        = 9721; //9476?
    public static final int bankDoorOutID       = 9722; //9476?
    public static final int prayerDoorID        = 9723; //9476?
    public static int[] doorIDs = {startingDoorID, resourceGateID, questDoorID, cookingDoorInID, cookingDoorOutID, gateID, metalGateID, combatGateID, bankDoorInID, bankDoorOutID, prayerDoorID};

    // NPC IDs
    public static final int gielinorID          = 3308;
    public static final int survivalID          = 8503;
    public static final int chefID              = 3305;
    public static final int questGuideID        = 3312;
    public static final int miningID            = 3311;
    public static final int vanakkaID           = 3307;
    public static final int giantRatID          = 3313;
    public static final int accountGuideID      = 3310;
    public static final int brotherBraceID      = 3319;
    public static final int mageInstructorID    = 3309;
    public static final int chickenID           = 3316;
    public static final int fishingSpotID       = 3317;
    public static final int[] npcIDs = {gielinorID, survivalID, chefID, questGuideID, miningID, vanakkaID, giantRatID, accountGuideID, brotherBraceID, mageInstructorID};

    // NPC names
    public static final String[] npcNames = {"Gielinor Guide", "survival expert"};

    // Door areas
    public static final Tile[] RESOURCE_DOOR          = {new Tile(3098, 3107, 0)};
    public static final Tile[] POST_RESOURCE_DOOR     = {new Tile(3089, 3091, 0), new Tile(3089, 3092, 0)};
    public static final Tile[] COOKING_DOOR           = {new Tile(3078, 3084, 0)};
    public static final Tile[] POST_COOKING_DOOR      = {new Tile(3072, 3090, 0)};
    public static final Tile[] QUEST_DOOR             = {new Tile(3086, 3125, 0)};
    public static final Tile[] COMBAT_DOOR            = {new Tile(3095, 9502, 0), new Tile(3095, 9503, 0)};
    public static final Tile[] VANNAKA_DOOR           = {new Tile(3111, 9518, 0), new Tile(3111, 9519, 0)};
    public static final Tile[] RAT_DOOR               = {new Tile(3110, 9518, 0), new Tile(3110, 9519, 0)};
    public static final Tile[] MANAGEMENT_DOOR        = {new Tile(3125, 3124, 0)};
    public static final Tile[] POST_MANAGEMENT_DOOR   = {new Tile(3130, 3124, 0)};
    public static final Tile[] POST_PRAYER_DOOR       = {new Tile(3122, 3102, 0)};

    // Ladder areas
    public static final Tile[] MINING_LADDER      = {new Tile(3088, 9520, 0)};
    public static final Tile[] BANK_LADDER        = {
            new Tile(3110, 3125, 0),
            new Tile(3112, 3127, 0)
    };

    // Areas
    public static final Area RESOURCE_AREA   = createAreaFromCorners(
            new Tile(3097, 3093, 0),
            new Tile(3105, 3098, 0)
    );
    public static final Area INSIDE_COOKING_AREA   = new Area(
            new Tile(3073, 3090, 0)
    );
    public static final Area OUTSIDE_COOKING_AREA   = createAreaFromCorners(
            new Tile(3079, 3080, 0),
            new Tile(3084, 3086, 0)
    );
    public static final Area PRE_QUEST_AREA1         = createAreaFromCorners(
            new Tile(3067, 3109, 0),
            new Tile(3078, 3114, 0)
    );
    public static final Area PRE_QUEST_AREA2         = createAreaFromCorners(
            new Tile(3081, 3127, 0),
            new Tile(3090, 3129, 0)
    );
    public static final Area MINING_AREA            = createAreaFromCorners(
            new Tile(3076, 9499, 0),
            new Tile(3084, 9508, 0)
    );
    public static final Area POST_MINING_AREA            = createAreaFromCorners(
            new Tile(3089, 9502, 0),
            new Tile(3094, 9503, 0)
    );
    public static final Area COMBAT_LADDER_AREA     = createAreaFromCorners(
            new Tile(3109, 9523, 0),
            new Tile(3113, 9527, 0)
    );
    public static final Area BANK_AREA              = createAreaFromCorners(
            new Tile(3118, 3119, 0),
            new Tile(3124, 3125, 0)
    );
    public static final Area PRAYER_AREA            = createAreaFromCorners(
            new Tile(3120, 3103, 0),
            new Tile(3128, 3110, 0)
    );

    public static final Area PRE_MAGE_AREA              = createAreaFromCorners(
            new Tile(3134, 3082, 0),
            new Tile(3139, 3083, 0)
    );

    public static final Area MAGE_AREA              = createAreaFromCorners(
            new Tile(3139, 3083, 0),
            new Tile(3143, 3089, 0)
    );

    // Paths
//    public static final Tile[] startingPath = {new Tile(3094, 3107, 0), new Tile(3098, 3107, 0), new Tile(3101, 3104, 0), new Tile(3101, 3100, 0), new Tile(3102, 3096, 0)};
//    public static final Tile[] cookingPath = {new Tile(3101, 3095, 0), new Tile(3097, 3092, 0), new Tile(3093, 3092, 0), new Tile(3089, 3091, 0), new Tile(3086, 3094, 0), new Tile(3085, 3090, 0), new Tile(3082, 3087, 0), new Tile(3079, 3084, 0), new Tile(3075, 3085, 0)};
//    public static final Tile[] questPath = {new Tile(3075, 3085, 0), new Tile(3074, 3089, 0), new Tile(3072, 3093, 0), new Tile(3071, 3097, 0), new Tile(3071, 3101, 0), new Tile(3071, 3105, 0), new Tile(3071, 3109, 0), new Tile(3071, 3113, 0), new Tile(3071, 3117, 0), new Tile(3072, 3121, 0), new Tile(3075, 3124, 0), new Tile(3079, 3126, 0), new Tile(3083, 3126, 0), new Tile(3086, 3123, 0)};
//    public static final Tile[] miningPath = {new Tile(3086, 3122, 0), new Tile(3088, 9520, 0), new Tile(3084, 9521, 0), new Tile(3080, 9518, 0), new Tile(3079, 9514, 0), new Tile(3081, 9510, 0), new Tile(3082, 9506, 0)};
//    public static final Tile[] postMiningPath = {new Tile(3082, 9499, 0), new Tile(3081, 9503, 0), new Tile(3085, 9504, 0), new Tile(3089, 9504, 0), new Tile(3093, 9503, 0), new Tile(3097, 9503, 0), new Tile(3101, 9503, 0), new Tile(3104, 9506, 0)};
//    public static final Tile[] combatPath = {new Tile(3105, 9508, 0), new Tile(3108, 9511, 0), new Tile(3111, 9515, 0), new Tile(3110, 9515, 0)};
//    public static final Tile[] reverseCombatPath = {new Tile(3110, 9515, 0), new Tile(3111, 9515, 0), new Tile(3108, 9511, 0), new Tile(3105, 9508, 0)};
//    public static final Tile[] bankPath = {new Tile(3106, 9508, 0), new Tile(3109, 9512, 0), new Tile(3112, 9516, 0), new Tile(3112, 9520, 0), new Tile(3111, 9524, 0), new Tile(3111, 3125, 0), new Tile(3112, 3121, 0), new Tile(3115, 3118, 0), new Tile(3118, 3114, 0), new Tile(3121, 3117, 0), new Tile(3121, 3121, 0)};
//    public static final Tile[] postBankPath = {new Tile(3120, 3121, 0), new Tile(3124, 3124, 0), new Tile(3128, 3124, 0)};
//    public static final Tile[] prayerPath = {new Tile(3128, 3124, 0), new Tile(3132, 3124, 0), new Tile(3133, 3120, 0), new Tile(3134, 3116, 0), new Tile(3131, 3113, 0), new Tile(3130, 3109, 0), new Tile(3126, 3107, 0)};
//    public static final Tile[] magePath = {new Tile(3124, 3107, 0), new Tile(3122, 3103, 0), new Tile(3124, 3099, 0), new Tile(3127, 3096, 0), new Tile(3128, 3092, 0), new Tile(3130, 3088, 0), new Tile(3134, 3087, 0), new Tile(3138, 3087, 0), new Tile(3142, 3088, 0)};

    public static final Tile[] startingPath = {new Tile(3098, 3107, 0), new Tile(3101, 3104, 0), new Tile(3101, 3100, 0), new Tile(3102, 3096, 0)};
    public static final Tile[] preCookingPath = {new Tile(3101, 3095, 0), new Tile(3097, 3092, 0), new Tile(3093, 3092, 0)};
    public static final Tile[] cookingPath = {new Tile(3089, 3092, 0), new Tile(3085, 3093, 0), new Tile(3084, 3089, 0), new Tile(3081, 3086, 0), new Tile(3079, 3084)};
    public static final Tile[] postCookingPath = {new Tile(3076, 3085, 0), new Tile(3075, 3089, 0)};
    public static final Tile[] questPath = {new Tile(3072, 3090, 0), new Tile(3072, 3094, 0), new Tile(3071, 3098, 0), new Tile(3071, 3102, 0), new Tile(3071, 3106, 0), new Tile(3071, 3110, 0), new Tile(3071, 3114, 0), new Tile(3071, 3118, 0), new Tile(3074, 3122, 0), new Tile(3077, 3125, 0), new Tile(3081, 3126, 0), new Tile(3085, 3126, 0)};
    public static final Tile[] miningPath = {new Tile(3088, 3120, 0), new Tile(3088, 9520, 0), new Tile(3084, 9521, 0), new Tile(3080, 9518, 0), new Tile(3079, 9514, 0), new Tile(3081, 9510, 0), new Tile(3082, 9506, 0)};
//    public static final Tile[] miningPath = {new Tile(3088, 9520, 0), new Tile(3084, 9521, 0), new Tile(3080, 9518, 0), new Tile(3079, 9514, 0), new Tile(3081, 9510, 0), new Tile(3082, 9506, 0)};
    public static final Tile[] postMiningPath = {new Tile(3082, 9499, 0), new Tile(3081, 9503, 0), new Tile(3085, 9504, 0), new Tile(3089, 9504, 0), new Tile(3093, 9503, 0)};
    public static final Tile[] preCombatPath = {new Tile(3095, 9502, 0), new Tile(3099, 9503, 0), new Tile(3103, 9505, 0), new Tile(3106, 9508)};
    public static final Tile[] combatPath = {new Tile(3105, 9508, 0), new Tile(3108, 9511, 0), new Tile(3111, 9515, 0), new Tile(3111, 9519, 0)};
    public static final Tile[] reverseCombatPath = {new Tile(3111, 9518, 0), new Tile(3111, 9514, 0), new Tile(3108, 9511, 0)};
    //    public static final Tile[] postCombatPath = {new Tile(3106, 9508, 0), new Tile(3109, 9512, 0), new Tile(3112, 9516, 0), new Tile(3112, 9520, 0), new Tile(3111, 9524, 0)};
    public static final Tile[] bankPath = {new Tile(3106, 9508, 0), new Tile(3109, 9512, 0), new Tile(3112, 9516, 0), new Tile(3112, 9520, 0), new Tile(3111, 9524, 0), new Tile(3111, 3125, 0), new Tile(3112, 3121, 0), new Tile(3115, 3118, 0), new Tile(3118, 3114, 0), new Tile(3121, 3117, 0), new Tile(3121, 3121, 0)};
//    public static final Tile[] bankPath = {new Tile(3111, 3125, 0), new Tile(3112, 3121, 0), new Tile(3115, 3118, 0), new Tile(3118, 3114, 0), new Tile(3121, 3117, 0), new Tile(3121, 3121, 0)};
    public static final Tile[] postBankPath = {new Tile(3120, 3121, 0), new Tile(3124, 3124, 0), new Tile(3128, 3124, 0)};
    public static final Tile[] prayerPath = {new Tile(3128, 3124, 0), new Tile(3132, 3124, 0), new Tile(3133, 3120, 0), new Tile(3134, 3116, 0), new Tile(3131, 3113, 0), new Tile(3130, 3109, 0), new Tile(3126, 3107, 0)};
    public static final Tile[] magePath = {new Tile(3124, 3107, 0), new Tile(3122, 3103, 0), new Tile(3124, 3099, 0), new Tile(3127, 3096, 0), new Tile(3128, 3092, 0), new Tile(3130, 3088, 0), new Tile(3134, 3087, 0), new Tile(3138, 3087, 0), new Tile(3142, 3088, 0)};

    public TutorialConstants(ClientContext ctx) {
        super(ctx);
    }
}
