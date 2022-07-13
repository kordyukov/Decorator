public class Main {
    public static void main(String[] args) {
        Print print1 = new Decorator(new Two(new One()));
        print1.print();
    }

    interface Print {
        void print();
    }

    static class One implements Print {

        @Override
        public void print() {
            System.out.print("Hello");
        }
    }

    static class Decorator implements Print {
        Print print;

        public Decorator(Print print) {
            this.print = print;
        }

        @Override
        public void print() {
            print.print();
        }
    }

    static class Two extends Decorator {

        public Two(Print print) {
            super(print);
        }

        @Override
        public void print() {
            System.out.print("'");
            print.print();
            System.out.print("'");
        }
    }
}
