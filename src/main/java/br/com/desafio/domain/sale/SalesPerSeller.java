package br.com.desafio.domain.sale;

import br.com.desafio.domain.IDataReport;
import br.com.desafio.domain.IGroupDataReport;
import java.math.BigDecimal;

public class SalesPerSeller implements IDataReport {

  private long id;
  private String salesman;
  private BigDecimal totalValue;

  @Override
  public IGroupDataReport group() {
    return new Sales();
  }

  public SalesPerSeller(long id, String salesman) {
    this.id = id;
    this.salesman = salesman;
    this.totalValue = BigDecimal.ZERO;
  }


  public void addSale(BigDecimal quantity, BigDecimal price) {
    this.totalValue = this.totalValue.add(quantity.multiply(price));
  }

  public BigDecimal getTotalValue() {
    return this.totalValue;
  }

  public long getId() {
    return id;
  }

  public String getSalesman() {
    return salesman;
  }

  @Override
  public String toString() {
    return null;
  }
}
