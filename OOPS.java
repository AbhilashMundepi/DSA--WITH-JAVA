public class OOPS {

    public static void main(String args[]) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum((float) 1.5, (float) 2.5));
        System.out.println(calc.sum(1, 2, 3));
    }

}

class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class BankAccount {
    public String username;
    private String password;

    public void setPassword(String pwd) {
        password = pwd;
    }

}

class Pen {

    private String color;
    private int tip;

    String getColor() {
        return this.color;
    }

    int getTip() {
        return this.tip;
    }

    void setColor(String newColor) {
        this.color = newColor;
    }

    void setTip(int newTip) {
        this.tip = newTip;
    }
}

class student {
    String name;
    int age;
    float percentage;// cgpa

    void calcPercentage(int phy, int chem, int math) {
        percentage = (phy + chem + math) / 3;
    }

}
