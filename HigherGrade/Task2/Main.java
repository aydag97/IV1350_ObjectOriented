
public class Main {

    public static void main(String[] args){
        HashSetComposition setComp1 = new HashSetComposition();
        for(int i = 1; i < 7; i++){
            setComp1.addOneElement(i);
        }

        HashSetComposition setComp2 = new HashSetComposition();
        for(int i = 4; i < 10; i++){
            setComp2.addOneElement(i);
        }

        HashSetComposition resultIntersection = setComp1.intersection(setComp2);
        HashSetComposition resultUnion = setComp1.union(setComp2);
        HashSetComposition resultDifference = setComp1.difference(setComp2);

        System.out.println("\nSet1: ");
        setComp1.print();
        System.out.println("Set2: ");
        setComp2.print();
        System.out.println("\n---------Composition---------");
        System.out.print("set 1 intersect set2: ");
        resultIntersection.print();
        System.out.print("set 1 union set2: ");
        resultUnion.print();
        System.out.print("set 1 intersect set2: ");
        resultDifference.print();

        HashSetInheritance setInh1 = new HashSetInheritance(true);
        for(int i = 1; i < 7; i++){
            setInh1.add(i);
        }

        HashSetInheritance setInh2 = new HashSetInheritance();
        for(int i = 4; i < 10; i++){
            setInh2.add(i);
        }

        System.out.println("\n---------Inheritance---------");
        System.out.print("set 1 intersect set2: ");
        System.out.println(setInh1.intersection(setInh2));
        System.out.print("set 1 union set2: ");
        System.out.println(setInh1.union(setInh2));
        System.out.print("set 1 intersect set2: ");
        System.out.println(setInh1.difference(setInh2));
        System.out.println();
    }
    
}
