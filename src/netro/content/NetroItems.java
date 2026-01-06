package netro.content;

import arc.graphics.*;
import mindustry.type.*;

public class NetroItems {
    public static Item
    // T1
        dionite, gatride, netroSand, hermite,
    // T2
        tarant, microchip,
    // Faulty items
        dust, faultyMicrochip,
    // Other
        soon;

    public static void load(){
        // T1
        dionite = new Item("dionite", Color.valueOf("8a73c6")){{
            hardness = 1; // Mineable by dionite drill or better
            cost = 1f;
            buildable = true;
        }};
        gatride = new Item("gatride", Color.valueOf("62bfa9")){{
            hardness = 2;
            cost = 2f;
            flammability = 0.1f;
            buildable = true;
        }};
        netroSand = new Item("netro-sand", Color.valueOf("fac6a2")){{
            hardness = 2;
            buildable = false;
        }};
        hermite = new Item("hermite", Color.valueOf("dddddd")){{
            cost = 4f;
            buildable = true;
        }};


        // T2
        tarant = new Item("tarant", Color.valueOf("eac2a9")){{
            hardness = 3; // At least Hermite Drill
            cost = 5f;
            buildable = true;
        }};
        microchip = new Item("microchip", Color.valueOf("99ff55")){{
            cost = 6f;
            buildable = true;
        }};


        // Faulty items
        dust = new Item("dust", Color.valueOf("333333")){{ // 10% Chance from Sand Separator
            buildable = false;
        }};
        faultyMicrochip = new Item("microchip-faulty", Color.valueOf("333333")){{ // 5% chance from Microchip Press
            buildable = false;
        }};

        // Other
        soon = new Item("soon", Color.valueOf("000000")){{ // Soon™
            buildable = false;
            alwaysUnlocked = true;
            hideDatabase = true;
        }};
    }
}