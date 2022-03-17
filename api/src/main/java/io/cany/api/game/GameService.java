package io.cany.api.game;

import java.io.File;
import java.io.FilenameFilter;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String[] getGames(File file) {
        String[] directories = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
        return directories;
    }
}
