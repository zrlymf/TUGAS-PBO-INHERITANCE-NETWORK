import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Network network = new Network();
        
        boolean running = true;
        while (running) {
            System.out.println("\nSelamat datang di aplikasi jejaring sosial!");
            System.out.println("1. Tambah User");
            System.out.println("2. Tambah Postingan");
            System.out.println("3. Tampilkan Semua Pengguna");
            System.out.println("4. Tampilkan Semua Postingan");
            System.out.println("5. Update Status Pengguna");
            System.out.println("6. Tambah Like ke Postingan");
            System.out.println("7. Hapus Like dari Postingan");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Mengonsumsi newline setelah input angka

            switch (choice) {
                case 1:
                    // Tambah User
                    System.out.print("Masukkan username: ");
                    String username = scanner.nextLine();
                    System.out.print("Masukkan nama: ");
                    String name = scanner.nextLine();
                    User user = new User(username, name);
                    network.addUser(user);
                    break;

                case 2:
                    // Tambah Postingan
                    System.out.print("Masukkan username pembuat postingan: ");
                    String authorUsername = scanner.nextLine();
                    User author = findUserByUsername(network, authorUsername);
                    if (author != null) {
                        System.out.print("Masukkan konten postingan: ");
                        String content = scanner.nextLine();
                        Post post = new Post(content, author);
                        network.addPost(post);
                    } else {
                        System.out.println("Pengguna tidak ditemukan.");
                    }
                    break;

                case 3:
                    // Tampilkan Semua Pengguna
                    network.displayAllUsers();
                    break;

                case 4:
                    // Tampilkan Semua Postingan
                    network.displayAllPosts();
                    break;

                case 5:
                    // Update Status Pengguna
                    System.out.print("Masukkan username untuk memperbarui status: ");
                    String statusUsername = scanner.nextLine();
                    User userToUpdate = findUserByUsername(network, statusUsername);
                    if (userToUpdate != null) {
                        System.out.print("Masukkan status baru: ");
                        String newStatus = scanner.nextLine();
                        userToUpdate.updateStatus(newStatus);
                    } else {
                        System.out.println("Pengguna tidak ditemukan.");
                    }
                    break;

                case 6:
                    // Tambah Like ke Postingan
                    System.out.print("Masukkan nomor indeks postingan yang ingin di-like: ");
                    int likeIndex = scanner.nextInt() - 1; // User-friendly index (1-based)
                    if (likeIndex >= 0 && likeIndex < network.getPosts().size()) {
                        network.getPosts().get(likeIndex).addLike();
                    } else {
                        System.out.println("Postingan tidak ditemukan.");
                    }
                    break;

                case 7:
                    // Hapus Like dari Postingan
                    System.out.print("Masukkan nomor indeks postingan yang ingin di-unlike: ");
                    int unlikeIndex = scanner.nextInt() - 1; // User-friendly index (1-based)
                    if (unlikeIndex >= 0 && unlikeIndex < network.getPosts().size()) {
                        network.getPosts().get(unlikeIndex).removeLike();
                    } else {
                        System.out.println("Postingan tidak ditemukan.");
                    }
                    break;

                case 8:
                    // Keluar
                    running = false;
                    System.out.println("Terima kasih telah menggunakan aplikasi!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }
        scanner.close();
    }

    // Fungsi untuk mencari pengguna berdasarkan username
    public static User findUserByUsername(Network network, String username) {
        for (User user : network.getUsers()) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}
