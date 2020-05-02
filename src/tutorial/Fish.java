package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Game;
import org.powerbot.script.rt4.Npc;
import osrs.Task;
import tutorialIsland.HelperMethods;
import tutorialIsland.TutorialConditions;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;
import static tutorial.TutorialComponents.*;
import static osrs.HelperMethods.*;

public class Fish extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);
    public Fish(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(netID).count() > 0 &&
                ctx.inventory.select().id(rawShrimpID).count() == 0 &&
                ctx.inventory.select().id(cookedShrimpID).count() == 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Fishing");

        // Remove previous door
        doorIDs = removeItemFromArray(startingDoorID, doorIDs);

        // Fish a shrimp
        Npc nearestFishingSpot = ctx.npcs.select().id(fishingSpotID).nearest().poll();
        if (!nearestFishingSpot.inViewport()) { ctx.camera.turnTo(nearestFishingSpot); }

        /*
        if (ctx.players.local().tile().distanceTo(nearestFishingSpot) > 4) {
            System.out.println("Moving closer");
            Tile nearFishingSpot = new Tile(nearestFishingSpot.tile().x(), nearestFishingSpot.tile().y() + 2);
            ctx.movement.findPath(nearFishingSpot).traverse();
        }
         */

        nearestFishingSpot.interact("Net");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation() != -1;
            }
        }, 250, 10);
    }
}
