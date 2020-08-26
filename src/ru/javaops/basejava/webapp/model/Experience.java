package ru.javaops.basejava.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public final class Experience {
    private final LocalDate startDate;
    private final LocalDate finishDate;
    private final String title;
    private final String description;

    public Experience(LocalDate startDate, LocalDate finishDate,
                      String title, String description) {
        Objects.requireNonNull(startDate, "startDate must not be null");
        Objects.requireNonNull(finishDate, "finishDate must not be null");
        Objects.requireNonNull(title, "title must not be null");
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.title = title;
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Experience that = (Experience) o;

        if (!startDate.equals(that.startDate)) return false;
        if (!finishDate.equals(that.finishDate)) return false;
        if (!title.equals(that.title)) return false;
        return description != null
                ? description.equals(that.description)
                : that.description == null;
    }

    @Override
    public int hashCode() {
        int result = startDate.hashCode();
        result = 31 * result + finishDate.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String startDateText =
                String.format("%02d\\%04d", startDate.getMonthValue(), startDate.getYear());
        String finishDateText = (finishDate.isAfter(LocalDate.now()))
                ? "Сейчас"
                : String.format("%02d\\%04d", finishDate.getMonthValue(), finishDate.getYear());
        String descriptionText = (description == null) ? "" : description;

        return startDateText + " - " + finishDateText + "\t\t" +
                title + '\n' + descriptionText;
    }
}
