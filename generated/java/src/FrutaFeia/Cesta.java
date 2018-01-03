package FrutaFeia;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Cesta {
  public VDMSet produtos;
  public Number peso;
  public Object tamanho;

  public void cg_init_Cesta_1() {

    peso = 0L;
    produtos = SetUtil.set();
    tamanho = Quotes.PEQUENAQuote.getInstance();
    return;
  }

  public Cesta() {

    cg_init_Cesta_1();
  }

  public void adicionaProduto(final Produto produto) {

    produtos = SetUtil.union(Utils.copy(produtos), SetUtil.set(produto));
    peso = peso.doubleValue() + produto.peso.doubleValue();
  }

  public void removeProduto(final Produto produto) {

    produtos = SetUtil.diff(Utils.copy(produtos), SetUtil.set(produto));
    peso = peso.doubleValue() - produto.peso.doubleValue();
  }

  public Boolean adicionaPesoProduto(final String nomeProduto, final Number p) {

    for (Iterator iterator_11 = produtos.iterator(); iterator_11.hasNext(); ) {
      Produto elem = (Produto) iterator_11.next();
      if (Utils.equals(nomeProduto, elem.nome)) {
        elem.adicionaPeso(p);
        peso = peso.doubleValue() + p.doubleValue();
        return true;
      }
    }
    return false;
  }

  public Boolean removePesoProduto(final String nomeProduto, final Number p) {

    for (Iterator iterator_12 = produtos.iterator(); iterator_12.hasNext(); ) {
      Produto elem = (Produto) iterator_12.next();
      if (Utils.equals(nomeProduto, elem.nome)) {
        elem.removePeso(p);
        return true;
      }
    }
    return false;
  }

  public void alterarTamanho(final Object tam) {

    tamanho = tam;
  }

  public Boolean produtoNaCesta(final String prodNome) {

    for (Iterator iterator_13 = produtos.iterator(); iterator_13.hasNext(); ) {
      Produto produto = (Produto) iterator_13.next();
      if (Utils.equals(prodNome, produto.nome)) {
        return true;
      }
    }
    return false;
  }

  public Number produtoNaCestaPeso(final String prodNome) {

    for (Iterator iterator_14 = produtos.iterator(); iterator_14.hasNext(); ) {
      Produto produto = (Produto) iterator_14.next();
      if (Utils.equals(prodNome, produto.nome)) {
        return produto.peso;
      }
    }
    return 99999L;
  }

  public String toString() {

    return "Cesta{"
        + "produtos := "
        + Utils.toString(produtos)
        + ", peso := "
        + Utils.toString(peso)
        + ", tamanho := "
        + Utils.toString(tamanho)
        + "}";
  }
}
