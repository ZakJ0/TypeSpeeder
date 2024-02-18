package se.ju23.typespeeder.logic;
/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-8
 */
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface iGameTask extends JpaRepository <Gametask,Long>{

    Optional findById(long task_id);

    List<Gametask> findByLanguage(Object language);

}
