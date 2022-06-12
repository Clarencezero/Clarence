package prototype;

import lombok.Data;

@Data
public class SearchWords implements Cloneable {
    String keyWorld;
    long updateTimeStamp;
    long lastUpdateTime;
    ReferenceClass referenceClass;

    public SearchWords() {
    }

    public SearchWords(String keyWorld, long lastUpdateTime) {
        this.keyWorld = keyWorld;
        this.lastUpdateTime = lastUpdateTime;
    }

    @Override
    protected SearchWords clone() throws CloneNotSupportedException {
        SearchWords content = null;
        try {
            content = (SearchWords) super.clone();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

    @Override
    public String toString() {
        return "SearchContent{" +
                "keyWorld='" + keyWorld + '\'' +
                ", updateTimeStamp=" + updateTimeStamp +
                '}';
    }
}
