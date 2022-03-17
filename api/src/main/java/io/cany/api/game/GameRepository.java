package io.cany.api.game;

import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {
    Game findByName(String name);

    Game findById(long id);
}
