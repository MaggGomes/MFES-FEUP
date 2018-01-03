package FrutaFeia.model;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class Agricultor {
  public VDMMap stock = MapUtil.map();
  public String nome;
  public String localizacao;

  public void cg_init_Agricultor_1(final String n, final String l) {

    nome = n;
    localizacao = l;
    stock = MapUtil.map();
    return;
  }

  public Agricultor(final String n, final String l) {

    cg_init_Agricultor_1(n, l);
  }

  public void adicionaProduto(final Produto produto) {

    stock = MapUtil.munion(Utils.copy(stock), MapUtil.map(new Maplet(produto.nome, produto)));
  }

  public void removeProduto(final String nomeProduto) {

    stock = MapUtil.domResBy(SetUtil.set(nomeProduto), Utils.copy(stock));
  }

  public Boolean adicionaPesoProduto(final String nomeProduto, final Number peso) {

    if (SetUtil.inSet(nomeProduto, MapUtil.dom(Utils.copy(stock)))) {
      ((Produto) Utils.get(stock, nomeProduto)).adicionaPeso(peso);
      return true;
    }

    return false;
  }

  public Boolean removePesoProduto(final String nomeProduto, final Number peso) {

    if (SetUtil.inSet(nomeProduto, MapUtil.dom(Utils.copy(stock)))) {
      ((Produto) Utils.get(stock, nomeProduto)).removePeso(peso);
      return true;
    }

    return false;
  }

  public Agricultor() {}

  public String toString() {

    return "Agricultor{"
        + "stock := "
        + Utils.toString(stock)
        + ", nome := "
        + Utils.toString(nome)
        + ", localizacao := "
        + Utils.toString(localizacao)
        + "}";
  }
}
