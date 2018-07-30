package br.com.desafio.domain;

import java.util.ArrayList;
import java.util.List;

public class Report {

  private List<IDataReport> dataReport;
  private String filename;

  public Report(String filename) {
    this.filename = filename.replace(".dat", ".done.dat");
    this.dataReport = new ArrayList<>();
  }

  public void addDataReport(IDataReport dataReport) {
    this.dataReport.add(dataReport);
  }

  public List<IDataReport> getDataReport() {
    return dataReport;
  }

  public String getFilename() {
    return filename;
  }
}
