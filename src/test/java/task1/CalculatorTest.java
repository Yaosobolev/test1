package task1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;
    @org.junit.jupiter.api.BeforeEach
    @DisplayName("Метод: создание обьекта")
    void setUp() {
        calculator = new Calculator();
    }

    @org.junit.jupiter.api.AfterEach
    @DisplayName("Метод: удаление обьекта")
    void tearDown() {
        calculator = null;
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка вычисления суммы с учетом скидки")
    void testCalculateDiscount() {
        assertEquals(80, calculator.calculateDiscount(100, 20));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Проверка скидки на превышение порога")
    void testImpossibleCalculateDiscount() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculateDiscount(100, 101));
    }
    @ParameterizedTest
    @ValueSource(ints = {10, 50, 99, 100})
    @DisplayName("Параметризованный тест для скидок: 10, 50, 99, 100")
    void testMultiplyWithParameters(int arg) {
        assertEquals(100-arg, calculator.calculateDiscount(100, arg));
    }
}