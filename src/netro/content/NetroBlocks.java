package netro.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import classes.*;
import static mindustry.Vars.*;
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
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.units.*;
import mindustry.world.consumers.*;
import mindustry.world.draw.*;
import mindustry.world.meta.*;

public class NetroBlocks {
    public static Block

    // Environment floors
    grassFloor, stoneFloor, triniteFloor, iceFloor,

    // Vents
    triniteVent,

    // Ores
    oreDionite, oreTrinite,

    // Props
    triniteCrystal,

    // Environment liquids
    lavaFloor,

    // Environment walls
    grassWall, stoneOreWall, triniteWall,

    // Cores
    coreHusk, coreDome,

    // Transport
    dioniteConveyor, dioniteRouter, dioniteUndConveyor,

    //Drills
    dioniteDrill, steelDrill,

    // Liquids
    alumPump, alumPipe, alumRouter,

    // Production
    alloyFurnace, steelFurnace, snowyHeater,

    // Energy
    dioniteNode, testReactor,

    // Turrets
    origin, tesla, volcano, //Volcano is a turret. Change my mind

    // Walls
    dioniteWall, largeDioniteWall, steelWall, largeSteelWall, dioniteDoor,

    // Unit crafters
    dioniteAssembler,

    // Logic
    netroProcessor, netroMessage, netroCell, netroSwitch,

    // Editor only
    supersteelWall, largeSupersteelWall, snowyModule;

    public static void load(){

        // They could be just one variable, but I prefer this
        float seconds = 60f;
        float energy = 60f;
        float fluid = 60f;

        // Environment floors
        grassFloor = new Floor("grass-floor"){{
            variants = 3;
            wall = NetroBlocks.grassWall;
        }};

        stoneFloor = new Floor("stone-floor"){{
            variants = 3;
            wall = NetroBlocks.stoneOreWall;
        }};

        triniteFloor = new Floor("trinite-floor"){{
            variants = 5;
            wall = NetroBlocks.triniteWall;
        }};

        iceFloor = new Floor("ice-floor"){{
            variants = 3;
            speedMultiplier = 0.9f;
            dragMultiplier = 0.03f;
        }};


        // Vents
        triniteVent = new SteamVent("trinite-vent"){{
            parent = blendGroup = triniteFloor;
            attributes.set(Attribute.steam, 1f);
            variants = 2;
        }};


        // Ores
        oreDionite = new OreBlock("ore-dionite", NetroItems.dionite){{
            variants = 2;
        }};

        oreTrinite = new OreBlock("ore-trinite", NetroItems.trinite){{
            variants = 2;
        }};


        // Props
        triniteCrystal = new TallBlock("trinite-crystals"){{
            variants = 3;
            clipSize = 128f;
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


        // Environment walls
        grassWall = new StaticWall("grass-wall"){{
            variants = 3;
        }};

        stoneOreWall = new StaticWall("stone-ore-wall"){{
            variants = 3;
        }};

        triniteWall = new StaticWall("trinite-wall"){{
            variants = 3;
        }};


        // Cores
        coreHusk = new NetroCoreBlock("core-husk"){{
            requirements(Category.effect, with(NetroItems.dionite, 700));

            isFirstTier = true;
            unitType = NetroUnits.unite;
            health = 1400;
            armor = 1f;
            itemCapacity = 800;
            size = 2;
            thrusterLength = 12/2f;
            alwaysUnlocked = true;
            requiresCoreZone = true;
            powerProduction = 200/energy;
            squareSprite = false;

            unitCapModifier = 10;
        }};

        coreDome = new NetroCoreBlock("core-dome"){{
            requirements(Category.effect, with(NetroItems.netroCopper, 9999));

            unitType = NetroUnits.verge;
            health = 3000;
            armor = 3f;
            itemCapacity = 2000;
            size = 3;
            thrusterLength = 12/2f;
            powerProduction = 450/energy;
            squareSprite = false;

            unitCapModifier = 16;
        }};


        // Transport
        dioniteConveyor = new Conveyor("dionite-conveyor"){{
            requirements(Category.distribution, with(NetroItems.dionite, 1));
            health = 10;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            underBullets = true;
        }};

        dioniteRouter = new Router("dionite-router"){{
            requirements(Category.distribution, with(NetroItems.dionite, 3));
            health = 20;
            underBullets = true;
        }};

        dioniteUndConveyor = new DuctBridge("dionite-und-conveyor"){{
            requirements(Category.distribution, with(NetroItems.dionite, 20));
            health = 30;
            range = 4;
            speed = 0.03f;
            underBullets = true;
        }};


        //Drills
        dioniteDrill = new Drill("dionite-drill"){{
            requirements(Category.production, with(NetroItems.dionite, 30));
            consumePower(1/energy);
            drillTime = 100f;
            tier = 2;
            health = 100;
            size = 2;
            squareSprite = false;
            consumeLiquid(NetroLiquids.cleanWater, 2f/fluid).boost();
        }};

        steelDrill = new Drill("steel-drill"){{
            requirements(Category.production, with(NetroItems.steelIngot, 30));
            consumePower(3/energy);
            drillTime = 140f;
            tier = 4;
            health = 200;
            size = 2;
            squareSprite = false;
            hasLiquids = true;
            consumeLiquid(NetroLiquids.cleanWater, 3f/fluid).boost();
        }};


        //Liquids
        alumPump = new AttributeCrafter("aluminium-pump"){{
            requirements(Category.production, with(NetroItems.dionite, 100, NetroItems.trinite, 50));
            attribute = Attribute.steam;
            group = BlockGroup.liquids;
            minEfficiency = 9f - 0.0001f;
            baseEfficiency = 0f;
            displayEfficiency = false;
            craftEffect = Fx.turbinegenerate;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawBlurSpin("-rotator", 6f), new DrawRegion("-mid"), new DrawLiquidTile(Liquids.water, 38f / 4f), new DrawDefault());
            craftTime = 120f;
            size = 3;
            ambientSound = Sounds.hum;
            ambientSoundVolume = 0.06f;
            hasLiquids = true;
            squareSprite = false;
            boostScale = 1f / 9f;
            itemCapacity = 0;
            outputLiquid = new LiquidStack(NetroLiquids.cleanWater, 30f/fluid);
            consumePower(3/energy);
            liquidCapacity = 60f;
        }};

        alumPipe = new Conduit("aluminium-pipe"){{
            requirements(Category.liquid, with(NetroItems.dionite, 1, NetroItems.trinite, 1));
            underBullets = true;
            health = 10;
        }};

        alumRouter = new LiquidRouter("aluminium-router"){{
            requirements(Category.liquid, with(NetroItems.dionite, 3, NetroItems.trinite, 3));
            health = 20;
            liquidCapacity = 18f;
            underBullets = true;
            solid = false;
        }};


        // Production
        alloyFurnace = new GenericCrafter("alloy-furnace"){{
            requirements(Category.crafting, with(NetroItems.dionite, 90));
            health = 200;
            craftEffect = Fx.none;
            outputItem = new ItemStack(NetroItems.netroCopper, 1);
            craftTime = 120f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 20;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawFlame(), new DrawDefault());
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.12f;
            squareSprite = false;

            consumeItems(with(NetroItems.dionite, 6, NetroItems.trinite, 2));
            consumePower(5/energy);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
        }};

        steelFurnace = new GenericCrafter("steel-furnace"){{
            requirements(Category.crafting, with(NetroItems.dionite, 180, NetroItems.steelIngot, 60, NetroItems.netroCopper, 50));
            health = 400;
            craftEffect = Fx.none;
            outputItem = new ItemStack(NetroItems.steelIngot, 1);
            craftTime = 300f;
            size = 3;
            hasPower = true;
            hasLiquids = false;
            itemCapacity = 40;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawFlame(), new DrawDefault());
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.12f;
            squareSprite = false;

            consumeItems(with(NetroItems.dionite, 3, NetroItems.steelIngot, 2, NetroItems.netroCopper, 2));
            consumePower(20/energy);
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawArcSmelt(), new DrawDefault());
        }};

        snowyHeater = new OverdriveProjector("snowy-heater"){{
            requirements(Category.effect, with(NetroItems.dionite, 90,  NetroItems.trinite, 60));
            health = 200;
            size = 2;
            speedBoost = 1f;
            range = 36f;
            useTime = 4*seconds;
            hasBoost = false;
            consumeItems(with(NetroItems.trinite, 1));
            consumePower(8f/energy);
        }};


        // Energy
        dioniteNode = new BeamNode("dionite-node"){{
            requirements(Category.power, with(NetroItems.dionite, 6));
            consumesPower = outputsPower = true;
            health = 40;
            range = 5;
            consumePowerBuffered(0f);
        }};

        testReactor = new VariableReactor("test-reactor"){{
            requirements(Category.power, with());
            buildVisibility = BuildVisibility.sandboxOnly;
            health = 12000;
            armor = 5f;
            powerProduction = 240f/energy;
            maxHeat = 400f;
            unstableSpeed = 1f / 60f / 120f; //Slow, to make more time for players to regret their life and logistic mistakes

            consumePower(25f);
            consumeLiquid(NetroLiquids.neutronium, 10f/fluid);

            flags = EnumSet.of(BlockFlag.reactor, BlockFlag.generator);
            schematicPriority = -5;

            liquidCapacity = 200f;
            explosionMinWarmup = 0.5f;
            explosionShake = 20f;
            explosionShakeDuration = 120f;

            explosionRadius = 50;
            explosionDamage = 9999999;

            ambientSound = Sounds.flux;
            ambientSoundVolume = 0.19f;

            explosionPuddles = 70;
            explosionPuddleRange = 10*tilesize;
            explosionPuddleLiquid = Liquids.slag;
            explosionPuddleAmount = 120f;
            logicConfigurable = false;

            size = 5;
        }};


        // Turrets
        origin = new ItemTurret("origin"){{
            requirements(Category.turret, with(NetroItems.dionite, 70, NetroItems.trinite, 30));
            ammo(
                    NetroItems.dionite, new BasicBulletType(5f, 17){{
                        width = 8f;
                        height = 10f;
                        lifetime = 23f;
                        buildingDamageMultiplier = 0.01f;
                    }});

            shootSound = Sounds.shoot;
            squareSprite = false;

            ammoPerShot = 1;
            drawer = new DrawTurret("netrobase-");
            outlineColor = Pal.darkOutline;
            size = 2;
            reload = 35f;
            recoil = 2f;
            range = 120;
            shootCone = 3f;
            health = 200;
            rotateSpeed = 2f;
            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 7.5f/fluid));
            coolantMultiplier = 3f;
        }};

        tesla = new PowerTurret("tesla"){{
            requirements(Category.turret, with(NetroItems.dionite, 150, NetroItems.trinite, 100));
            shootType = new LightningBulletType(){{
                damage = 10;
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
                    statusDuration = 6f; //0.1 sec
                    hittable = false;
                    collidesAir = false;
                    lightColor = Color.white;
                    buildingDamageMultiplier = 0.01f;
                }};
            }};
            reload = 60f; //1 sec
            shootCone = 40f;
            rotateSpeed = 20f;
            targetAir = false;
            drawer = new DrawTurret("tesla-");
            range = 125f;
            shootEffect = Fx.lightningShoot;
            recoil = 0f;
            size = 2;
            health = 110;
            shootSound = Sounds.spark;
            coolant = consume(new ConsumeLiquid(NetroLiquids.cleanWater, 15f/fluid));
            coolantMultiplier = 2f;
        }};

        volcano = new PowerTurret("volcano"){{
            requirements(Category.turret, with());
            size = 4;
            health = 9999;
            armor = 9999f;
            targetable = destructible = false;
            range = 2000f;
            recoil = 0f;
            reload = 240f; // It will be controlled by world processor
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
                shootSound = Sounds.titanExplosion;
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
                        despawnSound = hitSound = Sounds.shootBig;
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
            health = 100;
            size = 1;
        }};

        largeDioniteWall = new Wall("large-dionite-wall"){{
            requirements(Category.defense, with(NetroItems.dionite, 24));
            health = 400;
            size = 2;
        }};

        steelWall = new Wall("steel-wall"){{
            requirements(Category.defense, with(NetroItems.steelIngot, 3));
            health = 200;
            armor = 1f;
            size = 1;
        }};

        largeSteelWall = new Wall("large-steel-wall"){{
            requirements(Category.defense, with(NetroItems.steelIngot, 12));
            health = 800;
            armor = 1f;
            size = 2;
        }};

        dioniteDoor = new AutoDoor("dionite-door"){{
            requirements(Category.defense, with(NetroItems.dionite, 60, NetroItems.trinite, 50));
            health = 500;
            armor = 1f;
            size = 2;
        }};


        // Unit crafters
        dioniteAssembler = new UnitFactory("dionite-assembler"){{
            requirements(Category.units, with(NetroItems.dionite, 170, NetroItems.trinite, 150));
            health = 200;
            plans = Seq.with(
                    new UnitPlan(NetroUnits.hope, 60f * 40, with(NetroItems.dionite, 80, NetroItems.trinite, 50)),
                    new UnitPlan(NetroUnits.spark, 60f * 25, with(NetroItems.dionite, 50, NetroItems.trinite, 30)),
                    new UnitPlan(NetroUnits.kamikaze, 60f * 15, with(NetroItems.dionite, 30, NetroItems.trinite, 50)),
                    new UnitPlan(NetroUnits.plasma, 60f * 60, with(NetroItems.dionite, 120, NetroItems.trinite, 50))
            );
            size = 3;
            consumePower(24/energy);
        }};

        // Logic
        netroProcessor = new LogicBlock("netro-processor"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 90, NetroItems.dionite, 140, NetroItems.netroCopper, 60));
            health = 80;

            instructionsPerTick = 2;
            range = 8 * 8;
        }};

        netroMessage = new MessageBlock("netro-message"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 30, NetroItems.dionite, 50));
            health = 40;
        }};

        netroSwitch = new SwitchBlock("netro-switch"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 15, NetroItems.dionite, 30));
            health = 40;
        }};

        netroCell = new MemoryBlock("netro-cell"){{
            requirements(Category.logic, with(NetroItems.netroCopper, 25, NetroItems.dionite, 50));
            health = 100;

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

        snowyModule = new OverdriveProjector("snowy-module"){{
            requirements(Category.effect, BuildVisibility.sandboxOnly, with());
            health = Integer.MAX_VALUE;
            armor = Float.POSITIVE_INFINITY;
            size = 1;
            speedBoost = 0.8f;
            range = 6000f;
            targetable = destructible = rebuildable = false;
            hasBoost = false;
            consumeItems(with());
            consumePower(0f);
        }};
    }
}