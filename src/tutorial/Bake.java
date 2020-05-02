package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

import static osrs.HelperMethods.*;
import static tutorial.TutorialConstants.*;

public class Bake extends Task {
    public Bake(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(flourID).count() > 0 &&
                ctx.inventory.select().id(breadID).count() == 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Baking");

        // Remove previous door
        doorIDs = removeItemFromArray(cookingDoorInID, doorIDs);

        // Make the dough
        Item flour = ctx.inventory.select().id(flourID).poll();
        Item bucketWater = ctx.inventory.select().id(bucketWaterID).poll();
        GameObject range = ctx.objects.select().id(rangeID).nearest().poll();

        useItemOnOtherItem(flour, bucketWater);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().id(doughID).count() > 0;
            }
        }, 250, 10);

        // Cook the dough
        Item dough = ctx.inventory.select().id(doughID).poll();
        useItemOnObject(dough, range, ctx);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().id(breadID).count() > 0;
            }
        }, 250, 10);
    }
}
