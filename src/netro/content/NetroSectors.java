package netro.content;

import mindustry.type.*;

public class NetroSectors {
    public static SectorPreset
        firstSteps, theLake, shipyard, challengeI;

    public static void load(){

        // Difficulty list:
        // (0-7) Low, medium, high - straightforward
        // (8) Challenge - optional sector, bans all techs above it so the sector always has the same difficulty
        // (10) Boss - Any sector that has a boss

        firstSteps = new SectorPreset("first-steps", NetroPlanets.netroniumPlanet, 15){{
            alwaysUnlocked = true;
            difficulty = 0;
            captureWave = 10;
        }};
        theLake = new SectorPreset("the-lake", NetroPlanets.netroniumPlanet, 18){{
            difficulty = 0;
        }};
        shipyard = new SectorPreset("abandoned-shipyard", NetroPlanets.netroniumPlanet, 35){{
            difficulty = 10;
            captureWave = 20;
            isLastSector = true;
        }};
        challengeI = new SectorPreset("challenge-I", NetroPlanets.netroniumPlanet, 11){{
            difficulty = 8;
            captureWave = 99;
        }};
    }
}