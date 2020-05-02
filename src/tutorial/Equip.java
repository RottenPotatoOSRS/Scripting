package tutorial;

import com.sun.org.apache.bcel.internal.classfile.ConstantNameAndType;
import org.powerbot.Con;
import org.powerbot.script.Condition;
import org.powerbot.script.rt4.*;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;
import static osrs.HelperMethods.*;

public class Equip extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public Equip(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (ctx.inventory.select().id(bronzeDaggerID).count() > 0 &&
                        tutorialComponents.equipmentX.visible()) ||
                (ctx.inventory.select().id(bronzeSwordID).count() > 0 &&
                        ctx.skills.experience(Constants.SKILLS_ATTACK) == 0) ||
                (ctx.inventory.select().id(woodShieldID).count() > 0 &&
                        ctx.skills.experience(Constants.SKILLS_ATTACK) == 0) ||
                ctx.inventory.select().id(arrowID).count() > 0 ||
                ctx.inventory.select().id(bowID).count() > 0;
    }

    @Override
    public void execute() {
        System.out.println("Equipping");

        // Remove previous door
        doorIDs = removeItemFromArray(metalGateID, doorIDs);

        int itemID;
        String action = "Wield";

        if (tutorialComponents.equipmentX.visible()) {
            itemID = bronzeDaggerID;
            action = "Equip";
        } else if (ctx.skills.experience(Constants.SKILLS_ATTACK) == 0) {
            if (ctx.inventory.select().id(bronzeSwordID).count() > 0) {
                itemID = bronzeSwordID;
            } else {
                itemID = woodShieldID;
            }
        } else if (ctx.inventory.select().id(arrowID).count() > 0) {
            itemID = arrowID;
        } else {
            itemID = bowID;
        }

        ctx.game.tab(Game.Tab.INVENTORY);

        // Equip item
        Item weapon = ctx.inventory.select().id(itemID).poll();

        weapon.interact(action);
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return ctx.inventory.select().id(itemID).count() == 0;
            }
        }, 250, 10);
    }
}
