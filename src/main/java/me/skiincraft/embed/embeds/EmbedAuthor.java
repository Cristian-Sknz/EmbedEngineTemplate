package me.skiincraft.embed.embeds;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Author")
public class EmbedAuthor {

    private String icon;
    private String name;
    private String url;

    public EmbedAuthor(String icon, String name, String url) {
        this.icon = icon;
        this.name = name;
        this.url = url;
    }

    public EmbedAuthor() {
    }

    public String getIcon() {
        return icon;
    }

    @XmlAttribute
    public EmbedAuthor setIcon(String icon) {
        this.icon = icon;
        return this;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name= "Name")
    public EmbedAuthor setName(String name) {
        this.name = name;
        return this;
    }

    public String getUrl() {
        return url;
    }

    @XmlElement(name= "URL")
    public EmbedAuthor setUrl(String url) {
        this.url = url;
        return this;
    }

    @Override
    public String toString() {
        return "EmbedAuthor{" +
                "icon='" + icon + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
