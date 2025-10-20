package netro.content;

import arc.graphics.*;
import mindustry.type.*;

public class NetroGuideItems {
    public static Item
            guideIntro, energyGuide, bossGuide, bossRageGuide;

    public static void load(){
        guideIntro = new Item("guide-intro", Color.valueOf("000000")){{ // Intro
            buildable = false;
            alwaysUnlocked = true;
            hideDatabase = true;
        }};
        energyGuide = new Item("guide-energy", Color.valueOf("000000")){{ // About core producing energy
            buildable = false;
            hideDatabase = true;
        }};
        bossGuide = new Item("guide-boss", Color.valueOf("000000")){{ // About bosses
            buildable = false;
            hideDatabase = true;
        }};
        bossRageGuide = new Item("guide-boss-rage", Color.valueOf("000000")){{ // About boss rage levels
            buildable = false;
            frames = 4;
            frameTime = 120f;
            hideDatabase = true;
        }};
    }
}