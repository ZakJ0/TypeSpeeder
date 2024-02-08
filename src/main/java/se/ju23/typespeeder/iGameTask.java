package se.ju23.typespeeder;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iGameTask extends JpaRepository <Gametask,Long>{

    Optional findById(long task_id);
}
