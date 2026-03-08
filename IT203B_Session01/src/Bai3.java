class User {
    private int age;
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuổi không được âm");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class Bai3 {
    public static void main(String[] args) {
        User user = new User();
        try {
            user.setAge(-2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}