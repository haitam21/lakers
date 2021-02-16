package com.example.aferyad_haitam_exam.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Result {

    private List<Player> players = null;
    private List<Coach> coach = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Coach> getCoach() {
        return coach;
    }

    public void setCoach(List<Coach> coach) {
        this.coach = coach;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
