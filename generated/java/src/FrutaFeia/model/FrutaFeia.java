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

    for (Iterator iterator_27 = centros.iterator(); iterator_27.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_27.next();
      if (Utils.equals(centro.localizacao, centroLocal)) {
        centro.adicionaCliente(cliente);
      }
    }
  }

  public void removeCliente(final String clienteNome, final String centroLocal) {

    for (Iterator iterator_28 = centros.iterator(); iterator_28.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_28.next();
      if (Utils.equals(centro.localizacao, centroLocal)) {
        centro.removeCliente(clienteNome);
      }
    }
  }

  public void adicionaCentro(final CentroDistribuicao centro) {

    centros = SetUtil.union(Utils.copy(centros), SetUtil.set(centro));
  }

  public void removeCentro(final String centroLocal) {

    for (Iterator iterator_29 = centros.iterator(); iterator_29.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_29.next();
      if (Utils.equals(centroLocal, centro.localizacao)) {
        centros = SetUtil.diff(Utils.copy(centros), SetUtil.set(centro));
        return;
      }
    }
  }

  public void adicionaAgricultor(final Agricultor agricultor) {

    agricultores = SetUtil.union(Utils.copy(agricultores), SetUtil.set(agricultor));
  }

  public void removeAgricultor(final String agricultorNome) {

    for (Iterator iterator_30 = agricultores.iterator(); iterator_30.hasNext(); ) {
      Agricultor agricultor = (Agricultor) iterator_30.next();
      if (Utils.equals(agricultor.nome, agricultorNome)) {
        agricultores = SetUtil.diff(Utils.copy(agricultores), SetUtil.set(agricultor));
        return;
      }
    }
  }

  public VDMSet getTodosClientes() {

    VDMSet clientes = SetUtil.set();
    for (Iterator iterator_31 = centros.iterator(); iterator_31.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_31.next();
      clientes = SetUtil.union(Utils.copy(clientes), centro.clientes);
    }
    return Utils.copy(clientes);
  }

  public VDMSet getTodosProdutos() {

    VDMSet produtos = SetUtil.set();
    for (Iterator iterator_32 = agricultores.iterator(); iterator_32.hasNext(); ) {
      Agricultor agricultor = (Agricultor) iterator_32.next();
      produtos = SetUtil.union(Utils.copy(produtos), MapUtil.rng(agricultor.stock));
    }
    return Utils.copy(produtos);
  }

  public Cesta geraCestaGrande() {

    Cesta cesta = geraCesta(6L, 0.75, 8L, Quotes.GRANDEQuote.getInstance());
    return cesta;
  }

  public Cesta geraCestaPequena() {

    Cesta cesta = geraCesta(3L, 0.43, 7L, Quotes.PEQUENAQuote.getInstance());
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
      Boolean andResult_49 = false;

      if (minimo.doubleValue() > 0L) {
        if (runs.longValue() < 3L) {
          andResult_49 = true;
        }
      }

      whileCond_1 = andResult_49;

      if (!(whileCond_1)) {
        break;
      }

      {
        for (Iterator iterator_33 = produtos.iterator(); iterator_33.hasNext(); ) {
          Produto produto = (Produto) iterator_33.next();
          if (produto.peso.doubleValue() >= pesoAretirar.doubleValue()) {
            Boolean andResult_50 = false;

            if (Utils.equals(cesta.produtoNaCesta(produto.nome), false)) {
              if (totalNaCesta.longValue() < totalProdutos.doubleValue()) {
                andResult_50 = true;
              }
            }

            if (andResult_50) {
              produto.removePeso(pesoAretirar);
              cesta.adicionaProduto(new Produto(produto.nome, produto.origem, pesoAretirar));
              totalNaCesta = totalNaCesta.longValue() + 1L;
              minimo = minimo.doubleValue() - pesoAretirar.doubleValue();

            } else {
              Boolean andResult_51 = false;

              if (Utils.equals(totalNaCesta, totalProdutos)) {
                if (minimo.doubleValue() <= 0L) {
                  andResult_51 = true;
                }
              }

              if (andResult_51) {
                return cesta;

              } else {
                if (cesta.produtoNaCestaPeso(produto.nome).doubleValue()
                        + pesoAretirar.doubleValue()
                    < 0.8) {
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
      Boolean andResult_52 = false;

      if (minimo.doubleValue() > 0L) {
        if (runs.longValue() < 3L) {
          andResult_52 = true;
        }
      }

      whileCond_2 = andResult_52;

      if (!(whileCond_2)) {
        break;
      }

      {
        for (Iterator iterator_34 = produtos.iterator(); iterator_34.hasNext(); ) {
          Produto produto = (Produto) iterator_34.next();
          if (produto.peso.doubleValue() >= pesoAretirar.doubleValue()) {
            Boolean andResult_53 = false;

            if (Utils.equals(cesta.produtoNaCesta(produto.nome), false)) {
              if (totalNaCesta.longValue() < totalProdutos.longValue()) {
                andResult_53 = true;
              }
            }

            if (andResult_53) {
              produto.removePeso(pesoAretirar);
              cesta.adicionaProduto(new Produto(produto.nome, produto.origem, pesoAretirar));
              totalNaCesta = totalNaCesta.longValue() + 1L;
              minimo = minimo.doubleValue() - pesoAretirar.doubleValue();

            } else {
              Boolean andResult_54 = false;

              if (Utils.equals(totalNaCesta, totalProdutos)) {
                if (minimo.doubleValue() <= 0L) {
                  andResult_54 = true;
                }
              }

              if (andResult_54) {
                return;

              } else {
                if (cesta.produtoNaCestaPeso(produto.nome).doubleValue()
                        + pesoAretirar.doubleValue()
                    < 0.8) {
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

    for (Iterator iterator_35 = centros.iterator(); iterator_35.hasNext(); ) {
      CentroDistribuicao centro = (CentroDistribuicao) iterator_35.next();
      for (Iterator iterator_36 = centro.clientes.iterator(); iterator_36.hasNext(); ) {
        Cliente cliente = (Cliente) iterator_36.next();
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
            }
          }

        } else {
          if (Utils.equals(cliente.estadoEnc, Quotes.POR_CONCLUIRQuote.getInstance())) {
            preencheCesta(cliente.encomenda);
            cliente.verificaCestaParametros();
          }
        }
      }
    }
  }

  public String toString() {

    return "centros := "
        + Utils.toString(centros)
        + ", agricultores := "
        + Utils.toString(agricultores);
  }
}
