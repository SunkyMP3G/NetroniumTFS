package netro.content;

import arc.graphics.*;
import mindustry.type.*;

public class NetroItems {
    public static Item
    // T1
        dionite, trinite,
    // T2
        netroCopper, steelIngot,
    // T... (For later)
        neutroniumGem;

    public static void load(){
        dionite = new Item("dionite", Color.valueOf("8a73c6")){{
            hardness = 1; // Mineable by dionite drill or better
            cost = 1f;
            buildable = true;
        }};

        trinite = new Item("trinite", Color.valueOf("62bfa9")){{
            hardness = 2;
        }};

        netroCopper = new Item("netrocopper", Color.valueOf("d99d73")){{
            hardness = 4; // Mineable by aluminium drill or better
            cost = 3f;
            buildable = true;
        }};

        steelIngot = new Item("steel-ingot", Color.valueOf("d99d73")){{
            cost = 5f;
            buildable = true;
        }};

        neutroniumGem = new Item("neutronium-gem", Color.valueOf("ffa8af")){{ //TODO rebalance
            cost = 20f;
            buildable = true;
            radioactivity = 3.33f;
            charge = 1f;
        }};
    }
}