package starterMining;

import org.powerbot.script.Area;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.*;
import starterMining.StarterMinerComponents;

import static starterMining.HelperMethods.*;
import static starterMining.StarterMinerConstants.*;

public class WalkToMine extends Task {

    StarterMinerComponents starterMinerComponents = new StarterMinerComponents(ctx);

    public WalkToMine(ClientContext ctx) { super(ctx); }

    @Override
    public boolean activate() {
        return !playerInArea(MINING_AREA, ctx);
    }

    @Override
    public void execute() {
        // areas are still janky, gotta rewalk em :(
        pathToArea(new Area(area1), ctx);
        pathToArea(new Area(area2), ctx);
        pathToArea(new Area(area3), ctx);
        pathToArea(new Area(area4), ctx);
        pathToArea(new Area(area5), ctx);
        pathToArea(new Area(area6), ctx);
        pathToArea(new Area(area7), ctx);
    }

}
