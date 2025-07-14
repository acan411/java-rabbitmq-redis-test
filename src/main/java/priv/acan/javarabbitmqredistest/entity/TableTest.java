package priv.acan.javarabbitmqredistest.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author acan
 * @since 2025-07-11
 */
@Data
@TableName("table_test")
public class TableTest implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String col1;

    private Integer col2;

    @Override
    public String toString() {
        return "TableTest{" +
                "col1=" + col1 +
                ", col2=" + col2 +
                "}";
    }
}
