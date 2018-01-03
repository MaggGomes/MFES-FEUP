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
    tamanho = FrutaFeia.quotes.PEQUENAQuote.getInstance();
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

    for (Iterator iterator_20 = produtos.iterator(); iterator_20.hasNext(); ) {
      Produto elem = (Produto) iterator_20.next();
      if (Utils.equals(nomeProduto, elem.nome)) {
        elem.adicionaPeso(p);
        peso = peso.doubleValue() + p.doubleValue();
        return true;
      }
    }
    return false;
  }

  public Boolean removePesoProduto(final String nomeProduto, final Number p) {

    for (Iterator iterator_21 = produtos.iterator(); iterator_21.hasNext(); ) {
      Produto elem = (Produto) iterator_21.next();
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

    for (Iterator iterator_22 = produtos.iterator(); iterator_22.hasNext(); ) {
      Produto produto = (Produto) iterator_22.next();
      if (Utils.equals(prodNome, produto.nome)) {
        return true;
      }
    }
    return false;
  }

  public Number produtoNaCestaPeso(final String prodNome) {

    for (Iterator iterator_23 = produtos.iterator(); iterator_23.hasNext(); ) {
      Produto produto = (Produto) iterator_23.next();
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
