package br.com.desafio.domain;

import static org.junit.Assert.assertEquals;

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

    assertEquals(3, sellers.getNumberOfSellers());
  }

  @Test
  public void shouldNotContainTwoRepeatSellers() {

    var sellers = new Sellers();
    sellers.addCpf(CPF_SALESMAN_ONE);
    sellers.addCpf(CPF_SALESMAN_ONE);

    assertEquals(1, sellers.getNumberOfSellers());
  }

  @Test
  public void shouldNotContainAnySeller() {

    var sellers = new Sellers();

    assertEquals(0, sellers.getNumberOfSellers());
  }

  @Test
  public void shouldDisplayTheReportMessageContainingOneSeller() {
    var sellers = new Sellers();
    sellers.addCpf(CPF_SALESMAN_ONE);

    assertEquals("Amount of clients in the input file: 1", sellers.toString());
  }

}