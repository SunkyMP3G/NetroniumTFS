package netro.content;

import arc.struct.*;
import static mindustry.content.TechTree.*;
import mindustry.game.*;
@SuppressWarnings("all")

public class NetroLoreTree {
    public static void load(){

        NetroPlanets.netroniumPlanet.techTree = nodeRoot("@netronium-lore-tt", NetroLoreItems.loreIntro, true, () -> {
            node(NetroLoreItems.shardedLore, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps)), () -> {
            });
            node(NetroLoreItems.cruxLore, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps)), () -> {
            });
            node(NetroLoreItems.netroniumLore, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps)), () -> {
            });
        });
    }
}