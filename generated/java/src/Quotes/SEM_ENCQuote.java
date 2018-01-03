package Quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class SEM_ENCQuote {
  private static int hc = 0;
  private static SEM_ENCQuote instance = null;

  public SEM_ENCQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static SEM_ENCQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new SEM_ENCQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof SEM_ENCQuote;
  }

  public String toString() {

    return "<SEM_ENC>";
  }
}
