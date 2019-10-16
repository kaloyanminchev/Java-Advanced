package exams.spaceStationRecruitment;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpaceStation {
    private String name;
    private int capacity;
    private List<Astronaut> astronauts;

    public SpaceStation(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.astronauts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return this.astronauts.size();
    }

    public void add(Astronaut astronaut) {
        if (getCount() < this.capacity) {
            this.astronauts.add(astronaut);
        }
    }

    public boolean remove(String name) {
        for (Astronaut astronaut : this.astronauts) {
            if (astronaut.getName().equals(name)) {
                this.astronauts.remove(astronaut);
                return true;
            }
        }
        return false;
    }

    public Astronaut getOldestAstronaut() {
        ArrayList<Astronaut> oldest = this.astronauts.stream()
                .sorted((f, s) -> s.getAge() - f.getAge())
                .limit(1)
                .collect(Collectors.toCollection(ArrayList::new));

        return oldest.get(0);
    }

    public Astronaut getAstronaut(String name) {
        Astronaut astronaut = null;
        for (Astronaut currentAstronaut : this.astronauts) {
            if (currentAstronaut.getName().equals(name)) {
                astronaut = currentAstronaut;
            }
        }
        return astronaut;
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append("Astronauts working at Space Station ").append(this.name).append(":").append(System.lineSeparator());
        for (Astronaut astronaut : this.astronauts) {
            output.append(astronaut.toString()).append(System.lineSeparator());
        }

        return output.toString();
    }
}
