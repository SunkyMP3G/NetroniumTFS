package netro.content;

import mindustry.type.*;

public class NetroSectors {
    public static SectorPreset
        firstSteps, theLake;

    public static void load(){
        firstSteps = new SectorPreset("first-steps", NetroPlanets.netroniumPlanet, 15){{
            alwaysUnlocked = true;
            difficulty = 0;
            captureWave = 10;
        }};
        theLake = new SectorPreset("the-lake", NetroPlanets.netroniumPlanet, 18){{
            difficulty = 0;
            isLastSector = true;
        }};
    }
}