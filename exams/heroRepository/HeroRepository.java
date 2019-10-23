package exams.heroRepository;

import java.util.*;

public class HeroRepository {
    private List<Hero> heroes;
//    private Map<String, Hero> data;

    public HeroRepository() {
        this.heroes = new ArrayList<>();
//        this.data = new HashMap<>();
    }

    public void add(Hero hero) {
        this.heroes.add(hero);
//        this.data.put(hero.getName(), hero);
    }

    public void remove(String name) {
        for (Hero hero : this.heroes) {
            if (hero.getName().equals(name)) {
                this.heroes.remove(hero);
                break;
            }
        }
//        this.data.remove(name);
    }

    public Hero getHeroWithHighestStrength() {
        return this.heroes.stream()
                .max(Comparator.comparing(hero -> hero.getItem().getStrength()))
                .orElse(null);
    }

//    **solution with Map**
//    public Hero getHeroWithHighestStrength() {
//        return this.data.values()
//                .stream()
//                .sorted((f, s) -> s.getItem().getStrength() - f.getItem().getStrength())
//                .collect(Collectors.toList())
//                .get(0);
//    }

    public Hero getHeroWithHighestAgility() {
        return this.heroes.stream()
                .max(Comparator.comparing(hero -> hero.getItem().getAgility()))
                .orElse(null);
    }

    public Hero getHeroWithHighestIntelligence() {
        return this.heroes.stream()
                .max(Comparator.comparing(hero -> hero.getItem().getIntelligence()))
                .orElse(null);
    }

    public int getCount() {
        return this.heroes.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Hero hero : this.heroes) {
            sb.append(hero).append(System.lineSeparator());
        }
        return sb.toString();

//        **solution with Map**
//        return String.join("\n",
//                this.data.values()
//                        .stream()
//                        .map(Hero::toString)
//                        .collect(Collectors.toList()));
    }
}
