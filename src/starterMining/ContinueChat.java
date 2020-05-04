package starterMining;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

public class ContinueChat extends Task {

    public ContinueChat(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return ctx.chat.canContinue();
    }

    @Override
    public void execute() {
        System.out.println("Continue chat");
        ctx.chat.continueChat(true);

        // Wait until the chat header text changes
        Condition.wait(()-> !ctx.chat.chatting(), 250, 10);
    }
}
