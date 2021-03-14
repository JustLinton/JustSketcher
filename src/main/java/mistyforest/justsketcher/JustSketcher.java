package mistyforest.justsketcher;

import mistyforest.justsketcher.Files.SettingsFile;
import mistyforest.justsketcher.Files.Tags.ActionTagsFile;
import mistyforest.justsketcher.Files.Tags.EventTagsFile;
import mistyforest.justsketcher.Files.Tags.PlayerTagsFile;
import mistyforest.justsketcher.events.PlayerJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class JustSketcher extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        setup();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    void setup(){
        setUpFiles();
        Tags.setUp();
        registerEvents();
    }

    void setUpFiles(){
        SettingsFile.setup();
        PlayerTagsFile.setup();
        EventTagsFile.setup();
        ActionTagsFile.setup();
    }

    void registerEvents(){
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);
    }
}
