/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-08
 */
package se.ju23.typespeeder.databas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface LeaderboardRepo extends JpaRepository<Leaderboard, Long> {


    Optional<Leaderboard> findById(Long id);


}
