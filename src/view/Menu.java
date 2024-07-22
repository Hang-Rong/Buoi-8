package view;

import manager.Manager;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    Manager Manager = new Manager();

    Scanner inputInt = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("===== Menu Sản Phẩm  =====");
            System.out.println("1. Thêm mới sản phẩm");
            System.out.println("2. Sửa thông tin sản phẩm");
            System.out.println("3. Xóa sản phẩm");
            System.out.println("4. Hiển thị tất cả sản phẩm");
            System.out.println("0. Thoát trình quản lý");
            System.out.print("Nhập lựa chọn: ");

            choice = inputInt.nextInt();
            switch (choice) {
                case 1:
                    showMenuAdd();
                    break;
                case 2:
                    showMenuEdit();
                    break;
                case 3:
                    showMenuRemove();
                    break;
                case 4:
                    showAll();
                    break;
            }
        } while (choice != 0);
    }

    public void showMenuAdd() {
        System.out.println("===== Đây là menu thêm mới =====");
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = inputString.nextInt();
        inputString.nextLine();
        System.out.print("Nhập loại sản phẩm: ");
        String catelory = inputString.nextLine();
        Product product = new Product(name, price, catelory);
        Manager.add(product);
        System.out.println("===== Thêm thành công =====");
    }

    public void showAll() {
        System.out.println("Danh sách sản phẩm là: ");
        ArrayList<Product> listProducts = Manager.getAll();
        for (Product product : listProducts) {
            System.out.println(product);
        }
    }

    public void showMenuRemove() {
        System.out.println("===== Xóa sản phẩm ===== ");
        System.out.print("Nhập mã sản phẩm: ");
        int idDelete = inputInt.nextInt();
        Manager.delete(idDelete);
        System.out.println("===== Xóa thành công =====");
    }

    public void showMenuEdit() {
        System.out.println("===== Sửa thông tin sản phẩm =====");
        System.out.print("Nhập mã sản phẩm muốn sửa: ");
        int idEdit = inputInt.nextInt();
        inputInt.nextLine(); // Consume newline
        System.out.print("Nhập tên sản phẩm: ");
        String name = inputString.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        int price = inputInt.nextInt();
        inputInt.nextLine(); // Consume newline
        System.out.print("Nhập danh mục sản phẩm: ");
        String category = inputString.nextLine();
        Product newProduct = new Product(idEdit, name, price, category);
        Manager.update(idEdit, newProduct);
        System.out.println("===== Sửa thành công =====");
    }
}
