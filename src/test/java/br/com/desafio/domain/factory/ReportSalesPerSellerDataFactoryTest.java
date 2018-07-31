package br.com.desafio.domain.factory;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;

public class ReportSalesPerSellerDataFactoryTest {

  private ReportSalesPerSellerDataFactory reportSalesPerSellerDataFactory;

  @Before
  public void setUp() {
    reportSalesPerSellerDataFactory = new ReportSalesPerSellerDataFactory();
  }

  @Test
  public void shouldCreateOneSaleForTheReport() {
    final var salesLine = "003ç10ç[1-10-100,2-30-2.50,3-40-3.10]çDiego";
    final var salesReport = reportSalesPerSellerDataFactory.create(salesLine);

    assertEquals(10, salesReport.getId());
    assertEquals("Diego", salesReport.getSalesman());
    assertEquals(new BigDecimal("1199.00"), salesReport.getTotalValue());

  }

  @Test
  public void shouldCreateSaleWithOnlyOneItemForTheReport() {
    final var salesLine = "003ç1020ç[3-40-3]çDiego Alves";
    final var salesReport = reportSalesPerSellerDataFactory.create(salesLine);

    assertEquals(1020l, salesReport.getId());
    assertEquals("Diego Alves", salesReport.getSalesman());
    assertEquals(new BigDecimal("120"), salesReport.getTotalValue());

  }

}