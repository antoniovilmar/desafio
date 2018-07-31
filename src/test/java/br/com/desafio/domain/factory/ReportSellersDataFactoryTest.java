package br.com.desafio.domain;

import br.com.desafio.domain.factory.ReportSellersDataFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportSellersDataFactoryTest {

  private ReportSellersDataFactory reportSellersDataFactory;

  @Before
  public void setUp() {
    reportSellersDataFactory = new ReportSellersDataFactory();
  }

  @Test
  public void shouldCreateOneSellerForTheReport() {
    var sellersLine = "001ç3245678865434çRenatoç40000.99";
    final var sellersReport = reportSellersDataFactory.create(sellersLine);

    Assert.assertEquals(1, sellersReport.getNumberOfSellers());

  }

  @Test
  public void shouldCreateTwoSellersForTheReport() {
    var sellersLine = "001ç1234567891234çDiegoç50000 001ç3245678865434çRenatoç40000.99";
    final var sellersReport = reportSellersDataFactory.create(sellersLine);

    Assert.assertEquals(2, sellersReport.getNumberOfSellers());

  }

  @Test
  public void shouldCreateOneSellerForTheReportByIgnoringTheBadlyFormattedSecondSeller() {
    var sellersLine = "001ç1234567891234çDiegoç50000001ç3245678865434çRenatoç40000.99";
    final var sellersReport = reportSellersDataFactory.create(sellersLine);

    Assert.assertEquals(1, sellersReport.getNumberOfSellers());

  }

  @Test
  public void shouldNotCreateSellerBecauseLayoutIsInvalid() {
    var sellersLine = "0011234567891234Diego50000";
    final var sellersReport = reportSellersDataFactory.create(sellersLine);

    Assert.assertEquals(0, sellersReport.getNumberOfSellers());

  }

}