package me.bungee.staffchat.Inkzzz;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class StaffChatCMD extends Command {

	Config conf = new Config();
	private static final String perm = "staffchat.use";

	public StaffChatCMD() {
		super("staffchat", perm, new String[] { "sc" });
	}

	@SuppressWarnings("deprecation")
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length < 1) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&',
					"&cUsage> &7/staffchat <message>"));
			return;
		} else {
			for (ProxiedPlayer on : ProxyServer.getInstance().getPlayers()) {
				if (on.hasPermission(perm)) {
					on.sendMessage(ChatColor.translateAlternateColorCodes(
							'&',
							conf.getConfig()
									.getString("Format")
									.replace("%player%", p.getName())
									.replace("%message%", getMessage(args))
									.replace("%server%",
											p.getServer().getInfo().getName().toUpperCase())));
				}
			}
			return;
		}
	}

	private String getMessage(String[] args) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < args.length; i++) {
			sb.append(args[i]).append(" ");
		}
		return sb.toString();
	}

}
