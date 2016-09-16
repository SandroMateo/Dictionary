import java.util.List;
import java.util.ArrayList;

public class Word {
  private String mName;
  private static List<Word> instances = new ArrayList<Word>();
  private int mId;
  private List<Definition> mDefinitions;

  public Word(String name) {
    mName = name;
    instances.add(this);
    mId = instances.size();
    mDefinitions = new ArrayList<Definition>();
  }

  public String getName() {
    return mName;
  }

  public int getId() {
    return mId;
  }

  public void addDefinition(Definition definition) {
    mDefinitions.add(definition);
  }

  public List<Definition> getDefinitions() {
    return mDefinitions;
  }

  public static List<Word> all() {
    return instances;
  }

  public static void clear(){
    instances.clear();
  }

  public static Word find(int id) {
    return instances.get(id - 1);
  }
}
