package exams.repository;

public class Person {
    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDay) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDay;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName()
                + "\nAge: " + this.getAge()
                + "\nBirthday: " + this.getBirthDate();
    }
}
