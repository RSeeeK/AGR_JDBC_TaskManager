package entity;

import java.sql.Date;

public class Reminders {
    private long id;
    private String description;
    private Date reminderTime;

    public Reminders() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(Date reminderTime) {
        this.reminderTime = reminderTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Reminders reminders = (Reminders) o;

        if (id != reminders.id) return false;
        if (description != null ? !description.equals(reminders.description) : reminders.description != null)
            return false;
        return reminderTime != null ? reminderTime.equals(reminders.reminderTime) : reminders.reminderTime == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (reminderTime != null ? reminderTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Reminders{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", reminderTime=" + reminderTime +
                '}';
    }
}
