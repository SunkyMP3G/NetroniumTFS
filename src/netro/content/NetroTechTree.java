package netro.content;

import arc.struct.*;
import static mindustry.content.TechTree.*;
import mindustry.game.*;
@SuppressWarnings("all")

public class NetroTechTree {
    public static void load(){

        NetroPlanets.netroniumPlanet.techTree = nodeRoot("@planet.netroniummod-netronium.name", NetroBlocks.coreHusk, true, () -> {
            node(NetroBlocks.coreDome, Seq.with(new Objectives.SectorComplete(NetroSectors.shipyard)), () -> {
            });

            node(NetroBlocks.dioniteDrill, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                node(NetroBlocks.hermiteDrill, Seq.with(new Objectives.SectorComplete(NetroSectors.shipyard)), () -> {
                });
            });

            node(NetroBlocks.dioniteWire, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                node(NetroBlocks.dioniteNode, Seq.with(new Objectives.OnSector(NetroSectors.shipyard)), () -> {
                });
            });

            node(NetroBlocks.sandFurnace, Seq.with(new Objectives.OnSector(NetroSectors.theLake)), () -> {
                node(NetroBlocks.microchipPress, Seq.with(new Objectives.OnSector(NetroSectors.shipyard)), () -> {
                });
            });

            node(NetroBlocks.dioniteConveyor, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                node(NetroBlocks.dioniteRouter, () -> {
                    node(NetroBlocks.dioniteUndConveyor, () -> {
                    });
                });
            });

            node(NetroBlocks.hermitePump, Seq.with(new Objectives.OnSector(NetroSectors.theLake)), () -> {
                node(NetroBlocks.hermitePipe, () -> {
                    node(NetroBlocks.hermiteRouter, () -> {
                    });
                    node(NetroBlocks.hermiteUndPipe, () -> {
                    });
                });
            });

            node(NetroBlocks.netroProcessor, Seq.with(new Objectives.SectorComplete(NetroSectors.shipyard)), () -> {
                node(NetroBlocks.netroMessage, () -> {
                });
                node(NetroBlocks.netroSwitch, () -> {
                });
                node(NetroBlocks.netroCell, () -> {
                });
            });

            node(NetroBlocks.origin, Seq.with(new Objectives.Research(NetroBlocks.dioniteDrill), new Objectives.Research(NetroBlocks.dioniteConveyor), new Objectives.Research(NetroBlocks.dioniteNode)), () -> {
                node(NetroBlocks.tesla, Seq.with(new Objectives.OnSector(NetroSectors.theLake)), () -> {
                    // node(NetroBlocks.minigun, Seq.with(new Objectives.OnSector(NetroSectors.shipyard)), () -> {
                    // });
                });
                node(NetroBlocks.dioniteWall, () -> {
                    node(NetroBlocks.largeDioniteWall, () -> {
                    });
                    node(NetroBlocks.dioniteDoor, () -> {
                    });
                });
            });

            node(NetroBlocks.dioniteAssembler, Seq.with(new Objectives.OnSector(NetroSectors.theLake)), () -> {
                node(NetroUnits.spark);
                node(NetroUnits.hope);
                node(NetroUnits.kamikaze);
                node(NetroUnits.plasma, Seq.with(new Objectives.OnSector(NetroSectors.shipyard)), () -> {});
            });

            node(NetroSectors.firstSteps, () -> {
                node(NetroSectors.theLake, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps)), () -> {
                    node(NetroSectors.shipyard, Seq.with(new Objectives.SectorComplete(NetroSectors.theLake)), () -> {
                        node(NetroSectors.challengeI, Seq.with(new Objectives.SectorComplete(NetroSectors.shipyard)), () -> {
                        });
                        node(NetroItems.soon, Seq.with(new Objectives.SectorComplete(NetroSectors.theLake)), () -> {
                        });
                    });
                });
            });

            nodeProduce(NetroItems.dionite, () -> {
                nodeProduce(NetroItems.gatride, () -> {
                    nodeProduce(NetroItems.tarant, () -> {
                        nodeProduce(NetroItems.microchip, () -> {
                            nodeProduce(NetroItems.faultyMicrochip, () -> {
                            });
                        });
                    });
                });
                nodeProduce(NetroItems.netroSand, () -> {
                    nodeProduce(NetroItems.hermite, () -> {
                    });
                    nodeProduce(NetroItems.dust, () -> {
                    });
                });
                nodeProduce(NetroLiquids.cleanWater, () -> {
                });
            });

            node(NetroGuideItems.guideIntro, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                node(NetroGuideItems.energyGuide, Seq.with(new Objectives.Research(NetroItems.dionite)), () -> {
                });
                node(NetroGuideItems.bossGuide, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps)), () -> {
                    node(NetroGuideItems.bossRageGuide, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps)), () -> {
                    });
                });
            });
        });
    }
}