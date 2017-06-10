package solution;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sanguan.tangsicheng on 2017/6/5 下午11:05
 */
public class _609_Find_Duplicate_File_in_System {

    public static void main(String[] args) {
        _609_Find_Duplicate_File_in_System q = new _609_Find_Duplicate_File_in_System();
        String[] paths = new String []{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(q.findDuplicate(paths));
    }


    public List<List<String>> findDuplicate(String[] paths) {
        List<File> files = new LinkedList<>();
        for( int i = 0 ; i < paths.length ; i++){
            String str = paths[i];
            String[] strs = str.split(" ");
            for( int j = 1 ; j < strs.length ; j++){
                files.add(new File(strs[0],strs[j]));
            }
        }
        Map<String,List<File>> group = files.stream().collect(Collectors.groupingByConcurrent(file->file.content));
        List<List<File>> duplicateFiles = group.values().stream().filter(list->list.size()>1).collect(Collectors.toList());
        return duplicateFiles.stream().map(files1 -> files1.stream().map(
            file -> file.directory+"/"+file.fileName).collect(Collectors.toList())).collect(Collectors.toList());



    }


    public static class File{

        String directory;

        String fileName;

        String content;

        public File(String directory, String fileAndContent){
            this.directory = directory;
            parse(fileAndContent);
        }

        private void parse(String fileAndContent){
            int index = fileAndContent.indexOf("(");
            this.fileName = fileAndContent.substring(0,index);
            this.content = fileAndContent.substring(index+1,fileAndContent.length() - 1);
        }
    }
}
