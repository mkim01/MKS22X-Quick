public class Quick{

  /*Modify the array such that:
 *1. Only the indices from start to end inclusive are considered in range
 *2. A random index from start to end inclusive is chosen, the corresponding
 *   element is designated the pivot element.
 *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
 *4. all elements in range that are larger than the pivot element are placed after the pivot element.
 *@return the index of the final position of the pivot element.
 */

  public static int partition(int[] data, int start, int end){
    int pindex = (int)(Math.random() * (end - start)) + start;
    int pivot = data[pindex];
    data[pindex] = data[start];
    data[start] = pivot;
    pindex = start;
  //  start++;
    // set pivot index to the beginning and loop through the array
    while (start != end){
      if (data[start] > pivot){
        int holder = data[start];
        data[start] = data[end];
        data[end] = holder;
        end --;
      }
      else{
        start++;
      }
    }

    if (data[start] > pivot){
      data[pindex] = data[start - 1];
      data[start = 1] = pivot;
      pindex = start - 1;
    }
    else{
      data[pindex] = data[start];
      data[start] = pivot;
      pindex = start;
    }
    // return pindex;

    //debug

    // String output = "";
    // output += pivot + "|";
    // for(int i = 0; i < data.length; i++){
    //   output += data[i] + " ";
    // }
    return pindex;

  }




  public static int quickselect(int[] data, int k){
    //int pivot = partition(data,0, data.length - 1);
    // int h = partition(data, 0, end);
    // if (h > k) {
    //   end = h - 1;
    // }

    return 0;
  }

  public static void main(String[] args){
    int[] ary = {2,10,15,23,0,5};
    System.out.println(partition(ary,0,5));
  }
}
