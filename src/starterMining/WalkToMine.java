package starterMining;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.*;
import starterMining.StarterMinerComponents;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

import static starterMining.HelperMethods.*;
import static starterMining.StarterMinerConstants.*;

public class WalkToMine extends Task {

    StarterMinerComponents starterMinerComponents = new StarterMinerComponents(ctx);

    public WalkToMine(ClientContext ctx) { super(ctx); }

    @Override
    public boolean activate() {
        return ctx.skills.level(14) != 15;
    }

    @Override
    public void execute() {
        pathToDestination(pathToMine, ctx);
    }

}
