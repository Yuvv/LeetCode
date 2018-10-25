class MyHashSet {

    private HashSet<Integer> set;

     /** Initialize your data structure here. */
     public MyHashSet() {
         set = new HashSet<>();
     }

     public void add(int key) {
         set.add(key);
     }

     public void remove(int key) {
         set.remove(key);
     }

     /** Returns true if this set contains the specified element */
     public boolean contains(int key) {
         return set.contains(key);
     }
 }

 /**
  * Your MyHashSet object will be instantiated and called as such:
  * MyHashSet obj = new MyHashSet();
  * obj.add(key);
  * obj.remove(key);
  * boolean param_3 = obj.contains(key);
  */