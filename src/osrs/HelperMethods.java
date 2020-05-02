package osrs;

import org.powerbot.script.Condition;
import org.powerbot.script.Tile;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;
import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.Npc;

import java.util.Random;
import java.util.concurrent.Callable;

import static tutorial.TutorialConstants.*;

public class HelperMethods {

    /**
     * Uses the Condition.sleep() method to sleep a random number of seconds
     * @param min
     *      the shortest possible sleep time
     * @param max
     *      the longest possible sleep time
     */
    public static void randomSleep(int min, int max) {
        Random rand = new Random();
        int sleepTime = rand.nextInt(min + max) + min;
        Condition.sleep(sleepTime);
    }

    /**
     * Removes the first occurance of an int from an int array
     * @param item the int to remove
     * @param arr the array to remove an item from
     * @return an array of size arr.length -1, without the item
     */
    public static int[] removeItemFromArray(int item, int[] arr) {
        int[] newArr = new int[arr.length - 1];
        boolean removed = false;
        for (int i = 0, j = 0; i < newArr.length; i++, j++) {
            if (arr[i] == item && !removed) {
                j++;
                removed = true;
            }
            newArr[i] = arr[j];
        }
        return removed ? newArr : arr;
    }
    /**
     * Uses an item on another item
     * @param useThis the first item to click
     * @param onThis the second item to click
     */
    public static void useItemOnOtherItem(Item useThis, Item onThis) {
        useThis.interact("Use");
        onThis.interact("Use", onThis.name());
    }

    /**
     * Uses an item on an object
     * @param useThis the item to use
     * @param onThis the object to use the item on
     */
    public static void useItemOnObject(Item useThis, GameObject onThis, ClientContext ctx) {
        if (!onThis.inViewport()) { ctx.camera.turnTo(onThis); }
        useThis.interact("Use");
        onThis.interact("Use", onThis.name());
    }
}
