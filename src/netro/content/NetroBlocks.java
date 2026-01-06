package netro.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import classes.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import static mindustry.type.ItemStack.*;
import mindustry.world.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.liquid.*;
import mindustry.world.blocks.logic.*;
import mindustry.world.blocks.payloads.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

public class NetroBlocks {
    public static Block

    // Environment
    grassFloor, stoneFloor, gatrideFloor, sandFloor, retorFloor, iceFloor, metalLines,
    grassWall, stoneOreWall, gatrideWall, retorWall,

    // Props
    gatrideBoulder, gatrideCrystal, retorCrystal,

    // Vents
    gatrideVent, retorVent,

    // Ores
    oreDionite, oreGatride, oreTarant,

    // Environment liquids
    lavaFloor,

    // Cores
    coreHusk, coreDome,

    // Drills
    dioniteDrill, hermiteDrill,

    // Transport
    dioniteConveyor, dioniteRouter, dioniteUndConveyor,

    // Liquids
    hermitePump, hermitePipe, hermiteRouter, hermiteUndPipe,

    // Production
    sandFurnace, microchipPress,

    // Energy
    dioniteWire, dioniteNode,

    // Turrets
    origin, tesla, minigun, volcano, //Volcano is a turret. Change my mind

    // Walls
    dioniteWall, largeDioniteWall, dioniteDoor,

    // Unit crafters
    dioniteAssembler,

    // Payload
    hermitePayloadConveyor, hermitePayloadRouter,

    // Logic
    netroProcessor, netroMessage, netroCell, netroSwitch,

    // Editor only
    supersteelWall, largeSupersteelWall;

    public static void load(){

        // They could be just one variable, or even none, but I prefer this. Suffer
        float seconds = 60f;
        float energy = 60f;
        float fluid = 60f;

        // Environment
        grassFloor = new Floor("grass-floor"){{
            variants = 3;
            wall = NetroBlocks.grassWall;
        }};
        stoneFloor = new Floor("stone-floor"){{
            variants = 3;
            wall = NetroBlocks.stoneOreWall;
        }};
        gatrideFloor = new Floor("gatride-floor"){{
            variants = 5;
            wall = NetroBlocks.gatrideWall;
        }};
        sandFloor = new Floor("netrosand-floor"){{
            variants = 3;
            wall = Blocks.sandWall;
            itemDrop = NetroItems.netroSand;
            playerUnmineable = true;
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
        grassWall = new StaticWall("grass-wall"){{
            variants = 3;
        }};
        stoneOreWall = new StaticWall("stone-ore-wall"){{
            variants = 3;
        }};
        gatrideWall = new StaticWall("gatride-wall"){{
            variants = 3;
        }};
        retorWall = new StaticWall("retor-wall"){{
            variants = 3;
        }};


        // Props
        gatrideBoulder = new Prop("gatride-boulder"){{
            variants = 2;
            gatrideFloor.asFloor().decoration = this;
        }};
        gatrideCrystal = new TallBlock("gatride-crystals"){{
            variants = 3;
            clipSize = 128f;
        }};
        retorCrystal = new TallBlock("retor-crystal"){{
            variants = 0;
            clipSize = 128f;
        }};


        // Vents
        gatrideVent = new SteamVent("gatride-vent"){{
            parent = blendGroup = gatrideFloor;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
        }};
        retorVent = new SteamVent("retor-vent"){{
            parent = blendGroup = retorFloor;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
        }};


        // Ores
        oreDionite = new OreBlock("ore-dionite", NetroItems.dionite){{
            variants = 2;
        }};
        oreGatride = new OreBlock("ore-gatride", NetroItems.gatride){{
            variants = 2;
        }};
        oreTarant = new OreBlock("ore-tarant", NetroItems.tarant){{
            variants = 2;
        }};


        // Environment liquids
        lavaFloor = new Floor("lava-floor"){{
            speedMultiplier = 0.4f;
            variants = 0;
            liquidDrop = NetroLiquids.lava;
            isLiquid = true;
            status = NetroStatuses.lavaMelting;
            statusDuration = 10*seconds;
            drownTime = 80f;
            cacheLayer = CacheLayer.slag;
            albedo = 0f;
            lightColor = Color.valueOf("f8c266");
            lightRadius = 40f;
        }};


        // Cores
        coreHusk = new NetroCoreBlock("core-husk"){{
            requirements(Category.effect, with(NetroItems.dionite, 500, NetroItems.gatride, 200));
            isFirstTier = true;
            unitType = NetroUnits.unite;
            health = 1750;
            armor = 1f;
            itemCapacity = 800;
            size = 2;
            thrusterLength = 12/2f;
            alwaysUnlocked = true;
            requiresCoreZone = true;
            powerProduction = 4.16666667f;
            squareSprite = false;
            incinerateNonBuildable = true;

            unitCapModifier = 10;
        }};
        coreDome = new NetroCoreBlock("core-dome"){{
            requirements(Category.effect, with(NetroItems.dionite, 700, NetroItems.gatride, 400, NetroItems.hermite, 100, NetroItems.microchip, 30));
            researchCost = with(NetroItems.dionite, 1600, NetroItems.gatride, 800, NetroItems.hermite, 400, NetroItems.microchip, 100);
            unitType = NetroUnits.verge;
            health = 4000;
            armor = 3f;
            itemCapacity = 2000;
            size = 3;
            thrusterLength = 12/2f;
            powerProduction = 6.66666666f;
            squareSprite = false;
            incinerateNonBuildable = true;

            unitCapModifier = 16;
        }};


        //Drills
        dioniteDrill = new Drill("dionite-drill"){{
            requirements(Category.production, with(NetroItems.dionite, 10));
            researchCost = with(NetroItems.dionite, 20);
            consumePower(1/energy);
            drillTime = 240f;
            tier = 2;
            health = 110;
            size = 2;
            squareSprite = false;
            consumeLiquid(NetroLiquids.cleanWater, 2f/fluid).boost();
            liquidBoostIntensity = 1.4f;
            liquidCapacity = 10f;
        }};
        hermiteDrill = new Drill("hermite-drill"){{
            requirements(Category.production, with(NetroItems.dionite, 40, NetroItems.gatride, 15, NetroItems.hermite, 8));
            researchCost = with(NetroItems.dionite, 400, NetroItems.gatride, 300, NetroItems.hermite, 60);
            consumePower(2/energy);
            drillTime = 200f;
            tier = 4;
            health = 180;
            size = 2;
            squareSprite = false;
            consumeLiquid(NetroLiquids.cleanWater, 3f/fluid).boost();
            liquidBoostIntensity = 1.4f;
            liquidCapacity = 10f;
        }};


        // Transport
        dioniteConveyor = new Conveyor("dionite-conveyor"){{
            requirements(Category.distribution, with(NetroItems.dionite, 1));
            researchCost = with(NetroItems.dionite, 5);
            health = 45;
            speed = 0.04f;
            displayedSpeed = 6f;
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
            speed = 10f;
            underBullets = true;
            ((Conveyor) dioniteConveyor).bridgeReplacement = this;
        }};


        //Liquids
        hermitePump = new AttributeCrafter("hermite-pump"){{
            requirements(Category.production, with(NetroItems.dionite, 100, NetroItems.hermite, 20));
            researchCost = with(NetroItems.dionite, 200, NetroItems.hermite, 20);
            attribute = Attribute.steam;
            group = BlockGroup.liquids;
            minEfficiency = 9f - 0.0001f;
            baseEfficiency = 0f;
            displayEfficiency = false;
            craftEffect = Fx.turbinegenerate;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawBlurSpin("-rotator", 6f), new DrawRegion("-mid"), new DrawLiquidTile(Liquids.water, 38f / 4f), new DrawDefault());
            health = 200;
            craftTime = 120f;
            size = 3;
            ambientSound = Sounds.loopHum;
            ambientSoundVolume = 0.06f;
            hasLiquids = true;
            squareSprite = false;
            boostScale = 1f / 9f;
            itemCapacity = 0;
            outputLiquid = new LiquidStack(NetroLiquids.cleanWater, 30f/fluid);
            consumePower(3/energy);
            liquidCapacity = 60f;
        }};
        hermitePipe = new Conduit("hermite-pipe"){{
            requirements(Category.liquid, with(NetroItems.dionite, 1, NetroItems.hermite, 1));
            researchCost = with(NetroItems.dionite, 100, NetroItems.hermite, 10);
            botColor = Color.valueOf("271e40");
            underBullets = true;
            health = 90;
        }};
        hermiteRouter = new LiquidRouter("hermite-router"){{
            requirements(Category.liquid, with(NetroItems.dionite, 3, NetroItems.hermite, 3));
            researchCost = with(NetroItems.dionite, 100, NetroItems.hermite, 10);
            health = 120;
            liquidCapacity = 18f;
            underBullets = true;
            solid = false;
        }};
        hermiteUndPipe = new DirectionLiquidBridge("hermite-und-pipe"){{
            requirements(Category.liquid, with(NetroItems.dionite, 40, NetroItems.hermite, 10));
            researchCost = with(NetroItems.dionite, 200, NetroItems.hermite, 100);
            health = 180;
            range = 4;
            liquidCapacity = 45f;
            underBullets = true;
            squareSprite = false;

            ((Conduit)hermitePipe).rotBridgeReplacement = this;
        }};


        // Production
        sandFurnace = new Separator("sand-furnace"){{
            requirements(Category.crafting, with(NetroItems.dionite, 90, NetroItems.gatride, 40));
            researchCost = with(NetroItems.dionite, 110, NetroItems.gatride, 30);
            health = 220;
            results = with(
                NetroItems.hermite, 90,
                NetroItems.dust, 10
            );
            craftTime = 180f;
            size = 2;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 20;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawFlame(), new DrawDefault());
            ambientSound = Sounds.loopSmelter;
            ambientSoundVolume = 0.12f;
            squareSprite = false;

            consumeItems(with(NetroItems.netroSand, 3, NetroItems.gatride, 2));
            consumePower(4/energy);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
        }};
        microchipPress = new Separator("microchip-press"){{
            requirements(Category.crafting, with(NetroItems.dionite, 180, NetroItems.gatride, 100, NetroItems.hermite, 20, NetroItems.tarant, 40));
            researchCost = with(NetroItems.dionite, 300, NetroItems.gatride, 300, NetroItems.hermite, 80, NetroItems.tarant, 70);
            health = 220;
            size = 2;

            craftTime = 240f;
            hasPower = true;
            hasLiquids = true;
            itemCapacity = 30;
            ambientSound = Sounds.loopCircuit;
            ambientSoundVolume = 0.1f;
            squareSprite = false;

            consumeItems(with(NetroItems.gatride, 15, NetroItems.hermite, 5, NetroItems.tarant, 10));
            consumePower(8/energy);
            results = with(
                    NetroItems.microchip, 95,
                    NetroItems.faultyMicrochip, 5
            );
        }};


        // Energy
        dioniteWire = new PowerWire("dionite-wire"){{
            requirements(Category.power, with(NetroItems.dionite, 1));
            researchCost = with(NetroItems.dionite, 6);
            drawTeamOverlay = false;
            health = 60;
        }};
        dioniteNode = new BeamNode("dionite-node"){{
            requirements(Category.power, with(NetroItems.dionite, 50, NetroItems.gatride, 25, NetroItems.microchip, 3));
            researchCost = with(NetroItems.dionite, 400, NetroItems.gatride, 200, NetroItems.microchip, 20);
            consumesPower = outputsPower = true;
            health = 120;
            squareSprite = false;
            range = 3;
            laserColor1 = Color.white;
            laserColor2 = Color.valueOf("f3e979");
            consumePowerBuffered(0f);
        }};


        // Turrets
        origin = new ItemTurret("origin"){{
            requirements(Category.turret, with(NetroItems.dionite, 50, NetroItems.gatride, 25));
            researchCost = with(NetroItems.dionite, 70, NetroItems.gatride, 30);
            ammo(
                NetroItems.dionite, new BasicBulletType(5f, 25){{
                    width = 8f;
                    height = 10f;
                    lifetime = 23f;
                    buildingDamageMultiplier = 0.1f;
                }},
                NetroItems.hermite, new BasicBulletType(5f, 20){{
                    width = 8f;
                    height = 10f;
                    lifetime = 23f;
                    buildingDamageMultiplier = 0.1f;
                    fragBullets = 3;
                    ammoMultiplier = 5f;
                    fragBullet = new BasicBulletType(5f, 5){{
                        width = 4f;
                        height = 5f;
                        lifetime = 5f;
                        buildingDamageMultiplier = 0.1f;
                    }};
                }});

            shootSound = Sounds.shoot;
            shootSoundVolume = 1.5f;
            squareSprite = false;

            ammoPerShot = 1;
            drawer = new DrawTurret("netrobase-");
            outlineColor = Pal.darkOutline;
            size = 2;
            reload = 35f;
            recoil = 2f;
            range = 120;
            shootCone = 3f;
            health = 270;
            rotateSpeed = 2f;
            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 7.5f/fluid));
            coolantMultiplier = 3f;
        }};
        tesla = new PowerTurret("tesla"){{
            requirements(Category.turret, with(NetroItems.dionite, 100, NetroItems.gatride, 80, NetroItems.hermite, 20));
            researchCost = with(NetroItems.dionite, 400, NetroItems.gatride, 300, NetroItems.hermite, 40);
            shootType = new LightningBulletType(){{
                damage = 17;
                lightningLength = 20;
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
                    buildingDamageMultiplier = 0.1f;
                }};
            }};
            reload = 60f;
            shootCone = 40f;
            rotateSpeed = 20f;
            targetAir = false;
            drawer = new DrawTurret("tesla-");
            range = 125f;
            shootEffect = Fx.lightningShoot;
            recoil = 0f;
            size = 2;
            health = 340;
            shootSound = Sounds.shootArc;
            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 15f/fluid));
            coolantMultiplier = 2f;
        }};
        minigun = new ItemTurret("minigun"){{
            requirements(Category.turret, with(NetroItems.dionite, 100, NetroItems.gatride, 70, NetroItems.hermite, 30));
            researchCost = with(NetroItems.dionite, 400, NetroItems.gatride, 200, NetroItems.hermite, 80);
            health = 400;
            size = 2;

            reload = 300f;
            range = 96;
            shootSound = Sounds.shoot;
            ammoPerShot = 1;
            rotateSpeed = 1.2f;
            recoil = 2f;
            shootCone = 3f;

            ammo(
                NetroItems.hermite, new BasicBulletType(4f, 7){{
                    width = 6f;
                    height = 8f;
                    lifetime = 23f;
                    buildingDamageMultiplier = 0.9f;
                    ammoMultiplier = 3f;
                    shootCone = 30f;
                    inaccuracy = 17f;
                    fragBullets = 3;
                    shoot.shotDelay = 5f;
                    shoot.shots = 40;
                }});
            squareSprite = false;
            drawer = new DrawTurret("netrobase-");
            outlineColor = Pal.darkOutline;

            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 5f/fluid));
            coolantMultiplier = 3f;
        }};
        volcano = new PowerTurret("volcano"){{
            requirements(Category.turret, with());
            size = 4;
            health = 9999;
            armor = 9999f;

            targetable = destructible = false;
            range = 2000f;
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


        // Walls
        dioniteWall = new Wall("dionite-wall"){{
            requirements(Category.defense, with(NetroItems.dionite, 6));
            researchCost = with(NetroItems.dionite, 30);
            health = 200;
            size = 1;
        }};
        largeDioniteWall = new Wall("large-dionite-wall"){{
            requirements(Category.defense, with(NetroItems.dionite, 24));
            researchCost = with(NetroItems.dionite, 120);
            health = 800;
            size = 2;
        }};
        dioniteDoor = new AutoDoor("dionite-door"){{
            requirements(Category.defense, with(NetroItems.dionite, 60, NetroItems.gatride, 50, NetroItems.hermite, 10));
            researchCost = with(NetroItems.dionite, 200, NetroItems.gatride, 150, NetroItems.hermite, 30);
            health = 700;
            armor = 1f;
            size = 2;
        }};


        // Unit crafters
        dioniteAssembler = new UnitFactory("dionite-assembler"){{
            requirements(Category.units, with(NetroItems.dionite, 100, NetroItems.gatride, 70, NetroItems.hermite, 10));
            researchCost = with(NetroItems.dionite, 200, NetroItems.gatride, 120, NetroItems.hermite, 20);
            health = 300;
            size = 3;

            regionSuffix = "-netro";
            plans = Seq.with(
                    new UnitPlan(NetroUnits.hope, 40*seconds, with(NetroItems.dionite, 80, NetroItems.gatride, 50, NetroItems.hermite, 8)),
                    new UnitPlan(NetroUnits.spark, 25*seconds, with(NetroItems.dionite, 50, NetroItems.gatride, 30, NetroItems.hermite, 5)),
                    new UnitPlan(NetroUnits.kamikaze, 15*seconds, with(NetroItems.dionite, 20, NetroItems.gatride, 50, NetroItems.hermite, 3)),
                    new UnitPlan(NetroUnits.plasma, 50*seconds, with(NetroItems.dionite, 120, NetroItems.gatride, 50, NetroItems.hermite, 10))
            );
            consumePower(24/energy);
        }};


        // Payload
        hermitePayloadConveyor = new PayloadConveyor("hermite-payload-conveyor"){{
            requirements(Category.units, with(NetroItems.dionite, 20, NetroItems.gatride, 30, NetroItems.hermite, 5));
            researchCost = with(NetroItems.dionite, 300, NetroItems.gatride, 340, NetroItems.hermite, 100);
            health = 180;
            moveTime = 60f;
            canOverdrive = false;
        }};
        hermitePayloadRouter = new PayloadRouter("hermite-payload-router"){{
            requirements(Category.units, with(NetroItems.dionite, 40, NetroItems.gatride, 70, NetroItems.hermite, 10));
            researchCost = with(NetroItems.dionite, 400, NetroItems.gatride, 400, NetroItems.hermite, 150);
            health = 240;
            moveTime = 60f;
            canOverdrive = false;
        }};


        // Logic
        netroProcessor = new LogicBlock("netro-processor"){{
            requirements(Category.logic, with(NetroItems.gatride, 200, NetroItems.dionite, 140, NetroItems.hermite, 25, NetroItems.microchip, 10));
            researchCost = with(NetroItems.dionite, 600, NetroItems.gatride, 300, NetroItems.hermite, 100, NetroItems.microchip, 40);
            health = 400;

            instructionsPerTick = 5;
            range = 64;
        }};
        netroMessage = new MessageBlock("netro-message"){{
            requirements(Category.logic, with(NetroItems.gatride, 30, NetroItems.dionite, 50, NetroItems.hermite, 3, NetroItems.microchip, 3));
            researchCost = with(NetroItems.dionite, 300, NetroItems.gatride, 200, NetroItems.hermite, 50, NetroItems.microchip, 10);
            health = 150;

            maxTextLength = 500;
        }};
        netroSwitch = new SwitchBlock("netro-switch"){{
            requirements(Category.logic, with(NetroItems.gatride, 15, NetroItems.dionite, 30, NetroItems.hermite, 3, NetroItems.microchip, 3));
            researchCost = with(NetroItems.dionite, 300, NetroItems.gatride, 200, NetroItems.hermite, 50, NetroItems.microchip, 10);
            health = 150;
        }};
        netroCell = new MemoryBlock("netro-cell"){{
            requirements(Category.logic, with(NetroItems.gatride, 25, NetroItems.dionite, 50, NetroItems.hermite, 5, NetroItems.microchip, 10));
            researchCost = with(NetroItems.dionite, 300, NetroItems.gatride, 200, NetroItems.hermite, 50, NetroItems.microchip, 20);
            health = 300;

            memoryCapacity = 8;
        }};


        // Editor only
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
    }
}