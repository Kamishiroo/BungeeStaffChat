package me.bungee.staffchat.Inkzzz;

import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin {

	private Config conf = new Config();
	
	private static Main instance;

	public static Main getInstance() {
		return instance;
	}

	public void onEnable() {
		instance = this;
		conf.setupConfig();
		loadCommands();
	}
	
	void loadCommands() {
		this.getProxy().getPluginManager().registerCommand(this, new StaffChatCMD());
	}

}
