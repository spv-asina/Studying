void main(){
    System.out.println("Практика #1:");
    byte a = 127;
    System.out.println("byte: "+a);
    a = 0; //нельзя присвоить null
    System.out.println("byte: "+a);

    short b = 127;
    System.out.println("short: "+b);
    b = 0; //нельзя присвоить null
    System.out.println("short: "+b);

    int c = 127;
    System.out.println("int: "+c);
    c = 0; //нельзя присвоить null
    System.out.println("int: "+c);

    long l = 127;
    System.out.println("long: "+l);
    l = 0; //нельзя присвоить null
    System.out.println("long: "+l);

    float f = 127;
    System.out.println("float: "+f);
    f = 0; //нельзя присвоить null
    System.out.println("float: "+f);

    double d = 127;
    System.out.println("double: "+d);
    d = 0; //нельзя присвоить null
    System.out.println("double: "+d);

    char g = 127;
    System.out.println("char: "+g);
    g = '\u0000'; //null
    System.out.println("char: "+g);

    boolean j = true;
    System.out.println("boolean: "+j);
    j = Boolean.parseBoolean(null); //Единственный возможный способ (С остальными типами данных не работает)
    System.out.println("boolean: "+j);

    System.out.println("Практика #2:");
    System.out.println("Моё имя: "+"\u041F\u0430\u0432\u0435\u043B");

    System.out.println("Практика #3:");
    System.out.println(" Вывод: java: cannot find symbol symbol:   variable a location: class Main Область действия и время жизни переменной b ограничена блоком {}, в котором она объявлена. ");

    System.out.println("Практика #4:");
    String firstName = "Иван";
    String lastName = "Петров";
    String fullName = firstName + " " + lastName;
    System.out.println("String + String: " + fullName);

    int age = 25;
    String ageInfo = "Возраст: " + age;
    System.out.println("String + int: " + ageInfo);

    double salary = 1500.50;
    String salaryInfo = "Зарплата: " + salary;
    System.out.println("String + double: " + salaryInfo);

    boolean isActive = true;
    String status = "Статус: " + isActive;
    System.out.println("String + boolean: " + status);

    System.out.println("Практика #5:");
    byte hello = 127;
    System.out.println("byte: "+hello);
    short hell = hello;
    System.out.println("short: "+hell);
    int hel = hell;
    System.out.println("int: "+hel);
    long he = hel;
    System.out.println("long: "+he);
    float h = he;
    System.out.println("float: "+h);
    double hahaha = h;
    System.out.println("double: "+hahaha);
    /*
    Расширение позволяет хранить бОльшее количество данных
    Все целочисленные, после переход в типы с плавающей точкой
     */

    System.out.println("Практика #6:");
    int i = 140;
    byte asd = (byte) i;
    System.out.println("int -> byte: "+asd);
    long dsa = 1000000000;
    byte sad = (byte) dsa;
    System.out.println("long -> byte: "+sad);

    System.out.println("Практика #7:");
    System.out.println("java: incompatible types: possible lossy conversion from int to byte: Отсутствует явное приведение типов");

    System.out.println("Практика #8:");
    var number = 10;           // int
    var price = 19.99;         // double
    var name = "Иван";         // String
    var active = true;         // boolean
    var letter = 'A';          // char
    
}
