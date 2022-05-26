import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public enum DeSensionEnum {

    CHINESE_NAME("CHINESE_NAME", s -> s.substring(0, 1) + "**"),
    ID_CARD("ID_CARD", s -> s.substring(0, s.length() - 4) + "****"),
    ;

    private String name;

    private Function<String, String> deSension;

    public String getName() {
        return name;
    }

    public String getMsg(String id) {
        return deSension.apply(id);
    }
}
