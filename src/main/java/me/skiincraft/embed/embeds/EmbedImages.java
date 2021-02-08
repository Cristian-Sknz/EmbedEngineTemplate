package me.skiincraft.embed.embeds;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Images")
public class EmbedImages {

    private String image;
    private String thumbnail;

    public EmbedImages() {
    }

    public EmbedImages(String image, String thumbnail) {
        this.image = image;
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @XmlElement(name = "Image")
    public EmbedImages setImage(String image) {
        this.image = image;
        return this;
    }

    @XmlElement(name = "Thumbnail")
    public EmbedImages setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    @Override
    public String toString() {
        return "EmbedImages{" +
                "image='" + image + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
