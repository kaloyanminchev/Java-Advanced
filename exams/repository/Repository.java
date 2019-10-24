package exams.repository;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<Integer, Person> data;
    private int counter;

    public Repository() {
        this.data = new HashMap<>();
        this.counter = 0;
    }

    public void add(Person person) {
        this.data.put(counter++, person);
    }

    public Person get(int id) {
        return this.data.get(id);
    }

    public boolean update(int id, Person newPerson) {
        if (this.data.containsKey(id)) {
            this.data.put(id, newPerson);
            return true;
        }
        return false;
    }

    public boolean delete(int id) {
        if (this.data.containsKey(id)) {
            this.data.remove(id);
            return true;
        }
        return false;
    }

    public int getCount() {
        return this.data.size();
    }
}