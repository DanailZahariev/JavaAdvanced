package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return this.data.size();
    }

    public void add(Rabbit rabbit) {
        if (this.data.size() < this.capacity) {
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        return data.removeIf(rabbit -> rabbit.getName().equals(name));
    }

    public void removeSpecies(String species) {
        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbitReturn = null;
        for (Rabbit rabbit : data) {
            if (rabbit.getName().equals(name)) {
                rabbitReturn = rabbit;
                rabbit.setAvailable(rabbit.isAvailable());
                break;
            }
        }
        return rabbitReturn;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> soldRabbits = data.stream().filter(r -> r.getSpecies().equals(species)).collect(Collectors.toList());
        data.removeIf(r -> r.getSpecies().equals(species));
        return soldRabbits;
    }

    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Rabbits available at %s:%n", this.name));
        for (Rabbit rabbit : data) {
            if (rabbit.isAvailable()) {
                builder.append(rabbit).append(System.lineSeparator());
            }
        }
        return builder.toString().trim();
    }
}
