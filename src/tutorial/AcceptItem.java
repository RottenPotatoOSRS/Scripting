package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.util.concurrent.Callable;

public class AcceptItem extends Task {
    public AcceptItem(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        return tutorialComponents.continueItem.visible();
    }

    @Override
    public void execute() {
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        tutorialComponents.continueItem.click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !tutorialComponents.continueItem.visible();
            }
        }, 250, 10);
    }
}
