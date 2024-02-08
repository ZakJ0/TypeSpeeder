/*Emanuel sleyman, Zakaria jaouhari
2024-02-08
*/
package se.ju23.typespeeder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface AttemptRepo extends JpaRepository<Attempt, Long> {


    Optional<Attempt> findById(long userid);

}
