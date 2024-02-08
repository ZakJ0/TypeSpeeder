package se.ju23.typespeeder;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

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
    @OneToMany(mappedBy = "userByUserId")
    private Collection<Attempt> attemptsByUserid;
    @OneToMany(mappedBy = "userByPlayerid")
    private Collection<Leaderboard> leaderboardsByUserid;

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
}
