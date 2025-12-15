public class Main {
    public static void main(String[] args) {
        System.out.println("Объект A(100):");
        new A(100);
    }
}

class A {
    {
        System.out.println("logic (1) id= " + this.id);
    }

    static {
        System.out.println("static logic");
    }

    private int id = 1;

    public A(int id) {
        this.id = id;
        System.out.println("ctor id= " + id);
    }

    {
        System.out.println("logic (2) id= " + id);
    }
}
/*
Почему такой вывод:
static logic - статический блок выполняется первым, при загрузке класса в память, еще до создания объекта.
logic (1) id= 0 - первый логический блок выполняется после статического блока, но до инициализации поля id. В этот момент id имеет значение по умолчанию 0.
logic (2) id= 1 - второй логический блок выполняется после инициализации поля id = 1.
ctor id= 100 - конструктор выполняется последним и устанавливает id = 100.
*/
