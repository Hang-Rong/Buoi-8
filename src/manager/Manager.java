package manager;

import model.Product;

import java.util.ArrayList;

public class Manager implements iManager<Product> {
    ArrayList<Product> list;

    public Manager(){
        this.list = new ArrayList<>();
    }
    @Override
    public void add(Product product) {
        list.add(product);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public int findIndexById(int id) {
        return 0;
    }

    @Override
    public void update(int id, Product product) {

    }

    @Override
    public ArrayList<Product> getAll() {
        return list;
    }
}