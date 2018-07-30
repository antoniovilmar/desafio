package br.com.desafio.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ReportTest {

  @Test
  public void shouldCreateAReportByAddingInTheNomenclatureDone() {
    var report = new Report("filetest.dat");
    assertEquals("filetest.done.dat", report.getFilename());
  }
}