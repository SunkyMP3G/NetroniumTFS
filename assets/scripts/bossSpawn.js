Events.on(UnitSpawnEvent, event => {
  // Only display dialog if the spawned unit is a boss
  if(event.unit.type.name == "netroniummod-hydra"){
	const hydraDialog = new BaseDialog(Core.bundle.format("hydra-name"));
	// Add close button
	hydraDialog.addCloseButton();
	// Boss description
	hydraDialog.cont.add(Core.bundle.format("hydra-desc"));
	// Show dialog
	hydraDialog.show();
    }
  }
)

Events.on(UnitSpawnEvent, event => {
  if(event.unit.type.name == "netroniummod-bomber"){
	const bomberDialog = new BaseDialog(Core.bundle.format("bomber-name"));
	bomberDialog.addCloseButton();
	bomberDialog.cont.add(Core.bundle.format("bomber-desc"));
	Vars.tree.loadMusic("boss-bomber").play();
	bomberDialog.show();
    }
  }
)