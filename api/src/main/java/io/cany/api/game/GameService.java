package io.cany.api.game;

import java.io.File;
import java.io.FilenameFilter;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    public String[] getGames(File file) {
        return file.list(new FilenameFilter() {
            @Override
            public boolean accept(File current, String name) {
                return new File(current, name).isDirectory();
            }
        });
    }

    public double getGamesize(File game) {

        double length = folderSize(game);
        return length / (1024 * 1024 * 1024);
    }


    public static long folderSize(File directory) {
        long length = 0;
        for (File file : directory.listFiles()) {
            if (file.isFile())
                length += file.length();
            else
                length += folderSize(file);
        }
        return length;
    }
}
