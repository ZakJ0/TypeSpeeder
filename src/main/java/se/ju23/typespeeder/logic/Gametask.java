package se.ju23.typespeeder.logic;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Gametask {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "task_id", nullable = false)
    private long taskId;
    @Basic
    @Column(name = "language", nullable = false)
    private Object language;
    @Basic
    @Column(name = "task_type", nullable = false)
    private int taskType;
    @Basic
    @Column(name = "created_timestamp", nullable = false)
    private Timestamp createdTimestamp;
    @Basic
    @Column(name = "solution", nullable = false, length = -1)
    private String solution;
    @OneToMany(mappedBy = "gametaskByTaskId")
    private Collection<Attempt> attemptsByTaskId;

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public Object getLanguage() {
        return language;
    }
    public Object getSvenska(){
        return "svenska"+solution;
    }

    public void setLanguage(Object language) {
        this.language = language;
    }

    public int getTaskType() {
        return taskType;
    }

    public void setTaskType(int taskType) {
        this.taskType = taskType;
    }

    public Timestamp getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Timestamp createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gametask gametask = (Gametask) o;
        return taskId == gametask.taskId && taskType == gametask.taskType && Objects.equals(language, gametask.language) && Objects.equals(createdTimestamp, gametask.createdTimestamp) && Objects.equals(solution, gametask.solution);
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId, language, taskType, createdTimestamp, solution);
    }

    public Collection<Attempt> getAttemptsByTaskId() {
        return attemptsByTaskId;
    }

    @Override
    public String toString() {
        return "Gametask{" +
                "solution='" + solution + '\'' +
                '}';
    }

    public void setAttemptsByTaskId(Collection<Attempt> attemptsByTaskId) {
        this.attemptsByTaskId = attemptsByTaskId;
    }
    public static Gametask getGameTaskByLanguage(String language) {
        // Assume you have a method to fetch from the database based on language
        // Example: GametaskDAO.getGameTaskByLanguage(language);
        // Implement your database logic here
        // Return a sample task for demonstration
        Gametask task = new Gametask();
        task.setLanguage(language);
        task.setTaskType(1); // Assuming a task type
        task.setSolution("This is a sample solution."); // Sample solution
        return task;
    }

}
