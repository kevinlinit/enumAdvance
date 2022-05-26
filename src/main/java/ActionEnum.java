import lombok.AllArgsConstructor;
import lombok.Getter;

import java.text.MessageFormat;
import java.util.Objects;
import java.util.function.Function;

import static java.util.Arrays.stream;

@AllArgsConstructor
@Getter
public enum ActionEnum {

    MARK_ID_CARD(DeSensionEnum.ID_CARD, ActionToTake.MARK, s -> MessageFormat.format("{0}{1}是身份证号", DeSensionEnum.ID_CARD.getMsg(s), ActionToTake.MARK.getDesc())),

    CHANGE_ID_CARD(DeSensionEnum.ID_CARD, ActionToTake.CHANGE, s -> MessageFormat.format("{0}{1}身份证号", DeSensionEnum.ID_CARD.getMsg(s), ActionToTake.CHANGE.getDesc())),

    MARK_NAME(DeSensionEnum.CHINESE_NAME, ActionToTake.MARK, s -> MessageFormat.format("{0}{1}是名字", DeSensionEnum.CHINESE_NAME.getMsg(s), ActionToTake.MARK.getDesc())),

    CHANGE_NAME(DeSensionEnum.CHINESE_NAME, ActionToTake.CHANGE, s -> MessageFormat.format("{0}{1}的名字", DeSensionEnum.CHINESE_NAME.getMsg(s), ActionToTake.CHANGE.getDesc()));

    private DeSensionEnum deSensionEnum;

    private ActionToTake action;

    private Function<String, String> doAction;

    @AllArgsConstructor
    @Getter
    public enum ActionToTake {
        MARK("MARK", "这个"),
        CHANGE("CHANGE", "换了");
        private String name;
        private String desc;
    }

    public static ActionEnum getActionEnum(DeSensionEnum deSensionEnum, ActionToTake action) {
        return stream(ActionEnum.values()).filter(actionEnum -> (actionEnum.getDeSensionEnum() == deSensionEnum) &&
                Objects.equals(action, actionEnum.getAction())).findFirst().get();
    }

    public static String getMarkMsgWithDeEnum(String s, DeSensionEnum deSensionEnum, ActionToTake action) {
        String sex = deSensionEnum.getMsg(s);
        ActionEnum actionEnum = getActionEnum(deSensionEnum, action);
        String actionMsg = actionEnum.doAction.apply(sex);
        return actionMsg;
    }
}
