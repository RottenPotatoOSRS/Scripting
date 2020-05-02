package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Npc;
import osrs.Task;
import osrs.Walker;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class Walk extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);
    private final Walker walker = new Walker(ctx);

    public Walk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return tutorialComponents.instructionsHeader.visible() &&
                (tutorialComponents.instructionsHeader.text().contains("path") ||
                tutorialComponents.instructionsHeader.text().contains("ladder"));
    }

    @Override
    public void execute() {
        System.out.println("Pathing");

        String instructionsText = tutorialComponents.instructionsHeader.text().toLowerCase();
        Tile[] path = {ctx.players.local().tile()};

        if  (instructionsText.contains("caves") || instructionsText.contains("you a weapon")) {
            path = miningPath;
        } else if (instructionsText.contains("indicated ladder") || instructionsText.contains("bank")) {
            path = bankPath;
            ratSlain = false;
        }

        if (path.length > 0 &&
                !ctx.players.local().inMotion() ||
                ctx.movement.destination().equals(Tile.NIL) ||
                ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
            walker.walkPath(path);
        }
        Condition.wait(()-> !ctx.players.local().inMotion(), 250, 40);
    }
}
