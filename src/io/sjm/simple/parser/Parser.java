package io.sjm.simple.parser;

import org.parboiled.BaseParser;
import org.parboiled.Parboiled;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.parserunners.ReportingParseRunner;
import org.parboiled.parserunners.TracingParseRunner;
import org.parboiled.support.ParseTreeUtils;
import org.parboiled.support.ParsingResult;

@BuildParseTree
public class Parser extends BaseParser<Object> {
  Rule Statement() {
    return FirstOf(While(), Assignment());
  }

  Rule While() {
    return Sequence("while (", Expression(), ") { ", Statement(), " }");
  }

  Rule Assignment() {
    return Sequence(OneOrMore(CharRange('a', 'z')), " = ", Expression());
  }

  Rule Expression() {
    return LessThan();
  }

  Rule LessThan() {
    return FirstOf(Sequence(Multiply(), " < ", LessThan()), Multiply());
  }

  Rule Multiply() {
    return FirstOf(Sequence(Terminal(), " * ", Multiply()), Terminal());
  }

  Rule Terminal() {
    return FirstOf(Number(), Variable());
  }

  Rule Number() {
    return OneOrMore(CharRange('0', '9'));
  }

  Rule Variable() {
    return OneOrMore(CharRange('a', 'z'));
  }
}
