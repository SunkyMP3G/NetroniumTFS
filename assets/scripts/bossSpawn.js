Events.on(UnitSpawnEvent, event => {
  // Only display dialog if the spawned unit is a boss
  if(event.unit.type.name == "netroniummod-spark"){
	const hydraDialog = new BaseDialog(Core.bundle.format("boss-hydra"));
	// Add close button
	hydraDialog.addCloseButton();
	// Boss description and demo
	// add image right here //
	hydraDialog.cont.add(Core.bundle.format("boss-hydra-desc"));
	// Show dialog
	hydraDialog.show();
    }
  }
)