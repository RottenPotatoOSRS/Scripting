package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class ClickInterface extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public ClickInterface(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return (tutorialComponents.equipmentX.visible() &&
                ctx.inventory.select().id(bronzeDaggerID).count() == 0) ||
                tutorialComponents.pollX.visible() ||
                tutorialComponents.instructionsHeader.text().contains("helmet");
    }

    @Override
    public void execute() {
        System.out.println("Interface");

        Component component;
        if (tutorialComponents.pollX.visible()){
            component = tutorialComponents.pollX;
        } else if (ctx.inventory.select().id(bronzeDaggerID).count() == 0) {
            component = tutorialComponents.equipmentX;
        } else {
            component = tutorialComponents.wornEquipment;
        }
        component.click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                if (component.equals(tutorialComponents.pollX)) { return !component.visible(); }
                Component equipmentInterface = tutorialComponents.equipmentX;
                return component.equals(equipmentInterface) ? !equipmentInterface.visible() : equipmentInterface.visible();
            }
        }, 25, 20);

    }
}
