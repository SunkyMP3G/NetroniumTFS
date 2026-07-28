package netro.ui;

import arc.Core;
import arc.scene.ui.layout.*;
import mindustry.Vars;
import netro.content.*;

import static mindustry.Vars.renderer;

public class ModSettings {
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;

        Vars.ui.settings.addCategory("@planet.netroniummod-netronium.name", "netroniummod-setting-icon", root -> {
            //Disables camera control
            root.checkPref("disablecutscenes", false, val -> {
                NetroBlocks.cutsceneSkipper.health = val ? 1 : 0;
            });
            //Resets zoom level to default. For screenshots
            root.checkPref("resetzoom", false, val -> {
                renderer.setScale(Scl.scl(4));
            });
        });
    }

    public static boolean getDisableCutscenes(){
        return Core.settings.getBool("disablecutscenes", false);
    }
}