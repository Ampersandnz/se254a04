package a04;

import java.lang.reflect.*;

public class ClassCombiner
{
  protected static String nl;
  public static synchronized ClassCombiner create(String lineSeparator)
  {
    nl = lineSeparator;
    ClassCombiner result = new ClassCombiner();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "class ";
  protected final String TEXT_2 = " {";
  protected final String TEXT_3 = NL + "\tpublic ";
  protected final String TEXT_4 = NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    ExtractorArgument e = (ExtractorArgument) argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(e.className);
    stringBuffer.append(TEXT_2);
    Class<?> classA = e.a;
	Class<?> classB = e.b;
	Field[] classAFields = classA.getDeclaredFields();
	Field[] classBFields = classB.getDeclaredFields();
	for (Field c : classAFields) {
		for (Field d : classBFields) {
			if(c.getType().equals(d.getType()) && c.getName().equals(d.getName())) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(c.getType().getSimpleName() + " " + c.getName());
    }}}
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
