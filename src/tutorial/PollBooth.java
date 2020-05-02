package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class PollBooth extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public PollBooth(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.players.local().tile().distanceTo(ctx.bank.nearest()) < 5 &&
                tutorialComponents.instructionsHeader.text().contains("poll");
    }

    @Override
    public void execute() {
        System.out.println("Poll Booth");

        GameObject pollBooth = ctx.objects.select().id(pollBoothID).nearest().poll();

        if (!pollBooth.inViewport()) {
            ctx.camera.turnTo(pollBooth);
        }
        pollBooth.interact("Use");
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return tutorialComponents.pollX.visible();
            }
        }, 250, 10);
    }
}
