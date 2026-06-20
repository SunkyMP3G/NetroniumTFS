package netro.content;

import mindustry.type.*;

public class NetroSectors {
    public static SectorPreset
        //Campaign
        firstSteps, outpost, shipyard,

        //Challenges
        challengeI;

    public static void load(){
        //Difficulties
        float low = 0;
        float medium = 3;
        float high = 5;
        //float extreme = 8;
        //float eradication = 10;

        //region Campaign
        firstSteps = new SectorPreset("first-steps", NetroPlanets.netroniumPlanet, 15){{
            alwaysUnlocked = true;
            difficulty = low;
            captureWave = 10;
        }};
        outpost = new SectorPreset("outpost", NetroPlanets.netroniumPlanet, 175){{
            difficulty = low;
        }};
        shipyard = new SectorPreset("abandoned-shipyard", NetroPlanets.netroniumPlanet, 219){{
            difficulty = medium;
            captureWave = 20;
            isLastSector = true;
        }};
        //next sector positions: 220, 101
        //endregion Campaign

        //region Challenges
        challengeI = new SectorPreset("challenge-I", NetroPlanets.netroniumPlanet, 218){{
            difficulty = high;
            captureWave = 99;
        }};
        //endregion Challenges
    }
}