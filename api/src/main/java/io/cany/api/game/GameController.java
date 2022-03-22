package io.cany.api.game;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @Value("${game.library.directory}")
    private String gameLibraryDir;

    // initialize
    @PostConstruct
    public void init() {

        String[] games = gameService.getGames(new File(gameLibraryDir));
        for (String gameName : games) {
            String gameLoc = gameLibraryDir + "\\" + gameName;
            double size = gameService.getGamesize(new File(gameLoc));
            Game game = new Game(gameName, gameLoc, "", "", size, "");
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
         String pictureUrl = requestBody.getPictureUrl();
         double size = requestBody.getSize();

         Game game = new Game(name, gameLocation, patchLocation, patchTargetLocation, size, pictureUrl);
         gameRepository.save(game);
         return game;
    }
}
