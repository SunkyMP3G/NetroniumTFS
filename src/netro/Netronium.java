package netro;

import arc.util.*;
import mindustry.mod.*;

import netro.content.*;
@SuppressWarnings("unused")

public class Netronium extends Mod{
    @Override
    public void loadContent(){
        NetroItems.load();
        NetroStatuses.load();
        NetroLiquids.load();
        NetroUnits.load();
        NetroBlocks.load();
        NetroWeathers.load();
        NetroLoadouts.load();
        NetroPlanets.load();
        NetroSectors.load();
        NetroTechTree.load();
        Log.info("Netronium mod (CU-2) is loaded successfully!");
    }
}