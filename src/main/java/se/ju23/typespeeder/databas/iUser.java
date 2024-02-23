/*Zakaria Jaouhari, Emanuel Sleyman
2024-02-08
 */
package se.ju23.typespeeder.databas;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface iUser extends JpaRepository<User, Long> {
    Optional<User> findById(long userid);

    Optional<User> findByUsername(String userName);

    Optional<User> findByGamename(String gameName);
}
