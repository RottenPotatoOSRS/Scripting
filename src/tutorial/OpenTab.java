package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Game;
import osrs.Task;

import java.util.concurrent.Callable;

public class OpenTab extends Task {
    Component tab;

    public OpenTab(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        return tutorialComponents.instructionsHeader.text().contains("icon");
    }

    @Override
    public void execute() {
        System.out.println("Opening tab");
        TutorialComponents tutorialComponents = new TutorialComponents(ctx);
        String instructionsText = tutorialComponents.instructionsHeader.text().toLowerCase();
        if (instructionsText.contains("options")) {
            ctx.game.tab(Game.Tab.OPTIONS);
        } else if (instructionsText.contains("skills")) {
            ctx.game.tab(Game.Tab.STATS);
        } else if (instructionsText.contains("quest")) {
            ctx.game.tab(Game.Tab.QUESTS);
        } else if (instructionsText.contains("inventory")) {
            ctx.game.tab(Game.Tab.INVENTORY);
        } else if (instructionsText.contains("swords")) {
            ctx.game.tab(Game.Tab.ATTACK);
        } else if (instructionsText.contains("account")) {
            ctx.game.tab(Game.Tab.ACCOUNT_MANAGEMENT);
        } else if (instructionsText.contains("man")) {
            ctx.game.tab(Game.Tab.EQUIPMENT);
        } else if (instructionsText.contains("prayer")) {
            ctx.game.tab(Game.Tab.PRAYER);
        } else if (instructionsText.contains("friends")) {
            ctx.game.tab(Game.Tab.FRIENDS_LIST);
        } else if (instructionsText.contains("magic")) {
            ctx.game.tab(Game.Tab.MAGIC);
        }

        Condition.wait(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return tab.textureId() != -1;
            }
        }, 250, 10);
    }
}
