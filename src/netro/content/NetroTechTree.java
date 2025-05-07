package netro.content;

import arc.struct.*;
import static mindustry.Vars.*;
import static mindustry.content.TechTree.*;
import mindustry.type.*;
@SuppressWarnings("all")

public class NetroTechTree {
    public static void load(){
        var costMultipliers = new ObjectFloatMap<Item>();
        for(var item : content.items()) costMultipliers.put(item, 0.1f);

        costMultipliers.put(NetroItems.dionite, 0.1f);
        costMultipliers.put(NetroItems.gatride, 0.1f);
        costMultipliers.put(NetroItems.hermite, 0.1f);

        NetroPlanets.netroniumPlanet.techTree = nodeRoot("Netronium", NetroBlocks.coreHusk, true, () -> {
            node(NetroBlocks.dioniteDrill, () -> {
            });

            node(NetroBlocks.dioniteNode, () -> {
            });

            node(NetroBlocks.dioniteConveyor, () -> {
                node(NetroBlocks.dioniteRouter, () -> {
                    node(NetroBlocks.dioniteUndConveyor, () -> {
                    });
                });
            });

            node(NetroBlocks.hermitePump, () -> {
                node(NetroBlocks.hermitePipe, () -> {
                    node(NetroBlocks.hermiteRouter, () -> {
                    });
                });
            });

            node(NetroBlocks.netroProcessor, () -> {
                node(NetroBlocks.netroSwitch, () -> {
                });
                node(NetroBlocks.netroMessage, () -> {
                });
                node(NetroBlocks.netroCell, () -> {
                });
            });

            node(NetroBlocks.origin, () -> {
                node(NetroBlocks.tesla, () -> {
                });
                node(NetroBlocks.dioniteWall, () -> {
                    node(NetroBlocks.largeDioniteWall, () -> {
                    });
                    node(NetroBlocks.dioniteDoor, () -> {
                    });
                });
            });

            node(NetroBlocks.dioniteAssembler, () -> {
                node(NetroUnits.spark);
                node(NetroUnits.hope);
                node(NetroUnits.kamikaze);
                node(NetroUnits.plasma);
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
                    nodeProduce(NetroLiquids.phomaxite, () -> {
                    });
                    nodeProduce(NetroLiquids.lava, () -> {
                    });
                });
            });
        });
    }
}