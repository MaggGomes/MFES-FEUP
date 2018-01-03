package FrutaFeia.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class COM_ENCQuote {
  private static int hc = 0;
  private static COM_ENCQuote instance = null;

  public COM_ENCQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static COM_ENCQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new COM_ENCQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof COM_ENCQuote;
  }

  public String toString() {

    return "<COM_ENC>";
  }
}
