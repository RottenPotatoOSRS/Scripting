package starterMining;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Constants;

public class StarterMinerComponents extends ClientAccessor {

	public final Component weaponSlot = ctx.widgets.component(Constants.EQUIPMENT_WIDGET, 17).component(1);
	public final Component inventoryTab = ctx.widgets.component(Constants.RESIZABLE_VIEWPORT_BOTTOM_LINE_WIDGET, 55);

	public StarterMinerComponents(ClientContext ctx) {
		super(ctx);
	}

}
