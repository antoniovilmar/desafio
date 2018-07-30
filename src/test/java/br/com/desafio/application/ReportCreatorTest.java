package br.com.desafio.application;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import br.com.desafio.infra.BaseTest;
import br.com.desafio.infra.FileRepository;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.Test;

public class ReportCreatorTest extends BaseTest {

  private FileRepository fileRepository;

  @Test
  public void name() throws IOException {
    fileRepository = new FileRepository();
    fileRepository = spy(fileRepository);
    when(fileRepository.getInputFilePath()).thenReturn(this.getResourceLocal("mockFiles"));
    final List<File> files = fileRepository.findAll();

    ReportCreator reportCreator = new ReportCreator();
    reportCreator.create(files);


  }
}