package starterMining;

import org.powerbot.script.*;
import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

import java.awt.*;
import java.util.ArrayList;

import static starterMining.HelperMethods.turnOnShiftDrop;

@Script.Manifest(name="Starter Miner", description="Starter Miner", properties="client=4; author=Chris; topic=999;")

public class StarterMiner extends PollingScript<ClientContext> implements PaintListener {

	ArrayList<osrs.Task> tasks = new ArrayList<>();

	@Override
	public void start() {
		turnOnShiftDrop(ctx);
		tasks.add(new ContinueChat(ctx));
		tasks.add(new EquipPickaxe(ctx));
		tasks.add(new Drop(ctx));
		tasks.add(new Bank(ctx));
		tasks.add(new Walk(ctx));
		tasks.add(new Mine(ctx));
		System.out.println("Starting Starter Miner!");
	}

	@Override
	public void poll() {
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
