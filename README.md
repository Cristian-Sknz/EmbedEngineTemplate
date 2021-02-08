## Embed Template "Engine"
A useful tool to standardize the use of embeds in a JDA application.
(This project is a basic version used in the [Ou!su Bot](https://github.com/Cristian-Sknz/Ou-su))

##### The XML embed format:
```xml
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<Embed>
    <Title>Hello ${user}, what do you want for today?</Title>
    <Description>You already chose your option this week, look below!</Description>
    <URL>${userurl}</URL>
    <Color type="rgb">0, 0, 255</Color>
    <!-- Hex Color Support | type="hex"-->
    <Author icon="${bot.icon}">
        <Name>OusuBot</Name>
        <URL>https://github.com/Cristian-Sknz/Ou-su</URL>
    </Author>
    <Fields>
        <Field inline="true">
            <Name>[x] Money</Name>
            <Value>:(</Value>
        </Field>
        <Field inline="true">
            <Name>[ ] Happiness</Name>
            <Value>:)</Value>
        </Field>
    </Fields>
    <Images>
        <Image>${user.banner}</Image>
        <Thumbnail>${user.avatar}</Thumbnail>
    </Images>
</Embed>
```

##### Configuration:
I recommend researching the [Apache Freemaker library](https://freemarker.apache.org/).
```java
public static void main(String[] args){
    EmbedTemplate engine = EmbedTemplate.getInstance();
    //For xml files in classpath use:
    engine.getConfiguration().setClassForTemplateLoading(Main.class, "/templates/");
    //Otherwise, for external files, use:
    engine.getConfiguration().setDirectoryForTemplateLoading(new File("path"));
}
```
##### Example:
```java
public void sendMessage(TextChannel channel, User user, Bot bot){
    EmbedModel model = new EmbedModel("BuyEmbed.xml");
    model.addProperties("user", user);
    model.addProperties("bot", bot);
    try {
        EmbedBuilder embed = model.build();
        channel.sendMessage(embed.build()).queue();
    } catch (Exception e){
      e.printStackTrace();
    }
}
```
