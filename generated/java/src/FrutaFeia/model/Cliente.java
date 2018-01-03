package FrutaFeia.model;

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
    estadoEnc = Quotes.SEM_ENCQuote.getInstance();
    encomenda = new Cesta();
    return;
  }

  public Cliente(final String n, final Object gen) {

    cg_init_Cliente_1(n, gen);
  }

  public void removeCesta() {

    estadoEnc = Quotes.CANCELADAQuote.getInstance();
  }

  public void mudaCesta(final Cesta cesta) {

    encomenda = cesta;
    estadoEnc = Quotes.COM_ENCQuote.getInstance();
  }

  public void encomendaPronta() {

    estadoEnc = Quotes.PRONTAQuote.getInstance();
  }

  public void levantaCesta() {

    estadoEnc = Quotes.ENTREGUEQuote.getInstance();
  }

  public void verificaCestaParametros() {

    if (Utils.equals(encomenda.tamanho, Quotes.PEQUENAQuote.getInstance())) {
      Boolean andResult_40 = false;

      if (Utils.equals(encomenda.produtos.size(), 7L)) {
        if (encomenda.peso.doubleValue() >= 3L) {
          andResult_40 = true;
        }
      }

      if (andResult_40) {
        estadoEnc = Quotes.PRONTAQuote.getInstance();
      } else {
        estadoEnc = Quotes.POR_CONCLUIRQuote.getInstance();
      }

    } else {
      if (Utils.equals(encomenda.tamanho, Quotes.GRANDEQuote.getInstance())) {
        Boolean andResult_41 = false;

        if (Utils.equals(encomenda.produtos.size(), 8L)) {
          if (encomenda.peso.doubleValue() >= 6L) {
            andResult_41 = true;
          }
        }

        if (andResult_41) {
          estadoEnc = Quotes.PRONTAQuote.getInstance();
        } else {
          estadoEnc = Quotes.POR_CONCLUIRQuote.getInstance();
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
