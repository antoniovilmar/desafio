package br.com.desafio.domain.factory;

import br.com.desafio.domain.sale.SalesPerSeller;
import java.math.BigDecimal;
import java.util.List;

public class ReportSalesPerSellerDataFactory implements IReportDataFactory<SalesPerSeller> {

  private static System.Logger LOGGER = System
      .getLogger(ReportSalesPerSellerDataFactory.class.getName());

  private final int ITEMS_POSITION = 2;
  private final int QUANTITY_POSITION = 1;
  private final int PRICE_POSITION = 2;
  private final int SALESMAN_POSITION = 3;
  private final int ID_POSITION = 1;

  @Override
  public SalesPerSeller create(String line) {

    final var sales = List.of(line.split("ç"));
    final var items = createItems(sales);

    final var salesPerSeller = new SalesPerSeller(Long.valueOf(sales.get(ID_POSITION)),
        sales.get(SALESMAN_POSITION));

    items.forEach(item -> {
      final List<String> itemValues = List.of(item.split("-"));
      salesPerSeller
          .addSale(new BigDecimal(itemValues.get(QUANTITY_POSITION)), new BigDecimal(itemValues.get(
              PRICE_POSITION)));
    });

    return salesPerSeller;
  }

  private List<String> createItems(List<String> sales) {
    final String itemsLine = sales.get(ITEMS_POSITION).replace("[", "").replace("]", "");
    final List<String> items = List.of(itemsLine.split(","));

    return items;
  }

}
