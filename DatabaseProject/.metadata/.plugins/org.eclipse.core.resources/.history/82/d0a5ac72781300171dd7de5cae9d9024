package memberUI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.table.DefaultTableCellRenderer;

public class TimestampCellRenderer extends DefaultTableCellRenderer {

    DateFormat formatter = new SimpleDateFormat("HH:mm:ss");

    public TimestampCellRenderer() {
        super();
    }

    public void setValue(Object value) {
        if (formatter == null) {
            formatter = DateFormat.getDateInstance();
        }
        setText((value == null) ? "" : formatter.format(value));
    }
}