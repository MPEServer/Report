package tech.teslex.mpes.report;

/**
 * Created by expexes on 13.01.2017.
 * Site: teslex.tech
 */

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import com.google.gson.Gson;
import tech.teslex.mail.Mail;
import tech.teslex.mpes.report.config.Config;
import tech.teslex.mpes.report.vk.VKApi;
import tech.teslex.mpes.report.vk.impl.VKApiImpl;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Report extends PluginBase {

    private static Config config;

    @Override
    public void onEnable() {
        getLogger().info("Enabled");
        initConfig();
        config = loadCfg();

//		if (config.getEmail().isUse())
//			if (getServer().getPluginManager().getPlugin("MailApi") != null)
//				getLogger().error("Plugin MailApi not found! Please install it and start again!");
    }

    private void initConfig() {
        getDataFolder().mkdirs();
        saveResource("config.json");
    }

    private Config loadCfg() {
        Gson gson = new Gson();
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(getDataFolder() + "/config.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return gson.fromJson(br, Config.class);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getLabel()) {
            case "report":
                if (args.length != 0) {

                    if (config == null)
                        return false;

                    if (config.getVk().isUse()) {
                        VKApi vkApi = new VKApiImpl();

                        new Thread(() -> {
                            try {
                                vkApi.sendMessage(
                                        String.valueOf(config.getVk().getReceiverId()),
                                        config.getVk().getSenderToken(),
                                        config.getMessageTemplate()
                                                .replace(" ", "%20")
                                                .replace("{TEXT}", String.join("%20", args))
                                                .replace("{PLAYER}", sender.getName()));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }

                    if (config.getEmail().isUse()) {
                        Properties p = new Properties();
                        p.put("mail.smtp.auth", config.getEmail().getSmtpAuth());
                        p.put("mail.smtp.starttls.enable", true);
                        p.put("mail.smtp.host", config.getEmail().getSmtpHost());
                        p.put("mail.smtp.port", config.getEmail().getSmtpPort());
                        new Thread(() -> {
                            try {
                                new Mail(p, config.getEmail().getUsername(), config.getEmail().getPassword())
                                        .send(
                                                config.getEmail().getSenderEmail(),
                                                config.getEmail().getReceiverMail(),
                                                config.getEmail().getTitle(),
                                                config.getMessageTemplate()
                                                        .replace("{TEXT}", String.join(" ", args))
                                                        .replace("{PLAYER}", sender.getName()),
                                                config.getEmail().getType());
                            } catch (MessagingException e) {
                                e.printStackTrace();
                            }
                        }).start();
                    }

                    sender.sendMessage(config.getOnSendMessage());
                } else {
                    sender.sendMessage("Error!");
                }

        }
        return true;
    }
}
