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
    @Column(name = "game_id")
    private long id;

    private String name;

    private String gameLocation;
    private String patchLocation;
    private String patchTargetLocation;
    private double size;
    private String pictureUrl;

    public Game() {}

    public Game(String name, String gameLoc, String patchLoc, String patchTargetLoc, double size, String pictureUrl) {
        this.name = name;
        this.gameLocation = gameLoc;
        this.patchLocation = patchLoc;
        this.patchTargetLocation = patchTargetLoc;
        this.size = size;
        this.pictureUrl = pictureUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(long size){
        this.size = size;
    }

    public void setPictureUrl(String url){
        this.pictureUrl = url;
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

    public double getSize() {
        return size;
    }

    public String getGameLocation() {
        return gameLocation;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public String getPatchLocation() {
        return patchLocation;
    }

    public String getPatchTargetLocation() {
        return patchTargetLocation;
    }

}
