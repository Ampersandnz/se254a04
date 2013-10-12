package Question2;

import java.lang.reflect.*;

public class InterfaceImplementer
{
  protected static String nl;
  public static synchronized InterfaceImplementer create(String lineSeparator)
  {
    nl = lineSeparator;
    InterfaceImplementer result = new InterfaceImplementer();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class ";
  protected final String TEXT_2 = "Implementation implements ";
  protected final String TEXT_3 = " {";
  protected final String TEXT_4 = " public ";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = " (";
  protected final String TEXT_7 = "p";
  protected final String TEXT_8 = ") {";
  protected final String TEXT_9 = "p";
  protected final String TEXT_10 = ",";
  protected final String TEXT_11 = NL + "return null;}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class c = (Class) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(c.getSimpleName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(c.getName());
    stringBuffer.append(TEXT_3);
    for(Method m : c.getMethods()) { 
    stringBuffer.append(TEXT_4);
    stringBuffer.append(m.getReturnType.getSimpleName());
    stringBuffer.append(TEXT_5);
    stringBuffer.append(m.getName());
    stringBuffer.append(TEXT_6);
    Class<?>[] args = c.getParameterTypes(); 
    for(int i = 0; i < args.length(); i++) { 
    args.length[i].getSimpleName()
    if(i = args.length() - 1) { 
    stringBuffer.append(TEXT_7);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_8);
    } else { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_10);
    }
    stringBuffer.append(TEXT_11);
    }}
    return stringBuffer.toString();
  }
}
