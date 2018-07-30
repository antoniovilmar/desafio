package br.com.desafio.domain;

import org.junit.Assert;
import org.junit.Test;

public class SellersTest {

  private final String CPF_SALESMAN_ONE = "58959211087";
  private final String CPF_SALESMAN_TWO = "08775018071";
  private final String CPF_SALESMAN_THREE = "06861839086";

  @Test
  public void shouldContainThreeSellers() {

    var sellers = new Sellers();
    sellers.addCpf(CPF_SALESMAN_ONE);
    sellers.addCpf(CPF_SALESMAN_TWO);
    sellers.addCpf(CPF_SALESMAN_THREE);

    Assert.assertEquals(3, sellers.getNumberOfSellers());
  }

  @Test
  public void shouldNotContainTwoRepeatSellers() {

    var sellers = new Sellers();
    sellers.addCpf(CPF_SALESMAN_ONE);
    sellers.addCpf(CPF_SALESMAN_ONE);

    Assert.assertEquals(1, sellers.getNumberOfSellers());
  }

  @Test
  public void shouldNotContainAnySeller() {

    var sellers = new Sellers();

    Assert.assertEquals(0, sellers.getNumberOfSellers());
  }

}