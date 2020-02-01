package pzf.entity;

public class Salesman {
    int id;
    String salesmanName;
    String salesmanPassword;

    public Salesman() {
    }

    public Salesman(int id, String salesmanName, String salesmanPassword) {
        this.id = id;
        this.salesmanName = salesmanName;
        this.salesmanPassword = salesmanPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalesmanName() {
        return salesmanName;
    }

    public void setSalesmanName(String salesmanName) {
        this.salesmanName = salesmanName;
    }

    public String getSalesmanPassword() {
        return salesmanPassword;
    }

    public void setSalesmanPassword(String salesmanPassword) {
        this.salesmanPassword = salesmanPassword;
    }
}
