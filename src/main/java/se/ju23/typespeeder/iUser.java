package se.ju23.typespeeder;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface iUser extends JpaRepository<User,Long> {
    Optional<User> findById(long userid);
    Optional<User> findByUsername(String userName);
    Optional<User> findByGamename(String gameName);


}
