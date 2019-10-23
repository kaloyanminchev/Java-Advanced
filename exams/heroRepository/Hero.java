package exams.heroRepository;

public class Hero {
    private String name;
    private int level;
    private Item item;

    public Hero(String name, int level, Item item) {
        this.name = name;
        this.level = level;
        this.item = item;
    }

    public String getName() {
        return this.name;
    }

    public int getLevel() {
        return this.level;
    }

    public Item getItem() {
        return this.item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hero: ").append(this.getName()).append(" - ").append(this.getLevel()).append(System.lineSeparator())
                .append("  *  Strength: ").append(this.getItem().getStrength()).append(System.lineSeparator())
                .append("  *  Agility: ").append(this.getItem().getAgility()).append(System.lineSeparator())
                .append("  *  Intelligence: ").append(this.getItem().getIntelligence());
        return sb.toString();
    }
}
