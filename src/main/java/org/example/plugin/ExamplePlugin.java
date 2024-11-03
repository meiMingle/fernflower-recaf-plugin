package org.example.plugin;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import org.example.plugin.fernflower.FernflowerDecompiler;
import org.slf4j.Logger;
import software.coley.recaf.analytics.logging.Logging;
import software.coley.recaf.plugin.Plugin;
import software.coley.recaf.plugin.PluginInformation;
import software.coley.recaf.services.decompile.DecompilerManager;
import software.coley.recaf.services.decompile.JvmDecompiler;

@ApplicationScoped
@PluginInformation(id = "fernflower-plugin", version = "1.00", name = "Fernflower Plugin", description = "##DESC##")
public class ExamplePlugin implements Plugin {
	private static final Logger logger = Logging.get(ExamplePlugin.class);
	private final DecompilerManager decompilerManager;
	private JvmDecompiler jvmDecompiler = null;

	@Inject
	public ExamplePlugin(DecompilerManager decompileManager, Instance<JvmDecompiler> implementations) {
		this.decompilerManager = decompileManager;
		for (JvmDecompiler implementation : implementations) {
            if (implementation instanceof FernflowerDecompiler fernflowerDecompiler) {
				jvmDecompiler = fernflowerDecompiler;
            }
		}
	}

	@Override
	public void onEnable() {
		logger.info("Hello from the example plugin");
		if (jvmDecompiler != null) {
			decompilerManager.register(jvmDecompiler);
		}

	}

	@Override
	public void onDisable() {
		logger.info("goodbye from the example plugin");
	}
}
