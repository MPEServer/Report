package pe.teslex.report;

/**
 * Created by expexes on 13.01.2017.
 * Site: teslex.tech
 */

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Main extends PluginBase {

    public String token;
    public String id;
    public String msg;

    @Override
    public void onEnable() {
        this.getLogger().info("Запущен");
        this.initConfig();
        this.loadCfg();
    }

    public void initConfig(){
        this.getDataFolder().mkdirs();
        this.saveResource("config.yml");
    }

    public void loadCfg(){
        this.reloadConfig();
        this.token = this.getConfig().getString("token","token");
        this.id = this.getConfig().getString("id","1");
        this.msg = this.getConfig().getString("msg","Новое оповещение!<br>Отправлено игроком: {PLAYER}<br>Текст: {TEXT}");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        switch (command.getLabel()){
            case "report":
                if (args.length!=0){
                    String str = "";
                    for (String s : args) {
                        s = s + "%20";
                        str+=s;
                    }
                    String p = sender.getName();
                    this.msg = this.msg.replace("{PLAYER}", String.valueOf(p));
                    this.msg = this.msg.replace("{TEXT}", String.valueOf(str));
                    this.msg = this.msg.replace(" ", String.valueOf("%20"));
                    String line = "";
                    String url = "https://api.vk.com/method/"+
                            "messages.send"+
                            "?user_id="+id+
                            "&message="+msg+
                            "&access_token="+token+
                            "&v=5.60"
                            ;
                    try {
                        URL url2 = new URL(url);
                        BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream()));
                        line = reader.readLine();
                        reader.close();

                    } catch (MalformedURLException e) {

                    } catch (IOException e) {

                    }
                    this.getLogger().info("Игрок "+ p + " отправил репорт. Ответ от вк: " + line);
                    sender.sendMessage("Успех!");
                } else {
                    sender.sendMessage("Надо ввести описание!");
                }

        }
        return true;
    }
}
