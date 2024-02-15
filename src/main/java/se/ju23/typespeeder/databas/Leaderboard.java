/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-08
 */
package se.ju23.typespeeder.databas;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Leaderboard {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "leaderboard_id", nullable = false)
    private long leaderboardId;
    @Basic
    @Column(name = "average", nullable = true)
    private double average;
    @Basic
    @Column(name = "speed", nullable = true)
    private double speed;
    @Basic
    @Column(name = "mostrights", nullable = true, length = 45)
    private Integer mostrights;
    @Basic
    @Column(name = "mostright_inorder", nullable = true, length = 45)
    private String mostrightInorder;
    @Basic
    @Column(name = "resultcol", nullable = true, length = 45)
    private String resultcol;
    @Basic
    @Column(name = "playerid", nullable = true, updatable = false,insertable = false)
    private Long playerid;
    @ManyToOne
    @JoinColumn(name = "playerid", referencedColumnName = "userid")
    private User userByPlayerid;

    public Leaderboard(double average, String resultcol, long playerid, double speed, int mostrights) {
        this.average = average;
        this.resultcol = resultcol;
        this.playerid = playerid;
        this.speed = speed;
        this.mostrights = mostrights;
    }

    public Leaderboard() {

    }

    public long getLeaderboardId() {
        return leaderboardId;
    }

    public void setLeaderboardId(long leaderboardId) {
        this.leaderboardId = leaderboardId;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(Integer average) {
        this.average = average;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getMostrights() {
        return mostrights;
    }

    public void setMostrights(int mostrights) {
        this.mostrights = mostrights;
    }

    public String getMostrightInorder() {
        return mostrightInorder;
    }

    public void setMostrightInorder(String mostrightInorder) {
        this.mostrightInorder = mostrightInorder;
    }

    public String getResultcol() {
        return resultcol;
    }

    public void setResultcol(String resultcol) {
        this.resultcol = resultcol;
    }

    public Long getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Long playerid) {
        this.playerid = playerid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Leaderboard that = (Leaderboard) o;
        return leaderboardId == that.leaderboardId && Objects.equals(average, that.average) && Objects.equals(speed, that.speed) && Objects.equals(mostrights, that.mostrights) && Objects.equals(mostrightInorder, that.mostrightInorder) && Objects.equals(resultcol, that.resultcol) && Objects.equals(playerid, that.playerid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leaderboardId, average, speed, mostrights, mostrightInorder, resultcol, playerid);
    }

    public User getUserByPlayerid() {
        return userByPlayerid;
    }

    public void setUserByPlayerid(User userByPlayerid) {
        this.userByPlayerid = userByPlayerid;
    }
}
