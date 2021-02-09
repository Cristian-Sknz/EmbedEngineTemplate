package me.skiincraft.embed.adapter;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;

public class CustomCollapsedStringAdapter extends CollapsedStringAdapter {

    public CustomCollapsedStringAdapter() {
    }

    @Override
    public String unmarshal(String v) {
        return super.unmarshal(v).replace("\\n", "\n");
    }

    @Override
    public String marshal(String v) {
        return super.marshal(v);
    }
}
