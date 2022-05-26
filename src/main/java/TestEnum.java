public class TestEnum {
    public static void main(String[] args) {
        String name = "ID_CARD";
        String id = "123231231231X";
        DeSensionEnum deSensionEnum = DeSensionEnum.valueOf(name);

        String markMsg = ActionEnum.getMarkMsgWithDeEnum(id, deSensionEnum, ActionEnum.ActionToTake.MARK);
        String changeMsg = ActionEnum.getMarkMsgWithDeEnum(id, deSensionEnum, ActionEnum.ActionToTake.CHANGE);
        System.out.println(markMsg);
        System.out.println(changeMsg);

        String chnName = "CHINESE_NAME";
        String chinese = "周杰伦";
        DeSensionEnum chnEnum = DeSensionEnum.valueOf(chnName);

        String chnMarkMsg = ActionEnum.getMarkMsgWithDeEnum(chinese, chnEnum, ActionEnum.ActionToTake.MARK);
        String chnChangeMsg = ActionEnum.getMarkMsgWithDeEnum(chinese, chnEnum, ActionEnum.ActionToTake.CHANGE);
        System.out.println(chnMarkMsg);
        System.out.println(chnChangeMsg);
    }
}
