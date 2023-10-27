package zhangqs.array.test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class test {
    private final Logger logger = LoggerFactory.getLogger(test.class);

    @Test
    public void test_array_list() {
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
    }
}