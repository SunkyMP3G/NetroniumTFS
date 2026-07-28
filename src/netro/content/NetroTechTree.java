package netro.content;

import arc.struct.*;
import static mindustry.content.TechTree.*;
import mindustry.game.*;
@SuppressWarnings("all")

public class NetroTechTree {
    public static void load(){

        NetroPlanets.netroniumPlanet.techTree = nodeRoot("@planet.netroniummod-netronium.name", NetroBlocks.coreHusk, () -> {
            //Transport and payload
            node(NetroBlocks.dioniteConveyor, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                node(NetroBlocks.dioniteRouter, () -> {
                    node(NetroBlocks.dioniteUndConveyor, () -> {
                        node(NetroBlocks.netroSorter, () -> {
                            node(NetroBlocks.netroInvertedSorter, () -> {
                            });
                            node(NetroBlocks.netroOverflowGate, () -> {
                                node(NetroBlocks.netroUnderflowGate, () -> {
                                });
                            });
                        });
                        node(NetroBlocks.itemContainer, () -> {
                            node(NetroBlocks.netroUnloader, () -> {
                            });
                        });
                        node(NetroBlocks.hermitePayloadConveyor, () -> {
                            node(NetroBlocks.hermitePayloadRouter, () -> {
                            });
                        });
                    });
                });
            });
            //Energy and production
            node(NetroBlocks.dioniteWire, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                node(NetroBlocks.tarantBuildTower, Seq.with(new Objectives.OnSector(NetroSectors.ironFortress)), () -> {
                });
                node(NetroBlocks.dioniteDrill, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                    node(NetroBlocks.wallDrill, Seq.with(new Objectives.OnSector(NetroSectors.outpost)), () -> {
                    });
                    node(NetroBlocks.hermiteDrill, Seq.with(new Objectives.OnSector(NetroSectors.abandonedMines)), () -> {
                    });
                });
                node(NetroBlocks.dioniteNode, Seq.with(new Objectives.OnSector(NetroSectors.abandonedMines)), () -> {
                });
                node(NetroBlocks.platingPress, Seq.with(new Objectives.OnSector(NetroSectors.outpost)), () -> {
                    node(NetroBlocks.circuitAssembler, Seq.with(new Objectives.OnSector(NetroSectors.ironFortress)), () -> {
                    });
                    node(NetroBlocks.gatrideCrusher, Seq.with(new Objectives.OnSector(NetroSectors.ironFortress)), () -> {
                    });
                });
                node(NetroBlocks.hermitePump, Seq.with(new Objectives.OnSector(NetroSectors.outpost)), () -> {
                    node(NetroBlocks.hermitePipe, () -> {
                        node(NetroBlocks.hermiteRouter, () -> {
                            node(NetroBlocks.hermiteLiquidContainer, () -> {
                            });
                        });
                        node(NetroBlocks.hermiteUndPipe, () -> {
                        });
                    });
                });
                node(NetroBlocks.netroProcessor, Seq.with(new Objectives.OnSector(NetroSectors.abandonedMines)), () -> {
                    node(NetroBlocks.netroMessage, () -> {
                    });
                    node(NetroBlocks.netroSwitch, () -> {
                    });
                    node(NetroBlocks.netroCell, () -> {
                    });
                });
            });
            //Defence
            node(NetroBlocks.origin, Seq.with(new Objectives.Research(NetroBlocks.dioniteDrill)), () -> {
                node(NetroBlocks.tesla, Seq.with(new Objectives.OnSector(NetroSectors.outpost)), () -> {
                    node(NetroBlocks.flamethrower, Seq.with(new Objectives.OnSector(NetroSectors.ironFortress)), () -> {
                    });
                    node(NetroBlocks.hook, Seq.with(new Objectives.OnSector(NetroSectors.ironFortress)), () -> {
                    });
                });
                node(NetroBlocks.dioniteWall, () -> {
                    node(NetroBlocks.largeDioniteWall, () -> {
                        node(NetroBlocks.platedWall, () -> {
                            node(NetroBlocks.largePlatedWall, () -> {
                            });
                        });
                        node(NetroBlocks.dioniteDoor, () -> {
                        });
                    });
                });
                node(NetroBlocks.dioniteRadar, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
                    node(NetroBlocks.tarantRadar, Seq.with(new Objectives.OnSector(NetroSectors.abandonedMines)), () -> {
                    });
                });
            });
            //Cores
            node(NetroBlocks.coreDome, Seq.with(new Objectives.SectorComplete(NetroSectors.abandonedMines)), () -> {
            });
            //Units
            node(NetroBlocks.dioniteAssembler, Seq.with(new Objectives.OnSector(NetroSectors.outpost)), () -> {
                node(NetroUnits.hope, () -> {
                    node(NetroUnits.shell, () -> {
                    });
                });
                node(NetroUnits.spark, () -> {
                    node(NetroUnits.flint, () -> {
                    });
                });
                node(NetroUnits.kamikaze, () -> {
                    node(NetroUnits.falcon, () -> {
                    });
                });
                node(NetroUnits.plasma, () -> {
                    node(NetroUnits.arc, () -> {
                    });
                });
                node(NetroBlocks.tarantReassembler, Seq.with(new Objectives.OnSector(NetroSectors.ironFortress)), () -> {
                });
            });
            //Sectors
            node(NetroSectors.firstSteps, () -> {
                node(NetroSectors.outpost, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps), new Objectives.Research(NetroBlocks.dioniteUndConveyor)), () -> {
                    node(NetroSectors.abandonedMines, Seq.with(new Objectives.SectorComplete(NetroSectors.outpost)), () -> {
                        node(NetroSectors.ironFortress, Seq.with(new Objectives.SectorComplete(NetroSectors.abandonedMines)), () -> {
                            node(NetroSectors.newThreat, Seq.with(new Objectives.SectorComplete(NetroSectors.ironFortress)), () -> {
                                node(NetroGuideItems.soon, Seq.with(new Objectives.SectorComplete(NetroSectors.newThreat)), () -> {
                                });
                            });
                            node(NetroSectors.doubleDraw, Seq.with(new Objectives.SectorComplete(NetroSectors.ironFortress)), () -> {
                            });
                        });
                    });
                });
            });
            //Items and fluids
            nodeProduce(NetroItems.dionite, () -> {
                nodeProduce(NetroItems.gatride, () -> {
                    nodeProduce(NetroItems.plating, () -> {
                    });
                    nodeProduce(NetroItems.tarant, () -> {
                        nodeProduce(NetroItems.microchip, () -> {
                        });
                    });
                });
                nodeProduce(NetroItems.hermite, () -> {
                });
                nodeProduce(NetroLiquids.cleanWater, () -> {
                    nodeProduce(NetroLiquids.fuel, () -> {
                    });
                    node(NetroLiquids.phomaxite, Seq.with(new Objectives.SectorComplete(NetroSectors.newThreat)), () -> {
                    });
                });
            });
            //Guides and boss info
            node(NetroGuideItems.guideIntro, () -> {
                node(NetroGuideItems.energyGuide, Seq.with(new Objectives.Research(NetroItems.dionite)), () -> {
                });
                node(NetroGuideItems.bossGuide, Seq.with(new Objectives.OnSector(NetroSectors.abandonedMines)), () -> {
                    node(NetroUnits.bomber, Seq.with(new Objectives.SectorComplete(NetroSectors.abandonedMines)), () -> {
                    });
                });
            });
        });
    }
}