package ironMiner;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

import static ironMiner.HelperMethods.playerInArea;
import static ironMiner.HelperMethods.randomSleep;
import static ironMiner.MiningConstants.bankArea;
import static ironMiner.MiningConstants.bankBoothID;

public class BankingTask extends Task {

    public BankingTask(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.inventory.isFull() && playerInArea(bankArea, ctx);
    }

    @Override
    public void execute() {
        System.out.println("Banking");
        GameObject bankBooth = ctx.objects.select().id(bankBoothID).nearest().poll();
        ctx.camera.turnTo(bankBooth);
        bankBooth.interact("Use");
        randomSleep(500, 1000);
        ctx.bank.depositInventory();
        randomSleep(500, 1000);
        ctx.bank.close();
        ctx.camera.angleTo(50);
    }

}