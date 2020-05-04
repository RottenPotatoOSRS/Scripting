package starterMining;

import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;
import osrs.Walker;

import static starterMining.MiningConstants.*;

public class Mine extends Task {
    Tile rockLocation = Tile.NIL;
    int miningLevel = ctx.skills.level(Constants.SKILLS_MINING);
    int[] ROCK_IDS = miningLevel < 15 ? COPPER_ROCK : IRON_ROCK;

    public Mine(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().animation() == -1 || ctx.objects.select().at(rockLocation).id(ROCK_IDS).poll().equals(ctx.objects.nil());
    }

    @Override
    public void execute() {
        System.out.println("Mining");

        if (miningLevel >= 15 && !ctx.players.local().tile().equals(VARROCK_IRON_TILE)) {
            System.out.println("Not in iron spot");
            ctx.movement.step(VARROCK_IRON_TILE);
            Condition.wait(()-> ctx.players.local().tile().equals(VARROCK_IRON_TILE), 250, 10);
        }

        Filter<GameObject> filter = (object) ->
                object.tile().equals(VARROCK_IRON_ROCK_TILES[0]) ||
                object.tile().equals(VARROCK_IRON_ROCK_TILES[1]);

        GameObject rock = ctx.objects.select().id(ROCK_IDS).nearest().select(filter).poll();
        rockLocation = rock.tile();
        rock.interact("Mine");
        Condition.wait(()-> ctx.players.local().animation() != -1, 250, 10);
    }
}
