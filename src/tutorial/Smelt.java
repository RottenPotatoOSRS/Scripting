package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class Smelt extends Task {
    public Smelt(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(tinOreID).count() > 0 &&
                ctx.inventory.select().id(copperOreID).count() > 0 &&
                ctx.inventory.select().id(bronzeBarID).count() == 0 &&
                ctx.inventory.select().id(bronzeDaggerID).count() == 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Smelting");

        // Smelt ore
        GameObject furnace = ctx.objects.select().id(furnaceID).nearest().poll();
        if (!furnace.inViewport()) { ctx.camera.turnTo(furnace); }

        furnace.interact("Use");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation() != -1;
            }
        }, 250, 10);
    }
}
