package starterMining;

import org.powerbot.script.rt4.ClientContext;
import osrs.Task;

public class Antiban extends Task {
    public Antiban(ClientContext ctx) {
        super(ctx);
    }

    @Override
    public boolean activate() {
        return Math.random() > .96;
    }

    @Override
    public void execute() {
        System.out.println("Antiban");
        int randomCameraAngle = (int) (Math.random() * 360);
        if (Math.random() < .25) {
            int randomCameraPitch = (int) (Math.random() * 100);
            ctx.camera.pitch(randomCameraPitch);
        }
        System.out.println("Angle: " + randomCameraAngle);
        ctx.camera.angle(randomCameraAngle);
    }
}
