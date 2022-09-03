package P06ObjectsAndClassesExercise;

import java.util.Scanner;

public class P02Articles {

    static class Article {
       private String title;
       private String content;
       private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        public void setAuthor(String author) {

            this.author = author;
        }

        public String getAuthor() {
            return author;
        }

        public void setContent(String content) {

            this.content = content;
        }

        public String getContent() {
            return content;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            // ако искаме да вземем обекта под формата на стринг, той ще изглежда така:
            return this.title + " - " + this.content + ": " + this.author;
           // return String.format("%s - %s: %s", this.title, this.content, this.author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];

        Article article = new Article(title, content, author);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(": ");
            String command = data[0];
            String newValue = data[1];

            if (command.equals("Edit")) {
                article.setContent(newValue);
            } else if (command.equals("ChangeAuthor")) {
                article.setAuthor(newValue);
            } else {
                article.setTitle(newValue);
            }
        }
        System.out.println(article);
        //System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());
    }
}
