/*Emanuel sleyman, Zakaria jaouhari
2024-02-08
*/
package se.ju23.typespeeder.logic;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface AttemptRepo extends JpaRepository<Attempt, Long> {


    Optional<Attempt> findById(long userid);

}
