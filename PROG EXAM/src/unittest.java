import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductTests {

    @Test
    public void GetTotalProductSales_WithValidData_ReturnsCorrectValue() {
        int[] sales = {63, 37, 45};
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        Product product = new Product(sales, names);

        assertEquals(145, product.GetTotalProductSold());
    }

    @Test
    public void GetAverageSales_WithValidData_ReturnsCorrectValue() {
        int[] sales = {63, 37, 45};
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        Product product = new Product(sales, names);

        assertEquals(48.33, product.GetAverageProductSold(), 0.01);
    }
}