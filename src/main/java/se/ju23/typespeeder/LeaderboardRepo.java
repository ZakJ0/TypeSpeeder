package se.ju23.typespeeder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaderboardRepo extends JpaRepository<Leaderboard, Long> {

    List<Leaderboard> findAllById(long userid);
}
