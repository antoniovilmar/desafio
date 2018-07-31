package br.com.desafio.domain.sale;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class SalesTest {

  @Test
  public void shouldReturnTheIdOfTheBiggestSale() {
    Sales sale = createSale();

    Assert.assertEquals(Long.valueOf(2), sale.getIdOfTheMostExpensiveSale());

  }

  @Test
  public void shouldReturnTheSellerWithLessSale() {
    Sales sale = createSale();

    Assert.assertEquals("Raul", sale.getWorstSalesmanEver());

  }

  private Sales createSale() {
    var sale = new Sales();
    final SalesPerSeller salesPerSellerOne = spy(new SalesPerSeller(1l, "João"));
    final SalesPerSeller salesPerSellerTwo = spy(new SalesPerSeller(2l, "Alex"));
    final SalesPerSeller salesPerSellerThree = spy(new SalesPerSeller(3l, "Raul"));

    when(salesPerSellerOne.getTotalValue()).thenReturn(BigDecimal.valueOf(100));
    when(salesPerSellerTwo.getTotalValue()).thenReturn(BigDecimal.valueOf(300));
    when(salesPerSellerThree.getTotalValue()).thenReturn(BigDecimal.valueOf(99));

    sale.add(salesPerSellerOne);
    sale.add(salesPerSellerTwo);
    sale.add(salesPerSellerThree);

    return sale;
  }

}