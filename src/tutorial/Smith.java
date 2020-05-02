package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class Smith extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public Smith(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(bronzeBarID).count() > 0 &&
                ctx.inventory.select().id(hammerID).count() > 0 &&
                ctx.inventory.select().id(bronzeDaggerID).count() == 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Smithing");

        // Smith dagger
        GameObject anvil = ctx.objects.select().id(anvilID).nearest().poll();
        if (!anvil.inViewport()) { ctx.camera.turnTo(anvil); }

        anvil.interact("Smith");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return tutorialComponents.bronzeDagger.visible();
            }
        }, 250, 10);

        tutorialComponents.bronzeDagger.click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().id(bronzeDaggerID).count() > 0;
            }
        }, 250, 10);
    }
}
