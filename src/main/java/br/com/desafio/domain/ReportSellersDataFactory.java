package br.com.desafio.domain;


import java.lang.System.Logger.Level;
import java.util.List;

public class ReportSellersDataFactory implements IReportDataFactory<Sellers> {

  private static System.Logger LOGGER = System.getLogger(ReportSellersDataFactory.class.getName());
  private final int CPF_POSITION = 1;

  @Override
  public Sellers create(String line) {
    final var sellersReport = new Sellers();
    final var sellersLine = List.of(line.split(" "));
    sellersLine.forEach(seller -> {
      final var sellerData = seller.split("ç");
      try{
        sellersReport.addCpf(sellerData[CPF_POSITION]);
      }catch(ArrayIndexOutOfBoundsException e){
        LOGGER.log(Level.WARNING, "Seller was not found"+sellerData);
      }

    });
    return sellersReport;
  }
}
