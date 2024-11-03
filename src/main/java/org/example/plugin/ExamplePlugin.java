package org.example.plugin;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.example.plugin.fernflower.FernflowerConfig;
import org.example.plugin.fernflower.FernflowerDecompiler;
import org.slf4j.Logger;
import software.coley.recaf.analytics.logging.Logging;
import software.coley.recaf.plugin.Plugin;
import software.coley.recaf.plugin.PluginInformation;
import software.coley.recaf.services.config.ConfigManager;
import software.coley.recaf.services.decompile.DecompilerManager;

@ApplicationScoped
@PluginInformation(id = "##ID##", version = "##VERSION##", name = "##NAME##", description = "##DESC##")
public class ExamplePlugin implements Plugin {
    private static final Logger logger = Logging.get(ExamplePlugin.class);
    private final DecompilerManager decompilerManager;
    private final FernflowerDecompiler fernflower;

    @Inject
    public ExamplePlugin(DecompilerManager decompileManager, ConfigManager configManager) {
        this.decompilerManager = decompileManager;
        FernflowerConfig fernflowerConfig = new FernflowerConfig();
        this.fernflower = new FernflowerDecompiler(fernflowerConfig);
        configManager.registerContainer(fernflowerConfig);
        decompilerManager.register(fernflower);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }
}
