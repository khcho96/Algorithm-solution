import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Map<File, String> map = new HashMap<>();
        List<File> list = new ArrayList<>();
        for (String file : files) {
            int index1 = 0;
            int index2 = file.length();
            for (int i = 0; i < file.length(); i++) {
                if (index1 == 0 && String.valueOf(file.charAt(i)).matches("\\d")) {
                    index1 = i;
                }
                if (index1 != 0 && String.valueOf(file.charAt(i)).matches("\\D")) {
                    index2 = i;
                    break;
                }
            }
            String head = file.substring(0, index1).toLowerCase();
            int number = Integer.parseInt(file.substring(index1, index2));
            File newFile = new File(head, number, list.size());
            list.add(newFile);
            map.put(newFile, file);
        }

        list.sort(Comparator.comparing(File::getHead)
                .thenComparingInt(File::getNumber)
                .thenComparingInt(File::getIndex));
        
        return list.stream()
                .map(map::get)
                .toArray(String[]::new);
    }
    
    public static class File {
        String head;
        int number;
        int index;

        public File(String head, int number, int index) {
            this.head = head;
            this.number = number;
            this.index = index;
        }

        public String getHead() {
            return head;
        }

        public int getNumber() {
            return number;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) {
                return false;
            }
            File file = (File) object;
            return number == file.number && index == file.index && Objects.equals(head, file.head);
        }

        @Override
        public int hashCode() {
            return Objects.hash(head, number, index);
        }
    }
}