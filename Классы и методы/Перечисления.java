public class Main {
    public static void main(String[] args) {
        System.out.println("Практика 1:");
        Day day = Day.MONDAY;
        System.out.println(day + ": " + day.getRussianName());
        System.out.println(Day.FRIDAY + ": " + Day.FRIDAY.getRussianName());

        System.out.println("\nПрактика 2:");
        Operation op = Operation.ADD;
        System.out.println("5 + 3 = " + op.calculate(5, 3));
        op = Operation.MULTIPLY;
        System.out.println("5 * 3 = " + op.calculate(5, 3));
    }
}

enum Day {
    MONDAY("понедельник"),
    TUESDAY("вторник"),
    WEDNESDAY("среда"),
    THURSDAY("четверг"),
    FRIDAY("пятница"),
    SATURDAY("суббота"),
    SUNDAY("воскресенье");

    private String russianName;

    Day(String name) {
        this.russianName = name;
    }

    public String getRussianName() {
        return russianName;
    }
}

enum Operation {
    ADD {
        public int calculate(int a, int b) {
            return a + b;
        }
    },
    SUBTRACT {
        public int calculate(int a, int b) {
            return a - b;
        }
    },
    MULTIPLY {
        public int calculate(int a, int b) {
            return a * b;
        }
    },
    DIVIDE {
        public int calculate(int a, int b) {
            return a / b;
        }
    };

    public abstract int calculate(int a, int b);
}
