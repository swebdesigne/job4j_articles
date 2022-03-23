package tdd;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public interface Cinema {
    List<Session> find(Predicate<Session> filter);
    Ticket buy(Account account, int row, int column, Calendar data);
    void add(Session session);
}
