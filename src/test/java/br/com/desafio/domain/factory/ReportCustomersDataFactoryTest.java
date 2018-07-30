package br.com.desafio.domain.factory;

import br.com.desafio.domain.Sellers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReportCustomersDataFactoryTest {

  private ReportCustomersDataFactory reportCustomersDataFactory;

  @Before
  public void setUp() {
    reportCustomersDataFactory = new ReportCustomersDataFactory();
  }

  @Test
  public void shouldCreateOneCustomerForTheReport() {
    var customersLine = "002ç2345675434544345çJose da SilvaçRural";
    final var customersReport = reportCustomersDataFactory.create(customersLine);

    Assert.assertEquals(1, customersReport.getNumberOfCustomers());

  }

  @Test
  public void shouldCreateTwoCustomersForTheReport() {
    var customersLine = "002ç2345675434544345çJose da SilvaçRural 002ç2345675433444345çEduardo PereiraçRural";
    final var customersReport = reportCustomersDataFactory.create(customersLine);

    Assert.assertEquals(2, customersReport.getNumberOfCustomers());

  }

  @Test
  public void shouldCreateOneCustomerForTheReportByIgnoringTheBadlyFormattedSecondCustomer() {
    var customersLine = "002ç2345675434544345çJose da SilvaçRural002ç2345675433444345çEduardo PereiraçRural";
    final var customersReport = reportCustomersDataFactory.create(customersLine);

    Assert.assertEquals(1, customersReport.getNumberOfCustomers());

  }

  @Test
  public void shouldNotCreateCustomerBecauseLayoutIsInvalid() {
    var customersLine = "0022345675434544345Jose da SilvaRural 0022345675433444345Eduardo PereiraRural";
    final var customersReport = reportCustomersDataFactory.create(customersLine);

    Assert.assertEquals(0, customersReport.getNumberOfCustomers());

  }

}