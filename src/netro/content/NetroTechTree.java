package netro.content;

import arc.struct.*;
import static mindustry.Vars.*;
import static mindustry.content.TechTree.*;
import mindustry.type.*;
@SuppressWarnings("all")

public class NetroTechTree {
    public static void load(){
        var costMultipliers = new ObjectFloatMap<Item>();
        for(var item : content.items()) costMultipliers.put(item, 0f);

        costMultipliers.put(NetroItems.dionite, 0f);
        costMultipliers.put(NetroItems.ferroAluminium, 0f);
        costMultipliers.put(NetroItems.steelIngot, 0f);
        costMultipliers.put(NetroItems.netroCopper, 0f);

        NetroPlanets.netroniumPlanet.techTree = nodeRoot("netronium-tt", NetroBlocks.coreHusk, true, () -> {
            node(NetroBlocks.dioniteDrill, () -> {
                node(NetroBlocks.steelDrill, () -> {
                });
            });

            node(NetroBlocks.dioniteNode, () -> {
            });

            node(NetroBlocks.dioniteConveyor, () -> {
                node(NetroBlocks.dioniteRouter, () -> {
                    node(NetroBlocks.dioniteUndConveyor, () -> {
                    });
                });
            });

            node(NetroBlocks.alumPump, () -> {
                node(NetroBlocks.alumPipe, () -> {
                    node(NetroBlocks.alumRouter, () -> {
                    });
                });
            });

            node(NetroBlocks.alloyFurnace, () -> {
                node(NetroBlocks.steelFurnace, () -> {
                });
                node(NetroBlocks.netroProcessor, () -> {
                    node(NetroBlocks.netroSwitch, () -> {
                    });
                    node(NetroBlocks.netroMessage, () -> {
                    });
                    node(NetroBlocks.netroCell, () -> {
                    });
                });
            });

            node(NetroBlocks.origin, () -> {
                node(NetroBlocks.tesla, () -> {
                });
                node(NetroBlocks.dioniteWall, () -> {
                    node(NetroBlocks.largeDioniteWall, () -> {
                    });
                    node(NetroBlocks.steelWall, () -> {
                        node(NetroBlocks.largeSteelWall, () -> {
                        });
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
                nodeProduce(NetroItems.aluminium, () -> {
                    nodeProduce(NetroItems.ferroAluminium, () -> {
                    });
                });
                nodeProduce(NetroItems.trinite, () -> {
                });
                nodeProduce(NetroItems.netroCopper, () -> {
                    nodeProduce(NetroItems.steelIngot, () -> {
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