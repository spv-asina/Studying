import java.lang.annotation.*;
import java.lang.reflect.*;

// Практика 1

// Пример использования @Deprecated
class OldClass {
    @Deprecated
    void oldMethod() {
        System.out.println("Старый метод");
    }

    @Deprecated(since = "1.5", forRemoval = true)
    void veryOldMethod() {
        System.out.println("Очень старый метод");
    }
}

// Пример класса для @Override
class Parent {
    void show() {
        System.out.println("Родительский метод");
    }
}

class Child extends Parent {
    @Override
    void show() {
        System.out.println("Дочерний метод");
    }


    // void shoow() {  // Если бы написали @Override, была бы ошибка компиляции
    //     System.out.println("Опечатка");
    // }
}


// 1. Создаем аннотацию
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Info {
    String author();
    String version();
    String date();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Test {
    int priority() default 5;
    String description() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MinValue {
    int value();
}

// 2. Используем аннотации
@Info(author = "Иванов", version = "1.0", date = "2023-10-01")
class MyClass {
    @MinValue(18)
    private int age;

    @Test(priority = 1, description = "Основной тест")
    void testMethod1() {
        System.out.println("Тест 1 выполнен");
    }

    @Test(priority = 3)
    void testMethod2() {
        System.out.println("Тест 2 выполнен");
    }

    // Использование @SuppressWarnings
    @SuppressWarnings("deprecation")
    void useDeprecated() {
        OldClass obj = new OldClass();
        obj.oldMethod();  // Без @SuppressWarnings было бы предупреждение
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Практика #1:");

        // @Override
        System.out.println("\n1. @Override:");
        System.out.println("- Гарантирует, что метод переопределяет метод суперкласса");
        System.out.println("- Помогает найти ошибки при опечатках в имени метода");

        Parent p = new Child();
        p.show();

        // @Deprecated
        System.out.println("\n2. @Deprecated:");
        System.out.println("- Пометка устаревшего кода");
        System.out.println("- Компилятор выдает предупреждение при использовании");

        OldClass old = new OldClass();
        // old.oldMethod(); // Вызовет предупреждение, если не использовать @SuppressWarnings

        // @SuppressWarnings
        System.out.println("\n3. @SuppressWarnings:");
        System.out.println("- Подавляет предупреждения компилятора");
        System.out.println("- Параметры: \"deprecation\", \"unchecked\", \"rawtypes\" и др.");

        MyClass myObj = new MyClass();
        myObj.useDeprecated();

        // Работа с пользовательскими аннотациями
        System.out.println("\nСобственные аннотации:");

        // Получаем информацию об аннотациях класса MyClass
        Class<?> clazz = MyClass.class;

        // Читаем аннотацию @Info
        Info info = clazz.getAnnotation(Info.class);
        if (info != null) {
            System.out.println("Автор: " + info.author());
            System.out.println("Версия: " + info.version());
            System.out.println("Дата: " + info.date());
        }

        // Читаем аннотации методов
        System.out.println("\nТестовые методы:");
        for (Method method : clazz.getDeclaredMethods()) {
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                System.out.println(method.getName() +
                        ": приоритет=" + test.priority() +
                        ", описание='" + test.description() + "'");
            }
        }

        // Читаем аннотации полей
        System.out.println("\nАннотации полей:");
        for (Field field : clazz.getDeclaredFields()) {
            MinValue minValue = field.getAnnotation(MinValue.class);
            if (minValue != null) {
                System.out.println(field.getName() +
                        ": минимальное значение=" + minValue.value());
            }
        }
    }
}
