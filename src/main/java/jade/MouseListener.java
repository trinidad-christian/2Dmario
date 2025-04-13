package jade;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class MouseListener {
    private static MouseListener instance;
    private double scrollX,scrollY;
    private double xPos, yPos, lasty, lastx  ;
    private boolean mouseButtonPressed[] = new boolean[3];
    private boolean isDragging;

    private MouseListener() {
        this.scrollX = 0.0;
        this.scrollY = 0.0;
        this.xPos =0.0;
        this.yPos=0.0;
        this.lasty=0.0;
        this.lastx=0.0;
    }

    public static MouseListener get() {
        if(MouseListener.instance ==null ) {
            MouseListener.instance = new MouseListener();
        }
        return MouseListener.instance;

    }
    //Has to match the code in the GLFW website if not this will not run
    public static void mousePosCallBack(long window, double xpos, double ypos) {
        get().lastx = get().xPos;
        get().lasty = get().yPos;
        get().xPos = xpos;
        get().yPos = ypos;

    }

    public static void mouseButtonCallBack (long window, int button, int action, int mods) {
        if(action == GLFW_PRESS) {
            if(button < get().mouseButtonPressed.length)
            get().mouseButtonPressed[button] = true;

        } else if (action == GLFW_RELEASE) {
            if(button < get().mouseButtonPressed.length) {
                get().mouseButtonPressed[button] = false;
                get().isDragging = false;
            }
        }
    }

    public static void scrollCallBack(long window, double xoffset, double yoffset ) {
        get().scrollX = xoffset;
        get().scrollY = yoffset;
    }

    public static void endFrame() {
        get().scrollX = 0;
        get().scrollY = 0;
        get().lastx = get().xPos;
        get().lasty = get().yPos;
    }

    public static float getX() {
      return (float)get().xPos;
    }

    public static float getY() {
        return (float)get().yPos;
    }


}

