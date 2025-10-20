package netro.content;

import arc.graphics.*;
import mindustry.type.*;

public class NetroLoreItems {
    public static Item
            // Factions
            loreIntro, cruxLore, shardedLore, netroniumLore;

    public static void load(){
        loreIntro = new Item("lore-intro", Color.valueOf("000000")){{
            buildable = false;
            alwaysUnlocked = true;
            hideDatabase = true;
        }};
        cruxLore = new Item("crux-lore", Color.valueOf("000000")){{
            buildable = false;
            hideDatabase = true;
        }};
        shardedLore = new Item("sharded-lore", Color.valueOf("000000")){{
            buildable = false;
            hideDatabase = true;
        }};
        netroniumLore = new Item("netronium-lore", Color.valueOf("000000")){{
            buildable = false;
            hideDatabase = true;
        }};
    }
}