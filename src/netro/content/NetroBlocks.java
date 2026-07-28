package netro.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import classes.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import static mindustry.type.ItemStack.*;
import mindustry.world.*;
import mindustry.world.blocks.campaign.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.storage.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;
import netro.ui.ModSettings;

public class NetroBlocks {
    public static Block

    //region Stuff
    // Environment
    crystallicFloor, crystallicFloorAlt, stoneFloor, gatrideFloor, retorFloor, iceFloor, metalLines,
    crystallicWall, stoneOreWall, gatrideWall, retorWall,

    // Props
    crystallicBoulder, crystallicCrystal, gatrideBoulder, retorCrystal,

    // Vents
    crystallicVent, gatrideVent, retorVent,

    // Ores
    oreDionite, oreGatride, oreTarant,

    // Environment liquids
    lavaFloor,

    // Cores
    coreHusk, coreDome,

    // Storage
    itemContainer, netroUnloader,

    // Drills
    dioniteDrill, hermiteDrill, wallDrill,

    // Transport
    dioniteConveyor, dioniteRouter, dioniteUndConveyor,
    netroSorter, netroInvertedSorter, netroOverflowGate, netroUnderflowGate,
    hermiteLaunchPad, netroLandingPad,

    // Liquids
    hermitePump, hermitePipe, hermiteRouter, hermiteLiquidContainer, hermiteUndPipe,

    // Production
    platingPress, circuitAssembler, gatrideCrusher, waterBoiler, waterCooler,

    // Energy
    dioniteWire, dioniteNode,

    // Turrets
    origin, tesla, flamethrower, hook,

    // Walls
    dioniteWall, largeDioniteWall, dioniteDoor,
    platedWall, largePlatedWall,

    // Support
    tarantBuildTower,

    // Units
    dioniteAssembler, tarantReassembler,

    // Payload
    hermitePayloadConveyor, hermitePayloadRouter,

    // Utility
    dioniteRadar, tarantRadar,

    // Logic
    netroProcessor, netroMessage, netroCell, netroSwitch,

    // Editor only
    portableGenerator, supersteelWall, largeSupersteelWall, volcano, cutsceneSkipper;
    //endregion Stuff

    public static void load(){
        //region Variables
        float seconds = 60f;
        float energy = 60f;
        float fluid = 60f;
        //endregion Variables

        //region Environment
        crystallicFloor = new Floor("crystallic-floor"){{
            variants = 4;
            wall = NetroBlocks.crystallicWall;
        }};
        crystallicFloorAlt = new Floor("crystallic-floor-alt"){{
            variants = 3;
            wall = NetroBlocks.crystallicWall;
        }};
        stoneFloor = new Floor("stone-floor"){{
            variants = 3;
            wall = NetroBlocks.stoneOreWall;
        }};
        gatrideFloor = new Floor("gatride-floor"){{
            variants = 6;
            wall = NetroBlocks.gatrideWall;
        }};
        retorFloor = new Floor("retor-floor"){{
            variants = 3;
            wall = NetroBlocks.retorWall;
        }};
        iceFloor = new Floor("ice-floor"){{
            variants = 3;

            speedMultiplier = 0.9f;
            dragMultiplier = 0.07f;
        }};
        metalLines = new Floor("metal-lines"){{
            variants = 16;
        }};
        crystallicWall = new StaticWall("crystallic-wall"){{
            variants = 3;
            attributes.set(NetroAttributes.hermite, 0.8f);
        }};
        stoneOreWall = new StaticWall("stone-ore-wall"){{
            variants = 3;
            attributes.set(NetroAttributes.hermite, 1.2f);
        }};
        gatrideWall = new StaticWall("gatride-wall"){{
            variants = 3;
            attributes.set(NetroAttributes.hermite, 1f);
        }};
        retorWall = new StaticWall("retor-wall"){{
            variants = 3;
            attributes.set(NetroAttributes.hermite, 0.75f);
        }};
        //They are gray, so assume they are made of hermite.
        Blocks.metalWall1.attributes.set(NetroAttributes.hermite, 1.2f);
        Blocks.metalWall2.attributes.set(NetroAttributes.hermite, 1.2f);
        Blocks.metalWall3.attributes.set(NetroAttributes.hermite, 1.2f);
        //endregion Environment

        //region Props
        crystallicBoulder = new Prop("crystallic-boulder"){{
            variants = 2;
            crystallicFloor.asFloor().decoration = this;
        }};
        crystallicCrystal = new TallBlock("crystallic-crystals"){{ //Wow nice name
            variants = 3;
            clipSize = 128f;
        }};
        gatrideBoulder = new Prop("gatride-boulder"){{
            variants = 2;
            gatrideFloor.asFloor().decoration = this;
        }};
        retorCrystal = new TallBlock("retor-crystal"){{
            variants = 0;
            clipSize = 128f;
        }};
        //endregion Props

        //region Vents
        crystallicVent = new SteamVent("crystallic-vent"){{
            variants = 2;
            parent = blendGroup = crystallicFloor;
            attributes.set(Attribute.steam, 1f);
        }};
        gatrideVent = new SteamVent("gatride-vent"){{
            variants = 2;
            parent = blendGroup = gatrideFloor;
            attributes.set(Attribute.steam, 1f);
        }};
        retorVent = new SteamVent("retor-vent"){{
            variants = 2;
            parent = blendGroup = retorFloor;
            attributes.set(Attribute.steam, 1f);
        }};
        //endregion Vents

        //region Ores
        oreDionite = new OreBlock("ore-dionite", NetroItems.dionite){{
            variants = 2;
        }};
        oreGatride = new OreBlock("ore-gatride", NetroItems.gatride){{
            variants = 2;
        }};
        oreTarant = new OreBlock("ore-tarant", NetroItems.tarant){{
            variants = 2;
        }};
        //endregion Ores

        //region Environment liquids
        lavaFloor = new Floor("lava-floor"){{
            isLiquid = true;
            drownTime = 80f;
            speedMultiplier = 0.4f;
            variants = 0;
            liquidDrop = NetroLiquids.lava;
            status = NetroStatuses.lavaMelting;
            statusDuration = 10*seconds;
            albedo = 0f;
            cacheLayer = CacheLayer.slag;
            lightColor = Color.valueOf("f8c266");
            lightRadius = 40f;
        }};
        //endregion Environment liquids

        //region Cores
        coreHusk = new NetroCoreBlock("core-husk"){{
            requirements(Category.effect, with(NetroItems.dionite, 500, NetroItems.gatride, 300));
            health = 1800;
            armor = 2f;
            size = 2;

            unitType = NetroUnits.unite;
            itemCapacity = 1000;
            thrusterLength = 12/2f;
            isFirstTier = true;
            requiresCoreZone = true;
            incinerateNonBuildable = true;
            unitCapModifier = 10;
            powerProduction = 180/energy;

            alwaysUnlocked = true;
            squareSprite = false;
        }};
        coreDome = new NetroCoreBlock("core-dome"){{
            requirements(Category.effect, with(NetroItems.dionite, 700, NetroItems.hermite, 400, NetroItems.tarant, 300, NetroItems.microchip, 60));
            researchCost = with(NetroItems.dionite, 1400, NetroItems.hermite, 700, NetroItems.tarant, 600, NetroItems.microchip, 200);
            health = 4000;
            armor = 5f;
            size = 3;

            unitType = NetroUnits.verge;
            itemCapacity = 2000;
            thrusterLength = 12/2f;
            incinerateNonBuildable = true;
            unitCapModifier = 16;
            powerProduction = 300/energy;

            squareSprite = false;
        }};
        //endregion Cores

        //region Storage
        itemContainer = new StorageBlock("item-container"){{
            requirements(Category.effect, with(NetroItems.dionite, 150, NetroItems.hermite, 80));
            researchCost = with(NetroItems.dionite, 400, NetroItems.hermite, 150);
            health = 400;
            armor = 3;
            size = 2;

            itemCapacity = 150;

            squareSprite = false;
        }};
        netroUnloader = new DirectionalUnloader("netro-unloader"){{
            requirements(Category.distribution, with(NetroItems.dionite, 30, NetroItems.microchip, 5));
            researchCost = with(NetroItems.dionite, 200, NetroItems.microchip, 20);
            health = 120;

            speed = 2f;
            solid = false;
            underBullets = true;
            regionRotated1 = 1;
            allowCoreUnload = false;

            squareSprite = false;
        }};
        //endregion Storage

        //region Drills
        dioniteDrill = new Drill("dionite-drill"){{
            requirements(Category.production, with(NetroItems.dionite, 10));
            researchCost = with(NetroItems.dionite, 20);
            health = 110;
            size = 2;

            drillTime = 240f;
            tier = 2;
            consumePower(1/energy);
            consumeLiquid(NetroLiquids.cleanWater, 2f/fluid).boost();
            liquidBoostIntensity = 1.2f;
            liquidCapacity = 10f;

            squareSprite = false;
        }};
        hermiteDrill = new Drill("hermite-drill"){{
            requirements(Category.production, with(NetroItems.dionite, 40, NetroItems.gatride, 15, NetroItems.hermite, 8));
            researchCost = with(NetroItems.dionite, 400, NetroItems.gatride, 300, NetroItems.hermite, 60);
            health = 180;
            size = 2;

            drillTime = 200f;
            tier = 4;
            consumePower(2/energy);
            consumeLiquid(NetroLiquids.cleanWater, 3f/fluid).boost();
            liquidBoostIntensity = 1.2f;
            liquidCapacity = 10f;

            squareSprite = false;
        }};
        wallDrill = new WallCrafter("hermite-wall-drill"){{
            requirements(Category.production, with(NetroItems.dionite, 80, NetroItems.gatride, 50));
            researchCost = with(NetroItems.dionite, 200, NetroItems.gatride, 100);
            health = 240;
            size = 2;

            drillTime = 200f;
            output = NetroItems.hermite;
            attribute = NetroAttributes.hermite;
            consumePower(3/energy);
            consumeLiquid(NetroLiquids.cleanWater, 3f/fluid).boost();
            liquidBoostIntensity = 1.2f;
            liquidCapacity = 10f;
            ambientSound = Sounds.loopDrill;
            ambientSoundVolume = 0.04f;

            squareSprite = false;
        }};
        //endregion Drills

        //region Transport
        dioniteConveyor = new Conveyor("dionite-conveyor"){{
            requirements(Category.distribution, with(NetroItems.dionite, 1));
            researchCost = with(NetroItems.dionite, 5);
            health = 45;
            speed = 0.06f;

            displayedSpeed = 9f;
            underBullets = true;
        }};
        dioniteRouter = new Router("dionite-router"){{
            requirements(Category.distribution, with(NetroItems.dionite, 3));
            researchCost = with(NetroItems.dionite, 8);
            health = 90;

            underBullets = true;
        }};
        dioniteUndConveyor = new DuctBridge("dionite-und-conveyor"){{
            requirements(Category.distribution, with(NetroItems.dionite, 20));
            researchCost = with(NetroItems.dionite, 40);
            health = 140;

            range = 4;
            speed = 6.66f;
            underBullets = true;
            ((Conveyor)dioniteConveyor).bridgeReplacement = this;
            crushFragile = true;
        }};
        netroSorter = new Sorter("netro-sorter"){{
            requirements(Category.distribution, with(NetroItems.dionite, 10, NetroItems.microchip, 2));
            researchCost = with(NetroItems.dionite, 120, NetroItems.microchip, 5);
            health = 150;

            buildCostMultiplier = 2f;
        }};
        netroInvertedSorter = new Sorter("netro-inverted-sorter"){{
            requirements(Category.distribution, with(NetroItems.dionite, 10, NetroItems.microchip, 2));
            researchCost = with(NetroItems.dionite, 120, NetroItems.microchip, 5);
            health = 150;

            buildCostMultiplier = 2f;
            invert = true;
        }};
        netroOverflowGate = new OverflowGate("netro-overflow-gate"){{
            requirements(Category.distribution, with(NetroItems.dionite, 10, NetroItems.microchip, 2));
            researchCost = with(NetroItems.dionite, 120, NetroItems.microchip, 5);
            health = 150;

            buildCostMultiplier = 2f;
        }};
        netroUnderflowGate = new OverflowGate("netro-underflow-gate"){{
            requirements(Category.distribution, with(NetroItems.dionite, 10, NetroItems.microchip, 2));
            researchCost = with(NetroItems.dionite, 120, NetroItems.microchip, 5);
            health = 150;

            buildCostMultiplier = 2f;
            invert = true;
        }};
        hermiteLaunchPad = new LaunchPad("hermite-launch-pad"){{
            requirements(Category.effect, with(NetroItems.dionite, 250, NetroItems.gatride, 200, NetroItems.hermite, 100, NetroItems.microchip, 30));
            researchCost = with(NetroItems.dionite, 2500, NetroItems.gatride, 2000, NetroItems.hermite, 900, NetroItems.microchip, 150);
            health = 900;
            size = 3;

            itemCapacity = 70;
            launchTime = 40*seconds;
            lightSteps = 2;
            hasPower = true;
            consumePower(30f/energy);
            consumeLiquid(NetroLiquids.fuel, 9f/fluid);
            drawLiquid = Liquids.oil;
            liquidCapacity = 40f;

            squareSprite = false;
            hideDatabase = true;
        }};
        netroLandingPad = new LandingPad("netro-landing-pad"){{
            requirements(Category.effect, with(NetroItems.dionite, 150, NetroItems.gatride, 120, NetroItems.hermite, 40, NetroItems.microchip, 10));
            researchCost = with(NetroItems.dionite, 700, NetroItems.gatride, 600, NetroItems.hermite, 500, NetroItems.microchip, 50);
            health = 700;
            size = 3;

            itemCapacity = 200;
            coolingEffect = new RadialEffect(Fx.steamCoolSmoke, 4, 90f, 7.5f, 180f);
            consumeLiquid = NetroLiquids.cleanWater;
            consumeLiquidAmount = 400f;
            liquidCapacity = 800f;

            squareSprite = false;
            hideDatabase = true;
        }};
        //endregion Transport

        //region Liquids
        hermitePump = new AttributeCrafter("hermite-pump"){{
            requirements(Category.production, with(NetroItems.dionite, 100, NetroItems.hermite, 20, NetroItems.plating, 10));
            researchCost = with(NetroItems.dionite, 200, NetroItems.hermite, 20, NetroItems.plating, 15);
            health = 200;
            size = 3;

            craftTime = 120f;
            attribute = Attribute.steam;

            itemCapacity = 0;
            minEfficiency = 9f - 0.0001f;
            baseEfficiency = 0f;
            craftEffect = Fx.turbinegenerate;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;
            hasLiquids = true;
            boostScale = 1f / 9f;
            consumePower(3/energy);
            outputLiquid = new LiquidStack(NetroLiquids.cleanWater, 30f/fluid);
            liquidCapacity = 60f;

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawBlurSpin("-rotator", 6f), new DrawRegion("-mid"), new DrawLiquidTile(Liquids.water, 38f / 4f), new DrawDefault());

            squareSprite = false;
            displayEfficiency = false;
            group = BlockGroup.liquids;
        }};
        hermitePipe = new Conduit("hermite-pipe"){{
            requirements(Category.liquid, with(NetroItems.dionite, 1, NetroItems.plating, 1));
            researchCost = with(NetroItems.dionite, 100, NetroItems.plating, 10);
            health = 90;

            botColor = Color.valueOf("271e40");
            underBullets = true;
        }};
        hermiteRouter = new LiquidRouter("hermite-router"){{
            requirements(Category.liquid, with(NetroItems.dionite, 3, NetroItems.plating, 3));
            researchCost = with(NetroItems.dionite, 100, NetroItems.plating, 10);
            health = 120;

            liquidCapacity = 40f;
            underBullets = true;
            solid = false;
        }};
        hermiteLiquidContainer = new LiquidRouter("hermite-liquid-container"){{
            requirements(Category.liquid, with(NetroItems.hermite, 110, NetroItems.plating, 25, NetroItems.tarant, 50));
            researchCost = with(NetroItems.hermite, 400, NetroItems.plating, 60, NetroItems.tarant, 220);
            health = 450;
            size = 2;

            liquidCapacity = 360f;
            underBullets = true;
        }};
        hermiteUndPipe = new DirectionLiquidBridge("hermite-und-pipe"){{
            requirements(Category.liquid, with(NetroItems.dionite, 40, NetroItems.hermite, 10, NetroItems.plating, 5));
            researchCost = with(NetroItems.dionite, 200, NetroItems.hermite, 100, NetroItems.plating, 30);
            health = 180;

            range = 4;
            liquidCapacity = 40f;
            underBullets = true;
            ((Conduit)hermitePipe).rotBridgeReplacement = this;

            squareSprite = false;
            crushFragile = true;
        }};
        //endregion Liquids

        //region Crafting
        platingPress = new GenericCrafter("plating-press"){{
            requirements(Category.crafting, with(NetroItems.dionite, 90, NetroItems.gatride, 40, NetroItems.hermite, 20));
            researchCost = with(NetroItems.dionite, 150, NetroItems.gatride, 100, NetroItems.hermite, 40);
            health = 220;
            size = 2;

            craftTime = 140f;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 20;
            ambientSound = Sounds.loopCircuit;
            ambientSoundVolume = 0.1f;
            squareSprite = false;

            consumeItems(with(NetroItems.gatride, 3, NetroItems.hermite, 2));
            outputItems = with(NetroItems.plating, 1);
            consumePower(4/energy);
            craftEffect = Fx.pulverizeMedium;
        }};
        circuitAssembler = new GenericCrafter("circuit-assembler"){{
            requirements(Category.crafting, with(NetroItems.dionite, 200, NetroItems.plating, 20, NetroItems.tarant, 50));
            researchCost = with(NetroItems.dionite, 400, NetroItems.plating, 100, NetroItems.tarant, 200);
            health = 480;
            size = 3;

            craftTime = 240f;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 15;
            ambientSound = Sounds.loopCircuit;
            ambientSoundVolume = 0.1f;
            squareSprite = false;

            consumeItems(with(NetroItems.plating, 1, NetroItems.hermite, 3, NetroItems.tarant, 4));
            outputItems = with(NetroItems.microchip, 2);
            consumePower(6/energy);

            drawer = new DrawMulti(
                new DrawDefault(),
                new DrawGlowRegion(){{
                    alpha = 0.7f;
                    color = Color.valueOf("44aa44");
                    glowIntensity = 0.3f;
                    glowScale = 6f;
                }}
            );
        }};
        gatrideCrusher = new GenericCrafter("gatride-crusher"){{
            requirements(Category.crafting, with(NetroItems.gatride, 200, NetroItems.plating, 80, NetroItems.tarant, 80));
            researchCost = with(NetroItems.gatride, 450, NetroItems.plating, 160, NetroItems.tarant, 250);
            health = 750;
            size = 3;

            craftTime = 60f;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            ambientSound = Sounds.loopGrind;
            ambientSoundVolume = 0.1f;
            squareSprite = false;
            craftEffect = Fx.pulverizeMedium;
            drawer = new DrawMulti(new DrawRegion("-bottom"),
                new DrawLiquidTile(NetroLiquids.fuel, 12f / 4f),
                new DrawPistons(){{
                    sinMag = 1.5f;
                    sinScl = 5f;
                }},
                new DrawRegion("-mid"), new DrawLiquidTile(NetroLiquids.cleanWater, 37f / 4f),
                new DrawDefault()
            );

            consumeItems(with(NetroItems.gatride, 2));
            consumeLiquid(NetroLiquids.cleanWater, 8/fluid);
            consumePower(8/energy);
            outputLiquid = new LiquidStack(NetroLiquids.fuel, 12/fluid);
        }};
        waterBoiler = new GenericCrafter("water-boiler"){{ // To turn water into steam. Will be used for some later crafts and to not let Phomaxite annihilate your entire water logistics.
            requirements(Category.crafting, with(NetroItems.dionite, 9999));
            researchCost = with(NetroItems.dionite, 9999);
            health = 420;
            size = 2;
            hideDatabase = true;

            craftTime = 60f;
            hasPower = true;
            hasItems = false;
            hasLiquids = true;
            ambientSound = Sounds.loopSteam;
            ambientSoundVolume = 0.1f;
            squareSprite = false;
            craftEffect = Fx.steam;

            consumeLiquid(NetroLiquids.cleanWater, 10/fluid);
            consumePower(4/energy);
            outputLiquid = new LiquidStack(NetroLiquids.steam, 10/fluid);
        }};
        waterCooler = new GenericCrafter("water-cooler"){{ // buble
            requirements(Category.crafting, with(NetroItems.dionite, 9999));
            researchCost = with(NetroItems.dionite, 9999);
            health = 420;
            size = 2;
            hideDatabase = true;

            craftTime = 60f;
            hasPower = true;
            hasItems = false;
            hasLiquids = true;
            ambientSound = Sounds.loopElectricHum;
            ambientSoundVolume = 0.1f;
            squareSprite = false;
            craftEffect = Fx.none;

            consumeLiquid(NetroLiquids.steam, 10/fluid);
            consumePower(2/energy);
            outputLiquid = new LiquidStack(NetroLiquids.cleanWater, 10/fluid);
        }};
        //endregion Crafting

        //region Energy
        dioniteWire = new PowerWire("dionite-wire"){{
            requirements(Category.power, with(NetroItems.dionite, 1));
            researchCost = with(NetroItems.dionite, 6);
            health = 60;

            drawTeamOverlay = false;
        }};
        dioniteNode = new BeamNode("dionite-node"){{
            requirements(Category.power, with(NetroItems.dionite, 50, NetroItems.hermite, 25, NetroItems.microchip, 3));
            researchCost = with(NetroItems.dionite, 400, NetroItems.hermite, 200, NetroItems.microchip, 20);
            health = 120;

            consumesPower = outputsPower = true;
            range = 3;
            laserColor1 = Color.white;
            laserColor2 = Color.valueOf("f3e979");
            consumePowerBuffered(0f);
            crushFragile = true;
            squareSprite = false;
        }};
        //endregion

        //region Turrets
        origin = new ItemTurret("origin"){{
            requirements(Category.turret, with(NetroItems.dionite, 50, NetroItems.gatride, 25));
            researchCost = with(NetroItems.dionite, 70, NetroItems.gatride, 30);
            health = 270;
            size = 2;

            range = 120;
            reload = 35f;
            recoil = 2f;
            shootCone = 3f;
            rotateSpeed = 2f;
            shootSound = Sounds.shoot;
            ammoPerShot = 1;
            drawer = new DrawTurret("netrobase-");

            ammo(
                NetroItems.dionite, new BasicBulletType(5f, 30){{
                    width = 8f;
                    height = 10f;
                    lifetime = 23f;
                    buildingDamageMultiplier = 0.5f;
                }},
                NetroItems.hermite, new BasicBulletType(5f, 25){{
                    width = 8f;
                    height = 10f;
                    lifetime = 23f;
                    buildingDamageMultiplier = 0.5f;
                    fragBullets = 3;
                    ammoMultiplier = 5f;
                    fragBullet = new BasicBulletType(5f, 8){{
                        width = 4f;
                        height = 5f;
                        lifetime = 5f;
                        buildingDamageMultiplier = 0.5f;
                    }};
                }}
            );

            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 7.5f/fluid));
            coolantMultiplier = 3f;
            outlineColor = Pal.darkOutline;
            squareSprite = false;
        }};
        tesla = new PowerTurret("tesla"){{
            requirements(Category.turret, with(NetroItems.dionite, 100, NetroItems.tarant, 60));
            researchCost = with(NetroItems.dionite, 400, NetroItems.tarant, 200);
            health = 340;
            size = 2;

            reload = 80f;
            shootCone = 40f;
            range = 125f;
            rotateSpeed = 20f;
            recoil = 0f;
            targetAir = false;
            shootEffect = Fx.lightningShoot;
            shootSound = Sounds.shootArc;
            drawer = new DrawTurret("tesla-");

            shootType = new LightningBulletType(){{
                damage = 12;
                lightningLength = 24;
                collidesAir = false;
                ammoMultiplier = 1f;
                consumePower(18/energy);
                shootX = shootY = 0f;
                lightningType = new BulletType(0.0001f, 0f){{
                    lifetime = Fx.lightning.lifetime;
                    hitEffect = Fx.hitLancer;
                    despawnEffect = Fx.none;
                    status = NetroStatuses.shock;
                    statusDuration = 6f;
                    hittable = false;
                    collidesAir = false;
                    lightColor = Color.white;
                    buildingDamageMultiplier = 0.5f;
                }};
            }};

            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 15f/fluid));
            coolantMultiplier = 2f;
            squareSprite = false;
        }};
        flamethrower = new LiquidTurret("flamethrower"){{ //We commiting war crimes with this one
            requirements(Category.turret, with(NetroItems.gatride, 250, NetroItems.hermite, 200, NetroItems.tarant, 150));
            researchCost = with(NetroItems.gatride, 1400, NetroItems.hermite, 700, NetroItems.tarant, 500);
            health = 600;
            size = 3;

            reload = 3f;
            range = 120;
            shootSound = Sounds.shootFlame;
            ammoPerShot = 1;
            velocityRnd = 0.15f;
            rotateSpeed = 2f;
            recoil = 0f;
            shootCone = 20f;
            inaccuracy = 20f;
            liquidCapacity = 40f;

            ammo(
                NetroLiquids.fuel, new FlameBulletType(4f, 14){{
                    hitSize = 5f;
                    radius = 3f;
                    lifetime = 60f;
                    armorMultiplier = 1.5f;
                    collidesAir = true;
                    collidesTiles = false;
                    shootEffect = Fx.shootPyraFlame;
                }}
            );
            drawer = new DrawTurret("netrobase-"){{
                heatColor = Color.valueOf("ff5555");
                parts.addAll(
                    new RegionPart("-cover"){{
                        progress = PartProgress.warmup;
                        mirror = true;
                        moveX = moveY = -5f / 4f;
                    }}
                );
            }};
            cooldownTime = 80f;
            minWarmup = 0.2f;
            shootWarmupSpeed = 0.2f;
            warmupMaintainTime = 20f;
            squareSprite = false;
            outlineColor = Pal.darkOutline;
            ammoUseEffect = Fx.none;
            targetBlocks = false;
            extinguish = false;
            shootEffect = Fx.shootSmallFlame;
            loopSound = Sounds.none;
        }};
        hook = new ItemTurret("hook"){{
            requirements(Category.turret, with(NetroItems.dionite, 250, NetroItems.hermite, 200, NetroItems.tarant, 120));
            researchCost = with(NetroItems.dionite, 1200, NetroItems.hermite, 700, NetroItems.tarant, 400);
            health = 520;
            size = 3;

            reload = 120f;
            targetBlocks = false;
            itemCapacity = 30;
            shootCone = 5f;
            shootY = 6f;
            rotateSpeed = 10f;
            range = 160f;
            shootEffect = Fx.none;
            recoil = 0f;
            shootSound = Sounds.shootBreach;

            ammo(
                NetroItems.hermite, new BasicBulletType(4f, 22, "netroniummod-hook-bullet"){{
                    width = 8f;
                    height = 32f;
                    lifetime = 40f;
                    collidesTiles = false;
                    knockback = -6f;
                    hitEffect = Fx.none;
                    ammoPerShot = 2;
                    trailLength = 160;
                    trailInterval = 0.2f;
                    trailWidth = 1f;
                    shrinkY = 0f;
                    trailColor = Pal.accent;
                    trailEffect = NetroFx.chainPart;
                    status = StatusEffects.slow;
                    statusDuration = 30f;
                    trailRotation = true;
                    ammoMultiplier = 1f;

                    homingPower = 0.5f;
                }}
            );
            drawer = new DrawTurret("netrobase-"){{
                parts.add(new RegionPart("-side"){{
                    progress = PartProgress.charge;
                    moveX = 0.6f;
                    moveRot = -15f;
                    mirror = true;
                    layerOffset = 0.001f;
                    moves.add(new PartMove(PartProgress.recoil, 0f, -0.5f, -10f));
                }}, new RegionPart("-barrel"){{
                    progress = PartProgress.recoil;
                    moveY = -2f;
                }});
            }};

            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 15f/fluid));
            coolantMultiplier = 2f;
            squareSprite = false;
        }};

        volcano = new PowerTurret("volcano"){{
            requirements(Category.turret, with());
            size = 4;
            health = 999999;
            armor = 999999f;

            targetable = destructible = false;
            range = 80f;
            recoil = 0f;
            reload = 60f; // It will be controlled by world processor
            shootX = shootY = 0f;
            buildVisibility = BuildVisibility.sandboxOnly;
            rotateSpeed = 20f;
            drawer = new DrawTurret("volcanomouth-");
            ammoPerShot = 0;
            consumesPower = false;

            shootType = new BasicBulletType(0f, 0){{
                lifetime = 1f;
                ammoMultiplier = 0f;
                Draw.color(Color.black);
                Draw.z(121);
                shootEffect = new MultiEffect(Fx.bigShockwave, new WrapEffect(Fx.titanSmoke, Pal.redLight));
                shootSound = Sounds.explosionTitan;
                reloadMultiplier = 1f;
                despawnEffect = hitEffect = Fx.none;
                width = 0f;
                height = 0f;
                fragBullets = 12;
                fragBullet = new BasicBulletType(3f, 400f){{
                    health = 200;
                    hittable = true;
                    width = 24f;
                    height = 24f;
                    lifetime = 150f;
                    splashDamage = 110f;
                    splashDamageRadius = 64f;
                    buildingDamageMultiplier = 6f;
                    pierce = true;
                    pierceCap = 4;
                    pierceBuilding = false;
                    pierceDamageFactor = 0.9f;
                    backColor = hitColor = trailColor = Color.valueOf("ea8878").lerp(Pal.redLight, 0.5f);
                    frontColor = Color.white;
                    trailLength = 32;
                    trailWidth = 3.35f;
                    trailSinScl = 2.5f;
                    trailSinMag = 0.5f;
                    trailEffect = Fx.none;
                    despawnShake = 7f;
                    Draw.color(Color.orange);
                    despawnEffect = hitEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
                    despawnSound = hitSound = Sounds.explosionTitan;
                    trailInterp = v -> Math.max(Mathf.slope(v), 0.8f);
                    shrinkY = 0.45f;
                    collidesGround = true;
                    collidesAir = true;
                }};
            }};
        }};
        //endregion Turrets

        //region Walls
        dioniteWall = new Wall("dionite-wall"){{
            requirements(Category.defense, with(NetroItems.dionite, 6));
            researchCost = with(NetroItems.dionite, 30);
            health = 200;
            armor = 2f;
            size = 1;
        }};
        largeDioniteWall = new Wall("large-dionite-wall"){{
            requirements(Category.defense, with(NetroItems.dionite, 24));
            researchCost = with(NetroItems.dionite, 120);
            health = 800;
            armor = 2f;
            size = 2;
        }};
        dioniteDoor = new AutoDoor("dionite-door"){{
            requirements(Category.defense, with(NetroItems.dionite, 60, NetroItems.gatride, 50, NetroItems.hermite, 10));
            researchCost = with(NetroItems.dionite, 200, NetroItems.gatride, 150, NetroItems.hermite, 30);
            health = 700;
            armor = 3f;
            size = 2;
            hasShadow = false;
        }};
        platedWall = new Wall("plated-wall"){{
            requirements(Category.defense, with(NetroItems.plating, 6, NetroItems.tarant, 3));
            researchCost = with(NetroItems.plating, 30, NetroItems.tarant, 15);
            health = 350;
            armor = 8f;
            size = 1;
        }};
        largePlatedWall = new Wall("large-plated-wall"){{
            requirements(Category.defense, with(NetroItems.plating, 24, NetroItems.tarant, 12));
            researchCost = with(NetroItems.plating, 120, NetroItems.tarant, 60);
            health = 1400;
            armor = 8f;
            size = 2;
        }};
        //endregion Walls

        //region Support
        tarantBuildTower = new BuildTurret("tarant-build-tower"){{
            requirements(Category.effect, with(NetroItems.gatride, 200, NetroItems.hermite, 150, NetroItems.microchip, 30));
            researchCost = with(NetroItems.gatride, 500, NetroItems.hermite, 300, NetroItems.microchip, 150);
            health = 500;
            size = 2;

            range = 120f;
            buildSpeed = 0.75f;
            outlineColor = Pal.darkOutline;

            consumePower(7f/energy);
            consumeLiquid(NetroLiquids.fuel, 2f / 60f);
            squareSprite = false;
        }};
        //endregion

        //region Units
        dioniteAssembler = new UnitFactory("dionite-assembler"){{
            requirements(Category.units, with(NetroItems.dionite, 100, NetroItems.hermite, 80, NetroItems.plating, 20));
            researchCost = with(NetroItems.dionite, 400, NetroItems.hermite, 120, NetroItems.plating, 20);
            health = 300;
            size = 3;

            consumePower(15/energy);
            regionSuffix = "-netro";
            plans = Seq.with(
                new UnitPlan(NetroUnits.hope, 20*seconds, with(NetroItems.dionite, 80, NetroItems.gatride, 50, NetroItems.plating, 8)),
                new UnitPlan(NetroUnits.spark, 15*seconds, with(NetroItems.dionite, 60, NetroItems.gatride, 30, NetroItems.plating, 5)),
                new UnitPlan(NetroUnits.kamikaze, 10*seconds, with(NetroItems.gatride, 30, NetroItems.plating, 3)),
                new UnitPlan(NetroUnits.plasma, 25*seconds, with(NetroItems.gatride, 50, NetroItems.plating, 8, NetroItems.tarant, 20))
            );
        }};
        tarantReassembler = new Reconstructor("tarant-upgrader"){{
            requirements(Category.units, with(NetroItems.dionite, 520, NetroItems.plating, 120, NetroItems.microchip, 60));
            researchCost = with(NetroItems.dionite, 1100, NetroItems.plating, 320, NetroItems.microchip, 120);
            health = 1200;
            size = 5;

            consumeItems(with(NetroItems.plating, 60, NetroItems.tarant, 120, NetroItems.microchip, 20));
            consumeLiquid(NetroLiquids.cleanWater, 45f/fluid);
            consumePower(30/energy);
            regionSuffix = "-netro";
            upgrades.addAll(
                    new UnitType[]{NetroUnits.hope, NetroUnits.shell},
                    new UnitType[]{NetroUnits.spark, NetroUnits.flint},
                    new UnitType[]{NetroUnits.kamikaze, NetroUnits.falcon},
                    new UnitType[]{NetroUnits.plasma, NetroUnits.arc}
            );
            constructTime = 35*seconds;
        }};

        //endregion Units

        //region Payload
        hermitePayloadConveyor = new PayloadConveyor("hermite-payload-conveyor"){{
            requirements(Category.units, with(NetroItems.hermite, 5));
            researchCost = with(NetroItems.hermite, 100);
            health = 180;
            size = 3;

            moveTime = 40f;
            canOverdrive = false;
        }};
        hermitePayloadRouter = new PayloadRouter("hermite-payload-router"){{
            requirements(Category.units, with(NetroItems.hermite, 10));
            researchCost = with(NetroItems.hermite, 150);
            health = 240;
            size = 3;

            moveTime = 40f;
            canOverdrive = false;
        }};
        //endregion Payload

        //region Utility
        dioniteRadar = new Radar("dionite-radar"){{ //To make fog of war playthroughs playable
            requirements(Category.effect, BuildVisibility.fogOnly, with(NetroItems.dionite, 40, NetroItems.gatride, 20));
            researchCost = with(NetroItems.dionite, 80, NetroItems.gatride, 40);
            health = 80;

            outlineColor = Pal.darkOutline;
            fogRadius = 25;

            consumePower(1/energy);
        }};
        tarantRadar = new Radar("tarant-radar"){{
            requirements(Category.effect, BuildVisibility.fogOnly, with(NetroItems.dionite, 60, NetroItems.tarant, 20, NetroItems.microchip, 2));
            researchCost = with(NetroItems.dionite, 400, NetroItems.tarant, 200, NetroItems.microchip, 10);
            health = 200;

            outlineColor = Pal.darkOutline;
            fogRadius = 40;

            consumePower(2/energy);
        }};
        //endregion Utility

        //region Logic
        netroProcessor = new LogicBlock("netro-processor"){{
            requirements(Category.logic, with(NetroItems.hermite, 100, NetroItems.microchip, 10));
            researchCost = with(NetroItems.hermite, 400, NetroItems.microchip, 50);
            health = 400;

            instructionsPerTick = 5;
            range = 64;
        }};
        netroMessage = new MessageBlock("netro-message"){{
            requirements(Category.logic, with(NetroItems.hermite, 15, NetroItems.microchip, 3));
            researchCost = with(NetroItems.hermite, 100, NetroItems.microchip, 10);
            health = 150;
        }};
        netroSwitch = new SwitchBlock("netro-switch"){{
            requirements(Category.logic, with(NetroItems.hermite, 15, NetroItems.microchip, 3));
            researchCost = with(NetroItems.hermite, 100, NetroItems.microchip, 10);
            health = 150;
        }};
        netroCell = new MemoryBlock("netro-cell"){{
            requirements(Category.logic, with(NetroItems.hermite, 80, NetroItems.microchip, 10));
            researchCost = with(NetroItems.hermite, 200, NetroItems.microchip, 25);
            health = 300;

            memoryCapacity = 8;
        }};
        //endregion Logic

        //region Editor
        portableGenerator = new ConsumeGenerator("portable-generator"){{
            //It won't appear in campaign. Requirements are here just so it isn't demolished instantly.
            requirements(Category.effect, BuildVisibility.sandboxOnly, with(NetroItems.gatride, 200, NetroItems.plating, 100, NetroItems.tarant, 100));
            health = 600;
            armor = 5f;
            size = 2;

            powerProduction = 60/energy;
            squareSprite = false;
        }};
        supersteelWall = new Wall("supersteel-wall"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with());
            health = Integer.MAX_VALUE;
            armor = Float.POSITIVE_INFINITY;
            size = 1;

            absorbLasers = true;

            drawTeamOverlay = false;
            targetable = false;
        }};
        largeSupersteelWall = new Wall("large-supersteel-wall"){{
            requirements(Category.defense, BuildVisibility.sandboxOnly, with());
            health = Integer.MAX_VALUE;
            armor = Float.POSITIVE_INFINITY;
            size = 2;

            absorbLasers = true;

            drawTeamOverlay = false;
            targetable = false;
        }};
        cutsceneSkipper = new Wall("cutscene-skipper"){{
            health = ModSettings.getDisableCutscenes() ? 1 : 0;
            buildVisibility = BuildVisibility.hidden;
        }};
        //endregion Editor
    }
}