package se.ju23.typespeeder.logic;
/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-8
 */
import jakarta.persistence.*;
import org.hibernate.query.results.TableGroupImpl;
import se.ju23.typespeeder.databas.User;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Attempt {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "attempt_id", nullable = false)
    private long attemptId;
    @Basic
    @Column(name = "user_id", nullable = false,insertable = false,updatable = false)
    private long userId;
    @Basic
    @Column(name = "task_id", nullable = false,updatable = false,insertable = false)
    private long taskId;
    @Basic
    @Column(name = "outcome", nullable = false, length = 100)
    private String outcome;
    @Basic
    @Column(name = "end_time", nullable = false)
    private Timestamp endTime;
    @Basic
    @Column(name = "gamename", nullable = false)
    private String gamename;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userid", nullable = false)
    private User userByUserId;
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id", nullable = false)
    private Gametask gametaskByTaskId;



    public Attempt() {

    }

    public Attempt(long userId, long taskId, String outcome, Timestamp timestamp, String gamename) {
        this.userId = userId;
        this.taskId = taskId;
        this.outcome = outcome;
        this.endTime = timestamp;
        this.gamename = gamename;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    public long getAttemptId() {
        return attemptId;
    }

    public void setAttemptId(long attemptId) {
        this.attemptId = attemptId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Attempt{" +
                "attemptId=" + attemptId +
                ", userId=" + userId +
                ", taskId=" + taskId +
                ", outcome='" + outcome + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attempt attempt = (Attempt) o;
        return attemptId == attempt.attemptId && userId == attempt.userId && taskId == attempt.taskId && Objects.equals(outcome, attempt.outcome) && Objects.equals(endTime, attempt.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(attemptId, userId, taskId, outcome, endTime);
    }

    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    public Gametask getGametaskByTaskId() {
        return gametaskByTaskId;
    }

    public void setGametaskByTaskId(Gametask gametaskByTaskId) {
        this.gametaskByTaskId = gametaskByTaskId;
    }
}
