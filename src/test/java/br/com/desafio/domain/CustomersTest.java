package br.com.desafio.domain;

import org.junit.Assert;
import org.junit.Test;

public class CustomersTest {

  private static final String CNPJ_CUSTOMER_ONE = "12701745000167";
  private static final String CNPJ_CUSTOMER_TWO = "44419155000132";
  private static final String CNPJ_CUSTOMER_THREE = "80664988000122";

  @Test
  public void shouldContainThreeCustomers() {

    var customers = new Customers();
    customers.addCnpj(CNPJ_CUSTOMER_ONE);
    customers.addCnpj(CNPJ_CUSTOMER_TWO);
    customers.addCnpj(CNPJ_CUSTOMER_THREE);

    Assert.assertEquals(3, customers.getNumberOfCustomers());
  }

  @Test
  public void shouldNotContainTwoRepeatCustomers() {

    var customers = new Customers();
    customers.addCnpj(CNPJ_CUSTOMER_ONE);
    customers.addCnpj(CNPJ_CUSTOMER_ONE);

    Assert.assertEquals(1, customers.getNumberOfCustomers());
  }

  @Test
  public void shouldNotContainAnyCustomer() {

    var customers = new Customers();

    Assert.assertEquals(0, customers.getNumberOfCustomers());
  }

}