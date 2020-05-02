package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import osrs.Task;
import osrs.Walker;

import static tutorial.TutorialConstants.*;
import static osrs.HelperMethods.*;


public class OpenDoor extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);

    public OpenDoor(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        String instructionsText = tutorialComponents.instructionsHeader.text();
        return !ratSlain &&
                tutorialComponents.instructionsHeader.visible() &&
                (instructionsText.contains("door") ||
                instructionsText.contains("gate") ||
                instructionsText.contains("gates") ||
                instructionsText.contains("run or walk"));
    }

    @Override
    public void execute() {
        System.out.println("Opening door");
        String instructionsText = tutorialComponents.instructionsHeader.text().toLowerCase();

        if (instructionsText.contains("run or walk")) {
            doorIDs = removeItemFromArray(cookingDoorOutID, doorIDs);
        }

        GameObject door = ctx.objects.select().id(doorIDs).nearest().poll();
        Tile[] path = {ctx.players.local().tile()};

        if (!door.inViewport()) {
            ctx.camera.turnTo(door);
        }
        if (ctx.players.local().tile().distanceTo(door) > 5) {
            if (instructionsText.contains("first meal")) {
                path = preCookingPath;
            } else if (instructionsText.contains("also move around")) {
                path = cookingPath;
                doorIDs = removeItemFromArray(gateID, doorIDs);
            } else if (instructionsText.contains("bread")) {
                path = postCookingPath;
                doorIDs = removeItemFromArray(cookingDoorInID, doorIDs);
            } else if (instructionsText.contains("run or walk")) {
                path = questPath;
            } else if (instructionsText.contains("first weapon")) {
                path = postMiningPath;
            } else if (instructionsText.contains("monsters")) {
                System.out.println("monsters");
                path = combatPath;
            } else if (instructionsText.contains("polls")) {
                path = postBankPath;
            }  else if (instructionsText.contains("almost finished")) {
//                path = postPrayerPath;
            }

            if (path.length > 0 &&
                    !ctx.players.local().inMotion() ||
                    ctx.movement.destination().equals(Tile.NIL) ||
                    ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
                Walker walker = new Walker(ctx);
                walker.walkPath(path);
                System.out.println(path.length);
                System.out.println(path[0]);
            }
            Condition.wait(()-> !ctx.players.local().inMotion(), 250, 40);
            return;
        } else {
            if (door.interact("Open")) {
                Condition.wait(()-> !ctx.players.local().inMotion(), 250, 20);
                if (instructionsText.contains("gate and talk")) {
                    ratSlain = true;
                }
            } else {
                ctx.camera.angle((int) (Math.random() * 360));
            }
        }
    }
}
