package exams.repository;

public class Main {
    public static void main(String[] args) {
        //Initialize the exams.repository
        Repository repository = new Repository();

        //Initialize Person
        Person person = new Person("Pesho", 14, "13-07-2004");

        //Add two entities
        repository.add(person);

        //Initialize second Person object
        Person secondPerson = new Person("Gosho", 42, "21-09-1976");
        repository.add(secondPerson);

        //new exams.repository
        Repository newRepo = new Repository();
        Person thirdPerson = new Person("Misho", 15, "22-2-2000");
        newRepo.add(thirdPerson);


        System.out.println(repository.get(0).toString());
        //Name: Pesho
        //Age: 14
        //Birthday: 13-07-2004

        System.out.println(repository.get(1).toString());
        //Name: Gosho
        //Age: 42
        //Birthday: 21-09-1976


        //Update person with id 1
        repository.update(1, new Person("Success", 20, "01-01-1999"));

        System.out.println(repository.get(1).toString());
        //Name: Success
        //Age: 20
        //Birthday: 01-01-1999

        //Delete entity
        repository.delete(0);

        System.out.println(repository.getCount());
        //1
    }
}
