package tutorialIsland;

import org.powerbot.script.Condition;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;

import static tutorialIsland.HelperMethods.*;
import static tutorialIsland.TutorialConstants.*;

public class ResourcesArea extends Task {
    // For accessing all of the ctx components and conditions
    TutorialComponents tutorialComponents = new TutorialComponents(ctx);
    TutorialConditions tutorialConditions = new TutorialConditions(ctx);

    public ResourcesArea(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return tutorialComponents.instructionsHeader.text().contains("survival expert") && //TODO need a better check
                tutorialComponents.instructionsHeader.height() == 84;
    }

    @Override
    public void execute() {
        System.out.println("We are outside");

        pathToArea(RESOURCE_AREA, ctx);

        // Talk to the survival expert
        Npc survivalExpert = getNpcWithID(true, survivalID, ctx);
        talkTo(true, survivalExpert, ctx);
        continueChat(ctx);
        tutorialComponents.continueItem.click();

        System.out.println("Clicking inventory tab");
        boolean tabReady = Condition.wait(tutorialConditions.tabReady, 300, 15);
        while (!tabReady) {
            continueChat(ctx);
            tutorialComponents.continueItem.click();
            tabReady = Condition.wait(tutorialConditions.tabReady, 300, 10);
        }

        tutorialComponents.inventoryTab.click();
        boolean tabClicked = Condition.wait(tutorialConditions.startFishing, 300, 15);
        while (!tabClicked) {
            tutorialComponents.inventoryTab.click();
            tabClicked = Condition.wait(tutorialConditions.startFishing, 300, 10);
        }

        System.out.println("Attempting to fish");

        // Fish
        Item shrimp = fish(ctx);
        // Keep attempting to fish until we catch a shrimp
        while(shrimp == null) {
            shrimp = fish(ctx);
        }
        continueChat(ctx);
        tabReady = Condition.wait(tutorialConditions.tabReady, 300, 10);
        while (!tabReady) {
            continueChat(ctx);
            tabReady = Condition.wait(tutorialConditions.tabReady, 300, 10);
        }
        tutorialComponents.statsTab.click();
        tabClicked = Condition.wait(tutorialConditions.skillReady, 300, 10);
        while (!tabClicked) {
            tutorialComponents.statsTab.click();
            tabClicked = Condition.wait(tutorialConditions.skillReady, 200, 10);
        }

        talkTo(true, survivalExpert, ctx);
        continueChat(ctx);
        boolean woodcutReady = Condition.wait(tutorialConditions.woodcutReady, 300, 10);
        while (!woodcutReady) {
            continueChat(ctx);
            woodcutReady = Condition.wait(tutorialConditions.woodcutReady, 300, 10);
        }

        // TODO clicks tree too much and then waits too long
        // Woodcut
        System.out.println("Attempting to woodcut");
        Item logs = woodcut(ctx);
        while(logs == null) {
            logs = woodcut(ctx);
        }

        System.out.println("Attempting to firemake");
        // Firemake
        GameObject fire = firemake(ctx);
        while(fire == null) {
            fire = firemake(ctx);
        }

        System.out.println("Attempting to cook");
        // Cook
        cook(shrimp, fire, ctx);
        boolean shrimpCooked = Condition.wait(tutorialConditions.shrimpCooked, 500, 10);
        while (!shrimpCooked) {
            cook(shrimp, fire, ctx);
            shrimpCooked = Condition.wait(tutorialConditions.shrimpCooked, 500, 10);
        }
        Item burntShrimp = getItemFromInventory(burntShrimpID, ctx);
        while (burntShrimp != null) {
            fishAndCook();
            burntShrimp = getItemFromInventory(burntShrimpID, ctx);
        }

        System.out.println("Continuing to next area!");
        // Continue to Quest Area
        openDoor(true, POST_RESOURCE_DOOR, gateID, ctx);

        System.out.println("Resource area completed!");
    }

    public Item fishAndCook() {
        System.out.println("Attempting to fish");
        Item shrimp = fish(ctx);
        // Keep attempting to fish until we catch a shrimp
        while(shrimp == null) {
            shrimp = fish(ctx);
        }

        // Woodcut
        System.out.println("Attempting to woodcut");
        Item logs = woodcut(ctx);
        while(logs == null) {
            logs = woodcut(ctx);
        }

        System.out.println("Attempting to firemake");
        // Firemake
        GameObject fire = firemake(ctx);
        while(fire == null) {
            fire = firemake(ctx);
        }

        System.out.println("Attempting to cook");
        // Cook
        Item cookedShrimp = cook(shrimp, fire, ctx);
        boolean shrimpCooked = Condition.wait(tutorialConditions.shrimpCooked, 500, 10);
        while (!shrimpCooked) {
            shrimp = cook(cookedShrimp, fire, ctx);
            shrimpCooked = Condition.wait(tutorialConditions.shrimpCooked, 500, 10);
        }

        return shrimp;
    }
}
