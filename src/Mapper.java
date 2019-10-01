import java.util.ArrayList;
import java.util.List;

class Mapper {
    String mainclassName;
    int totalLines;
    Mapper parentClass;
    List<String> lines;
 
    Mapper(String mainclassName) {
        this.mainclassName = mainclassName;
        this.totalLines = 0;
        this.parentClass = null;
        this.lines = new ArrayList<>();
    }
 
    public String getMainClassName() {
        return this.mainclassName;
    }
 
    public void addParentClass(Mapper mainClass) {
        this.parentClass = mainClass;
    }
 
    public Mapper getParentClass() {
        return this.parentClass;
    }
 
    public void addOneLine(String line) {
        lines.add(line);
        this.totalLines += 1;
    }
 
    public int getTotalLines() {
        return this.totalLines - 1 > 0 ? this.totalLines - 1 : 0;
    }
 
    public List<String> getLines() {
        return this.lines;
    }
 
}
