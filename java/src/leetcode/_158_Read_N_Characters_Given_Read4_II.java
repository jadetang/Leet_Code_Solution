package leetcode;

public class _158_Read_N_Characters_Given_Read4_II {


  char[] buffer = new char[4];

  int lastRead = 0;

  int bufferLength = 0;

  public int read(char[] buf, int n) {
    int read = 0;
    while (read < n) {
       if ( lastRead < bufferLength) {
         int shouldRead = Math.min(bufferLength - lastRead, n - read);
         for (int i = 0; i < shouldRead; i++) {
           buf[read++] = buffer[lastRead++];
         }
       }else {
         bufferLength = read4(buffer);
         if (bufferLength == 0){
           break;
         }
         lastRead = 0;
       }
    }
    return read;
  }

  int read4(char[] buf) {
    return -1;
  }

}
