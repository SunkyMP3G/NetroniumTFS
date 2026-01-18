package netro.content;

import arc.graphics.*;
import mindustry.content.*;
import mindustry.type.*;

public class NetroLiquids {

    public static Liquid
        cleanWater, fuel, phomaxite, lava;

    public static void load(){
        cleanWater = new Liquid("clean-water", Color.valueOf("5a6cbc")){{
            heatCapacity = 0.4f;
            barColor = Color.valueOf("5a6cbc");
            effect = StatusEffects.wet;
            capPuddles = false;
        }};
        fuel = new Liquid("fuel", Color.valueOf("1b4239")){{
            viscosity = 0.6f;
            flammability = 1.2f;
            explosiveness = 1.2f;
            heatCapacity = 0.7f;
            barColor = Color.valueOf("3b6259");
            effect = StatusEffects.tarred;
            capPuddles = false;
            canStayOn.add(cleanWater);
        }};

        phomaxite = new CellLiquid("phomaxite", Color.valueOf("4dae58")){{
            viscosity = 0.9f;
            heatCapacity = 0.3f;
            temperature = 0.36f;
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
            viscosity = 0.8f;
            temperature = 1.2f;
            barColor = Color.valueOf("de9458");
            effect = NetroStatuses.lavaMelting;
            capPuddles = false;
        }};
    }
}