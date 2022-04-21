package ood.designe.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.function.Predicate;

public class ReportToXML implements Report<String> {
    private Store store;

    public ReportToXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String xml = "";
        Employees employees = new Employees();
        employees.setEmployees(store.findBy(filter));
        try {
            JAXBContext context = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            StringWriter writer = new StringWriter();
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
