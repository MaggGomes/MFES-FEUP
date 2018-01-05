package FrutaFeia.model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Produto {
  public String nome;
  public String origem;
  public Number peso;

  public void cg_init_Produto_1(final String n, final String o, final Number p) {

    nome = n;
    origem = o;
    peso = p;
    return;
  }

  public Produto(final String n, final String o, final Number p) {

    cg_init_Produto_1(n, o, p);
  }

  public void adicionaPeso(final Number p) {

    peso = peso.doubleValue() + p.doubleValue();
  }

  public void removePeso(final Number p) {

    peso = peso.doubleValue() - p.doubleValue();
  }

  public Produto() {}

  public String toString() {

    return "Nome: "
        + Utils.toString(nome)
        + "\nOrigem: "
        + Utils.toString(origem)
        + "\nPeso: "
        + Utils.toString(peso)
        + "\n";
  }
}
