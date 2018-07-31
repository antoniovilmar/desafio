package br.com.desafio.domain.sale;

import static java.util.Objects.nonNull;

import br.com.desafio.domain.IGroupDataReport;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Sales implements IGroupDataReport<SalesPerSeller> {

  private Set<SalesPerSeller> sales;

  public Sales() {
    this.sales = new HashSet<>();
  }

  @Override
  public String toString() {
    return "ID of the most expensive sale: " + this.getIdOfTheMostExpensiveSale() + "\n"
        + "Worst salesman ever: " + this.getWorstSalesmanEver();
  }

  public String getWorstSalesmanEver() {
    return this.sales.stream()
        .filter(salesPerSeller -> nonNull(salesPerSeller.getSalesman()))
        .sorted((o1, o2) -> o1.getTotalValue().compareTo(o2.getTotalValue()))
        .map(salesPerSeller -> salesPerSeller.getSalesman()).findFirst().orElse(null);
  }

  public Long getIdOfTheMostExpensiveSale() {
    final Optional<Long> bigger = this.sales.stream()
        .filter(salesPerSeller -> nonNull(salesPerSeller.getId()))
        .sorted((o1, o2) -> o1.getTotalValue().compareTo(o2.getTotalValue()))
        .map(salesPerSeller -> salesPerSeller.getId()).reduce((aLong, aLong2) -> {
          return aLong2;
        });
    return bigger.orElse(null);
  }

  @Override
  public void add(SalesPerSeller salesPerSeller) {
    this.sales.add(salesPerSeller);
  }
}