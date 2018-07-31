package br.com.desafio.domain;

import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    this.dataReport.stream().filter(data -> nonNull(data.group())).findFirst()
        .ifPresent(dataGroup -> {
          final IGroupDataReport group = dataGroup.group();
          this.dataReport.stream().filter(data -> nonNull(data.group())).forEach(dataReport1 -> {
            group.add(dataReport1);
          });
          this.addDataReport(group);
        });
    return dataReport.stream().filter(data -> nonNull(data.toString()))
        .collect(Collectors.toList());
  }

  public String getFilename() {
    return filename;
  }
}
