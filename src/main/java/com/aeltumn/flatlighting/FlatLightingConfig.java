package com.aeltumn.flatlighting;

import com.google.gson.Gson;
import net.fabricmc.loader.api.FabricLoader;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class FlatLightingConfig {
    private static final Gson GSON = new Gson();
    private static FlatLightingConfig instance;

    public boolean cardinalLighting = true;

    /**
     * Returns the current config state.
     */
    public static FlatLightingConfig get() {
        if (instance == null) {
            instance = load();
        }
        return instance;
    }

    /**
     * Loads this configuration file.
     */
    private static FlatLightingConfig load() {
        var file = getConfigFile();
        if (Files.exists(file)) {
            try (var reader = new FileReader(file.toFile())) {
                return GSON.fromJson(reader, FlatLightingConfig.class);
            } catch (Exception x) {
                x.printStackTrace();
            }
        }
        return new FlatLightingConfig();
    }

    /**
     * Saves the changes to this configuration file.
     */
    public void save() {
        try {
            Files.writeString(getConfigFile(), GSON.toJson(this));
        } catch (Exception x) {
            x.printStackTrace();
        }
    }

    /**
     * Returns the path where the configuration file is stored.
     */
    public static Path getConfigFile() {
        return FabricLoader.getInstance().getConfigDir().resolve("flat-lighting.json");
    }
}
