package FrutaFeia.model;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class FrutaFeia {
  public VDMSet centros;
  public VDMSet agricultores;

  public void cg_init_FrutaFeia_1() {

    centros = SetUtil.set();
    agricultores = SetUtil.set();
  }

  public FrutaFeia() {

    cg_init_FrutaFeia_1();
  }

  public void adicionaCliente(final Cliente cliente, final String centroLocal) {

    for (Iterator iterator_15 = centros.iterator(); iterator_15.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_15.next();
      if (Utils.equals(centro.localizacao, centroLocal)) {
        centro.adicionaCliente(cliente);
      }
    }
  }

  public void removeCliente(final Cliente cliente, final String centroLocal) {

    for (Iterator iterator_16 = centros.iterator(); iterator_16.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_16.next();
      if (Utils.equals(centro.localizacao, centroLocal)) {
        centro.removeCliente(cliente);
      }
    }
  }

  public void adicionaCentro(final CentroDistribuicao centro) {

    centros = SetUtil.union(Utils.copy(centros), SetUtil.set(centro));
  }

  public void removeCentro(final CentroDistribuicao centro) {

    centros = SetUtil.diff(Utils.copy(centros), SetUtil.set(centro));
  }

  public void adicionaAgricultor(final Agricultor agricultor) {

    agricultores = SetUtil.union(Utils.copy(agricultores), SetUtil.set(agricultor));
  }

  public void removeAgricultor(final Agricultor agricultor) {

    agricultores = SetUtil.diff(Utils.copy(agricultores), SetUtil.set(agricultor));
  }

  public VDMSet getTodosClientes() {

    VDMSet clientes = SetUtil.set();
    for (Iterator iterator_17 = centros.iterator(); iterator_17.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_17.next();
      clientes = SetUtil.union(Utils.copy(clientes), centro.clientes);
    }
    return Utils.copy(clientes);
  }

  public VDMSet getTodosProdutos() {

    VDMSet produtos = SetUtil.set();
    for (Iterator iterator_18 = agricultores.iterator(); iterator_18.hasNext(); ) {
      Agricultor agricultor = (Agricultor) iterator_18.next();
      produtos = SetUtil.union(Utils.copy(produtos), MapUtil.rng(agricultor.stock));
    }
    return Utils.copy(produtos);
  }

  public Cesta geraCestaGrande() {

    Cesta cesta = geraCesta(6L, 0.8, 8L, Quotes.GRANDEQuote.getInstance());
    return cesta;
  }

  public Cesta geraCestaPequena() {

    Cesta cesta = geraCesta(3L, 0.4, 7L, Quotes.PEQUENAQuote.getInstance());
    return cesta;
  }

  public Cesta geraCesta(
      final Number pesoMinimo,
      final Number pesoMinimoProduto,
      final Number totalProdutos,
      final Object tipoCesta) {

    Cesta cesta = new Cesta();
    VDMSet produtos = getTodosProdutos();
    Number totalNaCesta = 0L;
    Number pesoAretirar = pesoMinimoProduto;
    Number minimo = pesoMinimo;
    Number runs = 0L;
    cesta.alterarTamanho(tipoCesta);
    Boolean whileCond_1 = true;
    while (whileCond_1) {
      Boolean andResult_48 = false;

      if (minimo.doubleValue() > 0L) {
        if (runs.longValue() < 3L) {
          andResult_48 = true;
        }
      }

      whileCond_1 = andResult_48;

      if (!(whileCond_1)) {
        break;
      }

      {
        for (Iterator iterator_19 = produtos.iterator(); iterator_19.hasNext(); ) {
          Produto produto = (Produto) iterator_19.next();
          if (produto.peso.doubleValue() >= pesoAretirar.doubleValue()) {
            Boolean andResult_49 = false;

            if (Utils.equals(cesta.produtoNaCesta(produto.nome), false)) {
              if (totalNaCesta.longValue() < totalProdutos.doubleValue()) {
                andResult_49 = true;
              }
            }

            if (andResult_49) {
              produto.removePeso(pesoAretirar);
              cesta.adicionaProduto(new Produto(produto.nome, produto.origem, pesoAretirar));
              totalNaCesta = totalNaCesta.longValue() + 1L;
              minimo = minimo.doubleValue() - pesoAretirar.doubleValue();

            } else {
              Boolean andResult_50 = false;

              if (Utils.equals(totalNaCesta, totalProdutos)) {
                if (minimo.doubleValue() <= 0L) {
                  andResult_50 = true;
                }
              }

              if (andResult_50) {
                return cesta;

              } else {
                if (cesta.produtoNaCestaPeso(produto.nome).doubleValue() < 1.5) {
                  produto.removePeso(pesoAretirar);
                  if (cesta.adicionaPesoProduto(produto.nome, pesoAretirar)) {
                    minimo = minimo.doubleValue() - pesoAretirar.doubleValue();
                  } else {
                    produto.adicionaPeso(pesoAretirar);
                  }
                }
              }
            }
          }
        }
        pesoAretirar = Utils.divide(pesoAretirar.doubleValue(), runs.longValue() + 1L);
        runs = runs.longValue() + 1L;
      }
    }

    return cesta;
  }

  public void preencheCesta(final Cesta cesta) {

    VDMSet produtos = getTodosProdutos();
    Number totalNaCesta = cesta.produtos.size();
    Number pesoAretirar = 0.3;
    Number minimo = 0L;
    Number runs = 0L;
    Number totalProdutos = 0L;
    if (Utils.equals(cesta.tamanho, Quotes.PEQUENAQuote.getInstance())) {
      totalProdutos = 7L;
      minimo = 3L - cesta.peso.doubleValue();

    } else {
      if (Utils.equals(cesta.tamanho, Quotes.GRANDEQuote.getInstance())) {
        totalProdutos = 8L;
        minimo = 6L - cesta.peso.doubleValue();
      }
    }

    Boolean whileCond_2 = true;
    while (whileCond_2) {
      Boolean andResult_51 = false;

      if (minimo.doubleValue() > 0L) {
        if (runs.longValue() < 3L) {
          andResult_51 = true;
        }
      }

      whileCond_2 = andResult_51;

      if (!(whileCond_2)) {
        break;
      }

      {
        for (Iterator iterator_20 = produtos.iterator(); iterator_20.hasNext(); ) {
          Produto produto = (Produto) iterator_20.next();
          if (produto.peso.doubleValue() >= pesoAretirar.doubleValue()) {
            Boolean andResult_52 = false;

            if (Utils.equals(cesta.produtoNaCesta(produto.nome), false)) {
              if (totalNaCesta.longValue() < totalProdutos.longValue()) {
                andResult_52 = true;
              }
            }

            if (andResult_52) {
              produto.removePeso(pesoAretirar);
              cesta.adicionaProduto(new Produto(produto.nome, produto.origem, pesoAretirar));
              totalNaCesta = totalNaCesta.longValue() + 1L;
              minimo = minimo.doubleValue() - pesoAretirar.doubleValue();

            } else {
              Boolean andResult_53 = false;

              if (Utils.equals(totalNaCesta, totalProdutos)) {
                if (minimo.doubleValue() <= 0L) {
                  andResult_53 = true;
                }
              }

              if (andResult_53) {
                return;

              } else {
                if (cesta.produtoNaCestaPeso(produto.nome).doubleValue() < 1.5) {
                  produto.removePeso(pesoAretirar);
                  if (cesta.adicionaPesoProduto(produto.nome, pesoAretirar)) {
                    minimo = minimo.doubleValue() - pesoAretirar.doubleValue();
                  } else {
                    produto.adicionaPeso(pesoAretirar);
                  }
                }
              }
            }
          }
        }
        pesoAretirar = Utils.divide(pesoAretirar.doubleValue(), runs.longValue() + 1L);
        runs = runs.longValue() + 1L;
      }
    }
  }

  public void geraCestaTodosClientes() {

    for (Iterator iterator_21 = centros.iterator(); iterator_21.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_21.next();
      for (Iterator iterator_22 = centro.clientes.iterator(); iterator_22.hasNext(); ) {
        Cliente cliente = (Cliente) iterator_22.next();
        IO.println(cliente);
        if (Utils.equals(cliente.estadoEnc, Quotes.COM_ENCQuote.getInstance())) {
          if (Utils.equals(
              cliente.encomenda.tamanho, Quotes.PEQUENAQuote.getInstance())) {
            cliente.mudaCesta(geraCestaPequena());
            cliente.verificaCestaParametros();

          } else {
            if (Utils.equals(
                cliente.encomenda.tamanho, Quotes.GRANDEQuote.getInstance())) {
              cliente.mudaCesta(geraCestaGrande());
              cliente.verificaCestaParametros();

            } else {
              if (Utils.equals(
                  cliente.estadoEnc, Quotes.POR_CONCLUIRQuote.getInstance())) {
                preencheCesta(cliente.encomenda);
                cliente.verificaCestaParametros();
              }
            }
          }
        }
      }
    }
  }

  public String toString() {

    return "FrutaFeia{"
        + "centros := "
        + Utils.toString(centros)
        + ", agricultores := "
        + Utils.toString(agricultores)
        + "}";
  }
}
