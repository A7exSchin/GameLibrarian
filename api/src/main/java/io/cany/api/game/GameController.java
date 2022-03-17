package io.cany.api.game;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import java.io.File;
import java.util.List;

@RestController
public class GameController {
    
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private GameService gameService;

    // initialize
    @PostConstruct
    public void init() {
        String[] games = gameService.getGames(new File("E:\\Valentino Stuff\\Games"));
        for (String gameName : games) {
            Game game = new Game(gameName, "", "", "");
            gameRepository.save(game);
        }
    }

    @GetMapping("/games")
    public List<Game> getGames() {
        List<Game> allGames = (List<Game>)gameRepository.findAll();
        return allGames;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Game createGame(@Valid @RequestBody Game requestBody) {
         String name = requestBody.getName();
         String gameLocation = requestBody.getGameLocation();
         String patchLocation = requestBody.getPatchLocation();
         String patchTargetLocation = requestBody.getPatchTargetLocation();

         Game game = new Game(name, gameLocation, patchLocation, patchTargetLocation);
         gameRepository.save(game);
         return game;
    }
}
