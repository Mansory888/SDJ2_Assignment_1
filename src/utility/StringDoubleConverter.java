package utility;

import javafx.util.StringConverter;

public class StringDoubleConverter extends StringConverter<Number>
{
  private int emptyValue;

  public StringDoubleConverter(int emptyValue)
  {
    this.emptyValue = emptyValue;
  }

  @Override public String toString(Number n)
  {
    if (n == null || n.intValue() == emptyValue)
    {
      return "";
    }
    return n.toString();
  }

  @Override public Number fromString(String s)
  {
    try
    {
      return Double.parseDouble(s);
    }
    catch (Exception e)
    {
      return emptyValue;
    }
  }
}
