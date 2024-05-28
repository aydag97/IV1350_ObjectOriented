import java.util.HashSet;

/**
 * A subclass of HashSet that provides additional functionality for handling negative numbers
 * and set operations like intersection, union, and difference.
 */
public class HashSetInheritance extends HashSet<Integer> {

    private boolean negativeNumbers;


    /**
     * Default constructor that initializes an empty set with default settings.
     */
    public HashSetInheritance(){
        super();
        this.negativeNumbers = false;
    }


    /**
     * Constructor that initializes an empty set with a specified setting for handling negative numbers.
     * 
     * @param negativeNumbers if false, negative numbers are not allowed in the set.
     */
    public HashSetInheritance(boolean negativeNumbers){
        super();
        this.negativeNumbers = negativeNumbers;
    }


    /**
     * Adds an element to the set. If negative numbers are not allowed, negative elements will not be added.
     * Additionally, if the element is greater than 101, it is adjusted before adding.
     *
     * @param element the element to be added.
     * @return true if the element was added successfully, false otherwise.
     */
    @Override
    public boolean add(Integer element){
        if(!negativeNumbers && element < 0){
            System.out.println("Cannot add a negative number!");
            return false;
        }else if(element <= 101){
            return super.add(element);

        }else{
            return super.add(element-100);
        }  
    }


    /**
     * Checks if the set contains a specified element. If the element is not an integer or
     * if negative numbers are not allowed and the element is negative, it will not be found.
     *
     * @param element the element to check for presence in the set.
     * @return true if the set contains the element, false otherwise.
     */
    @Override
    public boolean contains(Object element){
        if(!(element instanceof Integer) || (!negativeNumbers && (Integer) element < 0)){
            System.out.println("Wrong sign or not an integer");
            return false;
        }else{
            return super.contains(element);
        }
    }


    /**
     * Returns a new set that is the intersection of this set and another set.
     * The intersection contains only elements that are present in both sets.
     *
     * @param otherSet the other set to intersect with.
     * @return a new HashSetInheritance containing the intersection of the two sets.
     */
    public HashSetInheritance intersection(HashSetInheritance otherSet) {
        HashSetInheritance resultSet = new HashSetInheritance();
        for(Integer element: this){
            if(otherSet.contains(element)){
                resultSet.add(element);
            }
        }
        return resultSet;
    }


    /**
     * Returns a new set that is the union of this set and another set.
     * The union contains all unique elements present in either set.
     *
     * @param otherSet the other set to union with.
     * @return a new HashSetInheritance containing the union of the two sets.
     */
    public HashSetInheritance union(HashSetInheritance otherSet) {
        HashSetInheritance resultSet = new HashSetInheritance();
        resultSet.addAll(this);
        resultSet.addAll(otherSet);
        return resultSet;
    }


    /**
     * Returns a new set that is the difference of this set and another set.
     * The difference contains elements that are present in this set but not in the other set.
     *
     * @param otherSet the other set to subtract from this set.
     * @return a new HashSetInheritance containing the difference of the two sets.
     */
    public HashSetInheritance difference(HashSetInheritance otherSet){
        HashSetInheritance resultSet = new HashSetInheritance();
        for(Integer element: this){
            if(!(otherSet.contains(element))){
                resultSet.add(element);
            }
        }
        return resultSet;
    }
}