package tpsit;

public class Person{

    public String name;
    public String surname;
    public String birthday;
    public String[] languages;

    public Person(String name, String surname, String birthday, String... languages){
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.languages = languages;
    }
}
