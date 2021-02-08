package me.skiincraft.embed.embeds;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "Footer")
public class EmbedFooter {

    private String icon;
    private String text;

    public EmbedFooter() {
    }

    public EmbedFooter(String icon, String text) {
        this.icon = icon;
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    @XmlAttribute
    public EmbedFooter setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getText() {
        return text;
    }

    @XmlValue
    public EmbedFooter setText(String text) {
        this.text = text;
        return this;
    }
}
