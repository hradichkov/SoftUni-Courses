package P06ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P04Songs {

    static class Song {
        String typeList;
        String name;
        String time;

        Song(String typeList, String name, String time) {
            this.typeList = typeList;
            this.name = name;
            this.time = time;
        }

//        public void setName(String name) {
//            this.name = name;
//        }

        public String getName() {
            return this.name;
        }

//        public void setTypeList(String typeList) {
//            this.typeList = typeList;
//        }

        public String getTypeList() {
            return typeList;
        }

//        public void setTime(String time) {
//            this.time = time;
//        }

        public String getTime() {
            return time;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Song> songsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split("_");

            String type = data[0];
            String name = data[1];
            String time = data[2];

            Song currentSong = new Song(type, name, time);

//            currentSong.setTypeList(type);
//            currentSong.setName(name);
//            currentSong.setTime(time);

            songsList.add(currentSong);

        }

        String command = scanner.nextLine();

        if (command.equals("all")) {
            for (Song item : songsList) {
                System.out.println(item.getName());
            }
        } else {
            for (Song item : songsList) {
                if (command.equals(item.getTypeList())) {
                    System.out.println(item.getName());
                }
            }
        }
    }
}
