package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class Mine extends Task {
    public Mine(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(bronzePickaxeID).count() > 0 &&
                (ctx.inventory.select().id(tinOreID).count() == 0 ||
                ctx.inventory.select().id(copperOreID).count() == 0) &&
                ctx.inventory.select().id(bronzeBarID).count() == 0 &&
                ctx.inventory.select().id(hammerID).count() == 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Mining");
        int rockID;

        // Mine
        if (ctx.inventory.select().id(tinOreID).count() == 0) {
            rockID = tinRockID;
        } else {
            rockID = copperRockID;
        }

        GameObject nearestRock = ctx.objects.select().id(rockID).nearest().poll();
        if (!nearestRock.inViewport()) { ctx.camera.turnTo(nearestRock); }

        nearestRock.interact("Mine");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().animation() != -1;
            }
        }, 250, 10);
    }
}
