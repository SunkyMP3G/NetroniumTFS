package netro.content;

import mindustry.type.*;

public class NetroSectors {
    public static SectorPreset
        //Campaign
        firstSteps, outpost, abandonedMines, ironFortress, newThreat,
        //Challenges
        doubleDraw;

    public static void load(){
        //region Campaign
        firstSteps = new SectorPreset("first-steps", NetroPlanets.netroniumPlanet, 15){{
            alwaysUnlocked = true;
            difficulty = 0;
            captureWave = 10;
        }};
        outpost = new SectorPreset("outpost", NetroPlanets.netroniumPlanet, 175){{
            difficulty = 0;
        }};
        abandonedMines = new SectorPreset("abandoned-mines", NetroPlanets.netroniumPlanet, 219){{
            difficulty = 3;
            captureWave = 20;
        }};
        ironFortress = new SectorPreset("iron-fortress", NetroPlanets.netroniumPlanet, 220){{
            difficulty = 5;
        }};
        newThreat = new SectorPreset("new-threat", NetroPlanets.netroniumPlanet, 101){{
            difficulty = 5;
            isLastSector = true;
        }};
        //endregion Campaign

        //region Challenges
        doubleDraw = new SectorPreset("double-draw", NetroPlanets.netroniumPlanet, 218){{
            difficulty = 5;
            captureWave = 99;
        }};
        //endregion Challenges
    }
}