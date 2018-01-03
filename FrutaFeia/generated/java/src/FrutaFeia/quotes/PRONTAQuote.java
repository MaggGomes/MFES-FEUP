package FrutaFeia.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PRONTAQuote {
  private static int hc = 0;
  private static PRONTAQuote instance = null;

  public PRONTAQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PRONTAQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PRONTAQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PRONTAQuote;
  }

  public String toString() {

    return "<PRONTA>";
  }
}
