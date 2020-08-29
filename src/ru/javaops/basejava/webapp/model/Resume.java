package ru.javaops.basejava.webapp.model;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public final class Resume implements Comparable<Resume>, Serializable {
    private static final long serialVersionUID = 1L;

    private final String uuid;
    private final String fullName;
    private final Map<ContactType, Link> contacts = new EnumMap<>(ContactType.class);
    private final Map<SectionType, AbstractSection<?>> sections = new EnumMap<>(SectionType.class);

    public Resume(String fullName) {
        this(UUID.randomUUID().toString().substring(0, 8), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must not be null");
        Objects.requireNonNull(fullName, "fullName must not be null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public Link getContact(ContactType type) {
        return contacts.get(type);
    }

    public void setContact(ContactType type, Link contact) {
        contacts.put(type, contact);
    }

    public AbstractSection<?> getSection(SectionType type) {
        return sections.get(type);
    }

    public void setSection(SectionType type, AbstractSection<?> section) {
        sections.put(type, section);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        if (!uuid.equals(resume.uuid)) return false;
        if (!fullName.equals(resume.fullName)) return false;
        if (!contacts.equals(resume.contacts)) return false;
        return sections.equals(resume.sections);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + fullName.hashCode();
        result = 31 * result + contacts.hashCode();
        result = 31 * result + sections.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Resume #" + uuid + ", fullName='" + fullName + "'\n\n" +
                contacts + "\n\n" +
                sections;
    }

    @Override
    public int compareTo(Resume o) {
        return uuid.compareTo(o.uuid);
    }
}
