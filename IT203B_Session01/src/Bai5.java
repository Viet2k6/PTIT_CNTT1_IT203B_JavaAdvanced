class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}

class User2 {
    private int age;
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuổi không thể âm!");
        }
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}

public class Bai5 {
    public static void main(String[] args) {
        User2 user = new User2();
        try {
            user.setAge(-2);
        } catch (InvalidAgeException e) {
            System.out.println("Lỗi: " + e.getMessage());
        }
        System.out.println("Kết thúc chương trình");
    }
}