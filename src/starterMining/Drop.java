package starterMining;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Game;
import osrs.Task;

import static starterMining.MiningConstants.*;

public class Drop extends Task {
    public Drop(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        // Randomize so we don't always drop at a full inventory
        // Minimum is 26, then we have a 70% of making it 27, then a 70% chance of making it 28
        int maxItems = 26 + (int) (Math.random() + .70) + (int)(Math.random() + .70);
        return ctx.inventory.select().count() >= maxItems && ctx.skills.level(Constants.SKILLS_MINING) < 15 ||
                (ctx.players.local().tile().distanceTo(LUMBY_TO_VARROCK_MINE[0]) < 10 &&
                ctx.inventory.count() > 0);
    }

    @Override
    public void execute() {
        System.out.println("Dropping");

        ctx.game.tab(Game.Tab.INVENTORY);
        ctx.inventory.drop(ctx.inventory.select());
    }
}
