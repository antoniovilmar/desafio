package br.com.desafio.infra;

import br.com.desafio.domain.IDataReport;
import br.com.desafio.domain.Report;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository extends BaseFileRepository implements IFileRepository {

  private static System.Logger LOGGER = System.getLogger(FileRepository.class.getName());

  public List<File> findAllFiles() {
    try {
      return Files.walk(Paths.get(getInputFilePath()))
          .filter(path -> path.toString().endsWith(".dat"))
          .map(Path::toFile)
          .collect(Collectors.toList());
    } catch (IOException e) {
      LOGGER.log(Level.ERROR, "Input folder does not exist: %HOMEPATH%/data/in");
      return List.of();
    }
  }

  public void saveReport(Report report) {
    try {
      var file = new File(getOutputFilePath().concat("/").concat(report.getFilename()));
      var fileWriter = new FileWriter(file);
      var writer = new BufferedWriter(fileWriter);

      for (IDataReport dataReport : report.getDataReport()) {
        writer.write(dataReport.toString());
        writer.newLine();
      }

      writer.flush();
      writer.close();

    } catch (IOException e) {
      LOGGER.log(Level.ERROR, "Output folder does not exist: %HOMEPATH%/data/out");
    }
  }

}
