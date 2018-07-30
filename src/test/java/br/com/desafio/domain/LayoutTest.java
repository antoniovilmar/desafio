package br.com.desafio.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

import br.com.desafio.domain.exception.LayoutNotFoundException;
import br.com.desafio.domain.factory.ReportSellersDataFactory;
import org.junit.Test;

public class LayoutTest {

  @Test
  public void shouldReturnTheFactoryThatCreatesTheDataOfTheSellersReport() {
    final var reportDataFactory = Layout.solveFactory("001asda1312asda");

    assertThat(reportDataFactory.get(), instanceOf(ReportSellersDataFactory.class));
  }

  @Test(expected = LayoutNotFoundException.class)
  public void shouldReturnErrorWhenItDoesNotFindAlayout() {
    Layout.solveFactory("000asda1312asda");
  }

}