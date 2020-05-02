package tutorial;

import org.powerbot.script.PaintListener;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.awt.*;
import java.util.ArrayList;

import static tutorial.TutorialConstants.*;

@Script.Manifest(name="Tutorial Island v2", description="Completes tutorial island on a fresh account.", properties="client=4; author=RottenPotato;")

public class TutorialIsland extends PollingScript<ClientContext> implements PaintListener
{
    ArrayList<osrs.Task> tasks = new ArrayList<>();

    @Override
    public void start() {
        System.out.println("Tutorial Island v2");
        tasks.add(new CreateCharacter(ctx));
        tasks.add(new CantReach(ctx));
        tasks.add(new AcceptItem(ctx));
        tasks.add(new ClickInterface(ctx));
        tasks.add(new OpenTab(ctx));
        tasks.add(new Cook(ctx));
        tasks.add(new Firemake(ctx));
        tasks.add(new Woodcut(ctx));
        tasks.add(new Smith(ctx));
        tasks.add(new Smelt(ctx));
        tasks.add(new Mine(ctx));
        tasks.add(new Equip(ctx));
        tasks.add(new CastSpell(ctx));
        tasks.add(new ContinueChat(ctx));
        tasks.add(new Fish(ctx));
        tasks.add(new Bake(ctx));
        tasks.add(new OpenDoor(ctx));
        tasks.add(new Attack(ctx));
        tasks.add(new Talk(ctx));
        tasks.add(new PollBooth(ctx));
        tasks.add(new Bank(ctx));
        tasks.add(new Walk(ctx));
    }

    @Override
    public void poll() {
        if (ctx.inventory.select().id(bodyRuneID).count() > 0) {
            System.out.println("Tutorial complete!");
            ctx.controller.stop();
        }
        for(Task t : tasks) {
            if(t.activate()) {
                t.execute();
                break;
            }
        }
    }

    @Override
    public void repaint(Graphics graphics) {


    }
}