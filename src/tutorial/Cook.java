package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import osrs.Task;

import java.util.concurrent.Callable;

import static osrs.HelperMethods.useItemOnObject;
import static osrs.HelperMethods.useItemOnOtherItem;
import static tutorial.TutorialConstants.*;

public class Cook extends Task {
    public Cook(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(rawShrimpID).count() > 0 &&
                ctx.inventory.select().id(cookedShrimpID).count() == 0 &&
                !ctx.objects.select().id(fireID).poll().equals(ctx.objects.nil()) &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Cooking");

        // Light a log
        Item shrimp = ctx.inventory.select().id(rawShrimpID).poll();
        GameObject fire = ctx.objects.select().id(fireID).nearest().poll();

        try {
            useItemOnObject(shrimp, fire, ctx);
        } catch (Exception e) {
            System.out.println("Could not cook");
        }

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().id(cookedShrimpID).count() > 0;
            }
        }, 250, 10);
    }
}
