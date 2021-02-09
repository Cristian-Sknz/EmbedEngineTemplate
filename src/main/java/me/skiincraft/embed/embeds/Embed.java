package me.skiincraft.embed.embeds;

import me.skiincraft.embed.adapter.CustomCollapsedStringAdapter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "Embed")
@XmlType(propOrder = { "title", "description", "url", "color", "author", "fields", "images", "footer" })
public class Embed {

    private String title;
    private String description;
    private String url;
    private EmbedColor color;
    private EmbedAuthor author;
    private EmbedFields fields;
    private EmbedImages images;
    private EmbedFooter footer;

    public Embed() {
    }

    public Embed(String title, String description, String url, EmbedColor color, EmbedAuthor author, EmbedFields fields, EmbedImages images, EmbedFooter footer) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.color = color;
        this.author = author;
        this.fields = fields;
        this.images = images;
        this.footer = footer;
    }

    public String getTitle() {
        return title;
    }

    @XmlElement(name= "Title")
    public Embed setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    @XmlElement(name= "Description")
    @XmlJavaTypeAdapter(CustomCollapsedStringAdapter.class)
    public Embed setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    @XmlElement(name= "URL")
    public Embed setUrl(String url) {
        this.url = url;
        return this;
    }

    public EmbedColor getColor() {
        return color;
    }

    @XmlElement(name= "Color")
    public Embed setColor(EmbedColor color) {
        this.color = color;
        return this;
    }

    public EmbedAuthor getAuthor() {
        return author;
    }

    @XmlElement(name= "Author")
    public Embed setAuthor(EmbedAuthor author) {
        this.author = author;
        return this;
    }

    public EmbedFields getFields() {
        return fields;
    }

    @XmlElement(name= "Fields")
    public Embed setFields(EmbedFields fields) {
        this.fields = fields;
        return this;
    }

    public Embed addField(EmbedFields.EmbedField field){
        if (fields == null) {
            fields = new EmbedFields(new EmbedFields.EmbedField[]{field});
            return this;
        }
        fields.addField(field);
        return this;
    }

    public EmbedImages getImages() {
        return images;
    }

    @XmlElement(name= "Images")
    public Embed setImages(EmbedImages images) {
        this.images = images;
        return this;
    }

    public EmbedFooter getFooter() {
        return footer;
    }

    @XmlElement(name = "Footer")
    public Embed setFooter(EmbedFooter footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public String toString() {
        return "Embed{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", color=" + color +
                ", author=" + author +
                ", fields=" + fields +
                ", images=" + images +
                '}';
    }
}
