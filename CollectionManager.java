import java.util.ArrayDeque;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Класс управления коллекцией LabWork.
 * Содержит методы добавления, удаления, фильтрации и получения информации о коллекции.
 */

public class CollectionManager {
    public ZonedDateTime creationDate = ZonedDateTime.now();
    ArrayDeque<LabWork> collection = new ArrayDeque<>();

    private long nextId = 1;

    public long generateId() {
        return nextId++;
    }
    public void updateNextId(long id){
        if (id >= nextId){
            nextId = id + 1;
        }
    }

    public ZonedDateTime getTime(){
        return creationDate;
    }
    public void add(LabWork labWork) {
        collection.add(labWork);
    }
    public String removeById(long id) {
        ArrayDeque<LabWork> filler = new ArrayDeque<>();
        int n = collection.size();
        for (int i = 0; i < n; i++) {
            LabWork l = collection.getFirst();
            if (l.getId() != id) {
                filler.add(l);
            }
            collection.removeFirst();
        }
        collection = filler;
        if (collection.size() == n) {
            return "Элемента с таким айди нет";
        }else{
            return "Элемент с таким айди удален";
        }
    }
    public void clear(){
        collection.clear();
    }
    public int size(){
        return collection.size();
    }
    public ArrayDeque<LabWork> getCollection(){
        return collection;
    }
    public LabWork removeHead(){
        return collection.poll();
    }
    public int countByDifficulty(Difficulty difficulty){
        int count = 0;
        for(LabWork labWork : collection){
            if (labWork.getDifficulty() == difficulty){
                count += 1;
            }
        }
        return count;
    }
    public ArrayDeque<LabWork> filterInName(String arg){
        ArrayDeque<LabWork> filler = new ArrayDeque<>();
        for (LabWork labWork : collection){
            if (labWork.getName().contains(arg)){
                 filler.add(labWork);
            }
        }
        return filler;
    }
    public ArrayList<Difficulty> PFDD() {
        ArrayList<Difficulty> filler = new ArrayList<>();
        for (LabWork labWork : collection) {
            if (labWork.getDifficulty() != null) {
                filler.add(labWork.getDifficulty());
            }
        }
        filler.sort(Collections.reverseOrder());
        return filler;
    }
}
