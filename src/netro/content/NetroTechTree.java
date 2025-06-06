package netro.content;

import arc.struct.*;
import static mindustry.content.TechTree.*;
import mindustry.game.*;
@SuppressWarnings("all")

public class NetroTechTree {
    public static void load(){

        NetroPlanets.netroniumPlanet.techTree = nodeRoot("@planet.netroniummod-netronium.name", NetroBlocks.coreHusk, true, () -> {
            node(NetroBlocks.dioniteDrill, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
            });

            node(NetroBlocks.dioniteNode, Seq.with(new Objectives.OnSector(NetroSectors.firstSteps)), () -> {
            });

            node(NetroBlocks.sandFurnace, Seq.with(new Objectives.OnSector(NetroSectors.theLake)), () -> {
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
                });
            });

            node(NetroBlocks.origin, Seq.with(new Objectives.Research(NetroBlocks.dioniteDrill), new Objectives.Research(NetroBlocks.dioniteConveyor), new Objectives.Research(NetroBlocks.dioniteNode)), () -> {
                node(NetroBlocks.tesla, () -> {
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
                node(NetroUnits.plasma);
            });

            node(NetroSectors.firstSteps, () -> {
                node(NetroSectors.theLake, Seq.with(new Objectives.SectorComplete(NetroSectors.firstSteps)), () -> {
                    nodeProduce(NetroItems.soon, Seq.with(new Objectives.SectorComplete(NetroSectors.theLake)), () -> {
                    });
                });
            });

            nodeProduce(NetroItems.dionite, () -> {
                nodeProduce(NetroItems.gatride, () -> {
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
        });
    }
}