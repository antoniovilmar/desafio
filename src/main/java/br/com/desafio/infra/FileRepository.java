package br.com.desafio.infra;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileRepository extends BaseFileRepository {

  private static System.Logger LOGGER = System.getLogger(FileRepository.class.getName());

  public List<File> findAll() throws IOException {
    return Files.walk(Paths.get(getInputFilePath()))
        .filter(path -> path.toString().endsWith(".dat"))
        .map(Path::toFile)
        .collect(Collectors.toList());
  }

}
