import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {
  private Definition firstDefinition;
  private Definition secondDefinition;

  @Before
  public void initialize() {
    Definition.clear();
    firstDefinition = new Definition("def");
    secondDefinition = new Definition("inition");
  }

  @Test
  public void Definition_instantiatesCorrectly_true() {
    assertTrue(firstDefinition instanceof Definition);
  }

  @Test
  public void getDescription_returnsDescription_String() {
    assertEquals("def", firstDefinition.getDescription());
  }

  @Test
  public void all_returnsDefinitionList_true() {
    assertTrue(Definition.all().contains(firstDefinition));
    assertTrue(Definition.all().contains(secondDefinition));
  }

  @Test
  public void getId_returnsId_int() {
    assertEquals(1, firstDefinition.getId());
  }

  @Test
  public void find_returnsWantedDefinition_Definition() {
    assertEquals(secondDefinition, Definition.find(secondDefinition.getId()));
  }

  @Test
  public void all_instancesListClearsCorrectly_0(){
    Definition.clear();
    assertEquals(0, Definition.all().size());
  }

}
