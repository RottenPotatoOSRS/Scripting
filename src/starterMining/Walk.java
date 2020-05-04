package starterMining;

import org.powerbot.script.Random;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;
import osrs.Walker;
import osrs.Task;

import static starterMining.MiningConstants.*;

public class Walk extends Task {
    Walker walker = new Walker(ctx);

    public Walk(ClientContext ctx) { super(ctx); }

    @Override
    public boolean activate() {
        return ctx.skills.level(Constants.SKILLS_MINING) >= 15 &&
                (ctx.inventory.select().count() > 27 ||
                ctx.players.local().tile().distanceTo(VARROCK_MINE_TO_BANK[0]) > 6);
    }

    @Override
    public void execute() {
        System.out.println("Walking");

        if (!ctx.movement.running() && ctx.movement.energyLevel() > Random.nextInt(15, 30))
            ctx.movement.running(true);

        Tile playerTile = ctx.players.local().tile();
        Tile[] path;

        if (playerTile.y() < (VARROCK_MINE_TO_BANK[0].y() - 10)) {
            path = LUMBY_TO_VARROCK_MINE;
        } else {
            path = BANK_TO_VARROCK_MINE;
        }
        //pathToDestination(pathToMine, ctx);
        if (path.length > 0 &&
                !ctx.players.local().inMotion() ||
                ctx.movement.destination().equals(Tile.NIL) ||
                ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
            if (ctx.inventory.isEmpty()) walker.walkPath(path);
            else walker.walkPathReverse(path);
        } }

}
