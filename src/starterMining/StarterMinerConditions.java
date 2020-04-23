package starterMining;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Constants;

import java.util.concurrent.Callable;

import static starterMining.StarterMinerConstants.bronzePickaxeId;

public class StarterMinerConditions extends ClientAccessor {

	StarterMinerComponents starterMinerComponents = new StarterMinerComponents(ctx);

	public StarterMinerConditions(ClientContext ctx) {
		super(ctx);
	}

}
