var BomberDialogStopper = 0
Events.on(UnitSpawnEvent, event => {
// Only display dialog if the spawned unit is a boss
    if(event.unit.type.name == "netroniummod-bomber"){
        if(BomberDialogStopper != 1){
	        const bomberDialog = new BaseDialog(Core.bundle.format("unit.netroniummod-bomber.name"));
	        // Pause game
	        Vars.control.pause()
	        // Prevent dialog and music doubling. Resets only when game is launched again, which is good.
	        BomberDialogStopper = 1
	        // Boss description
	        bomberDialog.cont.add(Core.bundle.format("unit.netroniummod-bomber.description"));
	        // Show dialog
	        bomberDialog.addCloseButton();
	        bomberDialog.show();
            bomberDialog.hidden(()=>{
                // Play music and resume game
                Vars.control.resume()
                Vars.tree.loadMusic("boss-bomber").play();
            });
	    }
    }
})