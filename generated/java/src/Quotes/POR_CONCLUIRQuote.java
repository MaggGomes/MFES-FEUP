package Quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class POR_CONCLUIRQuote {
  private static int hc = 0;
  private static POR_CONCLUIRQuote instance = null;

  public POR_CONCLUIRQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static POR_CONCLUIRQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new POR_CONCLUIRQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof POR_CONCLUIRQuote;
  }

  public String toString() {

    return "<POR_CONCLUIR>";
  }
}
