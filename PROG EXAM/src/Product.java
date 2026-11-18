public class Product implements IProducts {
    private int[] totalSalesPerProduct;
    private String[] productNames;

    public Product(int[] totalSalesPerProduct, String[] productNames) {
        this.totalSalesPerProduct = totalSalesPerProduct;
        this.productNames = productNames;
    }

    @Override
    public int GetTotalProductSold() {
        int total = 0;
        for (int sales : totalSalesPerProduct) {
            total += sales;
        }
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        if (totalSalesPerProduct.length == 0) return 0;
        return (double) GetTotalProductSold() / totalSalesPerProduct.length;
    }

    @Override
    public int GetTotalProductsSold() {
        return 0;
    }

    @Override
    public double GetAverageProduct() {
        return 0;
    }

    @Override
    public String GetMostPopularProduct() {
        if (totalSalesPerProduct.length == 0) return "";
        int maxIndex = 0;
        for (int i = 1; i < totalSalesPerProduct.length; i++) {
            if (totalSalesPerProduct[i] > totalSalesPerProduct[maxIndex]) {
                maxIndex = i;
            }
        }
        return productNames[maxIndex] + " (" + totalSalesPerProduct[maxIndex] + ")";
    }
}
