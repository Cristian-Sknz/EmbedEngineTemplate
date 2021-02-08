package me.skiincraft.embed.embeds;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
import java.awt.*;
import java.util.Arrays;

@XmlRootElement(name = "Color")
public class EmbedColor {

    private String type;
    private String color;

    public EmbedColor(String type, String color) {
        this.type = type;
        this.color = color;
    }

    public EmbedColor(Color color) {
        this.color = color.getRed() + "," + color.getGreen() + "," + color.getBlue();
        this.type = "rgb";
    }

    public EmbedColor() {
    }

    public String getType() {
        return type;
    }

    @XmlAttribute
    public EmbedColor setType(String type) {
        this.type = type;
        return this;
    }

    public Color getColor() {
        if (type == null || type.equalsIgnoreCase("rgb")){
            Float[] rgb = Arrays.stream(color.split(","))
                    .map(str -> Float.parseFloat(str.trim()))
                    .toArray(Float[]::new);
            if (rgb.length == 1) {
                return new Color(Math.round(rgb[0]));
            }
            return new Color(rgb[0], rgb[1], rgb[2]);
        }
        if (type.equalsIgnoreCase("hex")){
            return new Color(Integer.valueOf(color.substring( 1, 3 ), 16 ),
                    Integer.valueOf(color.substring( 3, 5 ), 16 ),
                    Integer.valueOf(color.substring( 5, 7 ), 16 ) );
        }

        return Color.BLACK;
    }

    @XmlValue
    public EmbedColor setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public String toString() {
        return "EmbedColor{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
