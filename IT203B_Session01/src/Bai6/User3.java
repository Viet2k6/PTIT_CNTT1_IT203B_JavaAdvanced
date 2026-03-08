package Bai6;

class User3 {
    private String name;
    private int age;
    public void setName(String name) {
        if (name != null) {
            this.name = name;
        }
    }

    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm");
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}