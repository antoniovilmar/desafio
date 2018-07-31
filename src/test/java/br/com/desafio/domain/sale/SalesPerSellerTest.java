package br.com.desafio.domain.sale;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;

public class SalesPerSellerTest {

  @Test
  public void shouldCalculateTheTotalOfTheSaleInformingTwoItems() {
    var sale = new SalesPerSeller(1l, null);
    sale.addSale(BigDecimal.valueOf(3.25), BigDecimal.valueOf(2.50));
    sale.addSale(BigDecimal.TEN, BigDecimal.TEN);

    assertEquals(BigDecimal.valueOf(108.125), sale.getTotalValue());

  }

  @Test
  public void shouldShowTheNameOfTheSellerAndTheIdOfTheSale() {
    var sale = new SalesPerSeller(1015l, "Pedro");
    assertEquals(1015l, sale.getId());
    assertEquals("Pedro", sale.getSalesman());

  }

  @Test
  public void shouldStartTheSaleValueAtZero() {
    var sale = new SalesPerSeller(1l, null);

    assertEquals(BigDecimal.ZERO, sale.getTotalValue());

  }

}