package leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.Test;

public class _588_Design_In_Memory_File_System {

    @Test
    public void test() {
        FileSystem fileSystem = new FileSystem();
        fileSystem.mkdir("/goowmfn");
        fileSystem.mkdir("/");
        fileSystem.addContentToFile("/goowmfn/c", "shetopcy");
        System.out.println(fileSystem.ls("/goowmfn/c"));
    }

    public static class FileSystem {
        public static class Node {

            public String name;

            public Map<String, Node> children;

            public boolean isDir;

            public String content;

            public Node(String name, Boolean isDir) {
                this.name = name;
                this.children = new HashMap<>();
                this.isDir = isDir;
                this.content = "";
            }

            public Node getChild(String key) {
                return children.get(key);
            }

            public List<String> getAllChildrenName() {
                return children.values().stream().map(n -> n.name).collect(Collectors.toList());
            }

            public void addChild(String name, Node node) {
                children.put(name, node);
            }

            public void addContent(String content) {
                this.content = this.content + content;
            }
        }


        Node root;

        public FileSystem() {
            root = new Node("/", true);
        }

        public List<String> ls(String path) {
            if (path.equals("/")) {
                return root.getAllChildrenName().stream().sorted().collect(Collectors.toList());
            }
            String[] paths = path.substring(1).split("/");
            Node currentNode = root;
            StringBuilder pathBuilder = new StringBuilder();
            for (int i = 0; i < paths.length; i++) {
                String currentPath = paths[i];
                currentNode = currentNode.getChild(currentPath);
                if (i != 0) {
                    pathBuilder.append("/");
                }
                pathBuilder.append(currentPath);
            }
            if (currentNode.isDir) {
                return currentNode.getAllChildrenName().stream()
                        .sorted()
                        .collect(
                                Collectors.toList());
            }else {
                return Collections.singletonList(currentNode.name);
            }
        }

        public void mkdir(String path) {
            String[] paths = path.substring(1).split("/");
            Node currentNode = root;
            for (int i = 0; i < paths.length; i++) {
                if (!currentNode.isDir) {
                    throw new RuntimeException("It is a file.");
                }
                String currentPath = paths[i];
                if (currentNode.getChild(currentPath) == null) {
                    currentNode.addChild(currentPath, new Node(currentPath, true));
                }
                currentNode = currentNode.getChild(currentPath);
            }
        }

        public void addContentToFile(String filePath, String content) {
            String[] paths = filePath.substring(1).split("/");
            Node currentNode = root;
            for (int i = 0; i < paths.length; i++) {
                String currentPath = paths[i];
                if (currentNode.getChild(currentPath) == null) {
                    if (i == paths.length - 1) {
                        currentNode.addChild(currentPath, new Node(currentPath, false));
                    }else {
                        currentNode.addChild(currentPath, new Node(currentPath, true));
                    }
                }
                currentNode = currentNode.getChild(currentPath);
            }
            currentNode.addContent(content);
        }

        public String readContentFromFile(String filePath) {
            String[] paths = filePath.substring(1).split("/");
            Node currentNode = root;
            for (int i = 0; i < paths.length; i++) {
                String currentPath = paths[i];
                currentNode = currentNode.getChild(currentPath);
            }
            return currentNode.content;
        }
    }

}
