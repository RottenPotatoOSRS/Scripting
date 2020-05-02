package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Npc;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;
import static tutorialIsland.TutorialConstants.fishingSpotID;

public class Woodcut extends Task {
    public Woodcut(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(bronzeAxeID).count() > 0 &&
                ctx.inventory.select().id(rawShrimpID).count() > 0 &&
                ctx.inventory.select().id(cookedShrimpID).count() == 0 &&
                ctx.inventory.select().id(logsID).count() == 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Woodcutting");

        // Cut a tree
        GameObject nearestTree = ctx.objects.select().id(treeID).nearest().poll();
        if (!nearestTree.inViewport()) { ctx.camera.turnTo(nearestTree); }

        nearestTree.interact("Chop down");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation() != -1;
            }
        }, 250, 10);
    }
}
