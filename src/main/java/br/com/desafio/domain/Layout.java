package br.com.desafio.domain;

import static java.util.Arrays.stream;

import br.com.desafio.domain.exception.LayoutNotFoundException;
import br.com.desafio.domain.factory.IReportDataFactory;
import br.com.desafio.domain.factory.ReportCustomersDataFactory;
import br.com.desafio.domain.factory.ReportSalesPerSellerDataFactory;
import br.com.desafio.domain.factory.ReportSellersDataFactory;
import java.util.Optional;

public enum Layout {

  UM("001") {
    @Override
    protected Optional<IReportDataFactory> getFactory() {
      return Optional.of(new ReportSellersDataFactory());
    }
  },
  DOIS("002") {
    @Override
    protected Optional<IReportDataFactory> getFactory() {
      return Optional.of(new ReportCustomersDataFactory());
    }
  },
  TRES("003") {
    @Override
    protected Optional<IReportDataFactory> getFactory() {
      return Optional.of(new ReportSalesPerSellerDataFactory());
    }
  };

  private final String id;

  Layout(String id) {
    this.id = id;
  }

  public static Optional<IReportDataFactory> solveFactory(String dataLine) {
    final var id = dataLine.substring(0, 3);
    return stream(Layout.values()).filter(l -> l.id.equals(id)).reduce((a, b) -> {
      return a;
    }).orElseThrow(
        LayoutNotFoundException::new).getFactory();
  }

  protected abstract Optional<IReportDataFactory> getFactory();

}
