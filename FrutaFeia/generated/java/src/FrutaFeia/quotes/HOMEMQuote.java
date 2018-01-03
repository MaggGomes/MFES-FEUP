package FrutaFeia.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class HOMEMQuote {
  private static int hc = 0;
  private static HOMEMQuote instance = null;

  public HOMEMQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static HOMEMQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new HOMEMQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof HOMEMQuote;
  }

  public String toString() {

    return "<HOMEM>";
  }
}
