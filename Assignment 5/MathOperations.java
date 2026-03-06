class Operations {

    double floorValue(double num) {
        return Math.floor(num);
    }

    double ceilValue(double num) {
        return Math.ceil(num);
    }

    long roundValue(double num) {
        return Math.round(num);
    }
}

public class MathOperations {

    public static void main(String[] args) {

        Operations op = new Operations();
        double num = 5.7;

        System.out.println("Floor = " + op.floorValue(num));
        System.out.println("Ceil = " + op.ceilValue(num));
        System.out.println("Round = " + op.roundValue(num));
    }
}