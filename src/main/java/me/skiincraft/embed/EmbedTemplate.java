package me.skiincraft.embed;

import freemarker.template.Configuration;
import me.skiincraft.embed.embeds.Embed;

import javax.xml.bind.JAXBContext;

public class EmbedTemplate {

    private static final EmbedTemplate instance = new EmbedTemplate();
    private final Configuration cfg;
    private JAXBContext xml;

    private EmbedTemplate() {
        this.cfg = new Configuration(Configuration.VERSION_2_3_0);
        this.cfg.setDefaultEncoding("UTF-8");
        try {
            this.xml = JAXBContext.newInstance(Embed.class);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Configuration getConfiguration(){
        return cfg;
    }

    public JAXBContext getJAXBContent(){
        return xml;
    }

    public static EmbedTemplate getInstance() {
        return instance;
    }
}
