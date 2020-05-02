package tutorial;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Constants;
import org.powerbot.script.rt4.Npc;
import osrs.Task;
import osrs.Walker;

import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;
import static osrs.HelperMethods.*;

public class Talk extends Task {
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);
    Walker walker = new Walker(ctx);
    int npcID;

    public Talk(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        String instructionsText = tutorialComponents.instructionsHeader.text().toLowerCase();
        Npc closestNPC = ctx.npcs.select().id(npcIDs).nearest().peek();

        return tutorialComponents.instructionsHeader.visible() &&
                (instructionsText.contains("talk") ||
                instructionsText.contains("speak") ||
                instructionsText.contains("hear") ||
                instructionsText.contains("begin")) &&
                !instructionsText.contains("ladder");
    }

    @Override
    public void execute() {
        System.out.println("Talk");
        String instructionsText = tutorialComponents.instructionsHeader.text().toLowerCase();
        if (instructionsText.contains("gielinor")) {
            npcID = gielinorID;
        } else if (instructionsText.contains("survival")) {
            npcID = survivalID;
        } else if (instructionsText.contains("chef")) {
            npcID = chefID;
        } else if (instructionsText.contains("quest guide")) {
            npcID = questGuideID;
        } else if (instructionsText.contains("mining")) {
            npcID = miningID;
        } else if (instructionsText.contains("magic")) {
            npcID = mageInstructorID;
        } else if (instructionsText.contains("combat")) {
            npcID = vanakkaID;
        } else if (instructionsText.contains("monk") || instructionsText.contains("brother")) {
            npcID = brotherBraceID;
        } else if (instructionsText.contains("account")) {
            npcID = accountGuideID;
            doorIDs = removeItemFromArray(bankDoorInID, doorIDs);
        }
        Npc npc = ctx.npcs.select().id(npcID).poll();
        if (!npc.inViewport()) { ctx.camera.turnTo(npc); }

        if (!npc.inViewport() &&
                ctx.players.local().tile().distanceTo(npc) > 7) {
            Tile[] path = {ctx.players.local().tile()};

//            if (instructionsText.contains("next instructor")) {
//                path = startingPath;
//            } else if (instructionsText.contains("first meal") || instructionsText.contains("clicking on the minimap")) {
//                path = cookingPath;
//            } else if (instructionsText.contains("bread") || instructionsText.contains("run or walk")) {
//                path = questPath;
//            } else if (instructionsText.contains("caves") || instructionsText.contains("you a weapon")) {
//                path = miningPath;
//            } else if (instructionsText.contains("melee and ranged") || instructionsText.contains("made your first weapon")) {
//                path = postMiningPath;
//            } else if (instructionsText.contains("attack")) {
//                path = combatPath;
//            } else if (instructionsText.contains("your next task")) {
//                path = reverseCombatPath;
//            } else if (instructionsText.contains("indicated ladder") || instructionsText.contains("bank")) {
//                path = bankPath;
//            } else if (instructionsText.contains("polls")) {
//                path = postBankPath;
//            } else if (instructionsText.contains("next door") || instructionsText.contains("chapel")) {
//                path = prayerPath;
//            } else if (instructionsText.contains("final instructor")) {
//                path = magePath;
//            }
            if (npcID == mageInstructorID) {
                path = magePath;
            } else if (npcID == survivalID) {
                path = startingPath;
            } else if (npcID == chefID) {
                path = cookingPath;
            } else if (npcID == questGuideID) {
                path = questPath;
            } else if (npcID == miningID) {
                if (instructionsText.contains("you a weapon")) {
                    path = miningPath;
                } else if (instructionsText.contains("recap")) {
                    path = postMiningPath;
                }
            } else if (npcID == vanakkaID) {
                path = ratSlain ? reverseCombatPath : preCombatPath;
            } else if (npcID == brotherBraceID) {
                path = prayerPath;
            }

            if (!ctx.players.local().inMotion() || ctx.movement.destination().equals(Tile.NIL) || ctx.movement.destination().distanceTo(ctx.players.local()) < 5) {
                walker.walkPath(path);
            }
            Condition.wait(()-> !ctx.players.local().inMotion(), 250, 20);
            return;
        }

        if (npc.interact("Talk-to")) {
            Condition.wait(()-> tutorialComponents.chatBody.visible(), 250, 20);
        }
    }
}
