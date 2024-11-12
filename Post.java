import java.time.LocalDateTime;

public class Post {
    private String content;
    private LocalDateTime timestamp;
    private User author;
    private int likes;

    public Post(String content, User author) {
        this.content = content;
        this.author = author;
        this.timestamp = LocalDateTime.now();  
        this.likes = 0;
    }

    public void addLike() {
        likes++;
        System.out.println("Post liked! Total likes: " + likes);
    }

    public void removeLike() {
        if (likes > 0) {
            likes--;
            System.out.println("Post unliked. Total likes: " + likes);
        } else {
            System.out.println("No likes to remove.");
        }
    }

    public void displayPost() {
        System.out.println("Author: " + author.getUsername());
        System.out.println("Content: " + content);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Likes: " + likes);
    }

    public User getAuthor() {
        return author;
    }
}
