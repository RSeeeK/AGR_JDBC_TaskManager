package entity;

public class Task {
    private long id;
    private String name;
    private String description;
    private long importance_id;
    private long reminder_id;
    private Boolean completed;

    public Task() {

    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getImportance_id() {
        return importance_id;
    }

    public void setImportance_id(long importance_id) {
        this.importance_id = importance_id;
    }

    public long getReminder_id() {
        return reminder_id;
    }

    public void setReminder_id(long reminder_id) {
        this.reminder_id = reminder_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (importance_id != task.importance_id) return false;
        if (reminder_id != task.reminder_id) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        return description != null ? description.equals(task.description) : task.description == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (importance_id ^ (importance_id >>> 32));
        result = 31 * result + (int) (reminder_id ^ (reminder_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", importance_id=" + importance_id +
                ", reminder_id=" + reminder_id +
                '}';
    }
}
