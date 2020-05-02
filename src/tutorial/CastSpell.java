package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.*;
import osrs.Task;

import java.util.concurrent.Callable;

import static osrs.HelperMethods.*;
import static tutorial.TutorialConstants.*;

public class CastSpell extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public CastSpell(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.select().id(mindRuneID).count() > 0 &&
                ctx.skills.experience(Constants.SKILLS_MAGIC) == 0 &&
                ctx.players.local().animation() == -1;
    }

    @Override
    public void execute() {
        System.out.println("Casting spell");

        // Cast wind strike
        Npc npc = ctx.npcs.select().id(chickenID).nearest().poll();
        if (!npc.inViewport()) { ctx.camera.turnTo(npc); }
        tutorialComponents.windStrike.click();
        randomSleep(400, 1200);
        npc.interact("Cast", npc.name());

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.skills.experience(Constants.SKILLS_MAGIC) > 0;
            }
        }, 250, 10);
    }
}
