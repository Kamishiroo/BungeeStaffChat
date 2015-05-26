package me.bungee.staffchat.Inkzzz;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Config {

	private Configuration config;

	public void setupConfig() {
		try {
			if (!Main.getInstance().getDataFolder().exists()) {
				Main.getInstance().getDataFolder().mkdir();
			}
			File file = new File(Main.getInstance().getDataFolder(),
					"config.yml");
			if (!file.exists()) {
				Files.copy(
						Main.getInstance().getResourceAsStream("config.yml"),
						file.toPath());
			}

			loadConfig();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadConfig() {
		try {
			config = ConfigurationProvider.getProvider(YamlConfiguration.class)
					.load(new File(Main.getInstance().getDataFolder(),
							"config.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveConfig() {
		try {
			ConfigurationProvider.getProvider(YamlConfiguration.class).save(
					getConfig(),
					new File(Main.getInstance().getDataFolder(), "config.yml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Configuration getConfig() {
		return config;
	}

}
