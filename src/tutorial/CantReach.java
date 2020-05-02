package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.util.concurrent.Callable;

public class CantReach extends Task {
    public CantReach(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        return tutorialComponents.failureContinue.visible();
    }

    @Override
    public void execute() {
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        tutorialComponents.failureContinue.click();
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !tutorialComponents.failureContinue.visible();
            }
        }, 250, 10);
    }
}
