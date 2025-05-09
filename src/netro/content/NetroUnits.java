package netro.content;

import arc.graphics.*;
import arc.math.geom.Rect;
import classes.*;
import mindustry.Vars;
import static mindustry.Vars.*;
import mindustry.content.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.entities.pattern.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ai.types.*;
import mindustry.type.unit.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.BlockFlag;

public class NetroUnits {
    public static UnitType

    // Core units
    unite, verge,

    //T1
    hope, spark, kamikaze, plasma,

    // Bosses
    hydra, hydraHead, bomber,

    // Other
    train;

    public static void load() {

        //Core units
        unite = new NetroUnitType("unite"){{ // If only the mod was in Soviet Union
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
            drag = 0.08f;
            speed = 3.8f;
            rotateSpeed = 5f;
            accel = 0.08f;
            itemCapacity = 50;
            health = 100f;
            armor = 1f;
            hitSize = 9f;
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
                fractionRepairSpeed = 0.01f;
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
            coreUnitDock = true;
            controller = u -> new BuilderAI(true, 500);
            isEnemy = false;
            this.constructor = UnitEntity::create;

            range = 80f;
            faceTarget = true;
            targetPriority = -2;
            lowAltitude = false;
            mineWalls = true;
            mineFloor = true;
            mineHardnessScaling = false;
            flying = true;
            mineSpeed = 6f;
            mineTier = 3;
            buildSpeed = 1.4f;
            drag = 0.09f;
            speed = 4.7f;
            rotateSpeed = 6f;
            accel = 0.09f;
            itemCapacity = 80;
            health = 220f;
            armor = 3f;
            hitSize = 9f;
            vulnerableWithPayloads = true;
            hideDatabase = true;

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
                x = 5f;
                y = 5f;
                rotate = false;
                shootY = 0f;
                beamWidth = 0.7f;
                repairSpeed = 0.75f;
                fractionRepairSpeed = 0.01f;
                aimDst = 0f;
                shootCone = 15f;
                mirror = true;

                targetUnits = false;
                targetBuildings = true;
                autoTarget = false;
                controllable = true;
                laserColor = Pal.heal;
                healColor = Pal.heal;

                bullet = new BulletType(){{
                    maxRange = 80f;
                }};
            }});
        }};

        //T1
        hope = new TankUnitType("hope"){{ // Tonk
            health = 300f;
            hitSize = 13f;
            armor = 2f;
            speed = 0.6f;
            rotateSpeed = 2.6f;
            flying = false;
            this.constructor = TankUnit::create;
            itemCapacity = 0;
            treadPullOffset = 0;
            treadFrames = 14;

            treadRects = new Rect[]{new Rect(8f - 32f, 4f - 32f, 11f, 56f)};

            researchCostMultiplier = 0f;

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
                shootSound = Sounds.laser;
                heatColor = Color.valueOf("f9350f");
                bullet = new LaserBulletType(27f){{
                    sideAngle = 12f;
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
            hitSize = 8f;
            health = 90f;
            armor = 0f;
            speed = 2.5f;
            drag = accel = 0.07f;
            flying = true;
            this.constructor = UnitEntity::create;
            itemCapacity = 0;
            researchCostMultiplier = 0f;
            crashDamageMultiplier = 0.1f; // Not a kamikaze

            weapons.add(new Weapon("netroniummod-spark-weapon") {{
                reload = 20f;
                mirror = true;
                top = false;
                x = 2.75f;
                y = 2.72f;
                alternate = true;
                shootSound = Sounds.shoot;
                ejectEffect = Fx.casing1;
                recoil = 0.4f;
                bullet = new BasicBulletType() {{
                    damage = 15f;
                    speed = 2f;
                    width = height = 8;
                }};
            }});
        }};

        kamikaze = new NetroUnitType("kamikaze"){{ // Straight from Japan
            hitSize = 8f;
            health = 25f;
            armor = 0f;
            speed = 2.2f;
            range = 40f;
            drag = accel = 0.06f;
            flying = true;
            this.constructor = UnitEntity::create;
            itemCapacity = 0;
            researchCostMultiplier = 0f;

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

                    rangeOverride = 30f;
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

        plasma = new NetroUnitType("plasma"){{ // I call him Wheatley Crab
            aiController = DefenderAI::new;
            hitSize = 9f;
            health = 220;
            armor = 3f;
            speed = 0.70f;
            flying = false;
            playerControllable = true;
            this.constructor = LegsUnit::create;
            itemCapacity = 0;
            researchCostMultiplier = 0f;

            drag = 0.1f;
            rotateSpeed = 3f;
            stepShake = 0f;
            allowLegStep = true;

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

            shadowElevation = 0.1f;
            groundLayer = Layer.legUnit - 1f;

            abilities.add(new ForceFieldAbility(30f, 0.5f, 300f, 60f * 10, 18, 0f){});
        }};

        // Bosses
        hydra = new NetroBossUnit("hydra"){{ // Absolutely not a market
            health = 7500;
            armor = 3f;
            speed = 0.6f;
            drag = 0.08f;
            rotateSpeed = 2.5f;
            engineSize = 4f;
            hitSize = 24f;
            flying = true;
            range = 80f;
            this.constructor = UnitEntity::create;

            weapons.add(new Weapon(){{
                shootSound = Sounds.shockBlast;
                x = 0f;
                y = -2f;
                shootY = 0f;
                reload = 140f;
                mirror = false;
                shake = 3f;

                bullet = new BasicBulletType(){{
                    shoot = new ShootHelix(){{
                        mag = 1f;
                        scl = 5f;
                    }};

                    shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
                        colorTo = Pal.sapBulletBack;
                        sizeTo = 26f;
                        lifetime = 14f;
                        strokeFrom = 4f;
                    }});
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Pal.sapBullet;
                    despawnSound = Sounds.spark;

                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    speed = 2f;
                    damage = 100f;
                    lifetime = 30f;
                    width = height = 10f;
                    backColor = Pal.sapBulletBack;
                    frontColor = Pal.sapBullet;
                    shrinkX = shrinkY = 0f;
                    trailColor = Pal.sapBulletBack;
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = hitEffect = new ExplosionEffect(){{
                        waveColor = Pal.sapBullet;
                        smokeColor = Color.gray;
                        sparkColor = Pal.sap;
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};
                }};
            }});

            // TODO Fix the crash
            // abilities.add(new SpawnDeathAbility(NetroUnits.hydraHead, 2, 8f));
        }};

        hydraHead = new NetroBossUnit("hydra-head"){{
            health = 3750;
            armor = 3f;
            speed = 1f;
            drag = 0.08f;
            rotateSpeed = 2.5f;
            engineSize = 2f;
            hitSize = 12f;
            flying = true;
            this.constructor = UnitEntity::create;

            weapons.add(new Weapon(){{
                shootSound = Sounds.shockBlast;
                x = 0f;
                y = -2f;
                shootY = 0f;
                reload = 140f;
                mirror = false;
                shake = 3f;

                bullet = new BasicBulletType(){{
                    shoot = new ShootHelix(){{
                        mag = 1f;
                        scl = 5f;
                    }};

                    shootEffect = new MultiEffect(Fx.shootTitan, new WaveEffect(){{
                        colorTo = Pal.sapBulletBack;
                        sizeTo = 26f;
                        lifetime = 14f;
                        strokeFrom = 4f;
                    }});
                    smokeEffect = Fx.shootSmokeTitan;
                    hitColor = Pal.sapBullet;
                    despawnSound = Sounds.spark;

                    sprite = "large-orb";
                    trailEffect = Fx.missileTrail;
                    trailInterval = 3f;
                    trailParam = 4f;
                    speed = 2f;
                    damage = 100f;
                    lifetime = 30f;
                    width = height = 10f;
                    backColor = Pal.sapBulletBack;
                    frontColor = Pal.sapBullet;
                    shrinkX = shrinkY = 0f;
                    trailColor = Pal.sapBulletBack;
                    trailLength = 12;
                    trailWidth = 2.2f;
                    despawnEffect = hitEffect = new ExplosionEffect(){{
                        waveColor = Pal.sapBullet;
                        smokeColor = Color.gray;
                        sparkColor = Pal.sap;
                        waveStroke = 4f;
                        waveRad = 40f;
                    }};
                }};

            }});
        }};

        bomber = new NetroBossUnit("bomber"){{ // Kamikaze, but OP
            health = 15000;
            armor = 4f;
            speed = 0.3f;
            drag = 0.04f;
            accel = 0.08f;
            aiController = HugAI::new;
            rotateSpeed = 1f;
            engineSize = 2f;
            hitSize = 54f;
            crashDamageMultiplier = 9999f; // Boss special ability
            abilities.add(new ForceFieldAbility(30f, 0.1f, 10000f, 600f * 10, 18, 0f){});
            flying = true;
            targetFlags = new BlockFlag[]{BlockFlag.core, null};
            this.constructor = UnitEntity::create;

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

                    rangeOverride = 30f;
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


        // Other
        train = new NeoplasmUnitType("train"){{ // THOMAS
            health = 66666;
            armor = 66666f;
            targetable = killable = false;
            hitSize = 40f;
            crushDamage = 66666f;
            speed = 5f;
            stepShake = 6f;
            loopSound = Vars.tree.loadSound("thomas");
            loopSoundVolume = 0.2f; // Too loud
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
    }
}