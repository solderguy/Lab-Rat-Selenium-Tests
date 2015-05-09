package jsoper.com.pair;

/**
 * @author John Soper
 * @version 1  May 4, 2015
 * 
 * Function test of Xtreme Java Quiz page from personal website 
 * with Selenium.  
 * 
 * Issues - runs kind of slow
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizFuncTests {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();
  private int questionNum;
  private int numberCorrectlyAnswered;

  @Before
  public void setUp() throws Exception {
	driver = Utils.getBrowserType();

    baseUrl = "http://www530.pair.com/";
    //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }
  
  @Test
  public void go() throws Exception {
	  frontPageTests();
	  q1TestsPre();
	  q1TestsPost("AnsFieldB", "bpbb");
	  q2TestsPre();
	  q2TestsPost("AnsFieldC", "bbpb");
	  q3TestsPre();
	  q3TestsPost("AnsFieldB", "bpbb");
	  q4TestsPre();
	  q4TestsPost("AnsFieldD", "bbbp");
	  q5TestsPre();
	  q5TestsPost("AnsFieldD", "bbbp");
	  q6TestsPre();
	  q6TestsPost("AnsFieldC", "bbpb");
	  q7TestsPre();
	  q7TestsPost("AnsFieldB", "bpbb");
	  q8TestsPre();
	  q8TestsPost("AnsFieldA", "pbbb");
	  q9TestsPre();
	  q9TestsPost("AnsFieldB", "bpbb");
	  q10TestsPre();
	  q10TestsPost("AnsFieldB", "bpbb");
	  q11TestsPre();
	  q11TestsPost("AnsFieldA", "pbbb");
	  q12TestsPre();
	  q12TestsPost("AnsFieldB", "bpbb");
	  
	  frontPageTests();
	  q1TestsPost("AnsFieldD", "bbbf");  
	  q2TestsPost("AnsFieldA", "fbbb");
	  q3TestsPost("AnsFieldB", "bpbb"); 
	  q4TestsPost("AnsFieldC", "bbfb");
	  q5TestsPost("AnsFieldD", "bbbp");
	  q6TestsPost("AnsFieldA", "fbbb");
	  q7TestsPost("AnsFieldB", "bpbb");
	  q8TestsPost("AnsFieldC", "bbfb");
	  q9TestsPost("AnsFieldD", "bbbf");  
	  q10TestsPost("AnsFieldA", "fbbb");
	  q11TestsPost("AnsFieldB", "bfbb");
	  q12TestsPost("AnsFieldC", "bbfb");
	  
	  frontPageTests();
	  q1TestsPost("AnsFieldA", "fbbb");
	  q2TestsPost("AnsFieldB", "bfbb"); 
	  q3TestsPost("AnsFieldC", "bbfb");
	  q4TestsPost("AnsFieldD", "bbbp");
	  q5TestsPost("AnsFieldA", "fbbb");
	  q6TestsPost("AnsFieldB", "bfbb");
	  q7TestsPost("AnsFieldC", "bbfb");
	  q8TestsPost("AnsFieldD", "bbbf");  
	  q9TestsPost("AnsFieldA", "fbbb");
	  q10TestsPost("AnsFieldB", "bpbb");
	  q11TestsPost("AnsFieldC", "bbfb");
	  q12TestsPost("AnsFieldD", "bbbf");
	  
	  
	  
  }

  public void frontPageTests() throws Exception {
	    driver.get(baseUrl + "/jsoper/xtremeJavaQuiz.html");
	    assertEquals("8-Bit Lab Rat Java Quiz", driver.getTitle());
	    assertEquals("This is a 12 question Java quiz meant to expose tricks and subtleties in the language. Some of the answers may seem like cheap shots, so I used pastel colors and bad jokes to lighten things up.\n\nIt was also an opportunity to sharpen my Jquery and Qunit test skills.\n\nComments and inquiries welcome: Linkedin Profile", driver.findElement(By.cssSelector("p.questionText")).getText());
	    assertEquals("Linkedin Profile", driver.findElement(By.linkText("Linkedin Profile")).getText());
	    assertEquals("The answers will be discussed here, with an off-page link for further reading", driver.findElement(By.id("AnsDisplay")).getText());
	    assertEquals("Code will be displayed here.\n\nMany times a class with default access level will appear below the public class to keep things simple. It's legal to have both in a single file, just uncommon.\n\nA full Maven-enabled Java program to run each question is available on Github at:", driver.findElement(By.id("finalCodeSlot")).getText());
	    assertEquals("Current Score: 0 / 0", driver.findElement(By.cssSelector("div.scoreDiv")).getText());
	    assertEquals("Extreme Java Quiz", driver.findElement(By.cssSelector("div.txtStatusBar > span")).getText());
	    assertTrue(isElementPresent(By.id("progressKeeper")));
	    assertEquals("Start Quiz", driver.findElement(By.cssSelector("button.btnNext")).getText());
	    assertTrue(isElementPresent(By.cssSelector("button.btnNext")));
	    assertEquals("Current Score: 0 / 0", driver.findElement(By.cssSelector("div.scoreDiv")).getText());
	    questionNum = 0;
	    numberCorrectlyAnswered = 0;
	    driver.findElement(By.cssSelector("button.btnNext")).click();
  }
 
  public void q1TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
    		("Question 1: What is the minimum number of constructors you must " 
    				+ "code up for the Foo class shown\\?"));

    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^0, the compiler will insert for both cases$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^1, the compiler will only insert the default constructor$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^2, the compiler won't insert either one$"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^Naming a class Foo, could you be any less original\\?$"));
    
    assertEquals("public class Q1_Constructors {\n"+				
    			"    public static void main(String[] args) {\n"+	
    			"        Foo firstFoo = new Foo();\n"+					
    			"        Foo secondFoo = new Foo(5);\n"+			
    			"    }\n"+											
    			"}\n" +												
    			"\n"+												
    			"class Foo {\n"+									
    			"}", 												
    			driver.findElement(By.id("prelimCodeSlot")).getText());
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
}

public void q1TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    
    assertEquals("Only 1 constructor needs to be written. \n\n" +						
    		"Although the text is deliberately misleading, varargs can be\n" +			
    		"used to support both cases.\n\n" +											
    		"Many books will say the default constructor is one with no\n" +			
    		"parameters defined, but technically it's a constructor that can be\n" +	
    		"called without parameters, optional parameters are allowed.\n\n" +			
    		"In Java this is done with varargs.\n" +									
    		"In C++, parameters can have default values:\n" +							
    		"    void myMethod(int a=10, float b=2.8)  \n\n" +							
    		" Great Stack Overflow post",												
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertTrue(isElementPresent(By.linkText(" Great Stack Overflow post")));
      
      assertEquals("public class Q1_Constructors { \n" +							
    		  "  public static void main(String[] args) { \n" +						
    		  "     Foo firstFoo = new Foo();\n" +									
    		  "     Foo secondFoo = new Foo(5);\n" +								
    		  "  }\n" +																
    		  "}\n\n" + 															
    		  "class Foo {\n" +														
    		  "  Foo(int... ints) {\n" +											
    		  "    int numArgs = ints.length;\n" +									
    		  "    System.out.println(\"\\nNumber of arguments: \"+numArgs);\n" +
    		  "    if (numArgs == 0)\n" +											
    		  "      System.out.println(\"Acting as default constructor\");\n" +	
    		  "  }\n" +																
    		  "}", 																	
    		  driver.findElement(By.id("finalCodeSlot")).getText());
       runNonUniqueTests(grading);
  }
  
  
  public void q2TestsPre() throws Exception {
	    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
	    		("^Question 2: Can a subclass declare wider checked exceptions " +
	    			"than its superclass\\? How about more narrow ones\\?$"));
	    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
	    		("^Only narrower or equal$"));
	    
	    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
	    		("^Only wider or equal$"));

	    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
	    		("^A subclass can do either$"));

	    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
	    		("^When my brother is losing at chess, he literally throws checked exceptions$"));
	    
	    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
	    
	    assertEquals("Take note, FileNotFoundException is a subclass\n"+				
	    			"of IOException\n"+	
	    			"\n"+					
	    			"public class FileNotFoundException\n"+			
	    			"extends IOException\n"+											
	    			"\n" +												
	    			"full Oracle docs",											
	    			driver.findElement(By.id("prelimCodeSlot")).getText());
  }

  public void q2TestsPost(String choice, String grading) throws Exception {
      assertEquals(parseGradeIcons(), "bbbb");   
      driver.findElement(By.id(choice)).click();
	    assertEquals("A subclass can do either.\n\n" +						
	    		"A method in a subclass can only declare equal or narrower,\n" +			
	    		"but a constructor must declare equal or wider.\n\n" +											
	    		"This makes sense because the first line of a constructor must be\n" +			
	    		"either a call to the super-constructor or to an overloaded\n" +	
	    		"constructor which itself calls super()\n\n" +			
	    		"  JavaRanch thread",								
	    		driver.findElement(By.id("AnsDisplay")).getText());
	   
	      assertTrue(isElementPresent(By.linkText("JavaRanch thread")));
	      
	      assertEquals("import java.io.FileNotFoundException;\n" +							
	    		  "import java.io.IOException;\n\n" +						
	    		  "public class Q2_Exceptions {\n" +									
	    		  "    Q2_Exceptions() throws FileNotFoundException {\n" +								
	    		  "        ;\n" +																
	    		  "    }\n" + 															
	    		  "    void Go() throws IOException {\n" +														
	    		  "        ;\n" +											
	    		  "    }\n" +									
	    		  "}\n\n" +
	    		  "class MySubClass extends Q2_Exceptions {\n" +											
	    		  "    MySubClass() throws IOException {\n" +	
	    		  "        super();\n" +																
		     	  "    }\n" +																	
		  		  "    void Go() throws FileNotFoundException {\n" + 																	
		  		  "        ;\n" +																	
  	      	  "    }\n" + 																	
  	      	  "}", 		
   		      driver.findElement(By.id("finalCodeSlot")).getText());
	      
	      runNonUniqueTests(grading);
}
  
public void q3TestsPre() throws Exception {
	    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
	    		("^Question 3: In the displayed code, the variable \"i\" can have decimal places on some JVMs, " +
		    			"especially when multi-threading. True or false\\?$"));
	
	    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
	    		("^True$"));
	    
	    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
	    		("^False$"));

	    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
	    		("^Only when the \"strictfp\" modifier is used in the integer declaration$"));

	    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
	    		("^My dog could write a better quiz than this$"));
	    
	    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
	    
	    assertEquals("public class Q3_Integers {\n"+	
	    			"    public static void main(String[] args) {\n"+					
	    			"        int i = 5;\n"+			
	    			"  \n"+											
					"        i++;\n" +												
					"        i+= 1E8;\n" +												
					"        i--;\n" +												
					"        i-= 1E8;\n" +												
					"\n" +												
					"        System.out.println(\"i: \" + i);\n" +												
					"    }\n" +												
					"}",											
	    			driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q3TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
	    assertEquals("False\n\n" +						
	    		"Just a control question to keep people from simply guessing\n" +			
	    		"unlikely answers.  There may be some more later (or maybe not).\n\n" +											
	    		"Did you like how I used multi-threading as the boogeyman?\n\n" +			
	    		"Strictfp is only for floats.  Here's a link if you're interested:\n\n" +	
	    		"  Stack Overflow post",								
	    		driver.findElement(By.id("AnsDisplay")).getText());
	   
	      assertTrue(isElementPresent(By.linkText("Stack Overflow post")));
	      
   	      assertEquals("public class Q3_Integers {\n"+	
	    			"    public static void main(String[] args) {\n"+					
	    			"        int i = 5;\n"+			
	    			"  \n"+											
					"        i++;\n" +												
					"        i+= 1E8;\n" +												
					"        i--;\n" +												
					"        i-= 1E8;\n" +												
					"\n" +												
					"        System.out.println(\"i: \" + i);\n" +												
					"    }\n" +												
					"}",											
 		      driver.findElement(By.id("finalCodeSlot")).getText());
   	      runNonUniqueTests(grading);
}
  
public void q4TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
    		("^Question 4: A college grad works on a program that requires singletons. " +
	    			"During code review you noticed he used enums instead as shown. " +
    				"What should be done\\?$"));

    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^Rewrite code if it code will be going through serialization cycles$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^Rewrite code if it will be running multi-threaded$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^Rewrite code no matter what, it's a horrible approach$"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^Leave the code alone and buy him a beer$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("enum InventoryManager {\n"+	
	"  INSTANCE;\n"+			
	"  private final String[] lossLeaders =\n"+			
	"    { \"Led Flashlights\", \"Multitools\" };\n"+			
	"\n"+			
	"  public void printLossLeaders() {\n"+			
	"    System.out.println(Arrays.toString(lossLeaders));\n"+			
	"  }\n"+			
	"}\n\n"+			
	"public class Q4_Singletons {\n"+			
	"  public static void main(String[] args) {\n"+			
	"    InventoryManager.INSTANCE.printLossLeaders();\n"+			
	"  }\n"+			
	"}",		
	driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q4TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertTrue(isElementPresent(By.id("pngD")));
    assertEquals("Enum Singletons are fine.\n\n" +						
    		"In \"Effective Java\", Joshua Bloch stated that single-valued \n" +			
    		"Enums make the best singletons because they are more resistant\n" +											
    		"to multithreading, serialization, and reflection.\n" +			
    		"Poorly-designed instantiated singletons have been known to\n" +	
    		"become doubletons.\n\n" +								
    		"Great book btw.\n\n" +								
    		"  Bloch article",								
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertTrue(isElementPresent(By.linkText("Bloch article")));
      
      assertEquals("enum InventoryManager {\n"+	
    			"  INSTANCE;\n"+			
    			"  private final String[] lossLeaders =\n"+			
    			"    { \"Led Flashlights\", \"Multitools\" };\n"+			
    			"\n"+			
    			"  public void printLossLeaders() {\n"+			
    			"    System.out.println(Arrays.toString(lossLeaders));\n"+			
    			"    }\n"+			
    			"}\n\n"+			
    			"public class Q4_Singletons {\n"+			
    			"  public static void main(String[] args) {\n"+			
    			"    InventoryManager.INSTANCE.printLossLeaders();\n"+			
    			"  }\n"+			
    			"}",		
    			driver.findElement(By.id("finalCodeSlot")).getText());
      runNonUniqueTests(grading);
}
  

public void q5TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
    		("^Question 5: The VarStore class has ivars for all four access levels. Which of them can " +
    				"be seen by another different class in the same package\\? " +
    				"Note: no inner classes or getters are used.$"));

    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^Only the public one$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^The public and protected ones$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^The public, protected, and default\\(package\\) ones$"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^All four, even the private$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("public class Q5_VarStore {\n" +
    		" \n"+	
    		"    public int myPublicInt = 100;\n"+			
    		"    protected int myProtectedInt = 200;\n"+			
    		"    int myPackageInt = 300;\n"+			
    		"    private int myPrivateInt = 400;\n"+			
    		"}",		
	driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q5TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("All four are visible (and modifiable).\n\n" +						
    		"Reflection can be used to access private ivars and methods\n" +			
    		"for reading or writing.  This is sometimes handy in\n" +											
    		"unit test situations.\n\n" +			
    		"NOTE: In the interest of fairness, no other questions will\n" +	
    		"involve Reflection, especially since I'm not an expert myself.\n\n" +								
    		"  Stack Overflow post",								
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertTrue(isElementPresent(By.linkText("Stack Overflow post")));
      
      assertEquals("import java.lang.reflect.Field;\n\n" +
           	"public class Q5_Visibility {\n"+			
           	"  public static void main(String[] args) throws Exception {\n"+			
           	"    Q5_VarStore vs = new Q5_VarStore();\n\n"+			
           	"    Class c = Class.forName(\"org.example.john.Q5_VarStore\");\n"+			
           	"    Field field = c.getDeclaredField(\"myPrivateInt\");\n" +
           	"    field.setAccessible(true);\n"+			
           	"    int private_via_refl = field.getInt(vs);\n\n"+			
           	"    System.out.println(\"vs.myPublicInt: \" + vs.myPublicInt);\n"+			
           	"    System.out.println(\"vs.myProtectedInt: \" + vs.myProtectedInt);\n"+			
           	"    System.out.println(\"vs.myPackageInt: \" + vs.myPackageInt);\n"+			
           	"    System.out.println(\"vs.myPrivateInt: \" + private_via_refl);\n"+			
           	"  }\n"+
           	"}\n\n"+			
           	"public class Q5_VarStore {\n"+	
          	" \n"+			
           	"  public int myPublicInt = 100;\n"+			
           	"  protected int myProtectedInt = 200;\n"+			
           	"  int myPackageInt = 300;\n"+			
           	"  private int myPrivateInt = 400;\n"+			
           	"}",		
    		driver.findElement(By.id("finalCodeSlot")).getText());
      runNonUniqueTests(grading);
}
  
public void q6TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
    		("^Question 6: What three boolean value print out\\?$"));

    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^True, True, True$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^False, False, False$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^True, True, False"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^True, False, False$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("public static void main(String[] args) {\n" +
	"    Integer i1 = 50;\n"+	
	"    Integer i2 = 50;\n"+	
	"    System.out.println(i1 == i2);\n\n"+	
	"    Integer i3 = 100;\n"+	
	"    Integer i4 = 100;\n"+	
	"    System.out.println(i3 == i4);\n\n"+	
	"    Integer i5 = 150;\n"+	
	"    Integer i6 = 150;\n"+	
	"    System.out.println(i5 == i6);\n"+	
	"}",	
	driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q6TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("True, True, False\n\n" +						
    		"The Java Spec states that all boxed integer-family primitives be\n" +			
    		"considered the same object if:\n\n" +											
    		"1.  They have the same value and\n" +			
    		"2.  They can fit into a single byte\n\n" +	
    		"That gives a range from -126 to 127 inclusive.\n" +								
    		"The equals() method will work for every value however.\n" +
    		"  \n" +								
    		"And YOU thought it was another control question. \n\n" +								
    		"  Stack Overflow post",								
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertTrue(isElementPresent(By.linkText("Stack Overflow post")));
      
      assertEquals("public static void main(String[] args) {\n" +
    			"    Integer i1 = 50;\n"+	
    			"    Integer i2 = 50;\n"+	
    			"    System.out.println(i1 == i2);\n\n"+	
    			"    Integer i3 = 100;\n"+	
    			"    Integer i4 = 100;\n"+	
    			"    System.out.println(i3 == i4);\n\n"+	
    			"    Integer i5 = 150;\n"+	
    			"    Integer i6 = 150;\n"+	
    			"    System.out.println(i5 == i6);\n"+	
    			"}",	
    			driver.findElement(By.id("finalCodeSlot")).getText());
      runNonUniqueTests(grading);
}

public void q7TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
    		("^Question 7: The marketing guy at your company decided to learn " +
    				"programming. He tells you that JavaScript is just an " +
    				"interpreted version of Java that uses the same JVM. You " +
    				"start arguing and he offers a \\$20 bet that the displayed code " +
    				"will run on a bare bones system with only a JDK installed. " +
    				"Should you accept the bet\\?$"));

    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^Yes, JavaScript is a separate animal. Cha-ching, easy 20 bucks$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^No, those marketing guys are sharper than you think$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^I smell a control question"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^I\'m not sure what I smell$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("/*  A JavaScript file listing */ \n\n" +
    		"var a=1;\n"+	
    		"var b=false;\n"+	
    		"var c=0.0;\n\n"+	
    		"eval(\'a=a+1\');\n"+	
    		"eval(\'b=(a===2)\');    \n"+	
    		"println(\'a: \' + a);\n"+	
    		"println('b: ' + b);\n\n"+	
    		"for (var i=0; i<50000; i++)\n"+	
    		"        c=c+1.1;\n"+	
    		"println(\'c: \' + c); \n\n"+	
    		"// functions are first class citizens\n"+	
    		"var passFunAndApply = function (fn,x,y,z) {\n"+	
    		"  return fn(x,y,z); \n"+	
    		" };\n"+	
    		"var sum = function(x,y,z) {\n"+	
    		" return x+y+z;\n"+	
    		"};\n\n"+	
    		"var result = passFunAndApply(sum,3,4,5); // 12\n"+	
    		"println('result: ' + result); \n\n"+	
    		"date();",	
    		driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q7TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("No, the JavaScript file CAN be run.\n\n" +						
    		"JavaScript is definitely not an interpreted version of Java,\n" +			
    		"but Java 6 includes the Jrunscript script utility for running\n" +											
    		"javascript on the command line.  \n" +			
    		"There's no DOM because there's no web environment,\n" +	
    		"but most other non-graphical features work.\n" +								
    		"Other java goodies like classes and jars are available. \n\n" +
    		"  Codecentric",
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertTrue(isElementPresent(By.linkText("Codecentric")));
      
      assertEquals("Save the code below as file myScript.js and then on\n" +
        		"the command line run: \n"+	
          		"jrunscript -l js -f myScript.js\n\n\n"+	
          		"/*  A JavaScript file listing */\n\n"+	
          	"var a=1;\n" +
      		"var b=false;\n"+	
      		"var c=0.0;\n\n"+	
      		"eval(\'a=a+1\');\n"+	
      		"eval(\'b=(a===2)\');\n"+	
      		"println(\'a: \' + a);\n"+	
      		"println('b: ' + b);\n\n"+	
      		"for (var i=0; i<50000; i++)\n"+	
      		"        c=c+1.1;\n"+	
      		"println(\'c: \' + c);\n\n"+	
      		"// functions are first class citizens\n"+	
      		"var passFunAndApply = function (fn,x,y,z) {\n"+	
      		"  return fn(x,y,z); \n"+	
      		" };\n"+	
      		"var sum = function(x,y,z) {\n"+	
      		"  return x+y+z;\n"+	
      		"};\n\n"+	
      		"var result = passFunAndApply(sum,3,4,5); // 12\n"+	
      		"println('result: ' + result);\n\n"+	
      		"date();",	
      		driver.findElement(By.id("finalCodeSlot")).getText());
      runNonUniqueTests(grading);
}

public void q8TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
    		("^Question 8: True or False: the Java keyword \"new\" can appear in front " +
    				"of an interface name as shown\\?$"));

    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^True$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^False, \"new\" instantiates which interfaces cannot do$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^Only if methods are all static"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^This quiz fell out of the Stupid Tree and hit every branch " + 
    		"on the way down$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("FooInterface fi = new FooInterface()",
    		driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q8TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("True\n\n" +						
    		"It can, but only for an anonymous inner class which\n" +			
    		"implements that interface.  \n" +											
    		"This creates an object without a class name.\n\n" +			
    		"Note the funky semicolon after a brace, this can\n" +	
    		"often mess you up.\n\n" +								
    		"  Stack Overflow post",
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertTrue(isElementPresent(By.linkText("Stack Overflow post")));
      
      assertEquals("public class Q8_NewInterface {\n\n" +
        	"    public static void main(String[] args) {\n"+	
          	"        new Q8_NewInterface().go();\n"+	
          	"    }\n"+	
          	"    void go() {\n" +
      		"        FooInterface fi = new FooInterface() {\n"+	
      		"            @Override\n"+	
      		"            public void callMe() {\n"+	
      		"                    System.out.println(\"calling\");\n"+	
      		"            }\n"+	
      		"        };\n"+	
      		"        fi.callMe();\n"+	
      		"    }\n"+	
      		"}\n\n"+	
      		"interface FooInterface {  \n"+	
      		"    public void callMe();  \n"+	
      		"}  ",	
       		driver.findElement(By.id("finalCodeSlot")).getText());
      runNonUniqueTests(grading);
}

public void q9TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
	("^Question 9: The marketing guy came back and told you his program " +
   	"tracks variable changes with time stamps using a little-known feature of " +
	"Java 6. It\'s called the \"var tracking table\" which makes a table entry " + 
    "every time a variable updates. However, it only works on one local or instance " +
	"variable, not multiples. Is this true or false\\?$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^True, it\'s a crime that more people don\'t know about it$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^False, he had too many martinis at a business lunch$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^It uses annotation metadata and requires a special library"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^Does this quiz ever end\\?$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("import java.util.tracking;\n\n" +
    		"public class Q09_TrackingTable {\n"+	
    		"int i = 1;\n\n"+	
    		"public static void main(String[] args) {\n"+	
    		"new Q09_TrackingTable().go();\n"+
    		"}\n"+
    		"void go() {\n"+
    		"// initilize to variable\n"+
    		"TrackTable tt = new TrackTable(i);\n"+
    		"i++;\n"+
    		"i*=5;\n"+
    		"i--;\n"+
    		"System.out.println(\"Num of records: \" + tt.size());\n"+
    		"System.out.println(\"Time of first change: \" +\n"+
    		" tt.getTimestamp(0));\n"+
    		"}\n\n"+
    		"}",
    		driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q9TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("False, just another control question.\n\n" +						
    		"However for ivars, you could roll your own with a custom\n" +			
    		"setter.  \n\n" +											
    		"Did anyone like my fake code?",
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertEquals("3 Errors\n" +
    	    "  The import java.util.tracking cannot be resolved\n"+	
    	    "  TrackTable cannot be resolved to a type\n"+	
    	    "  TrackTable cannot be resolved to a type\n\n\n\n"+	
     	    "import java.util.tracking;\n\n"+	
          	"public class Q09_TrackingTable {\n"+	
      		"    int i = 1;\n\n"+	
      		"    public static void main(String[] args) {\n"+	
      		"        new Q09_TrackingTable().go();\n"+
      		"    }\n"+
      		"    void go() {\n"+
      		"        // initilize to variable\n"+
      		"        TrackTable tt = new TrackTable(i);\n"+
      		"        i++;\n"+
      		"        i*=5;\n"+
      		"        i--;\n"+
      		"        System.out.println(\"Num of records: \"+tt.size());\n"+
      		"        System.out.println(\"Time of first change: \" +\n"+
      		"             tt.getTimestamp(0));\n"+
      		"    }\n"+
      		"}",
      		driver.findElement(By.id("finalCodeSlot")).getText());
      runNonUniqueTests(grading);
}


public void q10TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
	("^Question 10: Can you program with pointers in Java\\?$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^No, references only thankfully$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^Yes, in certain cases$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^If this is another trick question, I will hunt you down"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^If this is another control question, I will hunt you down$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("No code, so I'll display my favorite part of the C++ FAQ:\n\n" +
    		"[6.15] What does the FAQ mean by \"such and such is evil\"?\n\n"+	
    		"It means \"such and such\" is something you should avoid\n"+	
    		"most of the time, but not all of the time.  Use them when\n"+	
    		"they are the \"least evil\" alternative.\n\n"+
    		"Now let's get real here. I'm not suggesting macros or\n"+
    		"arrays or pointers are right up there with murder or\n"+
    		"kidnapping.  Well, maybe pointers...",
    		driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q10TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("Yes, but only with a FilePointer which can move backwards\n" +						
    		"and forwards through file contents.\n\n" +			
    		"Doesn\'t it give you a warm glow to see the word \"pointer\" in\n" +											
    		"Java code?\n\n"+
    		"Disclosure: the example code was taken directly from\n"+
    		"the site linked below.  It's a great site that deserves\n"+
    		"your attention.\n\n"+
    		"  Tutorialspoint",
    		driver.findElement(By.id("AnsDisplay")).getText());
   
      assertEquals("//Example from: \n" +
      	    "//http://www.tutorialspoint.com/java/\n"+	
    	    " io/randomaccessfile_getfilepointer.htm\n\n"+	
    	    "public class Q10_Pointers {\n"+	
    	    "   public static void main(String[] args) {\n"+	
    	    "      try {\n"+	
    	    "          // create a new RandomAccessFile \n"+	
    	    "          RandomAccessFile raf = \n"+	
    	    "            new RandomAccessFile(\"test.txt\", \"rw\");\n\n"+	
    	    "          // write something in the file\n"+	
    	    "          raf.writeUTF(\"Hello World\");\n\n"+	
    	    "          // set the file pointer at 0 position\n"+	
    	    "          raf.seek(0);  // Thar she blows!!!\n\n"+	
    	    "          // read and print the contents of the file\n"+	
    	    "          System.out.println(\"\" + raf.readUTF());\n\n"+	
    	    "          // return the file pointer\n"+	
    	    "          System.out.println(\"\" + raf.getFilePointer()); \n\n"+	
    	    "          // change the position of the file pointer\n"+	
    	    "          raf.seek(5);\n\n"+	
    	    "          // return the file pointer\n"+	
    	    "          System.out.println(\"\" + raf.getFilePointer());\n"+	
    	    "          \n"+
    	    "          // close to release resources\n"+	
    	    "          raf.close();\n"+	
    	    "       } catch (IOException ex) {\n"+	
    	    "          ex.printStackTrace();\n"+	
    	    "       }\n"+	
    	    "   }\n"+	
    	    "}",	
      		driver.findElement(By.id("finalCodeSlot")).getText());
      runNonUniqueTests(grading);
}


public void q11TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
	("^Question 11: What prints out after garbage collection?\\?$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^Peas$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^are a vegetable.$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^Peas are a vegetable"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^\\{nothing\\}$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("  void go() {\n" +
    		"    Peas peas = new Peas();\n"+	
    		"    peas = null;\n"+	
    		"    // only use in small demo programs\n"+	
    		"    System.gc();\n"+
    		"  }\n"+
    		"}\n\n"+
    		"class Vegetables {\n"+
    		"  protected void finalize() throws Throwable  \n"+
    		"  {  \n"+
    		"    System.out.println(\" are a vegetable.\");\n"+
    		"  }  \n"+
    		"}\n\n"+
    		"class Peas extends Vegetables {\n"+
    		"  protected void finalize() throws Throwable  \n"+
    		"  {  \n"+
    		"    System.out.print(\"Peas\");\n"+
    		"  }  \n"+
    		"}",
    		driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q11TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("Peas\n\n" +						
    		"Each user class's finalizer must have a super call, all the\n" +			
    		"way up to the Object type if needed.\n" +											
    		"The Joshua Bloch article linked below discusses this and their\n"+
    		"other numerous drawbacks at length.\n\n"+
    		"  Bloch article",
     		driver.findElement(By.id("AnsDisplay")).getText());
   
    assertEquals("public class Q11_Finalizers {\n" +
    		"  public static void main(String[] args) {\n"+	
    		"      new Q11_Finalizers().go();\n"+	
    		"  }\n"+	
     		"  void go() {\n"+	
    		"    Peas peas = new Peas();\n"+	
    		"    peas = null;\n"+	
    		"    // only use in small demo programs\n"+	
    		"    System.gc();\n\n"+
       		"    // a little delay might help since above command is\n"+
    		"    // only a suggestion\n"+
    		"    try {\n"+
    		"      Thread.sleep(1000);\n"+
    		"    } catch(InterruptedException e) {\n"+
    		"      throw new RuntimeException(\"Can\'t handle this\", e);\n"+
    		"    }\n"+
    		"  }\n"+
    		"}\n\n"+
    		"class Vegetables {\n"+
    		"  protected void finalize() throws Throwable  \n"+
    		"  {  \n"+
    		"    System.out.println(\" are a vegetable.\");\n"+
    		"  }  \n"+
    		"}\n\n"+
    		"class Peas extends Vegetables {\n"+
    		"  protected void finalize() throws Throwable  \n"+
    		"  {  \n"+
    		"    System.out.print(\"Peas\");\n"+
    	    "    //super.finalize();\n"+

    		"  }  \n"+
    		"}",
    		driver.findElement(By.id("finalCodeSlot")).getText());
    runNonUniqueTests(grading);
}

public void q12TestsPre() throws Exception {
    assertTrue(driver.findElement(By.cssSelector("p.questionText")).getText().matches
    		("^Question 12: The marketing guy came back and said he switched to Spring to hide the " + 
    	    		"plumbing. He\'s coding a robotic dog class that inherits methods from " +
    	    		"an animal class and private int values from a robot class. These are plain classes," +
    	    		" no interface, inner class, static, constant, or reflection tricks. Doable\\?$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldA")).getText().matches
    		("^There\'s no multiple inheritance in Java, especially with privates$"));
    
    assertTrue(driver.findElement(By.id("AnsFieldB")).getText().matches
    		("^Yes there is, don\'t believe the books, believe in marketing$"));

    assertTrue(driver.findElement(By.id("AnsFieldC")).getText().matches
    		("^Yes, Java 7 has a bug that treats this as a warning instead of error$"));

    assertTrue(driver.findElement(By.id("AnsFieldD")).getText().matches
    		("^What gives\\? Did a marketing guy beat you up as a kid or something\\?$"));
    
    assertEquals("", driver.findElement(By.cssSelector("div.discussion")).getText());
    
    assertEquals("public class Q12_Robot {\n" +
    		"  private int chargerVoltage\n"+	
    		"}\n\n"+	
    		"public class Q12_RoboticDog extends Q12_Dog\n"+	
    		"{\n\n"+
    		" robodog.move();\n"+
    		" robodog.bark();\n"+
    		" System.out.println(\"Charger Voltage: \" +\n"+
    		"   robodog.getChargerVoltage());\n\n"+
    		"  @Override\n"+
    		"  void bark() {\n"+
    		" System.out.println(\"machine-sounding woof woof\");\n"+
    		"  }\n\n"+
    		"  public int getChargerVoltage() {\n"+
    		" return chargerVoltage;\n"+
    		"  }\n"+
    		"}",
    		driver.findElement(By.id("prelimCodeSlot")).getText());
}

public void q12TestsPost(String choice, String grading) throws Exception {
    assertEquals(parseGradeIcons(), "bbbb");   
    driver.findElement(By.id(choice)).click();
    assertEquals("Yes, there is a small sliver of multiple inheritance\n" +		
        "possible in Spring\n\n" +
	    "A class can inherit ivars and methods from a superclass\n" +
	    "using the \"extends\" keyword as usual.\n" +
	    "However, when defined as a Spring bean, it can inherit\n" +
	    "constructor and property values from the parent bean.\n\n" +
	    "In this case, all robotic product classes in the program\n" +
	    "could inherit the line voltage value (120 for US,\n" +
	    "220 for Europe) that's set in just one place.  \n" +
	    "There's no way to invoke a parent bean method however. \n\n" +
	    "  Stack Overflow",
        driver.findElement(By.id("AnsDisplay")).getText());
   
    assertEquals("// File beans.xml\n" +
    		"<bean id=\"robotBean\" class=\"org.example.john.Q12_Robot\">\n"+
    		" <property name=\"chargerVoltage\" value=\"120\"/>\n"+
    		"</bean> \n"+
    		"<bean id=\"roboticDogBean\" parent =\"robotBean\"\n"+
    		" class=\"org.example.john.Q12_RoboticDog\">\n"+
    		"  </bean> \n\n"+
    		"public class Q12_Robot {\n"+
    		"  private int chargerVoltage = 0;\n"+	
    		"  }\n\n"+	
    		"public class Q12_RoboticDog extends Q12_Dog {\n"+	
    		"  private int chargerVoltage = 0;\n\n"+	
    		"  public static void main(String[] args) {\n"+
    		"    ApplicationContext ctx = new \n"+
    		" ClassPathXmlApplicationContext(\"Beans.xml\");\n"+
    		"    Q12_RoboticDog robodog =\n"+
    		"    (Q12_RoboticDog) ctx.getBean(\"roboticDogBean\");\n"+
    		"    robodog.move();\n"+
    		"    robodog.bark();\n"+
    		"    System.out.println(\"Charger Voltage: \" +\n"+
    		"        robodog.getChargerVoltage());\n"+
    		"    ((ConfigurableApplicationContext) ctx).close();\n"+
    		"  }\n"+
    		"  @Override\n"+
    		"  void bark() {\n"+
    		"    System.out.println(\"machine-sounding woof woof\");\n"+
    		"  }\n"+
    		"  public int getChargerVoltage() {\n"+
    		"    return chargerVoltage;\n"+
    		"  }",
    		driver.findElement(By.id("finalCodeSlot")).getText());
    runNonUniqueTests(grading);
}

	void runNonUniqueTests(String grading) throws Exception {
		assertEquals(parseGradeIcons(), grading);
		
		String prefixStr;
		if (++questionNum == 12) 
			prefixStr = "Final Score: ";
		else 
			prefixStr = "Current Score: ";
		String scoreStr = prefixStr + numberCorrectlyAnswered + " / "
				+ questionNum;
		assertTrue(driver.findElement(By.id("scoreP")).getText()
				.matches(scoreStr));

		WebElement progressBar = driver.findElement(By.id("progress"));
		assertEquals(progressBar.getSize().getWidth(), 35 * questionNum);
		try {
			assertTrue(isElementPresent(By.id("progress")));
			assertTrue(isElementPresent(By.id("scoreP")));
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
		driver.findElement(By.cssSelector("button.btnNext")).click();
	}

	String parseGradeIcons() throws Exception {
		StringBuilder sb = new StringBuilder(5);
		sb.append(parseSingleGradeIcon("pngA"));
		sb.append(parseSingleGradeIcon("pngB"));
		sb.append(parseSingleGradeIcon("pngC"));
		sb.append(parseSingleGradeIcon("pngD"));
		return sb.toString();
	}

	String parseSingleGradeIcon(String slotID) throws Exception {
		String str;
		WebElement img = driver.findElement(By.id(slotID));
		String[] tokens = img.getAttribute("src").split("[/.]"); // split by "/"
																	// and "."
		String imageName = tokens[tokens.length - 2];

		if (imageName.equals("qBlank")) {
			str = "b";
		} // blank
		else if (imageName.equals("qGreen")) {
			str = "p";
			numberCorrectlyAnswered++;
		} // correct
		else if (imageName.equals("qRed")) {
			str = "f";
		} // incorrect
		else
			throw new Exception("cannot parse image name");
		return str;
	}
    
  @After
  public void tearDown() throws Exception {
	     driver.close();
	     driver.quit();
     String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}
