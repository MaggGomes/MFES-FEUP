package Quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class ENTREGUEQuote {
  private static int hc = 0;
  private static ENTREGUEQuote instance = null;

  public ENTREGUEQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static ENTREGUEQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new ENTREGUEQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof ENTREGUEQuote;
  }

  public String toString() {

    return "<ENTREGUE>";
  }
}
