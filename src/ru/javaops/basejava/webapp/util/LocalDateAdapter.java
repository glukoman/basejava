package ru.javaops.basejava.webapp.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

public final class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    @Override
    public LocalDate unmarshal(String str) {
        return LocalDate.parse(str);
    }

    @Override
    public String marshal(LocalDate ld) {
        return ld.toString();
    }
}
