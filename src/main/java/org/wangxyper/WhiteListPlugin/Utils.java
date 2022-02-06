package org.wangxyper.WhiteListPlugin;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Utils {
    public static FileConfiguration pluginConfig;
    public static FileConfiguration whiteLists;
    public static File whiteListFile;
    public static void init(){
        try {
            whiteListFile = new File("plugins\\WhiteListPlugin\\data.yml");
            whiteLists = new YamlConfiguration();
            whiteLists.load(whiteListFile);
        }catch (Exception e){e.printStackTrace();}
    }
    public static void save(){
        try {
            whiteLists.save(whiteListFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
