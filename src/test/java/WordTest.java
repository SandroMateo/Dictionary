import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {
  private Word firstWord;
  private Word secondWord;
  private Definition testDefinition;

  @Before
  public void initialize() {
    Word.clear();
    firstWord = new Word("word");
    secondWord = new Word("words");
    testDefinition = new Definition("definition");
  }

  @Test
  public void Word_instantiatesCorrectly_true() {
    assertTrue(firstWord instanceof Word);
  }

  @Test
  public void getName_returnsName_String() {
    assertEquals("word", firstWord.getName());
  }

  @Test
  public void all_returnsWordList_true() {
    assertTrue(Word.all().contains(firstWord));
    assertTrue(Word.all().contains(secondWord));
  }

  @Test
  public void getId_returnsId_int() {
    assertEquals(1, firstWord.getId());
  }

  @Test
  public void getDefinitions_returnsDefinitionsArrayList_0() {
    assertEquals(0, firstWord.getDefinitions().size());
  }

  @Test
  public void addDefinition_addsDefinitiontoDefinitionList_true() {
    firstWord.addDefinition(testDefinition);
    assertTrue(firstWord.getDefinitions().contains(testDefinition));
  }

  @Test
  public void find_returnsWantedWord_Word() {
    assertEquals(secondWord, Word.find(secondWord.getId()));
  }

  @Test
  public void all_instancesListClearsCorrectly_0(){
    Definition.clear();
    assertEquals(0, Definition.all().size());
  }

}
