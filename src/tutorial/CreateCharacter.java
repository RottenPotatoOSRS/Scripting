package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import osrs.Task;

import java.util.concurrent.Callable;

import static osrs.HelperMethods.randomSleep;

public class CreateCharacter extends Task {
    Component displayName  = ctx.widgets.component(558, 7);
    Component availability  = ctx.widgets.component(558, 12);
    Component suggestedName = ctx.widgets.component(558, 15);
    Component setName       = ctx.widgets.component(558, 18);
    Component acceptButton  = ctx.widgets.component(269, 100);

    public CreateCharacter(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return availability.visible();
    }

    @Override
    public void execute() {
        System.out.println("Setting a character name");
        // Generate character name
        String generatedName = "username"; // TODO generate random name
        displayName.click();
        randomSleep(400,800);
        // Try the name
        ctx.chat.sendInput(generatedName + "\n");
        Callable<Boolean> availabilityChecked = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return availability.text().contains("not");
            }
        };
        Condition.wait(availabilityChecked, 300, 15);

        // If name is not available, use a default name
        suggestedName.click();
        Callable<Boolean> nameAvailable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return availability.text().contains("Great!");
            }
        };
        Condition.wait(nameAvailable, 300, 15);

        // Set the name
        setName.click();
        Callable<Boolean> nameSet = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !setName.valid() && acceptButton.valid();
            }
        };
        Condition.wait(nameSet, 300, 15);

        System.out.println("Name has been set!");

        // Change clothes randomly
        changeClothes();
        randomSleep(500,1000);
        acceptButton.click();
        System.out.println("Character built!");
    }

    public void changeClothes() {
        int[] colorWidgets = {121, 122, 123, 124, 125, 127, 128, 129, 130, 131, 139};
        for (int i = 0; i < colorWidgets.length; i++) {
            if (Math.random() < 0.5) {
                ctx.widgets.component(269, colorWidgets[i]).click();
                randomSleep(100, 400);
            }
        }
        int x = (int) Math.random();
        // change head
        for (int j = 0; j < (int) Math.random() * 10; j++) {
            ctx.widgets.component(269, 113).click();
            randomSleep(50,200);
        }
        // change jaw
        for (int j = 0; j < (int) Math.random() * 10; j++) {
            ctx.widgets.component(269, 114).click();
            randomSleep(50,200);
        }
    }
}
