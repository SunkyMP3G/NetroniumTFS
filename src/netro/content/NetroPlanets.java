package netro.content;

import arc.graphics.*;

import mindustry.content.*;
import mindustry.game.Team;
import mindustry.graphics.Pal;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.type.*;

public class NetroPlanets {
    public static Planet
        netroniumPlanet;

    public static void load(){
        netroniumPlanet = new Planet("netronium", Planets.sun, 1f, 3){{
            generator = new NetroPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 6);
            cloudMeshLoader = () -> new MultiMesh(
                new HexSkyMesh(this, 0, 0f, 0.14f, 2, Color.cyan.cpy().lerp(Color.valueOf("30d5c8"), 0.55f).a(0.4f), 0, 1f, 2f, 0.1f),
                new HexSkyMesh(this, 21, 0.6f, 0.15f, 5, Pal.lancerLaser.cpy().a(0.8f), 2, 0.42f, 1.2f, 0.45f)
            );

            defaultCore = NetroBlocks.coreHusk;
            clearSectorOnLose = true;
            allowLaunchToNumbered = false;
            allowCampaignRules = true;
            orbitRadius = 35;
            showRtsAIRule = true;

            sectorSeed = 0;
            ruleSetter = r -> {
                r.waveTeam = Team.crux;
                r.placeRangeCheck = false;
                r.hideSpawns = false;
                r.coreDestroyClear = true;
                r.lighting = false;
            };

            iconColor = Color.valueOf("9999ff");
            atmosphereColor = Color.valueOf("5c5ccc");
            atmosphereRadIn = 0f;
            atmosphereRadOut = 0.3f;
            startSector = 15;
            updateLighting = false;
            alwaysUnlocked = true;
            landCloudColor = Pal.lancerLaser.cpy().a(0.8f);
        }};
    }
}