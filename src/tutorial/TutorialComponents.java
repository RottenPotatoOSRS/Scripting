package tutorial;

import org.powerbot.script.rt4.ClientAccessor;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Component;
import org.powerbot.script.rt4.Constants;

public class TutorialComponents extends ClientAccessor {
    // Components
    public final Component instructionsHeader    = ctx.widgets.component(263, 1).component(0);
    public final Component continueItem          = ctx.widgets.component(193, 0).component(2);
    // TODO if this is visible we MUST click it
    public final Component failureContinue       = ctx.widgets.component(Constants.CHAT_INPUT, 45);
    public final Component chatBody              = ctx.widgets.component(Constants.CHAT_NPC, 4);
    // TODO is this right?
    public final Component chatOptions           = ctx.widgets.component(Constants.CHAT_WIDGET, 1);
    public final Component equipmentX            = ctx.widgets.component(84, 4);
    public final Component pollX                 = ctx.widgets.component(310, 2).component(11);

    public final Component bronzeDagger          = ctx.widgets.component(312, 9).component(2);
    public final Component wornEquipment         = ctx.widgets.component(Constants.EQUIPMENT_WIDGET, 1);
    public final Component windStrike            = ctx.widgets.component(Constants.SPELLBOOK_WIDGET, 6);
    public final Component music                 = ctx.widgets.component(261, 1).component(3);
    public final Component music0                = ctx.widgets.component(261, 1).component(38);
    public final Component sound0                = ctx.widgets.component(261, 1).component(44);
    public final Component area0                 = ctx.widgets.component(261, 1).component(50);
    public TutorialComponents(ClientContext ctx) {
        super(ctx);
    }
}
