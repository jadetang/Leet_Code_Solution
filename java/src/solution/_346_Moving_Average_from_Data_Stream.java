package solution;

public class _346_Moving_Average_from_Data_Stream {

  int size;
  int sum;
  int[] buffer;
  int offset;
  int currentSize;

  /**
   * Initialize your data structure here.
   */
  public _346_Moving_Average_from_Data_Stream(int size) {
    this.buffer = new int[size];
    this.size = size;
    this.sum = 0;
    this.currentSize = 0;
  }

  public double next(int val) {
    if (currentSize == size) {
      int remove = buffer[offset];
      sum -= remove;
    } else {
      currentSize++;
    }
    buffer[offset] = val;
    sum += val;
    offset = (offset + 1) % size;
    return (double) sum / currentSize;
  }

}
