package FrutaFeia.quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class MULHERQuote {
  private static int hc = 0;
  private static MULHERQuote instance = null;

  public MULHERQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static MULHERQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new MULHERQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof MULHERQuote;
  }

  public String toString() {

    return "<MULHER>";
  }
}
