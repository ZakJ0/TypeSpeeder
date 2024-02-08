package se.ju23.typespeeder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface LeaderboardRepo extends JpaRepository<Leaderboard, Long> {


    Optional<Leaderboard> findById(Long id);
}
