Events.on(UnitSpawnEvent, event => {
  // Only display dialog if the spawned unit is a boss
  if(event.unit.type.name == "netroniummod-hydra"){
	const hydraDialog = new BaseDialog(Core.bundle.format("unit.netroniummod-hydra.name"));
	// Add close button
	hydraDialog.addCloseButton();
	// Boss description and demo
	// add image right here //
	hydraDialog.cont.add(Core.bundle.format("unit.netroniummod-hydra.description"));
	// Show dialog
	hydraDialog.show();
    }
  }
)

Events.on(UnitSpawnEvent, event => {
  if(event.unit.type.name == "netroniummod-bomber"){
	const bomberDialog = new BaseDialog(Core.bundle.format("unit.netroniummod-bomber.name"));
	bomberDialog.addCloseButton();
	bomberDialog.cont.add(Core.bundle.format("unit.netroniummod-bomber.description"));
	bomberDialog.show();
    }
  }
)