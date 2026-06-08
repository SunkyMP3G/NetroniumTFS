package netro.content;

import arc.graphics.*;
import mindustry.type.*;

public class NetroItems {
    public static Item
    // T1
        dionite, gatride, plating, hermite,
    // T2
        tarant, microchip, refinedTarant,
    // Other
        soon;

    public static void load(){
        //region T1
        dionite = new Item("dionite", Color.valueOf("8a73c6")){{
            hardness = 1; // Mineable by dionite drill or better
            cost = 1f;
            buildable = true;
        }};
        gatride = new Item("gatride", Color.valueOf("62bfa9")){{
            hardness = 2;
            cost = 1f;
            buildable = true;
        }};
        hermite = new Item("hermite", Color.valueOf("dddddd")){{
            cost = 2f;
            buildable = true;
        }};
        plating = new Item("plating", Color.valueOf("88ff88")){{
            cost = 2f;
            buildable = true;
        }};
        //endregion T1

        //region T2
        tarant = new Item("tarant", Color.valueOf("eac2a9")){{
            hardness = 3; // At least Hermite Drill
            cost = 2f;
            buildable = true;
        }};
        microchip = new Item("microchip", Color.valueOf("99ff55")){{
            cost = 3f;
            buildable = true;
        }};
        //endregion T2

        //region Other
        soon = new Item("soon", Color.valueOf("000000")){{ // Soon™
            buildable = false;
            hideDatabase = true;
        }};
        //endregion Other
    }
}