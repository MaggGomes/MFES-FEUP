package FrutaFeia;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Cliente {
  public Cesta encomenda;
  public Object estadoEnc;
  public String nome;
  public Object genero;

  public void cg_init_Cliente_1(final String n, final Object gen) {

    nome = n;
    genero = gen;
    estadoEnc = FrutaFeia.quotes.SEM_ENCQuote.getInstance();
    encomenda = new Cesta();
    return;
  }

  public Cliente(final String n, final Object gen) {

    cg_init_Cliente_1(n, gen);
  }

  public void removeCesta() {

    estadoEnc = FrutaFeia.quotes.CANCELADAQuote.getInstance();
  }

  public void mudaCesta(final Cesta cesta) {

    encomenda = cesta;
    estadoEnc = FrutaFeia.quotes.COM_ENCQuote.getInstance();
  }

  public void encomendaPronta() {

    estadoEnc = FrutaFeia.quotes.PRONTAQuote.getInstance();
  }

  public void levantaCesta() {

    estadoEnc = FrutaFeia.quotes.ENTREGUEQuote.getInstance();
  }

  public void verificaCestaParametros() {

    if (Utils.equals(encomenda.tamanho, FrutaFeia.quotes.PEQUENAQuote.getInstance())) {
      Boolean andResult_39 = false;

      if (Utils.equals(encomenda.produtos.size(), 7L)) {
        if (encomenda.peso.doubleValue() >= 3L) {
          andResult_39 = true;
        }
      }

      if (andResult_39) {
        estadoEnc = FrutaFeia.quotes.PRONTAQuote.getInstance();
      } else {
        estadoEnc = FrutaFeia.quotes.POR_CONCLUIRQuote.getInstance();
      }

    } else {
      if (Utils.equals(encomenda.tamanho, FrutaFeia.quotes.GRANDEQuote.getInstance())) {
        Boolean andResult_40 = false;

        if (Utils.equals(encomenda.produtos.size(), 8L)) {
          if (encomenda.peso.doubleValue() >= 6L) {
            andResult_40 = true;
          }
        }

        if (andResult_40) {
          estadoEnc = FrutaFeia.quotes.PRONTAQuote.getInstance();
        } else {
          estadoEnc = FrutaFeia.quotes.POR_CONCLUIRQuote.getInstance();
        }
      }
    }
  }

  public Cliente() {}

  public String toString() {

    return "Cliente{"
        + "encomenda := "
        + Utils.toString(encomenda)
        + ", estadoEnc := "
        + Utils.toString(estadoEnc)
        + ", nome := "
        + Utils.toString(nome)
        + ", genero := "
        + Utils.toString(genero)
        + "}";
  }
}
