/*Zakaria Jaouhari,Emanuel Sleyman
30-01-24
zakaria.jaouhari@iths.se*/
package se.ju23.typespeeder.databas;

import jakarta.persistence.*;
import se.ju23.typespeeder.Main;
import se.ju23.typespeeder.logic.Attempt;

import java.sql.*;
import java.util.*;

@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "userid", nullable = false)
    private long userid;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic
    @Column(name = "gamelevel", nullable = false)
    private int gamelevel;
    @Basic
    @Column(name = "gamename", nullable = false, length = 45)
    private String gamename;

    @Basic
    @Column(name = "xp",nullable=false)
    private int xp;

    @OneToMany(mappedBy = "userByUserId")
    private Collection<Attempt> attemptsByUserid;
    @OneToMany(mappedBy = "userByPlayerid")
    private Collection<Leaderboard> leaderboardsByUserid;

    public User(int xp) {
        this.xp = xp;
    }

    public User(String userName, String password, String gamename) {
        this.username = userName;
        this.password = password;
        this.gamename = gamename;
    }

    public User() {
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getGamelevel() {
        return gamelevel;
    }

    public void setGamelevel(int gamelevel) {
        this.gamelevel = gamelevel;
    }

    public String getGamename() {
        return gamename;
    }

    public void setGamename(String gamename) {
        this.gamename = gamename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userid == user.userid && gamelevel == user.gamelevel && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(gamename, user.gamename);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, username, password, gamelevel, gamename);
    }

    public Collection<Attempt> getAttemptsByUserid() {
        return attemptsByUserid;
    }

    public void setAttemptsByUserid(Collection<Attempt> attemptsByUserid) {
        this.attemptsByUserid = attemptsByUserid;
    }

    public Collection<Leaderboard> getLeaderboardsByUserid() {
        return leaderboardsByUserid;
    }

    public void setLeaderboardsByUserid(Collection<Leaderboard> leaderboardsByUserid) {
        this.leaderboardsByUserid = leaderboardsByUserid;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", gamelevel=" + gamelevel +
                ", gamename='" + gamename + '\'' +
                '}';
    }

}

