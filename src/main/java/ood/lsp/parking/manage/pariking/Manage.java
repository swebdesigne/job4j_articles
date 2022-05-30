package ood.lsp.parking.manage.pariking;

public class Manage {
    IManage iManage;

    public Manage(IManage iManage) {
        this.iManage = iManage;
    }

    public void execute() {
        iManage.msg();
    }
}
