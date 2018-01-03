package Quotes;

import org.overture.codegen.runtime.*;

@SuppressWarnings("all")
public class CANCELADAQuote {
  private static int hc = 0;
  private static CANCELADAQuote instance = null;

  public CANCELADAQuote() {

    if (Utils.equals(hc, 0)) {
      hc = super.hashCode();
    }
  }

  public static CANCELADAQuote getInstance() {

    if (Utils.equals(instance, null)) {
      instance = new CANCELADAQuote();
    }

    return instance;
  }

  public int hashCode() {

    return hc;
  }

  public boolean equals(final Object obj) {

    return obj instanceof CANCELADAQuote;
  }

  public String toString() {

    return "<CANCELADA>";
  }
}
