package br.com.desafio.domain;

import java.util.HashSet;
import java.util.Set;

public class Customers implements IDataReport {

  private Set<String> customersCnpj;

  public Customers() {
    this.customersCnpj = new HashSet<>();
  }

  public int getNumberOfCustomers() {
    return this.customersCnpj.size();
  }

  public void addCnpj(String cnpj) {
    this.customersCnpj.add(cnpj);
  }

  @Override
  public String toString() {
    return "Amount of customers in the input file: "+this.getNumberOfCustomers();
  }
}
