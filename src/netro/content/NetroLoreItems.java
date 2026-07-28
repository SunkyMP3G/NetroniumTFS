package netro.content;

import classes.*;
import mindustry.type.*;

public class NetroLoreItems {
    public static Item
            // Factions
            loreIntro, cruxLore, shardedLore, netroniumLore;

    public static void load(){
        loreIntro = new GuideItem("lore-intro"){{
            alwaysUnlocked = true;
        }};
        cruxLore = new GuideItem("crux-lore"){};
        shardedLore = new GuideItem("sharded-lore"){};
        netroniumLore = new GuideItem("netronium-lore"){};
    }
}