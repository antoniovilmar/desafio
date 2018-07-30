package br.com.desafio.domain.factory;


import br.com.desafio.domain.Customers;
import br.com.desafio.domain.Sellers;
import java.lang.System.Logger.Level;
import java.util.List;

public class ReportCustomersDataFactory implements IReportDataFactory<Customers> {

  private static System.Logger LOGGER = System.getLogger(ReportCustomersDataFactory.class.getName());
  private final int CNPJ_POSITION = 1;

  @Override
  public Customers create(String line) {
    final var customersReport = new Customers();
    final var customersLine = List.of(line.split("( )0"));
    customersLine.forEach(customer -> {
      final var customerData = customer.split("ç");
      try{
        customersReport.addCnpj(customerData[CNPJ_POSITION]);
      }catch(ArrayIndexOutOfBoundsException e){
        LOGGER.log(Level.WARNING, "Customer was not found"+customerData);
      }

    });
    return customersReport;
  }
}
