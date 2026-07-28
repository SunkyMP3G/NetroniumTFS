package netro;

import arc.util.Log;
import mindustry.Vars;
import mindustry.mod.Mod;
import netro.content.*;
import netro.ui.ModSettings;

@SuppressWarnings("unused")

public class Netronium extends Mod{
    public static final String modVersion = "CU-4";

    @Override
    public void loadContent(){
        NetroItems.load();
        NetroLoreItems.load();
        NetroGuideItems.load();
        NetroStatuses.load();
        NetroLiquids.load();
        NetroUnits.load();
        NetroBlocks.load();
        NetroWeathers.load();
        NetroLoadouts.load();
        NetroPlanets.load();
        NetroSectors.load();
        NetroLoreTree.load();
        NetroTechTree.load();
        Log.info("Netroniummod @ is fully loaded", modVersion);
    }

    @Override
    public void init() {
        if (!Vars.headless && Vars.ui != null) {
            ModSettings.init();
        }
    }
}