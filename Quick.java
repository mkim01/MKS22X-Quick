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
    int pindex = (int)(Math.random() * (end - start)) + start;
    Random random = new Random();
    int pivot = data[pindex];
    data[pindex] = data[start];
    data[start] = pivot;
    pindex = start;
    //start++;
    // set pivot index to the beginning and loop through the array
    while (start != end){
      if (data[start] > pivot){
        int holder = data[start];
        data[start] = data[end];
        data[end] = holder;
        end --;
      }
      else if (data[start] == pivot){
        int nextInt = random.nextInt(2);
        if (nextInt == 0){
          int holder = data[start];
          data[start] = data[end];
          data[end] = holder;
          end --;
        }
      }
      else{
        start++;
      }
    }
    //inserting pivot into original position
    if (data[start] > pivot){
      data[pindex] = data[start - 1];
      data[start - 1] = pivot;
      pindex = start - 1;
    }
    else{
      data[pindex] = data[start];
      data[start] = pivot;
      pindex = start;
    }


    //debug
    // String output = "";
    // output += pivot + "|";
    // for(int i = 0; i < data.length; i++){
    //   output += data[i] + " ";
    // }
    return pindex;
  }


  public static int quickselect(int[] data, int k){
    return 0;
  }

  public static void quicksort(int[] data){

    return ;
  }


  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
      }
    }
  }
