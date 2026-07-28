package netro.content;

import arc.graphics.*;
import arc.math.Mathf;
import arc.math.geom.Rect;
import classes.*;
import mindustry.Vars;
import mindustry.content.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.part.HoverPart;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ai.types.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

import static mindustry.Vars.*;
import static mindustry.type.ItemStack.with;

public class NetroUnits {
    public static UnitType
    //region Stuff

    // Core
    unite, verge,

    //T1
    hope, spark, kamikaze, plasma,

    //T2
    shell, flint, falcon, arc,

    // Bosses
    bomber, swarm,

    // Other
    portal, train, slav;
    //endregion

    public static void load() {

        //region Core
        unite = new NetroUnitType("unite"){{
            health = 100f;
            armor = 1f;
            hitSize = 9f;
            speed = 3.8f;
            rotateSpeed = 5f;
            drag = accel = 0.08f;

            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500);
            isEnemy = false;
            this.constructor = UnitEntity::create;

            range = 60f;
            faceTarget = true;
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 4f;
            mineTier = 1;
            buildSpeed = 1f;
            itemCapacity = 50;
            vulnerableWithPayloads = true;

            fogRadius = 0f;
            targetable = false;
            hittable = false;
            payloadCapacity = tilePayload;

            alwaysUnlocked = true;

            setEnginesMirror(
                new UnitEngine(18 / 4f, -17 / 4f, 2f, 315f)
            );

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 0f;
                y = 5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                repairSpeed = 1f;
                fractionRepairSpeed = 0.05f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = false;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.heal;
                healColor = Pal.heal;

                bullet = new BulletType(){{
                    maxRange = 60f;
                }};
            }});
        }};

        verge = new NetroUnitType("verge"){{
            health = 220f;
            armor = 3f;
            hitSize = 14f;
            speed = 4.2f;
            rotateSpeed = 5f;
            drag = accel = 0.1f;

            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500);
            isEnemy = false;
            this.constructor = UnitEntity::create;

            range = 60f;
            faceTarget = true;
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 6f;
            mineTier = 2;
            buildSpeed = 1.2f;
            itemCapacity = 80;
            vulnerableWithPayloads = true;

            fogRadius = 0f;
            targetable = false;
            hittable = false;
            payloadCapacity = tilePayload;

            setEnginesMirror(
                    new UnitEngine(19 / 4f, -18 / 4f, 2f, 315f)
            );

            weapons.add(new RepairBeamWeapon(){{
                widthSinMag = 0.11f;
                reload = 20f;
                x = 5f;
                y = 5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                repairSpeed = 0.75f;
                fractionRepairSpeed = 0.05f;
                aimDst = 0f;
                shootCone = 45f;
                mirror = true;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.heal;
                healColor = Pal.heal;

                bullet = new BulletType(){{
                    maxRange = 60f;
                }};
            }});
        }};
        //endregion Core

        //region T1
        hope = new TankUnitType("hope"){{ // Tonk
            health = 600f;
            armor = 5f;
            hitSize = 13f;
            speed = 0.6f;
            rotateSpeed = 2.6f;
            this.constructor = TankUnit::create;

            flying = false;
            itemCapacity = 0;
            researchCostMultiplier = 0f;

            treadPullOffset = 0;
            treadRects = new Rect[] {
                    new Rect(13f, -28f, 11, 56)
            };

            weapons.add(new Weapon("netroniummod-hope-weapon"){{
                reload = cooldownTime = 90f;
                layerOffset = 0.0001f;
                mirror = false;
                top = true;
                x = y = 0;
                shootY = 10f;
                recoil = 2f;
                rotate = true;
                rotateSpeed = 4f;
                shootCone = 2f;
                shootSound = Sounds.shootLancer;
                heatColor = Color.valueOf("f9350f");
                bullet = new LaserBulletType(40f){{
                    sideAngle = 35f;
                    sideWidth = 1f;
                    sideLength = 10f;
                    length = 35f;
                    buildingDamageMultiplier = 1.2f;
                    pierce = false;
                    colors = new Color[]{Pal.neoplasm1.cpy().a(0.4f), Pal.neoplasm1, Color.white};
                }};
            }});
        }};

        spark = new NetroUnitType("spark"){{ // Flare 2.0
            health = 130f;
            armor = 0f;
            hitSize = 8f;
            speed = 2.5f;
            drag = accel = 0.07f;
            this.constructor = UnitEntity::create;

            flying = true;
            itemCapacity = 0;
            researchCostMultiplier = 0f;
            crashDamageMultiplier = 0.2f; // You have kamikaze for that

            weapons.add(new Weapon("netroniummod-spark-weapon") {{
                reload = 20f;
                mirror = true;
                top = false;
                x = 2.75f;
                y = 3.5f;
                alternate = true;
                shootSound = Sounds.shoot;
                ejectEffect = Fx.casing1;
                recoil = 0.4f;
                bullet = new BasicBulletType() {{
                    damage = 16f;
                    speed = 2f;
                    width = height = 8;
                    buildingDamageMultiplier = 0.75f;
                }};
            }});
        }};

        kamikaze = new NetroUnitType("kamikaze"){{ // スパムに最適
            health = 20f;
            armor = 0f;
            hitSize = 8f;
            speed = 2.2f;
            drag = accel = 0.06f;
            this.constructor = UnitEntity::create;

            flying = true;
            range = 8f;
            itemCapacity = 0; //no
            researchCostMultiplier = 0f;
            crashDamageMultiplier = 4f;
            engineOffset = 2;
            wreckHealthMultiplier = 999f; // It has to fall to be useful

            float fallDmgStat = Mathf.round(Mathf.pow(this.hitSize, 0.75f) * this.crashDamageMultiplier * 2.5f, 0.5f);

            weapons.add(new Weapon() {{
                shootOnDeath = true;
                reload = 24f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType() {{
                    collidesTiles = false;
                    collides = false;
                    hitSound = Sounds.explosion;
                    damage = fallDmgStat;

                    rangeOverride = 8f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 0f;
                    instantDisappear = true;
                    splashDamage = 0f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = collidesGround = false;
                }};
            }});
        }};

        plasma = new NetroUnitType("plasma"){{ // Crab
            cachedRequirements = with(NetroItems.gatride, 800, NetroItems.plating, 120, NetroItems.tarant, 300);
            health = 450;
            armor = 3f;
            hitSize = 11f;
            speed = 0.70f;
            drag = 0.1f;
            rotateSpeed = 3f;
            aiController = DefenderAI::new;

            range = 20f;
            flying = false;
            playerControllable = true;
            this.constructor = LegsUnit::create;
            itemCapacity = 0;

            legCount = 6;
            legLength = 14f;
            legGroupSize = 3;
            lockLegBase = true;
            legContinuousMove = true;
            legExtension = -5f;
            legBaseOffset = 4f;
            legMaxLength = 1.1f;
            legMinLength = 0.2f;
            legLengthScl = 1f;
            legForwardScl = 0.9f;
            legMoveSpace = 1f;
            hovering = true;
            rippleScale = 0.1f;
            stepShake = 0f;
            allowLegStep = true;

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;

            abilities.add(new ForceFieldAbility(32f, 0.3f, 650f, 60f * 12, 6, 0f){});
        }};
        //endregion T1

        //region T2
        shell = new TankUnitType("shell"){{
            health = 1000f;
            armor = 7f;
            hitSize = 18f;
            speed = 0.43f;
            rotateSpeed = 2f;
            this.constructor = TankUnit::create;

            flying = false;
            itemCapacity = 0;
            researchCostMultiplier = 0f;
            treadPullOffset = 0;
            crushFragile = true;

            treadRects = new Rect[] {
            new Rect(15f, -40f, 14, 80)
            };

            weapons.add(new Weapon("netroniummod-shell-weapon"){{
                reload = 90f;
                layerOffset = 0.0001f;
                mirror = false;
                top = true;
                x = y = 0;
                shootY = 5f;
                recoil = 3f;
                rotate = true;
                rotateSpeed = 3f;
                shake = 1f;
                shootCone = 2f;
                shootSound = Sounds.shootArtillery;
                bullet = new BasicBulletType(){{
                    damage = 60f;
                    splashDamage = 30f;
                    splashDamageRadius = 24f;
                    shootEffect = Fx.shootBig;
                    despawnEffect = hitEffect = Fx.blastExplosion;
                    hitSound = despawnSound = Sounds.explosionCrawler;
                    lifetime = 20f;
                    hitShake = 2f;
                    despawnShake = 1f;
                    speed = 4f;
                    width = height = 12;
                    buildingDamageMultiplier = 1.3f;
                }};
            }});
        }};

        flint = new NetroUnitType("flint"){{ // Flying shotgun at your service
            cachedRequirements = with(NetroItems.plating, 200, NetroItems.tarant, 400, NetroItems.microchip, 80);
            health = 400f;
            armor = 3f;
            hitSize = 12f;
            speed = 2.2f;
            drag = accel = 0.07f;
            this.constructor = UnitEntity::create;

            flying = true;
            itemCapacity = 0;
            crashDamageMultiplier = 0.2f; // You still have kamikaze for that

            weapons.add(new Weapon() {{
                reload = 80f;
                mirror = false;
                top = false;
                x = 0f;
                y = 3f;
                alternate = false;
                shoot = new ShootSpread(4, 10f);
                shootSound = Sounds.shoot;
                ejectEffect = Fx.casing1;
                recoil = 0f;
                bullet = new BasicBulletType() {{
                    damage = 35f;
                    lifetime = 20f;
                    speed = 3f;
                    width = height = 8;
                    recoil = 0.15f;
                }};
            }});
        }};
        falcon = new NetroUnitType("falcon"){{ // Mortis.
            cachedRequirements = with(NetroItems.plating, 200, NetroItems.tarant, 400, NetroItems.microchip, 80);
            health = 350f;
            armor = 2f;
            hitSize = 12f;
            speed = 1.9f;
            drag = accel = 0.07f;
            this.constructor = UnitEntity::create;

            flying = true;
            range = 40f;
            itemCapacity = 0; //still no
            engineOffset = 6;

            weapons.add(new Weapon() {{
                reload = 180f;
                shootCone = 1f;
                ejectEffect = Fx.none;
                shootSound = Sounds.none;
                x = shootY = 0f;
                mirror = false;
                bullet = new BasicBulletType(){{
                    hitSound = Sounds.shieldHit;
                    damage = 50;
                    width = height = 0f;
                    rangeOverride = 40f;
                    recoil = -9f;
                    hitEffect = Fx.pulverize;
                    speed = 6f;
                    lifetime = 16f;
                    pierce = true;
                    pierceCap = 3;
                    pierceBuilding = true;
                    splashDamageRadius = 0f;
                    splashDamage = 0f;
                    buildingDamageMultiplier = 0.7f;
                    hittable = false;
                    collidesAir = false;
                }};
            }});
        }};
        arc = new NetroUnitType("arc"){{ // Spooder
            cachedRequirements = with(NetroItems.plating, 200, NetroItems.tarant, 400, NetroItems.microchip, 80);
            health = 900;
            armor = 8f;
            hitSize = 18f;
            speed = 0.58f;
            rotateSpeed = 2.5f;
            drag = 0.1f;
            this.constructor = LegsUnit::create;
            aiController = DefenderAI::new;

            flying = false;
            playerControllable = true;
            itemCapacity = 0;
            range = 20f;
            stepShake = 0.3f;
            allowLegStep = true;

            legContinuousMove = true;
            legCount = 4;
            legLength = 18f;
            legGroupSize = 2;
            legExtension = -8f;
            legBaseOffset = 4f;
            legMaxLength = 1.05f;
            legMinLength = 0.2f;
            legLengthScl = 0.9f;
            legForwardScl = 0.9f;
            legPairOffset = 2;
            legStraightness = 0f;

            legMoveSpace = 1f;
            hovering = true;
            rippleScale = 0.5f;

            shadowElevation = 0.3f;
            groundLayer = Layer.legUnit;

            abilities.add(new ForceFieldAbility(50f, 0.5f, 900f, 60f * 20, 8, 0f){});
        }};
        //endregion T2

        //region Bosses
        bomber = new NetroBossUnit("bomber"){{ // Kamikaze, but OP
            health = 7000;
            armor = 0f;
            hitSize = 30f;
            speed = 0.31f;
            drag = 0.04f;
            accel = 0.08f;
            aiController = FlyingAI::new;

            rotateSpeed = 1f;
            deathSound = Sounds.explosionCore;
            deathSoundVolume = 2f;
            crashDamageMultiplier = 3120.44f; // Boss special ability
            flying = true;
            targetAir = false;
            targetFlags = new BlockFlag[]{BlockFlag.core, null};
            this.constructor = UnitEntity::create;
            engineOffset = 12;
            engineSize = 4;

            float fallDmgStat = Mathf.round(Mathf.pow(this.hitSize, 0.75f) * this.crashDamageMultiplier * 2.5f, 0.5f);

            setEnginesMirror(
                    new UnitEngine(28 / 4f, -52 / 4f, 3f, 270f)
            );

            weapons.add(new Weapon() {{
                shootOnDeath = true;
                reload = 24f;
                shootCone = 180f;
                ejectEffect = Fx.none;
                shootSound = Sounds.explosion;
                x = shootY = 0f;
                mirror = false;
                bullet = new BulletType() {{
                    collidesTiles = false;
                    collides = false;
                    hitSound = Sounds.explosion;
                    damage = fallDmgStat;

                    rangeOverride = 8f;
                    hitEffect = Fx.pulverize;
                    speed = 0f;
                    splashDamageRadius = 0f;
                    instantDisappear = true;
                    splashDamage = 0f;
                    killShooter = true;
                    hittable = false;
                    collidesAir = collidesGround = false;
                }};
            }});
        }};
        swarm = new PhomaxiteUnitType("swarm"){{ // BACTERIA
            health = 700;
            armor = 2f;
            hitSize = 10f;
            speed = 1.2f;
            drag = accel = 0.03f;
            aiController = FlyingAI::new;

            rotateSpeed = 5f;
            lowAltitude = true;
            useUnitCap = true; // Infinite units would be unfair + would lag
            crashDamageMultiplier = 0;
            flying = true;
            this.constructor = UnitEntity::create;
            hideDatabase = true;

            weapons.add(new Weapon() {{
                reload = 60f;
                shootCone = 15f;
                ejectEffect = Fx.none;
                shootSound = Sounds.shootAtrax;
                x = 0f;
                shootY = 7f;
                mirror = false;
                bullet = new LiquidBulletType(NetroLiquids.phomaxite){{
                    damage = 50;
                    buildingDamageMultiplier = 0.5f;
                    speed = 2.5f;
                    drag = 0.009f;
                    shootEffect = Fx.vaporSmall;
                    lifetime = 30f;
                    status = NetroStatuses.corrosion;
                    statusDuration = 300f;
                    despawnEffect = Fx.vaporSmall;
                    knockback = 0;
                }};
            }});
        }};
        // Boss special ability (Has to be outside otherwise it crashes)
        swarm.abilities.add(new PhomaxiteUnitSpawnAbility(NetroUnits.swarm, 60f*10f, 0f, 0f));
        //endregion

        //region Other
        portal = new NetroUnitType("portal"){{ // Ground units should not appear from thin air
            health = 500000f;
            armor = 25000f;
            hitSize = 61f;
            speed = 0.7f;
            drag = accel = 0.08f;
            rotateSpeed = 0;
            this.constructor = UnitEntity::create;

            flying = true;
            itemCapacity = 0;
            researchCostMultiplier = 0f;
            crashDamageMultiplier = 0f;
            flyingLayer = 117f; // Renders above all other units because...
            shadowElevationScl = 2.2f; // ...it's very high.
            physics = false;

            isEnemy = false;
            canAttack = false;
            drawItems = false;
            drawCell = true;
            bounded = false;
            omniMovement = true;
            drawMinimap = false;
            faceTarget = false;
            healFlash = false;
            hittable = targetable = false;
            useUnitCap = false;
            hideDatabase = true;
            engineSize = 0;

            setEnginesMirror(
                    new UnitEngine(0 / 4f, 155 / 4f, 4f, 90f),
                    new UnitEngine(109 / 4f, 109 / 4f, 3f, 45f),
                    new UnitEngine(155 / 4f, 0 / 4f, 4f, 0f),
                    new UnitEngine(109 / 4f, -109 / 4f, 3f, -45f),
                    new UnitEngine(0 / 4f, -155 / 4f, 4f, -90f)
            );

            parts.add(new HoverPart(){{
                x = 0;
                y = 0;
                mirror = false;
                radius = 30f;
                circles = 3;
                sides = 8;
                phase = 90f;
                stroke = 2f;
                layerOffset = -0.001f;
                color = Color.valueOf("f25555");
            }});
        }};
        train = new NeoplasmUnitType("train"){{ // This is what happens when you let Asgore drive a train
            health = 66666;
            armor = 66666f;
            hitSize = 40f;
            speed = 5f;

            targetable = killable = false;
            crushDamage = 66666f;
            stepShake = 6f;
            loopSound = Vars.tree.loadSound("asgore");
            loopSoundVolume = 0.8f;
            targetAir = false;
            omniMovement = true;
            canDrown = false;
            segments = 1;
            drawBody = true;
            hideDatabase = true;

            segmentScl = 0f;
            segmentPhase = 0f;
            weapons.add(new Weapon(""){{
                reload = 1f;
                layerOffset = 0.0001f;
                mirror = false;
                x = 0;
                y = 20;
                shootY = 20f;
                range =
                recoil = 0f;
                rotate = true;
                rotateSpeed = 400f;
                shootCone = 2f;
                shootSound = Sounds.none;
                bullet = new LaserBulletType(66666f){{
                    length = 40f;
                    pierce = true;
                    hitEffect = new MultiEffect(Fx.titanExplosion, Fx.titanSmoke);
                    colors = new Color[]{Pal.neoplasm1.cpy().a(0.4f), Pal.neoplasm1, Color.white};
                }};
            }});

            this.constructor = CrawlUnit::create;
            drawCell = false;

            abilities.add(new MoveEffectAbility(){{
                effect = Fx.missileTrailSmoke;
                rotation = 180f;
                y = -64f;
                color = Color.grays(0.6f).lerp(Pal.redLight, 0.5f).a(0.4f);
                interval = 7f;
            }});
        }};
        slav = new NetroUnitType("slav"){{ // SLAVYANSKIY ZAZHIM YAITCAMI
            health = 8008135f;
            armor = 1984f;
            hitSize = 64f;
            speed = 2.1f;
            drag = accel = 0.69f;
            flying = true;
            this.constructor = UnitEntity::create;
            itemCapacity = 0;
            researchCostMultiplier = 0f;
            crashDamageMultiplier = 420f;
            hideDatabase = true;

            weapons.add(new Weapon(){{
                reload = 10f;
                mirror = true;
                top = false;
                x = 0f;
                y = 0f;
                alternate = true;
                shootSound = Vars.tree.loadSound("slav");
                ejectEffect = Fx.none;
                recoil = 0f;
                bullet = new BasicBulletType(52f, 1000000f, "netroniummod-slav-egg"){{
                    width = height = 32;
                    shrinkY = 0f;
                }};
            }});
        }};
        //endregion Other
    }
}