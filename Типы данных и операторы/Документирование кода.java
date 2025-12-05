/**
 *
 * @author  Иванов Иван
 * @version 1.1
 * @since   2023-09-20
 * @see     java.lang.Math
 */
public class Calculator {

    /**
     * Текущее значение, хранящееся в калькуляторе.
     */
    private double currentValue;

    /**
     * Конструктор по умолчанию. Инициализирует калькулятор нулем.
     */
    public Calculator() {
        this.currentValue = 0.0;
    }

    /**
     * Складывает переданное число с текущим значением.
     *
     * @param value число, которое нужно прибавить
     * @return      новое текущее значение после сложения
     */
    public double add(double value) {
        currentValue += value;
        return currentValue;
    }

    /**
     * Делит текущее значение на указанный делитель.
     *
     * @param divisor делитель
     * @return        новое текущее значение после деления
     * @throws ArithmeticException если divisor равен нулю
     * @see #multiply(double)
     */
    public double divide(double divisor) throws ArithmeticException {
        if (divisor == 0) {
            throw new ArithmeticException("Деление на ноль запрещено.");
        }
        currentValue /= divisor;
        return currentValue;
    }

    /**
     * Сбрасывает текущее значение калькулятора к нулю.
     * @deprecated Используйте более конкретный метод {@link #resetTo(double)} с параметром 0.
     */
    @Deprecated
    public void reset() {
        this.currentValue = 0;
    }

    /**
     * Сбрасывает текущее значение к заданному.
     *
     * @param newValue значение, к которому нужно сбросить калькулятор
     */
    public void resetTo(double newValue) {
        this.currentValue = newValue;
    }
}
