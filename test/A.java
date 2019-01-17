class a {
    void r() {
        System.out.println("class a");
    }
}

class b extends a {
    void r() {
        System.out.println("class b");
    }
}

class z extends b {
    void r() {
        System.out.println("class c");
    }
}

class c {
    void print(a a1) {
        a1.r();
    }

    public static void main(String[] args) {
        a z1 = new z();
        a b1 = new b();
        a a1 = new a();

        // z z1 = new z();
        // b b1 = new b();
        // a a1 = new a();
        c c1 = new c();
        c1.print(z1);
        c1.print(b1);
        c1.print(a1);
    }
}