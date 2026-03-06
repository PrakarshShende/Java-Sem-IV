//Experiment 4
// Student class
class Student {
    int rollNo;

    void setRollNo(int r) {
        rollNo = r;
    }

    int getRollNo() {
        return rollNo;
    }
}

class Test extends Student {
    int sub1, sub2;

    void setMarks(int m1, int m2) {
        sub1 = m1;
        sub2 = m2;
    }

    void getMarks() {
        System.out.println("Subject 1 Marks: " + sub1);
        System.out.println("Subject 2 Marks: " + sub2);
    }
}

interface Sports {
    int sMarks = 20;
    void set();
}

class Result extends Test implements Sports {

    int total;

    public void set() {
        total = sub1 + sub2 + sMarks;
    }

    void display() {
        System.out.println("Roll No: " + getRollNo());
        getMarks();
        System.out.println("Sports Marks: " + sMarks);
        System.out.println("Total Marks: " + total);
    }
}

public class ResultTest {

    public static void main(String[] args) {

        Result r = new Result();

        r.setRollNo(101);
        r.setMarks(80, 85);
        r.set();
        r.display();
    }
}