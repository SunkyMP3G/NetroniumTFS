package netro.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;

public class NetroLiquids {

    public static Liquid
        cleanWater, phomaxite, lava;

    public static void load(){
        cleanWater = new Liquid("clean-water", Color.valueOf("7a8cdc")){{ //TODO recolor
            viscosity = 0.3f;
            temperature = 0.4f;
            heatCapacity = 0.4f;
            barColor = Color.valueOf("7a8cdc");
            effect = StatusEffects.wet;
            capPuddles = false;
        }};

        phomaxite = new CellLiquid("phomaxite", Color.valueOf("4dae58")){{
            viscosity = 0.9f;
            heatCapacity = 0.3f;
            temperature = 0.36f;
            flammability = 0f;
            incinerable = false;
            moveThroughBlocks = false;
            coolant = false;
            barColor = Color.valueOf("4dae58");
            effect = NetroStatuses.corrosion;
            capPuddles = false;
            spreadTarget = NetroLiquids.cleanWater;

            colorFrom = Color.valueOf("55e665");
            colorTo = Color.valueOf("3c7042");
        }};

        lava = new Liquid("lava", Color.valueOf("de9458")){{
            viscosity = 0.6f;
            heatCapacity = 0f;
            temperature = 2f;
            barColor = Color.valueOf("de9458");
            effect = NetroStatuses.lavaMelting;
            capPuddles = false;
        }};
    }
}