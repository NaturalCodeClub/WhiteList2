package org.wangxyper.WhiteListPlugin.commands;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.wangxyper.WhiteListPlugin.Utils;
public class CommandWhiteList implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length!=2)
        {
            switch (args[0]){
                case "add":
                    whiteList(true,args[1]);
                    break;
                case "remove":
                    whiteList(false,args[1]);
                    break;
                default:
                    sender.sendMessage("用法错误！正确用法:");
                    return false;
            }
        }else{
            sender.sendMessage("用法错误！正确用法:");
            return false;
        }
        return true;
    }
    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent e){
        if(!Utils.whiteLists.contains(e.getPlayer().getName())){
            !Utils.whiteLists.set(e.getPlayer().getName(),false);
        }
        if (!Utils.whiteLists.getBoolean(e.getPlayer().getName()))
        {
            e.disallow(PlayerLoginEvent.Result.KICK_WHITELIST,Utils.pluginConfig.getString("MessageKickedByWhiteList"));
        }
        Utils.save();
    }
    public String whiteList(boolean addOrRemove,String playerName){
        String outMessage = "Null";
        if (addOrRemove)
        {
            if (Utils.whiteLists.getBoolean(playerName))
            {
                outMessage=ChatColor.RED+"玩家已在白名单内！";
            }
            Utils.whiteLists.set(playerName,true);
            outMessage= ChatColor.GREEN+ "已添加!";
        }else{
            if (!Utils.whiteLists.getBoolean(playerName))
            {
                outMessage=ChatColor.RED+"该玩家不再白名单内!";
            }
            Utils.whiteLists.set(playerName,false);
            outMessage=ChatColor.GREEN+"已删除！";
        }
        Utils.save();
        return outMessage;
    }
}
