package br.com.desafio.application;

import br.com.desafio.domain.IDataReport;
import br.com.desafio.domain.Layout;
import br.com.desafio.domain.Report;
import br.com.desafio.infra.IFileRepository;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.nio.file.Files;

public class ReportCreator implements IReportCreator {

  private static System.Logger LOGGER = System.getLogger(ReportCreator.class.getName());
  private IFileRepository fileRepository;

  public ReportCreator(IFileRepository fileRepository) {
    this.fileRepository = fileRepository;
  }

  public void create() {
    final var files = fileRepository.findAllFiles();
    files.stream().forEach(file -> {
      Report report = new Report(file.getName());
      try {
        Files.readAllLines(file.toPath()).forEach(line -> {
          Layout.solveFactory(line).ifPresent(layoutFactory ->
              {
                final IDataReport dataReport = layoutFactory.create(line);
                report.addDataReport(dataReport);
              }
          );
        });
        fileRepository.saveReport(report);
      } catch (IOException e) {
        LOGGER.log(Level.ERROR, "Could not read file: " + file.getName());
      }

    });

  }
}
