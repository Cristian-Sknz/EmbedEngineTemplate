package me.skiincraft.embed;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import me.skiincraft.embed.adapter.BooleanAdapter;
import me.skiincraft.embed.adapter.CustomCollapsedStringAdapter;
import me.skiincraft.embed.embeds.Embed;
import me.skiincraft.embed.embeds.EmbedFields;
import net.dv8tion.jda.api.EmbedBuilder;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class EmbedModel {

    private final Template template;
    private final Map<String, Object> properties = new HashMap<>();

    public EmbedModel(String name) {
        this.template = checkTemplate(name);
    }

    public EmbedModel addProperties(String name, Object object){
        properties.put(name, object);
        return this;
    }

    public void removeProperties(String name){
        properties.remove(name);
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public EmbedBuilder build() throws IOException, TemplateException, JAXBException {
        EmbedBuilder builder = new EmbedBuilder();
        Embed embed = buildEmbed();
        builder.setTitle(embed.getTitle(), embed.getUrl());
        if (embed.getDescription() != null){
            builder.setDescription(embed.getDescription());
        }
        if (embed.getAuthor() != null) {
            builder.setAuthor(embed.getAuthor().getName(), embed.getAuthor().getUrl(), embed.getAuthor().getIcon());
        }
        if (embed.getImages() != null) {
            builder.setThumbnail(embed.getImages().getThumbnail());
            builder.setImage(embed.getImages().getImage());
        }
        if (embed.getFields() != null && embed.getFields().getFields().length != 0){
            for (EmbedFields.EmbedField field : embed.getFields()){
                builder.addField(field.getName(), field.getValue(), field.isInline());
            }
        }
        if (embed.getFooter() != null){
            builder.setFooter(embed.getFooter().getText(), embed.getFooter().getIcon());
        }
        builder.setColor(embed.getColor().getColor());
        return builder;
    }

    public Embed buildEmbed() throws IOException, TemplateException, JAXBException {
        StringWriter writer = new StringWriter();
        template.process(properties, writer);
        Unmarshaller marshaller = EmbedTemplate.getInstance().getJAXBContent().createUnmarshaller();
        marshaller.setAdapter(BooleanAdapter.INSTANCE);
        marshaller.setAdapter(new CustomCollapsedStringAdapter());
        return (Embed) marshaller.unmarshal(new ByteArrayInputStream(writer.toString().getBytes(StandardCharsets.UTF_8)));
    }

    private Template checkTemplate(String templateName){
        try {
            return EmbedTemplate.getInstance().getConfiguration().getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
