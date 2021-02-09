package me.skiincraft.embed.embeds;

import me.skiincraft.embed.adapter.CustomCollapsedStringAdapter;
import org.jetbrains.annotations.NotNull;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@XmlRootElement(name="Fields")
public class EmbedFields implements Iterable<EmbedFields.EmbedField>{

    private EmbedField[] fields;

    public EmbedFields() {
    }

    public EmbedFields(EmbedField[] fields) {
        this.fields = fields;
    }

    public EmbedField[] getFields() {
        return fields;
    }

    public EmbedFields addField(EmbedField field){
        List<EmbedField> embeds = new ArrayList<>(Arrays.asList(fields));
        embeds.add(field);
        fields = embeds.toArray(new EmbedField[0]);
        return this;
    }

    @XmlElement(name = "Field")
    public EmbedFields setFields(EmbedField[] fields) {
        this.fields = fields;
        return this;
    }

    @NotNull
    @Override
    public Iterator<EmbedField> iterator() {
        return Arrays.asList(fields).iterator();
    }

    @XmlRootElement(name="Field")
    public static class EmbedField {

        private String name;
        private String value;
        private boolean inline;

        public EmbedField() {
        }

        public EmbedField(String name, String value, boolean inline) {
            this.name = name;
            this.value = value;
            this.inline = inline;
        }

        public String getName() {
            return name;
        }

        @XmlElement(name = "Name")
        public EmbedField setName(String name) {
            this.name = name;
            return this;
        }

        public String getValue() {
            return value;
        }

        @XmlElement(name = "Value")
        @XmlJavaTypeAdapter(CustomCollapsedStringAdapter.class)
        public EmbedField setValue(String value) {
            this.value = value;
            return this;
        }

        public boolean isInline() {
            return inline;
        }

        @XmlAttribute
        public EmbedField setInline(Boolean inline) {
            this.inline = inline;
            return this;
        }

        @Override
        public String toString() {
            return "EmbedField{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    ", inline=" + inline +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "EmbedFields{" +
                "fields=" + Arrays.toString(fields) +
                '}';
    }
}
