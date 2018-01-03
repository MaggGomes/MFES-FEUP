package FrutaFeia;

import java.util.*;
import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CentroDistribuicao {
  public VDMSet clientes;
  public String localizacao;

  public void cg_init_CentroDistribuicao_1(final String local) {

    clientes = SetUtil.set();
    localizacao = local;
    return;
  }

  public CentroDistribuicao(final String local) {

    cg_init_CentroDistribuicao_1(local);
  }

  public void adicionaCliente(final Cliente cliente) {

    clientes = SetUtil.union(Utils.copy(clientes), SetUtil.set(cliente));
  }

  public void removeCliente(final Cliente cliente) {

    clientes = SetUtil.diff(Utils.copy(clientes), SetUtil.set(cliente));
  }

  public CentroDistribuicao() {}

  public String toString() {

    return "CentroDistribuicao{"
        + "clientes := "
        + Utils.toString(clientes)
        + ", localizacao := "
        + Utils.toString(localizacao)
        + "}";
  }
}
