package softuni.exam.util;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {
    //    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ISO_LOCAL_TIME;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Override
    public LocalDate unmarshal(String date) throws Exception {
        return LocalDate.parse(date, timeFormatter);
    }

    @Override
    public String marshal(LocalDate time) throws Exception {
        return time.format(timeFormatter);
    }
}
