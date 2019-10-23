package exams.arena;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FightingArena {
    private String name;
    private List<Gladiator> gladiators;

    public FightingArena(String name) {
        this.name = name;
        this.gladiators = new ArrayList<>();
    }

    public void add(Gladiator gladiator) {
        this.gladiators.add(gladiator);
    }

    public void remove(String name) {
        for (Gladiator gladiator : this.gladiators) {
            if (gladiator.getName().equals(name)) {
                this.gladiators.remove(gladiator);
                break;
            }
        }
    }

    public Gladiator getGladiatorWithHighestStatPower() {
        return this.gladiators.stream()
                .max(Comparator.comparing(Gladiator::getStatPower))
                .orElse(null);
    }

    public Gladiator getGladiatorWithHighestWeaponPower() {
        return this.gladiators.stream()
                .max(Comparator.comparing(Gladiator::getWeaponPower))
                .orElse(null);
    }

    public Gladiator getGladiatorWithHighestTotalPower() {
        return this.gladiators.stream()
                .max(Comparator.comparing(Gladiator::getTotalPower))
                .orElse(null);
    }

    public int getCount() {
        return this.gladiators.size();
    }

    @Override
    public String toString() {
        return String.format("%s - %d gladiators are participating.",
                this.name,
                this.getCount()
        );
    }
}
