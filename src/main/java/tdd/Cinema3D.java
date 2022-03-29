package tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {

    @Override
    public List<Session> find(Predicate<Session> filter) {
        return null;
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar data) {
        return null;
    }

    @Override
    public void add(Session session) {

    }

    @Override
    public Ticket validPlace(int row, int column) {
        return null;
    }

    @Override
    public Ticket validPlace(int row, int column, Calendar data) {
        return null;
    }

    @Override
    public Ticket validDate(Calendar data) {
        return null;
    }
}
