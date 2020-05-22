import greenfoot.*;
import java.util.Comparator;

public class GameRecordsComparator implements Comparator<Space> 
{
    
    @Override
    public int compare(Space o1, Space o2) {
        return o2.getTime()-o1.getTime();
    }
}
