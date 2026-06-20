package netro.ui;

import arc.Core;
import mindustry.Vars;
import mindustry.ui.dialogs.SettingsMenuDialog.SettingsTable.*;

public class ModSettings {
    private static boolean initialized = false;

    public static void init() {
        if (initialized) return;
        initialized = true;

        Vars.ui.settings.addCategory("Netronium", root -> {
            root.checkPref("disablecutscenes", false);

            for (Setting setting : root.getSettings()) {
                if (setting instanceof CheckSetting) {
                    CheckSetting check = (CheckSetting) setting;
                    check.title = "@settings." + check.name;
                }
            }
        });
    }

    public static boolean getDisableCutscenes(){
        return Core.settings.getBool("disablecutscenes", false);
    }
}