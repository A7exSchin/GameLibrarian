package io.cany.api.game;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="games")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "assignee_id")
    private long id;

    private String name;

    private String gameLocation;
    private String patchLocation;
    private String patchTargetLocation;

    public Game() {}

    public Game(String name, String gameLoc, String patchLoc, String patchTargetLoc) {
        this.name = name;
        this.gameLocation = gameLoc;
        this.patchLocation = patchLoc;
        this.patchTargetLocation = patchTargetLoc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGameLocation(String gameLoc) {
        this.gameLocation = gameLoc;
    }

    public void setPatchLocation(String patchLoc) {
        this.patchLocation = patchLoc;
    }

    public void setPatchTargetLocation(String patchTargetLoc) {
        this.patchTargetLocation = patchTargetLoc;
    }

    public long getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public String getPatchLocation() {
        return patchLocation;
    }

    public String getPatchTargetLocation() {
        return patchTargetLocation;
    }

}
