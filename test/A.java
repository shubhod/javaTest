import java.time.LocalDate;
import java.util.*;

class argexcp extends Exception {

}

class a {
    a(int x) throws argexcp {
        System.out.println("class a");
        throw new argexcp();
    }

    void r() {

    }
}

class z {
    void r() {
        System.out.println("class z");
        try {
            a a1 = new a(1);
            // a1.r();
        } catch (argexcp e) {
            System.out.println("exception caught");
        }

    }

}

class f extends z {
    void r() {
        System.out.println("class f");
        r();
    }
}

class c {
    public static void main(String[] args) {
        z f1 = new z();
        f1.r();
        LocalDate date = LocalDate.now();

    }

}
