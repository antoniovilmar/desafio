package br.com.desafio.domain;

import java.util.HashSet;
import java.util.Set;

public class Sellers implements IDataReport {

  private Set<String> sellersCpf;

  public Sellers() {
    this.sellersCpf = new HashSet<>();
  }

  public void addCpf(String cpf) {
    this.sellersCpf.add(cpf);
  }

  public int getNumberOfSellers() {
    return this.sellersCpf.size();
  }

  @Override
  public String toString() {
    return "Amount of clients in the input file: "+this.getNumberOfSellers();
  }
}
