package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;
import static osrs.HelperMethods.*;

public class Firemake extends Task {
    public Firemake(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(bronzeAxeID).count() > 0 &&
                ctx.inventory.select().id(rawShrimpID).count() > 0 &&
                ctx.inventory.select().id(cookedShrimpID).count() == 0 &&
                ctx.inventory.select().id(logsID).count() > 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Firemaking");

        // Light a log
        Item tinderbox = ctx.inventory.select().id(tinderboxID).poll();
        Item logs = ctx.inventory.select().id(logsID).poll();

        try {
            useItemOnOtherItem(tinderbox, logs);
        } catch (Exception e) {
            System.out.println("No logs in inventory!");
        }

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !ctx.objects.select().id(fireID).poll().equals(ctx.objects.nil());
            }
        }, 250, 10);
    }
}
