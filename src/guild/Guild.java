package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
            this.roster.add(player);
        }
    }

    public int count() {
        return this.roster.size();
    }

    public boolean removePlayer(String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player != null) {
            roster.remove(player);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player != null) {
            player.setRank("Member");
        }
    }

    private int findPlayerIndex(String name) {
        for (int i = 0; i < roster.size(); i++) {
            if (roster.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void demotePlayer(String name) {
        int index = findPlayerIndex(name);
        if (index != -1) {
            roster.get(index).setRank("Trial");
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayers = roster.stream().filter(p -> p.getClazz().equals(clazz)).collect(Collectors.toList());
        roster.removeAll(removedPlayers);
        return removedPlayers.toArray(Player[]::new);
    }

    public String report() {
        return String.format("Players in the guild: %s:%n%s", name,
                roster.stream().map(Player::toString).collect(Collectors.joining(System.lineSeparator()))).trim();

    }

}