import java.util.*;
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
    //if (start == end){ return start;}
    // int pindex = (int)(Math.random() * (end - start)) + start;
    Random random = new Random();
    //improvement part b
    int pindex = 0;
    int pivot = 0;
    int lo = start;
    int hi = end;
    int mid = (start + end) / 2;
    if ((data[hi] > data[lo] && data[lo] > data[mid]) || (data[mid] > data[lo] && data[lo] > data[hi])){
      pindex = lo;
      pivot = data[pindex];
    }
    else if ((data[lo] > data[hi] && data[hi] > data[mid]) || (data[mid] > data[hi] && data[hi] > data[lo])){
      pindex = hi;
      pivot = data[pindex];
    }
    else{
      pindex = mid;
      pivot = data[pindex];
    }
    // move it to the first index;
    if (pindex != start){
      data[pindex] = data[start];
      data[start] = pivot;
      pindex = start;
    }

      lo = start + 1;

    while (lo != hi && lo < hi && lo > 0) {
      if (data[lo] > pivot){
        int n = data[lo];
        data[lo] = data[hi];
        data[hi] = n;
        hi --;
      }
      else if (data[lo] == pivot){
        if ((int)(Math.random() * 2) % 2 == 0){
          int n = data[lo];
          data[lo] = data[hi];
          data[hi] = n;
          hi --;
        }
        else{
          lo++;
        }
      }
      else {
        lo ++;
      }
    }

    if (data[lo] > pivot) {
      data[pindex] = data[lo - 1];
      data[lo - 1] = pivot;
      return lo - 1;
    }
    if (data[lo] <= pivot){
      data[pindex] = data[lo];
      data[lo] = pivot;
      return lo;
    }
    // String output = "";
    // output += pivot + "|";
    // for(int i = 0; i < data.length; i++){
    //   output += data[i] + " ";
    // }
    // return output;
  return 0;
}

  private static int[] partitionDutch(int[] data, int lo, int hi){
    //choosing the pivot;
    int mid = (lo + hi) / 2;
    int pindex = 0;
    int pivot = 0 ;
    if ((data[hi] > data[lo] && data[lo] > data[mid]) || (data[mid] > data[lo] && data[lo] > data[hi])){
      pindex = lo;
      pivot = data[pindex];
    }
    else if ((data[lo] > data[hi] && data[hi] > data[mid]) || (data[mid] > data[hi] && data[hi] > data[lo])){
      pindex = hi;
      pivot = data[pindex];
    }
    else{
      pindex = mid;
      pivot = data[pindex];
    }
    //System.out.println(Arrays.toString(data));
    // swapping the pindex value with the lowest value;
    int holder = pivot;
    pivot = data[lo];
    data[lo] = holder;
    //System.out.println(Arrays.toString(data));
    //
    int lt = lo;
    int gt = hi;
    int i = lt + 1;

    while (i != gt + 1){
      if (data[lt] > data[i]){
        int dholder = data[lt];
        data[lt] = data[i];
        data[i] = dholder;
        i++;
        lt++;
      }
      else if (data[lt] < data[i]){
        // swap with the highest value and decrease gt by 1;
        int dholder = data[i];
        data[i] = data[gt];
        data[gt] = dholder;
        gt --;
      }
      else{
        //if data[lt] == data[i] then just move onto next i;
        i++;
      }
      System.out.println(Arrays.toString(data));
    }
    int[] ary = {lt, gt};
    // System.out.println(Arrays.toString(data));
    // String output = lt + " " + gt;
    // return output;
    return ary;
  }


  public static int quickselect(int[] data, int k){
    int lo = 0;
    int hi = data.length - 1;
    int pindex = 0;
    // for (int i = 0 ; i <data.length; i++){
    while (pindex != k){
      pindex = partition(data,lo,hi);
      if (pindex < k){
        lo = pindex + 1;
      }
      else {
        hi = pindex -1;
      }
    }
    return data[pindex];
  }

  public static void quicksort(int[] data){
    quickH(data, 0, data.length - 1);
  }

  public static void quickH(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
      int pindex = partition(data,lo,hi);
      quickH(data, lo, pindex - 1);
      quickH(data, pindex + 1, hi);
    }

  // public static void



  public static void main(String[]args){

    int[] test = {2,1,2,1,2,1,2,1,2,1,3,1,4,1,2,7,1};
    System.out.println(partitionDutch(test,0,test.length-1));
    // System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    // int[]MAX_LIST = {1000000000,500,10};
    // for(int MAX : MAX_LIST){
    //   for(int size = 31250; size < 2000001; size*=2){
    //     long qtime=0;
    //     long btime=0;
    //     //average of 5 sorts.
    //     for(int trial = 0 ; trial <=5; trial++){
    //       int []data1 = new int[size];
    //       int []data2 = new int[size];
    //       for(int i = 0; i < data1.length; i++){
    //         data1[i] = (int)(Math.random()*MAX);
    //         data2[i] = data1[i];
    //       }
    //       long t1,t2;
    //       t1 = System.currentTimeMillis();
    //       Quick.quicksort(data2);
    //       t2 = System.currentTimeMillis();
    //       qtime += t2 - t1;
    //       t1 = System.currentTimeMillis();
    //       Arrays.sort(data1);
    //       t2 = System.currentTimeMillis();
    //       btime+= t2 - t1;
    //       if(!Arrays.equals(data1,data2)){
    //         System.out.println("FAIL TO SORT!");
    //         System.exit(0);
    //       }
    //     }
    //     System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    //   }
    //   System.out.println();
    //   }



    }
}
