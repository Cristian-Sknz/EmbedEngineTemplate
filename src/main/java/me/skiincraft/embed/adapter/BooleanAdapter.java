package me.skiincraft.embed.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanAdapter extends XmlAdapter<String, Boolean> {

    public static final BooleanAdapter INSTANCE = new BooleanAdapter();
    private BooleanAdapter() {
    }

    @Override
    public Boolean unmarshal(String v) {
        return v.equalsIgnoreCase("true") || v.equalsIgnoreCase("y") || v.equalsIgnoreCase("yes");
    }

    @Override
    public String marshal(Boolean v) {
        return (v) ? "true" : "false";
    }
}
