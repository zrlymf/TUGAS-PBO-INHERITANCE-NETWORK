import java.util.ArrayList;

public class Network {
    private ArrayList<User> users;
    private ArrayList<Post> posts;

    public Network() {
        users = new ArrayList<>();
        posts = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getUsername());
    }

    public void removeUser(User user) {
        if (users.remove(user)) {
            System.out.println("User removed: " + user.getUsername());
        } else {
            System.out.println("User not found in the network.");
        }
    }

    public void addPost(Post post) {
        posts.add(post);
        System.out.println("Post added by: " + post.getAuthor().getUsername()); // Menggunakan getter
    }

    public void displayAllUsers() {
        System.out.println("All users in the network:");
        for (User user : users) {
            user.viewProfile();
        }
    }

    public void displayAllPosts() {
        System.out.println("All posts in the network:");
        for (int i = 0; i < posts.size(); i++) {
            System.out.println("Post #" + (i + 1));
            posts.get(i).displayPost();
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }
}
