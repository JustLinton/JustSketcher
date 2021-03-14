package mistyforest.justsketcher.msgs;

import mistyforest.justsketcher.JustSketcher;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Messenger {
    Plugin plugin= JustSketcher.getPlugin(JustSketcher.class);

    public static void sendMsg(Player receiver){

        TextComponent chat = new TextComponent("");
        TextComponent componentNameTag = new TextComponent("1");
        TextComponent componentSplit = new TextComponent("--");
        TextComponent componentMsg = new TextComponent("2");
        TextComponent componentHover_NameLine1_Left = new TextComponent("|");
        TextComponent componentHover_NameLine1_Mid = new TextComponent("hover");
        TextComponent componentHover_NameLine1_Medal = new TextComponent("hover2");
        TextComponent componentHover_NameLine1_Online = new TextComponent("⬛  ");
        TextComponent componentHover_NameLine1_Right = new TextComponent("|\n");
        TextComponent componentHover_NameLine2 = new TextComponent("点击互动");
        componentHover_NameLine1_Online.setColor(ChatColor.of(getHexStr("<#83c599>")));
        componentHover_NameLine2.setColor(ChatColor.WHITE);
        componentHover_NameLine1_Mid.setColor(ChatColor.WHITE);
        componentHover_NameLine1_Left.setColor(ChatColor.WHITE);
        componentHover_NameLine1_Right.setColor(ChatColor.WHITE);

        componentHover_NameLine1_Online.addExtra(componentHover_NameLine1_Mid);
        componentHover_NameLine1_Online.addExtra(componentHover_NameLine1_Left);
        componentHover_NameLine1_Online.addExtra(componentHover_NameLine1_Right);
        componentHover_NameLine1_Online.addExtra(componentHover_NameLine2);
        componentNameTag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("hoverFormat")).create()));
        componentNameTag.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/help "));
        componentNameTag.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder(componentHover_NameLine1_Online)).create()));
        componentMsg.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (new ComponentBuilder("回复该消息")).create()));
        componentNameTag.setColor(ChatColor.of(getHexStr("<#cbe2ec>")));
        componentSplit.setColor(ChatColor.of(getHexStr("<#fdf2c5>")));
        componentMsg.setColor(ChatColor.of(getHexStr("<#FFFFFF>")));
        chat.addExtra(componentNameTag);
        chat.addExtra(componentSplit);
        chat.addExtra(componentMsg);

        receiver.spigot().sendMessage((BaseComponent)chat);

    }

    private static String getHexStr(String legacyMsg) {
        Matcher matcher = Pattern.compile("<#[A-Fa-f0-9]{6}>").matcher(legacyMsg);
        int hexAmount = 0;
        while (matcher.find()) {
            matcher.region(matcher.end() - 1, legacyMsg.length());
            hexAmount++;
        }
        int startIndex = 0;
        String res="";
        for (int hexIndex = 0; hexIndex < hexAmount; hexIndex++) {
            int msgIndex = legacyMsg.indexOf("<#", startIndex);
            String hex = legacyMsg.substring(msgIndex + 1, msgIndex + 8);
            startIndex = msgIndex + 2;
            res=hex;
        }
        return res;
    }
}
