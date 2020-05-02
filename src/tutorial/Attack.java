package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.Filter;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class Attack extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public Attack(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return tutorialComponents.instructionsHeader.text().contains("attack") &&
                !ctx.players.local().interacting().valid();
    }

    @Override
    public void execute() {
        System.out.println("Attacking");

        int npcID = giantRatID;

        Filter<Npc> healthNotVisible = new Filter<Npc>() {
            @Override
            public boolean accept(Npc npc) {
                return !npc.healthBarVisible();
            }
        };

        Npc npc = ctx.npcs.select().id(npcID).nearest().select(healthNotVisible).poll();
        if (!npc.inViewport()) { ctx.camera.turnTo(npc); }
        npc.interact("Attack");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.players.local().interacting().valid();
            }
        }, 250, 20);
    }
}
