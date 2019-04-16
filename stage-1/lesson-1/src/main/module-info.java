module lesson1 {
    requires java.base; // 默认依赖 java.base
    requires java.sql;  // 依赖 SQL（JDBC）
//    requires java.logging;
    exports pers.qly.deep.in.java.stage1.lesson1;
    exports pers.qly.deep.in.java.stage1;
}