package Quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class PEQUENAQuote {
  private static int hc = 0;
  private static PEQUENAQuote instance = null;

  public PEQUENAQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static PEQUENAQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new PEQUENAQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof PEQUENAQuote;
  }

  public String toString() {

    return "<PEQUENA>";
  }
}
