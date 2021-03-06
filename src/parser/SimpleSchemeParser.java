/* Generated By:JavaCC: Do not edit this line. SimpleSchemeParser.java */
package parser;

import java.io.*;
import java.util.*;
import ast.*;

        public class SimpleSchemeParser implements SimpleSchemeParserConstants {
                private static boolean runSubstitutionTest = true;

                public static void main( String[] Args )
                {
                        try
                        {
                                String lUnitName = Args[0];

                                if ( !lUnitName.endsWith( ".ssu" ) )
                                        lUnitName += ".ssu";

                                SimpleSchemeParser lParser = new SimpleSchemeParser( new FileInputStream( lUnitName ) );

                                ArrayList<SchemeExpression> lExpressions = lParser.SimpleSchemeUnit();

                                Hashtable<Variable,SchemeExpression> lSymbolTable = new Hashtable<Variable, SchemeExpression>();
                                lSymbolTable.put( new Variable( "succ" ), new ast.builtin.IncrementAbstraction() );
                                lSymbolTable.put( new Variable( "pred" ), new ast.builtin.DecrementAbstraction() );
                                lSymbolTable.put( new Variable( "isZero" ), new ast.builtin.ZeroAbstraction() );
                                lSymbolTable.put( new Variable( "notZero" ), new ast.builtin.NotZeroAbstraction() );

                                SchemeExpression Result = null;

                                for ( SchemeExpression e : lExpressions )
                                {
                                        Result = e.reduce( lSymbolTable );
                                }

                                System.out.println( Result );
                        }
                        catch (ParseException e)
                        {
                        System.out.println("Syntax Error : \u005cn"+ e.toString());
                        }
                        catch (FileNotFoundException e)
                        {
                        System.out.println( e.toString() );
                        }
                }

  final public ArrayList<SchemeExpression> SimpleSchemeUnit() throws ParseException {
        ArrayList<SchemeExpression> Result = new ArrayList<SchemeExpression>();
        SchemeExpression e;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 6:
      case Constant:
      case Identifier:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      e = SchemeExp();
                         Result.add( e );
    }
    jj_consume_token(0);
      {if (true) return Result;}
    throw new Error("Missing return statement in function");
  }

// SchemeExpression
  final public SchemeExpression SchemeExp() throws ParseException {
        Token t;
        SchemeExpression e1, e2, e3;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case Constant:
      t = jj_consume_token(Constant);
                  {if (true) return new Constant( t.image );}
      break;
    case Identifier:
      t = jj_consume_token(Identifier);
                  {if (true) return new Variable( t.image );}
      break;
    default:
      jj_la1[1] = jj_gen;
      if (jj_2_1(2)) {
        jj_consume_token(6);
        jj_consume_token(7);
        t = jj_consume_token(Identifier);
        e1 = SchemeExp();
        jj_consume_token(8);
                  {if (true) return new Declaration( new Variable( t.image ), e1 );}
      } else if (jj_2_2(2)) {
        jj_consume_token(6);
        jj_consume_token(9);
        t = jj_consume_token(String);
        jj_consume_token(8);
                  {if (true) return new Load( t.image.substring( 1, t.image.length() - 1 ) );}
      } else if (jj_2_3(2)) {
        jj_consume_token(6);
        jj_consume_token(10);
        e1 = SchemeExp();
        e2 = SchemeExp();
        e3 = SchemeExp();
        jj_consume_token(8);
                  {if (true) return new IfThenElse( e1, e2, e3 );}
      } else if (jj_2_4(2)) {
        jj_consume_token(6);
        jj_consume_token(11);
        t = jj_consume_token(Identifier);
        jj_consume_token(12);
        e1 = SchemeExp();
        jj_consume_token(8);
                  {if (true) return new Abstraction( new Variable( t.image ), e1 );}
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 6:
          jj_consume_token(6);
          e1 = SchemeExp();
          e2 = SchemeExp();
          jj_consume_token(8);
                  {if (true) return new Application( e1, e2 );}
          break;
        default:
          jj_la1[2] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      }
    }
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_2_4(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_4(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(3, xla); }
  }

  private boolean jj_3_2() {
    if (jj_scan_token(6)) return true;
    if (jj_scan_token(9)) return true;
    return false;
  }

  private boolean jj_3_4() {
    if (jj_scan_token(6)) return true;
    if (jj_scan_token(11)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(6)) return true;
    if (jj_scan_token(7)) return true;
    return false;
  }

  private boolean jj_3_3() {
    if (jj_scan_token(6)) return true;
    if (jj_scan_token(10)) return true;
    return false;
  }

  /** Generated Token Manager. */
  public SimpleSchemeParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[3];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x18040,0x18000,0x40,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[4];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public SimpleSchemeParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public SimpleSchemeParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new SimpleSchemeParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public SimpleSchemeParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new SimpleSchemeParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public SimpleSchemeParser(SimpleSchemeParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(SimpleSchemeParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 3; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[17];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 3; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 17; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 4; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
            case 3: jj_3_4(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

        }
