package bjorge.lecture.week37;

public class Person implements Comparable<Person>{
    private String first_name;
    private String last_name;

    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }
    public int compareTo(Person other){
        int last_compare = this.last_name.compareTo(other.last_name);
        if (last_compare == 0) {
            return this.first_name.compareTo(other.first_name);
        }
        else {
            return last_compare;
        }
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "Person.java{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}

