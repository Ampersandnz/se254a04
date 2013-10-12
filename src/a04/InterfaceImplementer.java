package a04;

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
  protected final String TEXT_3 = " {" + NL;
  protected final String TEXT_4 = NL + "\tpublic ";
  protected final String TEXT_5 = " ";
  protected final String TEXT_6 = " (";
  protected final String TEXT_7 = " ";
  protected final String TEXT_8 = "p";
  protected final String TEXT_9 = "p";
  protected final String TEXT_10 = ", ";
  protected final String TEXT_11 = ") {";
  protected final String TEXT_12 = " ";
  protected final String TEXT_13 = " ";
  protected final String TEXT_14 = NL;
  protected final String TEXT_15 = " ";
  protected final String TEXT_16 = NL;
  protected final String TEXT_17 = " ";
  protected final String TEXT_18 = NL;
  protected final String TEXT_19 = NL + "\t}" + NL + "\t";
  protected final String TEXT_20 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    Class<?> c = (Class <?>) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(c.getSimpleName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(c.getName());
    stringBuffer.append(TEXT_3);
    for(Method m : c.getMethods()) { 
    String toReturn = m.getReturnType().getSimpleName();
    stringBuffer.append(TEXT_4);
    stringBuffer.append(toReturn);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(m.getName());
    stringBuffer.append(TEXT_6);
    Class<?>[] args = m.getParameterTypes(); 
    for(int i = 0; i < args.length; i++) { 
    stringBuffer.append(args[i].getSimpleName());
    stringBuffer.append(TEXT_7);
    if(i == args.length - 1) { 
    stringBuffer.append(TEXT_8);
    stringBuffer.append(i);
    } else { 
    stringBuffer.append(TEXT_9);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_10);
    }
    }
    stringBuffer.append(TEXT_11);
    if (!toReturn.equals("void")) {
    stringBuffer.append(TEXT_12);
    if (toReturn.equals("int") || toReturn.equals("double")) {
    stringBuffer.append(TEXT_13);
    stringBuffer.append(TEXT_14);
    stringBuffer.append("		return 0;");
    } else if (toReturn.equals("Boolean")) {
    stringBuffer.append(TEXT_15);
    stringBuffer.append(TEXT_16);
    stringBuffer.append("		return false;");
    } else {
    stringBuffer.append(TEXT_17);
    stringBuffer.append(TEXT_18);
    stringBuffer.append("		return null;");
    }}
    stringBuffer.append(TEXT_19);
    }
    stringBuffer.append(TEXT_20);
    return stringBuffer.toString();
  }
}
