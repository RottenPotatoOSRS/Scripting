package starterMining;

import org.powerbot.script.Condition;
import org.powerbot.script.Locatable;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;
import tutorial.TutorialComponents;

public class Bank extends Task {
    public Bank(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        Locatable nearestBank = ctx.objects.select().name("Bank booth").nearest().poll();
        return ctx.players.local().tile().distanceTo(nearestBank) < 5 &&
                ctx.inventory.select().count() > 0;
    }

    @Override
    public void execute() {
        System.out.println("Banking");

        if (!ctx.bank.inViewport()) { ctx.camera.turnTo(ctx.bank.nearest()); }
        if (ctx.bank.open()) Condition.wait(ctx.bank::opened, 250, 10);
        if (ctx.bank.depositInventory()) Condition.wait(()-> ctx.inventory.select().count() == 0, 250, 10);
        if (ctx.bank.close()) Condition.wait(ctx.bank::opened, 250, 10);

    }
}
