package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ChatOption;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.TextQuery;
import osrs.Task;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class ContinueChat extends Task {

    public ContinueChat(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        return ctx.chat.canContinue() |
                tutorialComponents.chatOptions.visible() |
                tutorialComponents.continueItem.visible();
    }

    @Override
    public void execute() {
        System.out.println("Continue chat");
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        // The current text of the chat header
        String chatText = tutorialComponents.chatBody.text();
        ctx.chat.continueChat(true, TutorialConstants.chatOptions);

        // Wait until the chat header text changes
        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return !chatText.equals(tutorialComponents.chatBody.text()) ||
                        !tutorialComponents.chatBody.visible();
            }
        }, 250, 10);
    }
}
