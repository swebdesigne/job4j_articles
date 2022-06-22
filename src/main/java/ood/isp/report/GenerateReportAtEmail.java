package ood.isp.report;

public class GenerateReportAtEmail implements IReport {
    @Override
    public void email() {
        System.out.println("Report has been send at email");
    }

    @Override
    public void html() {
        throw new  UnsupportedOperationException("I not support this method");
    }

    @Override
    public void xml() {
        throw new  UnsupportedOperationException("I not support this method");
    }
}
