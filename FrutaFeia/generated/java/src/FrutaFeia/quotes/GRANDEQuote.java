package FrutaFeia.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class GRANDEQuote {
  private static int hc = 0;
  private static GRANDEQuote instance = null;

  public GRANDEQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static GRANDEQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new GRANDEQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof GRANDEQuote;
  }

  public String toString() {

    return "<GRANDE>";
  }
}
