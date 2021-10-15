package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet> data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return this.data.size();
    }

    public void add(Pet pet) {
        if (this.data.size() < this.capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        return this.data.removeIf(pet -> pet.getName().equals(name));
    }

    public Pet getPet(String name, String owner) {
        return this.data.stream()
                .filter(pet -> pet.getName().equals(name) && pet.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder("The grooming salon has the following clients:" + System.lineSeparator());
        for (Pet pet : data) {
            builder.append(pet.getName())
                    .append(" ").append(pet.getOwner())
                    .append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
