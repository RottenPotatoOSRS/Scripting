package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.Locatable;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.util.concurrent.Callable;

public class Bank extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        //System.out.println(ctx.players.local().tile() + ", " + (ctx.bank.nearest()));
        //System.out.println(ctx.players.local().tile().distanceTo(ctx.bank.nearest()));
        Locatable nearestBank = ctx.objects.select().name("Bank booth").nearest().poll();
        return ctx.players.local().tile().distanceTo(nearestBank) < 5 &&
                tutorialComponents.instructionsHeader.text().contains("bank");
    }

    @Override
    public void execute() {
        System.out.println("Banking");

        if (!ctx.bank.inViewport()) { ctx.camera.turnTo(ctx.bank.nearest()); }
        ctx.bank.open();
        Condition.wait(()-> ctx.bank.opened(), 250, 10);

        ctx.bank.close();
        Condition.wait(()-> ctx.bank.opened(), 250, 10);

    }
}
