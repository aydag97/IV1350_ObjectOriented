import java.util.HashSet;


/**
 * A class that wraps around a HashSet to provide additional set operations
 * like intersection, union, and difference, along with methods to add and
 * remove elements. This class demonstrates composition by containing a HashSet
 * instance and delegating operations to it.
 */
public class HashSetComposition {

    private HashSet<Integer> set;


    public HashSetComposition(){
        this.set = new HashSet<Integer>();
    }


    public HashSet<Integer> getHashSet(){
        return this.set;
    }


    public int getSize(){
        return this.set.size();
    }


    /**
     * Adds a single element to the set.
     *
     * @param elementToAdd the element to be added
     * @return true if the set did not already contain the specified element
     */
    public boolean addOneElement(Integer elementToAdd){
        return this.set.add(elementToAdd);
    }


    /**
     * Adds all elements from the specified set to this set.
     *
     * @param setToAdd the set containing elements to be added to this set
     * @return true if this set changed as a result of the call
     */
    public boolean addSet(HashSet<Integer> setToAdd){
        return this.set.addAll(setToAdd);
    }


    /**
     * Removes a single element from the set.
     *
     * @param elementToRemove the element to be removed
     * @return true if the set contained the specified element
     */
    public boolean remove(Integer elementToRemove){
        return this.set.remove(elementToRemove);
    }   
    

    /**
     * Checks if the set contains the specified element.
     *
     * @param element the element whose presence in this set is to be tested
     * @return true if this set contains the specified element
     */
    public boolean contains(Integer element){
        return this.set.contains(element);
    }


    /**
     * Checks if the set is empty.
     *
     * @return true if this set contains no elements
     */
    public boolean isEmpty(){
        return this.set.isEmpty();
    }


    /**
     * Returns a set containing the intersection of this set and the specified set.
     *
     * @param otherSet the set to be intersected with this set
     * @return a set containing the intersection of this set and the specified set
     */
    public HashSetComposition intersection(HashSetComposition otherSet){
        HashSetComposition resultSet = new HashSetComposition();
        for(Integer element: this.set){
            if(otherSet.contains(element)){
                resultSet.addOneElement(element);
            }
        }
        if(resultSet.isEmpty()){
            System.out.println("The two sets are disjoint and had nothing in common.");
        }
        return resultSet;
    }


    /**
     * Returns a set containing the union of this set and the specified set.
     *
     * @param otherSet the set to be united with this set
     * @return a set containing the union of this set and the specified set
     */
    public HashSetComposition union(HashSetComposition otherSet){
        HashSetComposition resultSet = new HashSetComposition();

        resultSet.addSet(this.set);
        resultSet.addSet(otherSet.set);

        return resultSet;
    }


    /**
     * Returns a set containing the difference of this set and the specified set.
     *
     * @param otherSet the set to be compared with this set
     * @return a set containing the difference of this set and the specified set
     */
    public HashSetComposition difference(HashSetComposition otherSet){
        HashSetComposition resultSet = new HashSetComposition();

        for(Integer element: this.set){
            if(!(otherSet.contains(element))){
                resultSet.addOneElement(element);
            }
        }
        if(resultSet.isEmpty()){
            System.out.println("The two sets were identical so the difference is an empty set");
        }
        return resultSet;
    }


    /**
     * Prints the elements of the set.
     */
    public void print(){
        System.out.println(this.set);
    }
}
